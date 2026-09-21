public class Main {
    public static void main(String[] args) {
        Year[] results = Year.parseYears("2024 2047 2098 2002 2001 2016 2026");
        for (Year year : results) {
            System.out.print(String.format("%d ", year.year));
        }
    }
}
