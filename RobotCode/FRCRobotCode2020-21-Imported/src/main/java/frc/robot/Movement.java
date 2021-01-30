package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class Movement {

    private final ADIS16448_IMU imu = new ADIS16448_IMU();

    public Movement() {
        imu.setYawAxis(ADIS16448_IMU.IMUAxis.kY); //TODO: set correct yaw axis
    }



    
}
