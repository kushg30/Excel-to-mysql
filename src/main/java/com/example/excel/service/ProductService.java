package com.example.excel.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.excel.entity.Product;
import com.example.excel.helper.Helper;
import com.example.excel.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public void save(MultipartFile file) {
		try {
			List<Product> products = Helper.convertToListOfProduct(file.getInputStream());
			this.productRepo.saveAll(products);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}
}
