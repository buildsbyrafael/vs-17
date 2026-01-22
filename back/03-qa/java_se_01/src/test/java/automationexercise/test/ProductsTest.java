package automationexercise.test;

import automationexercise.driver.DriverFactory;
import automationexercise.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void teste09_devePesquisarProdutoComSucesso() {
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

        productsPage.irParaProducts();

        Assert.assertTrue(productsPage.tituloAllProductsEstaVisivel());

        productsPage.pesquisarProduto("Tshirt");

        Assert.assertTrue(productsPage.tituloSearchedProductsEstaVisivel());
    }

    @Test
    public void teste10_deveVerificarDetalhesDoProduto() {
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

        productsPage.irParaProducts();
        productsPage.clicarNoPrimeiroProduto();

        Assert.assertTrue(productsPage.detalhesDoProdutoEstaoVisiveis());
    }
}