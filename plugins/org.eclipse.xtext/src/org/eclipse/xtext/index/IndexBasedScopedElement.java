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
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.xtext.scoping.impl.AbstractScopedElement;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class IndexBasedScopedElement extends AbstractScopedElement {
	
	private EObjectDescriptor descriptor;
	
	IndexBasedScopedElement(EObjectDescriptor descriptor) {
		super();
		this.descriptor = descriptor;
	}

	/**
	 * @return the user data map of the EObjectDescriptor.
	 */
	public Object additionalInformation() {
		return descriptor.getUserData();
	}

	public EObject element() {
		EClass eclass = descriptor.getEClassDescriptor().getEClass();
		EObject obj = eclass.getEPackage().getEFactoryInstance().create(eclass);
		((InternalEObject)obj).eSetProxyURI(descriptor.getFragmentURI());
		return obj;
	}

	public String name() {
		return descriptor.getName();
	}
	
}
