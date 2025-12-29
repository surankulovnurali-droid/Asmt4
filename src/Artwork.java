import java.util.Objects;

public abstract class Artwork {

    private String title;
    private int year;
    private double price;

    public Artwork(String title, int year, double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    // polymorphism
    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " | Title: " + title +
                ", Year: " + year +
                ", Price: " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artwork)) return false;
        Artwork artwork = (Artwork) o;
        return year == artwork.year &&
                Objects.equals(title, artwork.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }
}
