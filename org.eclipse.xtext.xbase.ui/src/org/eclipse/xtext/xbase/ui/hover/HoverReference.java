/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
