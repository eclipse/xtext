/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.datatyperules.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class DatatypeRulesTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class CompositeModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompositeModel");
		private final Assignment cAssignmentModel = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallModel = (RuleCall)cAssignmentModel.eContents().get(0);
		
		// CompositeModel:   (model+=Model)+;
		public ParserRule getRule() { return rule; }

		// (model+=Model)+
		public Assignment eleAssignmentModel() { return cAssignmentModel; }

		// Model
		public RuleCall ele0ParserRuleCallModel() { return c0ParserRuleCallModel; }
	}

	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Assignment c0000AssignmentId = (Assignment)c000Group.eContents().get(0);
		private final RuleCall c00000ParserRuleCallNestedModelId = (RuleCall)c0000AssignmentId.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Keyword c00010KeywordColon = (Keyword)c0001Group.eContents().get(0);
		private final Assignment c00011AssignmentValue = (Assignment)c0001Group.eContents().get(1);
		private final RuleCall c000110ParserRuleCallFraction = (RuleCall)c00011AssignmentValue.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Keyword c0010KeywordNumberSign = (Keyword)c001Group.eContents().get(0);
		private final Assignment c0011AssignmentVector = (Assignment)c001Group.eContents().get(1);
		private final RuleCall c00110ParserRuleCallVector = (RuleCall)c0011AssignmentVector.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordPlusSign = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentDots = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110ParserRuleCallDots = (RuleCall)c011AssignmentDots.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// Model:   id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)? ("+" dots=Dots)? ";";
		public ParserRule getRule() { return rule; }

		// id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)? ("+" dots=Dots)? ";"
		public Group eleGroup() { return cGroup; }

		// id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)? ("+" dots=Dots)?
		public Group ele0Group() { return c0Group; }

		// id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)?
		public Group ele00Group() { return c00Group; }

		// id=NestedModelId (":" value=Fraction)?
		public Group ele000Group() { return c000Group; }

		// id=NestedModelId
		public Assignment ele0000AssignmentId() { return c0000AssignmentId; }

		// NestedModelId
		public RuleCall ele00000ParserRuleCallNestedModelId() { return c00000ParserRuleCallNestedModelId; }

		// (":" value=Fraction)?
		public Group ele0001Group() { return c0001Group; }

		// ":"
		public Keyword ele00010KeywordColon() { return c00010KeywordColon; }

		// value=Fraction
		public Assignment ele00011AssignmentValue() { return c00011AssignmentValue; }

		// Fraction
		public RuleCall ele000110ParserRuleCallFraction() { return c000110ParserRuleCallFraction; }

		// ("#" vector=Vector)?
		public Group ele001Group() { return c001Group; }

		// "#"
		public Keyword ele0010KeywordNumberSign() { return c0010KeywordNumberSign; }

		// vector=Vector
		public Assignment ele0011AssignmentVector() { return c0011AssignmentVector; }

		// Vector
		public RuleCall ele00110ParserRuleCallVector() { return c00110ParserRuleCallVector; }

		// ("+" dots=Dots)?
		public Group ele01Group() { return c01Group; }

		// "+"
		public Keyword ele010KeywordPlusSign() { return c010KeywordPlusSign; }

		// dots=Dots
		public Assignment ele011AssignmentDots() { return c011AssignmentDots; }

		// Dots
		public RuleCall ele0110ParserRuleCallDots() { return c0110ParserRuleCallDots; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class ModelIdElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModelId");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0Group.eContents().get(0);
		private final Keyword c01KeywordFullStop = (Keyword)c0Group.eContents().get(1);
		private final RuleCall c1LexerRuleCallID = (RuleCall)cGroup.eContents().get(1);
		
		// ModelId returns EString:   ID "." ID;
		public ParserRule getRule() { return rule; }

		// ID "." ID
		public Group eleGroup() { return cGroup; }

		// ID "."
		public Group ele0Group() { return c0Group; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// "."
		public Keyword ele01KeywordFullStop() { return c01KeywordFullStop; }

		// ID
		public RuleCall ele1LexerRuleCallID() { return c1LexerRuleCallID; }
	}

	public class NestedModelIdElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NestedModelId");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final RuleCall c00ParserRuleCallModelId = (RuleCall)c0Group.eContents().get(0);
		private final Keyword c01KeywordFullStop = (Keyword)c0Group.eContents().get(1);
		private final RuleCall c1ParserRuleCallModelId = (RuleCall)cGroup.eContents().get(1);
		
		// NestedModelId returns EString:   ModelId "." ModelId;
		public ParserRule getRule() { return rule; }

		// ModelId "." ModelId
		public Group eleGroup() { return cGroup; }

		// ModelId "."
		public Group ele0Group() { return c0Group; }

		// ModelId
		public RuleCall ele00ParserRuleCallModelId() { return c00ParserRuleCallModelId; }

		// "."
		public Keyword ele01KeywordFullStop() { return c01KeywordFullStop; }

		// ModelId
		public RuleCall ele1ParserRuleCallModelId() { return c1ParserRuleCallModelId; }
	}

	public class FractionElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Fraction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallINT = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordSolidus = (Keyword)c1Group.eContents().get(0);
		private final RuleCall c11LexerRuleCallINT = (RuleCall)c1Group.eContents().get(1);
		
		// Fraction returns EBigDecimal:   INT ("/" INT)?;
		public ParserRule getRule() { return rule; }

		// INT ("/" INT)?
		public Group eleGroup() { return cGroup; }

		// INT
		public RuleCall ele0LexerRuleCallINT() { return c0LexerRuleCallINT; }

		// ("/" INT)?
		public Group ele1Group() { return c1Group; }

		// "/"
		public Keyword ele10KeywordSolidus() { return c10KeywordSolidus; }

		// INT
		public RuleCall ele11LexerRuleCallINT() { return c11LexerRuleCallINT; }
	}

	public class VectorElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Vector");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordLeftParenthesis = (Keyword)c00Group.eContents().get(0);
		private final RuleCall c001LexerRuleCallINT = (RuleCall)c00Group.eContents().get(1);
		private final RuleCall c01LexerRuleCallINT = (RuleCall)c0Group.eContents().get(1);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Vector returns EString:   "(" INT INT ")";
		public ParserRule getRule() { return rule; }

		// "(" INT INT ")"
		public Group eleGroup() { return cGroup; }

		// "(" INT INT
		public Group ele0Group() { return c0Group; }

		// "(" INT
		public Group ele00Group() { return c00Group; }

		// "("
		public Keyword ele000KeywordLeftParenthesis() { return c000KeywordLeftParenthesis; }

		// INT
		public RuleCall ele001LexerRuleCallINT() { return c001LexerRuleCallINT; }

		// INT
		public RuleCall ele01LexerRuleCallINT() { return c01LexerRuleCallINT; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class DotsElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Dots");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group c0Group = (Group)cAlternatives.eContents().get(0);
		private final Keyword c00KeywordFullStop = (Keyword)c0Group.eContents().get(0);
		private final Keyword c01KeywordFullStop = (Keyword)c0Group.eContents().get(1);
		private final Keyword c1KeywordFullStopFullStop = (Keyword)cAlternatives.eContents().get(1);
		
		// Dots returns EString:   "." "."|"..";
		public ParserRule getRule() { return rule; }

		// "." "."|".."
		public Alternatives eleAlternatives() { return cAlternatives; }

		// "." "."
		public Group ele0Group() { return c0Group; }

		// "."
		public Keyword ele00KeywordFullStop() { return c00KeywordFullStop; }

		// "."
		public Keyword ele01KeywordFullStop() { return c01KeywordFullStop; }

		// ".."
		public Keyword ele1KeywordFullStopFullStop() { return c1KeywordFullStopFullStop; }
	}
	
	private CompositeModelElements pCompositeModel;
	private ModelElements pModel;
	private ModelIdElements pModelId;
	private NestedModelIdElements pNestedModelId;
	private FractionElements pFraction;
	private VectorElements pVector;
	private DotsElements pDots;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public DatatypeRulesTestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// CompositeModel:   (model+=Model)+;
	public CompositeModelElements prCompositeModel() {
		return (pCompositeModel != null) ? pCompositeModel : (pCompositeModel = new CompositeModelElements());
	} 

	// Model:   id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)? ("+" dots=Dots)? ";";
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// ModelId returns EString:   ID "." ID;
	public ModelIdElements prModelId() {
		return (pModelId != null) ? pModelId : (pModelId = new ModelIdElements());
	} 

	// NestedModelId returns EString:   ModelId "." ModelId;
	public NestedModelIdElements prNestedModelId() {
		return (pNestedModelId != null) ? pNestedModelId : (pNestedModelId = new NestedModelIdElements());
	} 

	// Fraction returns EBigDecimal:   INT ("/" INT)?;
	public FractionElements prFraction() {
		return (pFraction != null) ? pFraction : (pFraction = new FractionElements());
	} 

	// Vector returns EString:   "(" INT INT ")";
	public VectorElements prVector() {
		return (pVector != null) ? pVector : (pVector = new VectorElements());
	} 

	// Dots returns EString:   "." "."|"..";
	public DotsElements prDots() {
		return (pDots != null) ? pDots : (pDots = new DotsElements());
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
