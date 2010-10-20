/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.scoping.newapi.ISelector.SelectByEObject;
import org.eclipse.xtext.xbase.scoping.newapi.ISelector.SelectByName;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Selectors {
	
	public static SelectByName byName(QualifiedName qualifiedName) {
		return new SelectByName(qualifiedName);
	}
	
	public static SelectByName byName(QualifiedName qualifiedName, final ISelector additionalSelectionCriteria) {
		return new SelectByName(qualifiedName) {
			@Override
			public boolean apply(IEObjectDescription input) {
				return super.apply(input) && additionalSelectionCriteria.apply(input);
			}
		};
	}
	
	public static SelectByEObject byEObject(EObject object) {
		return new SelectByEObject(object);
	}

	public static SelectByEObject byEObject(EObject object, final ISelector selector) {
		return new SelectByEObject(object) {
			@Override
			public boolean apply(IEObjectDescription input) {
				return super.apply(input) && selector.apply(input);
			}
		};
	}
}
