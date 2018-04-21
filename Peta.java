import java.util.*;

public class Peta {
    private char[][] peta = new char[14][14];
    private static Peta petaInstance = null;

    public static Peta getInstance () {
        if (petaInstance == null){
            petaInstance = new Peta();
        }
        return petaInstance;
    }

    private Peta() {
        for (int i = 0; i < 14; i ++) {
            this.peta[i][0] = '#';
            this.peta[i][13] = '#';
            this.peta[0][i] = '#';
            this.peta[13][i] = '#';
        } 
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 13; j ++) {
                this.peta[i][j] = '.';
            }
        }
    }

    public void setPeta(char [][] maze){
        for (int i = 0; i<14; i++) {
            for (int j = 0; j<14; j++) {
                peta[i][j] = maze[i][j];
            }
        }
    }

    public void printPeta(Praktikan p, Asisten a) {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j ++) {
                if (a.getPos().equals(new Position(i,j))){
                    System.out.print('A');
                }else if (p.getPos().equals(new Position(i,j))){
                    System.out.print('P');
                }else{
                    System.out.print(peta[i][j]);
                }
            }
            System.out.println();
        }
    }

    public char[][] get() {
        return peta;
    }

    public synchronized void placeAsisten(Asisten asisten) {
        peta[asisten.getPos().getX()][asisten.getPos().getY()] = asisten.getLogo();
    }

    public synchronized void placePraktikan(Praktikan praktikan) {
        peta[praktikan.getPos().getX()][praktikan.getPos().getY()] = praktikan.getLogo();
    }

    public synchronized void placeWall(Position place) {
        peta[place.getX()][place.getY()] = '#';
    }

    public synchronized void setTitik(Position place) {
        peta[place.getX()][place.getY()] = '.';
    }

    public synchronized void setKoor(char logo, Position place) {
        peta[place.getX()][place.getY()] = logo;
    }

    // public static void main (String[] args){
    //     Peta worldMap = Peta.getInstance();
    //     worldMap.printPeta1();
    // }

}