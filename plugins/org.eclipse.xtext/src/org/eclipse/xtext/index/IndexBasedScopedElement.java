/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.xtext.scoping.impl.AbstractScopedElement;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class IndexBasedScopedElement extends AbstractScopedElement {
	
	private String name;
	private EObject element;
	
	IndexBasedScopedElement(EObjectDescriptor descriptor) {
		super();
		name = descriptor.getName();
		element = createProxy(descriptor);
	}

	private EObject createProxy(EObjectDescriptor descriptor) {
		EClass eclass = descriptor.getEClass();
		EObject obj = eclass.getEPackage().getEFactoryInstance().create(eclass);
		((InternalEObject)obj).eSetProxyURI(descriptor.getFragmentURI());
		return obj;
	}
	
	public EObject element() {
		return element;
	}

	public String name() {
		return name;
	}

}
