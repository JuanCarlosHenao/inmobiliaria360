package com.tesis.inmobiliaria360.infraestructura.rest;

import com.tesis.inmobiliaria360.dominio.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
@RestController
@RequestMapping("/cloudinaryImages")
@CrossOrigin
public class CloudinaryController {

    @Autowired
    CloudinaryService cloudinaryService;

//    public CloudinaryController(CloudinaryService cloudinaryService) {
//        this.cloudinaryService = cloudinaryService;
//    }

    //	ImageService imageService;
//
//	@GetMapping("/list")
//	public ResponseEntity<List<Image>> list(){
//		List<Image> list = imageService.list();
//		return new ResponseEntity(list, HttpStatus.OK);
//	}


    // Post
    @PostMapping("/uploadImage")
    public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi= ImageIO.read(multipartFile.getInputStream());
        if(bi==null) {
            return new ResponseEntity("Imagen no valida", HttpStatus.BAD_REQUEST);
        }
        Map result=cloudinaryService.upload(multipartFile);
        return new ResponseEntity(result, HttpStatus.OK);
    }



//	// para subir imagen a la BD
//	@PostMapping("/uploadImage")
//	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException{
//		BufferedImage bi= ImageIO.read(multipartFile.getInputStream());
//		if(bi==null) {
//			return new ResponseEntity(new Message ("Imagen no válida "), HttpStatus.BAD_REQUEST);
//		}
//		Map result=cloudinaryService.upload(multipartFile);
//		Image image = new Image((String) result.get("original_filename"),
//				(String) result.get("url"),
//				(String) result.get("public_id"));
//		imageService.save(image);
////		return new ResponseEntity(result, HttpStatus.OK);
//		return new ResponseEntity(new Message ("Imagen subida con exito"), HttpStatus.OK);
//	}


//    @DeleteMapping("/deleteImage/{id}")
//    public ResponseEntity<Map> delete(@PathVariable("id") String id) throws IOException{
//        Map result=cloudinaryService.delete(id);
//        return new ResponseEntity(result, HttpStatus.OK);
//    }

//	@DeleteMapping("/deleteImage/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException{
//		if (!imageService.exists(id)) {
//			return new ResponseEntity(new Message ("La imagen no eiste "), HttpStatus.NOT_FOUND);
//		}
//		Image image = imageService.getOne(id).get(); // acá el optional lo convertimos en image
//		Map result=cloudinaryService.delete(image.getImageIdCloud()); // acá se borraria la imagen en cloudinar
//		imageService.delete(id);
////		return new ResponseEntity(result, HttpStatus.OK);
//		return new ResponseEntity(new Message("Imagen elimnada"), HttpStatus.OK);
//
//	}


}
