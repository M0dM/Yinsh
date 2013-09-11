
public class Yinsh {

	public enum color{ BLACK, WHITE };
	
	private color currentColor;
	private int numberOfRings;
	private color[][] plate;
	private int numberOfWhiteRings = 0;
	private int numberOfBlackRings = 0;
	private int[] ligneMin = { 2, 1, 1, 1, 1,  2,  2,  3,  4,  5,  7 };
	private int[] ligneMax = { 5, 7, 8, 9, 10, 10, 11, 11, 11, 11, 10 };
	
	public Yinsh(){
		this.numberOfRings = 0;
		this.currentColor = null;
		plate = new color[10][10];
	}
	
	public color currentColor(){
		return this.currentColor;
	}
	
	public void putRing(char colone, int ligne, color ringColor) throws DuplicateRingException, InvalidCoordinateException, InvalidColorException{
		if(!hasCoordinates(colone, ligne)){
			throw new InvalidCoordinateException();
		}
		else{
			if(hasRing(colone, ligne)){
				throw new DuplicateRingException();
			}
			else{
				if(currentColor == ringColor) {
					throw new InvalidColorException();
				}
				else{
					currentColor = ringColor;
				}
				numberOfRings++;
				if(ringColor == color.BLACK){
					numberOfBlackRings++;
				}
				else{
					numberOfWhiteRings++;
				}
				setPlate(colone, ligne, ringColor);
			}
		}
	}
	
	public boolean hasRing(char colone, int ligne){
		return plate[(int)colone-'a'][ligne-1] != null;
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

	public void setPlate(char colone, int ligne, color value){
		plate[(int)colone-97][ligne-1] = value;
	}
	
	public boolean isInitialized(){
		return numberOfBlackRings == 5 && numberOfWhiteRings == 5;
	}
	
}
