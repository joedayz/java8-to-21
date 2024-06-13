import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatExample {
    public static void main(String[] args) {
        NumberFormat followers = NumberFormat.getCompactNumberInstance(
          new Locale.Builder().setLanguage("en").setRegion("US").build(), 
          NumberFormat.Style.SHORT);
          followers.setMaximumFractionDigits(1);
          System.out.println(followers.format(5412) + " followers");

    }
}
