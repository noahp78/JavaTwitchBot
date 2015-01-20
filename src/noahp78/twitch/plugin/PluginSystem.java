package noahp78.twitch.plugin;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.ServiceLoader;



public class PluginSystem {
	public static void Init() throws Exception{
		File loc = new File("plugins");

        File[] flist = loc.listFiles(new FileFilter() {
            public boolean accept(File file) {return file.getPath().toLowerCase().endsWith(".jar");}
        });
	        
        URL[] urls = new URL[flist.length];
        for (int i = 0; i < flist.length; i++)
            urls[i] = flist[i].toURI().toURL();
        URLClassLoader ucl = new URLClassLoader(urls);

        ServiceLoader<Plugin> sl = ServiceLoader.load(Plugin.class, ucl);
        Iterator<Plugin> apit = sl.iterator();
        while (apit.hasNext()){
        	Plugin a = apit.next();
        	if(a.onEnable()){
        		System.out.println("Loaded " + a.getName() + ":" + a.getVersion());
        	}else{
        		System.out.println("Could not load " + a.getName() + ":" + a.getVersion());
        	}
        	
        }
    	
	    }
	}

