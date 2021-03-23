import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import org.apache.commons.io.IOUtils;

@Service
public class TransformImage {

  @Transactional
    public String getStaticMapImage() throws IOException {
      String urlMaps = "http://localhost:3000/?center=-45.9009074,-23.223701&zoom=13&height=673&width=1067";
      String base64 = "";
      try {
        byte[] imageBytes = IOUtils.toByteArray(new URL(urlMaps));
        base64 = Base64.getEncoder().encodeToString(imageBytes);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return base64;
    }
}
