/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EReferenceImpl;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class HoverReference extends EReferenceImpl {
	EClass clazz = null;

	public HoverReference(EClass clazz) {
		this.clazz = clazz;
	}

	@Override
	public EClass getEReferenceType() {
		return clazz;
	}
}
