/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class ActionTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Assignment cAssignmentChildren = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallElement = (RuleCall)cAssignmentChildren.eContents().get(0);
		
		// Model:   (children+=Element)*;
		public ParserRule getRule() { return rule; }

		// (children+=Element)*
		public Assignment eleAssignmentChildren() { return cAssignmentChildren; }

		// Element
		public RuleCall ele0ParserRuleCallElement() { return c0ParserRuleCallElement; }
	}

	public class ElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Element");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallItem = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionItemitems = (Action)c1Group.eContents().get(0);
		private final Assignment c11AssignmentItems = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallItem = (RuleCall)c11AssignmentItems.eContents().get(0);
		
		// Element returns Type:   Item ({current=Item.items+=current} items+=Item);
		public ParserRule getRule() { return rule; }

		// Item ({current=Item.items+=current} items+=Item)
		public Group eleGroup() { return cGroup; }

		// Item
		public RuleCall ele0ParserRuleCallItem() { return c0ParserRuleCallItem; }

		// {current=Item.items+=current} items+=Item
		public Group ele1Group() { return c1Group; }

		// {current=Item.items+=current}
		public Action ele10ActionItemitems() { return c10ActionItemitems; }

		// items+=Item
		public Assignment ele11AssignmentItems() { return c11AssignmentItems; }

		// Item
		public RuleCall ele110ParserRuleCallItem() { return c110ParserRuleCallItem; }
	}

	public class ItemElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Item");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action c0ActionThingcontent = (Action)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// Item returns Type:   {current=Thing.content=current} name=ID;
		public ParserRule getRule() { return rule; }

		// {current=Thing.content=current} name=ID
		public Group eleGroup() { return cGroup; }

		// {current=Thing.content=current}
		public Action ele0ActionThingcontent() { return c0ActionThingcontent; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}
	
	public final static ActionTestLanguageGrammarAccess INSTANCE = new ActionTestLanguageGrammarAccess();

	private static final String ACTIONTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static ElementElements pElement;
	private static ItemElements pItem;
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
			GRAMMAR = (Grammar) loadGrammarFile(ActionTestLanguageGrammarAccess.class.getClassLoader(),ACTIONTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// Model:   (children+=Element)*;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Element returns Type:   Item ({current=Item.items+=current} items+=Item);
	public ElementElements prElement() {
		return (pElement != null) ? pElement : (pElement = new ElementElements());
	} 

	// Item returns Type:   {current=Thing.content=current} name=ID;
	public ItemElements prItem() {
		return (pItem != null) ? pItem : (pItem = new ItemElements());
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
