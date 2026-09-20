// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import org.carlmontrobotics.Constants.OI.Driver;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem1 extends SubsystemBase {
  SparkBase motor;
  private SparkBaseConfig motorConfig;
  private SparkClosedLoopController pidcontroller;
  RelativeEncoder motorEncoder;
  
  /** Creates a new Subsystem1. */
  public Subsystem1() {
    ConfigureMotor();
    motor = MotorControllerFactory.createSpark(1, MotorConfig.NEO);
    pidcontroller = motor.getClosedLoopController();
    motorEncoder = motor.getEncoder();
  }

  private void ConfigureMotor() {
    motorConfig = MotorControllerFactory.sparkConfig(MotorConfig.NEO);
    motorConfig.idleMode(IdleMode.kCoast);
    motorConfig.closedLoop.pid(Driver.kP, Driver.kI, Driver.kD);
  }

public void setRPM(double rpm) {
  pidcontroller.setSetpoint(rpm, ControlType.kVelocity);
  
}

public void spinMotor(double input){
  motor.set(input);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
