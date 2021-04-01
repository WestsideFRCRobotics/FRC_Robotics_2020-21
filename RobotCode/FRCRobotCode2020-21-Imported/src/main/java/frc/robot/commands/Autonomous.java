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


    private final double DRIVE_SPEED = 1.1, TURN_SPEED = 1;

    public Command barrelRacing() {
        return new SequentialCommandGroup(

            Drive.DriveDistance(DRIVE_SPEED, 10, driveTrain),

            Drive.DriveArcWithAngle(30.0/12, TURN_SPEED, 180, driveTrain, movement),
            Drive.DriveArcWithAngle(30.0/12, TURN_SPEED, 180, driveTrain, movement),

            Drive.DriveDistance(DRIVE_SPEED, 90.0/12, driveTrain),

            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -180, driveTrain, movement),
            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -134.64, driveTrain, movement),

            Drive.DriveDistance(DRIVE_SPEED, 84.95/12, driveTrain),

            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -180, driveTrain, movement),
            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -45.16, driveTrain, movement),

            Drive.DriveDistance(DRIVE_SPEED, 260.0/12, driveTrain),
            
            new StopAhead(10.0/12, driveTrain)

        );
    }

    public Command slalom(){
        return new SequentialCommandGroup(

            Drive.DriveDistance(DRIVE_SPEED, 22.47/12, driveTrain),

            Drive.DriveArcWithAngle(-28.0/12, TURN_SPEED, -59.27, driveTrain, movement),
            Drive.DriveDistance(DRIVE_SPEED, 37.95/12, driveTrain),
            Drive.DriveArcWithAngle(28.0/12, TURN_SPEED, 59.27, driveTrain, movement),

            Drive.DriveDistance(DRIVE_SPEED, 120/12, driveTrain),


            Drive.DriveArcWithAngle(30.0/12, TURN_SPEED, 90, driveTrain, movement),

            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -180, driveTrain, movement),
            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -180, driveTrain, movement),

            Drive.DriveArcWithAngle(30.0/12, TURN_SPEED, 90, driveTrain, movement),

            Drive.DriveDistance(DRIVE_SPEED, 260.0/12, driveTrain),

            Drive.DriveArcWithAngle(28.0/12, TURN_SPEED, 59.27, driveTrain, movement),
            Drive.DriveDistance(DRIVE_SPEED, 37.95/12, driveTrain),
            Drive.DriveArcWithAngle(-28.0/12, TURN_SPEED, -59.27, driveTrain, movement),
            
            new StopAhead(22.47/12, driveTrain)

        );
    }

    public Command bouncePath(){
        double bd = 7.0/12;
        return new SequentialCommandGroup(

            Drive.DriveDistance(DRIVE_SPEED, 30.0/12, driveTrain),

            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -90, driveTrain, movement),
            new StopAhead(bd, driveTrain),

            Drive.DriveDistance(-DRIVE_SPEED, -bd, driveTrain),
            Drive.DriveArcWithAngle(17.09/12, -TURN_SPEED, -25.49, driveTrain, movement),
            Drive.DriveDistance(-DRIVE_SPEED, -bd, driveTrain),
            Drive.DriveArcWithAngle(30.0/12, -TURN_SPEED, -154.51, driveTrain, movement),
            Drive.DriveDistance(-DRIVE_SPEED, -60.0/12, driveTrain),
            new StopAhead(-bd, driveTrain),

            Drive.DriveDistance(DRIVE_SPEED, 60.0/12+bd, driveTrain),
            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -90, driveTrain, movement),
            Drive.DriveDistance(DRIVE_SPEED, 30.0/12, driveTrain),
            Drive.DriveArcWithAngle(-30.0/12, TURN_SPEED, -90, driveTrain, movement),
            Drive.DriveDistance(DRIVE_SPEED, 60.0/12, driveTrain),
            new StopAhead(bd, driveTrain),

            Drive.DriveDistance(-DRIVE_SPEED, -bd, driveTrain),
            Drive.DriveArcWithAngle(30.0/12, -TURN_SPEED, -90, driveTrain, movement),

            new StopAhead(-30.0/12, driveTrain)

        );
    }

    
}
