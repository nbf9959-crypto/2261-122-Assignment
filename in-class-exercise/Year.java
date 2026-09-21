public class Year { 

    public int year; 

    public Year(int year) {
        this.year = year; 
    }

    public static Year[] parseYears(String years) {
        String[] collection = years.split(" "); Year[] results = new Year[100]; 
        for(int x = 0; x < collection.length; x++)  {
            results[x] = new Year(Integer.parseInt(collection[x])); 
        }

        return results; 
    }
}

