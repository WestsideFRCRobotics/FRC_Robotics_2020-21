/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
This subsystem interfaces with the motor controlers that run the drive train on the robot.
*/

public class DriveTrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // all instances of drive motors
  // LeftMotor2 and RightMotor2 are slaves to LeftMotor1 and RightMotor1
  // respectively
  private TalonSRX LeftMotor1 = new TalonSRX(Constants.LEFT_DRIVE_MOTOR1_ID);
  private TalonSRX RightMotor1 = new TalonSRX(Constants.RIGHT_DRIVE_MOTOR1_ID);
  private VictorSPX LeftMotor2 = new VictorSPX(Constants.LEFT_DRIVE_MOTOR2_ID);
  private VictorSPX RightMotor2 = new VictorSPX(Constants.RIGHT_DRIVE_MOTOR2_ID);
  
  private final IMotorController LEFT = LeftMotor1;
  private final IMotorController RIGHT = RightMotor1; 
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    //TODO: Add initialisers and stuff like methods
    LeftMotor1.setInverted(true);
    LeftMotor2.setInverted(true);

    LeftMotor2.follow(LEFT);
    RightMotor2.follow(RIGHT);

  }

  //TODO: add dead zones

  //method for setting speed of left motor
  public void setLeftMotors(double percent) {
    LEFT.set(ControlMode.PercentOutput, percent);
  }

  //method for setting speed for right motor
  public void setRightMotors(double percent) {
    RIGHT.set(ControlMode.PercentOutput, percent);
  }

  public void drive(double speed, double turnH) {
    setRightMotors(speed - turnH);
    setLeftMotors(speed + turnH);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
