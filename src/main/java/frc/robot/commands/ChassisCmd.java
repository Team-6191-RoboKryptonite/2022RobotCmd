// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ChassisSub;

public class ChassisCmd extends CommandBase {
  /** Creates a new Chassiscmd. */

  private final Joystick m_stick0;
  private final Joystick m_stick1;
  private final ChassisSub chassissub;

  public ChassisCmd(ChassisSub chassissub, Joystick m_stick0, Joystick m_stick1) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.chassissub = chassissub;
    this.m_stick0 = m_stick0;
    this.m_stick1 = m_stick1;

    addRequirements(chassissub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //shoot ball
    //get out of tarmac

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    chassissub.ChassisStraight(m_stick0.getRawAxis(Constants.Chassis.kStickLeftYPort),
                               m_stick0.getRawAxis(Constants.Chassis.kStickLeftXPort), 
                               m_stick0.getRawAxis(Constants.Chassis.kStickRightXPort));
    if(m_stick0.getRawButton(Constants.Chassis.kNotStraightButton)){
      chassissub.ChassisNotStraight(m_stick0.getRawAxis(Constants.Chassis.kStickLeftYPort),
                                    m_stick0.getRawAxis(Constants.Chassis.kStickLeftXPort), 
                                    m_stick0.getRawAxis(Constants.Chassis.kStickRightXPort));
    }
    else if(m_stick0.getRawButton(Constants.Chassis.kStopButton)){
      chassissub.ChassisStop(Constants.Chassis.kstopspeed);
    }

    /*else if(m_stick1.getRawButton(Constants.Chassis.TarmacAimBtn)){
      chassissub.Aim(Constants.Limelight.Tarmacmax_speed, chassissub.Tarmacturn());
      chassissub.Range(Constants.Limelight.Tarmacmax_vel, chassissub.Tarmacrange());
    }
    else if(m_stick1.getRawButton(Constants.Chassis.HPAimBtn)){
      chassissub.Aim(Constants.Limelight.HPmax_speed, chassissub.HPturn());
      chassissub.Range(Constants.Limelight.HPmax_vel, chassissub.HPrange());
    }*/
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
