// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Climb;

import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class climbDown extends Command {
  ClimbSubsystem c_ClimbSubsystem;
  double speed;

  public climbDown(ClimbSubsystem c_ClimbSubsystem, double speed) {
    this.c_ClimbSubsystem = c_ClimbSubsystem;
    this.speed = speed;

    addRequirements(c_ClimbSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    c_ClimbSubsystem.climbPull();
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
