package br.com.ifba;

import br.com.ifba.controller.CursoController;
import br.com.ifba.view.CursoListar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import javax.swing.SwingUtilities;

@SpringBootApplication
public class IfbaApplication implements CommandLineRunner {

    private final ApplicationContext context;

    public IfbaApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(IfbaApplication.class)
                .headless(false)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            // Obtém o controller do Spring
            CursoController controller = context.getBean(CursoController.class);
            
            // Passa para a view
            CursoListar frame = new CursoListar(controller);
            frame.setVisible(true);
        });
    }
}
