/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISyntacticSequencerPDAProvider {

	interface IPDAAbsorberState extends IPDAEmitterState {
		Map<AbstractElement, List<IPDAEmitterState>> getFollowersByElement();

		Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallEnter();

		Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallExit();
	}

	interface IPDAEmitterState {
		PDAEmitterStateType getType();

		AbstractElement getGrammarElement();

		List<IPDAEmitterState> getFollowers();
	}

	enum PDAEmitterStateType {
		START, //
		STOP, //
		PARSER_RULE_ENTER, //
		PARSER_RULE_EXIT, //
		PASS_ACTION, // 
		PASS_KEYWORD, //
		UNKNOWN
		// TODO: use real types
	}

	IPDAEmitterState getPDA(Grammar grammar);

}
