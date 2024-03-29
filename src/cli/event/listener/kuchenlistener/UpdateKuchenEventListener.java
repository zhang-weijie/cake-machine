package cli.event.listener.kuchenlistener;
/*
 * Name: Weijie Zhang
 * Matrikelnummer: s0582504
 */

import gl.AutomatInstanceManager;
import cli.event.CMDEvent;
import cli.event.CMDEventListener;

/**
 * @author Weijie Zhang, weijiezhangpku@gmail.com
 * @version 1.0
 */
public class UpdateKuchenEventListener extends CMDEventListener {


    public UpdateKuchenEventListener(AutomatInstanceManager automatInstanceManager) {
        super(automatInstanceManager);
    }

    @Override
    public void onCmdEvent(CMDEvent cmdEvent) {
        String[] args = cmdEvent.getArgs();
        try {
            boolean updated = getAutomat().updateKuchen(Integer.parseInt(args[0]));
            if (updated){
                System.out.println("Kuchen wurde aktualisiert!");
            } else {
                System.out.println("Falsche Fachnummer oder Leeres Fach!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ungueltige Fachnummer!");
        }
    }
}