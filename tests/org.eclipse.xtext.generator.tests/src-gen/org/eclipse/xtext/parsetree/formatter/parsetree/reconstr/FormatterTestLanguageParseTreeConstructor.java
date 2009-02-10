/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;


public class FormatterTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Root") && (s = new Root_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Line") && (s = new Line_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TestLinewrap") && (s = new TestLinewrap_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TestIndentation") && (s = new TestIndentation_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Root ****************
 *
 * Root:   "test" (TestLinewrap|TestIndentation);
 *
 **/


// "test" (TestLinewrap|TestIndentation)
protected class Root_Group extends GroupToken {
	
	public Root_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prRoot().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Root_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Root_0_Keyword_test(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "test"
protected class Root_0_Keyword_test extends KeywordToken  {
	
	public Root_0_Keyword_test(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prRoot().ele0KeywordTest();
	}	
}

// TestLinewrap|TestIndentation
protected class Root_1_Alternatives extends AlternativesToken {

	public Root_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prRoot().ele1Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Root_1_1_RuleCall_TestIndentation(current, this) : new Root_1_0_RuleCall_TestLinewrap(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// TestLinewrap
protected class Root_1_0_RuleCall_TestLinewrap extends RuleCallToken {
	
	public Root_1_0_RuleCall_TestLinewrap(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prRoot().ele10ParserRuleCallTestLinewrap();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TestLinewrap_Group.class, current)) return null;
		if(!current.isInstanceOf("TestLinewrap")) return null;
		return new TestLinewrap_Group(current, this).firstSolution();
	}
}

// TestIndentation
protected class Root_1_1_RuleCall_TestIndentation extends RuleCallToken {
	
	public Root_1_1_RuleCall_TestIndentation(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prRoot().ele11ParserRuleCallTestIndentation();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(TestIndentation_Group.class, current)) return null;
		if(!current.isInstanceOf("TestIndentation")) return null;
		return new TestIndentation_Group(current, this).firstSolution();
	}
}



/************ end Rule Root ****************/


/************ begin Rule Line ****************
 *
 * Line:   type+=ID name+=ID ";";
 *
 **/


// type+=ID name+=ID ";"
protected class Line_Group extends GroupToken {
	
	public Line_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prLine().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Line_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Line_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// type+=ID name+=ID
protected class Line_0_Group extends GroupToken {
	
	public Line_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prLine().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Line_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Line_0_0_Assignment_type(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// type+=ID
protected class Line_0_0_Assignment_type extends AssignmentToken  {
	
	public Line_0_0_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prLine().ele00AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = FormatterTestLanguageGrammarAccess.INSTANCE.prLine().ele000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// name+=ID
protected class Line_0_1_Assignment_name extends AssignmentToken  {
	
	public Line_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prLine().ele01AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = FormatterTestLanguageGrammarAccess.INSTANCE.prLine().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ";"
protected class Line_1_Keyword extends KeywordToken  {
	
	public Line_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prLine().ele1KeywordSemicolon();
	}	
}


/************ end Rule Line ****************/


/************ begin Rule TestLinewrap ****************
 *
 * TestLinewrap:   "linewrap" (items+=Line)*;
 *
 **/


// "linewrap" (items+=Line)*
protected class TestLinewrap_Group extends GroupToken {
	
	public TestLinewrap_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestLinewrap().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestLinewrap_1_Assignment_items(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestLinewrap_0_Keyword_linewrap(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "linewrap"
protected class TestLinewrap_0_Keyword_linewrap extends KeywordToken  {
	
	public TestLinewrap_0_Keyword_linewrap(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestLinewrap().ele0KeywordLinewrap();
	}	
}

// (items+=Line)*
protected class TestLinewrap_1_Assignment_items extends AssignmentToken  {
	
	public TestLinewrap_1_Assignment_items(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestLinewrap().ele1AssignmentItems();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("items",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("items");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Line")) {
				Solution s = new Line_Group(param, this).firstSolution();
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


/************ end Rule TestLinewrap ****************/


/************ begin Rule TestIndentation ****************
 *
 * TestIndentation:   "indentation" "{" (sub+=TestIndentation|items+=Line)* "}";
 *
 **/


// "indentation" "{" (sub+=TestIndentation|items+=Line)* "}"
protected class TestIndentation_Group extends GroupToken {
	
	public TestIndentation_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestIndentation_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestIndentation_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "indentation" "{" (sub+=TestIndentation|items+=Line)*
protected class TestIndentation_0_Group extends GroupToken {
	
	public TestIndentation_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestIndentation_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestIndentation_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "indentation" "{"
protected class TestIndentation_0_0_Group extends GroupToken {
	
	public TestIndentation_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new TestIndentation_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new TestIndentation_0_0_0_Keyword_indentation(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "indentation"
protected class TestIndentation_0_0_0_Keyword_indentation extends KeywordToken  {
	
	public TestIndentation_0_0_0_Keyword_indentation(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele000KeywordIndentation();
	}	
}

// "{"
protected class TestIndentation_0_0_1_Keyword extends KeywordToken  {
	
	public TestIndentation_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele001KeywordLeftCurlyBracket();
	}	
}


// (sub+=TestIndentation|items+=Line)*
protected class TestIndentation_0_1_Alternatives extends AlternativesToken {

	public TestIndentation_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele01Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TestIndentation_0_1_1_Assignment_items(current, this) : new TestIndentation_0_1_0_Assignment_sub(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// sub+=TestIndentation
protected class TestIndentation_0_1_0_Assignment_sub extends AssignmentToken  {
	
	public TestIndentation_0_1_0_Assignment_sub(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele010AssignmentSub();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("sub",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("sub");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TestIndentation")) {
				Solution s = new TestIndentation_Group(param, this).firstSolution();
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

// items+=Line
protected class TestIndentation_0_1_1_Assignment_items extends AssignmentToken  {
	
	public TestIndentation_0_1_1_Assignment_items(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele011AssignmentItems();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("items",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("items");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Line")) {
				Solution s = new Line_Group(param, this).firstSolution();
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



// "}"
protected class TestIndentation_1_Keyword extends KeywordToken  {
	
	public TestIndentation_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule TestIndentation ****************/

}
