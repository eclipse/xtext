/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;


public class TransientValuesTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		if(object == null) throw new IllegalArgumentException("The to-be-serialialized model is null");
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Root") && (s = new Root_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TestRequired") && (s = new TestRequired_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TestOptional") && (s = new TestOptional_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TestList") && (s = new TestList_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Root ****************
 *
 * Root : 'test' ( TestRequired | TestOptional | TestList ) ;
 *
 **/


// 'test' ( TestRequired | TestOptional | TestList )
protected class Root_Group extends GroupToken {
	
	public Root_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Root_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Root_0_Keyword_test(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'test'
protected class Root_0_Keyword_test extends KeywordToken  {
	
	public Root_0_Keyword_test(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot().ele0KeywordTest();
	}	
}

// TestRequired | TestOptional | TestList
protected class Root_1_Alternatives extends AlternativesToken {

	public Root_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot().ele1Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Root_1_1_RuleCall_TestList(current, this) : new Root_1_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// TestRequired | TestOptional
protected class Root_1_0_Alternatives extends AlternativesToken {

	public Root_1_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot().ele10Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Root_1_0_1_RuleCall_TestOptional(current, this) : new Root_1_0_0_RuleCall_TestRequired(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// TestRequired
protected class Root_1_0_0_RuleCall_TestRequired extends RuleCallToken {
	
	public Root_1_0_0_RuleCall_TestRequired(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot().ele100ParserRuleCallTestRequired();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TestRequired_Group.class, current)) return null;
		if(!current.isInstanceOf("TestRequired")) return null;
		return new TestRequired_Group(current, this).firstSolution();
	}
}

// TestOptional
protected class Root_1_0_1_RuleCall_TestOptional extends RuleCallToken {
	
	public Root_1_0_1_RuleCall_TestOptional(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot().ele101ParserRuleCallTestOptional();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TestOptional_Group.class, current)) return null;
		if(!current.isInstanceOf("TestOptional")) return null;
		return new TestOptional_Group(current, this).firstSolution();
	}
}


// TestList
protected class Root_1_1_RuleCall_TestList extends RuleCallToken {
	
	public Root_1_1_RuleCall_TestList(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot().ele11ParserRuleCallTestList();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TestList_Group.class, current)) return null;
		if(!current.isInstanceOf("TestList")) return null;
		return new TestList_Group(current, this).firstSolution();
	}
}



/************ end Rule Root ****************/

/************ begin Rule TestRequired ****************
 *
 * TestRequired : 'required' required1 = INT required2 = INT ;
 *
 **/


// 'required' required1 = INT required2 = INT
protected class TestRequired_Group extends GroupToken {
	
	public TestRequired_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestRequired().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestRequired_1_Assignment_required2(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestRequired_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'required' required1 = INT
protected class TestRequired_0_Group extends GroupToken {
	
	public TestRequired_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestRequired().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestRequired_0_1_Assignment_required1(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestRequired_0_0_Keyword_required(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'required'
protected class TestRequired_0_0_Keyword_required extends KeywordToken  {
	
	public TestRequired_0_0_Keyword_required(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestRequired().ele00KeywordRequired();
	}	
}

// required1 = INT
protected class TestRequired_0_1_Assignment_required1 extends AssignmentToken  {
	
	public TestRequired_0_1_Assignment_required1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestRequired().ele01AssignmentRequired1();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("required1",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("required1");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = TransientValuesTestGrammarAccess.INSTANCE.prTestRequired().ele010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// required2 = INT
protected class TestRequired_1_Assignment_required2 extends AssignmentToken  {
	
	public TestRequired_1_Assignment_required2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestRequired().ele1AssignmentRequired2();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("required2",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("required2");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = TransientValuesTestGrammarAccess.INSTANCE.prTestRequired().ele10LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TestRequired ****************/

/************ begin Rule TestOptional ****************
 *
 * TestOptional : 'optional' ( opt1 = INT ) ? ( ':' opt2 = INT ) ? ;
 *
 **/


// 'optional' ( opt1 = INT ) ? ( ':' opt2 = INT ) ?
protected class TestOptional_Group extends GroupToken {
	
	public TestOptional_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestOptional_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestOptional_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'optional' ( opt1 = INT ) ?
protected class TestOptional_0_Group extends GroupToken {
	
	public TestOptional_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestOptional_0_1_Assignment_opt1(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestOptional_0_0_Keyword_optional(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'optional'
protected class TestOptional_0_0_Keyword_optional extends KeywordToken  {
	
	public TestOptional_0_0_Keyword_optional(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele00KeywordOptional();
	}	
}

// ( opt1 = INT ) ?
protected class TestOptional_0_1_Assignment_opt1 extends AssignmentToken  {
	
	public TestOptional_0_1_Assignment_opt1(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele01AssignmentOpt1();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("opt1",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("opt1");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// ( ':' opt2 = INT ) ?
protected class TestOptional_1_Group extends GroupToken {
	
	public TestOptional_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestOptional_1_1_Assignment_opt2(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestOptional_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class TestOptional_1_0_Keyword extends KeywordToken  {
	
	public TestOptional_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele10Keyword();
	}	
}

// opt2 = INT
protected class TestOptional_1_1_Assignment_opt2 extends AssignmentToken  {
	
	public TestOptional_1_1_Assignment_opt2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele11AssignmentOpt2();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("opt2",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("opt2");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = TransientValuesTestGrammarAccess.INSTANCE.prTestOptional().ele110LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule TestOptional ****************/

/************ begin Rule TestList ****************
 *
 * TestList : 'list' ( item += INT ) * ;
 *
 **/


// 'list' ( item += INT ) *
protected class TestList_Group extends GroupToken {
	
	public TestList_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestList().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestList_1_Assignment_item(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestList_0_Keyword_list(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'list'
protected class TestList_0_Keyword_list extends KeywordToken  {
	
	public TestList_0_Keyword_list(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestList().ele0KeywordList();
	}	
}

// ( item += INT ) *
protected class TestList_1_Assignment_item extends AssignmentToken  {
	
	public TestList_1_Assignment_item(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestList().ele1AssignmentItem();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("item",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("item");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = TransientValuesTestGrammarAccess.INSTANCE.prTestList().ele10LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule TestList ****************/

}
