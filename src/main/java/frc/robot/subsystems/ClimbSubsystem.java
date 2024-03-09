
package frc.robot.subsystems;

import java.time.format.TextStyle;

import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase {

  private WPI_VictorSPX rightClimb = new WPI_VictorSPX(ClimbConstants.rightClimbPort);
  private WPI_VictorSPX leftClimb = new WPI_VictorSPX(ClimbConstants.leftClimbPort);

  public boolean ClimbUpMode;
  public boolean ClimbDownMode;


  /** Creates a new ClimbSubsystem. */
  public ClimbSubsystem() {
    ClimbUpMode = true;
    ClimbDownMode = true;
  }

  @Override
  public void periodic() {

 }

  public void climbPush() {
    if (ClimbUpMode) {
      rightClimb.set(1f);
      leftClimb.set(1f);
    } else {
      rightClimb.stopMotor();
      leftClimb.stopMotor();
    }
  }

  public void climbPull() {
    if (ClimbDownMode) {
      rightClimb.set(-1f);
      leftClimb.set(-1f);
    } else {
      rightClimb.stopMotor();
      leftClimb.stopMotor();
    }
  }

 

  public void ClimbStop() {
    rightClimb.stopMotor();
    leftClimb.stopMotor();
  }
 }
