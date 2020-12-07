package com.xu.exceptions;

/**
 * @Description: 商品操作异常
 *
 */
public class ProductOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductOperationException(String msg) {
		super(msg);
	}
}
