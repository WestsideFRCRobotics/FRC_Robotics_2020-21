package frc.robot;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.List;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.SimPhotonCamera;
import org.photonvision.SimVisionSystem;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

public class Robot extends TimedRobot {

  public static PhotonCamera camera = new PhotonCamera(Constants.AprilTag.cameraName); //OV5647     FHD_Camera
  public static SimPhotonCamera simCamera = new SimPhotonCamera(Constants.AprilTag.cameraName);

  @Override
  public void robotInit() {

    ShuffleboardTab tab = Shuffleboard.getTab("Vision");
    //tab.addCamera("View", "OV5647");
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {}

  @Override
  public void robotPeriodic() {
    SimVisionSystem simVision = new SimVisionSystem(Constants.AprilTag.cameraName, Constants.AprilTag.cameraMaxDiagonalFOV, Constants.AprilTag.robotToCamera, Constants.AprilTag.cameraMaxLEDRange, Constants.AprilTag.cameraResWidth, Constants.AprilTag.cameraResHeight, Constants.AprilTag.cameraMinTargetArea);

    PhotonPipelineResult cameraResult = camera.getLatestResult();
    if(cameraResult.hasTargets()){
      List<PhotonTrackedTarget> targets = cameraResult.getTargets();
      int cnt = 0;
      for(PhotonTrackedTarget target : targets){
      //simVision.addSimVisionTarget(Constants.AprilTag.);
        simCamera.submitProcessedFrame(cnt, targets);
        SmartDashboard.putString("name", ("tag" + target.getFiducialId()));
        SmartDashboard.putNumber("id" + String.valueOf(cnt), target.getFiducialId());
        SmartDashboard.putNumberArray("coordinates "+ String.valueOf(target.getFiducialId()), new double[]
        {target.getBestCameraToTarget().getX(),target.getBestCameraToTarget().getY(),target.getBestCameraToTarget().getZ()});
        SmartDashboard.putNumber("distance to target", PhotonUtils.calculateDistanceToTargetMeters(kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod));
        SmartDashboard.putNumber( "Area", target.getArea());


        


      }
    }
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
