package com.Santander.Santander;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class NameImageController {

	@Autowired
	private NameImageRepository nameImageRepository;

	@PostMapping("/bookImage")
	public NameImage addBookImage(@RequestParam String name, @RequestParam MultipartFile file) throws IOException {
		NameImage nameImage = new NameImage();
		nameImage.setName(name);
		nameImage.setImage(new Binary(file.getBytes()));

		return nameImageRepository.save(nameImage);
	}

	@GetMapping("/getBookImageData")
	public String getBookImageData(@RequestParam String id) {
		Optional<NameImage> nameImage = nameImageRepository.findById(id);
		Encoder encoder = Base64.getEncoder();

		return encoder.encodeToString(nameImage.get().getImage().getData());

	}

	@GetMapping("/getBookImage")
	public ResponseEntity<byte[]> getBookImage(@RequestParam String id) throws SQLException {
		
		Optional<NameImage> nameImage = nameImageRepository.findById(id);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    return new ResponseEntity<>(nameImage.get().getImage().getData(), headers, HttpStatus.OK);
		
		
	}

}
