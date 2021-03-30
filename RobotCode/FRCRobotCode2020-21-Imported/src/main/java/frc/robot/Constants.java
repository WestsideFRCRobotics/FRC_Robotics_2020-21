/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //CAN maping
	public static final int LEFT_DRIVE_MOTOR1_ID = 0; 	//front left motor CAN ID
	public static final int RIGHT_DRIVE_MOTOR1_ID = 10;	//front right motor CAN ID
	public static final int LEFT_DRIVE_MOTOR2_ID = 1;	//back left motor CAN ID
    public static final int RIGHT_DRIVE_MOTOR2_ID = 11;	//back right motor CAN ID

	public static final int LEFT_LOW_FLYWHEEL_MOTOR_ID = 20; 	//lower left motor CAN ID
	public static final int RIGHT_LOW_FLYWHEEL_MOTOR_ID = 30;	//lower right motor CAN ID
	public static final int LEFT_HIGH_FLYWHEEL_MOTOR_ID = 21;	//upper left motor CAN ID
    public static final int RIGHT_HIGH_FLYWHEEL_MOTOR_ID = 31;	//upper right motor CAN ID
    public static final int HOOD_MOTOR = 42; //Moves the hood

    public static final int SHOOTER_FEEDER = 40; //The thing that moves the ball up to the shooter

    public static final int INDEXER = 41;

    //Digital IO mapping
	public static final int[] FRONT_CENTER_ULTRASONIC_DIO = {1,2};

 
    //-------------------
    public static final int CONTROLLER_PORT = 0; //the port the controller is pluged into


    //Drive Constants
    public static final double TELEOP_DRIVE_SENSITIVITY = 1;
    public static final double TELEOP_TURN_SENSITIVITY = 1;

    public static final double WHEEL_DISTANCE_FT = 22.75/12;
    public static final double WHEEL_RADIUS_FT = 4.0/12;

    public static final double MAX_SPEED_FT_PER_SECOND = -1234;

    //Hood constants
    public static final double MIN_HOOD_ANGLE = 30;
    public static final double MAX_HOOD_ANGLE = 70;

    //Conversion Constants
    public static final double TICKSPER100MS_PER_RPM = 4096.0/600;
    public static final double TICKSPER100MS_PER_FTPERSEC = 4096.0/(8.0/12*Math.PI)*.1; //for 8in diameter wheel
    public static final double DISTANCE_DRIVE_FEET_PER_MAG_TICK = 8.0/12*Math.PI/4096.0;
    public static final double MAG_TICKS_PER_HOOD_DEGREE = 4096.0/2.0/360.0; 
        //note that hood encoder is on a different shaft than the hood so a gear ratio of 2 must be taken into account


    //PID constants
    public static final double FLYWHEEL_KP= .1, FLYWHEEL_KI=0, FLYWHEEL_KD=.02, FLYWHEEL_KF=.1;

    public static final double HOOD_KP = .1, HOOD_KI = .1, HOOD_KD = .1, HOOD_KF = 0;

    public static final double TURN_KP=0.5, TURN_KI=0, TURN_KD=0, DEGREE_TOLERANCE=1, TURN_RATE_TOLERANCE=1;

    public static final double DRIVE_KP=-1234, DRIVE_KI=-1234, DRIVE_KD=-1234, DRIVE_KF=-1234;

    public static final double STOP_KP=1, STOP_KI=0, STOP_KD=1, POS_TOLERANCE = .1, SPEED_TOLERANCE = 1;

    

}
