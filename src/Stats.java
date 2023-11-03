public class Stats
{
    private String name;
    private boolean selected;
    private int value;

    public Stats(String name) {
        this.name = name;
        this.selected = false;
        this.value = 31;
    }

    public Stats(String name, int value) {
        this.name = name;
        this.selected = true;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getValue() {
        return value;
    }

    public void select(boolean selected) {
        this.selected = selected;
        value = (selected) ? ((int) (Math.random() * 30) + 1) : 31;
    }
}
