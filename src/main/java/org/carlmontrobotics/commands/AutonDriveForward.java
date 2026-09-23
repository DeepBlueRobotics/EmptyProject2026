// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.commands;

import org.carlmontrobotics.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.Timer;

import org.carlmontrobotics.Constants.AutonTimer;
import org.carlmontrobotics.Constants.AutonTimer.*;

import edu.wpi.first.wpilibj2.command.Command;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutonDriveForward extends Command {
    /** Creates a new TellyopDrive. */
    Drivetrain drivetrain;
    Timer timer = new Timer();
    public AutonDriveForward(Drivetrain drivetrain) {
      // Use addRequirements() here to declare subsystem dependencies.
      this.drivetrain = drivetrain;
      addRequirements(drivetrain);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      timer.restart();
      drivetrain.arcadeDrive(-0.25, 0.0);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      drivetrain.arcadeDrive(0.0,0.0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return timer.get() >= AutonTimer.END_TIMER;
  }
}