import java.text.DecimalFormat;

public class Planet {

    private String name;
    private double mass;
    private double distance;
    private double orbital;

    /*
    this object transform ',' into '.' and round it so it doesn't have
    more than 3 decimal variables
     */
    private DecimalFormat decimalFormat = new DecimalFormat("0.0##");

    /*
    this constructor makes it easier to create a new object
     */
    public Planet(String name, double mass, double distance){
        setDistance(distance);
        setMass(mass);
        setName(name);
        setOrbital();
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    private void setMass(double mass) {
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    /*
    in this method we calculate the orbit
     */
    private void setOrbital() {
        this.orbital = Math.sqrt(distance*distance*distance);
    }

    private double getOrbital() {
        return orbital;
    }

    /*
    this method return the message
     */
    public String toString() {
        return ("Planet " + getName() +
                " has a mass of " + decimalFormat.format(getMass()).replace("," , ".") +
                " Earths, is " + decimalFormat.format(getDistance()).replace("," , ".") +
                "AU from its star, and orbits in " +
                decimalFormat.format(getOrbital()).replace("," , ".") +
                " years: could be habitable? ");
    }
}
