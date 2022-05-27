// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int kSlotIdx = 0;

	/**
	 * Talon FX supports multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */
	public static final int kPIDLoopIdx = 0;

	/**
	 * Set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails.
	 */
    public static final int kTimeoutMs = 30;

	/**
	 * PID Gains may have to be adjusted based on the responsiveness of control loop.
     * kF: 1023 represents output value to Talon at 100%, 20660 represents Velocity units at 100% output
     * 
	 * 	                                    			  kP   	 kI    kD      kF          Iz    PeakOut */
    public final static Gains kGains_Velocit  = new Gains( 0.1, 0.001, 5, 1023.0/20660.0,  300,  1.00);

    public final static int kStickPort0 = 0;
    public final static int kStickPort1 = 1;

    public final static int stopspeed = 0;

    public static final class Autonomous{
        public static final double AutoSpeed = -0.2 * 2000.0 * 2048.0 / 600.0;
        public static final int AutoTime = 2;
        public static final double Autofly = 0.0;
        public static final double Autodrive = 0.0;
        public static final double Autoconvey = 0.0;
        public static final int Autogoal= 0;
    }

    public static final class Limelight{
        public static final double BallKp_aim = 0.0375;
        public static final double BallKp_distance = 0.7;
        public static final double Balldesired_area = 2.5;
        public static final double Ballmax_speed = 0.6;
        public static final double Ballmax_vel = 0.2 * 2000.0 * 2048.0 / 600.0;

        public static final double TarmacKp_aim = 0.0375;
        public static final double TarmacKp_distance = 0.7;
        public static final double Tarmacdesired_area = 2.5;
        public static final double Tarmacmax_speed = 0.6;
        public static final double Tarmacmax_vel = 0.2 * 2000.0 * 2048.0 / 600.0;

        public static final double HPKp_aim = 0.0375;
        public static final double HPKp_distance = 0.7;
        public static final double HPdesired_area = 2.5;
        public static final double HPmax_speed = 0.6;
        public static final double HPmax_vel = 0.2 * 2000.0 * 2048.0 / 600.0;
    }

    public static final class Chassis{
        public static final int kFrontLeftChannel = 1;
        public static final int kRearLeftChannel = 2;
        public static final int kFrontRightChannel = 3;
        public static final int kRearRightChannel = 4;

        public static final double frStraightspeed = 0.35;
        public static final double rrStraightspeed = 0.35;
        public static final double flStraightspeed = 0.32;
        public static final double rlStraightspeed = 0.24;

        public static final double frnotStraightspeed = 0.32;
        public static final double rrnotStraightspeed = 0.23;
        public static final double flnotStraightspeed = 0.37;
        public static final double rlnotStraightspeed = 0.16; 

        public static final double kstopspeed = 0;

        public static final int kStickLeftXPort = 0;
        public static final int kStickLeftYPort = 1;
        public static final int kStickRightXPort = 4;
        public static final int kNotStraightButton = 6;
        public static final int kStopButton = 5;

        public static final int IntakeAimBtn = 0;
        public static final int TarmacAimBtn = 0;
        public static final int HPAimBtn = 0;
    }

    public static final class Intake{
        public static final int kball_inPort = 14;
        public static final int kupanddownPort = 15; 
        public static final double kball_inSpeed = 0.3;
        public static final double kupSpeed = -0.4;
        public static final double kdownSpeed = 0.4;
        public static final double kstopspeed = 0.0;

        public static final int ball_in_btn = 1;
        public static final int up_btn = 2;
        public static final int down_btn = 3;
    
    } 

    public static final class Conveyor{
        public static final int conveyPort = 0;
        public static final int conveyBtn = 0;
        public static final double TarmacconveySpeed = 0;
        public static final double HPconveySpeed = 0.0;
        public static final double conveySpeed = 0.6;
    }
    
    public static final class Shooter{
        public static final int flywheelLeftPort = 0;
        public static final int flywheelRightPort = 0;
        public static final int driveLeftPort = 0;
        public static final int driveRightPort = 0;
        public static final int panelPort = 0;
        public static final int uplimitswitchPort = 0;
        public static final int downlimitswitchPort = 0;

        public static final int TarmacShootBtn = 0;
        public static final int HPShootBtn = 0;
        public static final int forward_btn = 0;
        public static final int backward_btn = 0;
        public static final int stopBtn = 0;

        public static final double panelforwardSpeed = 0.2;
        public static final double panelbackwardSpeed = -0.2;
        public static final double panelstop = 0.0;
        public static final double TarmacflySpeed = 0.0;
        public static final double TarmacdriveSpeed = 0.0;
        public static final double HPflySpeed = 0.0;
        public static final double HPdriveSpeed = 0.0;
        public static final int Tarmac_flyGoalVel = 0;
        public static final int HP_flyGoalVel = 0;
        public static final double flySpeed = 0.0;
        public static final double driveSpeed = 0.0;
        //driveSpeed >= 0.3
    }

    public static final class Climb{
        public static final int LiftLeftPort = 0;
        public static final int LiftRightPort = 0; 
        public static final double liftSpeed = 0.0;
        public static final double downSpeed = 0.0;
        public static final int liftBtn = 0;
        public static final int downBtn = 0;

        public static final int HangerMidPort = 0;
        public static final int HangerSidePort = 0;
        public static final double step1Speed = 0.0;
        public static final double step2Speed = 0.0;
        public static final double step3Speed = 0.0;
        public static final double stopSpeed = 0;
        public static final int step1Btn = 0;
        public static final int step2Btn = 0;
        public static final int step3Btn = 0;

        public static final int limit1Port = 0;
        public static final int limit2Port = 0;
        public static final int limit3Port = 0;
    }
}
