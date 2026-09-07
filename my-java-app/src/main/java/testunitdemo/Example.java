package testunitdemo;

public class Example {
    private String aircraft = "";
    
    private String propulsion_system = ""; 

    public example(String aircraft_insertion, String system_insertion)  {
        this.aircraft = aircraft_insertion; this.propulsion_system = system_insertion; 
    }

    public String Detail_Outlining() {
        String template = """
        Aircraft model: %s
        Propulsion system: %s
        """;
        return String.format(template, this.aircraft, this.propulsion_system)
    }
}
