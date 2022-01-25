package com.vsoft.cursomc.services;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class S3Service {

    private Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    private AmazonS3 s3client;

    @Value("${s3.bucket}")
    private String bucketName;

    public void uploadFile(String localFilePath){
        try{
            File file = new File(localFilePath);
            s3client.putObject(new PutObjectRequest(bucketName, "teste.jpg", file));
            LOG.info("Upload finalizado com sucesso");
        } catch (AmazonServiceException e){
            LOG.info("AmazonServiceException: " + e.getErrorMessage());
            LOG.info("StatusCode: " + e.getErrorCode());
        } catch(AmazonClientException a){
            LOG.info("AmazonClientException: " + a.getMessage());
        }

    }
}
