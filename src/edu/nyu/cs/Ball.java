package edu.nyu.cs;

import static org.mockito.ArgumentMatchers.booleanThat;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Program that creates the ball object for the pong game and properties for the ball's collision with the environment
 *
 * @author Jean Luis Adrover Torres ja4146
 * @version 0.1 
 */
public class Ball {
    //ball object and its properties
    private Game game;
    private final int circle_radius = 12;
    private int x = 600;
	private int y = 300;
    private int speedX = -2;
    private int speedY = 2;

    //random num initialized
    private int randNum = 0;

    //window size properties
    private int width = 1200;
    private int height = 600;

    //score variables 
    private int p1Score = 0;
    private int p2Score = 0;
    Random random = new Random();
    
    /**
    * Gets the value of the ball's x-coordinate on the screen
    * @return int x coordinate of the ball
    */
    public int getX(){
        return this.x;
    }

    /**
    * Gets the value of the radius of the ball (a circle created through the processing ellipse method).
    * @return int radius of the ball.
    */
    public int getRadius(){
        return this.circle_radius;
    }

    /**
    * Sets the value of the ball's x-coordinate on the screen.
    * @param int to set as the ball's x-coordinate.
    */
    public void setX(int x){
        this.x = x;
    }
    
    /**
    * Gets the value of the ball's y-coordinate on the screen.
    * @return int y coordinate of the ball.
    */
    public int getY(){
        return this.y;
    }

    /**
    * Sets the value of the ball's y-coordinate on the screen.
    * @param int to set as the ball's y-coordinate.
    */
    public void setY(int y){
        this.y = y;
    }

    /**
    * Sets reference to current object in the form of an instance variable.
    * @param game reference to game object.
    */
    public Ball(Game game){
        this.game = (Game) game;
    }

    /**
    * Sets the value of the ball speed's scalar x-value.
    * @param int value to set the rate of which the ball moves through the screen by the x-axis.
    */
    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }

    /**
    * Gets the value of the ball speed's scalar x-value.
    * @return int x value of which the ball moves through the screen by.
    */
    public int getSpeedX(){
        return speedX;
    }

    /**
    * Sets the value of the ball speed's scalar y-value.
    * @param int value to set the rate of which the ball moves through the screen by the y axis.
    */
    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }

    /**
    * Gets the value of the ball speed's scalar y-value.
    * @return int y value of which the ball moves through the screen by.
    */
    public int getSpeedY(){
        return speedY;
    }

    /**
    * Sets the value of the left player's score.
    * @param int value to set player one's score to.
    */
    public void setP1Score(int score){
        this.p1Score = score;
    }

    /**
    * Sets the value of the right player's score.
    * @param int value to set player two's score to.
    */
    public void setP2Score(int score){
        this.p2Score = score;
    }

    /**
    * Moves the ball across the screen by changing both x/y instances by the speed additive.
    * If the ball reaches a coordinate deemed "out of bounds", its location is reset to the middle.
    * When the ball is scored (meaning reaching the left or right bounds), it is reset to the middle with a random speed from -3 to 3 not including zero.
    * The players' scores iterate by 1 based on which side that the ball is scored. 
    */
    public void move(){
        this.x = this.x + this.speedX; //move in the x  direction.
	    this.y = this.y + this.speedY; //move in the y  direction.
        boolean outOfBoundsUp = this.y < 0;
		boolean outOfBoundsDown = this.y >  this.height;
        boolean outOfBoundsLeft = this.x < 0;
        boolean outOfBoundsRight = this.x > this.width;
        if (outOfBoundsUp || outOfBoundsDown){
            this.speedY = this.speedY * -1;
        }
        if (outOfBoundsLeft){
            this.y = this.height / 2;
            this.x = this.width / 2;
            while (randNum == 0){
                this.randNum = random.nextInt(4 + 4) - 4;
              }
              this.speedX = randNum;
              this.randNum = 0;
            
            this.p2Score++;
        }
        if (outOfBoundsRight){
            this.y = this.height / 2;
            this.x = this.width / 2;
            while (randNum == 0){
                this.randNum = random.nextInt(4 + 4) - 4;
              }
              this.speedX = randNum;
              this.randNum = 0;
            this.p1Score++;
        }
    }

    /**
    * Gets the value of the left player's score.
    * @return int score value of player one.
    */
    public int getPlayerOneScore(){
        return this.p1Score;
    }
    
    /**
    * Gets the value of the right player's score.
    * @return int score value of player two.
    */
    public int getPlayerTwoScore(){
        return this.p2Score;
    }

    /**
    * Draws the current object as an ellipse according to the values of the instance properties.
    */
    public void draw(){
        this.game.ellipse(this.x, this.y, this.circle_radius * 2, this.circle_radius * 2);
    }


}
