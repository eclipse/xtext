/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.language;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.LanguageFacadeFactory;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class LanguageDescriptor {
	public final static String ID_ATTRIBUTE = "id";
	public final static String NAME_ATTRIBUTE = "name";
	public final static String LANGUAGEFACADE_CLASS_ATTRIBUTE = "languageFacade";

	private String id;
	private String name;
	private ILanguageFacade languageFacade;
	private String nameSpace;

	public LanguageDescriptor(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public LanguageDescriptor(String id) {
		this.id = id;
	}

	public LanguageDescriptor(IConfigurationElement element) throws CoreException {
		if (element == null)
			throw new IllegalArgumentException("ConfigurationElement cannot be null.");
		this.id = element.getAttribute(LanguageDescriptor.ID_ATTRIBUTE);
		if (getId() == null)
			throw new IllegalArgumentException("Id is requered and cannot be null.");
		this.name = element.getAttribute(LanguageDescriptor.NAME_ATTRIBUTE);
		this.languageFacade = (ILanguageFacade) element.createExecutableExtension(LANGUAGEFACADE_CLASS_ATTRIBUTE);
		this.nameSpace = element.getNamespaceIdentifier();
		LanguageFacadeFactory.register(languageFacade);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ILanguageFacade getLanguageFacade() {
		return languageFacade;
	}

	public String getNameSpace() {
		return nameSpace;
	}
}
