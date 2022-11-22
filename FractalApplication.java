package fractal;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Bergsmassiv(new Point(230,450), new Point(300,300), new Point(450,315), 1000);
		new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
