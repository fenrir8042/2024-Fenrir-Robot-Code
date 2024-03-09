
package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private WPI_VictorSPX intakeMotor = new WPI_VictorSPX(Constants.IntakeConstans.intakePort);

  public boolean motorPush;
  public boolean motorPull;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    motorPush = true;
    motorPull = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void motorPush() {
    if (motorPush) {
      intakeMotor.set(0.5f);
    } else {
      intakeMotor.stopMotor();
    }
  }

  

  public void motorPull() {
    if (motorPull) {
      intakeMotor.set(-0.5f);
    } else {
      intakeMotor.stopMotor();
    }
  }



  public void motorStop() {
    intakeMotor.stopMotor();
  }
 }