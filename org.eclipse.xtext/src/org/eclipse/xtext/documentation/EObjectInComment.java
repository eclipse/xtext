/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.16
 */
public class EObjectInComment {

	private final EObject eObject;
	private final ITextRegion region;

	public EObjectInComment(EObject eObject, ITextRegion region) {
		this.eObject = eObject;
		this.region = region;
	}

	public EObject getEObject() {
		return eObject;
	}

	public ITextRegion getRegion() {
		return region;
	}
}
