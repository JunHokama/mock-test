package junhokama.com.github.springmock.controller;

import junhokama.com.github.springmock.model.Photo;
import junhokama.com.github.springmock.model.PhotoConsumerFeign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PhotoController {
    private final PhotoConsumerFeign photoConsumerFeign;

    public PhotoController(PhotoConsumerFeign photoConsumerFeign) {
        this.photoConsumerFeign = photoConsumerFeign;
    }

    @GetMapping(value = "/photos")
    ResponseEntity<List<Photo>> getPhotos(){
        return ResponseEntity.ok(photoConsumerFeign.getPhotos());
    }
    @GetMapping(value = "/photos/{id}")
    public ResponseEntity<Photo> getPhotosById(@PathVariable("id") Long id) {
        Photo photo = photoConsumerFeign.getPhotosById(id);
        return ResponseEntity.ok(photo);
    }

}
