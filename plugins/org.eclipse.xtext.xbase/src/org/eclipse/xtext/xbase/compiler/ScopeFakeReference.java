/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EReferenceImpl;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.4
 */
public class ScopeFakeReference extends EReferenceImpl {
	EClass clazz = null;

	public ScopeFakeReference(EClass clazz) {
		this.clazz = clazz;
	}

	@Override
	public EClass getEReferenceType() {
		return clazz;
	}
}
