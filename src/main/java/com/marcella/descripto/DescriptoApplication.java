package com.marcella.descripto;

import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.marcella.descripto.model.Answer;

@SpringBootApplication
public class DescriptoApplication {

	private static final Logger LOG = LoggerFactory.getLogger(DescriptoApplication.class);
	// NÃO SEI PQ PRECISA DE UMA FACTORY DE LOG

	private static final String BASE_URL = "https://api.codenation.dev/v1/challenge/dev-ps";
	private static final String GET_ENDPOINT = "/generate-data?token=";
	private static final String POST_ENDPOINT = "/submit-solution?token=";
	private static final String TOKEN = "ee24d917a1b8b5bed3412ba20c54448094021af1";

	public static void main(String[] args) {
		// SpringApplication.run(DescriptoApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		Answer answer = restTemplate.getForObject(BASE_URL + GET_ENDPOINT + TOKEN, Answer.class);
		// NÃO SEI OQ É ISSO ^^
		// NÃO SEI PQ ENFIOU ESSE MONTE DE LOG
		LOG.info("Pré descriptografia: {}", answer);
		answer.decifrar();
		LOG.info("Pós descriptografia: {}", answer);
		FileStorage.writeFile(answer);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		MultipartFile multipartFile = null;
		try {
			multipartFile = new MockMultipartFile("answer.json", new FileInputStream(FileStorage.getFile()));
		} catch (IOException ioe) {
			LOG.error("Erro criando MultipartFile.", ioe);
		}

		MultiValueMap<String, MultipartFile> body = new LinkedMultiValueMap<>();
		body.add("answer", multipartFile);

		HttpEntity<MultiValueMap<String, MultipartFile>> requestEntity = new HttpEntity<>(body, headers);
		
		//ResponseEntity<String> responseEntity = restTemplate.postForEntity(BASE_URL + POST_ENDPOINT + TOKEN, requestEntity, String.class);
		
		//LOG.info(responseEntity.getBody());
	}

}
