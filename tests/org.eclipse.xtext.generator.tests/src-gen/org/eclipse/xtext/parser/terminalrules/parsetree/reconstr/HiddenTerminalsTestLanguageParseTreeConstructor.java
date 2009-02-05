/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;


public class HiddenTerminalsTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new Model_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("WithoutHiddens") && (s = new WithoutHiddens_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("WithHiddens") && (s = new WithHiddens_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("OverridingHiddens") && (s = new OverridingHiddens_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("OverridingHiddensCall") && (s = new OverridingHiddensCall_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("InheritingHiddens") && (s = new InheritingHiddens_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("HidingHiddens") && (s = new HidingHiddens_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("InheritingHiddensCall") && (s = new InheritingHiddensCall_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Model ****************
 *
 * Model : WithoutHiddens | WithHiddens | OverridingHiddens | InheritingHiddens ;
 *
 **/


// WithoutHiddens | WithHiddens | OverridingHiddens | InheritingHiddens
protected class Model_Alternatives extends AlternativesToken {

	public Model_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_1_RuleCall_InheritingHiddens(current, this) : new Model_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// WithoutHiddens | WithHiddens | OverridingHiddens
protected class Model_0_Alternatives extends AlternativesToken {

	public Model_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel().ele0Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_1_RuleCall_OverridingHiddens(current, this) : new Model_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// WithoutHiddens | WithHiddens
protected class Model_0_0_Alternatives extends AlternativesToken {

	public Model_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel().ele00Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Model_0_0_1_RuleCall_WithHiddens(current, this) : new Model_0_0_0_RuleCall_WithoutHiddens(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// WithoutHiddens
protected class Model_0_0_0_RuleCall_WithoutHiddens extends RuleCallToken {
	
	public Model_0_0_0_RuleCall_WithoutHiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel().ele000ParserRuleCallWithoutHiddens();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(WithoutHiddens_Group.class, current)) return null;
		if(!current.isInstanceOf("WithoutHiddens")) return null;
		return new WithoutHiddens_Group(current, this).firstSolution();
	}
}

// WithHiddens
protected class Model_0_0_1_RuleCall_WithHiddens extends RuleCallToken {
	
	public Model_0_0_1_RuleCall_WithHiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel().ele001ParserRuleCallWithHiddens();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(WithHiddens_Group.class, current)) return null;
		if(!current.isInstanceOf("WithHiddens")) return null;
		return new WithHiddens_Group(current, this).firstSolution();
	}
}


// OverridingHiddens
protected class Model_0_1_RuleCall_OverridingHiddens extends RuleCallToken {
	
	public Model_0_1_RuleCall_OverridingHiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel().ele01ParserRuleCallOverridingHiddens();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(OverridingHiddens_Group.class, current)) return null;
		if(!current.isInstanceOf("OverridingHiddens")) return null;
		return new OverridingHiddens_Group(current, this).firstSolution();
	}
}


// InheritingHiddens
protected class Model_1_RuleCall_InheritingHiddens extends RuleCallToken {
	
	public Model_1_RuleCall_InheritingHiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel().ele1ParserRuleCallInheritingHiddens();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(InheritingHiddens_Group.class, current)) return null;
		if(!current.isInstanceOf("InheritingHiddens")) return null;
		return new InheritingHiddens_Group(current, this).firstSolution();
	}
}


/************ end Rule Model ****************/


/************ begin Rule WithoutHiddens ****************
 *
 * WithoutHiddens : "without" spaces += WS "hiddens" ( spaces += WS ) ? valid ?= ";" ;
 *
 **/


// "without" spaces += WS "hiddens" ( spaces += WS ) ? valid ?= ";"
protected class WithoutHiddens_Group extends GroupToken {
	
	public WithoutHiddens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new WithoutHiddens_1_Assignment_valid(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new WithoutHiddens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "without" spaces += WS "hiddens" ( spaces += WS ) ?
protected class WithoutHiddens_0_Group extends GroupToken {
	
	public WithoutHiddens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new WithoutHiddens_0_1_Assignment_spaces(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new WithoutHiddens_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "without" spaces += WS "hiddens"
protected class WithoutHiddens_0_0_Group extends GroupToken {
	
	public WithoutHiddens_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new WithoutHiddens_0_0_1_Keyword_hiddens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new WithoutHiddens_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "without" spaces += WS
protected class WithoutHiddens_0_0_0_Group extends GroupToken {
	
	public WithoutHiddens_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new WithoutHiddens_0_0_0_1_Assignment_spaces(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new WithoutHiddens_0_0_0_0_Keyword_without(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "without"
protected class WithoutHiddens_0_0_0_0_Keyword_without extends KeywordToken  {
	
	public WithoutHiddens_0_0_0_0_Keyword_without(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele0000KeywordWithout();
	}	
}

// spaces += WS
protected class WithoutHiddens_0_0_0_1_Assignment_spaces extends AssignmentToken  {
	
	public WithoutHiddens_0_0_0_1_Assignment_spaces(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele0001AssignmentSpaces();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("spaces",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("spaces");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele00010ParserRuleCallWS();
			return new Solution(obj);
		}

		return null;
	}
}


// "hiddens"
protected class WithoutHiddens_0_0_1_Keyword_hiddens extends KeywordToken  {
	
	public WithoutHiddens_0_0_1_Keyword_hiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele001KeywordHiddens();
	}	
}


// ( spaces += WS ) ?
protected class WithoutHiddens_0_1_Assignment_spaces extends AssignmentToken  {
	
	public WithoutHiddens_0_1_Assignment_spaces(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele01AssignmentSpaces();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("spaces",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("spaces");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele010ParserRuleCallWS();
			return new Solution(obj);
		}

		return null;
	}
}


// valid ?= ";"
protected class WithoutHiddens_1_Assignment_valid extends AssignmentToken  {
	
	public WithoutHiddens_1_Assignment_valid(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele1AssignmentValid();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("valid",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("valid");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithoutHiddens().ele10KeywordSemicolon();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule WithoutHiddens ****************/


/************ begin Rule WithHiddens ****************
 *
 * WithHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ) : "with" "hiddens" valid ?= ";" ;
 *
 **/


// "with" "hiddens" valid ?= ";"
protected class WithHiddens_Group extends GroupToken {
	
	public WithHiddens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithHiddens().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new WithHiddens_1_Assignment_valid(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new WithHiddens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "with" "hiddens"
protected class WithHiddens_0_Group extends GroupToken {
	
	public WithHiddens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithHiddens().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new WithHiddens_0_1_Keyword_hiddens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new WithHiddens_0_0_Keyword_with(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "with"
protected class WithHiddens_0_0_Keyword_with extends KeywordToken  {
	
	public WithHiddens_0_0_Keyword_with(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithHiddens().ele00KeywordWith();
	}	
}

// "hiddens"
protected class WithHiddens_0_1_Keyword_hiddens extends KeywordToken  {
	
	public WithHiddens_0_1_Keyword_hiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithHiddens().ele01KeywordHiddens();
	}	
}


// valid ?= ";"
protected class WithHiddens_1_Assignment_valid extends AssignmentToken  {
	
	public WithHiddens_1_Assignment_valid(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithHiddens().ele1AssignmentValid();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("valid",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("valid");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWithHiddens().ele10KeywordSemicolon();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule WithHiddens ****************/


/************ begin Rule OverridingHiddens ****************
 *
 * OverridingHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ) : "overriding" "hiddens" "(" called = OverridingHiddensCall ")" valid ?= ";" ;
 *
 **/


// "overriding" "hiddens" "(" called = OverridingHiddensCall ")" valid ?= ";"
protected class OverridingHiddens_Group extends GroupToken {
	
	public OverridingHiddens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridingHiddens_1_Assignment_valid(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridingHiddens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overriding" "hiddens" "(" called = OverridingHiddensCall ")"
protected class OverridingHiddens_0_Group extends GroupToken {
	
	public OverridingHiddens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridingHiddens_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridingHiddens_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overriding" "hiddens" "(" called = OverridingHiddensCall
protected class OverridingHiddens_0_0_Group extends GroupToken {
	
	public OverridingHiddens_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridingHiddens_0_0_1_Assignment_called(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridingHiddens_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overriding" "hiddens" "("
protected class OverridingHiddens_0_0_0_Group extends GroupToken {
	
	public OverridingHiddens_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridingHiddens_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridingHiddens_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overriding" "hiddens"
protected class OverridingHiddens_0_0_0_0_Group extends GroupToken {
	
	public OverridingHiddens_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridingHiddens_0_0_0_0_1_Keyword_hiddens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridingHiddens_0_0_0_0_0_Keyword_overriding(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "overriding"
protected class OverridingHiddens_0_0_0_0_0_Keyword_overriding extends KeywordToken  {
	
	public OverridingHiddens_0_0_0_0_0_Keyword_overriding(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele00000KeywordOverriding();
	}	
}

// "hiddens"
protected class OverridingHiddens_0_0_0_0_1_Keyword_hiddens extends KeywordToken  {
	
	public OverridingHiddens_0_0_0_0_1_Keyword_hiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele00001KeywordHiddens();
	}	
}


// "("
protected class OverridingHiddens_0_0_0_1_Keyword extends KeywordToken  {
	
	public OverridingHiddens_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele0001KeywordLeftParenthesis();
	}	
}


// called = OverridingHiddensCall
protected class OverridingHiddens_0_0_1_Assignment_called extends AssignmentToken  {
	
	public OverridingHiddens_0_0_1_Assignment_called(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele001AssignmentCalled();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("called",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("called");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("OverridingHiddensCall")) {
				Solution s = new OverridingHiddensCall_Group(param, this).firstSolution();
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


// ")"
protected class OverridingHiddens_0_1_Keyword extends KeywordToken  {
	
	public OverridingHiddens_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele01KeywordRightParenthesis();
	}	
}


// valid ?= ";"
protected class OverridingHiddens_1_Assignment_valid extends AssignmentToken  {
	
	public OverridingHiddens_1_Assignment_valid(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele1AssignmentValid();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("valid",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("valid");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddens().ele10KeywordSemicolon();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule OverridingHiddens ****************/


/************ begin Rule OverridingHiddensCall ****************
 *
 * OverridingHiddensCall hidden ( ) : "call" ( spaces += WS ) ? valid ?= ";" ;
 *
 **/


// "call" ( spaces += WS ) ? valid ?= ";"
protected class OverridingHiddensCall_Group extends GroupToken {
	
	public OverridingHiddensCall_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddensCall().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridingHiddensCall_1_Assignment_valid(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridingHiddensCall_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "call" ( spaces += WS ) ?
protected class OverridingHiddensCall_0_Group extends GroupToken {
	
	public OverridingHiddensCall_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddensCall().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new OverridingHiddensCall_0_1_Assignment_spaces(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new OverridingHiddensCall_0_0_Keyword_call(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "call"
protected class OverridingHiddensCall_0_0_Keyword_call extends KeywordToken  {
	
	public OverridingHiddensCall_0_0_Keyword_call(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddensCall().ele00KeywordCall();
	}	
}

// ( spaces += WS ) ?
protected class OverridingHiddensCall_0_1_Assignment_spaces extends AssignmentToken  {
	
	public OverridingHiddensCall_0_1_Assignment_spaces(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddensCall().ele01AssignmentSpaces();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("spaces",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("spaces");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddensCall().ele010ParserRuleCallWS();
			return new Solution(obj);
		}

		return null;
	}
}


// valid ?= ";"
protected class OverridingHiddensCall_1_Assignment_valid extends AssignmentToken  {
	
	public OverridingHiddensCall_1_Assignment_valid(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddensCall().ele1AssignmentValid();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("valid",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("valid");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prOverridingHiddensCall().ele10KeywordSemicolon();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule OverridingHiddensCall ****************/


/************ begin Rule InheritingHiddens ****************
 *
 * InheritingHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ) : "inheriting" "hiddens" "(" ( called = InheritingHiddensCall | hidingCalled = HidingHiddens ) ")" valid ?= ";" ;
 *
 **/


// "inheriting" "hiddens" "(" ( called = InheritingHiddensCall | hidingCalled = HidingHiddens ) ")" valid ?= ";"
protected class InheritingHiddens_Group extends GroupToken {
	
	public InheritingHiddens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new InheritingHiddens_1_Assignment_valid(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritingHiddens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "inheriting" "hiddens" "(" ( called = InheritingHiddensCall | hidingCalled = HidingHiddens ) ")"
protected class InheritingHiddens_0_Group extends GroupToken {
	
	public InheritingHiddens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new InheritingHiddens_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritingHiddens_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "inheriting" "hiddens" "(" ( called = InheritingHiddensCall | hidingCalled = HidingHiddens )
protected class InheritingHiddens_0_0_Group extends GroupToken {
	
	public InheritingHiddens_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new InheritingHiddens_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritingHiddens_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "inheriting" "hiddens" "("
protected class InheritingHiddens_0_0_0_Group extends GroupToken {
	
	public InheritingHiddens_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new InheritingHiddens_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritingHiddens_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "inheriting" "hiddens"
protected class InheritingHiddens_0_0_0_0_Group extends GroupToken {
	
	public InheritingHiddens_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new InheritingHiddens_0_0_0_0_1_Keyword_hiddens(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritingHiddens_0_0_0_0_0_Keyword_inheriting(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "inheriting"
protected class InheritingHiddens_0_0_0_0_0_Keyword_inheriting extends KeywordToken  {
	
	public InheritingHiddens_0_0_0_0_0_Keyword_inheriting(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele00000KeywordInheriting();
	}	
}

// "hiddens"
protected class InheritingHiddens_0_0_0_0_1_Keyword_hiddens extends KeywordToken  {
	
	public InheritingHiddens_0_0_0_0_1_Keyword_hiddens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele00001KeywordHiddens();
	}	
}


// "("
protected class InheritingHiddens_0_0_0_1_Keyword extends KeywordToken  {
	
	public InheritingHiddens_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele0001KeywordLeftParenthesis();
	}	
}


// called = InheritingHiddensCall | hidingCalled = HidingHiddens
protected class InheritingHiddens_0_0_1_Alternatives extends AlternativesToken {

	public InheritingHiddens_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele001Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new InheritingHiddens_0_0_1_1_Assignment_hidingCalled(current, this) : new InheritingHiddens_0_0_1_0_Assignment_called(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// called = InheritingHiddensCall
protected class InheritingHiddens_0_0_1_0_Assignment_called extends AssignmentToken  {
	
	public InheritingHiddens_0_0_1_0_Assignment_called(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele0010AssignmentCalled();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("called",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("called");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("InheritingHiddensCall")) {
				Solution s = new InheritingHiddensCall_Group(param, this).firstSolution();
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

// hidingCalled = HidingHiddens
protected class InheritingHiddens_0_0_1_1_Assignment_hidingCalled extends AssignmentToken  {
	
	public InheritingHiddens_0_0_1_1_Assignment_hidingCalled(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele0011AssignmentHidingCalled();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("hidingCalled",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("hidingCalled");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("HidingHiddens")) {
				Solution s = new HidingHiddens_Group(param, this).firstSolution();
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



// ")"
protected class InheritingHiddens_0_1_Keyword extends KeywordToken  {
	
	public InheritingHiddens_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele01KeywordRightParenthesis();
	}	
}


// valid ?= ";"
protected class InheritingHiddens_1_Assignment_valid extends AssignmentToken  {
	
	public InheritingHiddens_1_Assignment_valid(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele1AssignmentValid();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("valid",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("valid");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddens().ele10KeywordSemicolon();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule InheritingHiddens ****************/


/************ begin Rule HidingHiddens ****************
 *
 * HidingHiddens hidden ( ) : "hiding" space = WS called = InheritingHiddensCall ;
 *
 **/


// "hiding" space = WS called = InheritingHiddensCall
protected class HidingHiddens_Group extends GroupToken {
	
	public HidingHiddens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prHidingHiddens().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new HidingHiddens_1_Assignment_called(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new HidingHiddens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "hiding" space = WS
protected class HidingHiddens_0_Group extends GroupToken {
	
	public HidingHiddens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prHidingHiddens().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new HidingHiddens_0_1_Assignment_space(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new HidingHiddens_0_0_Keyword_hiding(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "hiding"
protected class HidingHiddens_0_0_Keyword_hiding extends KeywordToken  {
	
	public HidingHiddens_0_0_Keyword_hiding(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prHidingHiddens().ele00KeywordHiding();
	}	
}

// space = WS
protected class HidingHiddens_0_1_Assignment_space extends AssignmentToken  {
	
	public HidingHiddens_0_1_Assignment_space(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prHidingHiddens().ele01AssignmentSpace();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("space",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("space");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prHidingHiddens().ele010ParserRuleCallWS();
			return new Solution(obj);
		}

		return null;
	}
}


// called = InheritingHiddensCall
protected class HidingHiddens_1_Assignment_called extends AssignmentToken  {
	
	public HidingHiddens_1_Assignment_called(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prHidingHiddens().ele1AssignmentCalled();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("called",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("called");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("InheritingHiddensCall")) {
				Solution s = new InheritingHiddensCall_Group(param, this).firstSolution();
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


/************ end Rule HidingHiddens ****************/


/************ begin Rule InheritingHiddensCall ****************
 *
 * InheritingHiddensCall : "call" valid ?= ";" ;
 *
 **/


// "call" valid ?= ";"
protected class InheritingHiddensCall_Group extends GroupToken {
	
	public InheritingHiddensCall_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddensCall().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new InheritingHiddensCall_1_Assignment_valid(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new InheritingHiddensCall_0_Keyword_call(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "call"
protected class InheritingHiddensCall_0_Keyword_call extends KeywordToken  {
	
	public InheritingHiddensCall_0_Keyword_call(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddensCall().ele0KeywordCall();
	}	
}

// valid ?= ";"
protected class InheritingHiddensCall_1_Assignment_valid extends AssignmentToken  {
	
	public InheritingHiddensCall_1_Assignment_valid(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddensCall().ele1AssignmentValid();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("valid",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("valid");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prInheritingHiddensCall().ele10KeywordSemicolon();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule InheritingHiddensCall ****************/





}
