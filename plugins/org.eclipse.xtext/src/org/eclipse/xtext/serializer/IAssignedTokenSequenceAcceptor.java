/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IAssignedTokenSequenceAcceptor {
	void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, EObject value);

	void acceptAssignedCrossRefKeyword(Keyword keyword, EObject value);

	void acceptAssignedCrossRefTerminal(RuleCall terminalRC, EObject value);

	void acceptAssignedCrossRefEnum(RuleCall enumRC, EObject value);

	void acceptAssignedDatatype(RuleCall datatypeRC, Object value);

	void acceptAssignedEnum(RuleCall enumRC, Object value);

	void acceptAssignedKeyword(Keyword keyword, String value);

	void acceptAssignedKeyword(Keyword keyword, Boolean value);

	void acceptAssignedTerminal(RuleCall terminalRC, Object value);
}
