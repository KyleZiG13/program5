//Kyle Zeigler
/**
 *
 * @author zeiglekl2019
 */

//This class was created for a Programming assignment in CSC 120 and I have
//reused it here in this assignment.
////Kyle Zeigler
//5/3/2017
//Program Assignment 5
//This Soccerball class is from a previously created Program 3 and draws 
//Soccerball's in the StageFrame

package csc220.program5.fromProgram3;

/*
Author: Kyle Zeigler
Created 9/10/2016
 */
import csc220.drawing.Drawable;
import csc220.program5.GameCharacter;
import java.awt.*;


public class Soccerball extends csc220.program5.GameCharacter {

    public Soccerball(int x, int y, int diameter, int moveInterval) {
        super(x, y, diameter, diameter, 1000, new List<Point>());
        animationPath.add(new Point(x, y));
        animationPath.add(new Point(x + 100, y));
        animationPath.add(new Point(x, y + 100));
        animationPath.add(new Point(x + 100, y + 100));
    }

    @Override
    public void draw(Graphics g) { 
    // base of the ball
    g.setColor(Color.WHITE);
    g.fillOval(getOver(), getDown(), 50, 50); 
    g.setColor(Color.BLACK);
    g.drawOval(getOver(), getDown(), 50, 50);
    //smaller circle designs on ball
    g.setColor(Color.BLACK);
    g.fillOval(getOver() + 30, getDown() + 5 ,10, 10);
    g.fillOval(getOver() + 7, getDown() + 10, 10, 10);
    g.fillOval(getOver() + 20, getDown() + 23, 10, 10);
    g.fillOval(getOver() + 5 , getDown() + 30, 10, 10);
    g.fillOval(getOver() + 34, getDown() + 32, 10, 10);
}
    
    
    
    @Override
    public boolean contains(Point p){
        Rectangle newBoundaries = new Rectangle();
        newBoundaries.x = getOver();
        newBoundaries.y = getDown();
        newBoundaries.width = getWidth()+50;
        newBoundaries.height = getHeight()+50;
        
        return newBoundaries.contains(p);
    }
    }