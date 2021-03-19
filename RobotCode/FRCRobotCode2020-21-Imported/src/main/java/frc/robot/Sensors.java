package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.subsystems.DriveTrain;

//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Sensors {


    private AHRS ahrs = new AHRS(SPI.Port.kMXP);
    private double relativeAngleBase = 0;  //if you want to turn 90 degrees, first record what angle the robots facing, than compare the new angle to the old one.

   
    private final DriveTrain driveTrain;

    private final Ultrasonic front_center_ultrasonic = new Ultrasonic(Constants.FRONT_CENTER_ULTRASONIC_DIO[0], Constants.FRONT_CENTER_ULTRASONIC_DIO[1]);

    public Sensors(DriveTrain driveTrain, Field field) {
        //imu.setYawAxis(ADIS16448_IMU.IMUAxis.kY); //TODO: set correct yaw axis
        this.driveTrain = driveTrain;

        driveTrain.setMovement(this); //so drivetrain can have a reference to this class so it can impliment a closed loop system.

    }

    //returns the angle the robot is facing if the initial angle its facing was 0
    public double getAbsoluteAngle() {
        return ahrs.getAngle();
    }
    public void recalibrateGyroscope() {
        ahrs.calibrate();
    }
    public double getRelativeAngle() {
        return ahrs.getAngle() - relativeAngleBase;
    }
    public void resetRelativeBaseAngle() { //sets the relative angle to the current angle. should be called at the begining of any autonomous routine that uses relative angles
        relativeAngleBase = ahrs.getAngle(); 
    }
    public boolean isGyroCalibrating() {
        return ahrs.isCalibrating();
    }
    public double getRelativeBaseAngle() {
        return relativeAngleBase;
    }

    public double getFrontCenterUltrasonicDistance() {
        return front_center_ultrasonic.getRangeInches();
    }



    // private double positionX=0, positionY=0, StartAngle=0,
    //                leftTotalArclength=0, rightTotalArclength=0, lastAngle;
                   
    // public static void resetRobotPosition(double positionX, double positionY, double angle){
    // }



    
}
