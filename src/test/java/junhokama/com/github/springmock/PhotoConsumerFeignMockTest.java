package junhokama.com.github.springmock;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class PhotoConsumerFeignMockTest {

    private ClientAndServer mockServer;

    @Test
    public void getPhotosByIdTest() {
        mockServer = startClientAndServer(1080);

        new MockServerClient("localhost", 1080)
                .when(
                        HttpRequest.request()
                                .withMethod("GET")
                                .withPath("/photos/1")
                )
                .respond(
                        HttpResponse.response()
                                .withStatusCode(200)
                                .withBody("{ \"id\": 1, \"title\": \"foto mockada\", \"url\": \"http://teste.com/photo.jpg\" }",
                                        org.mockserver.model.MediaType.APPLICATION_JSON)
                );

        mockServer.stop();
    }
}
