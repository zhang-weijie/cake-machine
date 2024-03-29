package cli.event.listener.persistencelistener;

import gl.AutomatInstanceManager;
import io.SaveWithJBP;
import cli.client.Client;
import cli.event.CMDEvent;

public class SaveJBPEventListener extends SaveStatusEventListener {
    public SaveJBPEventListener(AutomatInstanceManager automatInstanceManager) {
        super(automatInstanceManager);
    }

    @Override
    public void onCmdEvent(CMDEvent cmdEvent) {
        setSaveStrategy(new SaveWithJBP());
        boolean saved = getAutomat().save(Client.STATUS_JBP_FILE);
        if (saved){
            System.out.println("Zustand wurde mit JBP erfolgreich gespeichert!");
        } else {
            System.out.println("Speicherung schlug fehl!");
        }
    }
}