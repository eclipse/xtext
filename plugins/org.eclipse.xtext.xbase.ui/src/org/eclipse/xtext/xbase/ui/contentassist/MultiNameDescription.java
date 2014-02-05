/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.AbstractEObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MultiNameDescription extends AbstractEObjectDescription {

	private IEObjectDescription delegate;
	private List<QualifiedName> otherNames;

	public MultiNameDescription(IEObjectDescription delegate) {
		this.otherNames = Lists.newArrayListWithExpectedSize(3);
		this.delegate = delegate;
	}
	
	public void setDelegate(IEObjectDescription delegate) {
		this.delegate = delegate;
	}
	
	public IEObjectDescription getDelegate() {
		return delegate;
	}
	
	public List<QualifiedName> getOtherNames() {
		return otherNames;
	}
	
	public void addOtherName(QualifiedName name) {
		otherNames.add(name);
	}

	public QualifiedName getName() {
		return delegate.getName();
	}
	
	public QualifiedName getQualifiedName() {
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
	
	@Override
	public String toString() {
		return otherNames.toString() + delegate;
	}
	
}