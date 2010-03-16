/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractCrossReferenceSerializer implements ITokenSerializer.ICrossReferenceSerializer {

	public String serializeCrossRef(EObject context, CrossReference grammarElement, EObject target, AbstractNode node) {
		return null;
	}

	public boolean equalsOrReplacesNode(EObject context, CrossReference crossref, EObject target, AbstractNode node) {
		return false;
	}

}
