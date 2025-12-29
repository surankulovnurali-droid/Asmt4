import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gallery {

    private String name;
    private List<Artwork> artworks;

    public Gallery(String name) {
        this.name = name;
        this.artworks = new ArrayList<>();
    }

    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
    }

    // search
    public Artwork searchByTitle(String title) {
        for (Artwork a : artworks) {
            if (a.getTitle().equals(title)) {
                return a;
            }
        }
        return null;
    }

    // filtering
    public List<Artwork> filterByType(String type) {
        List<Artwork> result = new ArrayList<>();
        for (Artwork a : artworks) {
            if (a.getType().equals(type)) {
                result.add(a);
            }
        }
        return result;
    }

    // sorting
    public void sortByPrice() {
        artworks.sort(Comparator.comparingDouble(Artwork::getPrice));
    }

    public void showAllArtworks() {
        System.out.println("Gallery: " + name);
        for (Artwork a : artworks) {
            System.out.println(a);
        }
    }
}
