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

- Your code must follow the principles of **abstraction** and **encapsulation**.
- Keep data fields **private**, and use **getter** and **setter** methods for any data fields that require external access.
- The setters should perform **validation** to only assign "reasonable" values to instance properties.
- Use the `this` keyword when referring to instance properties or methods within the class they belong to (e.g. `this.foo = 5;`)
- Use the class name when referring to static properties or methods (e.g. `Foo.bar();`)

### Interactive

Users must be able to interact with your game in some way and have the game visualization react meaningfully. Common interactions include clicking, hovering the mouse over a part of the visualization, or typing on the keyboard. Some helpful tips:

- When a user presses a key, Processing's code will automatically call any method named `keyPressed()`. The `key` instance property will automatically be assigned the key that was pressed, as as `char` value.
- When a user moves, clicks, or drags the mouse, Processing's code will automatically call any method named `mouseMoved()`, `mouseClicked()`, or `mouseDragged()`, respectively. The `mouseX` and `mouseY` instance properties will automatically hold the position of the mouse, measured from the top-left origin of the window.

