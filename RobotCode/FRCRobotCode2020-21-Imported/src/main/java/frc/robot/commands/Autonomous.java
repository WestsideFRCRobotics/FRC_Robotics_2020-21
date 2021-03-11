package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.*;

public class Autonomous {

    private final DriveTrain driveTrain;
  
    private final Movement movement;
  
    private final Field field;


    public Autonomous(DriveTrain driveTrain, Movement movement, Field field) {
        this.driveTrain = driveTrain;
        this.movement = movement;
        this.field = field;
    }



    public Command Square() {

        return new SequentialCommandGroup(
            new InstantCommand(()->movement.resetAngle()),

            (new DriveStraight(3, 0, driveTrain, movement)).withTimeout(3),
            new TurnToAngle(90, driveTrain, movement),

            (new DriveStraight(3, 0, driveTrain, movement)).withTimeout(3),
            new TurnToAngle(180, driveTrain, movement),

            (new DriveStraight(3, 0, driveTrain, movement)).withTimeout(3),
            new TurnToAngle(270, driveTrain, movement),

            (new DriveStraight(3, 0, driveTrain, movement)).withTimeout(3),
            new TurnToAngle(0, driveTrain, movement)

        );

    }




    
}
