// 30/04/2020
// Daniel Foley
// c17335606
// https://github.com/FunsizeEvil/MusicVisuals

// TwodObject creates an object that a shape class can extend.
// it gives paramters for the new shape classes such Square.java
// to use and also gives it PVector parametrs.
package c17335606;

import ie.tudublin.Visual;
import processing.core.PVector;


public abstract class TwodObject extends Visual
{
    //private classes
    //
    protected PVector pos;
    protected PVector movement;
    protected float rotation;
    protected float speed;
    protected SHAPE shape;

    public TwodObject(SHAPE shape, float x, float y, float rotation, float speed)
    {
        this.shape = shape;
        pos = new PVector(x, y);
        movement = new PVector(0, -1);
        this.rotation = rotation;
        this.speed = speed;
    }

    public abstract void update();
    public abstract void render();

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the movement
     */
    public PVector getMovement() {
        return movement;
    }

    /**
     * @param movement the movement to set
     */
    public void setMovement(PVector movement) {
        this.movement = movement;
    }

    /**
     * @return the rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the shape
     */
    public SHAPE getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(SHAPE shape) {
        this.shape = shape;
    }
}
