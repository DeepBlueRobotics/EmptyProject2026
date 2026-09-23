// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.commands;

import edu.wpi.first.wpilibj2.command.Command;

import org.carlmontrobotics.subsystems.MySubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MyCommand extends Command {
  /** Creates a new MyCommand. */
  MySubsystem mysubsystem;
  public MyCommand(MySubsystem mysubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.mysubsystem = mysubsystem;
    addRequirements(mysubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mysubsystem.runMotor(0.2);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
