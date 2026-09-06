// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.spark.SparkBase;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem1 extends SubsystemBase {
  /** Creates a new Subsystem1. */
  SparkBase motor;
  public Subsystem1() {
    motor = MotorControllerFactory.createSpark(1, MotorConfig.NEO);
  }

  public void spinMotor(double input) {
    motor.set(input);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
