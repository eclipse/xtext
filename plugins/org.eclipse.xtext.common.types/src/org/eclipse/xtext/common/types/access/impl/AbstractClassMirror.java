/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.IdentifyableElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractClassMirror implements IClassMirror {

	public String getFragment(EObject obj) {
		if (obj instanceof IdentifyableElement)
			return ((IdentifyableElement) obj).getCanonicalName();
		return null;
	}
	
}
