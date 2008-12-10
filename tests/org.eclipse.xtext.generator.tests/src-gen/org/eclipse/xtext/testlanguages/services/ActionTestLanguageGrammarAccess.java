/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class ActionTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentChildren;
		private RuleCall c0ParserRuleCallElement;
		
		// Model : ( children += Element ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( children += Element ) *
		public Assignment eleAssignmentChildren() {
			return (cAssignmentChildren != null) ? cAssignmentChildren : (cAssignmentChildren = (Assignment)getRule().eContents().get(1)); 
		}

		// Element
		public RuleCall ele0ParserRuleCallElement() {
			return (c0ParserRuleCallElement != null) ? c0ParserRuleCallElement : (c0ParserRuleCallElement = (RuleCall)eleAssignmentChildren().eContents().get(0)); 
		}
	}

	public class ElementElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallItem;
		private Group c1Group;
		private Action c10ActionItemitems;
		private Assignment c11AssignmentItems;
		private RuleCall c110ParserRuleCallItem;
		
		// Element returns Type : Item ( { current = Item . items += current } items += Item ) ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// Item ( { current = Item . items += current } items += Item )
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// Item
		public RuleCall ele0ParserRuleCallItem() {
			return (c0ParserRuleCallItem != null) ? c0ParserRuleCallItem : (c0ParserRuleCallItem = (RuleCall)eleGroup().eContents().get(0)); 
		}

		// { current = Item . items += current } items += Item
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// { current = Item . items += current }
		public Action ele10ActionItemitems() {
			return (c10ActionItemitems != null) ? c10ActionItemitems : (c10ActionItemitems = (Action)ele1Group().eContents().get(0)); 
		}

		// items += Item
		public Assignment ele11AssignmentItems() {
			return (c11AssignmentItems != null) ? c11AssignmentItems : (c11AssignmentItems = (Assignment)ele1Group().eContents().get(1)); 
		}

		// Item
		public RuleCall ele110ParserRuleCallItem() {
			return (c110ParserRuleCallItem != null) ? c110ParserRuleCallItem : (c110ParserRuleCallItem = (RuleCall)ele11AssignmentItems().eContents().get(0)); 
		}
	}

	public class ItemElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Action c0ActionThingcontent;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallID;
		
		// Item returns Type : { current = Thing . content = current } name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// { current = Thing . content = current } name = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// { current = Thing . content = current }
		public Action ele0ActionThingcontent() {
			return (c0ActionThingcontent != null) ? c0ActionThingcontent : (c0ActionThingcontent = (Action)eleGroup().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele1AssignmentName() {
			return (c1AssignmentName != null) ? c1AssignmentName : (c1AssignmentName = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentName().eContents().get(0)); 
		}
	}
	
	public final static ActionTestLanguageGrammarAccess INSTANCE = new ActionTestLanguageGrammarAccess();

	private static final String ACTIONTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static ElementElements pElement;
	private static ItemElements pItem;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ActionTestLanguageGrammarAccess.class.getClassLoader(),ACTIONTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Model : ( children += Element ) * ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Element returns Type : Item ( { current = Item . items += current } items += Item ) ;
	public ElementElements prElement() {
		return (pElement != null) ? pElement : (pElement = new ElementElements());
	} 

	// Item returns Type : { current = Thing . content = current } name = ID ;
	public ItemElements prItem() {
		return (pItem != null) ? pItem : (pItem = new ItemElements());
	} 
}
