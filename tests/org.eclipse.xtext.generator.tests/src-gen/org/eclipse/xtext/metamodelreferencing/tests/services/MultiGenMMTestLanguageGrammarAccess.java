/*
Generated with Xtext
*/

package org.eclipse.xtext.metamodelreferencing.tests.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class MultiGenMMTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class FooElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Foo");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentName = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentNameRefs = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallNameRef = (RuleCall)c1AssignmentNameRefs.eContents().get(0);
		
		// Foo:   name=ID (nameRefs+=NameRef)*;
		public ParserRule getRule() { return rule; }

		// name=ID (nameRefs+=NameRef)*
		public Group eleGroup() { return cGroup; }

		// name=ID
		public Assignment ele0AssignmentName() { return c0AssignmentName; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// (nameRefs+=NameRef)*
		public Assignment ele1AssignmentNameRefs() { return c1AssignmentNameRefs; }

		// NameRef
		public RuleCall ele10ParserRuleCallNameRef() { return c10ParserRuleCallNameRef; }
	}

	public class NameRefElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NameRef");
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallSTRING = (RuleCall)cAssignmentName.eContents().get(0);
		
		// NameRef returns other :: FooBar:   name=STRING;
		public ParserRule getRule() { return rule; }

		// name=STRING
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() { return c0LexerRuleCallSTRING; }
	}
	
	private FooElements pFoo;
	private NameRefElements pNameRef;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public MultiGenMMTestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Foo:   name=ID (nameRefs+=NameRef)*;
	public FooElements prFoo() {
		return (pFoo != null) ? pFoo : (pFoo = new FooElements());
	} 

	// NameRef returns other :: FooBar:   name=STRING;
	public NameRefElements prNameRef() {
		return (pNameRef != null) ? pNameRef : (pNameRef = new NameRefElements());
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
