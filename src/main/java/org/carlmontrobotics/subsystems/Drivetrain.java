// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.config.SparkBaseConfig;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.carlmontrobotics.Constants.OI.Driver;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Subsystem1. */
  SparkBase leftMotor;
  SparkBase rightMotor;
  public Drivetrain() {
    SparkBaseConfig config = MotorControllerFactory.sparkConfig(MotorConfig.NEO);
    config.closedLoop.pid(0.01, 0, 0);
    leftMotor = MotorControllerFactory.createSpark(Driver.LEFT_MOTOR_ID, MotorConfig.NEO, config);
    rightMotor = MotorControllerFactory.createSpark(Driver.RIGHT_MOTOR_ID, MotorConfig.NEO, config);
  }
  public void tankDrive(double leftSpeed, double rightSpeed) {
    leftMotor.set(leftSpeed * Driver.MOTOR_SLOWDOWN);
    rightMotor.set(-rightSpeed * Driver.MOTOR_SLOWDOWN);
  }

  public void arcadeDrive(double speed, double rotation) {
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
