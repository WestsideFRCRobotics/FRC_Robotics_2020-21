// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class StopAhead extends CommandBase {


  private DriveTrain driveTrain;

  PIDController pidLeft = new PIDController(Constants.STOP_KP, Constants.STOP_KI, Constants.STOP_KD);

  PIDController pidRight = new PIDController(Constants.STOP_KP, Constants.STOP_KI, Constants.STOP_KD);

  private final double distanceFt;

  /** Creates a new StopAhead. */
  public StopAhead(double distanceFt, DriveTrain driveTrain) {
    
    this.driveTrain = driveTrain;

    pidLeft.setTolerance(Constants.POS_TOLERANCE, Constants.SPEED_TOLERANCE);
    pidRight.setTolerance(Constants.POS_TOLERANCE, Constants.SPEED_TOLERANCE);

    this.distanceFt = distanceFt;

    pidLeft.setSetpoint(distanceFt);
    pidRight.setSetpoint(distanceFt);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    driveTrain.resetEncoderPositions();


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    driveTrain.setLeftMotors(pidLeft.calculate(driveTrain.getLeftDistanceTraveled()));

    driveTrain.setRightMotors(pidRight.calculate(driveTrain.getRightDistanceTraveled()));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidLeft.atSetpoint() && pidRight.atSetpoint();
  }
}
