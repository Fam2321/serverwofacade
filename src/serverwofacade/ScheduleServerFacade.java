/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author 60050257
 */
public class ScheduleServerFacade {
    private static ScheduleServerFacade myFacade = null;
    private ScheduleServerFacade() {}
    public static ScheduleServerFacade get() {
        if (myFacade == null) {
            myFacade = new ScheduleServerFacade();
        }
        return myFacade;
    }
    
    public void start() {
        ScheduleServer scheduleServer = new ScheduleServer();
	scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
    }
    
    public void stop() {
        ScheduleServer scheduleServer = new ScheduleServer();
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
