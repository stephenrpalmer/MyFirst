/**
 *
 */
package com.sap.hybris.productreview.webservices;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.hybris.productreview.facades.ProductReviewDTO;
import com.sap.hybris.productreview.facades.ProductReviewFacade;

/**
 *
 *
 */
@RestController
public class ProductReviewWebService {

	@Resource
	private ProductReviewFacade productReviewFacade;

	@RequestMapping("/review")
	public ProductReviewDTO getProductReview(@RequestParam(value = "code") String code) {

		ProductReviewDTO productReviewDTO = productReviewFacade.getProductReviewByCode(code);
		return productReviewDTO;
	}
}
