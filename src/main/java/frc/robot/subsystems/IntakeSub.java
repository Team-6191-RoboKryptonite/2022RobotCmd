// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {
  /** Creates a new Intake. */
  TalonSRX ball_in = new TalonSRX(Constants.Intake.kball_inPort);
  TalonSRX upanddown = new TalonSRX(Constants.Intake.kupanddownPort);
  

  public IntakeSub() {
    ball_in.setInverted(false);
    upanddown.setInverted(false);
    upanddown.setNeutralMode(NeutralMode.Brake);
  }

  public void intake(){
    ball_in.set(ControlMode.PercentOutput, Constants.Intake.kball_inSpeed);
  }

  public void Intakeup(){
      upanddown.set(ControlMode.PercentOutput, Constants.Intake.kupSpeed);
  }

  public void Intakedown(){
      upanddown.set(ControlMode.PercentOutput, Constants.Intake.kdownSpeed);
  }
  public void Intakestop(){
    ball_in.set(ControlMode.PercentOutput, Constants.Intake.kstopspeed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
