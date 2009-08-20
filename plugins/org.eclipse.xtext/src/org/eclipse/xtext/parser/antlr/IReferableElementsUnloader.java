/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(IReferableElementsUnloader.NullUnloader.class)
public interface IReferableElementsUnloader {

	void unloadRoot(EObject root);
	
	public final class NullUnloader implements IReferableElementsUnloader {

		public void unloadRoot(EObject root) {
		}
		
	}
	
}
