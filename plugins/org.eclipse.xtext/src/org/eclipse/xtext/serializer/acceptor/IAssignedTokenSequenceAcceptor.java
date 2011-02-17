/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IAssignedTokenSequenceAcceptor {
	public abstract class AssignedTokenDelegator implements IAssignedTokenSequenceAcceptor {

		public void acceptAssignedCrossRefDatatype(RuleCall rc, String tkn, EObject val, int index, ICompositeNode node) {
			delegate().acceptAssignedCrossRefDatatype(rc, tkn, val, index, node);
		}

		public void acceptAssignedCrossRefEnum(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
			delegate().acceptAssignedCrossRefEnum(rc, token, value, index, node);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall rc, String tkn, EObject val, int index, ILeafNode node) {
			delegate().acceptAssignedCrossRefTerminal(rc, tkn, val, index, node);
		}

		public void acceptAssignedDatatype(RuleCall rc, String token, Object value, int index, ICompositeNode node) {
			delegate().acceptAssignedDatatype(rc, token, value, index, node);
		}

		public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
			delegate().acceptAssignedEnum(enumRC, token, value, index, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
			delegate().acceptAssignedKeyword(keyword, token, value, index, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
			delegate().acceptAssignedKeyword(keyword, token, value, index, node);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
			delegate().acceptAssignedTerminal(terminalRC, token, value, index, node);
		}

		protected abstract IAssignedTokenSequenceAcceptor delegate();
	}

	void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index, ICompositeNode node);

	void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node);

	void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index, ILeafNode node);

	void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node);

	void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node);

	void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node);

	void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node);

	void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node);
}
