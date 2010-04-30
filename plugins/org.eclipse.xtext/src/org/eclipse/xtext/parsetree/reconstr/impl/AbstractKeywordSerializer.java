/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IKeywordSerializer;

/**
 * TODO: consider moving all methods to the default impl and removing this class
 * 
 * @author meysholdt - Initial contribution and API
 */
public class AbstractKeywordSerializer implements IKeywordSerializer {

	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, AbstractNode node) {
		return false;
	}

	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, AbstractNode node) {
		return false;
	}

	public String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, AbstractNode node) {
		return null;
	}

	public String serializeUnassignedKeyword(EObject context, Keyword keyword, AbstractNode node) {
		return null;
	}

}
