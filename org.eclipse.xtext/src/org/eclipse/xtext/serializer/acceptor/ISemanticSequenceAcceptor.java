/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISemanticSequenceAcceptor {

	public final static int NO_INDEX = -1;

	void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index, ICompositeNode node);

	void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node);

	void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index, ILeafNode node);

	void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node);

	void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node);

	void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node);

	void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node);

	void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node);

	boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node);

	boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node);

	void finish();

	void leaveAssignedAction(Action action, EObject semanticChild);

	void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild);

}
