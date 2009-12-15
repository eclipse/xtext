/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.AbstractEObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AliasedEObjectDescription extends AbstractEObjectDescription {

	private IEObjectDescription delegate;
	private String alias;

	public AliasedEObjectDescription(String alias, IEObjectDescription delegate) {
		super();
		this.alias = alias;
		this.delegate = delegate;
	}

	public String getName() {
		return alias;
	}
	
	public String getQualifiedName() {
		return delegate.getQualifiedName();
	}

	public EObject getEObjectOrProxy() {
		return delegate.getEObjectOrProxy();
	}

	public URI getEObjectURI() {
		return delegate.getEObjectURI();
	}

	@Override
	public String getUserData(String name) {
		return delegate.getUserData(name);
	}

	@Override
	public String[] getUserDataKeys() {
		return delegate.getUserDataKeys();
	}

	public EClass getEClass() {
		return delegate.getEClass();
	}

}
