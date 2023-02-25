package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.List;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

public class Robot extends TimedRobot {

  public static PhotonCamera camera = new PhotonCamera("FHD_Camera");

  @Override
  public void robotInit() {

    ShuffleboardTab tab = Shuffleboard.getTab("Vision");
    tab.addCamera("View", "FHD_Camera");
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
    PhotonPipelineResult cameraResult = camera.getLatestResult();
    if(cameraResult.hasTargets()){
      List<PhotonTrackedTarget> targets = cameraResult.getTargets();
      int cnt = 0;
      for(PhotonTrackedTarget target : targets){
        SmartDashboard.putNumber("id" + String.valueOf(cnt), target.getFiducialId());
        SmartDashboard.putNumberArray("coordinates "+ String.valueOf(target.getFiducialId()), new double[]
        {target.getBestCameraToTarget().getX(),target.getBestCameraToTarget().getY(),target.getBestCameraToTarget().getZ()});
        SmartDashboard.putNumber("distance to target", PhotonUtils.calculateDistanceToTargetMeters(kDefaultPeriod, kDefaultPeriod, kDefaultPeriod, kDefaultPeriod));
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
