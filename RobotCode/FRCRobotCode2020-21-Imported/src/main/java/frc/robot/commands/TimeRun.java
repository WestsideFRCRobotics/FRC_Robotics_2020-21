// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class TimeRun extends WaitCommand {

  private Command command;

  public TimeRun(double seconds, Command command) {
    super(seconds);
    //put something here to make the command end when this command ends
  }

  
  
}
