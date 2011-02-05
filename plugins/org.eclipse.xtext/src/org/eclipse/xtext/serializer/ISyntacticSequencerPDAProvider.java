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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.grammaranalysis.IPDAState;
import org.eclipse.xtext.grammaranalysis.IPDAState.PDAStateType;
import org.eclipse.xtext.serializer.impl.SyntacticSequencerPDAProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(SyntacticSequencerPDAProvider.class)
public interface ISyntacticSequencerPDAProvider {

	interface IPDAAbsorberState extends IPDAEmitterState {
		List<IPDATransition> getOutTransitions();

		Map<AbstractElement, IPDATransition> getOutTransitionsByElement();

		Map<AbstractElement, IPDATransition> getOutTransitionsByRuleCallEnter();

		Map<AbstractElement, IPDATransition> getOutTransitionsByRuleCallExit();
	}

	interface IPDAEmitterState {

		List<IPDAEmitterState> getFollowers();

		AbstractElement getGrammarElement();

		PDAEmitterStateType getType();
	}

	interface IPDATransition {
		List<IPDAEmitterState> getDirectEmittersAndAbsorber();

		List<IPDAEmitterState> getShortestPathToAbsorber();

		IPDAAbsorberState getSource();

		IPDAAbsorberState getTarget();

		boolean involvesRuleExit();

		boolean involvesUnassignedTokenRuleCalls();

		boolean isSyntacticallyAmbiguous();
	}

	enum PDAEmitterStateType {
		ASSIGNED_ACTION_CALL(PDAStateType.ELEMENT), //
		ASSIGNED_BOOLEAN_KEYWORD(PDAStateType.ELEMENT), //
		ASSIGNED_CROSSREF_DATATYPE_RULE_CALL(PDAStateType.ELEMENT), //
		ASSIGNED_CROSSREF_ENUM_RULE_CALL(PDAStateType.ELEMENT), //  
		ASSIGNED_CROSSREF_KEYWORD(PDAStateType.ELEMENT), // 
		ASSIGNED_CROSSREF_TERMINAL_RULE_CALL(PDAStateType.ELEMENT), //
		ASSIGNED_DATATYPE_RULE_CALL(PDAStateType.ELEMENT), //
		ASSIGNED_ENUM_RULE_CALL(PDAStateType.ELEMENT), //
		ASSIGNED_KEYWORD(PDAStateType.ELEMENT), //
		ASSIGNED_PARSER_RULE_CALL(PDAStateType.ELEMENT), //
		ASSIGNED_TERMINAL_RULE_CALL(PDAStateType.ELEMENT), //
		START(PDAStateType.START), //
		STOP(PDAStateType.STOP), //
		UNASSIGEND_ACTION_CALL(PDAStateType.ELEMENT), //
		UNASSIGEND_KEYWORD(PDAStateType.ELEMENT), //
		UNASSIGNED_DATATYPE_RULE_CALL(PDAStateType.ELEMENT), //
		UNASSIGNED_PARSER_RULE_ENTER(PDAStateType.RULECALL_ENTER), //
		UNASSIGNED_PARSER_RULE_EXIT(PDAStateType.RULECALL_EXIT), //
		UNASSIGNED_TERMINAL_RULE_CALL(PDAStateType.ELEMENT);

		protected IPDAState.PDAStateType simpleType;

		private PDAEmitterStateType(PDAStateType simpleType) {
			this.simpleType = simpleType;
		}

		public IPDAState.PDAStateType getSimpleType() {
			return simpleType;
		}

	}

	IPDAAbsorberState getPDA(Action contet);

	IPDAAbsorberState getPDA(ParserRule context);

}
