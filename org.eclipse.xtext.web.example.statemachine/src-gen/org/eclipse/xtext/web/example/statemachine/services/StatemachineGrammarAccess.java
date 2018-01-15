/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class StatemachineGrammarAccess extends AbstractGrammarElementFinder {
	
	public class StatemachineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.Statemachine");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cStatemachineAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSignalsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSignalsSignalParserRuleCall_1_0 = (RuleCall)cSignalsAssignment_1.eContents().get(0);
		private final Assignment cStatesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cStatesStateParserRuleCall_2_0 = (RuleCall)cStatesAssignment_2.eContents().get(0);
		
		//Statemachine:
		//	{Statemachine} signals+=Signal*
		//	states+=State*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Statemachine} signals+=Signal* states+=State*
		public Group getGroup() { return cGroup; }
		
		//{Statemachine}
		public Action getStatemachineAction_0() { return cStatemachineAction_0; }
		
		//signals+=Signal*
		public Assignment getSignalsAssignment_1() { return cSignalsAssignment_1; }
		
		//Signal
		public RuleCall getSignalsSignalParserRuleCall_1_0() { return cSignalsSignalParserRuleCall_1_0; }
		
		//states+=State*
		public Assignment getStatesAssignment_2() { return cStatesAssignment_2; }
		
		//State
		public RuleCall getStatesStateParserRuleCall_2_0() { return cStatesStateParserRuleCall_2_0; }
	}
	public class SignalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.Signal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cInputSignalParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cOutputSignalParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Keyword cSignalKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//Signal:
		//	(InputSignal | OutputSignal) 'signal' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//(InputSignal | OutputSignal) 'signal' name=ID
		public Group getGroup() { return cGroup; }
		
		//InputSignal | OutputSignal
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//InputSignal
		public RuleCall getInputSignalParserRuleCall_0_0() { return cInputSignalParserRuleCall_0_0; }
		
		//OutputSignal
		public RuleCall getOutputSignalParserRuleCall_0_1() { return cOutputSignalParserRuleCall_0_1; }
		
		//'signal'
		public Keyword getSignalKeyword_1() { return cSignalKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
	}
	public class InputSignalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.InputSignal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cInputSignalAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cInputKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//InputSignal:
		//	{InputSignal}
		//	'input';
		@Override public ParserRule getRule() { return rule; }
		
		//{InputSignal} 'input'
		public Group getGroup() { return cGroup; }
		
		//{InputSignal}
		public Action getInputSignalAction_0() { return cInputSignalAction_0; }
		
		//'input'
		public Keyword getInputKeyword_1() { return cInputKeyword_1; }
	}
	public class OutputSignalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.OutputSignal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOutputSignalAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOutputKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//OutputSignal:
		//	{OutputSignal}
		//	'output';
		@Override public ParserRule getRule() { return rule; }
		
		//{OutputSignal} 'output'
		public Group getGroup() { return cGroup; }
		
		//{OutputSignal}
		public Action getOutputSignalAction_0() { return cOutputSignalAction_0; }
		
		//'output'
		public Keyword getOutputKeyword_1() { return cOutputKeyword_1; }
	}
	public class StateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.State");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStateKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cCommandsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cCommandsCommandParserRuleCall_2_0 = (RuleCall)cCommandsAssignment_2.eContents().get(0);
		private final Assignment cTransitionsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTransitionsTransitionParserRuleCall_3_0 = (RuleCall)cTransitionsAssignment_3.eContents().get(0);
		private final Assignment cNestedStatesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cNestedStatesStateParserRuleCall_4_0 = (RuleCall)cNestedStatesAssignment_4.eContents().get(0);
		private final Keyword cEndKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//State:
		//	'state' name=ID
		//	commands+=Command*
		//	transitions+=Transition*
		//	nestedStates+=State*
		//	'end';
		@Override public ParserRule getRule() { return rule; }
		
		//'state' name=ID commands+=Command* transitions+=Transition* nestedStates+=State* 'end'
		public Group getGroup() { return cGroup; }
		
		//'state'
		public Keyword getStateKeyword_0() { return cStateKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//commands+=Command*
		public Assignment getCommandsAssignment_2() { return cCommandsAssignment_2; }
		
		//Command
		public RuleCall getCommandsCommandParserRuleCall_2_0() { return cCommandsCommandParserRuleCall_2_0; }
		
		//transitions+=Transition*
		public Assignment getTransitionsAssignment_3() { return cTransitionsAssignment_3; }
		
		//Transition
		public RuleCall getTransitionsTransitionParserRuleCall_3_0() { return cTransitionsTransitionParserRuleCall_3_0; }
		
		//nestedStates+=State*
		public Assignment getNestedStatesAssignment_4() { return cNestedStatesAssignment_4; }
		
		//State
		public RuleCall getNestedStatesStateParserRuleCall_4_0() { return cNestedStatesStateParserRuleCall_4_0; }
		
		//'end'
		public Keyword getEndKeyword_5() { return cEndKeyword_5; }
	}
	public class TransitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.Transition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIfKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cConditionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConditionConditionParserRuleCall_1_0 = (RuleCall)cConditionAssignment_1.eContents().get(0);
		private final Keyword cGotoKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cStateAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cStateStateCrossReference_3_0 = (CrossReference)cStateAssignment_3.eContents().get(0);
		private final RuleCall cStateStateQualifiedNameParserRuleCall_3_0_1 = (RuleCall)cStateStateCrossReference_3_0.eContents().get(1);
		
		//Transition:
		//	'if' condition=Condition 'goto' state=[State|QualifiedName];
		@Override public ParserRule getRule() { return rule; }
		
		//'if' condition=Condition 'goto' state=[State|QualifiedName]
		public Group getGroup() { return cGroup; }
		
		//'if'
		public Keyword getIfKeyword_0() { return cIfKeyword_0; }
		
		//condition=Condition
		public Assignment getConditionAssignment_1() { return cConditionAssignment_1; }
		
		//Condition
		public RuleCall getConditionConditionParserRuleCall_1_0() { return cConditionConditionParserRuleCall_1_0; }
		
		//'goto'
		public Keyword getGotoKeyword_2() { return cGotoKeyword_2; }
		
		//state=[State|QualifiedName]
		public Assignment getStateAssignment_3() { return cStateAssignment_3; }
		
		//[State|QualifiedName]
		public CrossReference getStateStateCrossReference_3_0() { return cStateStateCrossReference_3_0; }
		
		//QualifiedName
		public RuleCall getStateStateQualifiedNameParserRuleCall_3_0_1() { return cStateStateQualifiedNameParserRuleCall_3_0_1; }
	}
	public class ConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.Condition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cEventsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cEventsEventParserRuleCall_0_0 = (RuleCall)cEventsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cAndKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cEventsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cEventsEventParserRuleCall_1_1_0 = (RuleCall)cEventsAssignment_1_1.eContents().get(0);
		
		//Condition:
		//	events+=Event ('and' events+=Event)*;
		@Override public ParserRule getRule() { return rule; }
		
		//events+=Event ('and' events+=Event)*
		public Group getGroup() { return cGroup; }
		
		//events+=Event
		public Assignment getEventsAssignment_0() { return cEventsAssignment_0; }
		
		//Event
		public RuleCall getEventsEventParserRuleCall_0_0() { return cEventsEventParserRuleCall_0_0; }
		
		//('and' events+=Event)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'and'
		public Keyword getAndKeyword_1_0() { return cAndKeyword_1_0; }
		
		//events+=Event
		public Assignment getEventsAssignment_1_1() { return cEventsAssignment_1_1; }
		
		//Event
		public RuleCall getEventsEventParserRuleCall_1_1_0() { return cEventsEventParserRuleCall_1_1_0; }
	}
	public class EventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.Event");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSignalAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSignalSignalCrossReference_0_0 = (CrossReference)cSignalAssignment_0.eContents().get(0);
		private final RuleCall cSignalSignalIDTerminalRuleCall_0_0_1 = (RuleCall)cSignalSignalCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueBOOLEANTerminalRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//Event:
		//	signal=[Signal] '==' value=BOOLEAN;
		@Override public ParserRule getRule() { return rule; }
		
		//signal=[Signal] '==' value=BOOLEAN
		public Group getGroup() { return cGroup; }
		
		//signal=[Signal]
		public Assignment getSignalAssignment_0() { return cSignalAssignment_0; }
		
		//[Signal]
		public CrossReference getSignalSignalCrossReference_0_0() { return cSignalSignalCrossReference_0_0; }
		
		//ID
		public RuleCall getSignalSignalIDTerminalRuleCall_0_0_1() { return cSignalSignalIDTerminalRuleCall_0_0_1; }
		
		//'=='
		public Keyword getEqualsSignEqualsSignKeyword_1() { return cEqualsSignEqualsSignKeyword_1; }
		
		//value=BOOLEAN
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }
		
		//BOOLEAN
		public RuleCall getValueBOOLEANTerminalRuleCall_2_0() { return cValueBOOLEANTerminalRuleCall_2_0; }
	}
	public class CommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.Command");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cSignalAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSignalSignalCrossReference_1_0 = (CrossReference)cSignalAssignment_1.eContents().get(0);
		private final RuleCall cSignalSignalIDTerminalRuleCall_1_0_1 = (RuleCall)cSignalSignalCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNewValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNewValueBOOLEANTerminalRuleCall_3_0 = (RuleCall)cNewValueAssignment_3.eContents().get(0);
		
		//Command:
		//	'set' signal=[Signal] '=' newValue=BOOLEAN;
		@Override public ParserRule getRule() { return rule; }
		
		//'set' signal=[Signal] '=' newValue=BOOLEAN
		public Group getGroup() { return cGroup; }
		
		//'set'
		public Keyword getSetKeyword_0() { return cSetKeyword_0; }
		
		//signal=[Signal]
		public Assignment getSignalAssignment_1() { return cSignalAssignment_1; }
		
		//[Signal]
		public CrossReference getSignalSignalCrossReference_1_0() { return cSignalSignalCrossReference_1_0; }
		
		//ID
		public RuleCall getSignalSignalIDTerminalRuleCall_1_0_1() { return cSignalSignalIDTerminalRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//newValue=BOOLEAN
		public Assignment getNewValueAssignment_3() { return cNewValueAssignment_3; }
		
		//BOOLEAN
		public RuleCall getNewValueBOOLEANTerminalRuleCall_3_0() { return cNewValueBOOLEANTerminalRuleCall_3_0; }
	}
	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//	ID ('.' ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('.' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('.' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final StatemachineElements pStatemachine;
	private final SignalElements pSignal;
	private final InputSignalElements pInputSignal;
	private final OutputSignalElements pOutputSignal;
	private final StateElements pState;
	private final TransitionElements pTransition;
	private final ConditionElements pCondition;
	private final EventElements pEvent;
	private final CommandElements pCommand;
	private final QualifiedNameElements pQualifiedName;
	private final TerminalRule tBOOLEAN;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public StatemachineGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pStatemachine = new StatemachineElements();
		this.pSignal = new SignalElements();
		this.pInputSignal = new InputSignalElements();
		this.pOutputSignal = new OutputSignalElements();
		this.pState = new StateElements();
		this.pTransition = new TransitionElements();
		this.pCondition = new ConditionElements();
		this.pEvent = new EventElements();
		this.pCommand = new CommandElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.tBOOLEAN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.statemachine.Statemachine.BOOLEAN");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.web.example.statemachine.Statemachine".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Statemachine:
	//	{Statemachine} signals+=Signal*
	//	states+=State*;
	public StatemachineElements getStatemachineAccess() {
		return pStatemachine;
	}
	
	public ParserRule getStatemachineRule() {
		return getStatemachineAccess().getRule();
	}
	
	//Signal:
	//	(InputSignal | OutputSignal) 'signal' name=ID;
	public SignalElements getSignalAccess() {
		return pSignal;
	}
	
	public ParserRule getSignalRule() {
		return getSignalAccess().getRule();
	}
	
	//InputSignal:
	//	{InputSignal}
	//	'input';
	public InputSignalElements getInputSignalAccess() {
		return pInputSignal;
	}
	
	public ParserRule getInputSignalRule() {
		return getInputSignalAccess().getRule();
	}
	
	//OutputSignal:
	//	{OutputSignal}
	//	'output';
	public OutputSignalElements getOutputSignalAccess() {
		return pOutputSignal;
	}
	
	public ParserRule getOutputSignalRule() {
		return getOutputSignalAccess().getRule();
	}
	
	//State:
	//	'state' name=ID
	//	commands+=Command*
	//	transitions+=Transition*
	//	nestedStates+=State*
	//	'end';
	public StateElements getStateAccess() {
		return pState;
	}
	
	public ParserRule getStateRule() {
		return getStateAccess().getRule();
	}
	
	//Transition:
	//	'if' condition=Condition 'goto' state=[State|QualifiedName];
	public TransitionElements getTransitionAccess() {
		return pTransition;
	}
	
	public ParserRule getTransitionRule() {
		return getTransitionAccess().getRule();
	}
	
	//Condition:
	//	events+=Event ('and' events+=Event)*;
	public ConditionElements getConditionAccess() {
		return pCondition;
	}
	
	public ParserRule getConditionRule() {
		return getConditionAccess().getRule();
	}
	
	//Event:
	//	signal=[Signal] '==' value=BOOLEAN;
	public EventElements getEventAccess() {
		return pEvent;
	}
	
	public ParserRule getEventRule() {
		return getEventAccess().getRule();
	}
	
	//Command:
	//	'set' signal=[Signal] '=' newValue=BOOLEAN;
	public CommandElements getCommandAccess() {
		return pCommand;
	}
	
	public ParserRule getCommandRule() {
		return getCommandAccess().getRule();
	}
	
	//QualifiedName:
	//	ID ('.' ID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//terminal BOOLEAN returns ecore::EBoolean:
	//	'true' | 'false';
	public TerminalRule getBOOLEANRule() {
		return tBOOLEAN;
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
