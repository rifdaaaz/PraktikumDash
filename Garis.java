public class Garis {
	private Point start;
	private Point end;
	
	public Garis(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	// setter
    public void setStart (Point start) {
        this.start = start;
    }

    public void setEnd (Point end) {
        this.end = end;
    }

    // getter
    public Point getStart (){
        return this.start;
    }
    public Point getEnd (){
        return this.end;
    }
    
    public void print() {
		System.out.println("(" + this.start.getX() + (",") + this.start.getY() + (")") + (" - ") + "(" + this.end.getX() + (",") + this.end.getY() + (")"));
	}
    
    public double length() {
		double dx = this.start.getX() - this.end.getX();
        double dy = this.start.getY() - this.end.getY();
        return Math.sqrt(dx*dx + dy*dy);
	}	
    
    public double gradient() {
		double hasily = this.end.getY() - this.start.getY();
		double hasilx = this.end.getX() - this.start.getX();
		return (hasily / hasilx);
	}
    
    public void move(double x, double y) {
		this.start.move(x, y);
		this.end.move(x, y);
	}
    
    public boolean isTegakLurusWith(Garis g2) {
		double gradientTes = g2.gradient();
		double hasilKali = gradientTes * this.gradient();
		if (hasilKali == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSejajarWith(Garis g2) {
    	double gradientTes = g2.gradient();
		if (gradientTes == this.gradient()) {
			return true;
		}
		else {
			return false;
		}
	}
}
	
