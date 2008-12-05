/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class FowlerDslTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class StatemachineElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Group c00000Group;
		private Keyword c000000KeywordEvents;
		private Assignment c000001AssignmentEvents;
		private RuleCall c0000010ParserRuleCallEvent;
		private Keyword c00001KeywordEnd;
		private Keyword c0001KeywordCommands;
		private Assignment c001AssignmentCommands;
		private RuleCall c0010ParserRuleCallCommand;
		private Keyword c01KeywordEnd;
		private Assignment c1AssignmentStates;
		private RuleCall c10ParserRuleCallState;
		
		// Statemachine : 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end' ( states += State ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end' ( states += State ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) *
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'events' ( events += Event ) * 'end' 'commands'
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'events' ( events += Event ) * 'end'
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// 'events' ( events += Event ) *
		public Group ele00000Group() {
			return (c00000Group != null) ? c00000Group : (c00000Group = (Group)ele0000Group().eContents().get(0)); 
		}

		// 'events'
		public Keyword ele000000KeywordEvents() {
			return (c000000KeywordEvents != null) ? c000000KeywordEvents : (c000000KeywordEvents = (Keyword)ele00000Group().eContents().get(0)); 
		}

		// ( events += Event ) *
		public Assignment ele000001AssignmentEvents() {
			return (c000001AssignmentEvents != null) ? c000001AssignmentEvents : (c000001AssignmentEvents = (Assignment)ele00000Group().eContents().get(1)); 
		}

		// Event
		public RuleCall ele0000010ParserRuleCallEvent() {
			return (c0000010ParserRuleCallEvent != null) ? c0000010ParserRuleCallEvent : (c0000010ParserRuleCallEvent = (RuleCall)ele000001AssignmentEvents().eContents().get(0)); 
		}

		// 'end'
		public Keyword ele00001KeywordEnd() {
			return (c00001KeywordEnd != null) ? c00001KeywordEnd : (c00001KeywordEnd = (Keyword)ele0000Group().eContents().get(1)); 
		}

		// 'commands'
		public Keyword ele0001KeywordCommands() {
			return (c0001KeywordCommands != null) ? c0001KeywordCommands : (c0001KeywordCommands = (Keyword)ele000Group().eContents().get(1)); 
		}

		// ( commands += Command ) *
		public Assignment ele001AssignmentCommands() {
			return (c001AssignmentCommands != null) ? c001AssignmentCommands : (c001AssignmentCommands = (Assignment)ele00Group().eContents().get(1)); 
		}

		// Command
		public RuleCall ele0010ParserRuleCallCommand() {
			return (c0010ParserRuleCallCommand != null) ? c0010ParserRuleCallCommand : (c0010ParserRuleCallCommand = (RuleCall)ele001AssignmentCommands().eContents().get(0)); 
		}

		// 'end'
		public Keyword ele01KeywordEnd() {
			return (c01KeywordEnd != null) ? c01KeywordEnd : (c01KeywordEnd = (Keyword)ele0Group().eContents().get(1)); 
		}

		// ( states += State ) *
		public Assignment ele1AssignmentStates() {
			return (c1AssignmentStates != null) ? c1AssignmentStates : (c1AssignmentStates = (Assignment)eleGroup().eContents().get(1)); 
		}

		// State
		public RuleCall ele10ParserRuleCallState() {
			return (c10ParserRuleCallState != null) ? c10ParserRuleCallState : (c10ParserRuleCallState = (RuleCall)ele1AssignmentStates().eContents().get(0)); 
		}
	}

	public class EventElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Assignment c00AssignmentResetting;
		private Keyword c000KeywordResetting;
		private Assignment c01AssignmentName;
		private RuleCall c010LexerRuleCallID;
		private Assignment c1AssignmentCode;
		private RuleCall c10LexerRuleCallID;
		
		// Event : ( resetting ?= 'resetting' ) ? name = ID code = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// ( resetting ?= 'resetting' ) ? name = ID code = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// ( resetting ?= 'resetting' ) ? name = ID
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// ( resetting ?= 'resetting' ) ?
		public Assignment ele00AssignmentResetting() {
			return (c00AssignmentResetting != null) ? c00AssignmentResetting : (c00AssignmentResetting = (Assignment)ele0Group().eContents().get(0)); 
		}

		// 'resetting'
		public Keyword ele000KeywordResetting() {
			return (c000KeywordResetting != null) ? c000KeywordResetting : (c000KeywordResetting = (Keyword)ele00AssignmentResetting().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele01AssignmentName() {
			return (c01AssignmentName != null) ? c01AssignmentName : (c01AssignmentName = (Assignment)ele0Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele010LexerRuleCallID() {
			return (c010LexerRuleCallID != null) ? c010LexerRuleCallID : (c010LexerRuleCallID = (RuleCall)ele01AssignmentName().eContents().get(0)); 
		}

		// code = ID
		public Assignment ele1AssignmentCode() {
			return (c1AssignmentCode != null) ? c1AssignmentCode : (c1AssignmentCode = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentCode().eContents().get(0)); 
		}
	}

	public class CommandElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Assignment c0AssignmentName;
		private RuleCall c00LexerRuleCallID;
		private Assignment c1AssignmentCode;
		private RuleCall c10LexerRuleCallID;
		
		// Command : name = ID code = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// name = ID code = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0AssignmentName() {
			return (c0AssignmentName != null) ? c0AssignmentName : (c0AssignmentName = (Assignment)eleGroup().eContents().get(0)); 
		}

		// ID
		public RuleCall ele00LexerRuleCallID() {
			return (c00LexerRuleCallID != null) ? c00LexerRuleCallID : (c00LexerRuleCallID = (RuleCall)ele0AssignmentName().eContents().get(0)); 
		}

		// code = ID
		public Assignment ele1AssignmentCode() {
			return (c1AssignmentCode != null) ? c1AssignmentCode : (c1AssignmentCode = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentCode().eContents().get(0)); 
		}
	}

	public class StateElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordState;
		private Assignment c0001AssignmentName;
		private RuleCall c00010LexerRuleCallID;
		private Group c001Group;
		private Group c0010Group;
		private Group c00100Group;
		private Keyword c001000KeywordActions;
		private Keyword c001001Keyword;
		private Assignment c00101AssignmentActions;
		private CrossReference c001010CrossReferenceCommand;
		private Keyword c0011Keyword;
		private Assignment c01AssignmentTransitions;
		private RuleCall c010ParserRuleCallTransition;
		private Keyword c1KeywordEnd;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// (error)
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// (error)
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'state' name = ID
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'state'
		public Keyword ele0000KeywordState() {
			return (c0000KeywordState != null) ? c0000KeywordState : (c0000KeywordState = (Keyword)ele000Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0001AssignmentName() {
			return (c0001AssignmentName != null) ? c0001AssignmentName : (c0001AssignmentName = (Assignment)ele000Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele00010LexerRuleCallID() {
			return (c00010LexerRuleCallID != null) ? c00010LexerRuleCallID : (c00010LexerRuleCallID = (RuleCall)ele0001AssignmentName().eContents().get(0)); 
		}

		// (error)
		public Group ele001Group() {
			return (c001Group != null) ? c001Group : (c001Group = (Group)ele00Group().eContents().get(1)); 
		}

		// (error)
		public Group ele0010Group() {
			return (c0010Group != null) ? c0010Group : (c0010Group = (Group)ele001Group().eContents().get(0)); 
		}

		// 'actions' '{'
		public Group ele00100Group() {
			return (c00100Group != null) ? c00100Group : (c00100Group = (Group)ele0010Group().eContents().get(0)); 
		}

		// 'actions'
		public Keyword ele001000KeywordActions() {
			return (c001000KeywordActions != null) ? c001000KeywordActions : (c001000KeywordActions = (Keyword)ele00100Group().eContents().get(0)); 
		}

		// '{'
		public Keyword ele001001Keyword() {
			return (c001001Keyword != null) ? c001001Keyword : (c001001Keyword = (Keyword)ele00100Group().eContents().get(1)); 
		}

		// (error)
		public Assignment ele00101AssignmentActions() {
			return (c00101AssignmentActions != null) ? c00101AssignmentActions : (c00101AssignmentActions = (Assignment)ele0010Group().eContents().get(1)); 
		}

		// (error)
		public CrossReference ele001010CrossReferenceCommand() {
			return (c001010CrossReferenceCommand != null) ? c001010CrossReferenceCommand : (c001010CrossReferenceCommand = (CrossReference)ele00101AssignmentActions().eContents().get(0)); 
		}

		// '}'
		public Keyword ele0011Keyword() {
			return (c0011Keyword != null) ? c0011Keyword : (c0011Keyword = (Keyword)ele001Group().eContents().get(1)); 
		}

		// ( transitions += Transition ) *
		public Assignment ele01AssignmentTransitions() {
			return (c01AssignmentTransitions != null) ? c01AssignmentTransitions : (c01AssignmentTransitions = (Assignment)ele0Group().eContents().get(1)); 
		}

		// Transition
		public RuleCall ele010ParserRuleCallTransition() {
			return (c010ParserRuleCallTransition != null) ? c010ParserRuleCallTransition : (c010ParserRuleCallTransition = (RuleCall)ele01AssignmentTransitions().eContents().get(0)); 
		}

		// 'end'
		public Keyword ele1KeywordEnd() {
			return (c1KeywordEnd != null) ? c1KeywordEnd : (c1KeywordEnd = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class TransitionElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Assignment c00AssignmentEvent;
		private CrossReference c000CrossReferenceEvent;
		private Keyword c01Keyword;
		private Assignment c1AssignmentState;
		private CrossReference c10CrossReferenceState;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// (error)
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// (error)
		public Assignment ele00AssignmentEvent() {
			return (c00AssignmentEvent != null) ? c00AssignmentEvent : (c00AssignmentEvent = (Assignment)ele0Group().eContents().get(0)); 
		}

		// (error)
		public CrossReference ele000CrossReferenceEvent() {
			return (c000CrossReferenceEvent != null) ? c000CrossReferenceEvent : (c000CrossReferenceEvent = (CrossReference)ele00AssignmentEvent().eContents().get(0)); 
		}

		// '=>'
		public Keyword ele01Keyword() {
			return (c01Keyword != null) ? c01Keyword : (c01Keyword = (Keyword)ele0Group().eContents().get(1)); 
		}

		// (error)
		public Assignment ele1AssignmentState() {
			return (c1AssignmentState != null) ? c1AssignmentState : (c1AssignmentState = (Assignment)eleGroup().eContents().get(1)); 
		}

		// (error)
		public CrossReference ele10CrossReferenceState() {
			return (c10CrossReferenceState != null) ? c10CrossReferenceState : (c10CrossReferenceState = (CrossReference)ele1AssignmentState().eContents().get(0)); 
		}
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

	// (error)
	public StateElements prState() {
		return (pState != null) ? pState : (pState = new StateElements());
	} 

	// (error)
	public TransitionElements prTransition() {
		return (pTransition != null) ? pTransition : (pTransition = new TransitionElements());
	} 
}
