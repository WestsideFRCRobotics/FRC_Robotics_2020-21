/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

/*
Allows the driver to move the robot with the controller
*/

public class UserControlDrive extends CommandBase {
  private DriveTrain driveTrain;
  private XboxController controller;
  /**
   * Creates a new UserControlDrive.
   */
  public UserControlDrive(DriveTrain driveTrain, XboxController xboxController) {
    this.driveTrain = driveTrain; //only passing a reference. The object is the same as in RobotContainer.
    controller = xboxController;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double turnH=controller.getRawAxis(Constants.LEFT_X_AXIS);
    double speed= controller.getRawAxis(Constants.LEFT_Y_AXIS);
    driveTrain.drive(speed, turnH);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
