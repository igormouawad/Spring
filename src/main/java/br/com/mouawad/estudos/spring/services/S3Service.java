package br.com.mouawad.estudos.spring.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3Service {

	private static final Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 amazonS3;

	@Value("${s3.bucket}")
	private String bucketName;

	public URI uploadFile(MultipartFile mpf) {
		try {
			String filename = mpf.getOriginalFilename();
			InputStream is = mpf.getInputStream();

			String contentType = mpf.getContentType();
			return uploadFile(is, filename, contentType);
		} catch (IOException e) {
			throw new RuntimeException("Erro de IO" + e.getMessage());
		}

	}

	public URI uploadFile(InputStream is, String FileName, String cotentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(cotentType);

			LOG.info("Inicia upload s3");
			amazonS3.putObject(bucketName, FileName, is, meta);
			LOG.info("TERMINA UPLOAD S3");

			return amazonS3.getUrl(bucketName, FileName).toURI();
		} catch (URISyntaxException e) {

			throw new RuntimeException("Erro ao converter URL para URI");
		}

	}
}
