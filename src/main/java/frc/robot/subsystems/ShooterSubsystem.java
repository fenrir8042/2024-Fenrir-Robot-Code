package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  private WPI_VictorSPX shooterRightMotor = new WPI_VictorSPX(Constants.ShooterConstants.shooterRightPort);
  private WPI_VictorSPX shooterLeftMotor = new WPI_VictorSPX(Constants.ShooterConstants.shooterLeftPort);

  private WPI_VictorSPX transCim = new WPI_VictorSPX(Constants.ShooterConstants.transMitterPort);

  public boolean shoot;
  public boolean shoot2;
  public boolean transMitter;

  public ShooterSubsystem() {
    shoot = true;
    shoot2 = true;
    transMitter = true;
  }

  @Override
  public void periodic() {

  }

  public void shooter() {
    if (shoot) {
      shooterRightMotor.set(1f);
    } else {
      shooterRightMotor.stopMotor();
      shooterLeftMotor.stopMotor();
    }
  }

  public void shoot2() {
    if(shoot2) {
      shooterLeftMotor.set(-1f);
    } else {
      shooterLeftMotor.stopMotor();
    }
  }

  public void transMitter() {
    if (transMitter) {
      transCim.set(1f);
    } else {
      transCim.stopMotor();
    }
  }
  
  public void shooterStop() {
    shooterRightMotor.stopMotor();
    shooterLeftMotor.stopMotor();
  }
}