/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class LookaheadTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private LookaheadTestLanguageGrammarAccess grammarAccess;
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Entry") && (s = new Entry_Assignment_contents(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Alts") && (s = new Alts_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("LookAhead0") && (s = new LookAhead0_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("LookAhead1") && (s = new LookAhead1_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("LookAhead2") && (s = new LookAhead2_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("LookAhead3") && (s = new LookAhead3_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("LookAhead4") && (s = new LookAhead4_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Entry ****************
 *
 * Entry:   (contents+=Alts)*;
 *
 **/


// (contents+=Alts)*
protected class Entry_Assignment_contents extends AssignmentToken  {
	
	public Entry_Assignment_contents(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prEntry().eleAssignmentContents();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("contents",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contents");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Alts")) {
				Solution s = new Alts_Alternatives(param, this).firstSolution();
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

/************ end Rule Entry ****************/


/************ begin Rule Alts ****************
 *
 * Alts:   LookAhead0|LookAhead1|LookAhead3;
 *
 **/


// LookAhead0|LookAhead1|LookAhead3
protected class Alts_Alternatives extends AlternativesToken {

	public Alts_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return grammarAccess.prAlts().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Alts_1_RuleCall_LookAhead3(current, this) : new Alts_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// LookAhead0|LookAhead1
protected class Alts_0_Alternatives extends AlternativesToken {

	public Alts_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return grammarAccess.prAlts().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Alts_0_1_RuleCall_LookAhead1(current, this) : new Alts_0_0_RuleCall_LookAhead0(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// LookAhead0
protected class Alts_0_0_RuleCall_LookAhead0 extends RuleCallToken {
	
	public Alts_0_0_RuleCall_LookAhead0(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return grammarAccess.prAlts().ele00ParserRuleCallLookAhead0();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(LookAhead0_Group.class, current)) return null;
		if(!current.isInstanceOf("LookAhead0")) return null;
		return new LookAhead0_Group(current, this).firstSolution();
	}
}

// LookAhead1
protected class Alts_0_1_RuleCall_LookAhead1 extends RuleCallToken {
	
	public Alts_0_1_RuleCall_LookAhead1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return grammarAccess.prAlts().ele01ParserRuleCallLookAhead1();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(LookAhead1_Group.class, current)) return null;
		if(!current.isInstanceOf("LookAhead1")) return null;
		return new LookAhead1_Group(current, this).firstSolution();
	}
}


// LookAhead3
protected class Alts_1_RuleCall_LookAhead3 extends RuleCallToken {
	
	public Alts_1_RuleCall_LookAhead3(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return grammarAccess.prAlts().ele1ParserRuleCallLookAhead3();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(LookAhead3_Group.class, current)) return null;
		if(!current.isInstanceOf("LookAhead3")) return null;
		return new LookAhead3_Group(current, this).firstSolution();
	}
}


/************ end Rule Alts ****************/


/************ begin Rule LookAhead0 ****************
 *
 * LookAhead0:   "bar" x="a";
 *
 **/


// "bar" x="a"
protected class LookAhead0_Group extends GroupToken {
	
	public LookAhead0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead0().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead0_1_Assignment_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead0_0_Keyword_bar(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "bar"
protected class LookAhead0_0_Keyword_bar extends KeywordToken  {
	
	public LookAhead0_0_Keyword_bar(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prLookAhead0().ele0KeywordBar();
	}	
}

// x="a"
protected class LookAhead0_1_Assignment_x extends AssignmentToken  {
	
	public LookAhead0_1_Assignment_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead0().ele1AssignmentX();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("x",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("x");

		if("a".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead0().ele10KeywordA();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule LookAhead0 ****************/


/************ begin Rule LookAhead1 ****************
 *
 * LookAhead1:   "foo" y=LookAhead2 x="b" x="d";
 *
 **/


// "foo" y=LookAhead2 x="b" x="d"
protected class LookAhead1_Group extends GroupToken {
	
	public LookAhead1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead1().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead1_1_Assignment_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "foo" y=LookAhead2 x="b"
protected class LookAhead1_0_Group extends GroupToken {
	
	public LookAhead1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead1().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead1_0_1_Assignment_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "foo" y=LookAhead2
protected class LookAhead1_0_0_Group extends GroupToken {
	
	public LookAhead1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead1().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead1_0_0_1_Assignment_y(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead1_0_0_0_Keyword_foo(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "foo"
protected class LookAhead1_0_0_0_Keyword_foo extends KeywordToken  {
	
	public LookAhead1_0_0_0_Keyword_foo(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prLookAhead1().ele000KeywordFoo();
	}	
}

// y=LookAhead2
protected class LookAhead1_0_0_1_Assignment_y extends AssignmentToken  {
	
	public LookAhead1_0_0_1_Assignment_y(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead1().ele001AssignmentY();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("y",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("y");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("LookAhead2")) {
				Solution s = new LookAhead2_Group(param, this).firstSolution();
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


// x="b"
protected class LookAhead1_0_1_Assignment_x extends AssignmentToken  {
	
	public LookAhead1_0_1_Assignment_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead1().ele01AssignmentX();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("x",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("x");

		if("b".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead1().ele010KeywordB();
			return new Solution(obj);
		}

		return null;
	}
}


// x="d"
protected class LookAhead1_1_Assignment_x extends AssignmentToken  {
	
	public LookAhead1_1_Assignment_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead1().ele1AssignmentX();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("x",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("x");

		if("d".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead1().ele10KeywordD();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule LookAhead1 ****************/


/************ begin Rule LookAhead2 ****************
 *
 * LookAhead2:   (z="foo"|z="bar") "c";
 *
 **/


// (z="foo"|z="bar") "c"
protected class LookAhead2_Group extends GroupToken {
	
	public LookAhead2_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead2().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead2_1_Keyword_c(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead2_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// z="foo"|z="bar"
protected class LookAhead2_0_Alternatives extends AlternativesToken {

	public LookAhead2_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return grammarAccess.prLookAhead2().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new LookAhead2_0_1_Assignment_z(current, this) : new LookAhead2_0_0_Assignment_z(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// z="foo"
protected class LookAhead2_0_0_Assignment_z extends AssignmentToken  {
	
	public LookAhead2_0_0_Assignment_z(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead2().ele00AssignmentZ();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("z",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("z");

		if("foo".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead2().ele000KeywordFoo();
			return new Solution(obj);
		}

		return null;
	}
}

// z="bar"
protected class LookAhead2_0_1_Assignment_z extends AssignmentToken  {
	
	public LookAhead2_0_1_Assignment_z(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead2().ele01AssignmentZ();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("z",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("z");

		if("bar".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead2().ele010KeywordBar();
			return new Solution(obj);
		}

		return null;
	}
}


// "c"
protected class LookAhead2_1_Keyword_c extends KeywordToken  {
	
	public LookAhead2_1_Keyword_c(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prLookAhead2().ele1KeywordC();
	}	
}


/************ end Rule LookAhead2 ****************/


/************ begin Rule LookAhead3 ****************
 *
 * LookAhead3:   "foo" "bar" x="b" z=LookAhead4;
 *
 **/


// "foo" "bar" x="b" z=LookAhead4
protected class LookAhead3_Group extends GroupToken {
	
	public LookAhead3_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead3().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead3_1_Assignment_z(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead3_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "foo" "bar" x="b"
protected class LookAhead3_0_Group extends GroupToken {
	
	public LookAhead3_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead3().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead3_0_1_Assignment_x(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead3_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "foo" "bar"
protected class LookAhead3_0_0_Group extends GroupToken {
	
	public LookAhead3_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return grammarAccess.prLookAhead3().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new LookAhead3_0_0_1_Keyword_bar(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new LookAhead3_0_0_0_Keyword_foo(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "foo"
protected class LookAhead3_0_0_0_Keyword_foo extends KeywordToken  {
	
	public LookAhead3_0_0_0_Keyword_foo(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prLookAhead3().ele000KeywordFoo();
	}	
}

// "bar"
protected class LookAhead3_0_0_1_Keyword_bar extends KeywordToken  {
	
	public LookAhead3_0_0_1_Keyword_bar(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return grammarAccess.prLookAhead3().ele001KeywordBar();
	}	
}


// x="b"
protected class LookAhead3_0_1_Assignment_x extends AssignmentToken  {
	
	public LookAhead3_0_1_Assignment_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead3().ele01AssignmentX();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("x",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("x");

		if("b".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead3().ele010KeywordB();
			return new Solution(obj);
		}

		return null;
	}
}


// z=LookAhead4
protected class LookAhead3_1_Assignment_z extends AssignmentToken  {
	
	public LookAhead3_1_Assignment_z(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead3().ele1AssignmentZ();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("z",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("z");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("LookAhead4")) {
				Solution s = new LookAhead4_Alternatives(param, this).firstSolution();
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


/************ end Rule LookAhead3 ****************/


/************ begin Rule LookAhead4 ****************
 *
 * LookAhead4:   x="c"|x="d";
 *
 **/


// x="c"|x="d"
protected class LookAhead4_Alternatives extends AlternativesToken {

	public LookAhead4_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return grammarAccess.prLookAhead4().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new LookAhead4_1_Assignment_x(current, this) : new LookAhead4_0_Assignment_x(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// x="c"
protected class LookAhead4_0_Assignment_x extends AssignmentToken  {
	
	public LookAhead4_0_Assignment_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead4().ele0AssignmentX();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("x",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("x");

		if("c".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead4().ele00KeywordC();
			return new Solution(obj);
		}

		return null;
	}
}

// x="d"
protected class LookAhead4_1_Assignment_x extends AssignmentToken  {
	
	public LookAhead4_1_Assignment_x(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return grammarAccess.prLookAhead4().ele1AssignmentX();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("x",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("x");

		if("d".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = grammarAccess.prLookAhead4().ele10KeywordD();
			return new Solution(obj);
		}

		return null;
	}
}


/************ end Rule LookAhead4 ****************/

}
