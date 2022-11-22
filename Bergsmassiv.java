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
    }

    @Override
    public String getTitle() {
        return "Bergsmassiv";
    }

    @Override
    public void draw(TurtleGraphics g) {
        g.moveTo(a.getX(),a.getY());
        drawFractal(g, a, b, c, order, dev);
    }

    public void drawFractal(TurtleGraphics g, Point a, Point b, Point c, int order, double dev) {
        Point a1, b1, c1, a2, b2, c2, a3, b3, c3;
        if (order == 0) {
            g.forwardTo(b.getX(), b.getY());
            g.forwardTo(c.getX(), c.getY());
            g.forwardTo(a.getX(), a.getY());
        } else {
            a1 = new Point(a.getX(), a.getY());
            b1 = new Point((a.getX()+b.getX())/2, ((b.getY()+a.getY())/2) + (int) Math.round(RandomUtilities.randFunc(dev)));
            System.out.println((int) Math.round(RandomUtilities.randFunc(dev)));
            c1 = new Point((a.getX()+c.getX())/2, (c.getY()+a.getY())/2);

            b2 = new Point(b.getX(), b.getY());
            a2 = new Point((a.getX()+b.getX())/2, ((b.getY()+a.getY())/2) + (int) Math.round(RandomUtilities.randFunc(dev)));
            c2 = new Point((b.getX()+c.getX())/2, (c.getY()+b.getY())/2);

            a3 =  new Point((a.getX()+c.getX())/2, (c.getY()+a.getY())/2);
            b3 = new Point((b.getX()+c.getX())/2, ((c.getY()+b.getY())/2) + (int) Math.round(RandomUtilities.randFunc(dev)));
            c3 = new Point(c.getX(), c.getY());

            g.moveTo(a3.getX(), a3.getY());
            g.forwardTo(b3.getX(), b3.getY());
            g.moveTo(a3.getX(), a3.getY());
            g.forwardTo(a2.getX(), a2.getY());
            g.moveTo(b3.getX(), b3.getY());
            g.forwardTo(a2.getX(), a2.getY());

            drawFractal(g, a1, b1, c1, order-1, dev/2);
            drawFractal(g, a2, b2, c2, order-1, dev/2);
            drawFractal(g, a3, b3, c3, order-1, dev/2);
        }

    }
}
