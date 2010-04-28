/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(IReferableElementsUnloader.NullUnloader.class)
public interface IReferableElementsUnloader {

	void unloadRoot(EObject root);
	
	final class NullUnloader implements IReferableElementsUnloader {

		public void unloadRoot(EObject root) {
		}
		
	}
	
	final class GenericUnloader implements IReferableElementsUnloader {

		public void unloadRoot(EObject root) {
			for(Iterator<EObject> i = EcoreUtil.getAllProperContents(root, false); i.hasNext();) {
				final EObject next = i.next();
				next.eAdapters().clear();
				((InternalEObject) next).eSetProxyURI(EcoreUtil.getURI(next));
			}
			((InternalEObject) root).eSetProxyURI(EcoreUtil.getURI(root));
			root.eAdapters().clear();

		}
		
	}
	
}
