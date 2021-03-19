// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
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

    driveTrain.PIDsetLeftMotors(leftSpeedFtPerSec);
    driveTrain.PIDsetRightMotors(rightSpeedFtPerSec);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    if (interrupted){
      driveTrain.stop();
    }

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


  //positive radius is on right side. Negative radius is on left side.
  public static Drive DriveArc(double radiusFeet, double speedFtPerSecond, DriveTrain driveTrain) {

    double leftSpeedFtPerSec = speedFtPerSecond * (radiusFeet - Constants.WHEEL_DISTANCE_FT/2)/radiusFeet;
    double rightSpeedFtPerSec = speedFtPerSecond * (radiusFeet + Constants.WHEEL_DISTANCE_FT/2)/radiusFeet;
    return new Drive(leftSpeedFtPerSec, rightSpeedFtPerSec, driveTrain);

  }

  

}
