import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ArtworkHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if (exchange.getRequestMethod().equalsIgnoreCase("GET")) {

            ArtworkDAO dao = new ArtworkDAO();
            List<Artwork> artworks = dao.showArtworks();

            String json = convertToJson(artworks);

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, json.length());

            OutputStream os = exchange.getResponseBody();
            os.write(json.getBytes());
            os.close();
        }
    }

    private String convertToJson(List<Artwork> list) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            Artwork a = list.get(i);
            json.append("{")
                    .append("\"id\":").append(a.getId()).append(",")
                    .append("\"title\":\"").append(a.getTitle()).append("\",")
                    .append("\"year\":").append(a.getYear()).append(",")
                    .append("\"price\":").append(a.getPrice()).append(",")
                    .append("\"type\":\"").append(a.getType()).append("\"")
                    .append("}");

            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        return json.toString();
    }
}
