// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSub;

public class ShooterCmd extends CommandBase {
  /** Creates a new ShooterCmd. */
  private final Joystick m_stick1;
  private final ShooterSub shootersub;


  public ShooterCmd(final ShooterSub shootersub, final Joystick m_stick1) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shootersub = shootersub;
    this.m_stick1 = m_stick1;

    addRequirements(shootersub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_stick1.getRawButton(Constants.Shooter.TarmacShootBtn)){
      shootersub.shoot(Constants.Shooter.TarmacflySpeed,
                       Constants.Shooter.TarmacdriveSpeed,
                       Constants.Conveyor.TarmacconveySpeed);
    }

    else if(m_stick1.getRawButton(Constants.Shooter.HPShootBtn)){
      shootersub.shoot(Constants.Shooter.HPflySpeed,
                       Constants.Shooter.HPdriveSpeed,
                       Constants.Conveyor.HPconveySpeed);
    }

    else if(m_stick1.getRawButton(Constants.Shooter.stopBtn)){
      shootersub.stop();
    }

    else if(m_stick1.getRawButton(Constants.Shooter.forward_btn)){
      shootersub.panelforward();
    }

    else if(m_stick1.getRawButton(Constants.Shooter.backward_btn)){
      shootersub.panelbackward();
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
