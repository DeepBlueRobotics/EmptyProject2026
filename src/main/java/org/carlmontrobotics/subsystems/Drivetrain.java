// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkBaseConfig;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.carlmontrobotics.Constants.OI.Driver;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Subsystem1. */
  SparkBase leftMotor;
  private SparkClosedLoopController motorController;
  private SimpleMotorFeedforward motorFeedforward;
  public Drivetrain() {
    SparkBaseConfig config = MotorControllerFactory.sparkConfig(MotorConfig.NEO);
    config.closedLoop.pid(0.01, 0, 0);
    leftMotor = MotorControllerFactory.createSpark(Driver.LEFT_MOTOR_ID, MotorConfig.NEO, config);
    motorController = leftMotor.getClosedLoopController();

    motorFeedforward = new SimpleMotorFeedforward(Driver.kS, Driver.kV, Driver.kA);
  }
  public void tankDrive(double leftSpeed, double rightSpeed) {
    leftMotor.set(leftSpeed * Driver.MOTOR_SLOWDOWN);
  }

  public void arcadeDrive(double speed, double rotation) {
    double leftSpeed = MathUtil.clamp(speed + rotation, -1.0, 1.0);
    leftMotor.set(leftSpeed * Driver.MOTOR_SLOWDOWN);
  }
  public void runMotorPID(double targetSpeed) {
    motorController.setSetpoint(targetSpeed, ControlType.kVelocity);
  }

  public void runMotorFeedforward(double targetSpeed) {
    double feedForwardVolts = motorFeedforward.calculate(targetSpeed);
    motorController.setSetpoint(targetSpeed, ControlType.kVelocity, ClosedLoopSlot.kSlot0, feedForwardVolts);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
