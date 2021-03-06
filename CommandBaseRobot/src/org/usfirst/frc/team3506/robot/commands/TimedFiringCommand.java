package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedFiringCommand extends Command {
	double power;
	double timeout;

    public TimedFiringCommand(double speed, double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.firingMotorSubsystem);
    	power = speed;
    	timeout = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    	System.out.println("TimedFiring initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.firingMotorSubsystem.setMotor(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.firingMotorSubsystem.setMotor(0);
    	System.out.println("Timed Firing Ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
