package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserDriveCommand extends Command {
	Joystick joystick;

	public UserDriveCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveSubsystem);
		requires(Robot.firingMotorSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		joystick = Robot.oi.getJoystick();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveSubsystem.drive(-joystick.getRawAxis(1) * 0.75,
				-joystick.getRawAxis(5) * 0.75);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
