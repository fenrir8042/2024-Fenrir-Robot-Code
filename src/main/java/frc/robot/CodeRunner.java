// package frc.robot;

// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.CommandScheduler;
// import edu.wpi.first.wpilibj2.command.Subsystem;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.Intake.motorPull;
// import frc.robot.commands.Intake.motorPush;
// import frc.robot.subsystems.RediktorSubsystem;
// import frc.robot.subsystems.IntakeSubsystem;

// import java.util.concurrent.*;

// public class CodeRunner {

//      private WPI_VictorSPX intakeMotor = new WPI_VictorSPX(Constants.IntakeConstans.intakePort);

//   final RediktorSubsystem r_RediktorSubsystem = new RediktorSubsystem();
//   final static IntakeSubsystem i_IntakeSubsystem = new IntakeSubsystem();

//   public static final Joystick stick = new Joystick(Constants.OI.kStickId);

//   private final JoystickButton button1 = new JoystickButton(stick, Constants.OI.button1);
//   private final JoystickButton button2 = new JoystickButton(stick, Constants.OI.button2);
//   private final static JoystickButton button3 = new JoystickButton(stick, Constants.OI.button3);
//   private final JoystickButton button4 = new JoystickButton(stick, Constants.OI.button4);
//   private final JoystickButton button5 = new JoystickButton(stick, Constants.OI.button5);
//   private final JoystickButton button6 = new JoystickButton(stick, Constants.OI.button6);
//   private final JoystickButton button7 = new JoystickButton(stick, Constants.OI.button7);
//   private final JoystickButton button8 = new JoystickButton(stick, Constants.OI.button8);
//   private final JoystickButton button9 = new JoystickButton(stick, Constants.OI.button9);
//   private final JoystickButton button10 = new JoystickButton(stick, Constants.OI.button10);
//   private final JoystickButton button11 = new JoystickButton(stick, Constants.OI.button11);
//   private final JoystickButton button12 = new JoystickButton(stick, Constants.OI.button12);
  
//     public static void main(String[] args) {
//         // Create an ExecutorService with a single thread
//         ExecutorService executor = Executors.newSingleThreadExecutor();

//         // Define the code block you want to run
//         Runnable codeBlock = () -> {
//             // Your code to be executed within the time limit
//             button3.whileTrue(new motorPull(i_IntakeSubsystem, -0.6f));
//             try {
//                 Thread.sleep(2000); // Simulating some time-consuming operation
//                 System.out.println("Code executed successfully!");
//             } catch (InterruptedException e) {
//                 System.out.println("Code execution interrupted!");
//             }
//         };

//         // Submit the code block to the executor
//         Future<?> future = executor.submit(codeBlock);

//         try {
//             // Set a time limit for the code to execute (in seconds)
//             long timeLimitInSeconds = 1;

//             // Wait for the code block to finish executing within the time limit
//             future.get(timeLimitInSeconds, TimeUnit.SECONDS);
//         } catch (InterruptedException | ExecutionException | TimeoutException e) {
//             // If the code execution is interrupted or exceeds the time limit
//             future.cancel(true); // Cancel the task if it's still running
//             System.out.println("Code execution timed out or interrupted!");
//         } finally {
//             // Shutdown the executor
//             executor.shutdown();
//         }
//     }
// }





