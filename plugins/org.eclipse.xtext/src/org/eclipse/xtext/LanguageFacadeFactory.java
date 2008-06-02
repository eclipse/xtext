/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.builtin.XtextBuiltinLanguageFacade;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public final class LanguageFacadeFactory {
	private LanguageFacadeFactory() {}
	
	private static Map<String,ILanguageFacade> registry = new HashMap<String, ILanguageFacade>();
	
	static {
		registry.put(XtextBuiltinLanguageFacade.ID, new XtextBuiltinLanguageFacade());
	}
	
	public static ILanguageFacade getFacade(String languageID) {
		return registry.get(languageID);
	}
	
	public static void register(ILanguageFacade facade) {
		registry.put(facade.getLanguageId(), facade);
	}
}
