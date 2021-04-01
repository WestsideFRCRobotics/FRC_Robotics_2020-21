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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
  private final Indexer indexer;
  private final Hood hood;

  //Takes input from the XboxController and changes it into output for the DriveTrain
  private final XboxController controller;

  private final Autonomous autonomous;
  private final TeleOp teleOp;

  private final Sensors movement;

  private final Field field;


  private final SendableChooser<Command> chooser = new SendableChooser<>();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    
    driveTrain = new DriveTrain();
    flyWheel = new FlyWheel();
    indexer = new Indexer();
    hood = new Hood();

    controller = new XboxController(Constants.CONTROLLER_PORT);
    teleOp = new TeleOp(controller, driveTrain, flyWheel, indexer, hood);

    field = new Field();
    movement = new Sensors(driveTrain, field);

    autonomous = new Autonomous(driveTrain, movement, field);


    chooser.addOption("None", new InstantCommand());
    chooser.addOption("squareOld", autonomous.SquareOld());
    chooser.addOption("squareNew", autonomous.SquareNew());
    chooser.addOption("testDrive", autonomous.testDrive());
    chooser.addOption("testArc180", autonomous.testArc180());
    chooser.addOption("testArc90", autonomous.testArc90());
    chooser.addOption("barrelRacing", autonomous.barrelRacing());
    chooser.addOption("slalom", autonomous.slalom());
    chooser.addOption("bounce", autonomous.bouncePath());
    SmartDashboard.putData("Auto mode", chooser);


    configureButtonBindings(); // Configure the button bindings

    hood.calibrate().schedule();

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  public void putDataToSmartDashboard() {
    SmartDashboard.putNumber("Absolute Angle", movement.getAbsoluteAngle());
    SmartDashboard.putNumber("Relative Angle", movement.getRelativeAngle());
    SmartDashboard.putNumber("right wheel distance", driveTrain.getRightDistanceTraveled());
    SmartDashboard.putNumber("left wheel distance", driveTrain.getLeftDistanceTraveled());
    SmartDashboard.putNumber("hood angle", hood.getHoodAngle());
    SmartDashboard.putBoolean("limit", hood.getLimitSwitch());
    SmartDashboard.putBoolean("is calibrated", hood.isCalibrated());
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

  public Command calibrateHood() {
    return hood.calibrate();
  }
}
