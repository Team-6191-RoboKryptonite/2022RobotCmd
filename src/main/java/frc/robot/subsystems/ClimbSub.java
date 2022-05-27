// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSub extends SubsystemBase {
  /** Creates a new ClimbSub. */
  TalonSRX LiftLeft = new TalonSRX(Constants.Climb.LiftLeftPort);
  TalonSRX LiftRight = new TalonSRX(Constants.Climb.LiftRightPort);

  TalonSRX HangerMid = new TalonSRX(Constants.Climb.HangerMidPort);
  TalonSRX HangerSide = new TalonSRX(Constants.Climb.HangerSidePort);

  private final DigitalInput limit1 = new DigitalInput(Constants.Climb.limit1Port);
  private final DigitalInput limit2 = new DigitalInput(Constants.Climb.limit2Port);
  private final DigitalInput limit3 = new DigitalInput(Constants.Climb.limit3Port); 

  public ClimbSub() {
    LiftLeft.setInverted(false);
    LiftRight.setInverted(true);
  }

  public void LiftMove(double Speed){
    LiftLeft.set(ControlMode.PercentOutput, Speed);
  }

  public void HangerStep1(){
    HangerMid.set(ControlMode.PercentOutput, Constants.Climb.step1Speed);
    if(limit1.get())
      HangerMid.set(ControlMode.PercentOutput, Constants.Climb.stopSpeed);
  }

  public void HangerStep2(){
    HangerMid.set(ControlMode.PercentOutput, Constants.Climb.step2Speed);
    HangerSide.set(ControlMode.PercentOutput, Constants.Climb.step2Speed);
    if(limit2.get()){
      HangerMid.set(ControlMode.PercentOutput, Constants.Climb.stopSpeed);
      HangerSide.set(ControlMode.PercentOutput, Constants.Climb.stopSpeed);
    }
  }

  public void HangerStep3(){
    HangerSide.set(ControlMode.PercentOutput, Constants.Climb.step3Speed);
    if(limit3.get()){
      HangerSide.set(ControlMode.PercentOutput, Constants.Climb.stopSpeed);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
