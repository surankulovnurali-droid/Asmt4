public class Painting extends Artwork {

    public Painting(String title, int year, double price) {
        super(title, year, price);
    }

    @Override
    public String getType() {
        return "Painting";
    }
}
