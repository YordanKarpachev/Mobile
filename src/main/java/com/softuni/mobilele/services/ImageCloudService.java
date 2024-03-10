package com.softuni.mobilele.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageCloudService {


        private Cloudinary cloudinary;
        private final String CLOUD_NAME = "dsldgrzba";
        private final String RESOURCE_TYPE = "image";
    public ImageCloudService() {
        String cloudName = System.getenv("CLOUDINARY_CLOUD_NAME");
        String apiKey = System.getenv("CLOUDINARY_API_KEY");
        String apiSecret = System.getenv("CLOUDINARY_API_SECRET");

        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", true
        ));
    }
        public String saveImage(MultipartFile multipartFile){
        String imageId = UUID.randomUUID().toString();
        Map params = ObjectUtils.asMap(
                "public_id", imageId,
                "overwrite" ,true ,
                "resource_type" , "image"
        ) ;
        File tmpFile = new File(imageId);

        try{
            Files.write(tmpFile.toPath(), multipartFile.getBytes());
            cloudinary.uploader().upload(tmpFile, params);
            Files.delete(tmpFile.toPath());
        } catch (IOException e){
            throw  new RuntimeException(e);
        }

        return String.format("https://res.cloudinary.com/%s/%s/upload/f_auto,q_auto/%s.%s" , CLOUD_NAME, RESOURCE_TYPE,imageId,getFileExtension(multipartFile.getOriginalFilename()) );
    }

        private String getFileExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }



}
