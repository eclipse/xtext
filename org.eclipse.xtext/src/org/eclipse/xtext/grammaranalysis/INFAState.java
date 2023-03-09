/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("rawtypes")
public interface INFAState<S extends INFAState, T extends INFATransition> {
	List<T> getAllIncoming();

	List<T> getAllOutgoing();

	NFABuilder<S, T> getBuilder();

	AbstractElement getGrammarElement();

	List<T> getIncommingWithoutRuleCalls();

	List<T> getOutgoing();

	List<T> getOutgoingAfterReturn();
	
	/**
	 * @since 2.0
	 */
	boolean hasOutgoingRuleCall();

	boolean isEndState();

	boolean isStartState();
}
