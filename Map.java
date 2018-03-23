public class Map {
    private char[][] map = new char[15][15];

    public Map() {
        for (int i = 0; i < 14; i ++) {
            this.map[i][0] = '#';
        } 
        for (int i = 0; i < 14; i ++) {
            this.map[0][i] = '#';
        }
        for (int i = 0; i < 14; i ++) {
            this.map[13][i] = '#';
        }
        for (int i = 0; i < 14; i ++) {
            this.map[i][13] = '#';
        } 
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 13; j ++) {
                this.map[i][j] = '.';
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j ++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void placeAsisten(Position place, Asisten asisten) {
        map[place.getX()][place.getY()] = asisten.getLogo();
    }

    public void placePraktikan(Position place, Praktikan praktikan) {
        map[place.getX()][place.getY()] = praktikan.getLogo();
    }

    public static void main(String[] args) {
        Map map = new Map();
        WorldBuilder world = new WorldBuilder();

        map.printMap();
    }

}