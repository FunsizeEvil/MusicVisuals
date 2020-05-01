// 30/04/2020
// Daniel Foley
// c17335606
// https://github.com/FunsizeEvil/MusicVisuals

// Square.java exrtends TwodObject. java to give the parameters of the square
// and the functionlity of rendering the sqaure and updating it.
package c17335606;

// import processing.core.PVector;

public class Square extends TwodObject
{
    private float extent;

    public Square(SHAPE shape, float x, float y, float speed, float rotation, float extent)
    {
        super(shape, x, y, 0, speed);
        this.extent = extent;

    }

    // render the square object
    // 
    public void render()
    {
        shape.pushMatrix();
        shape.translate(pos.x, pos.y);
        shape.rotate(rotation);

        float halfSize = extent / 2;
        shape.stroke(0);
        shape.square(pos.x - halfSize,pos.y - halfSize, extent);
        shape.pushMatrix();

    }

    public void update()
    {
        movement.x = (float) Math.sin(rotation);
        movement.y = (float) Math.cos(rotation);

        rotation += getAmplitude() / 8.0f;

        rotateY(rotation);

        pos.x = movement.x;
    }
}