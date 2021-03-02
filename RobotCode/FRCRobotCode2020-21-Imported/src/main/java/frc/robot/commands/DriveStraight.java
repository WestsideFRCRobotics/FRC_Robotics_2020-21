// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Movement;
import frc.robot.subsystems.DriveTrain;

public class DriveStraight extends CommandBase {

  //dependancies 
  private final DriveTrain driveTrain;
  private final Movement movement;



  //This is a more explicite way of using the PIDController. I'm sure everyone will like this better.
  //note how we need two controllers for driving straight, one for controlling the angle and another for controlling the speed
  private final PIDController angleController = new PIDController(Constants.TURN_KP, Constants.TURN_KI, Constants.TURN_KD);
  private final PIDController velocityController = new PIDController(Constants.TURN_KP, Constants.TURN_KI, Constants.TURN_KD);

  /** Creates a new DriveStraight. */
  public DriveStraight(double velocityftpersec, double targetAngleDegrees, DriveTrain driveTrain, Movement movement) {
    //We will use a seperate command to do time control. This will give us more flexibility with our autonomous setup.

    addRequirements(driveTrain);
    this.driveTrain = driveTrain;
    this.movement = movement;

    angleController.setSetpoint(targetAngleDegrees*Constants.TICKSPER100MS_PER_FTPERSEC);
    velocityController.setSetpoint(velocityftpersec);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //It's honestly just this simple. This basicly does exactly the same thing as the PIDController, but we can see what's going on behind the scenes.
    driveTrain.drive(
      velocityController.calculate()




  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
