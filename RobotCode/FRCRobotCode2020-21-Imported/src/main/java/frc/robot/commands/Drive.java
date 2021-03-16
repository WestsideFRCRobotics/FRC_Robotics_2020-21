// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase {

  private DriveTrain driveTrain;

  private final double leftSpeedFtPerSec, rightSpeedFtPerSec;

  /** Creates a new Drive. */
  public Drive(double leftSpeedFtPerSec, double rightSpeedFtPerSec, DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.leftSpeedFtPerSec = leftSpeedFtPerSec;
    this.rightSpeedFtPerSec = rightSpeedFtPerSec;

    this.driveTrain = driveTrain;

    addRequirements(driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {



  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
