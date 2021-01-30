package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Ultrasonic;

//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Movement {

    private final ADIS16448_IMU imu = new ADIS16448_IMU();

    //Gyro gyro = new ADXRS450_Gyro();
    //TODO: figure out if the IMU and gyro use the same port

    Ultrasonic front_center_ultrasonic = new Ultrasonic(Constants.FRONT_CENTER_ULTRASONIC_DIO[0], Constants.FRONT_CENTER_ULTRASONIC_DIO[1]);


    public Movement() {
        imu.setYawAxis(ADIS16448_IMU.IMUAxis.kY); //TODO: set correct yaw axis

    }

    //returns the angle the robot is facing if the initial angle its facing was 0
    public double getYawAngle() {
        return imu.getGyroAngleY();
    }


    
}
