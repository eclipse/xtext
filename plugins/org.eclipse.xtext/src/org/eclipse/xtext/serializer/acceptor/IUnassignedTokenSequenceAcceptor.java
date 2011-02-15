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
public interface IUnassignedTokenSequenceAcceptor {
	void acceptUnassignedAction(Action action);

	void acceptUnassignedDatatype(RuleCall datatypeRC, String value, ICompositeNode node);

	void acceptUnassignedEnum(RuleCall enumRC, String value, ICompositeNode node);

	void acceptUnassignedKeyword(Keyword keyword, ILeafNode node);

	void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node);

}
