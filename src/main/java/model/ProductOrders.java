package model;

public class ProductOrders {
	private int orderId;
	private int productId;
	private int amountProduct;
	private int nameProduct;

	public ProductOrders() {

	}

	public ProductOrders(int orderId, int productId, int amountProduct, int nameProduct) {

		this.orderId = orderId;
		this.productId = productId;
		this.amountProduct = amountProduct;
		this.nameProduct = nameProduct;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public int getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(int nameProduct) {
		this.nameProduct = nameProduct;
	}

}
