package mountain;

import java.util.HashMap;

import fractal.*;

public class Bergsmassiv extends fractal.Fractal {
    private Point a, b, c;
    private double dev;
    HashMap<Side, Point> sideMap;

    public Bergsmassiv(Point a, Point b, Point c, double dev) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.dev = dev;
        sideMap = new HashMap<Side, Point>();
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
        int rand = (int) RandomUtilities.randFunc(dev);
        int count= 0;
        if (order == 0) {
        	g.moveTo(a.getX(), a.getY());
            g.forwardTo(b.getX(), (b.getY()));
            Side abSide = new Side(b, a);
            sideMap.put(abSide, new Point((a.getX() + b.getX())/2 , ((a.getY() + b.getY() + rand)/2)) );
            g.forwardTo(c.getX(), (c.getY()));
            Side bcSide = new Side(b, c);
            sideMap.put(bcSide, new Point((b.getX() + c.getX())/2 , ((b.getY() + c.getY() + rand)/2)) );
            g.forwardTo(a.getX(), (a.getY()));
            Side caSide = new Side(c, a);
            sideMap.put(caSide, new Point((c.getX() + a.getX())/2 , ((c.getY() + a.getY() + rand)/2)) );
            
        } else {
        	Point ab, bc, ca ;
            
            Side m = new Side(a, b);
            Side mrev = new Side(b, a);
        	Side n = new Side(b, c);
        	Side nrev = new Side(c, b);
        	Side o = new Side(c, a);
        	Side orev = new Side(a, c);
            
        	
            	if (sideMap.containsKey(m) || sideMap.containsKey(mrev)) {
            		count++;
            		ab = sideMap.get(m);
            		sideMap.remove(m);
            	} else {
            	
			    	ab = new Point((a.getX() + b.getX())/2 , ((a.getY() + b.getY() + rand)/2));
			    	sideMap.put(m, ab);
            	}
            	
            	if (sideMap.containsKey(n) || sideMap.containsKey(nrev)) {
            		count++;
            		bc = sideMap.get(n);
            		sideMap.remove(n);
            	} else {
            	
			    	bc = new Point((b.getX() + c.getX())/2 , ((b.getY() + c.getY() + rand)/2));
			    	sideMap.put(n, bc);
            	}
            	
            	if (sideMap.containsKey(o) || sideMap.containsKey(orev)) {
            		count++;
            		ca = sideMap.get(o);
            		sideMap.remove(o);
            	} else {
            	
			    	ca = new Point((c.getX() + a.getX())/2 , ((c.getY() + a.getY() + rand)/2));
			    	sideMap.put(o, ca);
            	}
            
            drawFractal(g, ab, b , bc, order-1, dev/2);
            drawFractal(g, ca, bc, c , order-1, dev/2);
            drawFractal(g, ab, bc, ca, order-1, dev/2);
            drawFractal(g, a , ab, ca, order-1, dev/2);
           

        }
        System.out.println(count);

    }
}
