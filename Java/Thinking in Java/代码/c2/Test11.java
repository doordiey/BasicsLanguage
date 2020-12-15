package c2;

class AllTheColorOfTheRainbow{
    int anIntegerRepresentingColors;
    void changeTheHueOfTheColor(int newHue){
        anIntegerRepresentingColors = newHue;
    }
}
public class Test11 {
    public static void main(String[] args) {
        AllTheColorOfTheRainbow allTheColorOfTheRainbow = new AllTheColorOfTheRainbow();
        allTheColorOfTheRainbow.anIntegerRepresentingColors = 0;
        allTheColorOfTheRainbow.changeTheHueOfTheColor(2);
        System.out.println(allTheColorOfTheRainbow.anIntegerRepresentingColors);
    }
}
