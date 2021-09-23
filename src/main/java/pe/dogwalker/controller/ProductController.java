package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Product;
import pe.dogwalker.model.entity.Supplier;
import pe.dogwalker.service.ProductService;
import pe.dogwalker.service.SupplierService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class ProductController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductService productService;
	
	@Inject
	private SupplierService supplierService;
	
	private Product product;
	private List<Product> products;
	private Product productSelect;
	
	private Supplier supplier;
	private List<Supplier> suppliers;
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		product = new Product();
		supplier = new Supplier();
		products = new ArrayList<Product>();
		suppliers = new ArrayList<Supplier>();
		
		getAllProducts();
	}
	
	
	public void getAllProducts() {
		try {
			products = productService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Productos: " + e.getMessage());
		}
	}
	
	public String newProduct() {
		try {
			this.suppliers = supplierService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/product/insert";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.product = new Product();
	}
	
	public String listProduct() {
		return "/product/list";
	}
	
	public String saveProduct() {

		String view = "";
		try {
			if (product.getId() != null) 
			{
				product.setSupplier(supplier);
				productService.update(product);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else 
			{
				product.setSupplier(supplier);
				productService.insert(product);
				Message.messageInfo("Registro Insertado Correctamente");				
			}
			this.getAllProducts();
			resetForm();
			view = "/product/list";
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editProduct() {
		String view = "";
		try 
		{
			if (this.productSelect != null) 
			{
				this.product = productSelect;
				view = "/product/update";
			}
			else 
			{
				Message.messageError("Debe Seleccionar un producto");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error  en producto: " + e.getMessage());
		}
		return view;
	}
	
	public String deleteProduct() {
		String view = "";
		try {
			this.product = productSelect;
			productService.delete(this.product);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllProducts();
			view = "/product/list";
		} catch (Exception e) {
			Message.messageError("Error en producto " + e.getMessage());
		}
		return view;
	}
	
	public void searchProductByName() {
		try {
			products = productService.findByName(this.filterName.trim());
			resetForm();
			if (products.isEmpty()) {
				Message.messageInfo("No se encontraron productos");
			}
		} catch (Exception e) {
			Message.messageError("Error en producto " + e.getMessage());
		}
	}
	
	public void productSelect(SelectEvent e) {
		this.productSelect = (Product)e.getObject();
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Product getProductSelect() {
		return productSelect;
	}


	public void setProductSelect(Product productSelect) {
		this.productSelect = productSelect;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public List<Supplier> getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
