import com.labmedicine.model.Patient;
import com.labmedicine.model.Person;
import com.labmedicine.view.Menu;
import com.labmedicine.view.PatientView;

public class Main {
  public static void main(String[] args) {
    Menu menu = new Menu();
    PatientView patientView = new PatientView();

    Person person;

    menu.mainMenu();

    Integer opcao = menu.optionMenu();

    switch (opcao){
      case 1:
        person = new Patient();
        patientView.patientMenu();

    }


  }
}