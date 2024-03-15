package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

  private WPI_VictorSPX intakeMotor = new WPI_VictorSPX(Constants.IntakeConstans.intakePort);

  private WPI_VictorSPX transMitterCim = new WPI_VictorSPX(Constants.ShooterIntake.shooterIntakeCimPort);

  public boolean motorPush;
  public boolean motorPull;

  public IntakeSubsystem() {
    motorPush = true;
    motorPull = true;
  }

  @Override
  public void periodic() {

  }

  public void motorPush() {
    if (motorPush) {
      intakeMotor.set(0.6f);
      transMitterCim.set(0.6f);
    } else {
      intakeMotor.stopMotor();
      transMitterCim.stopMotor();
    }
  }
  
  public void motorPull() {
    if (motorPull) {
      intakeMotor.set(-0.6f);
      transMitterCim.set(-0.6f);
    } else {


      intakeMotor.stopMotor();
      transMitterCim.stopMotor();
    }
  }

  public void motorStop() {
    intakeMotor.stopMotor();
    transMitterCim.stopMotor();
  }
}