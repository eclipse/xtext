/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISemanticSequenceAcceptor extends IAssignedTokenSequenceAcceptor {

	void acceptAssignedAction(Action action, EObject semanticChild, ICompositeNode node);

	void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node);

	void finish();

}
