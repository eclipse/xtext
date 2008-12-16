/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.datatyperules.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class DatatypeRulesTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class CompositeModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Assignment cAssignmentModel = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallModel = (RuleCall)cAssignmentModel.eContents().get(0);
		
		// CompositeModel : ( model += Model ) + ;
		public ParserRule getRule() { return rule; }

		// ( model += Model ) +
		public Assignment eleAssignmentModel() { return cAssignmentModel; }

		// Model
		public RuleCall ele0ParserRuleCallModel() { return c0ParserRuleCallModel; }
	}

	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentId = (Assignment)c0Group.eContents().get(0);
		private final RuleCall c000ParserRuleCallNestedModelId = (RuleCall)c00AssignmentId.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordColon = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentValue = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110ParserRuleCallFraction = (RuleCall)c011AssignmentValue.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// Model : id = NestedModelId ( ':' value = Fraction ) ? ';' ;
		public ParserRule getRule() { return rule; }

		// id = NestedModelId ( ':' value = Fraction ) ? ';'
		public Group eleGroup() { return cGroup; }

		// id = NestedModelId ( ':' value = Fraction ) ?
		public Group ele0Group() { return c0Group; }

		// id = NestedModelId
		public Assignment ele00AssignmentId() { return c00AssignmentId; }

		// NestedModelId
		public RuleCall ele000ParserRuleCallNestedModelId() { return c000ParserRuleCallNestedModelId; }

		// ( ':' value = Fraction ) ?
		public Group ele01Group() { return c01Group; }

		// ':'
		public Keyword ele010KeywordColon() { return c010KeywordColon; }

		// value = Fraction
		public Assignment ele011AssignmentValue() { return c011AssignmentValue; }

		// Fraction
		public RuleCall ele0110ParserRuleCallFraction() { return c0110ParserRuleCallFraction; }

		// ';'
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class ModelIdElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0Group.eContents().get(0);
		private final Keyword c01KeywordFullStop = (Keyword)c0Group.eContents().get(1);
		private final RuleCall c1LexerRuleCallID = (RuleCall)cGroup.eContents().get(1);
		
		// ModelId returns EString : ID '.' ID ;
		public ParserRule getRule() { return rule; }

		// ID '.' ID
		public Group eleGroup() { return cGroup; }

		// ID '.'
		public Group ele0Group() { return c0Group; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// '.'
		public Keyword ele01KeywordFullStop() { return c01KeywordFullStop; }

		// ID
		public RuleCall ele1LexerRuleCallID() { return c1LexerRuleCallID; }
	}

	public class NestedModelIdElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final RuleCall c00ParserRuleCallModelId = (RuleCall)c0Group.eContents().get(0);
		private final Keyword c01KeywordFullStop = (Keyword)c0Group.eContents().get(1);
		private final RuleCall c1ParserRuleCallModelId = (RuleCall)cGroup.eContents().get(1);
		
		// NestedModelId returns EString : ModelId '.' ModelId ;
		public ParserRule getRule() { return rule; }

		// ModelId '.' ModelId
		public Group eleGroup() { return cGroup; }

		// ModelId '.'
		public Group ele0Group() { return c0Group; }

		// ModelId
		public RuleCall ele00ParserRuleCallModelId() { return c00ParserRuleCallModelId; }

		// '.'
		public Keyword ele01KeywordFullStop() { return c01KeywordFullStop; }

		// ModelId
		public RuleCall ele1ParserRuleCallModelId() { return c1ParserRuleCallModelId; }
	}

	public class FractionElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallINT = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordSolidus = (Keyword)c1Group.eContents().get(0);
		private final RuleCall c11LexerRuleCallINT = (RuleCall)c1Group.eContents().get(1);
		
		// Fraction returns EBigDecimal : INT ( '/' INT ) ? ;
		public ParserRule getRule() { return rule; }

		// INT ( '/' INT ) ?
		public Group eleGroup() { return cGroup; }

		// INT
		public RuleCall ele0LexerRuleCallINT() { return c0LexerRuleCallINT; }

		// ( '/' INT ) ?
		public Group ele1Group() { return c1Group; }

		// '/'
		public Keyword ele10KeywordSolidus() { return c10KeywordSolidus; }

		// INT
		public RuleCall ele11LexerRuleCallINT() { return c11LexerRuleCallINT; }
	}
	
	public final static DatatypeRulesTestLanguageGrammarAccess INSTANCE = new DatatypeRulesTestLanguageGrammarAccess();

	private static final String DATATYPERULESTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static CompositeModelElements pCompositeModel;
	private static ModelElements pModel;
	private static ModelIdElements pModelId;
	private static NestedModelIdElements pNestedModelId;
	private static FractionElements pFraction;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(DatatypeRulesTestLanguageGrammarAccess.class.getClassLoader(),DATATYPERULESTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// CompositeModel : ( model += Model ) + ;
	public CompositeModelElements prCompositeModel() {
		return (pCompositeModel != null) ? pCompositeModel : (pCompositeModel = new CompositeModelElements());
	} 

	// Model : id = NestedModelId ( ':' value = Fraction ) ? ';' ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// ModelId returns EString : ID '.' ID ;
	public ModelIdElements prModelId() {
		return (pModelId != null) ? pModelId : (pModelId = new ModelIdElements());
	} 

	// NestedModelId returns EString : ModelId '.' ModelId ;
	public NestedModelIdElements prNestedModelId() {
		return (pNestedModelId != null) ? pNestedModelId : (pNestedModelId = new NestedModelIdElements());
	} 

	// Fraction returns EBigDecimal : INT ( '/' INT ) ? ;
	public FractionElements prFraction() {
		return (pFraction != null) ? pFraction : (pFraction = new FractionElements());
	} 
}
