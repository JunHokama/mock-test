package junhokama.com.github.springmock.controller;

import junhokama.com.github.springmock.model.Photo;
import junhokama.com.github.springmock.model.PhotoConsumerFeign;
import junhokama.com.github.springmock.model.PhotoConsumerFeignLocal;
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

    private final PhotoConsumerFeignLocal photoConsumerFeignLocal;

    public PhotoController(PhotoConsumerFeign photoConsumerFeign, PhotoConsumerFeignLocal photoConsumerFeignLocal) {
        this.photoConsumerFeign = photoConsumerFeign;
        this.photoConsumerFeignLocal = photoConsumerFeignLocal;
    }


    @GetMapping(value = "/photos")
    ResponseEntity<List<Photo>> getPhotos(){
        return ResponseEntity.ok(photoConsumerFeign.getPhotos());
    }
    @GetMapping(value = "/test/photos")
    ResponseEntity<Photo> getPhotosTest(){
        return ResponseEntity.ok(photoConsumerFeignLocal.getOnePhotoTest());
    }

    @GetMapping(value = "/photos/{id}")
    public ResponseEntity<Photo> getPhotosById(@PathVariable("id") Long id) {
        Photo photo = photoConsumerFeign.getPhotosById(id);
        return ResponseEntity.ok(photo);
    }

    @GetMapping(value = "/photos/hd/{id}")
    public ResponseEntity<Photo> getPhotosByIdHd(@PathVariable("id") Long id) {
        Photo photo = photoConsumerFeignLocal.getPhotosByIdLocal(id);
        return ResponseEntity.ok(photo);
    }

}
