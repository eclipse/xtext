/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.IPDAState;
import org.eclipse.xtext.grammaranalysis.IPDAState.PDAStateType;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.sequencer.RuleCallStack;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(SyntacticSequencerPDAProvider.class)
public interface ISyntacticSequencerPDAProvider {

	public class GetGrammarElement implements Function<ISynState, AbstractElement> {
		@Override
		public AbstractElement apply(ISynState from) {
			return from.getGrammarElement();
		}
	}

	public interface ISynAbsorberState extends ISynState {
		List<ISynAbsorberState> getOutAbsorbers();

		List<ISynTransition> getOutTransitions();

		Map<AbstractElement, ISynTransition> getOutTransitionsByElement();
	}

	public interface ISynEmitterState extends ISynState, ISynNavigable {
	}

	public interface ISynFollowerOwner {

		EClass getEClass();

		List<ISynState> getFollowers();
	}

	public interface ISynNavigable extends ISynFollowerOwner {
		Pda<ISynState, RuleCall> getPathToTarget();

		List<ISynState> getShortestPathTo(AbstractElement ele, RuleCallStack stack);

		List<ISynState> getShortestPathToAbsorber(RuleCallStack stack);

		List<ISynState> getShortestStackpruningPathTo(AbstractElement ele, RuleCallStack stack);

		List<ISynState> getShortestStackpruningPathToAbsorber(RuleCallStack stack);

		ISynAbsorberState getTarget();

		boolean hasEmitters();

		boolean involvesUnassignedTokenRuleCalls();

		boolean isSyntacticallyAmbiguous();
	}

	public interface ISynState extends ISynFollowerOwner {

		AbstractElement getGrammarElement();

		SynStateType getType();

		String toString(Function<AbstractElement, String> elementFormatter);
	}

	public interface ISynTransition extends ISynNavigable {

		Nfa<ISynState> getAmbiguousNfa();

		AbstractElementAlias getAmbiguousSyntax();

		List<AbstractElementAlias> getAmbiguousSyntaxes();

		ISynAbsorberState getSource();
	}

	public class SynAbsorberNfaAdapter implements Nfa<ISynAbsorberState> {

		protected ISynAbsorberState start;
		protected ISynAbsorberState stop;

		public SynAbsorberNfaAdapter(ISynAbsorberState start) {
			super();
			this.start = start;
			this.stop = new NfaUtil().find(this, new Predicate<ISynAbsorberState>() {
				@Override
				public boolean apply(ISynAbsorberState input) {
					return input.getType().isStop();
				}
			});
			if (this.stop == null) {
				throw new IllegalStateException("Cannot find stop state");
			}
		}

		@Override
		public Iterable<ISynAbsorberState> getFollowers(ISynAbsorberState node) {
			return node.getOutAbsorbers();
		}

		@Override
		public ISynAbsorberState getStart() {
			return start;
		}

		@Override
		public ISynAbsorberState getStop() {
			return stop;
		}

	}

	public class SynPredicates {
		public static Predicate<ISynState> absorber() {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input instanceof ISynAbsorberState;
				}
			};
		}

		public static Predicate<ISynState> absorber(final AbstractElement ele) {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele && input instanceof ISynAbsorberState;
				}
			};
		}

		public static Predicate<ISynState> element(final AbstractElement ele) {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele;
				}
			};
		}

		public static Predicate<ISynState> emitter(final AbstractElement ele) {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele && input instanceof ISynEmitterState;
				}
			};
		}

		public static Predicate<ISynState> ruleCallEnter(final RuleCall ele) {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele && input.getType().isRuleCallEnter();
				}
			};
		}

		public static Predicate<ISynState> ruleCallExit(final RuleCall ele) {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele && input.getType().isRuleCallExit();
				}
			};
		}

		public static Predicate<ISynState> ruleCallExits() {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input.getType().isRuleCallExit();
				}
			};
		}

		public static Predicate<ISynState> ruleCallExitsOrAbsorber() {
			return new Predicate<ISynState>() {
				@Override
				public boolean apply(ISynState input) {
					return input.getType().isRuleCallExit() || input instanceof ISynAbsorberState;
				}
			};
		}
	}

	public enum SynStateType {
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
		TRANSITION(null), //
		UNASSIGEND_ACTION_CALL(PDAStateType.ELEMENT), //
		UNASSIGEND_KEYWORD(PDAStateType.ELEMENT), //
		UNASSIGNED_DATATYPE_RULE_CALL(PDAStateType.ELEMENT), //
		UNASSIGNED_PARSER_RULE_ENTER(PDAStateType.RULECALL_ENTER), //
		UNASSIGNED_PARSER_RULE_EXIT(PDAStateType.RULECALL_EXIT), //
		UNASSIGNED_TERMINAL_RULE_CALL(PDAStateType.ELEMENT);

		protected IPDAState.PDAStateType simpleType;

		private SynStateType(PDAStateType simpleType) {
			this.simpleType = simpleType;
		}

		public IPDAState.PDAStateType getSimpleType() {
			return simpleType;
		}

		public boolean isElement() {
			return simpleType == PDAStateType.ELEMENT;
		}

		public boolean isRuleCallEnter() {
			return simpleType == PDAStateType.RULECALL_ENTER;
		}

		public boolean isRuleCallExit() {
			return simpleType == PDAStateType.RULECALL_EXIT;
		}

		public boolean isStart() {
			return simpleType == PDAStateType.START;
		}

		public boolean isStop() {
			return simpleType == PDAStateType.STOP;
		}

	}

	SerializationContextMap<ISynAbsorberState> getSyntacticSequencerPDAs(Grammar grammar);
}
