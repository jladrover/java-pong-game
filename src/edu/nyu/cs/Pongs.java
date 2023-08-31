package edu.nyu.cs;

import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Program to create Pong game paddle objects and properties for collision detection
 *
 * @author Jean Luis Adrover Torres ja4146
 * @version 0.1 
 */
public class Pongs {
    // instance properties
    private Game game; // will hold a reference to the main Game object

    //pong paddle properties
    private int pongWidth = 20;
    private int pongLength = 100;
    private int x; 
    private int y;
    private int rightCollisionSide;
    private int leftCollisionSide;
    private int topCollisionSide;
    private int bottomCollisionSide;
    private int speedY = 12;
    
    
    /**
     * Constructor to create a Pong object at a specific position on the screen
     * @param app a reference to the Game object that created this object
     * @param x the x coordinate of the pong object on the screen
     * @param y the y coordinate of the pong object on the screen
     */
    public Pongs(Game game, int x, int y) {
        this.game = game; // store a reference to the main game object
        // store the x and y coordinates of this object on the screen
        this.x = x;
        this.y = y;
        
    }

    /**
    * Gets the value of the pong paddle's x-coordinate on the screen.
    * @return int x coordinate of the pong paddle.
    */
    public int getX(){
        return this.x;
    }

    /**
    * Gets the value of the pong paddle's y-coordinate on the screen.
    * @return int y coordinate of the pong paddle.
    */
    public int getY(){
        return this.y;
    }
    
    /**
    * Initializes the y-axis bounds of which the pong paddles cannot move past.
    */
    public void move() {
		//check bounds
		boolean outOfBoundsUp = this.y < 0;
		boolean outOfBoundsDown = this.y >  500;
		if (outOfBoundsUp){ 
			this.y = 0;
		}
        if (outOfBoundsDown){
            this.y = 500;
        }
	}

    /**
	 * Move pongs in the opposite  direction from which it is currently moving
	 */
	public void toggleDirection() {
		this.speedY = -this.speedY; //invert the  sign of the speed it's currently moving
	}

    /**
    * Gets the value of the pong paddle's left value on the screen according to the x-axis.
    * @return int x coordinate of the pong paddle's left side.
    */
    public int getLeftSide(){
        this.leftCollisionSide = this.x - this.pongWidth / 2;
        return this.leftCollisionSide;
    }

    /**
    * Gets the value of the pong paddle's right value on the screen according to the x-axis.
    * @return int x coordinate of the pong paddle's right side.
    */
    public int getRightSide(){
        this.rightCollisionSide = this.x + this.pongWidth / 2;
        return this.rightCollisionSide;
    }

    /**
    * Gets the value of the pong paddle's top value on the screen according to the y-axis.
    * @return int x coordinate of the pong paddle's top side.
    */
    public int getTopSide(){
        this.topCollisionSide = this.y - this.pongLength / 4;
        return this.topCollisionSide;
    }

    /**
    * Gets the value of the pong paddle's bottom value on the screen according to the y-axis.
    * @return int x coordinate of the pong paddle's bottom side.
    */
    public int getBottomSide(){
        this.bottomCollisionSide = this.y + this.pongLength;
        return this.bottomCollisionSide;
    }

    /**
    * Decreases y-coordinate instance value to move the pong paddle up the screen.
    */
    public void goUp() {
		//set speed to a negative value
		this.y = this.y - Math.abs(this.speedY);

	}

    /**
    * Increases y-coordinate instance value to move the pong paddle down the screen.
    */
    public void goDown() {
		//set speed to a negative value
		this.y = this.y + Math.abs(this.speedY);

	}

    /**
     * Draws both pong paddles to the screen at the appropriate coordinates
     */
    public void draw() {
        // draw this object's image at its x and y coordinates
        this.game.rect(this.x, this.y, pongWidth, pongLength);
    }

}
