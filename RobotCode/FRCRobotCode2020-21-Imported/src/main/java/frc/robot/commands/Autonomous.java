package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.*;


public class Autonomous {

    private final DriveTrain driveTrain;
  
    private final Sensors movement;
  
    private final Field field;


    public Autonomous(DriveTrain driveTrain, Sensors movement, Field field) {
        this.driveTrain = driveTrain;
        this.movement = movement;
        this.field = field;
    }



    public Command SquareOld() {

        return new SequentialCommandGroup(
            (new DriveStraightOldWithGyro(3, driveTrain, movement)).withTimeout(3),
            new TurnAngle(90, driveTrain, movement),

            (new DriveStraightOldWithGyro(3, driveTrain, movement)).withTimeout(3),
            new TurnAngle(90, driveTrain, movement),

            (new DriveStraightOldWithGyro(3, driveTrain, movement)).withTimeout(3),
            new TurnAngle(90, driveTrain, movement),

            (new DriveStraightOldWithGyro(3, driveTrain, movement)).withTimeout(3),
            new TurnAngle(90, driveTrain, movement)

        );

    }

    public Command SquareNew() {

        return new SequentialCommandGroup(

            (new Drive(1, 1, driveTrain)).withTimeout(3),
            Drive.DriveArc(3, 1, driveTrain).withTimeout(Math.PI/2*3/1), //this wont work. change later. radians = velocity*time/radius. time = radians*radius/velocity

            (new Drive(1, 1, driveTrain)).withTimeout(3),
            Drive.DriveArc(3, 1, driveTrain).withTimeout(Math.PI/2*3/1),

            (new Drive(1, 1, driveTrain)).withTimeout(3),
            Drive.DriveArc(3, 1, driveTrain).withTimeout(Math.PI/2*3/1),

            (new Drive(1, 1, driveTrain)).withTimeout(3),
            Drive.DriveArc(3, 1, driveTrain).withTimeout(Math.PI/2*3/1)

        );

    }


    public Command test()
    {
        return new SequentialCommandGroup(
            //new InstantCommand(()->movement.resetAngle()),  
            new TurnAngle(90, driveTrain, movement) //TODO: work out resetAngle and calibrate
        );
    }

    
}
