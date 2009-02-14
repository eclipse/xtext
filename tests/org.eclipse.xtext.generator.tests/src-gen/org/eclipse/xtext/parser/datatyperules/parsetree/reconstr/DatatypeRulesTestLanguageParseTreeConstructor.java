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
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class DatatypeRulesTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private DatatypeRulesTestLanguageGrammarAccess grammarAccess;
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("CompositeModel") && (s = new CompositeModel_Assignment_model(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Model") && (s = new Model_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule CompositeModel ****************
 *
 * CompositeModel:   (model+=Model)+;
 *
 **/


// (model+=Model)+
protected class CompositeModel_Assignment_model extends AssignmentToken  {
	
	public CompositeModel_Assignment_model(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prCompositeModel().eleAssignmentModel();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("model",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("model");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Model")) {
				Solution s = new Model_Group(param, this).firstSolution();
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

/************ end Rule CompositeModel ****************/


/************ begin Rule Model ****************
 *
 * Model:   id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)? ("+" dots=Dots)? ";";
 *
 **/


// id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)? ("+" dots=Dots)? ";"
protected class Model_Group extends GroupToken {
	
	public Model_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prModel().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)? ("+" dots=Dots)?
protected class Model_0_Group extends GroupToken {
	
	public Model_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prModel().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// id=NestedModelId (":" value=Fraction)? ("#" vector=Vector)?
protected class Model_0_0_Group extends GroupToken {
	
	public Model_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prModel().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// id=NestedModelId (":" value=Fraction)?
protected class Model_0_0_0_Group extends GroupToken {
	
	public Model_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prModel().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_0_0_0_Assignment_id(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// id=NestedModelId
protected class Model_0_0_0_0_Assignment_id extends AssignmentToken  {
	
	public Model_0_0_0_0_Assignment_id(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prModel().ele0000AssignmentId();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("id",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("id");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = grammarAccess.prModel().ele00000ParserRuleCallNestedModelId();
			return new Solution(obj);
		}

		return null;
	}
}

// (":" value=Fraction)?
protected class Model_0_0_0_1_Group extends GroupToken {
	
	public Model_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prModel().ele0001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_0_0_1_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ":"
protected class Model_0_0_0_1_0_Keyword extends KeywordToken  {
	
	public Model_0_0_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prModel().ele00010KeywordColon();
	}	
}

// value=Fraction
protected class Model_0_0_0_1_1_Assignment_value extends AssignmentToken  {
	
	public Model_0_0_0_1_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prModel().ele00011AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = grammarAccess.prModel().ele000110ParserRuleCallFraction();
			return new Solution(obj);
		}

		return null;
	}
}



// ("#" vector=Vector)?
protected class Model_0_0_1_Group extends GroupToken {
	
	public Model_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prModel().ele001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_0_1_1_Assignment_vector(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#"
protected class Model_0_0_1_0_Keyword extends KeywordToken  {
	
	public Model_0_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prModel().ele0010KeywordNumberSign();
	}	
}

// vector=Vector
protected class Model_0_0_1_1_Assignment_vector extends AssignmentToken  {
	
	public Model_0_0_1_1_Assignment_vector(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prModel().ele0011AssignmentVector();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("vector",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("vector");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = grammarAccess.prModel().ele00110ParserRuleCallVector();
			return new Solution(obj);
		}

		return null;
	}
}



// ("+" dots=Dots)?
protected class Model_0_1_Group extends GroupToken {
	
	public Model_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prModel().ele01Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_1_1_Assignment_dots(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "+"
protected class Model_0_1_0_Keyword extends KeywordToken  {
	
	public Model_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prModel().ele010KeywordPlusSign();
	}	
}

// dots=Dots
protected class Model_0_1_1_Assignment_dots extends AssignmentToken  {
	
	public Model_0_1_1_Assignment_dots(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prModel().ele011AssignmentDots();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("dots",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("dots");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = grammarAccess.prModel().ele0110ParserRuleCallDots();
			return new Solution(obj);
		}

		return null;
	}
}



// ";"
protected class Model_1_Keyword extends KeywordToken  {
	
	public Model_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prModel().ele1KeywordSemicolon();
	}	
}


/************ end Rule Model ****************/






}
