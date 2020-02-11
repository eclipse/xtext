/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IKeywordSerializer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractKeywordSerializer implements IKeywordSerializer {

	@Override
	public String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, INode node) {
		if (node != null && node.getGrammarElement() == keyword)
			return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		return keyword.getValue();
	}

	@Override
	public String serializeUnassignedKeyword(EObject context, Keyword keyword, INode node) {
		if (node != null && node.getGrammarElement() == keyword)
			return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		return keyword.getValue();
	}
	
	@Override
	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, INode node) {
		return node.getGrammarElement() == keyword;
	}

	@Override
	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, INode node) {
		return node.getGrammarElement() == keyword;
	}

}
