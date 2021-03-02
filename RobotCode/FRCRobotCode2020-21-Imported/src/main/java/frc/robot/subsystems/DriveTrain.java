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

/*
This subsystem interfaces with the motor controlers that run the drive train on the robot.
*/

public class DriveTrain extends SubsystemBase {

  // Any percent output level below 2 will shut off the motor
  private static final double DEAD_ZONE = 0.025;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // all instances of drive motors
  // LeftMotor2 and RightMotor2 are slaves to LeftMotor1 and RightMotor1
  // respectively
  private TalonSRX LeftMotor1 = new TalonSRX(Constants.LEFT_DRIVE_MOTOR1_ID);
  private TalonSRX RightMotor1 = new TalonSRX(Constants.RIGHT_DRIVE_MOTOR1_ID);
  private TalonSRX LeftMotor2 = new TalonSRX(Constants.LEFT_DRIVE_MOTOR2_ID);
  private TalonSRX RightMotor2 = new TalonSRX(Constants.RIGHT_DRIVE_MOTOR2_ID);
  
  private final IMotorController LEFT = LeftMotor1;
  private final IMotorController RIGHT = RightMotor1;






  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {

    LeftMotor1.setInverted(true);
    LeftMotor2.setInverted(true);

    LeftMotor2.follow(LEFT);
    RightMotor2.follow(RIGHT);


    LeftMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    RightMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    LeftMotor1.setSensorPhase(false); //TODO: make sure sensor phase is correct
    RightMotor1.setSensorPhase(false);


  }

  //method for setting speed of left motor
  public void setLeftMotors(double percent) {
    if (Math.abs(percent)<=DEAD_ZONE) {
      LEFT.neutralOutput(); //if the speed is in the dead zone, we shouldn't have any power to the wheels
    } else {
      LEFT.set(ControlMode.PercentOutput, percent); 
    }
  }

  //method for setting speed for right motor
  public void setRightMotors(double percent) {
    if(Math.abs(percent)<=DEAD_ZONE) {
      RIGHT.neutralOutput(); //if the speed is in the dead zone, we shouldn't have any power to the wheels
    } else {
      RIGHT.set(ControlMode.PercentOutput, percent);
    }
  }

  public void drive(double speed, double turnH) {
    setRightMotors(speed - turnH);
    setLeftMotors(speed + turnH);
  }

  //sets both the left and right motors to neutral output, stopping the robot
  public void stop() {
    LEFT.neutralOutput();
    RIGHT.neutralOutput();
  }


  //methods for geting and reseting wheel encoders.
  public double getLeftDistanceTraveled() {
    return LEFT.getSelectedSensorPosition(0)*Constants.DISTANCE_DRIVE_FEET_PER_MAG_TICK;
  }
  public double getRightDistanceTraveled() {
    return RIGHT.getSelectedSensorPosition(0)*Constants.DISTANCE_DRIVE_FEET_PER_MAG_TICK;
  }
  public double getAverageDistanceTraveled() {
    return (LEFT.getSelectedSensorPosition(0)+RIGHT.getSelectedSensorPosition(0))/2*Constants.DISTANCE_DRIVE_FEET_PER_MAG_TICK;
  }
  
  public void resetEncoderPositions() {
    //args: position, pidIndex, misTimeout
    LEFT.setSelectedSensorPosition(0, 0, 10);
    RIGHT.setSelectedSensorPosition(0, 0, 10);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
