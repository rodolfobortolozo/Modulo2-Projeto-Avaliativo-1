import com.labmedicine.model.Nurse;
import com.labmedicine.model.Patient;
import com.labmedicine.model.Person;
import com.labmedicine.view.Menu;
import com.labmedicine.view.NurseView;
import com.labmedicine.view.PatientView;

public class Main {
  public static void main(String[] args) {
    Menu menu = new Menu();
    PatientView patientView = new PatientView();
    NurseView nurseView = new NurseView();

    Person person;

    menu.mainMenu();

    Integer opcao = menu.optionMenu();

    switch (opcao){
      case 1:
        person = new Patient();
        patientView.patientMenu();
      case 2:
        person = new Nurse();
        nurseView.nurseMenu();
      default:
        System.out.println("Opção Inválida");
        menu.mainMenu();
    }


  }
}