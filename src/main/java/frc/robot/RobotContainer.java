// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoCmd;
import frc.robot.commands.ChassisCmd;
import frc.robot.commands.ClimbCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.ShooterCmd;
import frc.robot.subsystems.ChassisSub;
import frc.robot.subsystems.ClimbSub;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.ShooterSub;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Joystick m_stick0 = new Joystick(Constants.kStickPort0);
  private final Joystick m_stick1 = new Joystick(Constants.kStickPort1);
  private final Timer timer = new Timer();

  //Subsystems
  private final ChassisSub chassissub = new ChassisSub();
  private final IntakeSub intakesub = new IntakeSub();
  private final ShooterSub shootersub = new ShooterSub();
  private final ClimbSub climbsub = new ClimbSub();
  

  //Command
  private final ChassisCmd chassiscmd = new ChassisCmd(chassissub, m_stick0, m_stick1);
  private final AutoCmd autocmd = new AutoCmd(chassissub, shootersub, timer);
  private final IntakeCmd intakecmd = new IntakeCmd(intakesub, m_stick0);
  private final ShooterCmd shootercmd = new ShooterCmd(shootersub, m_stick1);
  private final ClimbCmd climbcmd = new ClimbCmd(m_stick1, climbsub);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    chassissub.setDefaultCommand(chassiscmd);
    intakesub.setDefaultCommand(intakecmd);
    shootersub.setDefaultCommand(shootercmd);
    climbsub.setDefaultCommand(climbcmd);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autocmd;
  }
}
