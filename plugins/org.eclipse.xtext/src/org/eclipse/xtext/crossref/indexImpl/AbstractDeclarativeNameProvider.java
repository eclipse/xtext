/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.indexImpl;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AbstractDeclarativeNameProvider implements INameProvider {
	
	private final Logger log = Logger.getLogger(getClass()); 

	public final String getGlobalName(EObject obj) {
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals("getName") && 
					method.getReturnType().equals(String.class) && 
					method.getParameterTypes().length==1 && 
					method.getParameterTypes()[0].isAssignableFrom(obj.getClass())) {
				try {
					method.setAccessible(true);
					return (String) method.invoke(this, obj);
				} catch (Exception e) {
					log.error(e.getMessage(),e);
				}
			}
		}
		return null;
	}
}
