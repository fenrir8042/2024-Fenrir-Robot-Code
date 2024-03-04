/**package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.IntakeState;


public class IntakeSubsystem { 

     private final WPI_TalonSRX talonSRX1;
    private final WPI_TalonSRX talonSRX2;
    private IntakeState currentState = IntakeState.STOPPED;

    public Intake(){
        this.talonSRX1 = new WPI_TalonSRX(Constants.INTAKE_MOTOR1_ID);
        this.talonSRX2 = new WPI_TalonSRX(Constants.INTAKE_MOTOR2_ID);
    }

    /**
     * sets the speed of both motors to the IntakeSpeed defined in the {@link Constants} file
     * @param forward if true the motors will spin in the intake directions,
     *                if false the motors will spin in the outtake direction
     */
    /**public void spin(boolean forward){
        double speed = forward ? Constants.INTAKE_SPEED : Constants.INTAKE_SPEED*-1;
        talonSRX1.set(speed);
        talonSRX2.set(-speed);
        currentState = forward ? IntakeState.FORWARD: IntakeState.BACKWARD;
    }
    public void stop(){
        talonSRX1.set(0);
        talonSRX2.set(0);
        currentState = IntakeState.STOPPED;
    }

    public IntakeState getState() {
        return currentState;
    }
  */