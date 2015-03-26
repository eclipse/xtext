/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializedEObjectTokens extends AbstractEObjectTokens {
	private final SerializerBasedRegionAccess tokenAccess;
	private final AbstractElement grammarElement;
	private final EObject semanticElement;

	public SerializedEObjectTokens(SerializerBasedRegionAccess tokenAccess, AbstractElement grammarElement,
			EObject semanticElement) {
		super();
		this.tokenAccess = tokenAccess;
		this.grammarElement = grammarElement;
		this.semanticElement = semanticElement;
	}

	@Override
	public AbstractElement getGrammarElement() {
		return grammarElement;
	}

	@Override
	public EObject getSemanticElement() {
		return semanticElement;
	}

	public SerializerBasedRegionAccess getTokenAccess() {
		return tokenAccess;
	}
}