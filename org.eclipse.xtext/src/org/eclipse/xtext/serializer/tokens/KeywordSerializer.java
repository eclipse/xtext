/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class KeywordSerializer implements IKeywordSerializer {

	@Override
	public boolean isValid(EObject context, Keyword keyword, Object value, Acceptor errorAcceptor) {
		return keyword.getValue().equals(value);
	}

	@Override
	public String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, INode node,
			Acceptor errorAcceptor) {
		if (node != null && node.getGrammarElement() == keyword)
			return node.getText();
		return keyword.getValue();
	}

	//	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, INode node) {
	//		return node.getGrammarElement() == keyword;
	//	}

}
