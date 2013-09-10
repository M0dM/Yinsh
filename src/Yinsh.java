
public class Yinsh {


	public static enum color{ BLACK, WHITE };
	
	private color currentColor;
	
	public Yinsh(){
		this.currentColor = color.BLACK;
	}
	
	public color currentColor(){
		return this.currentColor;
	}
	
}
