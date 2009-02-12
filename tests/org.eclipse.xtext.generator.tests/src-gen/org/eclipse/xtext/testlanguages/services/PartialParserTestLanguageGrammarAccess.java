/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class PartialParserTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ContainerElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Container");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordContainer = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Assignment c010AssignmentNested = (Assignment)c01Alternatives.eContents().get(0);
		private final RuleCall c0100ParserRuleCallNested = (RuleCall)c010AssignmentNested.eContents().get(0);
		private final Assignment c011AssignmentContent = (Assignment)c01Alternatives.eContents().get(1);
		private final RuleCall c0110ParserRuleCallContent = (RuleCall)c011AssignmentContent.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Container:   "container" name=ID "{" (nested+=Nested|content+=Content)* "}";
		public ParserRule getRule() { return rule; }

		// "container" name=ID "{" (nested+=Nested|content+=Content)* "}"
		public Group eleGroup() { return cGroup; }

		// "container" name=ID "{" (nested+=Nested|content+=Content)*
		public Group ele0Group() { return c0Group; }

		// "container" name=ID "{"
		public Group ele00Group() { return c00Group; }

		// "container" name=ID
		public Group ele000Group() { return c000Group; }

		// "container"
		public Keyword ele0000KeywordContainer() { return c0000KeywordContainer; }

		// name=ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (nested+=Nested|content+=Content)*
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// nested+=Nested
		public Assignment ele010AssignmentNested() { return c010AssignmentNested; }

		// Nested
		public RuleCall ele0100ParserRuleCallNested() { return c0100ParserRuleCallNested; }

		// content+=Content
		public Assignment ele011AssignmentContent() { return c011AssignmentContent; }

		// Content
		public RuleCall ele0110ParserRuleCallContent() { return c0110ParserRuleCallContent; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class NestedElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Nested");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordNested = (Keyword)c00Group.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentNested = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallContainer = (RuleCall)c01AssignmentNested.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Nested:   "nested" "{" (nested+=Container)+ "}";
		public ParserRule getRule() { return rule; }

		// "nested" "{" (nested+=Container)+ "}"
		public Group eleGroup() { return cGroup; }

		// "nested" "{" (nested+=Container)+
		public Group ele0Group() { return c0Group; }

		// "nested" "{"
		public Group ele00Group() { return c00Group; }

		// "nested"
		public Keyword ele000KeywordNested() { return c000KeywordNested; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (nested+=Container)+
		public Assignment ele01AssignmentNested() { return c01AssignmentNested; }

		// Container
		public RuleCall ele010ParserRuleCallContainer() { return c010ParserRuleCallContainer; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class ContentElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Content");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallChildren = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallAbstractChildren = (RuleCall)cAlternatives.eContents().get(1);
		
		// Content:   Children|AbstractChildren;
		public ParserRule getRule() { return rule; }

		// Children|AbstractChildren
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Children
		public RuleCall ele0ParserRuleCallChildren() { return c0ParserRuleCallChildren; }

		// AbstractChildren
		public RuleCall ele1ParserRuleCallAbstractChildren() { return c1ParserRuleCallAbstractChildren; }
	}

	public class ChildrenElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Children");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordChildren = (Keyword)c000Group.eContents().get(0);
		private final Keyword c0001KeywordLeftCurlyBracket = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentChildren = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallChild = (RuleCall)c001AssignmentChildren.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordComma = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentChildren = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110ParserRuleCallChild = (RuleCall)c011AssignmentChildren.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Children:   "children" "{" children+=Child ("," children+=Child)* "}";
		public ParserRule getRule() { return rule; }

		// "children" "{" children+=Child ("," children+=Child)* "}"
		public Group eleGroup() { return cGroup; }

		// "children" "{" children+=Child ("," children+=Child)*
		public Group ele0Group() { return c0Group; }

		// "children" "{" children+=Child
		public Group ele00Group() { return c00Group; }

		// "children" "{"
		public Group ele000Group() { return c000Group; }

		// "children"
		public Keyword ele0000KeywordChildren() { return c0000KeywordChildren; }

		// "{"
		public Keyword ele0001KeywordLeftCurlyBracket() { return c0001KeywordLeftCurlyBracket; }

		// children+=Child
		public Assignment ele001AssignmentChildren() { return c001AssignmentChildren; }

		// Child
		public RuleCall ele0010ParserRuleCallChild() { return c0010ParserRuleCallChild; }

		// ("," children+=Child)*
		public Group ele01Group() { return c01Group; }

		// ","
		public Keyword ele010KeywordComma() { return c010KeywordComma; }

		// children+=Child
		public Assignment ele011AssignmentChildren() { return c011AssignmentChildren; }

		// Child
		public RuleCall ele0110ParserRuleCallChild() { return c0110ParserRuleCallChild; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class ChildElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Child");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordHyphenMinusGreaterThanSign = (Keyword)c000Group.eContents().get(0);
		private final Keyword c0001KeywordC = (Keyword)c000Group.eContents().get(1);
		private final Keyword c001KeywordLeftParenthesis = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentValue = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallNamed = (RuleCall)c01AssignmentValue.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Child:   "->" "C" "(" value=Named ")";
		public ParserRule getRule() { return rule; }

		// "->" "C" "(" value=Named ")"
		public Group eleGroup() { return cGroup; }

		// "->" "C" "(" value=Named
		public Group ele0Group() { return c0Group; }

		// "->" "C" "("
		public Group ele00Group() { return c00Group; }

		// "->" "C"
		public Group ele000Group() { return c000Group; }

		// "->"
		public Keyword ele0000KeywordHyphenMinusGreaterThanSign() { return c0000KeywordHyphenMinusGreaterThanSign; }

		// "C"
		public Keyword ele0001KeywordC() { return c0001KeywordC; }

		// "("
		public Keyword ele001KeywordLeftParenthesis() { return c001KeywordLeftParenthesis; }

		// value=Named
		public Assignment ele01AssignmentValue() { return c01AssignmentValue; }

		// Named
		public RuleCall ele010ParserRuleCallNamed() { return c010ParserRuleCallNamed; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class AbstractChildrenElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AbstractChildren");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordAbstractChildren = (Keyword)c00Group.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentAbstractChildren = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallAbstractChild = (RuleCall)c01AssignmentAbstractChildren.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// AbstractChildren:   "abstract children" "{" (abstractChildren+=AbstractChild)+ "}";
		public ParserRule getRule() { return rule; }

		// "abstract children" "{" (abstractChildren+=AbstractChild)+ "}"
		public Group eleGroup() { return cGroup; }

		// "abstract children" "{" (abstractChildren+=AbstractChild)+
		public Group ele0Group() { return c0Group; }

		// "abstract children" "{"
		public Group ele00Group() { return c00Group; }

		// "abstract children"
		public Keyword ele000KeywordAbstractChildren() { return c000KeywordAbstractChildren; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (abstractChildren+=AbstractChild)+
		public Assignment ele01AssignmentAbstractChildren() { return c01AssignmentAbstractChildren; }

		// AbstractChild
		public RuleCall ele010ParserRuleCallAbstractChild() { return c010ParserRuleCallAbstractChild; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class AbstractChildElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AbstractChild");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallFirstConcrete = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallSecondConcrete = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractChild:   FirstConcrete|SecondConcrete;
		public ParserRule getRule() { return rule; }

		// FirstConcrete|SecondConcrete
		public Alternatives eleAlternatives() { return cAlternatives; }

		// FirstConcrete
		public RuleCall ele0ParserRuleCallFirstConcrete() { return c0ParserRuleCallFirstConcrete; }

		// SecondConcrete
		public RuleCall ele1ParserRuleCallSecondConcrete() { return c1ParserRuleCallSecondConcrete; }
	}

	public class FirstConcreteElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FirstConcrete");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Keyword c00000KeywordHyphenMinusGreaterThanSign = (Keyword)c0000Group.eContents().get(0);
		private final Keyword c00001KeywordF = (Keyword)c0000Group.eContents().get(1);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentValue = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallNamed = (RuleCall)c001AssignmentValue.eContents().get(0);
		private final Assignment c01AssignmentReferencedContainer = (Assignment)c0Group.eContents().get(1);
		private final CrossReference c010CrossReferenceEStringContainer = (CrossReference)c01AssignmentReferencedContainer.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// FirstConcrete:   "->" "F" "(" value=Named (referencedContainer=[Container])? ")";
		public ParserRule getRule() { return rule; }

		// "->" "F" "(" value=Named (referencedContainer=[Container])? ")"
		public Group eleGroup() { return cGroup; }

		// "->" "F" "(" value=Named (referencedContainer=[Container])?
		public Group ele0Group() { return c0Group; }

		// "->" "F" "(" value=Named
		public Group ele00Group() { return c00Group; }

		// "->" "F" "("
		public Group ele000Group() { return c000Group; }

		// "->" "F"
		public Group ele0000Group() { return c0000Group; }

		// "->"
		public Keyword ele00000KeywordHyphenMinusGreaterThanSign() { return c00000KeywordHyphenMinusGreaterThanSign; }

		// "F"
		public Keyword ele00001KeywordF() { return c00001KeywordF; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// value=Named
		public Assignment ele001AssignmentValue() { return c001AssignmentValue; }

		// Named
		public RuleCall ele0010ParserRuleCallNamed() { return c0010ParserRuleCallNamed; }

		// (referencedContainer=[Container])?
		public Assignment ele01AssignmentReferencedContainer() { return c01AssignmentReferencedContainer; }

		// [Container]
		public CrossReference ele010CrossReferenceEStringContainer() { return c010CrossReferenceEStringContainer; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class SecondConcreteElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SecondConcrete");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Keyword c000000KeywordHyphenMinusGreaterThanSign = (Keyword)c00000Group.eContents().get(0);
		private final Keyword c000001KeywordF = (Keyword)c00000Group.eContents().get(1);
		private final Keyword c00001KeywordS = (Keyword)c0000Group.eContents().get(1);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentValue = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallNamed = (RuleCall)c001AssignmentValue.eContents().get(0);
		private final Assignment c01AssignmentReferencedChildren = (Assignment)c0Group.eContents().get(1);
		private final CrossReference c010CrossReferenceEStringChild = (CrossReference)c01AssignmentReferencedChildren.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// SecondConcrete:   "->" "F" "S" "(" value=Named (referencedChildren+=[Child])? ")";
		public ParserRule getRule() { return rule; }

		// "->" "F" "S" "(" value=Named (referencedChildren+=[Child])? ")"
		public Group eleGroup() { return cGroup; }

		// "->" "F" "S" "(" value=Named (referencedChildren+=[Child])?
		public Group ele0Group() { return c0Group; }

		// "->" "F" "S" "(" value=Named
		public Group ele00Group() { return c00Group; }

		// "->" "F" "S" "("
		public Group ele000Group() { return c000Group; }

		// "->" "F" "S"
		public Group ele0000Group() { return c0000Group; }

		// "->" "F"
		public Group ele00000Group() { return c00000Group; }

		// "->"
		public Keyword ele000000KeywordHyphenMinusGreaterThanSign() { return c000000KeywordHyphenMinusGreaterThanSign; }

		// "F"
		public Keyword ele000001KeywordF() { return c000001KeywordF; }

		// "S"
		public Keyword ele00001KeywordS() { return c00001KeywordS; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// value=Named
		public Assignment ele001AssignmentValue() { return c001AssignmentValue; }

		// Named
		public RuleCall ele0010ParserRuleCallNamed() { return c0010ParserRuleCallNamed; }

		// (referencedChildren+=[Child])?
		public Assignment ele01AssignmentReferencedChildren() { return c01AssignmentReferencedChildren; }

		// [Child]
		public CrossReference ele010CrossReferenceEStringChild() { return c010CrossReferenceEStringChild; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class NamedElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Named");
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentName.eContents().get(0);
		
		// Named:   name=ID;
		public ParserRule getRule() { return rule; }

		// name=ID
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}
	
	public final static PartialParserTestLanguageGrammarAccess INSTANCE = new PartialParserTestLanguageGrammarAccess();

	private static final String PARTIALPARSERTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ContainerElements pContainer;
	private static NestedElements pNested;
	private static ContentElements pContent;
	private static ChildrenElements pChildren;
	private static ChildElements pChild;
	private static AbstractChildrenElements pAbstractChildren;
	private static AbstractChildElements pAbstractChild;
	private static FirstConcreteElements pFirstConcrete;
	private static SecondConcreteElements pSecondConcrete;
	private static NamedElements pNamed;
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
			GRAMMAR = (Grammar) loadGrammarFile(PartialParserTestLanguageGrammarAccess.class.getClassLoader(),PARTIALPARSERTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// Container:   "container" name=ID "{" (nested+=Nested|content+=Content)* "}";
	public ContainerElements prContainer() {
		return (pContainer != null) ? pContainer : (pContainer = new ContainerElements());
	} 

	// Nested:   "nested" "{" (nested+=Container)+ "}";
	public NestedElements prNested() {
		return (pNested != null) ? pNested : (pNested = new NestedElements());
	} 

	// Content:   Children|AbstractChildren;
	public ContentElements prContent() {
		return (pContent != null) ? pContent : (pContent = new ContentElements());
	} 

	// Children:   "children" "{" children+=Child ("," children+=Child)* "}";
	public ChildrenElements prChildren() {
		return (pChildren != null) ? pChildren : (pChildren = new ChildrenElements());
	} 

	// Child:   "->" "C" "(" value=Named ")";
	public ChildElements prChild() {
		return (pChild != null) ? pChild : (pChild = new ChildElements());
	} 

	// AbstractChildren:   "abstract children" "{" (abstractChildren+=AbstractChild)+ "}";
	public AbstractChildrenElements prAbstractChildren() {
		return (pAbstractChildren != null) ? pAbstractChildren : (pAbstractChildren = new AbstractChildrenElements());
	} 

	// AbstractChild:   FirstConcrete|SecondConcrete;
	public AbstractChildElements prAbstractChild() {
		return (pAbstractChild != null) ? pAbstractChild : (pAbstractChild = new AbstractChildElements());
	} 

	// FirstConcrete:   "->" "F" "(" value=Named (referencedContainer=[Container])? ")";
	public FirstConcreteElements prFirstConcrete() {
		return (pFirstConcrete != null) ? pFirstConcrete : (pFirstConcrete = new FirstConcreteElements());
	} 

	// SecondConcrete:   "->" "F" "S" "(" value=Named (referencedChildren+=[Child])? ")";
	public SecondConcreteElements prSecondConcrete() {
		return (pSecondConcrete != null) ? pSecondConcrete : (pSecondConcrete = new SecondConcreteElements());
	} 

	// Named:   name=ID;
	public NamedElements prNamed() {
		return (pNamed != null) ? pNamed : (pNamed = new NamedElements());
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
