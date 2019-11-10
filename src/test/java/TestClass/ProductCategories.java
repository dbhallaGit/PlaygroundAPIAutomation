package TestClass;

public class ProductCategories {
	String ProductCategoryID,ProductCategoryName;
	public String getProductCategoryID() {
		return ProductCategoryID;
	}
	public void setProductCategoryID(String productCategoryID) {
		ProductCategoryID = productCategoryID;
	}
	public String getProductCategoryName() {
		return ProductCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		ProductCategoryName = productCategoryName;
	}
	public ProductCategories() {
		
	}
	public ProductCategories(String ProductCategoryID,String ProductCategoryName){
		this.ProductCategoryID=ProductCategoryID;
		this.ProductCategoryName=ProductCategoryName;
	}
}
