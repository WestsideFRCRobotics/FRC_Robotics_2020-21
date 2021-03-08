package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Autonomous {

    private final DriveTrain driveTrain;

    private final TeleOp teleOp;
    //Takes input from the XboxController and changes it into output for the DriveTrain
  
    private final XboxController controller;
  
  
  
    private final Movement movement;
  
    private final Field field;



    public Command Square() {
        return new SequentialCommandGroup(
            new InstantCommand()
            new DriveStraight(3, 0, driveTrain, movement),

            new TurnToAngle(TargetAngleDegrees, driveTrain, movement)

        );



    }




    
}
