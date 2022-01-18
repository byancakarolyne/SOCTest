package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class BlogTestPO {

    private WebDriverWait wtNavegador;
    private By byBarraPesquisa;
    private By byBotaoPesquisaTexto;
    private By byMenuFuncionalidade;
    private By bySubMenuFuncionalidadeRedeSoc;
    private By byBotaoCredenciado;
    private By byBotaoPesquisaCredenciado;
    private By byFiltroWifi;
    private By byFiltroLaudo;
    private By byBotaoSaibaMais;
    private By byBotaoEscondeFiltros;

    public BlogTestPO(WebDriverWait waitNavegador) {
        wtNavegador = waitNavegador;
        byBarraPesquisa = By.className("elementor-search-form__toggle");
        byBotaoPesquisaTexto = By.className("elementor-search-form__input");
        byMenuFuncionalidade = By.linkText("Funcionalidades");
        bySubMenuFuncionalidadeRedeSoc = By.linkText("Rede SOCNET");
        byBotaoCredenciado = By.linkText("Buscar credenciados");
        byBotaoPesquisaCredenciado = By.id("ipt-busca-credenciado-2");
        byFiltroWifi = By.cssSelector("#div-filtro-conveniencias > section > div:nth-child(1) > label > span.nome-filtro");
        byFiltroLaudo = By.xpath("//*[@id=\"conteudo-resultados\"]/div[1]/div/div[1]/div/section");
        byBotaoSaibaMais = By.xpath("//*[@id=\"conteudo-resultados\"]/div[1]/div/div[1]/div/section/div[2]/a/button");
        byBotaoEscondeFiltros = By.xpath("//*[@id=\"root\"]/div/button");
    }

    public void pesquisar(String pesquisa) {
        WebElement barraPesquisa = wtNavegador.until(ExpectedConditions.elementToBeClickable(byBarraPesquisa));
        barraPesquisa.click();
        WebElement botaoPesquisa = wtNavegador.until(ExpectedConditions.elementToBeClickable(byBotaoPesquisaTexto));
        botaoPesquisa.sendKeys(pesquisa);
        //botaoPesquisa.click();
        botaoPesquisa.sendKeys((Keys.ENTER));
    }

    public void credenciado (String crendenciado) {
        WebElement menuFuncionalidade = wtNavegador.until(ExpectedConditions.elementToBeClickable(byMenuFuncionalidade));
        menuFuncionalidade.click();
        WebElement subMenuFuncionalidade = wtNavegador.until(ExpectedConditions.elementToBeClickable(bySubMenuFuncionalidadeRedeSoc));
        subMenuFuncionalidade.click();
        WebElement botaoBuscarCredenciado = wtNavegador.until(ExpectedConditions.elementToBeClickable(byBotaoCredenciado));
        botaoBuscarCredenciado.click();
        WebElement botaoPesquisaCredenciado = wtNavegador.until(ExpectedConditions.elementToBeClickable(byBotaoPesquisaCredenciado));
        botaoPesquisaCredenciado.click();
        botaoPesquisaCredenciado.sendKeys(crendenciado);
        botaoPesquisaCredenciado.sendKeys(Keys.ENTER);
        wtNavegador.until(ExpectedConditions.elementToBeClickable(byFiltroWifi)).click();
        wtNavegador.until(ExpectedConditions.elementToBeClickable(byBotaoSaibaMais)).click();
    }
}
