package com.jp.oms.controller;

import com.jp.oms.dtos.OnlineRequestDto;
import com.jp.oms.services.RequestHandlerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/handle/")
public class RequestHandlerController {
	@Autowired
	private RequestHandlerService requestHandlerService;


	@PostMapping("/onlineRequest")
	public ResponseEntity<?> onlineRequest(@Valid @RequestBody OnlineRequestDto onlineRequest) {
		return new ResponseEntity<>((requestHandlerService.handleOnlineRequest(onlineRequest)), HttpStatus.CREATED);
	}

	@PostMapping("/bulkRequest")
	public ResponseEntity<?> bulkRequest(@RequestBody MultipartFile bulkRequestFile) throws IOException {
		return new ResponseEntity<>((requestHandlerService.handleBulkRequest(bulkRequestFile)), HttpStatus.CREATED);
	}
}
