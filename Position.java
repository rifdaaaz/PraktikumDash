// Position.java

class Position {
  private int x;
  private int y;

  /** CTOR, CCTOR */
  public Position() { x = 0; y = 0; }
  public Position(int _x, int _y) { x = _x; y = _y; }
  public Position(final Position p) { x = p.x; y = p.y; }

  /** GETTER, SETTER */
  public final int getX() { return x; }
  public final int getY() { return y; }
  public void setX(int _x) { x = _x; }
  public void setY(int _y) { y = _y; }

  public String toString() { return "(" + x + "," + y + ")"; }

  public boolean equals(Position p) { 
    return x == p.x && y == p.y; 
  }

  public void move(int dx, int dy) { 
    x += dx; y += dy; 
  }

  public void inverse() {
    x = -x; y = -y;
  }
}

