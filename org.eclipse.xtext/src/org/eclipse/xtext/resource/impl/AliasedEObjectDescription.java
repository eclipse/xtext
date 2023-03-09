/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.AbstractEObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AliasedEObjectDescription extends AbstractEObjectDescription {

	private IEObjectDescription delegate;
	private QualifiedName alias;

	public AliasedEObjectDescription(QualifiedName alias, IEObjectDescription delegate) {
		this.alias = alias;
		this.delegate = delegate;
	}

	@Override
	public QualifiedName getName() {
		return alias;
	}
	
	@Override
	public QualifiedName getQualifiedName() {
		return delegate.getQualifiedName();
	}

	@Override
	public EObject getEObjectOrProxy() {
		return delegate.getEObjectOrProxy();
	}

	@Override
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

	@Override
	public EClass getEClass() {
		return delegate.getEClass();
	}
	
	public IEObjectDescription getAliasedEObjectDescription() {
		return delegate;
	}
	
}
