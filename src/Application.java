public class Application {

    private static void putRing(YinshGame yinsh)
    {
        // chaque joueur place ses anneaux
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('F', 7), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('G', 9), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
    }

    private static void putMarkerAndMoveRing(YinshGame yinsh)
    {
        // le joueur noir place un marqueur  et déplace un anneau
        yinsh.putMarker(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.moveRing(new Coordinates('J', 8), new Coordinates('I', 8), YinshGame.GAMECOLOR.BLACK);

        // le joueur blanc place un marqueur et déplace un anneau
        yinsh.putMarker(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.moveRing(new Coordinates('G', 8), new Coordinates('H', 9), YinshGame.GAMECOLOR.WHITE);

        // le joueur noir place un marqueur  et déplace un anneau
        yinsh.putMarker(new Coordinates('I', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.moveRing(new Coordinates('I', 8), new Coordinates('H', 8), YinshGame.GAMECOLOR.BLACK);

        // le joueur blanc place un marqueur et déplace un anneau
        yinsh.putMarker(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.moveRing(new Coordinates('H', 6), new Coordinates('I', 7), YinshGame.GAMECOLOR.WHITE);

        // le joueur noir place un marqueur  et déplace un anneau
        yinsh.putMarker(new Coordinates('H', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.moveRing(new Coordinates('H', 8), new Coordinates('F', 8), YinshGame.GAMECOLOR.BLACK);

        // le joueur blanc place un marqueur et déplace un anneau
        yinsh.putMarker(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.moveRing(new Coordinates('B', 2), new Coordinates('B', 3), YinshGame.GAMECOLOR.WHITE);

        // le joueur noir place un marqueur  et déplace un anneau
        yinsh.putMarker(new Coordinates('F', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.moveRing(new Coordinates('F', 8), new Coordinates('E', 8), YinshGame.GAMECOLOR.BLACK);
    }

    private static void removeRowAndRemoveRing(YinshGame yinsh)
    {
        yinsh.removeRow(new Coordinates('F', 8), new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.removeRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
    }

    public static void main(String[] args)
    {
        // le joueur noir commence
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);

        putRing(yinsh);
        putMarkerAndMoveRing(yinsh);
        removeRowAndRemoveRing(yinsh);
        //if (yinsh.winnerIs() == YinshGame.GAMECOLOR.BLACK) {
        //    System.out.println("Le joueur noir a gagné !");
        //} else {
        //    System.out.println("L'API YinshGame n'est pas conforme");
        //}
    }

}
