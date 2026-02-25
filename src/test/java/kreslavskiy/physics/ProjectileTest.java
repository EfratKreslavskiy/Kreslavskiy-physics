package kreslavskiy.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest {

    @Test
    void apply() {
        //given
        Force f1 = new Force(37.0365, 28.9360);
        Projectile p1 = new Projectile(0.0, 0.0, f1);

        //when
        p1.apply(0.001);


        //then - test that there's a change in x, y, and force
        assertEquals(0.0370, p1.getX(), 0.0001);
        assertEquals(0.0289, p1.getY(), 0.0001);
        assertEquals(37.0365, f1.x(), 0.0001);
        assertEquals(28.9360, f1.y(), 0.0001);
    }
}