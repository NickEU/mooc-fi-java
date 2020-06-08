public class LiteracyRates implements Comparable<LiteracyRates> {
    private final String sex;
    private final String country;
    private final int year;
    private final double literacyPercent;

    public LiteracyRates(String sex, String country, int year, double literacyPercent) {
        this.sex = sex;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    public String getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getLiteracyPercent() {
        return literacyPercent;
    }

    @Override
    public int compareTo(LiteracyRates o) {
        double difference = this.getLiteracyPercent() - o.getLiteracyPercent();
        return difference < 0 ? -1 : (int) Math.ceil(difference);
    }

    @Override
    public String toString() {
        return this.getCountry() + " (" + this.getYear() 
                + "), " + this.getSex() + ", " 
                + this.getLiteracyPercent();
    }   
    
    
}
