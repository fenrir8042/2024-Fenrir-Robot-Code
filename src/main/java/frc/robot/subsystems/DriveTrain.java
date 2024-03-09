package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.invert;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTrain extends SubsystemBase {

  Joystick gamepad = new Joystick(Constants.OI.kStickId);

  
  private WPI_TalonSRX backLeft = new WPI_TalonSRX(DrivetrainConstants.backLeftPort);
  private WPI_TalonSRX frontLeft = new WPI_TalonSRX(DrivetrainConstants.frontLeftPort);
  private WPI_VictorSPX frontRight= new WPI_VictorSPX(DrivetrainConstants.frontRightPort);
  private WPI_TalonSRX  backRight = new WPI_TalonSRX (DrivetrainConstants.backRightPort); 

  


  // private final MotorController rightcony = new MotorController(frontRight, backRight);
  // private final MotorController keftcony = new MotorController(frontLeft, backLeft);   

  public MecanumDrive mecDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  

  public DriveTrain() {
    frontLeft.setInverted(false);
    frontRight.setInverted(true);
    backLeft.setInverted(false);
    backRight.setInverted(true);
    
  }



  public double distanceToTicks(double distanceInches) {
    return (distanceInches / 6 * Math.PI) * 2048;
  }

  public void setMecanumPermanent(double y, double x, double rx) {
    frontLeft.set(y + x + rx);
    backLeft.set(y - x + rx);
    frontRight.set(y - x - rx);
    backRight.set(y + x - rx);

    
  }

  public void setMecanum(double y, double x, double rx) {
     mecDrive.driveCartesian(y, x, rx);

    SmartDashboard.putNumber("x", x);
    SmartDashboard.putNumber("y", y);
    SmartDashboard.putNumber("rx", rx);
  }

  public double getDistance() {
    return (frontLeft.getSelectedSensorPosition() * 3.55 * Math.PI / 2048) / 10.71;
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {}

  // public void autotaxi() {
  //   frontLeft.set(-0.5);
  //   backLeft.set(-0.5);
  //   frontRight.set(-0.5);
  //   backRight.set(-0.5);
  // }
  
}