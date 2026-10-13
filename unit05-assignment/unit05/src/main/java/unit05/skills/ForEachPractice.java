package unit05.skills; 

public class ForEachPractice{ 
    public static void main(String[] args) {
        int[] scores = {88, 92, 75, 100, 64};
        double accumulation = 0;  

        for (int score : scores) {
            System.out.println(score);
        }

        for (int score : scores) {
            accumulation += score; 
        }

        System.out.println(String.format("""
        \nTotal: %.0f,
        Average: %.1f
        """, Math.floor(accumulation), (accumulation / scores.length)));
    }
}