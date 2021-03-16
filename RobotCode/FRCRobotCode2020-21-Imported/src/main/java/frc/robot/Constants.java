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

	public static final int LEFT_LOW_FLYWHEEL_MOTOR_ID = -1; 	//lower left motor CAN ID
	public static final int RIGHT_LOW_FLYWHEEL_MOTOR_ID = -1;	//lower right motor CAN ID
	public static final int LEFT_HIGH_FLYWHEEL_MOTOR_ID = -1;	//upper left motor CAN ID
	public static final int RIGHT_HIGH_FLYWHEEL_MOTOR_ID = -1;	//upper right motor CAN ID


    //Digital IO mapping
	public static final int[] FRONT_CENTER_ULTRASONIC_DIO = {1,2};

 
    //-------------------
    public static final int CONTROLLER_PORT = 0; //the port the controller is pluged into


    //Drive Constants
    public static final double TELEOP_DRIVE_SENSITIVITY = 1;
    public static final double TELEOP_TURN_SENSITIVITY = 1;

    public static final double WHEEL_DISTANCE_INCHES = 22.75;
    public static final double WHEEL_RADIUS_INCHES = 4;

    public static final double MAX_SPEED_FT_PER_SECOND = -1234;

    //Conversion Constants
    public static final double TICKSPER100MS_PER_RPM = 4096.0/600;
    public static final double TICKSPER100MS_PER_FTPERSEC = 4096.0/(8*Math.PI)*.1; //for 8in diameter wheel
    public static final double DISTANCE_DRIVE_FEET_PER_MAG_TICK = 8*Math.PI/4096.0;


    //PID constants
    public static final double FLYWHEEL_KP= .1, FLYWHEEL_KI=0, FLYWHEEL_KD=.02, FLYWHEEL_KF=.1;

    public static final double TURN_KP=-1234, TURN_KI=-1234, TURN_KD=-1234, DEGREE_TOLERANCE=-1234, TURN_RATE_TOLERANCE=-1234;

    public static final double DRIVE_KP=-1234, DRIVE_KI=-1234, DRIVE_KD=-1234, DRIVE_KF=-1234;

    

}
