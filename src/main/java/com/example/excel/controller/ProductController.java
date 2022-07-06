package com.example.excel.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.entity.Product;
import com.example.excel.helper.Helper;
import com.example.excel.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		if (Helper.checkExcelFormat(file) && !file.isEmpty()) {
			this.productService.save(file);

			return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db..."));
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Excel file only!");
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return this.productService.getAllProducts();
	}

}
