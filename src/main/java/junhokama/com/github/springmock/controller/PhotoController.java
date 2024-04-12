package junhokama.com.github.springmock.controller;

import junhokama.com.github.springmock.togglz.MyFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.togglz.core.manager.FeatureManager;
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

    private final FeatureManager featureManager;
    private final PhotoConsumerFeign photoConsumerFeign;
    private final PhotoConsumerFeignLocal photoConsumerFeignLocal;

    public PhotoController(FeatureManager featureManager, PhotoConsumerFeign photoConsumerFeign, PhotoConsumerFeignLocal photoConsumerFeignLocal) {
        this.featureManager = featureManager;
        this.photoConsumerFeign = photoConsumerFeign;
        this.photoConsumerFeignLocal = photoConsumerFeignLocal;
    }

    @GetMapping(value = "/photos")
    ResponseEntity<List<Photo>> getPhotos(){

        if(featureManager.isActive(MyFeatures.URL)) {
            return ResponseEntity.ok(photoConsumerFeign.getPhotos());
        }
        return ResponseEntity.ok(photoConsumerFeignLocal.getPhotosLocal());
    }

    @GetMapping(value = "/photos/{id}")
    public ResponseEntity<Photo> getPhotosById(@PathVariable("id") Long id) {

        if(featureManager.isActive(MyFeatures.URL)){
            return ResponseEntity.ok(photoConsumerFeign.getPhotosById(id));
        }
        return ResponseEntity.ok(photoConsumerFeignLocal.getPhotosByIdLocal(id));
    }
}
