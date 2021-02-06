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
    
    public static final int RIGHT_DRIVE_MOTOR_FRONT = 0; //TODO: get CAN bus value

    //Digital IO mapping
	public static final int[] FRONT_CENTER_ULTRASONIC_DIO = {1,2};

 

    public static final int CONTROLLER_PORT = 0; //the port the controller is pluged into

    //Joystick mapping
    //public static final int LEFT_X_AXIS = 0;
    //public static final int LEFT_Y_AXIS = 0; // TODO! set joystick mapping




    //Drive Constants
    public static final double TELEOP_DRIVE_SENSITIVITY = 1;
    public static final double TELEOP_TURN_SENSITIVITY = 1;



    //Conversion Constants
    public static final double MAG_TICKS_PER_REVOLUTION=0;
    public static final double MAG_TICKS_PER_DISTANCE_DRIVE_INCHES=0;

}
