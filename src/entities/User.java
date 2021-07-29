package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name, Password;
	private boolean isAdmin,AddInventory,EditInventory,AddProduct,EditProduct,Sales,DeleteProduct,Reports,UserManagement;
	
	public User(){
		   super();
		}
	
	
	public User(String name, String password, boolean isAdmin, boolean addInventory, boolean editInventory,
			boolean addProduct, boolean editProduct, boolean sales, boolean deleteProduct, boolean reports,
			boolean userManagement) {
		super();
		
		this.name = name;
		Password = password;
		this.isAdmin = isAdmin;
		AddInventory = addInventory;
		EditInventory = editInventory;
		AddProduct = addProduct;
		EditProduct = editProduct;
		Sales = sales;
		DeleteProduct = deleteProduct;
		Reports = reports;
		UserManagement = userManagement;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isAddInventory() {
		return AddInventory;
	}
	public void setAddInventory(boolean addInventory) {
		AddInventory = addInventory;
	}
	public boolean isEditInventory() {
		return EditInventory;
	}
	public void setEditInventory(boolean editInventory) {
		EditInventory = editInventory;
	}
	public boolean isAddProduct() {
		return AddProduct;
	}
	public void setAddProduct(boolean addProduct) {
		AddProduct = addProduct;
	}
	public boolean isEditProduct() {
		return EditProduct;
	}
	public void setEditProduct(boolean editProduct) {
		EditProduct = editProduct;
	}
	public boolean isSales() {
		return Sales;
	}
	public void setSales(boolean sales) {
		Sales = sales;
	}
	public boolean isDeleteProduct() {
		return DeleteProduct;
	}
	public void setDeleteProduct(boolean deleteProduct) {
		DeleteProduct = deleteProduct;
	}
	public boolean isReports() {
		return Reports;
	}
	public void setReports(boolean reports) {
		Reports = reports;
	}
	public boolean isUserManagement() {
		return UserManagement;
	}
	public void setUserManagement(boolean userManagement) {
		UserManagement = userManagement;
	}
	

}
