package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.Generator;
import suport.Screenshot;


public class BlogTest {
    private WebDriver navegador;
    private WebDriverWait wt;
    private final String diretorio = "C:\\Users\\byanc\\IdeaProjects\\SOCTest\\screenshot\\";

    @Rule
    public TestName nomeDoTeste = new TestName();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\byanc\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        wt = new WebDriverWait(navegador,20);
        navegador.get("https://ww2.soc.com.br/blog/");
    }

    @Ignore
    public void testBuscaBlog () {
        String texto = "Tecnologia";
        BlogTestPO btpo = new BlogTestPO(wt);
        btpo.pesquisar(texto);
        String nomeArquivo = diretorio + Generator.dataHoraArquivo() + "_" + nomeDoTeste.getMethodName() + ".png";
        Screenshot.tirar(navegador,nomeArquivo );
    }

    @Test
    public void testCredenciadoBlog () {
        BlogTestPO btpo = new BlogTestPO(wt);
        String credenciado = "Santos, SP, Brasil";
        btpo.credenciado(credenciado);
        String nomeArquivo = diretorio + Generator.dataHoraArquivo() + "_" + nomeDoTeste.getMethodName() + ".png";
        Screenshot.tirar(navegador,nomeArquivo );
    }

    @After
    public void tearDown() {

        navegador.quit();
    }

}