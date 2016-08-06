package marp.type;

public class ProductType extends Type {

	private static final long serialVersionUID = 1L;

	private static final String PRODUCT_CODE = "P";

	private static final String SERVICE_CODE = "S";

	public static ProductType PRODUCT = new ProductType(PRODUCT_CODE);

	public static ProductType SERVICE = new ProductType(SERVICE_CODE);

	public ProductType() {}

	public ProductType(String type) {
		super(type);
	}

	public boolean isProduct() {
		return code.equals(PRODUCT_CODE);
	}

	public boolean isSuppler() {
		return code.equals(SERVICE_CODE);
	}

	public String toDisplay() {
		switch(code) {
		case PRODUCT_CODE:
			return "Produkt";
		case SERVICE_CODE:
			return "Usługa";
		default:
			return "Niezidentyfikowany";
		}
	}

}
