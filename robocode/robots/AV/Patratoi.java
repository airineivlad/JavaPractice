package AV;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Patratoi - a robot by (your name here)
 */
public class Patratoi extends Robot
{
	/**
	 * run: Patratoi's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		Patratoi p = new Patratoi();
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		
		setColors(Color.blue,Color.blue,Color.green); // body,gun,radar
		
		// Robot main loop
		while(true) {
			
			ahead(160);
			
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
