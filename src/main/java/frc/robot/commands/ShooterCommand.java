package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand {

      private ShooterSubsystem shooterSubsystem;

    public void ShooterCommands(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
    }


    public Command startShooter(double speed) {
        return new FunctionalCommand(
                () -> {},
                () -> shooterSubsystem.setSpeed(speed),
                interrupted -> shooterSubsystem.stopFlywheels(),
                () -> false,
                shooterSubsystem
        );
    }
}
    
    

