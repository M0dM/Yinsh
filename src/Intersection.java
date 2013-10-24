
class Intersection {

    private YinshGame.GAMECOLOR m_color;
    private YinshGame.GAMESTATE m_state;

    public Intersection(YinshGame.GAMECOLOR color, YinshGame.GAMESTATE state) {
        m_color = color;
        m_state = state;
    }

    public YinshGame.GAMECOLOR getColor() {
        return m_color;
    }

    public void setColor(YinshGame.GAMECOLOR color) {
        m_color = color;
    }

    public YinshGame.GAMESTATE getState() {
        return m_state;
    }

    public void setState(YinshGame.GAMESTATE state) {
        m_state = state;
    }

}
