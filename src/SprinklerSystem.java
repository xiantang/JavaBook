public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source;
    private int i;
    private float f;

    @Override
    public String toString() {
        return
                "valve1 = " + valve1 + "\n" +
                        "valve2 = " + valve2 + "\n" +
                        "valve3 = " + valve3 + "\n" +
                        "valve4 = " + valve4 + "\n" +
                        "i = " + i + "\n" +
                        "f = " + f + "\n" +
                        "source = " + source;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);

    }
}

