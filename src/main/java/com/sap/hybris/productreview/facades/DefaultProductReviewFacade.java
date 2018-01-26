package com.sap.hybris.productreview.facades;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sap.hybris.productreview.ProductReview;
import com.sap.hybris.productreview.ProductReviewService;

/**
 *
 *
 */
@Service
public class DefaultProductReviewFacade implements ProductReviewFacade {

	@Resource
	private ProductReviewService productReviewService;

	@Override
	public ProductReviewDTO addProductReview(ProductReviewDTO productReviewDTO) {
		ProductReview productReview = convertDTOToProductReview(productReviewDTO);
		productReview = productReviewService.addProductReview(productReview);
		ProductReviewDTO result = convertProductReviewToDTO(productReview);
		return result;
	}

	@Override
	public ProductReviewDTO getProductReviewByCode(String code) {
		ProductReview productReview = productReviewService.getProductReviewByCode(code);
		ProductReviewDTO result = convertProductReviewToDTO(productReview);
		return result;
	}

	private static ProductReviewDTO convertProductReviewToDTO(ProductReview productReview) {
		ProductReviewDTO productReviewDTO = new ProductReviewDTO();
		productReviewDTO.setCode(productReview.getCode());
		productReviewDTO.setContext(productReview.getContext());
		productReviewDTO.setCreated(productReview.getCreated());
		productReviewDTO.setProduct(productReview.getProduct());
		productReviewDTO.setRating(productReview.getRating());
		productReviewDTO.setReviewer(productReview.getReviewer());
		productReviewDTO.setTags(productReview.getTags());
		productReviewDTO.setText(productReview.getText());
		return productReviewDTO;
	}

	private static ProductReview convertDTOToProductReview(ProductReviewDTO productReviewDTO) {
		ProductReview productReview = new ProductReview();
		productReview.setCode(productReviewDTO.getCode());
		productReview.setContext(productReviewDTO.getContext());
		productReview.setCreated(productReviewDTO.getCreated());
		productReview.setProduct(productReviewDTO.getProduct());
		productReview.setRating(productReviewDTO.getRating());
		productReview.setReviewer(productReviewDTO.getReviewer());
		productReview.setTags(productReviewDTO.getTags());
		productReview.setText(productReviewDTO.getText());
		return productReview;
	}

}
