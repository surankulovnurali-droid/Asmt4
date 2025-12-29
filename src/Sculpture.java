public class Sculpture extends Artwork {

    public Sculpture(String title, int year, double price) {
        super(title, year, price);
    }

    @Override
    public String getType() {
        return "Sculpture";
    }
}
