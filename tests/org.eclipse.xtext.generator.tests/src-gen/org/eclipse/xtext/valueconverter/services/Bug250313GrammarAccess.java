/*
Generated with Xtext
*/

package org.eclipse.xtext.valueconverter.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class Bug250313GrammarAccess implements IGrammarAccess {
	
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Alternatives c000Alternatives = (Alternatives)c00Alternatives.eContents().get(0);
		private final Alternatives c0000Alternatives = (Alternatives)c000Alternatives.eContents().get(0);
		private final Alternatives c00000Alternatives = (Alternatives)c0000Alternatives.eContents().get(0);
		private final Alternatives c000000Alternatives = (Alternatives)c00000Alternatives.eContents().get(0);
		private final Alternatives c0000000Alternatives = (Alternatives)c000000Alternatives.eContents().get(0);
		private final Group c00000000Group = (Group)c0000000Alternatives.eContents().get(0);
		private final Keyword c000000000KeywordDigitOne = (Keyword)c00000000Group.eContents().get(0);
		private final Assignment c000000001AssignmentValue = (Assignment)c00000000Group.eContents().get(1);
		private final Alternatives c0000000010Alternatives = (Alternatives)c000000001AssignmentValue.eContents().get(0);
		private final Alternatives c00000000100Alternatives = (Alternatives)c0000000010Alternatives.eContents().get(0);
		private final Alternatives c000000001000Alternatives = (Alternatives)c00000000100Alternatives.eContents().get(0);
		private final Alternatives c0000000010000Alternatives = (Alternatives)c000000001000Alternatives.eContents().get(0);
		private final Keyword c00000000100000KeywordMykeyword1 = (Keyword)c0000000010000Alternatives.eContents().get(0);
		private final RuleCall c00000000100001LexerRuleCallSTRING = (RuleCall)c0000000010000Alternatives.eContents().get(1);
		private final RuleCall c0000000010001ParserRuleCallNestedDatatype = (RuleCall)c000000001000Alternatives.eContents().get(1);
		private final RuleCall c000000001001ParserRuleCallDatatype = (RuleCall)c00000000100Alternatives.eContents().get(1);
		private final RuleCall c00000000101LexerRuleCallID = (RuleCall)c0000000010Alternatives.eContents().get(1);
		private final Group c00000001Group = (Group)c0000000Alternatives.eContents().get(1);
		private final Keyword c000000010KeywordDigitOnePlusSign = (Keyword)c00000001Group.eContents().get(0);
		private final Assignment c000000011AssignmentMultiValue = (Assignment)c00000001Group.eContents().get(1);
		private final Alternatives c0000000110Alternatives = (Alternatives)c000000011AssignmentMultiValue.eContents().get(0);
		private final Alternatives c00000001100Alternatives = (Alternatives)c0000000110Alternatives.eContents().get(0);
		private final Alternatives c000000011000Alternatives = (Alternatives)c00000001100Alternatives.eContents().get(0);
		private final Alternatives c0000000110000Alternatives = (Alternatives)c000000011000Alternatives.eContents().get(0);
		private final Keyword c00000001100000KeywordMykeyword1 = (Keyword)c0000000110000Alternatives.eContents().get(0);
		private final RuleCall c00000001100001LexerRuleCallSTRING = (RuleCall)c0000000110000Alternatives.eContents().get(1);
		private final RuleCall c0000000110001ParserRuleCallNestedDatatype = (RuleCall)c000000011000Alternatives.eContents().get(1);
		private final RuleCall c000000011001ParserRuleCallDatatype = (RuleCall)c00000001100Alternatives.eContents().get(1);
		private final RuleCall c00000001101LexerRuleCallID = (RuleCall)c0000000110Alternatives.eContents().get(1);
		private final Group c0000001Group = (Group)c000000Alternatives.eContents().get(1);
		private final Keyword c00000010KeywordDigitTwo = (Keyword)c0000001Group.eContents().get(0);
		private final Assignment c00000011AssignmentValue = (Assignment)c0000001Group.eContents().get(1);
		private final RuleCall c000000110LexerRuleCallSTRING = (RuleCall)c00000011AssignmentValue.eContents().get(0);
		private final Group c000001Group = (Group)c00000Alternatives.eContents().get(1);
		private final Keyword c0000010KeywordDigitTwoPlusSign = (Keyword)c000001Group.eContents().get(0);
		private final Assignment c0000011AssignmentMultiValue = (Assignment)c000001Group.eContents().get(1);
		private final RuleCall c00000110LexerRuleCallSTRING = (RuleCall)c0000011AssignmentMultiValue.eContents().get(0);
		private final Group c00001Group = (Group)c0000Alternatives.eContents().get(1);
		private final Keyword c000010KeywordDigitThree = (Keyword)c00001Group.eContents().get(0);
		private final Assignment c000011AssignmentValue = (Assignment)c00001Group.eContents().get(1);
		private final RuleCall c0000110ParserRuleCallDatatype = (RuleCall)c000011AssignmentValue.eContents().get(0);
		private final Group c0001Group = (Group)c000Alternatives.eContents().get(1);
		private final Keyword c00010KeywordDigitThreePlusSign = (Keyword)c0001Group.eContents().get(0);
		private final Assignment c00011AssignmentMultiValue = (Assignment)c0001Group.eContents().get(1);
		private final RuleCall c000110ParserRuleCallDatatype = (RuleCall)c00011AssignmentMultiValue.eContents().get(0);
		private final Group c001Group = (Group)c00Alternatives.eContents().get(1);
		private final Keyword c0010KeywordDigitFour = (Keyword)c001Group.eContents().get(0);
		private final Assignment c0011AssignmentValue = (Assignment)c001Group.eContents().get(1);
		private final RuleCall c00110ParserRuleCallNestedDatatype = (RuleCall)c0011AssignmentValue.eContents().get(0);
		private final Group c01Group = (Group)c0Alternatives.eContents().get(1);
		private final Keyword c010KeywordDigitFourPlusSign = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentMultiValue = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110ParserRuleCallNestedDatatype = (RuleCall)c011AssignmentMultiValue.eContents().get(0);
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
		
		// Model:   "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING|"3" value=Datatype|"3+" multiValue+=Datatype|"4" value=NestedDatatype|"4+" multiValue+=NestedDatatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?;
		public ParserRule getRule() { return rule; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING|"3" value=Datatype|"3+" multiValue+=Datatype|"4" value=NestedDatatype|"4+" multiValue+=NestedDatatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?
		public Alternatives eleAlternatives() { return cAlternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING|"3" value=Datatype|"3+" multiValue+=Datatype|"4" value=NestedDatatype|"4+" multiValue+=NestedDatatype
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING|"3" value=Datatype|"3+" multiValue+=Datatype|"4" value=NestedDatatype
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING|"3" value=Datatype|"3+" multiValue+=Datatype
		public Alternatives ele000Alternatives() { return c000Alternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING|"3" value=Datatype
		public Alternatives ele0000Alternatives() { return c0000Alternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING
		public Alternatives ele00000Alternatives() { return c00000Alternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING
		public Alternatives ele000000Alternatives() { return c000000Alternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)
		public Alternatives ele0000000Alternatives() { return c0000000Alternatives; }

		// "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)
		public Group ele00000000Group() { return c00000000Group; }

		// "1"?
		public Keyword ele000000000KeywordDigitOne() { return c000000000KeywordDigitOne; }

		// value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)
		public Assignment ele000000001AssignmentValue() { return c000000001AssignmentValue; }

		// "mykeyword1"|STRING|NestedDatatype|Datatype|ID
		public Alternatives ele0000000010Alternatives() { return c0000000010Alternatives; }

		// "mykeyword1"|STRING|NestedDatatype|Datatype
		public Alternatives ele00000000100Alternatives() { return c00000000100Alternatives; }

		// "mykeyword1"|STRING|NestedDatatype
		public Alternatives ele000000001000Alternatives() { return c000000001000Alternatives; }

		// "mykeyword1"|STRING
		public Alternatives ele0000000010000Alternatives() { return c0000000010000Alternatives; }

		// "mykeyword1"
		public Keyword ele00000000100000KeywordMykeyword1() { return c00000000100000KeywordMykeyword1; }

		// STRING
		public RuleCall ele00000000100001LexerRuleCallSTRING() { return c00000000100001LexerRuleCallSTRING; }

		// NestedDatatype
		public RuleCall ele0000000010001ParserRuleCallNestedDatatype() { return c0000000010001ParserRuleCallNestedDatatype; }

		// Datatype
		public RuleCall ele000000001001ParserRuleCallDatatype() { return c000000001001ParserRuleCallDatatype; }

		// ID
		public RuleCall ele00000000101LexerRuleCallID() { return c00000000101LexerRuleCallID; }

		// "1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)
		public Group ele00000001Group() { return c00000001Group; }

		// "1+"
		public Keyword ele000000010KeywordDigitOnePlusSign() { return c000000010KeywordDigitOnePlusSign; }

		// multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)
		public Assignment ele000000011AssignmentMultiValue() { return c000000011AssignmentMultiValue; }

		// "mykeyword1"|STRING|NestedDatatype|Datatype|ID
		public Alternatives ele0000000110Alternatives() { return c0000000110Alternatives; }

		// "mykeyword1"|STRING|NestedDatatype|Datatype
		public Alternatives ele00000001100Alternatives() { return c00000001100Alternatives; }

		// "mykeyword1"|STRING|NestedDatatype
		public Alternatives ele000000011000Alternatives() { return c000000011000Alternatives; }

		// "mykeyword1"|STRING
		public Alternatives ele0000000110000Alternatives() { return c0000000110000Alternatives; }

		// "mykeyword1"
		public Keyword ele00000001100000KeywordMykeyword1() { return c00000001100000KeywordMykeyword1; }

		// STRING
		public RuleCall ele00000001100001LexerRuleCallSTRING() { return c00000001100001LexerRuleCallSTRING; }

		// NestedDatatype
		public RuleCall ele0000000110001ParserRuleCallNestedDatatype() { return c0000000110001ParserRuleCallNestedDatatype; }

		// Datatype
		public RuleCall ele000000011001ParserRuleCallDatatype() { return c000000011001ParserRuleCallDatatype; }

		// ID
		public RuleCall ele00000001101LexerRuleCallID() { return c00000001101LexerRuleCallID; }

		// "2" value=STRING
		public Group ele0000001Group() { return c0000001Group; }

		// "2"
		public Keyword ele00000010KeywordDigitTwo() { return c00000010KeywordDigitTwo; }

		// value=STRING
		public Assignment ele00000011AssignmentValue() { return c00000011AssignmentValue; }

		// STRING
		public RuleCall ele000000110LexerRuleCallSTRING() { return c000000110LexerRuleCallSTRING; }

		// "2+" multiValue+=STRING
		public Group ele000001Group() { return c000001Group; }

		// "2+"
		public Keyword ele0000010KeywordDigitTwoPlusSign() { return c0000010KeywordDigitTwoPlusSign; }

		// multiValue+=STRING
		public Assignment ele0000011AssignmentMultiValue() { return c0000011AssignmentMultiValue; }

		// STRING
		public RuleCall ele00000110LexerRuleCallSTRING() { return c00000110LexerRuleCallSTRING; }

		// "3" value=Datatype
		public Group ele00001Group() { return c00001Group; }

		// "3"
		public Keyword ele000010KeywordDigitThree() { return c000010KeywordDigitThree; }

		// value=Datatype
		public Assignment ele000011AssignmentValue() { return c000011AssignmentValue; }

		// Datatype
		public RuleCall ele0000110ParserRuleCallDatatype() { return c0000110ParserRuleCallDatatype; }

		// "3+" multiValue+=Datatype
		public Group ele0001Group() { return c0001Group; }

		// "3+"
		public Keyword ele00010KeywordDigitThreePlusSign() { return c00010KeywordDigitThreePlusSign; }

		// multiValue+=Datatype
		public Assignment ele00011AssignmentMultiValue() { return c00011AssignmentMultiValue; }

		// Datatype
		public RuleCall ele000110ParserRuleCallDatatype() { return c000110ParserRuleCallDatatype; }

		// "4" value=NestedDatatype
		public Group ele001Group() { return c001Group; }

		// "4"
		public Keyword ele0010KeywordDigitFour() { return c0010KeywordDigitFour; }

		// value=NestedDatatype
		public Assignment ele0011AssignmentValue() { return c0011AssignmentValue; }

		// NestedDatatype
		public RuleCall ele00110ParserRuleCallNestedDatatype() { return c00110ParserRuleCallNestedDatatype; }

		// "4+" multiValue+=NestedDatatype
		public Group ele01Group() { return c01Group; }

		// "4+"
		public Keyword ele010KeywordDigitFourPlusSign() { return c010KeywordDigitFourPlusSign; }

		// multiValue+=NestedDatatype
		public Assignment ele011AssignmentMultiValue() { return c011AssignmentMultiValue; }

		// NestedDatatype
		public RuleCall ele0110ParserRuleCallNestedDatatype() { return c0110ParserRuleCallNestedDatatype; }

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
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0Group.eContents().get(0);
		private final Keyword c01KeywordHyphenMinus = (Keyword)c0Group.eContents().get(1);
		private final RuleCall c1LexerRuleCallID = (RuleCall)cGroup.eContents().get(1);
		
		// Datatype returns EString:   ID "-" ID;
		public ParserRule getRule() { return rule; }

		// ID "-" ID
		public Group eleGroup() { return cGroup; }

		// ID "-"
		public Group ele0Group() { return c0Group; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// "-"
		public Keyword ele01KeywordHyphenMinus() { return c01KeywordHyphenMinus; }

		// ID
		public RuleCall ele1LexerRuleCallID() { return c1LexerRuleCallID; }
	}

	public class NestedDatatypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NestedDatatype");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0Group.eContents().get(0);
		private final Keyword c01KeywordPlusSign = (Keyword)c0Group.eContents().get(1);
		private final RuleCall c1ParserRuleCallDatatype = (RuleCall)cGroup.eContents().get(1);
		
		// NestedDatatype returns EString:   ID "+" Datatype?;
		public ParserRule getRule() { return rule; }

		// ID "+" Datatype?
		public Group eleGroup() { return cGroup; }

		// ID "+"
		public Group ele0Group() { return c0Group; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// "+"
		public Keyword ele01KeywordPlusSign() { return c01KeywordPlusSign; }

		// Datatype?
		public RuleCall ele1ParserRuleCallDatatype() { return c1ParserRuleCallDatatype; }
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
	
	private ModelElements pModel;
	private DatatypeElements pDatatype;
	private NestedDatatypeElements pNestedDatatype;
	private ChildElements pChild;
	private Child1Elements pChild1;
	private Child2Elements pChild2;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public Bug250313GrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Model:   "1"? value=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"1+" multiValue+=("mykeyword1"|STRING|NestedDatatype|Datatype|ID)|"2" value=STRING|"2+" multiValue+=STRING|"3" value=Datatype|"3+" multiValue+=Datatype|"4" value=NestedDatatype|"4+" multiValue+=NestedDatatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Datatype returns EString:   ID "-" ID;
	public DatatypeElements prDatatype() {
		return (pDatatype != null) ? pDatatype : (pDatatype = new DatatypeElements());
	} 

	// NestedDatatype returns EString:   ID "+" Datatype?;
	public NestedDatatypeElements prNestedDatatype() {
		return (pNestedDatatype != null) ? pNestedDatatype : (pNestedDatatype = new NestedDatatypeElements());
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
