package kreslavskiy.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForceTest {

    @Test
    void getMagnitude() {
        //given
        Force f = new Force(3, 4);

        //when
        double mag = f.getMagnitude();

        //then
        assertEquals(5, mag, 0.01);
    }

    @Test
    void getDegrees() {
        //given
        Force f = new Force(3, 4);

        //when
        double degrees = f.getDegrees();

        //then
        assertEquals(53.13, degrees, 0.1);
    }

    @Test
    void addForce() {
        //given
        Force f = new Force(3, 4);
        Force f2 = new Force(-2, 3);

        //when
        Force f3 = f.addForce(f2);

        //then
        assertEquals(1, f3.x(), 0.1);
        assertEquals(7, f3.y(), 0.1);
    }

    @Test
    void normalize() {
        //given
        Force f = new Force(3, 4);

        //when
        Force norm = f.normalize();
        double mag = norm.getMagnitude();

        //then
        assertEquals(1, mag, 0.01);
    }

    @Test
    void scale() {
        //given
        Force f = new Force(3, 4);

        //when
        Force scaled = f.scale(2.0);

        //then
        assertEquals(6, scaled.x(), 0.1);
        assertEquals(8, scaled.y(), 0.1);
    }

    @Test
    void gravity() {
        //given
        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(0.001);

        double x = 0.0;
        double y = 0.0;
        Force f1 = new Force(37.0365, 28.9360);

        //when
        //add gravity to ur force after 1s, creating new force. what is xy value? add to new force
        for (double i = 0; i < 5; i += 0.001) {
            f1 = f1.addForce(scaledGravity);
            Force scaledF1 = f1.scale(0.001);

            x += scaledF1.x();
            y += scaledF1.y();

        }
        System.out.println("Final location after 5s: " + x + ", " + y);
    }

}