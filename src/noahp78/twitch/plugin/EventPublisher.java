package noahp78.twitch.plugin;

import java.lang.reflect.Method;

public class EventPublisher {

    public static Boolean raiseEvent(final Event event) {
        new Thread() {
            @Override
            public void run() {
            	//First. Take Mod Timings
            	
                raise(event);
                }
        }.start();
		return event.isCancelled;
    }

    private static void raise(final Event event) {
        for (Class handler : HandlerRegistry.getHandlers()) {
            Method[] methods = handler.getMethods();

            for (int i = 0; i < methods.length; ++i) {
                EventHandler eventHandler = methods[i].getAnnotation(EventHandler.class);
                if (eventHandler != null) {
                    Class[] methodParams = methods[i].getParameterTypes();

                    if (methodParams.length < 1)
                        continue;

                    if (!event.getClass().getSimpleName()
                            .equals(methodParams[0].getSimpleName()))
                        continue;

                    // defence from runtime exceptions:
                    try {
                        methods[i].invoke(handler.newInstance(), event);
                    } catch (Exception e) {
                        System.err.println(e);
                       
                    }
                }
            }
        }
    }
}