// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.Constants.OI.Driver;
import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.spark.SparkBase;
import edu.wpi.first.math.MathUtil;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  SparkBase leftMotor;
  SparkBase rightMotor;
  public Drivetrain() {
leftMotor = MotorControllerFactory.createSpark(1, MotorConfig.NEO);
rightMotor = MotorControllerFactory.createSpark(2, MotorConfig.NEO);
}

public void arcadeDrive(double speed, double rotation){
  double leftSpeed = MathUtil.clamp(speed + rotation, -1.0, 1.0);
  double rightSpeed = MathUtil.clamp(speed - rotation, -1.0, 1.0);
  leftMotor.set(leftSpeed * Driver.MOTOR_SLOWDOWN);
  rightMotor.set(-rightSpeed * Driver.MOTOR_SLOWDOWN);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
