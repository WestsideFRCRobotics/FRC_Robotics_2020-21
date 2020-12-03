/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
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
  private TalonSRX LeftMotor1 = new TalonSRX(RobotMap.LEFT_DRIVE_MOTOR1_ID);
  private TalonSRX RightMotor1 = new TalonSRX(RobotMap.RIGHT_DRIVE_MOTOR1_ID);
  private VictorSPX LeftMotor2 = new VictorSPX(RobotMap.LEFT_DRIVE_MOTOR2_ID);
  private VictorSPX RightMotor2 = new VictorSPX(RobotMap.RIGHT_DRIVE_MOTOR2_ID);
  
  private final IMotorController LEFT = LeftMotor1;
  private final IMotorController RIGHT = RightMotor1; 
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {

  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
