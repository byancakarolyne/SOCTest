package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.Generator;
import suport.Screenshot;
import tests.BlogTestPO;

public class PesquisaBlogStep {
    private WebDriver navegador;
    private WebDriverWait wt;
    private final String diretorio = "C:\\Users\\byanc\\IdeaProjects\\SOCTest\\screenshot\\";

    @Rule
    public TestName nomeDoTeste = new TestName();

    @Dado("que estou acessando a aplicação")
    public void que_estou_acessando_a_aplicação() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\byanc\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        wt = new WebDriverWait(navegador,20);
        navegador.get("https://ww2.soc.com.br/blog/");
        navegador.manage().window().maximize();
    }

    @Entao("efetuarei uma pesquisa por {string}")
    public void efetuarei_uma_pesquisa_por(String pesquisaTema) {
        BlogTestPO btpo = new BlogTestPO(wt);
        btpo.pesquisar(pesquisaTema);
        String nomeArquivo = diretorio + Generator.dataHoraArquivo() + "_" + "efetuarei_uma_pesquisa_por" + pesquisaTema + ".png";
        Screenshot.tirar(navegador,nomeArquivo );
        navegador.quit();
    }

}
