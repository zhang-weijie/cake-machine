import cli.console.ConsoleImpl;
import gl.Automat;
import gl.AutomatInstanceManager;
import cli.client.Client;
import cli.event.CMDEventHandler;
import cli.event.listener.herstellerlistener.InsertHerstellerEventListener;
import cli.event.listener.herstellerlistener.ShowHerstellerEventListener;
import cli.event.listener.kuchenlistener.*;
import cli.event.listener.persistencelistener.LoadJBPEventListener;
import cli.event.listener.persistencelistener.LoadJOSEventListener;
import cli.event.listener.persistencelistener.SaveJBPEventListener;
import cli.event.listener.persistencelistener.SaveJOSEventListener;
import cli.event.source.ManageHerstellerEventSource;
import cli.event.source.ManageKuchenEventSource;
import cli.event.source.PersistenceEventSource;
import cli.oberserver.AllergenBeobachter;
import cli.oberserver.CapacityBeobachter;
import cli.oberserver.KuchenBeobachter;

public class CliAlternative {
    public static void main(String[] args) {
        int maxCapacity;
        Automat automat;
        try {
            switch (args.length) {
                case 1:
                    maxCapacity = Integer.parseInt(args[0]);
                    automat = new Automat(maxCapacity);
                    CapacityBeobachter capacityBeobachter = new CapacityBeobachter(automat);
                    automat.meldeAn(capacityBeobachter);
                    AutomatInstanceManager automatInstanceManager = AutomatInstanceManager.getInstance();
                    automatInstanceManager.setAutomat(automat);

                    DeleteKuchenEventListener deleteKuchenEventListener = new DeleteKuchenEventListener(automatInstanceManager);
                    InsertKuchenEventListener insertKuchenEventListener = new InsertKuchenEventListener(automatInstanceManager);
                    ReadAllKuchenEventListener readAllKuchenEventListener = new ReadAllKuchenEventListener(automatInstanceManager);
                    ReadMuerbeKuchenEventListener readMuerbeKuchenEventListener = new ReadMuerbeKuchenEventListener(automatInstanceManager);
                    ReadHefeKuchenEventListener readHefeKuchenEventListener = new ReadHefeKuchenEventListener(automatInstanceManager);
//        ShowIncludedAllergenEventListener showIncludedAllergenEventListener = new ShowIncludedAllergenEventListener(automatInstanceManager);
//        ShowExcludedAllergenEventListener showExcludedAllergenEventListener = new ShowExcludedAllergenEventListener(automatInstanceManager);
                    UpdateKuchenEventListener updateKuchenEventListener = new UpdateKuchenEventListener(automatInstanceManager);

                    CMDEventHandler deleteKuchenEventHandler = new CMDEventHandler();
                    CMDEventHandler insertKuchenEventHandler = new CMDEventHandler();
                    CMDEventHandler readAllKuchenEventHandler = new CMDEventHandler();
                    CMDEventHandler readMuerbeKuchenEventHandler = new CMDEventHandler();
                    CMDEventHandler readHefeKuchenEventHandler = new CMDEventHandler();
//        CMDEventHandler showIncludedAllergenEventHandler = new CMDEventHandler();
//        CMDEventHandler showExcludedAllergenEventHandler = new CMDEventHandler();
                    CMDEventHandler updateKuchenEventHandler = new CMDEventHandler();

                    deleteKuchenEventHandler.addListener(deleteKuchenEventListener);
                    insertKuchenEventHandler.addListener(insertKuchenEventListener);
                    readAllKuchenEventHandler.addListener(readAllKuchenEventListener);
                    readMuerbeKuchenEventHandler.addListener(readMuerbeKuchenEventListener);
                    readHefeKuchenEventHandler.addListener(readHefeKuchenEventListener);
//        showIncludedAllergenEventHandler.addListener(showIncludedAllergenEventListener);
//        showExcludedAllergenEventHandler.addListener(showExcludedAllergenEventListener);
                    updateKuchenEventHandler.addListener(updateKuchenEventListener);

                    ManageKuchenEventSource manageKuchenEventSource = new ManageKuchenEventSource();
                    manageKuchenEventSource.setDeleteKuchenEventHandler(deleteKuchenEventHandler);
                    manageKuchenEventSource.setInsertKuchenEventHandler(insertKuchenEventHandler);
                    manageKuchenEventSource.setReadAllKuchenEventHandler(readAllKuchenEventHandler);
                    manageKuchenEventSource.setReadMuerbeKuchenEventHandler(readMuerbeKuchenEventHandler);
                    manageKuchenEventSource.setReadHefeKuchenEventHandler(readHefeKuchenEventHandler);
//        manageKuchenEventSource.setShowIncludedAllergenEventHandler(showIncludedAllergenEventHandler);
//        manageKuchenEventSource.setShowExcludedAllergenEventHandler(showExcludedAllergenEventHandler);
                    manageKuchenEventSource.setUpdateKuchenEventHandler(updateKuchenEventHandler);

                    InsertHerstellerEventListener insertHerstellerEventListener = new InsertHerstellerEventListener(automatInstanceManager);
//        DeleteHerstellerEventListener deleteHerstellerEventListener = new DeleteHerstellerEventListener(automatInstanceManager);
                    ShowHerstellerEventListener showHerstellerEventListener = new ShowHerstellerEventListener(automatInstanceManager);

                    CMDEventHandler insertHerstellerEventHandler = new CMDEventHandler();
//        CMDEventHandler deleteHerstellerEventHandler = new CMDEventHandler();
                    CMDEventHandler showHerstellerEventHandler = new CMDEventHandler();

                    insertHerstellerEventHandler.addListener(insertHerstellerEventListener);
//        deleteHerstellerEventHandler.addListener(deleteHerstellerEventListener);
                    showHerstellerEventHandler.addListener(showHerstellerEventListener);

                    ManageHerstellerEventSource manageHerstellerEventSource = new ManageHerstellerEventSource();
//        manageHerstellerEventSource.setDeleteHerstellerEventHandler(deleteHerstellerEventHandler);
                    manageHerstellerEventSource.setInsertHerstellerEventHandler(insertHerstellerEventHandler);
                    manageHerstellerEventSource.setShowHerstellerEventHandler(showHerstellerEventHandler);

                    SaveJOSEventListener saveJOSEventListener = new SaveJOSEventListener(automatInstanceManager);
                    SaveJBPEventListener saveJBPEventListener = new SaveJBPEventListener(automatInstanceManager);
                    LoadJOSEventListener loadJOSEventListener = new LoadJOSEventListener(automatInstanceManager);
                    LoadJBPEventListener loadJBPEventListener = new LoadJBPEventListener(automatInstanceManager);

                    CMDEventHandler saveJOSEventHandler = new CMDEventHandler();
                    CMDEventHandler saveJBPEventHandler = new CMDEventHandler();
                    CMDEventHandler loadJOSEventHandler = new CMDEventHandler();
                    CMDEventHandler loadJBPEventHandler = new CMDEventHandler();

                    saveJOSEventHandler.addListener(saveJOSEventListener);
                    saveJBPEventHandler.addListener(saveJBPEventListener);
                    loadJOSEventHandler.addListener(loadJOSEventListener);
                    loadJBPEventHandler.addListener(loadJBPEventListener);

                    PersistenceEventSource persistenceEventSource = new PersistenceEventSource();
                    persistenceEventSource.setSaveJOSEventHandler(saveJOSEventHandler);
                    persistenceEventSource.setSaveJBPEventHandler(saveJBPEventHandler);
                    persistenceEventSource.setLoadJOSEventHandler(loadJOSEventHandler);
                    persistenceEventSource.setLoadJBPEventHandler(loadJBPEventHandler);
                    Client client = new Client(new ConsoleImpl(), manageHerstellerEventSource, manageKuchenEventSource, persistenceEventSource);
                    client.run();
                    break;
                default:
                    System.out.println("Falsche Anzahl von Argumenten!");

            }
        } catch (Exception exception) {
            System.out.println("Falsche Argumente");
        }
    }
}