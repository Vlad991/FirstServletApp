package com.infopulse.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ServletRequestAttributeListenerImp implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent e) {
        String name = e.getName();
        Object value = e.getValue();
        e.getServletRequest().setAttribute("newatr", name + value);
    }
}
