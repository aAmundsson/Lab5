package mountain;

import fractal.*;

public class Bergsmassiv extends fractal.Fractal {
    private Point a, b, c;
    private double dev;

    public Bergsmassiv(Point a, Point b, Point c, double dev) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.dev = dev;
    }

    @Override
    public String getTitle() {
        return "Bergsmassiv";
    }

    @Override
    public void draw(TurtleGraphics g) {
        
        drawFractal(g, a, b, c, order, dev);
    }

    public void drawFractal(TurtleGraphics g, Point a, Point b, Point c, int order, double dev) {
        double rand = RandomUtilities.randFunc(dev);
        if (order == 0) {
        	g.moveTo(a.getX(), a.getY());
            g.forwardTo(b.getX(), (b.getY()));
            g.forwardTo(c.getX(), (c.getY()));
            g.forwardTo(a.getX(), (a.getY()));
            
        } else {
        	Point ab, bc, ca ;
            ab = new Point((a.getX() + b.getX())/2 , (a.getY() + b.getY() + (int)rand)/2);
            bc = new Point((b.getX() + c.getX())/2 , (b.getY() + c.getY() + (int)rand)/2);
            ca = new Point((c.getX() + a.getX())/2 , (c.getY() + a.getY() + (int)rand)/2);
            
            drawFractal(g, ab, b, bc, order-1, dev/2);
            drawFractal(g, ca, bc, c, order-1, dev/2);
            drawFractal(g, ab, bc, ca, order-1, dev/2);
            drawFractal(g, a,ab, ca, order-1, dev/2);
            

            

            


        }

    }
}
