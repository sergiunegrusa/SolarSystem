import java.util.ArrayList;

/*
in the first coursework I forgot to put final variables
so I put now 3 of them
 */
public class SolarSystem {

    private final String HABITABLE = "yes";
    private final String UNHABITABLE = "no";
    private final String COUT = "\n";
    private ArrayList<Planet> solarSystem = new ArrayList<>();
    private String name;
    private double luminosity;
    private double maxLum;
    private double minLum;

    /*
    this constructor makes it easier to create a new object
     */
    public SolarSystem(String name, double luminosity){
        setName(name);
        setLuminosity(luminosity);
    }

    public double getLuminosity() {
        return luminosity;
    }

    /*
    in this method we calculate luminosity
     */
    private void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
        minLum=0.75*Math.sqrt(this.luminosity);
        maxLum=2.0*Math.sqrt(this.luminosity);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /*
    this method adds a planet, that we create with the help of
    a constructor, into the ArrayList
     */
    public void addPlanet(String name, double mass, double distance){
        solarSystem.add(new Planet(name, mass, distance));
    }

    /*
    here we calculate if the planet is habitable or not and
    print a message
     */
    public String toString() {
        String output="";
        output = output + getName() + COUT;
        for(Planet planet:solarSystem){
            output = output + planet.toString();
            boolean value;
            value = planet.getMass() >= 0.6 && planet.getMass() <= 7.0 &&
                    planet.getDistance() >= minLum && planet.getDistance() <= maxLum;
            if(value) {
                output = output + HABITABLE + COUT;
            } else {
                output = output + UNHABITABLE + COUT;
            }
        }
        return(output);
    }
}
