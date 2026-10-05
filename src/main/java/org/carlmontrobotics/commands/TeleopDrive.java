// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import org.carlmontrobotics.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.Command;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TeleopDrive extends Command {
  /** Creates a new TellyopDrive. */
  Drivetrain drivetrain;
    DoubleSupplier forwardAxis;
    DoubleSupplier swerveAxis;
    DoubleSupplier rotationAxis;
    BooleanSupplier turnOnBackAxis;
  public TeleopDrive(Drivetrain drivetrain, DoubleSupplier forwardAxis, DoubleSupplier swerveAxis, DoubleSupplier rotationAxis, BooleanSupplier turnOnBackAxis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.forwardAxis = forwardAxis;
    this.swerveAxis = swerveAxis;
    this.rotationAxis = rotationAxis;
    this.turnOnBackAxis = turnOnBackAxis;
    addRequirements(drivetrain);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = forwardAxis.getAsDouble();
    double swerve = swerveAxis.getAsDouble();
    double rotation = rotationAxis.getAsDouble();
    boolean turnOnBackAxisEnabled = turnOnBackAxis.getAsBoolean();
    drivetrain.mecanumDrive(forward, swerve, rotation, turnOnBackAxisEnabled);
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
