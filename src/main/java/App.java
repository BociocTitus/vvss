
import controller.EntryController;
import controller.MemberController;
import repository.EntryRepository;
import repository.MemberRepository;
import ui.MemberUI;


public class App {
    public static void main(String[] args) {

        MemberRepository repo = new MemberRepository();
        EntryRepository entryRepository = new EntryRepository();

        MemberController ctrl = new MemberController(repo);
        EntryController entryController = new EntryController(entryRepository);

        MemberUI console = new MemberUI(ctrl, entryController);
        console.Run();

    }
}
