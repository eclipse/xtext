/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class ActionTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private ActionTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf(grammarAccess.prModel().getRule().getType().getType()) && (s = new Model_Assignment_children(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prElement().getRule().getType().getType()) && (s = new Element_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prItem().getRule().getType().getType()) && (s = new Item_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Model ****************
 *
 * Model:   (children+=Element)*;
 *
 **/


// (children+=Element)*
protected class Model_Assignment_children extends AssignmentToken  {
	
	public Model_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prModel().eleAssignmentChildren();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("children",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prElement().getRule().getType().getType())) {
				Solution s = new Element_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

/************ end Rule Model ****************/


/************ begin Rule Element ****************
 *
 * Element returns Type:   Item ({current=Item.items+=current} items+=Item);
 *
 **/


// Item ({current=Item.items+=current} items+=Item)
protected class Element_Group extends GroupToken {
	
	public Element_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prElement().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Element_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Element_0_RuleCall_Item(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// Item
protected class Element_0_RuleCall_Item extends RuleCallToken {
	
	public Element_0_RuleCall_Item(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prElement().ele0ParserRuleCallItem();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Item_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prItem().getRule().getType().getType())) return null;
		return new Item_Group(current, this).firstSolution();
	}
}

// {current=Item.items+=current} items+=Item
protected class Element_1_Group extends GroupToken {
	
	public Element_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prElement().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Element_1_1_Assignment_items(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Element_1_0_Action_Item_items(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// {current=Item.items+=current}
protected class Element_1_0_Action_Item_items extends ActionToken  {

	public Element_1_0_Action_Item_items(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.prElement().ele10ActionItemitems();
	}
	
	@Override
	protected Solution createSolution() {
		if(!current.isInstanceOf(grammarAccess.prElement().ele10ActionItemitems().getTypeName().getType())) return null;
		Object val = current.getConsumable("items", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("items")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// items+=Item
protected class Element_1_1_Assignment_items extends AssignmentToken  {
	
	public Element_1_1_Assignment_items(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prElement().ele11AssignmentItems();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("items",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("items");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prItem().getRule().getType().getType())) {
				Solution s = new Item_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



/************ end Rule Element ****************/


/************ begin Rule Item ****************
 *
 * Item returns Type:   {current=Thing.content=current} name=ID;
 *
 **/


// {current=Thing.content=current} name=ID
protected class Item_Group extends GroupToken {
	
	public Item_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prItem().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Item_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Item_0_Action_Thing_content(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// {current=Thing.content=current}
protected class Item_0_Action_Thing_content extends ActionToken  {

	public Item_0_Action_Thing_content(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.prItem().ele0ActionThingcontent();
	}
	
	@Override
	protected Solution createSolution() {
		if(!current.isInstanceOf(grammarAccess.prItem().ele0ActionThingcontent().getTypeName().getType())) return null;
		Object val = current.getConsumable("content", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("content")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// name=ID
protected class Item_1_Assignment_name extends AssignmentToken  {
	
	public Item_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prItem().ele1AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prItem().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Item ****************/

}
