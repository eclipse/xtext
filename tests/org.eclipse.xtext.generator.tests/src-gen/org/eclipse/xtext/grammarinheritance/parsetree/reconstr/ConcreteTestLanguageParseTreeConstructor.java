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

	public IAbstractToken serialize(EObject object) {
		if(object == null) throw new IllegalArgumentException("The to-be-serialialized model is null");
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;

		if(inst.isInstanceOf("ConcreteParserRule") && (s = new ConcreteParserRule_Group(inst, null).firstSolution()) != null) return s;


		if(inst.isInstanceOf("AType") && (s = new InheritedParserRule_Group(inst, null).firstSolution()) != null) return s;

		return null;
	}
	

/************ begin Rule ConcreteParserRule ****************
 *
 * ConcreteParserRule : 'model' magicNumber = REAL ':' ( elements += InheritedParserRule ) * ;
 *
 **/


// 'model' magicNumber = REAL ':' ( elements += InheritedParserRule ) *
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
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'model' magicNumber = REAL ':'
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
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'model' magicNumber = REAL
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
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'model'
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


// ':'
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
 * InheritedParserRule returns AType : 'element' name = ID ;
 *
 **/


// 'element' name = ID
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
				s1 = s1.getPredecessor().nextSolution(this);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// 'element'
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

}
