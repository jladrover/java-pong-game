package edu.nyu.cs;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang3.SystemUtils;

import processing.core.*; // import the base Processing library
import processing.sound.*; // import the processing sound library

/**
 * Describe your game succinctly here, and update the author info below.
 * Some starter code has been included for your reference - feel free to delete or modify it.
 * 
 * @author Jean Luis Adrover Torres (https://github.com/jladrover)
 * @version 0.1
 */
public class Game extends PApplet {
  //game instance properties
  private SoundFile soundPongCollide; // will refer to a sound file to play when the ball collides with a surface
  PFont f;

  //height and width of window
  private int height = 600;
  private int width = 1200;

  //initiating Pongs objects
  private Pongs leftPong;
  private Pongs rightPong;

  //initializing Ball object
  private Ball gameBall;

  //properties for altering the ball speed and determining the winner 
  private int targetScore = 3;
  private int randNum = 0;
  Random random = new Random();


	/**
	 * This method will be automatically called by Processing when the program runs.
   * - Use it to set up the initial state of any instance properties you may use in the draw method.
	 */
	public void setup() {
    
    // load up a sound file and play it once when the user clicks
    this.soundPongCollide = new SoundFile(this, "sounds/Pong_Sound_Effect.mp3"); //CHANGE TO PONG SOUND
    
    this.rightPong = new Pongs(this, 1100, 500); 
    this.leftPong = new Pongs(this, 70, 100);
    this.gameBall = new Ball(this);
  
    f = createFont("Arial",16,true);
    
    
  }

	/**
	 * This method is called automatically by Processing every 1/60th of a second by default.
   * - Use it to modify what is drawn to the screen.
   * - There are methods for drawing various shapes, including `ellipse()`, `circle()`, `rect()`, `square()`, `triangle()`, `line()`, `point()`, etc.
	 */
	public void draw() {
    this.background(0, 0, 0); // fill the background black
    this.fill(256, 256, 256); // sets white color to use for filling in any shapes we draw later.

    //moves and displays the left pong paddle on the screen
    this.leftPong.move();
    this.leftPong.draw();

    //moves and displays the right pong paddle on the screen
    this.rightPong.move();
    this.rightPong.draw();

    //moves and displays the ball in the display
    this.gameBall.move();
    this.gameBall.draw();

    //executed only when a player has reached the target score
    this.gameOver();
    
    if (gameBall.getX() - gameBall.getRadius() * 2 < leftPong.getRightSide() && gameBall.getX()  > leftPong.getLeftSide() && gameBall.getY()> leftPong.getTopSide() && gameBall.getY() < leftPong.getBottomSide() ){
      if (gameBall.getSpeedX() > 0){
        this.gameBall.setSpeedX(this.gameBall.getSpeedX() + 1);
      }
      else{
        this.gameBall.setSpeedX(this.gameBall.getSpeedX() - 1);
      }
      this.gameBall.setSpeedX(-1 * this.gameBall.getSpeedX());
      this.soundPongCollide.play(2f,0f,0.5f,0f,0.7f);
    }

    if (gameBall.getX()  < rightPong.getRightSide() && gameBall.getX() > rightPong.getLeftSide() && gameBall.getY()> rightPong.getTopSide() && gameBall.getY() < rightPong.getBottomSide() ){
      if (gameBall.getSpeedX() > 0){
        this.gameBall.setSpeedX(this.gameBall.getSpeedX() + 1);
      }
      else{
        this.gameBall.setSpeedX(this.gameBall.getSpeedX() - 1);
      }
      this.gameBall.setSpeedX(-1 * this.gameBall.getSpeedX());
      this.soundPongCollide.play(2f,0f,0.5f,0f,0.7f);


  

    }

    // show the score at the bottom of the window
    String userscoreString = String.format("Player 1 Score: %d", this.gameBall.getPlayerOneScore());
    String cpuscoreString = String.format("Player 2 Score: %d", this.gameBall.getPlayerTwoScore());

    textFont(f,21);
    text(userscoreString, 130, this.height - 570);
    text(cpuscoreString, this.width - 300, this.height- 570);

	}

	/**
	 * This method is automatically called by Processing every time the user presses a key while viewing the map.
	 * - The `key` variable (type char) is automatically is assigned the value of the key that was pressed.
	 * - The `keyCode` variable (type int) is automatically is assigned the numeric ASCII/Unicode code of the key that was pressed.
   * - Moves the right pong paddle up and down if the up/down arrows are pressed on the keyboard
   * - Moves the left pong paddle up and down if the w/s keys are pressed on the keyboard
	 */
	public void keyPressed() {
    int key2 = this.key;
    if (this.key == PConstants.CODED) {
			switch (this.keyCode) {
				case PConstants.UP:
					this.rightPong.goUp(); //pong paddle moves up
					break;
        case PConstants.DOWN:
					this.rightPong.goDown(); //pong paddle moves down
					break;
			}
		}
    if (key2 == 'w'){
      this.leftPong.goUp();
    }
    else if (key2 == 's'){
      this.leftPong.goDown();
    }
		System.out.println(String.format("Key pressed: %s, key code: %d.", this.key, this.keyCode));
	}  
  
  /**
   * This function is called when one of the players' scores reaches the target score and resets the game while displaying the victor. 
   * It resets the ball speed and coordinates and allows a restart of the game if the mouse is clicked. 
   */
  public void gameOver(){
    if (this.gameBall.getPlayerOneScore() == this.targetScore){
      this.gameBall.setSpeedX(0);
      this.gameBall.setSpeedY(0);
      this.gameBall.setX(this.width / 2);
      this.gameBall.setY(this.height / 2);
      textFont(f,60);
      this.fill(256,0,0);
      text("Player one wins.", this.width / 3, this.height / 3);
      this.fill(256,256,256);
      text("Click to restart.", this.width / 3, this.height - 100);
      if (mousePressed){
        this.gameBall.setP1Score(0);
        this.gameBall.setP2Score(0);
        while (this.randNum == 0){
          this.randNum = random.nextInt(4 + 4) - 4;
        }
        this.gameBall.setSpeedX(randNum);
        this.gameBall.setSpeedY(2);
        this.randNum = 0;
      }
    }
    else if (this.gameBall.getPlayerTwoScore() == this.targetScore){
      this.gameBall.setSpeedX(0);
      this.gameBall.setSpeedY(0);
      this.gameBall.setX(this.width / 2);
      this.gameBall.setY(this.height / 2);
      textFont(f,60);
      this.fill(0,0,256);
      text("Player two wins.", this.width / 3, this.height / 3);
      this.fill(256,256,256);
      text("Click to restart.", this.width / 3, this.height - 100);
      if (mousePressed){
        this.gameBall.setP1Score(0);
        this.gameBall.setP2Score(0);
        while (this.randNum == 0){
          this.randNum = random.nextInt(4 + 4) - 4;
        }
        this.gameBall.setSpeedX(randNum);
        this.gameBall.setSpeedY(2);
        this.randNum = 0;
      }
    }


  }

  /**
   * A method that can be used to modify settings of the window, such as set its size.
   * This method shouldn't really be used for anything else.  
   * Use the setup() method for most other tasks to perform when the program first runs.
   */
  public void settings() {
		size(1200, 600); // set the map window size, using the OpenGL 2D rendering engine
		System.out.println(String.format("Set up the window size: %d, %d.", width, height));    
  }

  /**
   * The main function is automatically called first in a Java program.
   * When using the Processing library, this method must call PApplet's main method and pass it the full class name, including package.
   * You shouldn't need to modify this method.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) {
    // make sure we're using Java 1.8
		System.out.printf("\n###  JDK IN USE ###\n- Version: %s\n- Location: %s\n### ^JDK IN USE ###\n\n", SystemUtils.JAVA_VERSION, SystemUtils.getJavaHome());
		boolean isGoodJDK = SystemUtils.IS_JAVA_1_8;
		if (!isGoodJDK) {
			System.out.printf("Fatal Error: YOU MUST USE JAVA 1.8, not %s!!!\n", SystemUtils.JAVA_VERSION);
		}
		else {
			PApplet.main("edu.nyu.cs.Game"); // do not modify this!
		}
  }

}
