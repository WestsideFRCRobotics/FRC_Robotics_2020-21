// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.Sensors;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TurnAngle extends PIDCommand {


  private Sensors movement;

  /** Creates a new TurnToAngle. */
  public TurnAngle(double TargetAngleDegrees, DriveTrain driveTrain, Sensors movement) {
    super(
        // The controller that the command will use
        new PIDController(Constants.TURN_KP, Constants.TURN_KI, Constants.TURN_KD),
        // This should return the measurement
        () -> movement.getRelativeAngle(),  //lambda expression -- sends an ENTIRE function
        // This should return the setpoint (can also be a constant)
        TargetAngleDegrees,
        // This uses the output
        output -> driveTrain.drive(0, output)
    );
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    addRequirements(driveTrain);

    getController().enableContinuousInput(-180, 180);
    getController().setTolerance(Constants.DEGREE_TOLERANCE, Constants.TURN_RATE_TOLERANCE);
    
    this.movement = movement;

  }

  @Override
  public void initialize() {
    m_controller.reset(); //copied from PIDCommand class

    movement.resetRelativeBaseAngle();

  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
