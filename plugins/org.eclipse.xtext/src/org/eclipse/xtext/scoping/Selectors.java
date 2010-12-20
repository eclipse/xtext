/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Selectors {
	
	public static ISelector selectByName(QualifiedName name) {
		return new ISelector.SelectByName(name);
	}
	
	public static ISelector selectByEObject(final EObject object) {
		return new ISelector.SelectByEObject(object);
	}

	public static ISelector selectAll() {
		return ISelector.SELECT_ALL;
	}
}
