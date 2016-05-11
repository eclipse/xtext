/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
grammar InternalStatemachine;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.web.example.statemachine.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.web.example.statemachine.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;

}

@parser::members {

 	private StatemachineGrammarAccess grammarAccess;

    public InternalStatemachineParser(TokenStream input, StatemachineGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Statemachine";
   	}

   	@Override
   	protected StatemachineGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleStatemachine
entryRuleStatemachine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStatemachineRule()); }
	iv_ruleStatemachine=ruleStatemachine
	{ $current=$iv_ruleStatemachine.current; }
	EOF;

// Rule Statemachine
ruleStatemachine returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getStatemachineAccess().getStatemachineAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineAccess().getSignalsSignalParserRuleCall_1_0());
				}
				lv_signals_1_0=ruleSignal
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRule());
					}
					add(
						$current,
						"signals",
						lv_signals_1_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.Signal");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_2_0());
				}
				lv_states_2_0=ruleState
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRule());
					}
					add(
						$current,
						"states",
						lv_states_2_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.State");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleSignal
entryRuleSignal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignalRule()); }
	iv_ruleSignal=ruleSignal
	{ $current=$iv_ruleSignal.current; }
	EOF;

// Rule Signal
ruleSignal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getSignalAccess().getInputSignalParserRuleCall_0_0());
			}
			this_InputSignal_0=ruleInputSignal
			{
				$current = $this_InputSignal_0.current;
				afterParserOrEnumRuleCall();
			}
			    |
			{
				newCompositeNode(grammarAccess.getSignalAccess().getOutputSignalParserRuleCall_0_1());
			}
			this_OutputSignal_1=ruleOutputSignal
			{
				$current = $this_OutputSignal_1.current;
				afterParserOrEnumRuleCall();
			}
		)
		otherlv_2='signal'
		{
			newLeafNode(otherlv_2, grammarAccess.getSignalAccess().getSignalKeyword_1());
		}
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSignalRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleInputSignal
entryRuleInputSignal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInputSignalRule()); }
	iv_ruleInputSignal=ruleInputSignal
	{ $current=$iv_ruleInputSignal.current; }
	EOF;

// Rule InputSignal
ruleInputSignal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getInputSignalAccess().getInputSignalAction_0(),
					$current);
			}
		)
		otherlv_1='input'
		{
			newLeafNode(otherlv_1, grammarAccess.getInputSignalAccess().getInputKeyword_1());
		}
	)
;

// Entry rule entryRuleOutputSignal
entryRuleOutputSignal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOutputSignalRule()); }
	iv_ruleOutputSignal=ruleOutputSignal
	{ $current=$iv_ruleOutputSignal.current; }
	EOF;

// Rule OutputSignal
ruleOutputSignal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getOutputSignalAccess().getOutputSignalAction_0(),
					$current);
			}
		)
		otherlv_1='output'
		{
			newLeafNode(otherlv_1, grammarAccess.getOutputSignalAccess().getOutputKeyword_1());
		}
	)
;

// Entry rule entryRuleState
entryRuleState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStateRule()); }
	iv_ruleState=ruleState
	{ $current=$iv_ruleState.current; }
	EOF;

// Rule State
ruleState returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='state'
		{
			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStateRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStateAccess().getCommandsCommandParserRuleCall_2_0());
				}
				lv_commands_2_0=ruleCommand
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStateRule());
					}
					add(
						$current,
						"commands",
						lv_commands_2_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.Command");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0());
				}
				lv_transitions_3_0=ruleTransition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStateRule());
					}
					add(
						$current,
						"transitions",
						lv_transitions_3_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.Transition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getStateAccess().getNestedStatesStateParserRuleCall_4_0());
				}
				lv_nestedStates_4_0=ruleState
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStateRule());
					}
					add(
						$current,
						"nestedStates",
						lv_nestedStates_4_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.State");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_5='end'
		{
			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getEndKeyword_5());
		}
	)
;

// Entry rule entryRuleTransition
entryRuleTransition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionRule()); }
	iv_ruleTransition=ruleTransition
	{ $current=$iv_ruleTransition.current; }
	EOF;

// Rule Transition
ruleTransition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='if'
		{
			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getIfKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleCondition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionRule());
					}
					set(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.Condition");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='goto'
		{
			newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getGotoKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTransitionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTransitionAccess().getStateStateCrossReference_3_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCondition
entryRuleCondition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionRule()); }
	iv_ruleCondition=ruleCondition
	{ $current=$iv_ruleCondition.current; }
	EOF;

// Rule Condition
ruleCondition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_0_0());
				}
				lv_events_0_0=ruleEvent
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConditionRule());
					}
					add(
						$current,
						"events",
						lv_events_0_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.Event");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='and'
			{
				newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getAndKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_1_1_0());
					}
					lv_events_2_0=ruleEvent
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionRule());
						}
						add(
							$current,
							"events",
							lv_events_2_0,
							"org.eclipse.xtext.web.example.statemachine.Statemachine.Event");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleEvent
entryRuleEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventRule()); }
	iv_ruleEvent=ruleEvent
	{ $current=$iv_ruleEvent.current; }
	EOF;

// Rule Event
ruleEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEventRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getEventAccess().getSignalSignalCrossReference_0_0());
				}
			)
		)
		otherlv_1='=='
		{
			newLeafNode(otherlv_1, grammarAccess.getEventAccess().getEqualsSignEqualsSignKeyword_1());
		}
		(
			(
				lv_value_2_0=RULE_BOOLEAN
				{
					newLeafNode(lv_value_2_0, grammarAccess.getEventAccess().getValueBOOLEANTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEventRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_2_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.BOOLEAN");
				}
			)
		)
	)
;

// Entry rule entryRuleCommand
entryRuleCommand returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCommandRule()); }
	iv_ruleCommand=ruleCommand
	{ $current=$iv_ruleCommand.current; }
	EOF;

// Rule Command
ruleCommand returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='set'
		{
			newLeafNode(otherlv_0, grammarAccess.getCommandAccess().getSetKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCommandRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getSignalSignalCrossReference_1_0());
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getCommandAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_newValue_3_0=RULE_BOOLEAN
				{
					newLeafNode(lv_newValue_3_0, grammarAccess.getCommandAccess().getNewValueBOOLEANTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCommandRule());
					}
					setWithLastConsumed(
						$current,
						"newValue",
						lv_newValue_3_0,
						"org.eclipse.xtext.web.example.statemachine.Statemachine.BOOLEAN");
				}
			)
		)
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

RULE_BOOLEAN : ('true'|'false');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
