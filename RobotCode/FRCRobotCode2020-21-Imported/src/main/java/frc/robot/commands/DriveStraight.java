// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.Movement;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveStraight extends PIDCommand {

  private final DriveTrain driveTrain;

  /** Creates a new DriveStraight. */
  public DriveStraight(double TargetAngleDegrees, double TargetDistance, double cruisePower, DriveTrain driveTrain, Movement movement) {

    super(
        // The controller that the command will use
        new PIDController(Constants.TURN_KP, Constants.TURN_KI, Constants.TURN_KD),
        // This should return the measurement
        () -> movement.getAngle(),
        // This should return the setpoint (can also be a constant)
        () -> TargetAngleDegrees,
        // This uses the output
        output -> driveTrain.drive(cruisePower, output));


    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    addRequirements(driveTrain);
    this.driveTrain = driveTrain;

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
