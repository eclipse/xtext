/*
Generated with Xtext
*/

package org.eclipse.xtext.valueconverter.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class Bug250313GrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Group c000Group = (Group)c00Alternatives.eContents().get(0);
		private final Keyword c0000KeywordNumberSign = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentValue = (Assignment)c000Group.eContents().get(1);
		private final Alternatives c00010Alternatives = (Alternatives)c0001AssignmentValue.eContents().get(0);
		private final Alternatives c000100Alternatives = (Alternatives)c00010Alternatives.eContents().get(0);
		private final Alternatives c0001000Alternatives = (Alternatives)c000100Alternatives.eContents().get(0);
		private final Keyword c00010000KeywordMykeyword1 = (Keyword)c0001000Alternatives.eContents().get(0);
		private final RuleCall c00010001LexerRuleCallSTRING = (RuleCall)c0001000Alternatives.eContents().get(1);
		private final RuleCall c0001001ParserRuleCallDatatype = (RuleCall)c000100Alternatives.eContents().get(1);
		private final RuleCall c000101LexerRuleCallID = (RuleCall)c00010Alternatives.eContents().get(1);
		private final Group c001Group = (Group)c00Alternatives.eContents().get(1);
		private final Keyword c0010KeywordExclamationMark = (Keyword)c001Group.eContents().get(0);
		private final Assignment c0011AssignmentValue = (Assignment)c001Group.eContents().get(1);
		private final RuleCall c00110LexerRuleCallSTRING = (RuleCall)c0011AssignmentValue.eContents().get(0);
		private final Group c01Group = (Group)c0Alternatives.eContents().get(1);
		private final Keyword c010Keyword$ = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentValue = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110ParserRuleCallDatatype = (RuleCall)c011AssignmentValue.eContents().get(0);
		private final Group c1Group = (Group)cAlternatives.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Keyword c100KeywordContent = (Keyword)c10Group.eContents().get(0);
		private final Assignment c101AssignmentChildren = (Assignment)c10Group.eContents().get(1);
		private final RuleCall c1010ParserRuleCallChild = (RuleCall)c101AssignmentChildren.eContents().get(0);
		private final Group c11Group = (Group)c1Group.eContents().get(1);
		private final Keyword c110KeywordRef = (Keyword)c11Group.eContents().get(0);
		private final Assignment c111AssignmentRef = (Assignment)c11Group.eContents().get(1);
		private final Alternatives c1110Alternatives = (Alternatives)c111AssignmentRef.eContents().get(0);
		private final CrossReference c11100CrossReferenceEStringChild1 = (CrossReference)c1110Alternatives.eContents().get(0);
		private final CrossReference c11101CrossReferenceEStringChild2 = (CrossReference)c1110Alternatives.eContents().get(1);
		
		// Model:   "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING|"$" value=Datatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?;
		public ParserRule getRule() { return rule; }

		// "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING|"$" value=Datatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?
		public Alternatives eleAlternatives() { return cAlternatives; }

		// "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING|"$" value=Datatype
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// "#"? value=("mykeyword1"|STRING|Datatype|ID)
		public Group ele000Group() { return c000Group; }

		// "#"?
		public Keyword ele0000KeywordNumberSign() { return c0000KeywordNumberSign; }

		// value=("mykeyword1"|STRING|Datatype|ID)
		public Assignment ele0001AssignmentValue() { return c0001AssignmentValue; }

		// "mykeyword1"|STRING|Datatype|ID
		public Alternatives ele00010Alternatives() { return c00010Alternatives; }

		// "mykeyword1"|STRING|Datatype
		public Alternatives ele000100Alternatives() { return c000100Alternatives; }

		// "mykeyword1"|STRING
		public Alternatives ele0001000Alternatives() { return c0001000Alternatives; }

		// "mykeyword1"
		public Keyword ele00010000KeywordMykeyword1() { return c00010000KeywordMykeyword1; }

		// STRING
		public RuleCall ele00010001LexerRuleCallSTRING() { return c00010001LexerRuleCallSTRING; }

		// Datatype
		public RuleCall ele0001001ParserRuleCallDatatype() { return c0001001ParserRuleCallDatatype; }

		// ID
		public RuleCall ele000101LexerRuleCallID() { return c000101LexerRuleCallID; }

		// "!" value=STRING
		public Group ele001Group() { return c001Group; }

		// "!"
		public Keyword ele0010KeywordExclamationMark() { return c0010KeywordExclamationMark; }

		// value=STRING
		public Assignment ele0011AssignmentValue() { return c0011AssignmentValue; }

		// STRING
		public RuleCall ele00110LexerRuleCallSTRING() { return c00110LexerRuleCallSTRING; }

		// "$" value=Datatype
		public Group ele01Group() { return c01Group; }

		// "$"
		public Keyword ele010Keyword$() { return c010Keyword$; }

		// value=Datatype
		public Assignment ele011AssignmentValue() { return c011AssignmentValue; }

		// Datatype
		public RuleCall ele0110ParserRuleCallDatatype() { return c0110ParserRuleCallDatatype; }

		// "content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?
		public Group ele1Group() { return c1Group; }

		// "content" children=Child
		public Group ele10Group() { return c10Group; }

		// "content"
		public Keyword ele100KeywordContent() { return c100KeywordContent; }

		// children=Child
		public Assignment ele101AssignmentChildren() { return c101AssignmentChildren; }

		// Child
		public RuleCall ele1010ParserRuleCallChild() { return c1010ParserRuleCallChild; }

		// ("ref" ref=([Child1|STRING]|[Child2]))?
		public Group ele11Group() { return c11Group; }

		// "ref"
		public Keyword ele110KeywordRef() { return c110KeywordRef; }

		// ref=([Child1|STRING]|[Child2])
		public Assignment ele111AssignmentRef() { return c111AssignmentRef; }

		// [Child1|STRING]|[Child2]
		public Alternatives ele1110Alternatives() { return c1110Alternatives; }

		// [Child1|STRING]
		public CrossReference ele11100CrossReferenceEStringChild1() { return c11100CrossReferenceEStringChild1; }

		// [Child2]
		public CrossReference ele11101CrossReferenceEStringChild2() { return c11101CrossReferenceEStringChild2; }
	}

	public class DatatypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Datatype");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordGreaterThanSignGreaterThanSign = (Keyword)c00Group.eContents().get(0);
		private final RuleCall c001LexerRuleCallID = (RuleCall)c00Group.eContents().get(1);
		private final Keyword c01KeywordHyphenMinus = (Keyword)c0Group.eContents().get(1);
		private final RuleCall c1LexerRuleCallID = (RuleCall)cGroup.eContents().get(1);
		
		// Datatype returns EString:   ">>" ID "-" ID;
		public ParserRule getRule() { return rule; }

		// ">>" ID "-" ID
		public Group eleGroup() { return cGroup; }

		// ">>" ID "-"
		public Group ele0Group() { return c0Group; }

		// ">>" ID
		public Group ele00Group() { return c00Group; }

		// ">>"
		public Keyword ele000KeywordGreaterThanSignGreaterThanSign() { return c000KeywordGreaterThanSignGreaterThanSign; }

		// ID
		public RuleCall ele001LexerRuleCallID() { return c001LexerRuleCallID; }

		// "-"
		public Keyword ele01KeywordHyphenMinus() { return c01KeywordHyphenMinus; }

		// ID
		public RuleCall ele1LexerRuleCallID() { return c1LexerRuleCallID; }
	}

	public class ChildElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Child");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallChild1 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallChild2 = (RuleCall)cAlternatives.eContents().get(1);
		
		// Child:   Child1|Child2;
		public ParserRule getRule() { return rule; }

		// Child1|Child2
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Child1
		public RuleCall ele0ParserRuleCallChild1() { return c0ParserRuleCallChild1; }

		// Child2
		public RuleCall ele1ParserRuleCallChild2() { return c1ParserRuleCallChild2; }
	}

	public class Child1Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Child1");
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentName.eContents().get(0);
		
		// Child1:   name=ID;
		public ParserRule getRule() { return rule; }

		// name=ID
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}

	public class Child2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Child2");
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallSTRING = (RuleCall)cAssignmentName.eContents().get(0);
		
		// Child2:   name=STRING;
		public ParserRule getRule() { return rule; }

		// name=STRING
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() { return c0LexerRuleCallSTRING; }
	}
	
	public final static Bug250313GrammarAccess INSTANCE = new Bug250313GrammarAccess();

	private static final String BUG250313_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static DatatypeElements pDatatype;
	private static ChildElements pChild;
	private static Child1Elements pChild1;
	private static Child2Elements pChild2;
	private static LexerRule lID;
	private static LexerRule lINT;
	private static LexerRule lSTRING;
	private static LexerRule lML_COMMENT;
	private static LexerRule lSL_COMMENT;
	private static LexerRule lWS;
	private static LexerRule lANY_OTHER;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(Bug250313GrammarAccess.class.getClassLoader(),BUG250313_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// Model:   "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING|"$" value=Datatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Datatype returns EString:   ">>" ID "-" ID;
	public DatatypeElements prDatatype() {
		return (pDatatype != null) ? pDatatype : (pDatatype = new DatatypeElements());
	} 

	// Child:   Child1|Child2;
	public ChildElements prChild() {
		return (pChild != null) ? pChild : (pChild = new ChildElements());
	} 

	// Child1:   name=ID;
	public Child1Elements prChild1() {
		return (pChild1 != null) ? pChild1 : (pChild1 = new Child1Elements());
	} 

	// Child2:   name=STRING;
	public Child2Elements prChild2() {
		return (pChild2 != null) ? pChild2 : (pChild2 = new Child2Elements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return (lINT != null) ? lINT : (lINT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "INT"));
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return (lSTRING != null) ? lSTRING : (lSTRING = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return (lML_COMMENT != null) ? lML_COMMENT : (lML_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return (lSL_COMMENT != null) ? lSL_COMMENT : (lSL_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return (lWS != null) ? lWS : (lWS = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return (lANY_OTHER != null) ? lANY_OTHER : (lANY_OTHER = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 
}
