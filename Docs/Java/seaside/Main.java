public class Main {
    public static void main(String[] args) {
        SeaSample sample = new SeaSample();
        EntityFirst entityFirst = new EntityFirst();
        EntitySecond entitySecond = new EntitySecond();
        sample.refTest(entityFirst);
        sample.refTest(entitySecond);
    }
}
