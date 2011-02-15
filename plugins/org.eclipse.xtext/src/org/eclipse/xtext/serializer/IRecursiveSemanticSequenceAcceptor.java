/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IRecursiveSemanticSequenceAcceptor extends IAssignedTokenSequenceAcceptor {

	void enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node);

	void enterAssignedParserRuleCall(RuleCall rc, EObject newCurrent, ICompositeNode node);

	void leaveAssignedAction(Action action, EObject semanticChild);

	void leaveAssignedParserRuleCall(RuleCall rc);
}
