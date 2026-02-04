public class Force
{
    private double x;
    private double y;
    private double magnitude;
    private double degrees;

    public Force(double x1, double y1)
    {
        x = x1;
        y = y1;
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
        double mag = x*x + y*y;
        mag = Math.sqrt(mag);
        magnitude = mag;
        return mag;
    }

    public double getDegrees()
    {
        double radians = Math.atan2(y, x);
        degrees = Math.toDegrees(radians);
        return degrees;
    }

    public Force addForce(Force f2)
    {
        return new Force(this.getX()+f2.getX(), f2.getY()+this.getY());
    }

    /**
     * @return a new force where the magnitude is 1 (divide x and y by magnitude)
     */
    public Force normalize()
    {
        double mag = getMagnitude();
        double x1 = getX()/mag;
        double y1 = getY()/mag;
        return new Force(x1, y1);
    }

    /**
     * @return a new force with x and y multiplied by scale
     */
    public Force scale(double scale)
    {
        Force newF = new Force(this.x*scale, this.y*scale);
        return newF;
    }

    /*
    public static void main(String[] args)
    {
        Force F1 = new Force(7, 3);
        Force F2 = new Force(-4, 12);
        Force F3 = F1.addForce(F2);

        System.out.println("F1: (" + F1.getX() + "," + F1.getY() + ") \tDegrees: " + F1.getDegrees() + "\tMagnitude: " + F1.getMagnitude());
        System.out.println("F2: (" + F2.getX() + "," + F2.getY() + ") Degrees: " + F2.getDegrees() + "\tMagnitude: " + F2.getMagnitude());
        System.out.println("F3: (" + F3.getX() + "," + F3.getY() + ") \tDegrees: " + F3.getDegrees() + "\tMagnitude: " + F3.getMagnitude());
    }
    */
}

