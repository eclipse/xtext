/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringEObjectRegion extends AbstractEObjectRegion {

	public StringEObjectRegion(StringBasedRegionAccess access, EObject grammarElement, EObject semanticElement) {
		super(access);
		this.setGrammarElement(grammarElement);
		this.setSemanticElement(semanticElement);
	}
}
