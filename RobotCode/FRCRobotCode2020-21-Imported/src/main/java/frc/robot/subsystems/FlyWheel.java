// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.simulation.XboxControllerSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {


  //instances of all four motors that spin the flywheel
  private final TalonSRX leftLowMotor = new TalonSRX(Constants.LEFT_LOW_FLYWHEEL_MOTOR_ID);
  private final VictorSPX rightLowMotor = new VictorSPX(Constants.RIGHT_LOW_FLYWHEEL_MOTOR_ID); //this motor is the master
  private final VictorSPX leftHighMotor = new VictorSPX(Constants.LEFT_HIGH_FLYWHEEL_MOTOR_ID);
  private final TalonSRX rightHighMotor = new TalonSRX(Constants.RIGHT_HIGH_FLYWHEEL_MOTOR_ID);

  //To run all motors in sync with each other, we have 3 of the motors follow the controlMotor
  //The control motor should be the same one that's connected to the MagEncoder
  //only the controlMotor should be used to set constants and run in the rest of the program
  private final TalonSRX controlMotor = rightHighMotor;


  /** Creates a new FlyWheel. */
  public FlyWheel() {

    //sets all the motors to follow just the one motor
    leftLowMotor.follow(controlMotor);
    leftHighMotor.follow(controlMotor);
    rightLowMotor.follow(controlMotor);

    //this makes sure all the motors are spinning in the same direction
    leftLowMotor.setInverted(false);
    leftHighMotor.setInverted(false);
    rightLowMotor.setInverted(true);
    rightHighMotor.setInverted(true);

    //sets all motors to coast when we're done using the flywheel, so we don't break the gear box
    //the default setting is NeutralMode.Brake
    leftLowMotor.setNeutralMode(NeutralMode.Coast);
    leftHighMotor.setNeutralMode(NeutralMode.Coast);
    rightLowMotor.setNeutralMode(NeutralMode.Coast);
    rightHighMotor.setNeutralMode(NeutralMode.Coast);


    //setup magEncoder
    controlMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    //set sensor phase. This makes sure the encoder measures spin in the same direction the motor
    controlMotor.setSensorPhase(false);

    //set PID constants. - 
    controlMotor.config_kP(0, Constants.FLYWHEEL_KP);
    controlMotor.config_kI(0, Constants.FLYWHEEL_KI); 
    controlMotor.config_kD(0, Constants.FLYWHEEL_KD); 
    controlMotor.config_kF(0, Constants.FLYWHEEL_KF);

  }

  //This method runs the flywheel without a PID control loop
  public void setRawFlyWheelPower(double percent){
    controlMotor.set(ControlMode.PercentOutput, percent);
  }

  //this method runs the flywheel with a PID control loop
  public void setControlledVelocity(double WheelRPM){
    controlMotor.set(ControlMode.Velocity, WheelRPM*Constants.TICKSPER100MS_PER_RPM);
  }

  //stops the flywheel from running. The motors should coast to a stop.
  public void stop(){
    controlMotor.neutralOutput();
  }
  
  
  public void flywheelUpToSpeedteleop(boolean y_input, boolean x_input, boolean a_input, boolean b_input)
  {
    boolean isFlywheelOn = true;
    double threshold = 0; // Change this based on what is the minimum value in rpm for the flywheel is.
    
    // if (Constants.TICKSPER100MS_PER_RPM > threshold)
    // {
    //   isFlywheelOn = true;
    // }
    // else
    // {
    //   isFlywheelOn = false;
    // }


    // each button on the right pad corresponds to a zone.

    double green_zone_velocity = 2000;
    if ((x_input == true) && (isFlywheelOn == true)){
      setControlledVelocity(green_zone_velocity);
    }


    double yellow_zone_velocity = 20;
    if ((a_input == true) && (isFlywheelOn == true)){
      setControlledVelocity(yellow_zone_velocity);
    }
    
    
    double blue_zone_velocity = 20;
    if ((b_input == true) && (isFlywheelOn == true)){
      setControlledVelocity(blue_zone_velocity);
    }


    double red_zone_velocity = 20;
    if ((y_input == true) && (isFlywheelOn == true)){
      setControlledVelocity(red_zone_velocity);
    }

    
  }
  
  //TODO - Find distance from the target and then set the flywheel velovity to that.
  // Can be triggered by left bumper
  public void distanceshot(){
    

  }

}
