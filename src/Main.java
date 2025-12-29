public class Main {
    public static void main(String[] args) {

        Gallery gallery = new Gallery("World Art Gallery");

        Artwork a1 = new Painting("Mona Lisa", 1503, 800000);
        Artwork a2 = new Sculpture("David", 1504, 1200000);
        Artwork a3 = new Painting("The Scream", 1893, 950000);

        gallery.addArtwork(a1);
        gallery.addArtwork(a2);
        gallery.addArtwork(a3);

        System.out.println("All artworks");
        gallery.showAllArtworks();

        System.out.println("\nSearch by title");
        System.out.println(gallery.searchByTitle("David"));

        System.out.println("\nFilter by type: Painting");
        for (Artwork a : gallery.filterByType("Painting")) {
            System.out.println(a);
        }

        System.out.println("\nSorted by price");
        gallery.sortByPrice();
        gallery.showAllArtworks();
    }
}

