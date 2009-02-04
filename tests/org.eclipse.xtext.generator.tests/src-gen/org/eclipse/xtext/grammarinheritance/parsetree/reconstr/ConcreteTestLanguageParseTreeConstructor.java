/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;


public class ConcreteTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("RootRule") && (s = new RootRule_RuleCall_ConcreteParserRule(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ConcreteParserRule") && (s = new ConcreteParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AType") && (s = new InheritedParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AModel") && (s = new AbstractCallOverridenParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AType") && (s = new OverridableParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AModel") && (s = new AbstractCallExtendedParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AType") && (s = new ExtendableParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule RootRule ****************
 *
 * RootRule : ConcreteParserRule ;
 *
 **/


// ConcreteParserRule
protected class RootRule_RuleCall_ConcreteParserRule extends RuleCallToken {
	
	public RootRule_RuleCall_ConcreteParserRule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule().eleParserRuleCallConcreteParserRule();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(ConcreteParserRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ConcreteParserRule")) return null;
		return new ConcreteParserRule_Group(current, this).firstSolution();
	}
}

/************ end Rule RootRule ****************/


/************ begin Rule ConcreteParserRule ****************
 *
 * ConcreteParserRule : "model" magicNumber = REAL ":" ( elements += InheritedParserRule ) * ;
 *
 **/


// "model" magicNumber = REAL ":" ( elements += InheritedParserRule ) *
protected class ConcreteParserRule_Group extends GroupToken {
	
	public ConcreteParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ConcreteParserRule_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ConcreteParserRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "model" magicNumber = REAL ":"
protected class ConcreteParserRule_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ConcreteParserRule_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ConcreteParserRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "model" magicNumber = REAL
protected class ConcreteParserRule_0_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ConcreteParserRule_0_0_1_Assignment_magicNumber(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ConcreteParserRule_0_0_0_Keyword_model(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "model"
protected class ConcreteParserRule_0_0_0_Keyword_model extends KeywordToken  {
	
	public ConcreteParserRule_0_0_0_Keyword_model(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele000KeywordModel();
	}	
}

// magicNumber = REAL
protected class ConcreteParserRule_0_0_1_Assignment_magicNumber extends AssignmentToken  {
	
	public ConcreteParserRule_0_0_1_Assignment_magicNumber(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele001AssignmentMagicNumber();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("magicNumber",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("magicNumber");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele0010LexerRuleCallREAL();
			return new Solution(obj);
		}
		return null;
	}
}


// ":"
protected class ConcreteParserRule_0_1_Keyword extends KeywordToken  {
	
	public ConcreteParserRule_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele01KeywordColon();
	}	
}


// ( elements += InheritedParserRule ) *
protected class ConcreteParserRule_1_Assignment_elements extends AssignmentToken  {
	
	public ConcreteParserRule_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule().ele1AssignmentElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AType")) {
				Solution s = new InheritedParserRule_Group(param, this).firstSolution();
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


/************ end Rule ConcreteParserRule ****************/


/************ begin Rule InheritedParserRule ****************
 *
 * InheritedParserRule returns AType : "element" name = ID ;
 *
 **/


// "element" name = ID
protected class InheritedParserRule_Group extends GroupToken {
	
	public InheritedParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new InheritedParserRule_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritedParserRule_0_Keyword_element(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "element"
protected class InheritedParserRule_0_Keyword_element extends KeywordToken  {
	
	public InheritedParserRule_0_Keyword_element(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().ele0KeywordElement();
	}	
}

// name = ID
protected class InheritedParserRule_1_Assignment_name extends AssignmentToken  {
	
	public InheritedParserRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().ele1AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule InheritedParserRule ****************/


/************ begin Rule AbstractCallOverridenParserRule ****************
 *
 * AbstractCallOverridenParserRule returns AModel : "overridemodel" ( elements += OverridableParserRule ) * ;
 *
 **/


// "overridemodel" ( elements += OverridableParserRule ) *
protected class AbstractCallOverridenParserRule_Group extends GroupToken {
	
	public AbstractCallOverridenParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallOverridenParserRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new AbstractCallOverridenParserRule_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractCallOverridenParserRule_0_Keyword_overridemodel(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overridemodel"
protected class AbstractCallOverridenParserRule_0_Keyword_overridemodel extends KeywordToken  {
	
	public AbstractCallOverridenParserRule_0_Keyword_overridemodel(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallOverridenParserRule().ele0KeywordOverridemodel();
	}	
}

// ( elements += OverridableParserRule ) *
protected class AbstractCallOverridenParserRule_1_Assignment_elements extends AssignmentToken  {
	
	public AbstractCallOverridenParserRule_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallOverridenParserRule().ele1AssignmentElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AType")) {
				Solution s = new OverridableParserRule_Group(param, this).firstSolution();
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


/************ end Rule AbstractCallOverridenParserRule ****************/


/************ begin Rule OverridableParserRule ****************
 *
 * OverridableParserRule returns AType : "element" name = ID ;
 *
 **/


// "element" name = ID
protected class OverridableParserRule_Group extends GroupToken {
	
	public OverridableParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridableParserRule_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridableParserRule_0_Keyword_element(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "element"
protected class OverridableParserRule_0_Keyword_element extends KeywordToken  {
	
	public OverridableParserRule_0_Keyword_element(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().ele0KeywordElement();
	}	
}

// name = ID
protected class OverridableParserRule_1_Assignment_name extends AssignmentToken  {
	
	public OverridableParserRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().ele1AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = AbstractTestLanguageGrammarAccess.INSTANCE.prOverridableParserRule().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule OverridableParserRule ****************/


/************ begin Rule AbstractCallExtendedParserRule ****************
 *
 * AbstractCallExtendedParserRule returns AModel : "extendedmodel" ( elements += ExtendableParserRule ) * ;
 *
 **/


// "extendedmodel" ( elements += ExtendableParserRule ) *
protected class AbstractCallExtendedParserRule_Group extends GroupToken {
	
	public AbstractCallExtendedParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallExtendedParserRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new AbstractCallExtendedParserRule_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractCallExtendedParserRule_0_Keyword_extendedmodel(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "extendedmodel"
protected class AbstractCallExtendedParserRule_0_Keyword_extendedmodel extends KeywordToken  {
	
	public AbstractCallExtendedParserRule_0_Keyword_extendedmodel(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallExtendedParserRule().ele0KeywordExtendedmodel();
	}	
}

// ( elements += ExtendableParserRule ) *
protected class AbstractCallExtendedParserRule_1_Assignment_elements extends AssignmentToken  {
	
	public AbstractCallExtendedParserRule_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prAbstractCallExtendedParserRule().ele1AssignmentElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AType")) {
				Solution s = new ExtendableParserRule_Group(param, this).firstSolution();
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


/************ end Rule AbstractCallExtendedParserRule ****************/


/************ begin Rule ExtendableParserRule ****************
 *
 * ExtendableParserRule returns AType : "element" name = ID ;
 *
 **/


// "element" name = ID
protected class ExtendableParserRule_Group extends GroupToken {
	
	public ExtendableParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ExtendableParserRule_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ExtendableParserRule_0_Keyword_element(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "element"
protected class ExtendableParserRule_0_Keyword_element extends KeywordToken  {
	
	public ExtendableParserRule_0_Keyword_element(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().ele0KeywordElement();
	}	
}

// name = ID
protected class ExtendableParserRule_1_Assignment_name extends AssignmentToken  {
	
	public ExtendableParserRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().ele1AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = AbstractTestLanguageGrammarAccess.INSTANCE.prExtendableParserRule().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule ExtendableParserRule ****************/

}
