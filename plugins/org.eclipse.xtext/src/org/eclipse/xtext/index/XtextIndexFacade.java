/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextIndexFacade implements IXtextIndexFacade {

	
	
	public Iterable<IEObjectDescription> findAllDescriptionsFor(EObject object) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> findAllEObjects(IContainer in, EClass type) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> findAllEObjects(IContainer container, EClass type, String name) {
		throw new UnsupportedOperationException();
	}

}
