// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.DistributionHub.PowerDistributionHub;
import frc.robot.Lift.Lift;
import frc.robot.Shooter.ShooterContainer;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  public ShooterContainer m_operatorController;
  public Lift ArmOperatorController;
  public PowerDistributionHub PowerDistributionHub;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer(); // Initalize Xbox controller for swerve drives
    m_operatorController = new ShooterContainer(); // Initalize Xbox controller for for shooter
    ArmOperatorController = new Lift(); // Initalize Xbox controller for arms
    PowerDistributionHub = new PowerDistributionHub();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    ArmOperatorController.getLimitSwitch(); 
  }

  @Override
  public void disabledInit() {/* place commands here */}

  @Override
  public void disabledPeriodic() {/* place commands here */}

  @Override
  public void disabledExit() {/* place commands here */}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    m_robotContainer.teleopPeriodic();
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  @Override
  public void simulationPeriodic() {}
}
