// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ChassisSub extends SubsystemBase {
  WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.Chassis.kFrontLeftChannel);
  WPI_TalonFX rearLeft = new WPI_TalonFX(Constants.Chassis.kRearLeftChannel);
  WPI_TalonFX frontRight = new WPI_TalonFX(Constants.Chassis.kFrontRightChannel);
  WPI_TalonFX rearRight = new WPI_TalonFX(Constants.Chassis.kRearRightChannel);

  /*NetworkTable shooter = NetworkTableInstance.getDefault().getTable("shooter_limelight");

  NetworkTableEntry Tapetx = shooter.getEntry("Tapetx");
  NetworkTableEntry Tapety = shooter.getEntry("Tapety");
  NetworkTableEntry Tapeta = shooter.getEntry("Tapeta");
  NetworkTableEntry Tapetv = shooter.getEntry("Tapetv");

  double Tarmacx = Tapetx.getDouble(0.0);
  double Tarmacy = Tapety.getDouble(0.0);
  double Tarmacarea = Tapeta.getDouble(0.0);
  double Tarmacvalue = Tapetv.getDouble(0.0);
  double Tarmacturn = Constants.Limelight.TarmacKp_aim * Tarmacx;
  double Tarmacrange = Constants.Limelight.TarmacKp_distance *(Constants.Limelight.Tarmacdesired_area - Tarmacarea);

  double HPx = Tapetx.getDouble(0.0);
  double HPy = Tapety.getDouble(0.0);
  double HParea = Tapeta.getDouble(0.0);
  double HPvalue = Tapetv.getDouble(0.0);
  double HPturn = Constants.Limelight.HPKp_aim * HPx;
  double HPrange = Constants.Limelight.HPKp_distance *(Constants.Limelight.HPdesired_area - HParea);*/

  public ChassisSub() {
    frontRight.setInverted(true);
    rearRight.setInverted(true);
    frontLeft.setNeutralMode(NeutralMode.Brake);
    rearLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    rearRight.setNeutralMode(NeutralMode.Brake);

    frontRight.set(ControlMode.PercentOutput, Constants.Chassis.kstopspeed);
    rearRight.set(ControlMode.PercentOutput, Constants.Chassis.kstopspeed);
    frontLeft.set(ControlMode.PercentOutput, Constants.Chassis.kstopspeed);
    rearLeft.set(ControlMode.PercentOutput, Constants.Chassis.kstopspeed);

    frontLeft.configFactoryDefault();
    rearLeft.configFactoryDefault();
    frontRight.configFactoryDefault();
    rearRight.configFactoryDefault();

    frontLeft.configNeutralDeadband(0.001);
    rearLeft.configNeutralDeadband(0.001);
    frontRight.configNeutralDeadband(0.001);
    rearRight.configNeutralDeadband(0.001);

    frontLeft.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 
                                           Constants.kPIDLoopIdx, 
                                           Constants.kTimeoutMs);
    rearLeft.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 
                                           Constants.kPIDLoopIdx, 
                                           Constants.kTimeoutMs);
    frontRight.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 
                                           Constants.kPIDLoopIdx, 
                                           Constants.kTimeoutMs);
    rearRight.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 
                                           Constants.kPIDLoopIdx, 
                                           Constants.kTimeoutMs);

    frontLeft.configNominalOutputForward(0, Constants.kTimeoutMs);
		frontLeft.configNominalOutputReverse(0, Constants.kTimeoutMs);
		frontLeft.configPeakOutputForward(1, Constants.kTimeoutMs);
		frontLeft.configPeakOutputReverse(-1, Constants.kTimeoutMs);

    rearLeft.configNominalOutputForward(0, Constants.kTimeoutMs);
		rearLeft.configNominalOutputReverse(0, Constants.kTimeoutMs);
		rearLeft.configPeakOutputForward(1, Constants.kTimeoutMs);
		rearLeft.configPeakOutputReverse(-1, Constants.kTimeoutMs);

    frontRight.configNominalOutputForward(0, Constants.kTimeoutMs);
		frontRight.configNominalOutputReverse(0, Constants.kTimeoutMs);
		frontRight.configPeakOutputForward(1, Constants.kTimeoutMs);
		frontRight.configPeakOutputReverse(-1, Constants.kTimeoutMs);

    rearRight.configNominalOutputForward(0, Constants.kTimeoutMs);
		rearRight.configNominalOutputReverse(0, Constants.kTimeoutMs);
		rearRight.configPeakOutputForward(1, Constants.kTimeoutMs);
		rearRight.configPeakOutputReverse(-1, Constants.kTimeoutMs);

    frontLeft.config_kF(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kF, Constants.kTimeoutMs);
		frontLeft.config_kP(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kP, Constants.kTimeoutMs);
		frontLeft.config_kI(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kI, Constants.kTimeoutMs);
		frontLeft.config_kD(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kD, Constants.kTimeoutMs);

    rearLeft.config_kF(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kF, Constants.kTimeoutMs);
		rearLeft.config_kP(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kP, Constants.kTimeoutMs);
		rearLeft.config_kI(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kI, Constants.kTimeoutMs);
		rearLeft.config_kD(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kD, Constants.kTimeoutMs);

    frontRight.config_kF(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kF, Constants.kTimeoutMs);
		frontRight.config_kP(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kP, Constants.kTimeoutMs);
		frontRight.config_kI(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kI, Constants.kTimeoutMs);
		frontRight.config_kD(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kD, Constants.kTimeoutMs);

    rearRight.config_kF(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kF, Constants.kTimeoutMs);
		rearRight.config_kP(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kP, Constants.kTimeoutMs);
		rearRight.config_kI(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kI, Constants.kTimeoutMs);
		rearRight.config_kD(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kD, Constants.kTimeoutMs);
  }
  
  public void ChassisStraight(double LeftY, double LeftX, double RightX){
    double vertical = -LeftY * 2000.0 * 2048.0 / 600.0;
    double horizontal = -LeftX * 2000.0 * 2048.0 / 600.0;
    double pivot = RightX * 2000.0 * 2048.0 / 600.0;

    frontRight.set(ControlMode.Velocity, ((-pivot + (vertical + horizontal))*Constants.Chassis.frStraightspeed));
    rearRight.set(ControlMode.Velocity, ((-pivot + (vertical - horizontal))*Constants.Chassis.rrStraightspeed));
    frontLeft.set(ControlMode.Velocity, ((pivot +(vertical - horizontal))*Constants.Chassis.flStraightspeed));
    rearLeft.set(ControlMode.Velocity, ((pivot + (vertical + horizontal))*Constants.Chassis.rlStraightspeed));
  }

  public void ChassisNotStraight(double LeftY, double LeftX, double RightX){
    double vertical = -LeftY * 2000.0 * 2048.0 / 600.0;
    double horizontal = -LeftX * 2000.0 * 2048.0 / 600.0;
    double pivot = RightX * 2000.0 * 2048.0 / 600.0;

    frontRight.set(ControlMode.Velocity, ((-pivot + (vertical + horizontal))*Constants.Chassis.frnotStraightspeed));
    rearRight.set(ControlMode.Velocity, ((-pivot + (vertical - horizontal))*Constants.Chassis.rrnotStraightspeed));
    frontLeft.set(ControlMode.Velocity, ((pivot +(vertical - horizontal))*Constants.Chassis.flnotStraightspeed));
    rearLeft.set(ControlMode.Velocity, ((pivot + (vertical + horizontal))*Constants.Chassis.rlnotStraightspeed));
  }

  public void ChassisStop(double stop){
    frontRight.set(ControlMode.PercentOutput, stop);
    rearRight.set(ControlMode.PercentOutput, stop);
    frontLeft.set(ControlMode.PercentOutput, stop);
    rearLeft.set(ControlMode.PercentOutput, stop);
  }

  public void ChassisAuto(double velocity){
    frontRight.set(ControlMode.Velocity, velocity * Constants.Chassis.frStraightspeed);
    rearRight.set(ControlMode.Velocity, velocity * Constants.Chassis.rrStraightspeed);
    frontLeft.set(ControlMode.Velocity, velocity * Constants.Chassis.flStraightspeed);
    rearLeft.set(ControlMode.Velocity, velocity * Constants.Chassis.rlStraightspeed);
  }

  /*public void Aim(double maxSpeed, double turn){
    if(turn > maxSpeed){
      frontRight.set(ControlMode.PercentOutput, -maxSpeed);
      rearRight.set(ControlMode.PercentOutput, -maxSpeed);
      frontLeft.set(ControlMode.PercentOutput, maxSpeed);
      rearLeft.set(ControlMode.PercentOutput, maxSpeed);
    }

    else if(turn < -maxSpeed){
      frontRight.set(ControlMode.PercentOutput, maxSpeed);
      rearRight.set(ControlMode.PercentOutput, maxSpeed);
      frontLeft.set(ControlMode.PercentOutput, -maxSpeed);
      rearLeft.set(ControlMode.PercentOutput, -maxSpeed);
    }

    else{
      frontRight.set(ControlMode.PercentOutput ,-turn);
      rearRight.set(ControlMode.PercentOutput ,-turn);
      frontLeft.set(ControlMode.PercentOutput ,turn);
      rearLeft.set(ControlMode.PercentOutput ,turn);
    }

  }*/

  //VELOCITY！！！！
  /*public void Range(double maxVel, double range){
   double rangeVel = range * 2000.0 * 2048.0 / 600.0;
   if(rangeVel > maxVel){
    frontRight.set(ControlMode.Velocity, maxVel * Constants.Chassis.frStraightspeed);
    rearRight.set(ControlMode.Velocity, maxVel * Constants.Chassis.rrStraightspeed);
    frontLeft.set(ControlMode.Velocity, maxVel * Constants.Chassis.flStraightspeed);
    rearLeft.set(ControlMode.Velocity, maxVel * Constants.Chassis.rlStraightspeed);
   }
   else if(rangeVel < -maxVel){
    frontRight.set(ControlMode.Velocity, -maxVel * Constants.Chassis.frStraightspeed);
    rearRight.set(ControlMode.Velocity, -maxVel * Constants.Chassis.rrStraightspeed);
    frontLeft.set(ControlMode.Velocity, -maxVel * Constants.Chassis.flStraightspeed);
    rearLeft.set(ControlMode.Velocity, -maxVel * Constants.Chassis.rlStraightspeed);
   }
   else{
    frontRight.set(ControlMode.Velocity, rangeVel * Constants.Chassis.frStraightspeed);
    rearRight.set(ControlMode.Velocity, rangeVel * Constants.Chassis.rrStraightspeed);
    frontLeft.set(ControlMode.Velocity, rangeVel * Constants.Chassis.flStraightspeed);
    rearLeft.set(ControlMode.Velocity, rangeVel * Constants.Chassis.rlStraightspeed);
   }
  }*/


  /*public double Tarmacturn(){
    return Tarmacturn;
  }

  public double HPturn(){
    return HPturn;
  }

  public double Tarmacrange(){
    return Tarmacrange;
  }

  public double HPrange(){
    return HPrange;
  }*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    
  }
}