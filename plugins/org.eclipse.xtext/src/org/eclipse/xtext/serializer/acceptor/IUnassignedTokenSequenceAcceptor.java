/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IUnassignedTokenSequenceAcceptor extends IAssignedTokenSequenceAcceptor {

	public abstract class UnassignedTokenDelegator extends AssignedTokenDelegator implements
			IUnassignedTokenSequenceAcceptor {

		public void acceptUnassignedAction(Action action) {
			delegate().acceptUnassignedAction(action);
		}

		public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
			delegate().acceptUnassignedDatatype(datatypeRC, token, node);
		}

		public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
			delegate().acceptUnassignedEnum(enumRC, token, node);
		}

		public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
			delegate().acceptUnassignedKeyword(keyword, node);
		}

		public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
			delegate().acceptUnassignedTerminal(terminalRC, token, node);
		}

		@Override
		protected abstract IUnassignedTokenSequenceAcceptor delegate();
	}

	void acceptUnassignedAction(Action action);

	void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node);

	void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node);

	void acceptUnassignedKeyword(Keyword keyword, ILeafNode node);

	void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node);

}
