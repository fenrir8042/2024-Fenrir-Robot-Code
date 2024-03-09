// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSubsystem;
//import frc.robot.subsystems.IntakeSubsystem.IntakeState;
//import frc.robot.subsystems.ShooterSubsystem;
//import frc.robot.subsystems.pneumaticSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MecanumDriveCmd;
import frc.robot.commands.Climb.climbDown;
import frc.robot.commands.Climb.climbStopCmd;
import frc.robot.commands.Climb.climbUp;
import frc.robot.commands.Intake.motorPull;
import frc.robot.commands.Intake.motorPush;
import frc.robot.commands.Intake.motorStop;
// import frc.robot.commands.Climb.ClimbDownCmd;
// import frc.robot.commands.Climb.ClimbStopCmd;
// import frc.robot.commands.Climb.ClimbUpCmd;
//import frc.robot.commands.ShooterCommand;
//import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.Constants.OperatorConstants ;

//import frc.robot.commands.Arm.balanceCmd;

import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.commands.AutoCmd;
//import frc.robot.commands.IntakeCommand;



public class RobotContainer {


  final DriveTrain driveSubsystem = new DriveTrain();
  final ClimbSubsystem c_ClimbSubsystem = new ClimbSubsystem();
  final IntakeSubsystem i_IntakeSubsystem = new IntakeSubsystem();
  
  public static final Joystick stick = new Joystick(Constants.OI.kStickId);

  private final JoystickButton button1 = new JoystickButton(stick, Constants.OI.button1);
  private final JoystickButton button2 = new JoystickButton(stick, Constants.OI.button2);
  private final JoystickButton button3 = new JoystickButton(stick, Constants.OI.button3);
  private final JoystickButton button4 = new JoystickButton(stick, Constants.OI.button4);
  private final JoystickButton button5 = new JoystickButton(stick, Constants.OI.button5);
  private final JoystickButton button6 = new JoystickButton(stick, Constants.OI.button6);
  private final JoystickButton button7 = new JoystickButton(stick, Constants.OI.button7);
  private final JoystickButton button8 = new JoystickButton(stick, Constants.OI.button8);
  private final JoystickButton button9 = new JoystickButton(stick, Constants.OI.button9);
  private final JoystickButton button10 = new JoystickButton(stick, Constants.OI.button10);
  private final JoystickButton button11 = new JoystickButton(stick, Constants.OI.button11);
  private final JoystickButton button12 = new JoystickButton(stick, Constants.OI.button12);

  private final Command AutoCmd = new AutoCmd(driveSubsystem);

  public RobotContainer() {
    // Configure the button bindings
    CommandScheduler.getInstance().registerSubsystem(driveSubsystem);
   final Joystick stick = new Joystick(Constants.OI.kStickId);

    driveSubsystem.setDefaultCommand(
      new MecanumDriveCmd(
        driveSubsystem,
        () -> stick.getRawAxis(OperatorConstants.forwardAxis),
        () -> stick.getRawAxis(OperatorConstants.sideAxis),
        () -> stick.getRawAxis(OperatorConstants.rotationAxis),
        () -> stick.getRawAxis(OperatorConstants.scaleAxis)));

    configureButtonBindings();
  }

  private void configureButtonBindings() {

      // Climb
      button12.whileTrue(new climbStopCmd(c_ClimbSubsystem, 0));
      button4.whileTrue(new climbUp(c_ClimbSubsystem, +1f));
      button3.whileTrue(new climbDown(c_ClimbSubsystem, -1f));

      // Intake
     /* button2.whileTrue(new motorPush(i_IntakeSubsystem, 0.5f));
      button9.whileTrue(new motorPull(i_IntakeSubsystem, -0.5f));
      button11.whileTrue(new motorStop(i_IntakeSubsystem, 0));*/

     
  


   //button1.toggleOnTrue(ShooterCommand.setShooterMode(ShooterSubsystem.SHOOTING));
   //button2.toggleOnTrue(IntakeCommand.setIntakeState(IntakeSubsystem.INTAKING));
   //button5.onTrue(new CenterUp(m_ArmSubsystem,0.8f));
   //button3.onTrue(new CenterDown(m_ArmSubsystem, -0.3f));
   //button7.onTrue(new motorStopCmd(m_ArmSubsystem, 0));
   //button8.onTrue(new balanceCmd(m_ArmSubsystem, 0.2f));
   

   //button3.whileTrue(new ArmStopCmd(m_ArmSubsystem, 0));
   //button4.whileTrue(new ArmDownCmd(m_ArmSubsystem, 1f));
   //button12.whileTrue(new ArmDownCmd(m_ArmSubsystem, -1f));

   //button9.whileTrue(new ArmStopCmd(m_ArmSubsystem, 0));

   /*button1.whileTrue(new openCmd(m_pneumaticSubsystem));
   button2.whileTrue(new closeCmd(m_pneumaticSubsystem));*/


     /*  button3.whileTrue(new ArmStopCmd(m_ArmSubsystem, 0));
      button4.whileTrue(new ArmDownCmd(m_ArmSubsystem, 1f));
      button12.whileTrue(new ArmUpCmd(m_ArmSubsystem, 1f));*/

      
  
      


  }

  /*private void getClass(ClimbSubsystem c_ClimbSubsystem2) {
  
  }*/

  public Command getAutonomousCommand()  {

    return AutoCmd;
  }


  

}

    
