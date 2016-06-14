/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
grammar InternalStatemachine;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;

}
@parser::members {
	private StatemachineGrammarAccess grammarAccess;

	public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleStatemachine
entryRuleStatemachine
:
{ before(grammarAccess.getStatemachineRule()); }
	 ruleStatemachine
{ after(grammarAccess.getStatemachineRule()); } 
	 EOF 
;

// Rule Statemachine
ruleStatemachine 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStatemachineAccess().getGroup()); }
		(rule__Statemachine__Group__0)
		{ after(grammarAccess.getStatemachineAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSignal
entryRuleSignal
:
{ before(grammarAccess.getSignalRule()); }
	 ruleSignal
{ after(grammarAccess.getSignalRule()); } 
	 EOF 
;

// Rule Signal
ruleSignal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSignalAccess().getGroup()); }
		(rule__Signal__Group__0)
		{ after(grammarAccess.getSignalAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInputSignal
entryRuleInputSignal
:
{ before(grammarAccess.getInputSignalRule()); }
	 ruleInputSignal
{ after(grammarAccess.getInputSignalRule()); } 
	 EOF 
;

// Rule InputSignal
ruleInputSignal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInputSignalAccess().getGroup()); }
		(rule__InputSignal__Group__0)
		{ after(grammarAccess.getInputSignalAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOutputSignal
entryRuleOutputSignal
:
{ before(grammarAccess.getOutputSignalRule()); }
	 ruleOutputSignal
{ after(grammarAccess.getOutputSignalRule()); } 
	 EOF 
;

// Rule OutputSignal
ruleOutputSignal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOutputSignalAccess().getGroup()); }
		(rule__OutputSignal__Group__0)
		{ after(grammarAccess.getOutputSignalAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleState
entryRuleState
:
{ before(grammarAccess.getStateRule()); }
	 ruleState
{ after(grammarAccess.getStateRule()); } 
	 EOF 
;

// Rule State
ruleState 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStateAccess().getGroup()); }
		(rule__State__Group__0)
		{ after(grammarAccess.getStateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTransition
entryRuleTransition
:
{ before(grammarAccess.getTransitionRule()); }
	 ruleTransition
{ after(grammarAccess.getTransitionRule()); } 
	 EOF 
;

// Rule Transition
ruleTransition 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTransitionAccess().getGroup()); }
		(rule__Transition__Group__0)
		{ after(grammarAccess.getTransitionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCondition
entryRuleCondition
:
{ before(grammarAccess.getConditionRule()); }
	 ruleCondition
{ after(grammarAccess.getConditionRule()); } 
	 EOF 
;

// Rule Condition
ruleCondition 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConditionAccess().getGroup()); }
		(rule__Condition__Group__0)
		{ after(grammarAccess.getConditionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEvent
entryRuleEvent
:
{ before(grammarAccess.getEventRule()); }
	 ruleEvent
{ after(grammarAccess.getEventRule()); } 
	 EOF 
;

// Rule Event
ruleEvent 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEventAccess().getGroup()); }
		(rule__Event__Group__0)
		{ after(grammarAccess.getEventAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCommand
entryRuleCommand
:
{ before(grammarAccess.getCommandRule()); }
	 ruleCommand
{ after(grammarAccess.getCommandRule()); } 
	 EOF 
;

// Rule Command
ruleCommand 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCommandAccess().getGroup()); }
		(rule__Command__Group__0)
		{ after(grammarAccess.getCommandAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
		(rule__QualifiedName__Group__0)
		{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSignalAccess().getInputSignalParserRuleCall_0_0()); }
		ruleInputSignal
		{ after(grammarAccess.getSignalAccess().getInputSignalParserRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getSignalAccess().getOutputSignalParserRuleCall_0_1()); }
		ruleOutputSignal
		{ after(grammarAccess.getSignalAccess().getOutputSignalParserRuleCall_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Statemachine__Group__0__Impl
	rule__Statemachine__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); }
	()
	{ after(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Statemachine__Group__1__Impl
	rule__Statemachine__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStatemachineAccess().getSignalsAssignment_1()); }
	(rule__Statemachine__SignalsAssignment_1)*
	{ after(grammarAccess.getStatemachineAccess().getSignalsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Statemachine__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStatemachineAccess().getStatesAssignment_2()); }
	(rule__Statemachine__StatesAssignment_2)*
	{ after(grammarAccess.getStatemachineAccess().getStatesAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Signal__Group__0__Impl
	rule__Signal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignalAccess().getAlternatives_0()); }
	(rule__Signal__Alternatives_0)
	{ after(grammarAccess.getSignalAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Signal__Group__1__Impl
	rule__Signal__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignalAccess().getSignalKeyword_1()); }
	'signal'
	{ after(grammarAccess.getSignalAccess().getSignalKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Signal__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignalAccess().getNameAssignment_2()); }
	(rule__Signal__NameAssignment_2)
	{ after(grammarAccess.getSignalAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InputSignal__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InputSignal__Group__0__Impl
	rule__InputSignal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InputSignal__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInputSignalAccess().getInputSignalAction_0()); }
	()
	{ after(grammarAccess.getInputSignalAccess().getInputSignalAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InputSignal__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InputSignal__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InputSignal__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInputSignalAccess().getInputKeyword_1()); }
	'input'
	{ after(grammarAccess.getInputSignalAccess().getInputKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OutputSignal__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OutputSignal__Group__0__Impl
	rule__OutputSignal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OutputSignal__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOutputSignalAccess().getOutputSignalAction_0()); }
	()
	{ after(grammarAccess.getOutputSignalAccess().getOutputSignalAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OutputSignal__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OutputSignal__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OutputSignal__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOutputSignalAccess().getOutputKeyword_1()); }
	'output'
	{ after(grammarAccess.getOutputSignalAccess().getOutputKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__State__Group__0__Impl
	rule__State__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStateAccess().getStateKeyword_0()); }
	'state'
	{ after(grammarAccess.getStateAccess().getStateKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__State__Group__1__Impl
	rule__State__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStateAccess().getNameAssignment_1()); }
	(rule__State__NameAssignment_1)
	{ after(grammarAccess.getStateAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__State__Group__2__Impl
	rule__State__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStateAccess().getCommandsAssignment_2()); }
	(rule__State__CommandsAssignment_2)*
	{ after(grammarAccess.getStateAccess().getCommandsAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__State__Group__3__Impl
	rule__State__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStateAccess().getTransitionsAssignment_3()); }
	(rule__State__TransitionsAssignment_3)*
	{ after(grammarAccess.getStateAccess().getTransitionsAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__State__Group__4__Impl
	rule__State__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStateAccess().getNestedStatesAssignment_4()); }
	(rule__State__NestedStatesAssignment_4)*
	{ after(grammarAccess.getStateAccess().getNestedStatesAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__State__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStateAccess().getEndKeyword_5()); }
	'end'
	{ after(grammarAccess.getStateAccess().getEndKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Transition__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transition__Group__0__Impl
	rule__Transition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionAccess().getIfKeyword_0()); }
	'if'
	{ after(grammarAccess.getTransitionAccess().getIfKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transition__Group__1__Impl
	rule__Transition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionAccess().getConditionAssignment_1()); }
	(rule__Transition__ConditionAssignment_1)
	{ after(grammarAccess.getTransitionAccess().getConditionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transition__Group__2__Impl
	rule__Transition__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionAccess().getGotoKeyword_2()); }
	'goto'
	{ after(grammarAccess.getTransitionAccess().getGotoKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transition__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionAccess().getStateAssignment_3()); }
	(rule__Transition__StateAssignment_3)
	{ after(grammarAccess.getTransitionAccess().getStateAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Condition__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Condition__Group__0__Impl
	rule__Condition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionAccess().getEventsAssignment_0()); }
	(rule__Condition__EventsAssignment_0)
	{ after(grammarAccess.getConditionAccess().getEventsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Condition__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionAccess().getGroup_1()); }
	(rule__Condition__Group_1__0)*
	{ after(grammarAccess.getConditionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Condition__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Condition__Group_1__0__Impl
	rule__Condition__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionAccess().getAndKeyword_1_0()); }
	'and'
	{ after(grammarAccess.getConditionAccess().getAndKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Condition__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionAccess().getEventsAssignment_1_1()); }
	(rule__Condition__EventsAssignment_1_1)
	{ after(grammarAccess.getConditionAccess().getEventsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Event__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Event__Group__0__Impl
	rule__Event__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Event__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEventAccess().getSignalAssignment_0()); }
	(rule__Event__SignalAssignment_0)
	{ after(grammarAccess.getEventAccess().getSignalAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Event__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Event__Group__1__Impl
	rule__Event__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Event__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEventAccess().getEqualsSignEqualsSignKeyword_1()); }
	'=='
	{ after(grammarAccess.getEventAccess().getEqualsSignEqualsSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Event__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Event__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Event__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEventAccess().getValueAssignment_2()); }
	(rule__Event__ValueAssignment_2)
	{ after(grammarAccess.getEventAccess().getValueAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Command__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Command__Group__0__Impl
	rule__Command__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCommandAccess().getSetKeyword_0()); }
	'set'
	{ after(grammarAccess.getCommandAccess().getSetKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Command__Group__1__Impl
	rule__Command__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCommandAccess().getSignalAssignment_1()); }
	(rule__Command__SignalAssignment_1)
	{ after(grammarAccess.getCommandAccess().getSignalAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Command__Group__2__Impl
	rule__Command__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCommandAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getCommandAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Command__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCommandAccess().getNewValueAssignment_3()); }
	(rule__Command__NewValueAssignment_3)
	{ after(grammarAccess.getCommandAccess().getNewValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
	{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
	(rule__QualifiedName__Group_1__0)*
	{ after(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__0__Impl
	rule__QualifiedName__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
	{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Statemachine__SignalsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStatemachineAccess().getSignalsSignalParserRuleCall_1_0()); }
		ruleSignal
		{ after(grammarAccess.getStatemachineAccess().getSignalsSignalParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__StatesAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_2_0()); }
		ruleState
		{ after(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__CommandsAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStateAccess().getCommandsCommandParserRuleCall_2_0()); }
		ruleCommand
		{ after(grammarAccess.getStateAccess().getCommandsCommandParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__TransitionsAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); }
		ruleTransition
		{ after(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__State__NestedStatesAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStateAccess().getNestedStatesStateParserRuleCall_4_0()); }
		ruleState
		{ after(grammarAccess.getStateAccess().getNestedStatesStateParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__ConditionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_1_0()); }
		ruleCondition
		{ after(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__StateAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransitionAccess().getStateStateCrossReference_3_0()); }
		(
			{ before(grammarAccess.getTransitionAccess().getStateStateQualifiedNameParserRuleCall_3_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getTransitionAccess().getStateStateQualifiedNameParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getTransitionAccess().getStateStateCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__EventsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_0_0()); }
		ruleEvent
		{ after(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Condition__EventsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_1_1_0()); }
		ruleEvent
		{ after(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Event__SignalAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEventAccess().getSignalSignalCrossReference_0_0()); }
		(
			{ before(grammarAccess.getEventAccess().getSignalSignalIDTerminalRuleCall_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getEventAccess().getSignalSignalIDTerminalRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getEventAccess().getSignalSignalCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Event__ValueAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEventAccess().getValueBOOLEANTerminalRuleCall_2_0()); }
		RULE_BOOLEAN
		{ after(grammarAccess.getEventAccess().getValueBOOLEANTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__SignalAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCommandAccess().getSignalSignalCrossReference_1_0()); }
		(
			{ before(grammarAccess.getCommandAccess().getSignalSignalIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getCommandAccess().getSignalSignalIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getCommandAccess().getSignalSignalCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__NewValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCommandAccess().getNewValueBOOLEANTerminalRuleCall_3_0()); }
		RULE_BOOLEAN
		{ after(grammarAccess.getCommandAccess().getNewValueBOOLEANTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_BOOLEAN : ('true'|'false');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
