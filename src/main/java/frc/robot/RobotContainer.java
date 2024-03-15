// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MecanumDriveCmd;
import frc.robot.commands.Intake.motorPull;
import frc.robot.commands.Intake.motorPush;
import frc.robot.commands.Intake.motorStop;
import frc.robot.commands.Rediktor.rediktorDown;
import frc.robot.commands.Rediktor.rediktorStop;
import frc.robot.commands.Rediktor.rediktorUp;
import frc.robot.commands.Shooter.shoot2;
import frc.robot.commands.Shooter.shooter;
import frc.robot.commands.Shooter.shooterStop;
import frc.robot.commands.Shooter.transMitter;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.RediktorSubsystem;
import frc.robot.commands.AutoCmd;

//import frc.robot.TimerRediktor;



public class RobotContainer {

  final DriveTrain driveSubsystem = new DriveTrain();
  final RediktorSubsystem r_RediktorSubsystem = new RediktorSubsystem();
  final static IntakeSubsystem i_IntakeSubsystem = new IntakeSubsystem();
  final ShooterSubsystem s_ShooterSubsystem = new ShooterSubsystem();
  
  public static final Joystick stick = new Joystick(Constants.OI.kStickId);

  private final JoystickButton button1 = new JoystickButton(stick, Constants.OI.button1);
  private final JoystickButton button2 = new JoystickButton(stick, Constants.OI.button2);
  private final static JoystickButton button3 = new JoystickButton(stick, Constants.OI.button3);
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

      //Intake
      button4.whileTrue(new motorPush(i_IntakeSubsystem, 0.6f));
      //button3.whileTrue(new motorPull(i_IntakeSubsystem, -0.6f));

      //Rediktör
      button8.whileTrue(new rediktorUp(r_RediktorSubsystem, 1f));
      button7.whileTrue(new rediktorDown(r_RediktorSubsystem, -1f));


      //Shooter
      button2.whileTrue(new shooter(s_ShooterSubsystem, 1f));
      button2.whileTrue(new shoot2(s_ShooterSubsystem, -1f));
      button2.whileTrue(new transMitter(s_ShooterSubsystem, 1f));

      //Stop
      button1.whileTrue(new motorStop(i_IntakeSubsystem, 0));
      button1.whileTrue(new rediktorStop(r_RediktorSubsystem, 0));
      button1.whileTrue(new shooterStop(s_ShooterSubsystem, 0));


      
  }

   public static void main(String[] args) {
        // Create an ExecutorService with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Define the code block you want to run
        Runnable codeBlock = () -> {
            // Your code to be executed within the time limit
            button3.whileTrue(new motorPull(i_IntakeSubsystem, -0.6f));
            try {
                Thread.sleep(2000); // Simulating some time-consuming operation
                System.out.println("Code executed successfully!");
            } catch (InterruptedException e) {
                System.out.println("Code execution interrupted!");
            }
        };

        // Submit the code block to the executor
        Future<?> future = executor.submit(codeBlock);

        try {
            // Set a time limit for the code to execute (in seconds)
            long timeLimitInSeconds = 1;

            // Wait for the code block to finish executing within the time limit
            future.get(timeLimitInSeconds, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // If the code execution is interrupted or exceeds the time limit
            future.cancel(true); // Cancel the task if it's still running
            System.out.println("Code execution timed out or interrupted!");
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
    }

  public Command getAutonomousCommand()  {

    return AutoCmd;
  }


  

}