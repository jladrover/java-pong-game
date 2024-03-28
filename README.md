# Reuploaded assignment - 10/2021

## Game Development

Develop a game using object-oriented programming in Java and the [Processing](https://processing.org) framework.

The goal of this assignment is to give you hands-on experience writing well-written object-oriented code in Java.

## Authors

This game was created by:

- github.com/jladrover

### Starter code

Some starter code has been included in order to show some basic concepts of working with well-structured object-oriented code using the Processing framework. You should delete or modify this code as necessary to complete your own game.

_Your game should be nothing like the starter code example game_.


### Object orientated principles

- Follows the principles of **abstraction** and **encapsulation**.
- Keeps data fields **private**, and use **getter** and **setter** methods for any data fields that require external access.
- The setters should perform **validation** to only assign "reasonable" values to instance properties.
- Use the `this` keyword when referring to instance properties or methods within the class they belong to (e.g. `this.foo = 5;`)
- Use the class name when referring to static properties or methods (e.g. `Foo.bar();`)

### Interactive

- When a user presses a key, Processing's code will automatically call any method named `keyPressed()`. The `key` instance property will automatically be assigned the key that was pressed, as as `char` value.
- When a user moves, clicks, or drags the mouse, Processing's code will automatically call any method named `mouseMoved()`, `mouseClicked()`, or `mouseDragged()`, respectively. The `mouseX` and `mouseY` instance properties will automatically hold the position of the mouse, measured from the top-left origin of the window.

### Features

- Two-player gameplay with keyboard controls ('W' and 'S' for left paddle, UP and DOWN arrows for right paddle).
- Increasing ball speed with each paddle collision for challenging gameplay.
- Custom collision sound effect for an immersive experience.
- Victory message and game reset option upon reaching the target score.
- Customizable game window size and score settings.

### Installation

- Ensure Java 1.8 is installed on your system.
- Download the Processing core library and the Processing sound library.
- Clone the repository or download the game files.
- Open the project in an IDE that supports Java and Processing (e.g., Eclipse, IntelliJ IDEA).
- Add the Processing core and sound library jars to your project's build path.
- Run Game.java to start the game.
  
### Controls

Left Paddle: 'W' key to move up, 'S' key to move down.
Right Paddle: UP arrow to move up, DOWN arrow to move down.
Click to restart the game after a win.


## Enjoy!
