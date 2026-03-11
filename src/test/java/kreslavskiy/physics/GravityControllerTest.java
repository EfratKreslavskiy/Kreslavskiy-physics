package kreslavskiy.physics;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

class GravityControllerTest
{
    @Test
    void updateForce()
    {
        //given
        GravityComponent gravityComponent = mock();
        JTextField xField = mock();
        JTextField yField = mock();
        JTextField timeField = mock();
        doReturn("5").when(timeField).getText();
        JLabel angLabel = mock();
        JLabel magLabel = mock();
        JLabel apexLabel = mock();
        GravityController gravityController = new GravityController(gravityComponent, xField, yField, timeField,
                angLabel, magLabel, apexLabel);

        //when
        gravityController.updateForce(7, 5);

        //then
        verify(gravityComponent).setForce(new Force(7, 5));
        verify(gravityComponent).setTime(5);
        verify(xField).setText("7.0");
        verify(yField).setText("5.0");
        verify(angLabel).setText("Angle: 35.53767779197438");
        verify(magLabel).setText("Magnitude: 8.602325267042627");
        verify(apexLabel).setText("Apex: 1.2755102040816326");
    }
}