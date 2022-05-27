// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {
  /** Creates a new ShooterSub. */
  TalonSRX conveyor = new TalonSRX(Constants.Conveyor.conveyPort);
  TalonFX flywheelLeft = new TalonFX(Constants.Shooter.flywheelLeftPort);
  TalonFX flywheelRight = new TalonFX(Constants.Shooter.flywheelRightPort);
  TalonSRX driveLeft = new TalonSRX(Constants.Shooter.driveLeftPort);
  TalonSRX driveRight = new TalonSRX(Constants.Shooter.driveRightPort);
  TalonSRX panelmotor = new TalonSRX(Constants.Shooter.panelPort);
  boolean shoot;
  DigitalInput uplimit = new DigitalInput(Constants.Shooter.uplimitswitchPort);
  DigitalInput downlimit = new DigitalInput(Constants.Shooter.downlimitswitchPort);
  

  public ShooterSub() {
    flywheelLeft.setInverted(false);
    flywheelRight.setInverted(true);
    driveLeft.setInverted(true);
    driveRight.setInverted(false);
    panelmotor.setInverted(true);
    conveyor.setInverted(true);
  }


  public void shoot(double flySpeed, double driveSpeed, double convey) {
    flywheelLeft.set(ControlMode.PercentOutput, flySpeed);
    flywheelRight.set(ControlMode.PercentOutput, flySpeed);
    driveLeft.set(ControlMode.PercentOutput, driveSpeed);
    driveRight.set(ControlMode.PercentOutput, driveSpeed);
     Timer.delay(3);
    conveyor.set(ControlMode.PercentOutput, convey);
    
  }


  public void panelforward(){
    if(uplimit.get())
      panelmotor.set(ControlMode.PercentOutput, Constants.Shooter.panelstop);

    else 
      panelmotor.set(ControlMode.PercentOutput, Constants.Shooter.panelforwardSpeed);
  }

  public void panelbackward(){
    if(downlimit.get())
      panelmotor.set(ControlMode.PercentOutput, Constants.Shooter.panelstop);
    else
      panelmotor.set(ControlMode.PercentOutput, Constants.Shooter.panelbackwardSpeed);
  }

  public void stop(){
    flywheelLeft.set(ControlMode.PercentOutput, Constants.stopspeed);
    flywheelRight.set(ControlMode.PercentOutput, Constants.stopspeed);
    driveLeft.set(ControlMode.PercentOutput, Constants.stopspeed);
    driveRight.set(ControlMode.PercentOutput, Constants.stopspeed);
    conveyor.set(ControlMode.PercentOutput, Constants.stopspeed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
