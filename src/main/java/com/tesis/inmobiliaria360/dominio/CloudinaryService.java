package com.tesis.inmobiliaria360.dominio;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {
    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();


    public CloudinaryService() {
        valuesMap.put("cloud_name", "back-pragma");
        valuesMap.put("api_key", "913929357598725");
        valuesMap.put("api_secret", "A2n7jXaOVKVbRcFIg2J0bxj5s1k");
        cloudinary = new Cloudinary (valuesMap); // para crear una instantia de cloudinary

    }

    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        // Eliminamos el outputstring para no guardarlo en la carpeta del proyecto
        file.delete();
        return result;
    }

    public Map delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File (multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;

    }

    //Como estamos usando archivos multimedia por medio de API convertimos el multipart en un file




}
