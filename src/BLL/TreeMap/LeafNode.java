package BLL.TreeMap;

public class LeafNode extends Node {
    private Character character;

    public LeafNode(Character character, Integer count) {
        super(count);
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public void buildCode(String code) {
        super.buildCode(code);
    }
}
