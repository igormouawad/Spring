package br.com.mouawad.estudos.spring.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {
	
	private static final Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 amazonS3;
	
	@Value("${s3.bucket}")
	private String bucketName;

	
	
	public void uploadFile(String path) {
		try {
			LOG.info("Inicia upload s3");
		File file = new File(path);
		amazonS3.putObject(new PutObjectRequest(bucketName,"teste.jpg",file));
		LOG.info("TERMINA UPLOAD S3");
		
		}catch(AmazonServiceException e) {
			LOG.info("AmazonServiceException" + e.getErrorMessage());
			LOG.info("Status code" + e.getErrorCode());
		}catch(AmazonClientException e) {
			LOG.info("AmazonClientException" + e.getMessage());
		}

	}
}
