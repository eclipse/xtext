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
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;

/**
 * @author meysholdt - Initial contribution and API
 */
public class DefaultKeywordSerializer extends AbstractKeywordSerializer {

	@Override
	public String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, AbstractNode node) {
		if (node != null && node.getGrammarElement() == keyword)
			return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		return keyword.getValue();
	}

	@Override
	public String serializeUnassignedKeyword(EObject context, Keyword keyword, AbstractNode node) {
		if (node != null && node.getGrammarElement() == keyword)
			return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		return keyword.getValue();
	}

	@Override
	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, AbstractNode node) {
		return node.getGrammarElement() == keyword;
	}

	@Override
	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, AbstractNode node) {
		return node.getGrammarElement() == keyword;
	}

}
