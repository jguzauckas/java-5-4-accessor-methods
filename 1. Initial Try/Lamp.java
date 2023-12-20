public class Lamp {
    private boolean isOn;
    private String lightbulbType;
    private int wattage;

    public Lamp() {
        isOn = false;
        lightbulbType = "";
        wattage = -1;
    }

    public Lamp(boolean i, String l, int w) {
        isOn = i;
        lightbulbType = l;
        wattage = w;
    }
}