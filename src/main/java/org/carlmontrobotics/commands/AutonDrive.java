// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.commands;

import org.carlmontrobotics.subsystems.DriveTrainAuto;

import edu.wpi.first.wpilibj2.command.Command;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutonDrive extends Command {
  /** Creates a new TellyopDrive. */
  DriveTrainAuto driveTrainAuto;
  public AutonDrive(DriveTrainAuto drivetrainauto) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrainAuto = drivetrainauto;
    addRequirements(drivetrainauto);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

public void singleAutonCommand(double speed, double rotation){
  double Speed = speed;
  double Rotation = rotation;
  driveTrainAuto.arcadeDriveAuto(Speed, Rotation);
}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    singleAutonCommand(0.5,0);
    singleAutonCommand(0,0.5);
    singleAutonCommand(0,0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
