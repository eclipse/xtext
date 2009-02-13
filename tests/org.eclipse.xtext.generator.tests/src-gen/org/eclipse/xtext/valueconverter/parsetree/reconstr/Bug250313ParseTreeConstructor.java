/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;


public class Bug250313ParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new Model_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Child") && (s = new Child_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Child1") && (s = new Child1_Assignment_name(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Child2") && (s = new Child2_Assignment_name(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Model ****************
 *
 * Model:   "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING|"$" value=Datatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?;
 *
 **/


// "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING|"$" value=Datatype|"content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?
protected class Model_Alternatives extends AlternativesToken {

	public Model_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_1_Group(current, this) : new Model_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING|"$" value=Datatype
protected class Model_0_Alternatives extends AlternativesToken {

	public Model_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_1_Group(current, this) : new Model_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "#"? value=("mykeyword1"|STRING|Datatype|ID)|"!" value=STRING
protected class Model_0_0_Alternatives extends AlternativesToken {

	public Model_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele00Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_0_1_Group(current, this) : new Model_0_0_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "#"? value=("mykeyword1"|STRING|Datatype|ID)
protected class Model_0_0_0_Group extends GroupToken {
	
	public Model_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_0_0_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "#"?
protected class Model_0_0_0_0_Keyword extends KeywordToken  {
	
	public Model_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele0000KeywordNumberSign();
	}	
}

// value=("mykeyword1"|STRING|Datatype|ID)
protected class Model_0_0_0_1_Assignment_value extends AssignmentToken  {
	
	public Model_0_0_0_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele0001AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if("mykeyword1".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = Bug250313GrammarAccess.INSTANCE.prModel().ele00010000KeywordMykeyword1();
			return new Solution(obj);
		}

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = Bug250313GrammarAccess.INSTANCE.prModel().ele00010001LexerRuleCallSTRING();
			return new Solution(obj);
		}

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = Bug250313GrammarAccess.INSTANCE.prModel().ele0001001ParserRuleCallDatatype();
			return new Solution(obj);
		}

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = Bug250313GrammarAccess.INSTANCE.prModel().ele000101LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "!" value=STRING
protected class Model_0_0_1_Group extends GroupToken {
	
	public Model_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_0_1_1_Assignment_value(current, this).firstSolution();
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

// "!"
protected class Model_0_0_1_0_Keyword extends KeywordToken  {
	
	public Model_0_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele0010KeywordExclamationMark();
	}	
}

// value=STRING
protected class Model_0_0_1_1_Assignment_value extends AssignmentToken  {
	
	public Model_0_0_1_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele0011AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = Bug250313GrammarAccess.INSTANCE.prModel().ele00110LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}



// "$" value=Datatype
protected class Model_0_1_Group extends GroupToken {
	
	public Model_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele01Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_0_1_1_Assignment_value(current, this).firstSolution();
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

// "$"
protected class Model_0_1_0_Keyword extends KeywordToken  {
	
	public Model_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele010Keyword$();
	}	
}

// value=Datatype
protected class Model_0_1_1_Assignment_value extends AssignmentToken  {
	
	public Model_0_1_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele011AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = Bug250313GrammarAccess.INSTANCE.prModel().ele0110ParserRuleCallDatatype();
			return new Solution(obj);
		}

		return null;
	}
}



// "content" children=Child ("ref" ref=([Child1|STRING]|[Child2]))?
protected class Model_1_Group extends GroupToken {
	
	public Model_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "content" children=Child
protected class Model_1_0_Group extends GroupToken {
	
	public Model_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele10Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_1_0_1_Assignment_children(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_1_0_0_Keyword_content(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "content"
protected class Model_1_0_0_Keyword_content extends KeywordToken  {
	
	public Model_1_0_0_Keyword_content(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele100KeywordContent();
	}	
}

// children=Child
protected class Model_1_0_1_Assignment_children extends AssignmentToken  {
	
	public Model_1_0_1_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele101AssignmentChildren();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("children",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Child")) {
				Solution s = new Child_Alternatives(param, this).firstSolution();
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


// ("ref" ref=([Child1|STRING]|[Child2]))?
protected class Model_1_1_Group extends GroupToken {
	
	public Model_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele11Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Model_1_1_1_Assignment_ref(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Model_1_1_0_Keyword_ref(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "ref"
protected class Model_1_1_0_Keyword_ref extends KeywordToken  {
	
	public Model_1_1_0_Keyword_ref(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele110KeywordRef();
	}	
}

// ref=([Child1|STRING]|[Child2])
protected class Model_1_1_1_Assignment_ref extends AssignmentToken  {
	
	public Model_1_1_1_Assignment_ref(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prModel().ele111AssignmentRef();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("ref",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ref");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Child1")) {
				type = AssignmentType.CR;
				element = Bug250313GrammarAccess.INSTANCE.prModel().ele11100CrossReferenceEStringChild1(); 
				return new Solution(obj);
			}
		}
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Child2")) {
				type = AssignmentType.CR;
				element = Bug250313GrammarAccess.INSTANCE.prModel().ele11101CrossReferenceEStringChild2(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}




/************ end Rule Model ****************/



/************ begin Rule Child ****************
 *
 * Child:   Child1|Child2;
 *
 **/


// Child1|Child2
protected class Child_Alternatives extends AlternativesToken {

	public Child_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prChild().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Child_1_RuleCall_Child2(current, this) : new Child_0_RuleCall_Child1(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Child1
protected class Child_0_RuleCall_Child1 extends RuleCallToken {
	
	public Child_0_RuleCall_Child1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prChild().ele0ParserRuleCallChild1();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Child1_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("Child1")) return null;
		return new Child1_Assignment_name(current, this).firstSolution();
	}
}

// Child2
protected class Child_1_RuleCall_Child2 extends RuleCallToken {
	
	public Child_1_RuleCall_Child2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prChild().ele1ParserRuleCallChild2();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Child2_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("Child2")) return null;
		return new Child2_Assignment_name(current, this).firstSolution();
	}
}


/************ end Rule Child ****************/


/************ begin Rule Child1 ****************
 *
 * Child1:   name=ID;
 *
 **/


// name=ID
protected class Child1_Assignment_name extends AssignmentToken  {
	
	public Child1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prChild1().eleAssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = Bug250313GrammarAccess.INSTANCE.prChild1().ele0LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Child1 ****************/


/************ begin Rule Child2 ****************
 *
 * Child2:   name=STRING;
 *
 **/


// name=STRING
protected class Child2_Assignment_name extends AssignmentToken  {
	
	public Child2_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return Bug250313GrammarAccess.INSTANCE.prChild2().eleAssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = Bug250313GrammarAccess.INSTANCE.prChild2().ele0LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Child2 ****************/

}
