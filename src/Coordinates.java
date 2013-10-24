/**
 * Created with IntelliJ IDEA.
 * User: Benoit
 * Date: 24/10/13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public class Coordinates {
    char m_col;
    int m_line;
    public Coordinates(char col, int line){
        m_col = (char)((int)col - ('A' - 'a'));
        m_line = line;
    }
}
