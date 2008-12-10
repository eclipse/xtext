/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class FowlerDslTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class StatemachineElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Keyword c000000KeywordEvents = (Keyword)c00000Group.eContents().get(0);
		private final Assignment c000001AssignmentEvents = (Assignment)c00000Group.eContents().get(1);
		private final RuleCall c0000010ParserRuleCallEvent = (RuleCall)c000001AssignmentEvents.eContents().get(0);
		private final Keyword c00001KeywordEnd = (Keyword)c0000Group.eContents().get(1);
		private final Keyword c0001KeywordCommands = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentCommands = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallCommand = (RuleCall)c001AssignmentCommands.eContents().get(0);
		private final Keyword c01KeywordEnd = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentStates = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallState = (RuleCall)c1AssignmentStates.eContents().get(0);
		
		// Statemachine : 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end' ( states += State ) * ;
		public ParserRule getRule() { return rule; }

		// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end' ( states += State ) *
		public Group eleGroup() { return cGroup; }

		// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end'
		public Group ele0Group() { return c0Group; }

		// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) *
		public Group ele00Group() { return c00Group; }

		// 'events' ( events += Event ) * 'end' 'commands'
		public Group ele000Group() { return c000Group; }

		// 'events' ( events += Event ) * 'end'
		public Group ele0000Group() { return c0000Group; }

		// 'events' ( events += Event ) *
		public Group ele00000Group() { return c00000Group; }

		// 'events'
		public Keyword ele000000KeywordEvents() { return c000000KeywordEvents; }

		// ( events += Event ) *
		public Assignment ele000001AssignmentEvents() { return c000001AssignmentEvents; }

		// Event
		public RuleCall ele0000010ParserRuleCallEvent() { return c0000010ParserRuleCallEvent; }

		// 'end'
		public Keyword ele00001KeywordEnd() { return c00001KeywordEnd; }

		// 'commands'
		public Keyword ele0001KeywordCommands() { return c0001KeywordCommands; }

		// ( commands += Command ) *
		public Assignment ele001AssignmentCommands() { return c001AssignmentCommands; }

		// Command
		public RuleCall ele0010ParserRuleCallCommand() { return c0010ParserRuleCallCommand; }

		// 'end'
		public Keyword ele01KeywordEnd() { return c01KeywordEnd; }

		// ( states += State ) *
		public Assignment ele1AssignmentStates() { return c1AssignmentStates; }

		// State
		public RuleCall ele10ParserRuleCallState() { return c10ParserRuleCallState; }
	}

	public class EventElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentResetting = (Assignment)c0Group.eContents().get(0);
		private final Keyword c000KeywordResetting = (Keyword)c00AssignmentResetting.eContents().get(0);
		private final Assignment c01AssignmentName = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentCode = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentCode.eContents().get(0);
		
		// Event : ( resetting ?= 'resetting' ) ? name = ID code = ID ;
		public ParserRule getRule() { return rule; }

		// ( resetting ?= 'resetting' ) ? name = ID code = ID
		public Group eleGroup() { return cGroup; }

		// ( resetting ?= 'resetting' ) ? name = ID
		public Group ele0Group() { return c0Group; }

		// ( resetting ?= 'resetting' ) ?
		public Assignment ele00AssignmentResetting() { return c00AssignmentResetting; }

		// 'resetting'
		public Keyword ele000KeywordResetting() { return c000KeywordResetting; }

		// name = ID
		public Assignment ele01AssignmentName() { return c01AssignmentName; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// code = ID
		public Assignment ele1AssignmentCode() { return c1AssignmentCode; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class CommandElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentName = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentCode = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentCode.eContents().get(0);
		
		// Command : name = ID code = ID ;
		public ParserRule getRule() { return rule; }

		// name = ID code = ID
		public Group eleGroup() { return cGroup; }

		// name = ID
		public Assignment ele0AssignmentName() { return c0AssignmentName; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// code = ID
		public Assignment ele1AssignmentCode() { return c1AssignmentCode; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class StateElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordState = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Group c0010Group = (Group)c001Group.eContents().get(0);
		private final Group c00100Group = (Group)c0010Group.eContents().get(0);
		private final Keyword c001000KeywordActions = (Keyword)c00100Group.eContents().get(0);
		private final Keyword c001001KeywordLeftCurlyBracket = (Keyword)c00100Group.eContents().get(1);
		private final Assignment c00101AssignmentActions = (Assignment)c0010Group.eContents().get(1);
		private final CrossReference c001010CrossReferenceCommand = (CrossReference)c00101AssignmentActions.eContents().get(0);
		private final Keyword c0011KeywordRightCurlyBracket = (Keyword)c001Group.eContents().get(1);
		private final Assignment c01AssignmentTransitions = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallTransition = (RuleCall)c01AssignmentTransitions.eContents().get(0);
		private final Keyword c1KeywordEnd = (Keyword)cGroup.eContents().get(1);
		
		// State : 'state' name = ID ( 'actions' '{' ( actions += [ Command ] ) + '}' ) ? ( transitions += Transition ) * 'end' ;
		public ParserRule getRule() { return rule; }

		// 'state' name = ID ( 'actions' '{' ( actions += [ Command ] ) + '}' ) ? ( transitions += Transition ) * 'end'
		public Group eleGroup() { return cGroup; }

		// 'state' name = ID ( 'actions' '{' ( actions += [ Command ] ) + '}' ) ? ( transitions += Transition ) *
		public Group ele0Group() { return c0Group; }

		// 'state' name = ID ( 'actions' '{' ( actions += [ Command ] ) + '}' ) ?
		public Group ele00Group() { return c00Group; }

		// 'state' name = ID
		public Group ele000Group() { return c000Group; }

		// 'state'
		public Keyword ele0000KeywordState() { return c0000KeywordState; }

		// name = ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// ( 'actions' '{' ( actions += [ Command ] ) + '}' ) ?
		public Group ele001Group() { return c001Group; }

		// 'actions' '{' ( actions += [ Command ] ) +
		public Group ele0010Group() { return c0010Group; }

		// 'actions' '{'
		public Group ele00100Group() { return c00100Group; }

		// 'actions'
		public Keyword ele001000KeywordActions() { return c001000KeywordActions; }

		// '{'
		public Keyword ele001001KeywordLeftCurlyBracket() { return c001001KeywordLeftCurlyBracket; }

		// ( actions += [ Command ] ) +
		public Assignment ele00101AssignmentActions() { return c00101AssignmentActions; }

		// [ Command ]
		public CrossReference ele001010CrossReferenceCommand() { return c001010CrossReferenceCommand; }

		// '}'
		public Keyword ele0011KeywordRightCurlyBracket() { return c0011KeywordRightCurlyBracket; }

		// ( transitions += Transition ) *
		public Assignment ele01AssignmentTransitions() { return c01AssignmentTransitions; }

		// Transition
		public RuleCall ele010ParserRuleCallTransition() { return c010ParserRuleCallTransition; }

		// 'end'
		public Keyword ele1KeywordEnd() { return c1KeywordEnd; }
	}

	public class TransitionElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentEvent = (Assignment)c0Group.eContents().get(0);
		private final CrossReference c000CrossReferenceEvent = (CrossReference)c00AssignmentEvent.eContents().get(0);
		private final Keyword c01KeywordEqualsSignGreaterThanSign = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentState = (Assignment)cGroup.eContents().get(1);
		private final CrossReference c10CrossReferenceState = (CrossReference)c1AssignmentState.eContents().get(0);
		
		// Transition : event = [ Event ] '=>' state = [ State ] ;
		public ParserRule getRule() { return rule; }

		// event = [ Event ] '=>' state = [ State ]
		public Group eleGroup() { return cGroup; }

		// event = [ Event ] '=>'
		public Group ele0Group() { return c0Group; }

		// event = [ Event ]
		public Assignment ele00AssignmentEvent() { return c00AssignmentEvent; }

		// [ Event ]
		public CrossReference ele000CrossReferenceEvent() { return c000CrossReferenceEvent; }

		// '=>'
		public Keyword ele01KeywordEqualsSignGreaterThanSign() { return c01KeywordEqualsSignGreaterThanSign; }

		// state = [ State ]
		public Assignment ele1AssignmentState() { return c1AssignmentState; }

		// [ State ]
		public CrossReference ele10CrossReferenceState() { return c10CrossReferenceState; }
	}
	
	public final static FowlerDslTestLanguageGrammarAccess INSTANCE = new FowlerDslTestLanguageGrammarAccess();

	private static final String FOWLERDSLTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static StatemachineElements pStatemachine;
	private static EventElements pEvent;
	private static CommandElements pCommand;
	private static StateElements pState;
	private static TransitionElements pTransition;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(FowlerDslTestLanguageGrammarAccess.class.getClassLoader(),FOWLERDSLTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Statemachine : 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end' ( states += State ) * ;
	public StatemachineElements prStatemachine() {
		return (pStatemachine != null) ? pStatemachine : (pStatemachine = new StatemachineElements());
	} 

	// Event : ( resetting ?= 'resetting' ) ? name = ID code = ID ;
	public EventElements prEvent() {
		return (pEvent != null) ? pEvent : (pEvent = new EventElements());
	} 

	// Command : name = ID code = ID ;
	public CommandElements prCommand() {
		return (pCommand != null) ? pCommand : (pCommand = new CommandElements());
	} 

	// State : 'state' name = ID ( 'actions' '{' ( actions += [ Command ] ) + '}' ) ? ( transitions += Transition ) * 'end' ;
	public StateElements prState() {
		return (pState != null) ? pState : (pState = new StateElements());
	} 

	// Transition : event = [ Event ] '=>' state = [ State ] ;
	public TransitionElements prTransition() {
		return (pTransition != null) ? pTransition : (pTransition = new TransitionElements());
	} 
}
