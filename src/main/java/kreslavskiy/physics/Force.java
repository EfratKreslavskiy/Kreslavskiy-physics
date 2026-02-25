package kreslavskiy.physics;

public class Force
{
    private final double x;
    private final double y;

    Force(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getMagnitude()
    {
        double mag = x * x + y * y;
        mag = Math.sqrt(mag);
        return mag;
    }

    public double getDegrees()
    {
        double radians = Math.atan2(y, x);
        double degrees = Math.toDegrees(radians);
        return degrees;
    }

    public Force addForce(Force f2)
    {
        return new Force(this.x + f2.getX(), this.y + f2.getY());
    }

    /**
     * @return a new force where the magnitude is 1 (divide x and y by magnitude)
     */
    public Force normalize()
    {
        double mag = getMagnitude();
        double x1 = x / mag;
        double y1 = y / mag;
        return new Force(x1, y1);
    }

    /**
     * @return a new force with x and y multiplied by scale
     */
    public Force scale(double scale)
    {
        Force newF = new Force(this.x * scale, this.y * scale);
        return newF;
    }

}

