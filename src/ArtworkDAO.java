import java.sql.*;
import java.util.List;

public class ArtworkDAO {

    public void addArtwork(String title, int year, double price,
                           String type, int artistId) {

        String sql = """
            INSERT INTO artwork(title, year, price, type, artist_id)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setInt(2, year);
            ps.setDouble(3, price);
            ps.setString(4, type);
            ps.setInt(5, artistId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Artwork> showArtworks() {
        String sql = "SELECT * FROM artwork";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("title") + " " +
                                rs.getString("type") + " " +
                                rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
