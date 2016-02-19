import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
            if (findProduct(item.getID()) == null) {
                stock.add(item);
            }
            else {
                System.out.println("El id de este producto ya esta en uso el el stock.");
            }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product producto = findProduct(id);
        if(producto != null){
            producto.increaseQuantity(amount);
        }
        else{
            System.out.println("El id indicado no pertenece a ningun producto");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product productoEncontrado = null;       
        int index = 0;
        boolean encontrado = false;
        while (index < stock.size() && !encontrado) {  
            Product producto = stock.get(index);
            if (id == producto.getID()) {
                productoEncontrado = producto;
                encontrado = true;                
            }
            index++;
        }
        return productoEncontrado;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int cuantosProductosHay = 0;
        Product producto = findProduct(id); 
        if (producto != null) {
            cuantosProductosHay = producto.getQuantity();
        }
        return cuantosProductosHay;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product producto : stock) {
            System.out.println(producto);
        }
    }

    /**
     * Imprime los detalles de todos los productos cuyo stock está por debajo de un determinado número que será pasado como parámetro
     */
    public void underGivenNumberInStock(int stockMaximo)
    {
        boolean hayStockPorDebajo = false;
        for (Product producto : stock) {
            if (producto.getQuantity() < stockMaximo) {
                System.out.println(producto.toString());
                hayStockPorDebajo = true;
            }
        }
        if (hayStockPorDebajo == false) {
            System.out.println("No hay productos con stock por debajo de " + stockMaximo);
        }
    }
    
    /**
     * Permite encontrar productos por su nombre
     */
    public Product findProduct(String name)
    {
        int index = 0;
        boolean productoEncontrado = false;
        Product productoBuscado = null;        
        while (index < stock.size() && !productoEncontrado) {
            Product producto = stock.get(index);
            if (producto.getName().contains(name)) {
                productoBuscado = producto;
                productoEncontrado = true;
            }
            index++;
        }
        return productoBuscado;
    }
}
