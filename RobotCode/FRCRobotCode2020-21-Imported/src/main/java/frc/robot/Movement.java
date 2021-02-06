package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.subsystems.DriveTrain;

//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Movement {



    public Movement(DriveTrain driveTrain) {
        imu.setYawAxis(ADIS16448_IMU.IMUAxis.kY); //TODO: set correct yaw axis
        this.driveTrain = driveTrain;

        driveTrain.setMovement(this); //so drivetrain can have a reference to this class so it can impliment a closed loop system.

    }

    private final DriveTrain driveTrain;

    private final ADIS16448_IMU imu = new ADIS16448_IMU();

    //Gyro gyro = new ADXRS450_Gyro();
    //TODO: figure out if the IMU and gyro use the same port

    private final Ultrasonic front_center_ultrasonic = new Ultrasonic(Constants.FRONT_CENTER_ULTRASONIC_DIO[0], Constants.FRONT_CENTER_ULTRASONIC_DIO[1]);

    //returns the angle the robot is facing if the initial angle its facing was 0
    public double getYawAngle() {
        return imu.getGyroAngleY();
    }

    public double getFrontCenterUltrasonicDistance() {
        return front_center_ultrasonic.getRangeInches();
    }



    private double positionX=0, positionY=0, StartAngle=0,
                   leftTotalArclength=0, rightTotalArclength=0, lastAngle;

    public static void updateRobotPosition(){




    }




    
}
