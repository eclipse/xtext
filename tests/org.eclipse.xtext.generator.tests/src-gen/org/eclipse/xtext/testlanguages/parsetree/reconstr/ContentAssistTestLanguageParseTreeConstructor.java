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
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;

import com.google.inject.Inject;

public class ContentAssistTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private ContentAssistTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf(grammarAccess.prStart().getRule().getType().getType()) && (s = new Start_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prAbstractRule().getRule().getType().getType()) && (s = new AbstractRule_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prFirstAbstractRuleChild().getRule().getType().getType()) && (s = new FirstAbstractRuleChild_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prSecondAbstractRuleChild().getRule().getType().getType()) && (s = new SecondAbstractRuleChild_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf(grammarAccess.prAbstractRuleCall().getRule().getType().getType()) && (s = new AbstractRuleCall_Assignment_rule(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Start ****************
 *
 * Start:   "abstract rules" (rules+=AbstractRule)+ "end";
 *
 **/


// "abstract rules" (rules+=AbstractRule)+ "end"
protected class Start_Group extends GroupToken {
	
	public Start_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prStart().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Start_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Start_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "abstract rules" (rules+=AbstractRule)+
protected class Start_0_Group extends GroupToken {
	
	public Start_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prStart().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Start_0_1_Assignment_rules(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Start_0_0_Keyword_abstractrules(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "abstract rules"
protected class Start_0_0_Keyword_abstractrules extends KeywordToken  {
	
	public Start_0_0_Keyword_abstractrules(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prStart().ele00KeywordAbstractRules();
	}	
}

// (rules+=AbstractRule)+
protected class Start_0_1_Assignment_rules extends AssignmentToken  {
	
	public Start_0_1_Assignment_rules(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prStart().ele01AssignmentRules();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rules",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rules");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prAbstractRule().getRule().getType().getType())) {
				Solution s = new AbstractRule_Alternatives(param, this).firstSolution();
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


// "end"
protected class Start_1_Keyword_end extends KeywordToken  {
	
	public Start_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prStart().ele1KeywordEnd();
	}	
}


/************ end Rule Start ****************/


/************ begin Rule AbstractRule ****************
 *
 * AbstractRule:   FirstAbstractRuleChild|SecondAbstractRuleChild;
 *
 **/


// FirstAbstractRuleChild|SecondAbstractRuleChild
protected class AbstractRule_Alternatives extends AlternativesToken {

	public AbstractRule_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.prAbstractRule().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractRule_1_RuleCall_SecondAbstractRuleChild(current, this) : new AbstractRule_0_RuleCall_FirstAbstractRuleChild(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// FirstAbstractRuleChild
protected class AbstractRule_0_RuleCall_FirstAbstractRuleChild extends RuleCallToken {
	
	public AbstractRule_0_RuleCall_FirstAbstractRuleChild(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prAbstractRule().ele0ParserRuleCallFirstAbstractRuleChild();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(FirstAbstractRuleChild_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prFirstAbstractRuleChild().getRule().getType().getType())) return null;
		return new FirstAbstractRuleChild_Group(current, this).firstSolution();
	}
}

// SecondAbstractRuleChild
protected class AbstractRule_1_RuleCall_SecondAbstractRuleChild extends RuleCallToken {
	
	public AbstractRule_1_RuleCall_SecondAbstractRuleChild(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.prAbstractRule().ele1ParserRuleCallSecondAbstractRuleChild();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(SecondAbstractRuleChild_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.prSecondAbstractRuleChild().getRule().getType().getType())) return null;
		return new SecondAbstractRuleChild_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractRule ****************/


/************ begin Rule FirstAbstractRuleChild ****************
 *
 * FirstAbstractRuleChild:   name=ID "(" (elements+=AbstractRule)+ ")" ";";
 *
 **/


// name=ID "(" (elements+=AbstractRule)+ ")" ";"
protected class FirstAbstractRuleChild_Group extends GroupToken {
	
	public FirstAbstractRuleChild_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID "(" (elements+=AbstractRule)+ ")"
protected class FirstAbstractRuleChild_0_Group extends GroupToken {
	
	public FirstAbstractRuleChild_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID "(" (elements+=AbstractRule)+
protected class FirstAbstractRuleChild_0_0_Group extends GroupToken {
	
	public FirstAbstractRuleChild_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_0_0_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID "("
protected class FirstAbstractRuleChild_0_0_0_Group extends GroupToken {
	
	public FirstAbstractRuleChild_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID
protected class FirstAbstractRuleChild_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public FirstAbstractRuleChild_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele0000AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prFirstAbstractRuleChild().ele00000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "("
protected class FirstAbstractRuleChild_0_0_0_1_Keyword extends KeywordToken  {
	
	public FirstAbstractRuleChild_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele0001KeywordLeftParenthesis();
	}	
}


// (elements+=AbstractRule)+
protected class FirstAbstractRuleChild_0_0_1_Assignment_elements extends AssignmentToken  {
	
	public FirstAbstractRuleChild_0_0_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele001AssignmentElements();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prAbstractRule().getRule().getType().getType())) {
				Solution s = new AbstractRule_Alternatives(param, this).firstSolution();
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
protected class FirstAbstractRuleChild_0_1_Keyword extends KeywordToken  {
	
	public FirstAbstractRuleChild_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele01KeywordRightParenthesis();
	}	
}


// ";"
protected class FirstAbstractRuleChild_1_Keyword extends KeywordToken  {
	
	public FirstAbstractRuleChild_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prFirstAbstractRuleChild().ele1KeywordSemicolon();
	}	
}


/************ end Rule FirstAbstractRuleChild ****************/


/************ begin Rule SecondAbstractRuleChild ****************
 *
 * SecondAbstractRuleChild:   name=ID "rule" ":" rule=AbstractRuleCall ";";
 *
 **/


// name=ID "rule" ":" rule=AbstractRuleCall ";"
protected class SecondAbstractRuleChild_Group extends GroupToken {
	
	public SecondAbstractRuleChild_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID "rule" ":" rule=AbstractRuleCall
protected class SecondAbstractRuleChild_0_Group extends GroupToken {
	
	public SecondAbstractRuleChild_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_0_1_Assignment_rule(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID "rule" ":"
protected class SecondAbstractRuleChild_0_0_Group extends GroupToken {
	
	public SecondAbstractRuleChild_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID "rule"
protected class SecondAbstractRuleChild_0_0_0_Group extends GroupToken {
	
	public SecondAbstractRuleChild_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_0_0_0_1_Keyword_rule(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID
protected class SecondAbstractRuleChild_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public SecondAbstractRuleChild_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele0000AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.prSecondAbstractRuleChild().ele00000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "rule"
protected class SecondAbstractRuleChild_0_0_0_1_Keyword_rule extends KeywordToken  {
	
	public SecondAbstractRuleChild_0_0_0_1_Keyword_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele0001KeywordRule();
	}	
}


// ":"
protected class SecondAbstractRuleChild_0_0_1_Keyword extends KeywordToken  {
	
	public SecondAbstractRuleChild_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele001KeywordColon();
	}	
}


// rule=AbstractRuleCall
protected class SecondAbstractRuleChild_0_1_Assignment_rule extends AssignmentToken  {
	
	public SecondAbstractRuleChild_0_1_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele01AssignmentRule();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prAbstractRuleCall().getRule().getType().getType())) {
				Solution s = new AbstractRuleCall_Assignment_rule(param, this).firstSolution();
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


// ";"
protected class SecondAbstractRuleChild_1_Keyword extends KeywordToken  {
	
	public SecondAbstractRuleChild_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.prSecondAbstractRuleChild().ele1KeywordSemicolon();
	}	
}


/************ end Rule SecondAbstractRuleChild ****************/


/************ begin Rule AbstractRuleCall ****************
 *
 * AbstractRuleCall:   rule=[AbstractRule];
 *
 **/


// rule=[AbstractRule]
protected class AbstractRuleCall_Assignment_rule extends AssignmentToken  {
	
	public AbstractRuleCall_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.prAbstractRuleCall().eleAssignmentRule();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.prAbstractRuleCall().ele0CrossReferenceEStringAbstractRule().getType().getType())) {
				type = AssignmentType.CR;
				element = grammarAccess.prAbstractRuleCall().ele0CrossReferenceEStringAbstractRule(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

/************ end Rule AbstractRuleCall ****************/

}
