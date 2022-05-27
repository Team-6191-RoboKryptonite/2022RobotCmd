// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSub;

public class IntakeCmd extends CommandBase {
  /** Creates a new IntakeCmd. */
  
  private final Joystick m_stick0;
  private final IntakeSub intakesub;

  public IntakeCmd(IntakeSub intakesub, Joystick m_stick0) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_stick0 = m_stick0;
    this.intakesub = intakesub;

    addRequirements(intakesub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_stick0.getRawButtonPressed(Constants.Intake.ball_in_btn)){
      intakesub.intake();
    }
    if(m_stick0.getRawButtonReleased(Constants.Intake.ball_in_btn)){
      intakesub.Intakestop();
    }
    if(m_stick0.getRawButtonPressed(Constants.Intake.up_btn)){
      intakesub.Intakeup();
    }
    if(m_stick0.getRawButtonReleased(Constants.Intake.up_btn)){
      intakesub.Intakestop();
    }
    if(m_stick0.getRawButtonPressed(Constants.Intake.down_btn)){
      intakesub.Intakedown();
    }
    if(m_stick0.getRawButtonReleased(Constants.Intake.down_btn)){
      intakesub.Intakestop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
