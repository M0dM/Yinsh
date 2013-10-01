import java.util.HashMap;
import java.util.Vector;


public class Yinsh {

	public enum color{ BLACK, WHITE, UNDEFINED };
	public enum state{ RING, MARKER, BOTH };
	
	private color currentColor;
	private int numberOfRings;
	private HashMap plate = new HashMap(); 
	private int numberOfWhiteRings;
	private int numberOfBlackRings;
	private int[] ligneMin = { 2, 1, 1, 1, 1,  2,  2,  3,  4,  5,  7 };
	private int[] ligneMax = { 5, 7, 8, 9, 10, 10, 11, 11, 11, 11, 10 };
	
	public Yinsh(){
		this.numberOfRings = 0;
		this.numberOfBlackRings = 0;
		this.numberOfWhiteRings = 0;
		this.currentColor = null;
		for (int i = 0; i < 10; i++) {
			Integer index = new Integer(i);
			Vector<Intersection> ligne = new Vector<Intersection>();
			for (int j = 0; j < 10; j++) {
				 Intersection intersect = new Intersection(color.UNDEFINED, null);
				 ligne.add(intersect);
			}
			plate.put(index, ligne);
		}
	}
	
	public color currentColor(){
		return this.currentColor;
	}
	
	public void putRing(char colone, int ligne, color color) throws DuplicateRingException, InvalidCoordinateException, InvalidColorException{
		if(!hasCoordinates(colone, ligne)){
			throw new InvalidCoordinateException();
		}
		else{
			if(hasRing(colone, ligne)){
				throw new DuplicateRingException();
			}
			else{
				if(currentColor == color) {
					throw new InvalidColorException();
				}
				else{
					currentColor = color;
				}
				numberOfRings++;
				if(color == Yinsh.color.BLACK){
					numberOfBlackRings++;
				}
				else{
					numberOfWhiteRings++;
				}
				setIntersection(colone, ligne, new Intersection(color, state.RING));
			}
		}
	}
	
	public void putMarker(char colone, int ligne, color color){
		if(!hasRing(colone, ligne)){
			setIntersection(colone, ligne, new Intersection(color, state.MARKER));
		}
		else{
			setIntersection(colone, ligne, new Intersection(color, state.BOTH));
		}
	}
	
	public boolean hasRing(char colone, int ligne){
		return ((Vector<Intersection>)plate.get((int)colone-'a')).get(ligne-1).getColor() != Yinsh.color.UNDEFINED;
	}
	
	public boolean hasRingOnPlate(){
		return (numberOfRings > 0);
	}
	
	public int getNumberOfRingsOnPlate(){
		return this.numberOfRings;
	}
	
	public boolean hasCoordinates(char colone, int ligne){
		if(!coloneHasLigne(colone, ligne)){
			return false;
		}
		return true;
	}
	
	private boolean coloneHasLigne(char colone, int ligne) {
		if(colone < 'a' || colone > 'k')
			return false;
		if(ligne < ligneMin[(int)colone-'a'] || ligne > ligneMax[(int)colone-'a'])
			return false;
		return true;
	}

	public void setIntersection(char colone, int ligne, Intersection value){
		((Vector<Intersection>)plate.get((int)colone-'a')).get(ligne-1).setState(value.getState());
		((Vector<Intersection>)plate.get((int)colone-'a')).get(ligne-1).setColor(value.getColor());
	}
	
	public boolean isInitialized(){
		return numberOfBlackRings == 5 && numberOfWhiteRings == 5;
	}
	
}
