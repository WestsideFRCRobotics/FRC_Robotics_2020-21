// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.Movement;
import frc.robot.subsystems.DriveTrain;


//IMPORTANT NOTE: this command will make the robot drive straight a certain distance, but we have no control over its speed.
//when we actually use this to run autonomous paths, it will need to speed up at the begining and slow down at the end.
//we will need to set a start speed and an end speed. This can also be done with PID, but we might do better with a more straightforward approach

public class DriveStraight extends PIDCommand {

  private final DriveTrain driveTrain;

  private final double TARGET_DISTANCE_FEET;

  /** Creates a new DriveStraight. */
  public DriveStraight(double TargetAngleDegrees, double TargetDistanceFeet, double cruisePower, DriveTrain driveTrain, Movement movement) {

    super(
        // The controller that the command will use
        new PIDController(Constants.TURN_KP, Constants.TURN_KI, Constants.TURN_KD),
        // This should return the measurement
        () -> movement.getAngle(),
        // This should return the setpoint (can also be a constant)
        TargetAngleDegrees,
        // This uses the output
        output -> driveTrain.drive(cruisePower, output));


    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    addRequirements(driveTrain);
    this.driveTrain = driveTrain;

    driveTrain.resetEncoderPositions();

    TARGET_DISTANCE_FEET = TargetDistanceFeet;


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return driveTrain.getAverageDistanceTraveled() >= TARGET_DISTANCE_FEET;
  }
}
