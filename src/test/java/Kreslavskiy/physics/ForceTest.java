package kreslavskiy.physics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForceTest {

    @org.junit.jupiter.api.Test
    void getMagnitude()
    {
        //given
        Force f = new Force(3, 4);

        //when
        double mag = f.getMagnitude();

        //then
        assertEquals(5, mag, 0.01);
    }

    @org.junit.jupiter.api.Test
    void getDegrees() {
        //given
        Force f = new Force(3, 4);

        //when
        double degrees = f.getDegrees();

        //then
        assertEquals(53.13, degrees, 0.1);
    }

    @org.junit.jupiter.api.Test
    void addForce() {
        //given
        Force f = new Force(3, 4);
        Force f2 = new Force(-2, 3);

        //when
        Force f3 = f.addForce(f2);

        //then
        assertEquals(1, f3.getX(), 0.1);
        assertEquals(7, f3.getY(), 0.1);
    }

    @Test
    void normalize()
    {
        //given
        Force f = new Force(3, 4);

        //when
        Force norm = f.normalize();
        double mag = norm.getMagnitude();

        //then
        assertEquals(1, mag, 0.01);
    }

    @Test
    void scale()
    {
        //given
        Force f = new Force(3, 4);

        //when
        Force scaled = f.scale(2.0);

        //then
        assertEquals(6, scaled.getX(), 0.1);
        assertEquals(8, scaled.getY(), 0.1);
    }
}