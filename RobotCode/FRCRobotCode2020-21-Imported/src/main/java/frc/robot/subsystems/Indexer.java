// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {

  private VictorSPX feederMotor = new VictorSPX(Constants.SHOOTER_FEEDER);
  private VictorSPX indexerMotor = new VictorSPX(Constants.INDEXER);

  private final double INDEXER_POWER = .2;
  private final double FEEDER_POWER = .5;

  /** Creates a new Indexer. */
  public Indexer() {


  }

  public void startFeed() {
    feederMotor.set(ControlMode.PercentOutput, FEEDER_POWER);
    indexerMotor.set(ControlMode.PercentOutput, INDEXER_POWER);
  }

  public void stopFeed() {
    feederMotor.neutralOutput();
    indexerMotor.neutralOutput();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
