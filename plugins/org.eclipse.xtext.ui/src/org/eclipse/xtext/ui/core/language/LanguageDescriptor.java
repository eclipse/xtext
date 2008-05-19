/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.language;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class LanguageDescriptor {
	public final static String ID_ATTRIBUTE = "id";
	public final static String NAME_ATTRIBUTE = "name";

	private String id;
	private String name;

	public LanguageDescriptor(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public LanguageDescriptor(String id) {
		this.id = id;
	}

	public LanguageDescriptor(IConfigurationElement element) {
		if (element == null)
			throw new IllegalArgumentException(
					"ConfigurationElement cannot be null.");
		this.id = element.getAttribute(LanguageDescriptor.ID_ATTRIBUTE);
		if (getId() == null)
			throw new IllegalArgumentException(
					"Id is requered and cannot be null.");
		this.name = element.getAttribute(LanguageDescriptor.NAME_ATTRIBUTE);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
