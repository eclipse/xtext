/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.internal;

import org.eclipse.xtext.service.IServiceScope;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class ServiceScope implements IServiceScope {
	private String id;

	public ServiceScope(String id) {
		super();
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.service.IServiceScope#getId()
	 */
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("Scope ");
		buff.append(id);
		return buff.toString();
	}

}
