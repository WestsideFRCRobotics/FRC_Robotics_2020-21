/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain;

  private final FlyWheel flyWheel;

  private final TeleOp teleOp;
  //Takes input from the XboxController and changes it into output for the DriveTrain

  private final XboxController controller;



  private final Movement movement;

  private final Field field;

  private final Autonomous autonomous;


  private final SendableChooser<Command> chooser = new SendableChooser<>();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    
    driveTrain = new DriveTrain();
    flyWheel = new FlyWheel();

    controller = new XboxController(Constants.CONTROLLER_PORT);
    teleOp = new TeleOp(driveTrain, controller, flyWheel);

    field = new Field();
    movement = new Movement(driveTrain, field);

    autonomous = new Autonomous(driveTrain, movement, field);


    chooser.addOption("None", new InstantCommand());
    chooser.addOption("square", autonomous.Square());




    configureButtonBindings(); // Configure the button bindings
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   // return m_autoCommand;
   return chooser.getSelected();
  }

  public Command getTeleOpCommand (){
    return teleOp;
  }
}
