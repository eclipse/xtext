/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class TestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class EntryRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EntryRule");
		private final Assignment cAssignmentMultiFeature = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAbstractRule = (RuleCall)cAssignmentMultiFeature.eContents().get(0);
		
		// EntryRule returns Model:   (multiFeature+=AbstractRule)*;
		public ParserRule getRule() { return rule; }

		// (multiFeature+=AbstractRule)*
		public Assignment eleAssignmentMultiFeature() { return cAssignmentMultiFeature; }

		// AbstractRule
		public RuleCall ele0ParserRuleCallAbstractRule() { return c0ParserRuleCallAbstractRule; }
	}

	public class AbstractRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AbstractRule");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallChoiceRule = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallReducibleRule = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractRule returns AbstractElement:   ChoiceRule|ReducibleRule;
		public ParserRule getRule() { return rule; }

		// ChoiceRule|ReducibleRule
		public Alternatives eleAlternatives() { return cAlternatives; }

		// ChoiceRule
		public RuleCall ele0ParserRuleCallChoiceRule() { return c0ParserRuleCallChoiceRule; }

		// ReducibleRule
		public RuleCall ele1ParserRuleCallReducibleRule() { return c1ParserRuleCallReducibleRule; }
	}

	public class ChoiceRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ChoiceRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordChoice = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentOptionalKeyword = (Assignment)c0Group.eContents().get(1);
		private final Keyword c010KeywordOptional = (Keyword)c01AssignmentOptionalKeyword.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// ChoiceRule returns ChoiceElement:   "choice" (optionalKeyword?="optional")? name=ID;
		public ParserRule getRule() { return rule; }

		// "choice" (optionalKeyword?="optional")? name=ID
		public Group eleGroup() { return cGroup; }

		// "choice" (optionalKeyword?="optional")?
		public Group ele0Group() { return c0Group; }

		// "choice"
		public Keyword ele00KeywordChoice() { return c00KeywordChoice; }

		// (optionalKeyword?="optional")?
		public Assignment ele01AssignmentOptionalKeyword() { return c01AssignmentOptionalKeyword; }

		// "optional"
		public Keyword ele010KeywordOptional() { return c010KeywordOptional; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class ReducibleRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReducibleRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordReducible = (Keyword)c0Group.eContents().get(0);
		private final RuleCall c01ParserRuleCallTerminalRule = (RuleCall)c0Group.eContents().get(1);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionReducibleCompositeactionFeature = (Action)c1Group.eContents().get(0);
		private final Assignment c11AssignmentActionFeature = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallTerminalRule = (RuleCall)c11AssignmentActionFeature.eContents().get(0);
		
		// ReducibleRule returns ReducibleElement:   "reducible" TerminalRule ({current=ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule)?;
		public ParserRule getRule() { return rule; }

		// "reducible" TerminalRule ({current=ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule)?
		public Group eleGroup() { return cGroup; }

		// "reducible" TerminalRule
		public Group ele0Group() { return c0Group; }

		// "reducible"
		public Keyword ele00KeywordReducible() { return c00KeywordReducible; }

		// TerminalRule
		public RuleCall ele01ParserRuleCallTerminalRule() { return c01ParserRuleCallTerminalRule; }

		// ({current=ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule)?
		public Group ele1Group() { return c1Group; }

		// {current=ReducibleComposite.actionFeature+=current}
		public Action ele10ActionReducibleCompositeactionFeature() { return c10ActionReducibleCompositeactionFeature; }

		// actionFeature+=TerminalRule
		public Assignment ele11AssignmentActionFeature() { return c11AssignmentActionFeature; }

		// TerminalRule
		public RuleCall ele110ParserRuleCallTerminalRule() { return c110ParserRuleCallTerminalRule; }
	}

	public class TerminalRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TerminalRule");
		private final Assignment cAssignmentStringFeature = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallSTRING = (RuleCall)cAssignmentStringFeature.eContents().get(0);
		
		// TerminalRule returns TerminalElement:   stringFeature=STRING;
		public ParserRule getRule() { return rule; }

		// stringFeature=STRING
		public Assignment eleAssignmentStringFeature() { return cAssignmentStringFeature; }

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() { return c0LexerRuleCallSTRING; }
	}
	
	private EntryRuleElements pEntryRule;
	private AbstractRuleElements pAbstractRule;
	private ChoiceRuleElements pChoiceRule;
	private ReducibleRuleElements pReducibleRule;
	private TerminalRuleElements pTerminalRule;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public TestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// EntryRule returns Model:   (multiFeature+=AbstractRule)*;
	public EntryRuleElements prEntryRule() {
		return (pEntryRule != null) ? pEntryRule : (pEntryRule = new EntryRuleElements());
	} 

	// AbstractRule returns AbstractElement:   ChoiceRule|ReducibleRule;
	public AbstractRuleElements prAbstractRule() {
		return (pAbstractRule != null) ? pAbstractRule : (pAbstractRule = new AbstractRuleElements());
	} 

	// ChoiceRule returns ChoiceElement:   "choice" (optionalKeyword?="optional")? name=ID;
	public ChoiceRuleElements prChoiceRule() {
		return (pChoiceRule != null) ? pChoiceRule : (pChoiceRule = new ChoiceRuleElements());
	} 

	// ReducibleRule returns ReducibleElement:   "reducible" TerminalRule ({current=ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule)?;
	public ReducibleRuleElements prReducibleRule() {
		return (pReducibleRule != null) ? pReducibleRule : (pReducibleRule = new ReducibleRuleElements());
	} 

	// TerminalRule returns TerminalElement:   stringFeature=STRING;
	public TerminalRuleElements prTerminalRule() {
		return (pTerminalRule != null) ? pTerminalRule : (pTerminalRule = new TerminalRuleElements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return superGrammarAccess.lrID();
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return superGrammarAccess.lrINT();
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return superGrammarAccess.lrSTRING();
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return superGrammarAccess.lrML_COMMENT();
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return superGrammarAccess.lrSL_COMMENT();
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return superGrammarAccess.lrWS();
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return superGrammarAccess.lrANY_OTHER();
	} 
}
