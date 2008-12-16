/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;


public class DatatypeRulesTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		if(object == null) throw new IllegalArgumentException("The to-be-serialialized model is null");
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;

		if(inst.isInstanceOf("CompositeModel") && (s = new CompositeModel_Assignment_model(inst, null).firstSolution()) != null) return s;


		if(inst.isInstanceOf("Model") && (s = new Model_Group(inst, null).firstSolution()) != null) return s;




		return null;
	}
	

/************ begin Rule CompositeModel ****************
 *
 * CompositeModel : ( model += Model ) + ;
 *
 **/


// ( model += Model ) +
protected class CompositeModel_Assignment_model extends AssignmentToken  {
	
	public CompositeModel_Assignment_model(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prCompositeModel().eleAssignmentModel();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("model",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("model");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Model")) {
				Solution s = new Model_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

/************ end Rule CompositeModel ****************/


/************ begin Rule Model ****************
 *
 * Model : id = NestedModelId ( ':' value = Fraction ) ? ';' ;
 *
 **/


// id = NestedModelId ( ':' value = Fraction ) ? ';'
protected class Model_Group extends GroupToken {
	
	public Model_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Model_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// id = NestedModelId ( ':' value = Fraction ) ?
protected class Model_0_Group extends GroupToken {
	
	public Model_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Model_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_0_Assignment_id(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// id = NestedModelId
protected class Model_0_0_Assignment_id extends AssignmentToken  {
	
	public Model_0_0_Assignment_id(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele00AssignmentId();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("id",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("id");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele000ParserRuleCallNestedModelId();
			return new Solution(obj);
		}

		return null;
	}
}

// ( ':' value = Fraction ) ?
protected class Model_0_1_Group extends GroupToken {
	
	public Model_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Model_0_1_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ':'
protected class Model_0_1_0_Keyword extends KeywordToken  {
	
	public Model_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele010KeywordColon();
	}	
}

// value = Fraction
protected class Model_0_1_1_Assignment_value extends AssignmentToken  {
	
	public Model_0_1_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele011AssignmentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele0110ParserRuleCallFraction();
			return new Solution(obj);
		}

		return null;
	}
}



// ';'
protected class Model_1_Keyword extends KeywordToken  {
	
	public Model_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel().ele1KeywordSemicolon();
	}	
}


/************ end Rule Model ****************/




}
