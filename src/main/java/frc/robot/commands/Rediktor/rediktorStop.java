// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Rediktor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RediktorSubsystem;

public class rediktorStop extends Command {
  RediktorSubsystem r_RediktorSubsystem;
  double speed;

  public rediktorStop(RediktorSubsystem r_RediktorSubsystem, double speed) {
    this.r_RediktorSubsystem = r_RediktorSubsystem;
    this.speed = speed;

    addRequirements(r_RediktorSubsystem);
  }

  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    r_RediktorSubsystem.rediktorStop();
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