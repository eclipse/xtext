/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service;


/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class LanguageDescriptor implements ILanguageDescriptor {
	private String id;
	private String name;
	private String nameSpace;

	public LanguageDescriptor(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public LanguageDescriptor(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
     * @see org.eclipse.xtext.service.ILanguageDescriptor#getId()
     */
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
     * @see org.eclipse.xtext.service.ILanguageDescriptor#getName()
     */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
     * @see org.eclipse.xtext.service.ILanguageDescriptor#getNameSpace()
     */
	public String getNameSpace() {
		return nameSpace;
	}
}
