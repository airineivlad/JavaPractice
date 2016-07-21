package AV;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * PatratForever - a robot by (your name here)
 */
public class PatratForever extends Robot
{
	/**
	 * run: PatratForever's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		
		long numarPatrate=0;
		// Robot main loop
		while(true) {
			//sa se intoarca odata la stanga, odata la dreapta
			if(numarPatrate%2==0){
				moveInSquare(160);
			}else{
				for(int j=0;j<4;j++){
					ahead(160); // merge o latura de 160
					turnLeft(90); // se intoarce
				}
			}
			numarPatrate++;
		}
		
		System.out.println(numarPatrate);
	}
	
	public void moveInSquar(int lengthOfSide){
		for(int j=0;j<4;j++){
					ahead(lengthOfSide); // merge o latura de 160
					turnRight(90); // se intoarce
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
