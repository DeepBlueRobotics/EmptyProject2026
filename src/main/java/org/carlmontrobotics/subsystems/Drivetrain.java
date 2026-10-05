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
  SparkBase frontLeftMotor;
  SparkBase frontRightMotor;
  SparkBase backLeftMotor;
  SparkBase backRightMotor;
  boolean turnOnBackAxis;
  public Drivetrain() {
frontLeftMotor = MotorControllerFactory.createSpark(2, MotorConfig.NEO);
frontRightMotor = MotorControllerFactory.createSpark(3, MotorConfig.NEO);
backLeftMotor = MotorControllerFactory.createSpark(4, MotorConfig.NEO);
backRightMotor = MotorControllerFactory.createSpark(5, MotorConfig.NEO);
turnOnBackAxis = false;
}

/*public void tankDrive(double leftMotorSpeed, double rightMotorSpeed){
  leftMotor.set(leftMotorSpeed);
  rightMotor.set(rightMotorSpeed);
}*/

public void arcadeDrive(double speed, double rotation){
  double leftSpeed = MathUtil.clamp(speed + rotation, -1.0, 1.0);
  double rightSpeed = MathUtil.clamp(speed - rotation, -1.0, 1.0);
  frontLeftMotor.set(leftSpeed * Driver.MOTOR_SLOWDOWN);
  frontRightMotor.set(-rightSpeed * Driver.MOTOR_SLOWDOWN);
  backLeftMotor.set(leftSpeed * Driver.MOTOR_SLOWDOWN);
  backRightMotor.set(-rightSpeed * Driver.MOTOR_SLOWDOWN);
}

public void toggleBackAxis(boolean toggle){
  turnOnBackAxis = !turnOnBackAxis;
}
public void mecanumDrive(double forward, double strafe, double rotation){
  if (strafe == 0){
    arcadeDrive(forward, rotation);
  } else {
    double topLeftSpeed = forward + strafe + rotation;
    double topRightSpeed = forward - strafe - rotation;
    double bottomLeftSpeed ;
    double bottomRightSpeed;
    if (turnOnBackAxis == true && forward == 0 && strafe == 0){
      bottomLeftSpeed = 0;
      bottomRightSpeed = 0;
    } else{
      bottomLeftSpeed = forward - strafe + rotation;
      bottomRightSpeed = forward + strafe - rotation;
    }
    frontLeftMotor.set(MathUtil.clamp(topLeftSpeed, -1.0, 1.0) * Driver.MOTOR_SLOWDOWN);
    frontRightMotor.set(MathUtil.clamp(topRightSpeed, -1.0, 1.0) * Driver.MOTOR_SLOWDOWN);
    backLeftMotor.set(MathUtil.clamp(bottomLeftSpeed, -1.0, 1.0) * Driver.MOTOR_SLOWDOWN);
    backRightMotor.set(MathUtil.clamp(bottomRightSpeed, -1.0, 1.0) * Driver.MOTOR_SLOWDOWN);
  }
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
