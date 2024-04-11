package junhokama.com.github.springmock.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "photo-consumer-local",
        url = "http://localhost:8081/v1")
public interface PhotoConsumerFeignLocal {
    @GetMapping(value = "/photos")
    List<Photo> getPhotosLocal();

    @GetMapping(value = "/local-photo")
    Photo getOnePhotoTest();
    @GetMapping(value = "/photos/{id}")
    Photo getPhotosByIdLocal(@PathVariable("id") Long id);

}
