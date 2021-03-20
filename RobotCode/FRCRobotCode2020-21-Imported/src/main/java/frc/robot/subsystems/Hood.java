// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Constants;


/*
Hood angle is measured from the front of the hood to a horizontal plane. The lowest angle it can be is when the back
of the hood hits the limit switch.
*/

public class Hood extends SubsystemBase {

  private boolean isCalibrated = false;
  public boolean isCalibrated(){  return isCalibrated;  }
 
  private double targetHoodAngle = -1; 

  private TalonSRX hoodMotor = new TalonSRX(Constants.HOOD_MOTOR);

  private DigitalInput limitSwitch = new DigitalInput(0);

  /** Creates a new Hood. */
  public Hood() {

    hoodMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    hoodMotor.setSensorPhase(true);

    hoodMotor.config_kP(0, Constants.FLYWHEEL_KP);
    hoodMotor.config_kI(0, Constants.FLYWHEEL_KI); 
    hoodMotor.config_kD(0, Constants.FLYWHEEL_KD); 
    hoodMotor.config_kF(0, Constants.FLYWHEEL_KF);

  }

  //TODO: set limits to hood
  public void increaseHoodAngle() {
    if(getHoodAngle()<Constants.MAX_HOOD_ANGLE)
      hoodMotor.set(ControlMode.PercentOutput, .4);
  }
  public void decreaseHoodAngle() {
    if (!limitSwitch.get())
      hoodMotor.set(ControlMode.PercentOutput, -.4);
  }
  public void stopHood() {
    hoodMotor.neutralOutput();
  }

  public void setHoodToAngle(double angle) {
    targetHoodAngle = angle;
    if (angle<Constants.MIN_HOOD_ANGLE) angle = Constants.MIN_HOOD_ANGLE;
    if (angle>Constants.MAX_HOOD_ANGLE) angle = Constants.MAX_HOOD_ANGLE;
    hoodMotor.set(ControlMode.Position, targetHoodAngle*Constants.MAG_TICKS_PER_HOOD_DEGREE);
  }
  public void changeTargetHoodAngle(double angle) {
    setHoodToAngle(targetHoodAngle+angle);
  }
  public double getHoodAngle() {
    return hoodMotor.getSelectedSensorPosition()/Constants.MAG_TICKS_PER_HOOD_DEGREE;
  }
  public double getTargetHoodAngle() {
    return targetHoodAngle;
  }

  //this command runs a calibration sequence that sets th
  public Command calibrate() {
    return new SequentialCommandGroup(
      new InstantCommand(()->hoodMotor.set(ControlMode.PercentOutput, -.5)), //run the motor backwards
      new WaitUntilCommand(()->limitSwitch.get()), //wait until limit switch is hit
      new InstantCommand(()->{ //set hood angle to the minimum position
        hoodMotor.neutralOutput();
        hoodMotor.setSelectedSensorPosition(Constants.MIN_HOOD_ANGLE*Constants.MAG_TICKS_PER_HOOD_DEGREE);
        targetHoodAngle = Constants.MIN_HOOD_ANGLE;
        isCalibrated = true;
      })
    );
  }


  @Override
  public void periodic() {
    //limits the hood angle so you can't move it too far up or down
    if(limitSwitch.get() || getHoodAngle()>Constants.MAX_HOOD_ANGLE) hoodMotor.neutralOutput();
  }
}
