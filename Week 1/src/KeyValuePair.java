public class KeyValuePair {
    private double value;
   private String key;

    public KeyValuePair(double value, String key) {
        this.value = value;
        this.key = key;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return String.format("<%s,%,.2f>",key,value);
    }

    public static void main(String[] args) {
        KeyValuePair kvp = new KeyValuePair(6.268, "ted");
        System.out.println(kvp);
    }
}
