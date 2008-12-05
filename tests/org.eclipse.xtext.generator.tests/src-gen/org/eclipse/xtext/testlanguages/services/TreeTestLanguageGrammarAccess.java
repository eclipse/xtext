/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class TreeTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentChildren;
		private RuleCall c0ParserRuleCallNode;
		
		// Model : ( children += Node ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( children += Node ) *
		public Assignment eleAssignmentChildren() {
			return (cAssignmentChildren != null) ? cAssignmentChildren : (cAssignmentChildren = (Assignment)getRule().eContents().get(0)); 
		}

		// Node
		public RuleCall ele0ParserRuleCallNode() {
			return (c0ParserRuleCallNode != null) ? c0ParserRuleCallNode : (c0ParserRuleCallNode = (RuleCall)eleAssignmentChildren().eContents().get(0)); 
		}
	}

	public class NodeElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Group c00000Group;
		private Assignment c000000AssignmentName;
		private RuleCall c0000000LexerRuleCallID;
		private Keyword c000001Keyword;
		private Assignment c00001AssignmentAttrib;
		private RuleCall c000010LexerRuleCallSTRING;
		private Keyword c0001Keyword;
		private Keyword c001Keyword;
		private Assignment c01AssignmentChildren;
		private RuleCall c010ParserRuleCallNode;
		private Keyword c1Keyword;
		
		// Node : name = ID '(' attrib = STRING ')' '{' ( children += Node ) * '};' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// name = ID '(' attrib = STRING ')' '{' ( children += Node ) * '};'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// name = ID '(' attrib = STRING ')' '{' ( children += Node ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// name = ID '(' attrib = STRING ')' '{'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// name = ID '(' attrib = STRING ')'
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// name = ID '(' attrib = STRING
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// name = ID '('
		public Group ele00000Group() {
			return (c00000Group != null) ? c00000Group : (c00000Group = (Group)ele0000Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele000000AssignmentName() {
			return (c000000AssignmentName != null) ? c000000AssignmentName : (c000000AssignmentName = (Assignment)ele00000Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele0000000LexerRuleCallID() {
			return (c0000000LexerRuleCallID != null) ? c0000000LexerRuleCallID : (c0000000LexerRuleCallID = (RuleCall)ele000000AssignmentName().eContents().get(0)); 
		}

		// '('
		public Keyword ele000001Keyword() {
			return (c000001Keyword != null) ? c000001Keyword : (c000001Keyword = (Keyword)ele00000Group().eContents().get(1)); 
		}

		// attrib = STRING
		public Assignment ele00001AssignmentAttrib() {
			return (c00001AssignmentAttrib != null) ? c00001AssignmentAttrib : (c00001AssignmentAttrib = (Assignment)ele0000Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele000010LexerRuleCallSTRING() {
			return (c000010LexerRuleCallSTRING != null) ? c000010LexerRuleCallSTRING : (c000010LexerRuleCallSTRING = (RuleCall)ele00001AssignmentAttrib().eContents().get(0)); 
		}

		// ')'
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// '{'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// ( children += Node ) *
		public Assignment ele01AssignmentChildren() {
			return (c01AssignmentChildren != null) ? c01AssignmentChildren : (c01AssignmentChildren = (Assignment)ele0Group().eContents().get(1)); 
		}

		// Node
		public RuleCall ele010ParserRuleCallNode() {
			return (c010ParserRuleCallNode != null) ? c010ParserRuleCallNode : (c010ParserRuleCallNode = (RuleCall)ele01AssignmentChildren().eContents().get(0)); 
		}

		// '};'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}
	
	public final static TreeTestLanguageGrammarAccess INSTANCE = new TreeTestLanguageGrammarAccess();

	private static final String TREETESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static NodeElements pNode;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(TreeTestLanguageGrammarAccess.class.getClassLoader(),TREETESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Model : ( children += Node ) * ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Node : name = ID '(' attrib = STRING ')' '{' ( children += Node ) * '};' ;
	public NodeElements prNode() {
		return (pNode != null) ? pNode : (pNode = new NodeElements());
	} 
}
