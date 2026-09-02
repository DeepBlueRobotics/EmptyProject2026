// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkBase;



public class Example extends SubsystemBase {
  SparkBase Motorname;
  /** Creates a new Example. */
  public Example() {
    Motorname = MotorControllerFactory.createSpark(1,MotorConfig.NEO);
  }

  public void spinMotor(double input){
    Motorname.set(input);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
