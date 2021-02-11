/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

/*
Allows the driver to move the robot with the controller
*/

public class TeleOp extends CommandBase {
  private DriveTrain driveTrain;
  private XboxController controller;
  /**
   * Creates a new UserControlDrive.
   */
  public TeleOp(DriveTrain driveTrain, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    //^^^ adding this line of code makes sure we don't ever have two commands using the same subsystem at one time

    this.driveTrain = driveTrain; //only passing a reference. The object is the same as in RobotContainer.
    controller = xboxController;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double turnH = Constants.TELEOP_TURN_SENSITIVITY  *  controller.getX(Hand.kLeft);
    double speed = Constants.TELEOP_DRIVE_SENSITIVITY  *  controller.getY(Hand.kLeft);
    //from what I reseached, the above code should work. If not, we still have the old code below.
    //double turnH = Constants.TELEOP_TURN_SENSITIVITY  *  controller.getRawAxis(Constants.LEFT_X_AXIS);
    //double speed = Constants.TELEOP_DRIVE_SENSITIVITY  *  controller.getRawAxis(Constants.LEFT_Y_AXIS);

    //another thing to think about is usi ng non-linear input to speed mappings (S-curve, stepping, etc.)

    driveTrain.drive(speed, turnH);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    //make sure to stop the drive train if this command is interrupted, for safety
    if(interrupted) {
      driveTrain.stop();
    }


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
