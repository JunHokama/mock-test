package junhokama.com.github.springmock.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "photo-consumer",
        url = "https://jsonplaceholder.typicode.com")

// https://jsonplaceholder.typicode.com/photos

public interface PhotoConsumerFeign {

    @GetMapping(value = "/photos")
    List<Photo> getPhotos();
    @GetMapping(value = "/photos/{id}")
    Photo getPhotosById(@PathVariable("id") Long id);
}
