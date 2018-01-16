/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
