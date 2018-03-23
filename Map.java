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

    public void placeAsisten(Asisten asisten) {
        map[asisten.getPos().getX()][asisten.getPos().getY()] = asisten.getLogo();
    }

    public void placePraktikan(Praktikan praktikan) {
        map[praktikan.getPos().getX()][praktikan.getPos().getY()] = praktikan.getLogo();
    }

    public void placeWall(Position place) {
        map[place.getX()][place.getY()] = '#';
    }

    public void setTitik(Position place) {
        map[place.getX()][place.getY()] = '.';
    }

    public static void main(String[] args) {
        Map map = new Map();
        Position letakSandro = new Position(3,5);
        Asisten sandro = new Asisten("Sandro", letakSandro);
        map.placeAsisten(sandro);

        Position letakAthur = new Position(12,12);
        Praktikan athur = new Praktikan("Athur", letakAthur);
        map.placePraktikan(athur);

        sandro.setTarget(athur);
        while(!sandro.isSampai()){
            map.setTitik(sandro.getPos());
			sandro.move();
            map.placeAsisten(sandro);
			map.printMap();
            try        
            {
                Thread.sleep(1000);
            } 
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
		}
    }

}