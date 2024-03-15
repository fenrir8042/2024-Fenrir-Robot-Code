// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class motorPush extends Command {
  IntakeSubsystem i_IntakeSubsystem;
  double speed;

  public motorPush(IntakeSubsystem i_IntakeSubsystem, double speed) {
    this.i_IntakeSubsystem = i_IntakeSubsystem;
    this.speed = speed;

    addRequirements(i_IntakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    i_IntakeSubsystem.motorPush();

  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
