/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.IScopedElement;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AliasedScopedElement extends AbstractScopedElement {

	private IScopedElement delegate;
	private String alias;

	public AliasedScopedElement(String alias, IScopedElement delegate) {
		super();
		this.alias = alias;
		this.delegate = delegate;
	}

	public Object additionalInformation() {
		return delegate.additionalInformation();
	}

	public EObject element() {
		return delegate.element();
	}

	public String name() {
		return alias;
	}

}
