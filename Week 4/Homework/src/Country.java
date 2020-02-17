public class Country {
    private String name;
    private double area;
    private int population;
    private double populationDensity;

    public Country(String name, double area, int population, double populationDensity) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.populationDensity = populationDensity;
    }
//Getter/setters for name, area, population, population density
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(double populationDensity) {
        this.populationDensity = populationDensity;
    }
}
