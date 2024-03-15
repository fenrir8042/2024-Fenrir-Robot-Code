
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RediktorConstans;

public class RediktorSubsystem extends SubsystemBase {

  private WPI_VictorSPX rediktorMotor = new WPI_VictorSPX(RediktorConstans.rediktorPort);
  private WPI_VictorSPX rediktorMotor2 = new WPI_VictorSPX(RediktorConstans.rediktor2Port);

  public boolean rediktorUp;
  public boolean rediktorDown;

  public RediktorSubsystem() {
    rediktorUp = true;
    rediktorDown = true;
  }

  @Override
  public void periodic() {

  }

  public void rediktorUp() {
    if (rediktorUp) {
      rediktorMotor.set(1f);
      rediktorMotor2.set(1f);
    } else {
      rediktorMotor.stopMotor();
      rediktorMotor2.stopMotor();
    }
  }

  public void rediktorDown() {
    if (rediktorDown) {
      rediktorMotor.set(-1f);
      rediktorMotor2.set(-1f);
    } else {
      rediktorMotor.stopMotor();
      rediktorMotor2.stopMotor();
    }
  }

  public void rediktorStop() {
    rediktorMotor.stopMotor();
    rediktorMotor2.stopMotor();
  }
}
