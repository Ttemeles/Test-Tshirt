// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically it contains the code
 * necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {

  //declare motors

  WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeft_SRX);
  WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRight_SRX);
  WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.backLeft_SRX);
  WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.backRight_SRX);

  WPI_TalonSRX tilter = new WPI_TalonSRX(RobotMap.Tilter_SRX);
  
  //Speed Controller Groups
  SpeedController left = new SpeedControllerGroup(frontLeft, frontRight);
  SpeedController right = new SpeedControllerGroup ( frontRight, backRight);
 
 
  @Override
  public void robotInit() {
  

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
