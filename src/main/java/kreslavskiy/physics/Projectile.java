package kreslavskiy.physics;

public class Projectile {
    private Force force;
    private double x;
    private double y;

    public static final Force gravity = new Force(0, -9.8);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Projectile(double x, double y, Force force) {
        this.x = x;
        this.y = y;
        this.force = force;
    }

    //changes x and y based on gravity and force of projectile
    public void apply(double time) {
        Force scaledGravity = gravity.scale(time);
        force = force.addForce(scaledGravity);
        Force scaledForce = force.scale(time);

        x += scaledForce.x();
        y += scaledForce.y();
    }

}
