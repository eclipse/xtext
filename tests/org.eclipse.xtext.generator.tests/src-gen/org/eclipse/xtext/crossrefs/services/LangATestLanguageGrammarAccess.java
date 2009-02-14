/*
Generated with Xtext
*/

package org.eclipse.xtext.crossrefs.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class LangATestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class MainElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Main");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentImports = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00ParserRuleCallImport = (RuleCall)c0AssignmentImports.eContents().get(0);
		private final Assignment c1AssignmentTypes = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallType = (RuleCall)c1AssignmentTypes.eContents().get(0);
		
		// Main:   (imports+=Import)* (types+=Type)*;
		public ParserRule getRule() { return rule; }

		// (imports+=Import)* (types+=Type)*
		public Group eleGroup() { return cGroup; }

		// (imports+=Import)*
		public Assignment ele0AssignmentImports() { return c0AssignmentImports; }

		// Import
		public RuleCall ele00ParserRuleCallImport() { return c00ParserRuleCallImport; }

		// (types+=Type)*
		public Assignment ele1AssignmentTypes() { return c1AssignmentTypes; }

		// Type
		public RuleCall ele10ParserRuleCallType() { return c10ParserRuleCallType; }
	}

	public class ImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordImport = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentUri = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentUri.eContents().get(0);
		
		// Import:   "import" uri=STRING;
		public ParserRule getRule() { return rule; }

		// "import" uri=STRING
		public Group eleGroup() { return cGroup; }

		// "import"
		public Keyword ele0KeywordImport() { return c0KeywordImport; }

		// uri=STRING
		public Assignment ele1AssignmentUri() { return c1AssignmentUri; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class TypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Type");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordType = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Keyword c01KeywordExtends = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentExtends = (Assignment)cGroup.eContents().get(1);
		private final CrossReference c10CrossReferenceEStringType = (CrossReference)c1AssignmentExtends.eContents().get(0);
		
		// Type:   "type" name=ID "extends" ^extends=[Type];
		public ParserRule getRule() { return rule; }

		// "type" name=ID "extends" ^extends=[Type]
		public Group eleGroup() { return cGroup; }

		// "type" name=ID "extends"
		public Group ele0Group() { return c0Group; }

		// "type" name=ID
		public Group ele00Group() { return c00Group; }

		// "type"
		public Keyword ele000KeywordType() { return c000KeywordType; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// "extends"
		public Keyword ele01KeywordExtends() { return c01KeywordExtends; }

		// ^extends=[Type]
		public Assignment ele1AssignmentExtends() { return c1AssignmentExtends; }

		// [Type]
		public CrossReference ele10CrossReferenceEStringType() { return c10CrossReferenceEStringType; }
	}
	
	private MainElements pMain;
	private ImportElements pImport;
	private TypeElements pType;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public LangATestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Main:   (imports+=Import)* (types+=Type)*;
	public MainElements prMain() {
		return (pMain != null) ? pMain : (pMain = new MainElements());
	} 

	// Import:   "import" uri=STRING;
	public ImportElements prImport() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	} 

	// Type:   "type" name=ID "extends" ^extends=[Type];
	public TypeElements prType() {
		return (pType != null) ? pType : (pType = new TypeElements());
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
