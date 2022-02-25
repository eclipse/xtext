/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
public interface ISyntacticSequenceAcceptor extends ISemanticSequenceAcceptor {

	@Deprecated // no longer supported
	void enterUnassignedParserRuleCall(RuleCall rc);

	@Deprecated // no longer supported
	void leaveUnssignedParserRuleCall(RuleCall rc);

	void acceptUnassignedAction(Action action);

	void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node);

	void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node);

	void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node);

	void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node);
}
