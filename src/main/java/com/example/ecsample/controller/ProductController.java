package com.example.ecsample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecsample.entity.Product;
import com.example.ecsample.mapper.ProductMapper;

@Controller
public class ProductController {
	private final ProductMapper productMapper;

	public ProductController(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@GetMapping("/products")
	public String showList(Model model) {
		//商品一覧ページを表示する
		List<Product> products = productMapper.findAll();
		model.addAttribute("products", products);
		return "product/list";
	}

	@GetMapping("/product/{id}")
	public String showDetail(@PathVariable("id") int id, Model model) {
		Product product = productMapper.findById(id);

		model.addAttribute("product", product);
		return "product/detail";
	}

	//	@GetMapping("/product/{id}")
	//	public String productDetail(
	//			@PathVariable("id") int id,
	//			@RequestParam(value = "coupon", required = false) String coupon
	//
	//	) {
	//		System.out.println("アクセスされたＩＤ：" + id);
	//		if (coupon != null) {
	//			System.out.println("クーポン:" + coupon);
	//		} else {
	//			System.out.println("クーポンなし");
	//		}
	//		return "product/detail";
	//	}
}