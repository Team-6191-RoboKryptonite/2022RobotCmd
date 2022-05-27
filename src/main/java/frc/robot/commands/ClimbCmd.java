// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ClimbSub;

public class ClimbCmd extends CommandBase {
  /** Creates a new Climb. */
  private final Joystick m_stick1;
  private final ClimbSub climbsub;
  

  public ClimbCmd(Joystick m_stick1, ClimbSub climbsub) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_stick1 = m_stick1;
    this.climbsub = climbsub;

    addRequirements(climbsub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_stick1.getRawButton(Constants.Climb.liftBtn)){
      climbsub.LiftMove(Constants.Climb.liftSpeed);
    }
    else if(m_stick1.getRawButton(Constants.Climb.downBtn)){
      climbsub.LiftMove(Constants.Climb.downSpeed);
    }
    else if(m_stick1.getRawButton(Constants.Climb.step1Btn)){
      climbsub.HangerStep1();
    }
    else if(m_stick1.getRawButton(Constants.Climb.step2Btn)){
      climbsub.HangerStep2();
    }
    else if(m_stick1.getRawButton(Constants.Climb.step3Btn)){
      climbsub.HangerStep3();
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
