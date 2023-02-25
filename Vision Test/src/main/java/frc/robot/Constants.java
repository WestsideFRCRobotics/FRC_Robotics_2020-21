package frc.robot;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.util.Units;

public class Constants {

    public static final Pose3d robot = new Pose3d(); 

    public static final class AprilTag {

        public static final double targetWidth = Units.inchesToMeters(100);         //Width of AprilTag
        public static final double targetHeight = Units.inchesToMeters(100);        //Height of AprilTag

        //Camera Constants
        public static final String cameraName = "OV5647";
        public static final double cameraMaxDiagonalFOV = 70;
        public static final Transform3d robotToCamera = new Transform3d();
        public static final double cameraMaxLEDRange = 9999;
        public static final int cameraResWidth = 640;
        public static final int cameraResHeight = 480;
        public static final double cameraMinTargetArea = 10;




        //AprilTag locations on field
        //Red alliance community (right to left)
        public static final Pose3d tag1 = new Pose3d(Units.inchesToMeters(610.77), Units.inchesToMeters(42.19), Units.inchesToMeters(18.22), new Rotation3d(0, 0, Math.PI));
        public static final Pose3d tag2 = new Pose3d(Units.inchesToMeters(610.77), Units.inchesToMeters(108.19), Units.inchesToMeters(18.22), new Rotation3d(0, 0, Math.PI));
        public static final Pose3d tag3 = new Pose3d(Units.inchesToMeters(610.77), Units.inchesToMeters(174.19), Units.inchesToMeters(18.22), new Rotation3d(0, 0, Math.PI));

        //Blue alliance substation
        public static final Pose3d tag4 = new Pose3d(Units.inchesToMeters(636.96), Units.inchesToMeters(265.74), Units.inchesToMeters(27.38), new Rotation3d(0, 0, Math.PI));

        //Red alliance substation
        public static final Pose3d tag5 = new Pose3d(Units.inchesToMeters(14.25), Units.inchesToMeters(265.74), Units.inchesToMeters(27.38), new Rotation3d(0, 0, Math.PI));
        
        //Blue alliance community (right to left)
        public static final Pose3d tag6 = new Pose3d(Units.inchesToMeters(40.45), Units.inchesToMeters(174.19), Units.inchesToMeters(18.22), new Rotation3d(0, 0, Math.PI));
        public static final Pose3d tag7 = new Pose3d(Units.inchesToMeters(40.45), Units.inchesToMeters(108.19), Units.inchesToMeters(18.22), new Rotation3d(0, 0, Math.PI));
        public static final Pose3d tag8 = new Pose3d(Units.inchesToMeters(40.45), Units.inchesToMeters(42.19), Units.inchesToMeters(18.22), new Rotation3d(0, 0, Math.PI));
    }
}
