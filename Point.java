// Position.java

class Position {
  private double x;
  private double y;

  /** CTOR, CCTOR */
  public Position() { x = 0; y = 0; }
  public Position(double _x, double _y) { x = _x; y = _y; }
  public Position(final Position p) { x = p.x; y = p.y; }

  /** GETTER, SETTER */
  public final double getX() { return x; }
  public final double getY() { return y; }
  public void setX(double _x) { x = _x; }
  public void setY(double _y) { y = _y; }

  public String toString() { return "(" + x + "," + y + ")"; }

  public double distanceTo(Position p) {
    double dx = x - p.x;
    double dy = x - p.y;
    return Math.sqrt(dx*dx + dy*dy);
  }

  public boolean equals(Position p) { 
    return x == p.x && y == p.y; 
  }

  public void move(double dx, double dy) { 
    x += dx; y += dy; 
  }

  public void inverse() {
    x = -x; y = -y;
  }
}

