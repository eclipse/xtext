/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.index;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AbstractDeclarativeNameProvider implements INameProvider {
	
	private PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("getName", 1,1, Collections.singletonList(this), new PolymorphicDispatcher.ErrorHandler<String>(){
	
		public String handle(Object[] params, Throwable throwable) {
			return null;
		}
	});

	public final String getGlobalName(EObject obj) {
		return dispatcher.invoke(obj);
	}
}
