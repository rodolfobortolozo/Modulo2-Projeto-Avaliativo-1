import com.labmedicine.repository.mocks.Mocks;
import com.labmedicine.view.Menu;

public class Main {
  public static void main(String[] args) {
    Menu menu = new Menu();
    /*
        Inseri Dados Ficticios para Testes
     */
    Mocks mocks = new Mocks();

    mocks.insert();

    menu.mainMenu();
  }
}
