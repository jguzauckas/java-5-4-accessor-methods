public class TestLamp {
    public static void main() {
        Lamp lamp1 = new Lamp(false, "Incandescent", 60);

        System.out.println(lamp1.getIsOn());
        System.out.println(lamp1.getLightbulbType());
        System.out.println(lamp1.getWattage());
    }
}
