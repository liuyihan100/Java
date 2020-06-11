package com.gui.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class BeanListener
 *
 */
@WebListener
public class BeanListener implements HttpSessionBindingListener {

    public void valueBound(HttpSessionBindingEvent event)  { 
         System.out.println("Bind...");
    }

    public void valueUnbound(HttpSessionBindingEvent event)  { 
         System.out.println("Unbind...");
    }
	
}
