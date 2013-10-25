public class Coordinates {
    char m_col;
    int m_line;
    public Coordinates(char col, int line){
        m_col = (char)((int)col - ('A' - 'a'));
        m_line = line;
    }
}
