package automationexercise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    private By allProductsTitle = By.xpath("//h2[contains(text(), 'All Products')]");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[contains(text(), 'Searched Products')]");

    private By viewProductButtons = By.xpath("//a[contains(@href, '/product_details')]");

    private By productName = By.xpath("//div[@class='product-information']//h2");
    private By productCategory = By.xpath("//div[@class='product-information']//p[contains(text(), 'Category')]");
    private By productPrice = By.xpath("//div[@class='product-information']//span/span");
    private By productAvailability = By.xpath("//div[@class='product-information']//b[contains(text(), 'Availability')]");
    private By productCondition = By.xpath("//div[@class='product-information']//b[contains(text(), 'Condition')]");
    private By productBrand = By.xpath("//div[@class='product-information']//b[contains(text(), 'Brand')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean tituloAllProductsEstaVisivel() {
        return elementoEstaVisivel(allProductsTitle);
    }

    public void pesquisarProduto(String nomeProduto) {
        escrever(searchInput, nomeProduto);
        clicar(searchButton);
    }

    public boolean tituloSearchedProductsEstaVisivel() {
        return elementoEstaVisivel(searchedProductsTitle);
    }

    public void clicarNoPrimeiroProduto() {
        WebElement elemento = driver.findElements(viewProductButtons).get(0);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public boolean detalhesDoProdutoEstaoVisiveis() {
        return elementoEstaVisivel(productName) &&
                elementoEstaVisivel(productCategory) &&
                elementoEstaVisivel(productPrice) &&
                elementoEstaVisivel(productAvailability) &&
                elementoEstaVisivel(productCondition) &&
                elementoEstaVisivel(productBrand);
    }
}