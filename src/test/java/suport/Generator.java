package suport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Generator {
    public static String dataHoraArquivo () {
        LocalDateTime l = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
        return dtf.format(l);
    }
}
