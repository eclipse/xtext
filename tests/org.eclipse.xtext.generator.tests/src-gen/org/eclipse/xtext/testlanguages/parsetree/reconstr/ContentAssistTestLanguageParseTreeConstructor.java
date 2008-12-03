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


public class ContentAssistTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Start") && (s = new Start_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractRule") && (s = new AbstractRule_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("FirstAbstractRuleChild") && (s = new FirstAbstractRuleChild_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("SecondAbstractRuleChild") && (s = new SecondAbstractRuleChild_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractRuleCall") && (s = new AbstractRuleCall_Assignment_rule(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Start ****************
 *
 * Start : 'abstract rules' ( rules += AbstractRule ) + 'end' ;
 *
 **/


// 'abstract rules' ( rules += AbstractRule ) + 'end'
protected class Start_Group extends GroupToken {
	
	public Start_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Start_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Start_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'abstract rules' ( rules += AbstractRule ) +
protected class Start_0_Group extends GroupToken {
	
	public Start_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Start_0_1_Assignment_rules(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Start_0_0_Keyword_abstractrules(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'abstract rules'
protected class Start_0_0_Keyword_abstractrules extends KeywordToken  {
	
	public Start_0_0_Keyword_abstractrules(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}	
}

// ( rules += AbstractRule ) +
protected class Start_0_1_Assignment_rules extends AssignmentToken  {
	
	public Start_0_1_Assignment_rules(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rules",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rules");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				Solution s = new AbstractRule_Alternatives(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// 'end'
protected class Start_1_Keyword_end extends KeywordToken  {
	
	public Start_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Start ****************/

/************ begin Rule AbstractRule ****************
 *
 * AbstractRule : FirstAbstractRuleChild | SecondAbstractRuleChild ;
 *
 **/


// FirstAbstractRuleChild | SecondAbstractRuleChild
protected class AbstractRule_Alternatives extends AlternativesToken {

	public AbstractRule_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives");
	}
	
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
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(FirstAbstractRuleChild_Group.class, current)) return null;
		if(!current.isInstanceOf("FirstAbstractRuleChild")) return null;
		return new FirstAbstractRuleChild_Group(current, this).firstSolution();
	}
}

// SecondAbstractRuleChild
protected class AbstractRule_1_RuleCall_SecondAbstractRuleChild extends RuleCallToken {
	
	public AbstractRule_1_RuleCall_SecondAbstractRuleChild(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(SecondAbstractRuleChild_Group.class, current)) return null;
		if(!current.isInstanceOf("SecondAbstractRuleChild")) return null;
		return new SecondAbstractRuleChild_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractRule ****************/

/************ begin Rule FirstAbstractRuleChild ****************
 *
 * FirstAbstractRuleChild : name = ID '(' ( elements += AbstractRule ) + ')' ';' ;
 *
 **/


// name = ID '(' ( elements += AbstractRule ) + ')' ';'
protected class FirstAbstractRuleChild_Group extends GroupToken {
	
	public FirstAbstractRuleChild_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID '(' ( elements += AbstractRule ) + ')'
protected class FirstAbstractRuleChild_0_Group extends GroupToken {
	
	public FirstAbstractRuleChild_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID '(' ( elements += AbstractRule ) +
protected class FirstAbstractRuleChild_0_0_Group extends GroupToken {
	
	public FirstAbstractRuleChild_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_0_0_1_Assignment_elements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID '('
protected class FirstAbstractRuleChild_0_0_0_Group extends GroupToken {
	
	public FirstAbstractRuleChild_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstAbstractRuleChild_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstAbstractRuleChild_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID
protected class FirstAbstractRuleChild_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public FirstAbstractRuleChild_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// '('
protected class FirstAbstractRuleChild_0_0_0_1_Keyword extends KeywordToken  {
	
	public FirstAbstractRuleChild_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( elements += AbstractRule ) +
protected class FirstAbstractRuleChild_0_0_1_Assignment_elements extends AssignmentToken  {
	
	public FirstAbstractRuleChild_0_0_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				Solution s = new AbstractRule_Alternatives(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// ')'
protected class FirstAbstractRuleChild_0_1_Keyword extends KeywordToken  {
	
	public FirstAbstractRuleChild_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ';'
protected class FirstAbstractRuleChild_1_Keyword extends KeywordToken  {
	
	public FirstAbstractRuleChild_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule FirstAbstractRuleChild ****************/

/************ begin Rule SecondAbstractRuleChild ****************
 *
 * SecondAbstractRuleChild : name = ID 'rule' ':' rule = AbstractRuleCall ';' ;
 *
 **/


// name = ID 'rule' ':' rule = AbstractRuleCall ';'
protected class SecondAbstractRuleChild_Group extends GroupToken {
	
	public SecondAbstractRuleChild_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID 'rule' ':' rule = AbstractRuleCall
protected class SecondAbstractRuleChild_0_Group extends GroupToken {
	
	public SecondAbstractRuleChild_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_0_1_Assignment_rule(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID 'rule' ':'
protected class SecondAbstractRuleChild_0_0_Group extends GroupToken {
	
	public SecondAbstractRuleChild_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID 'rule'
protected class SecondAbstractRuleChild_0_0_0_Group extends GroupToken {
	
	public SecondAbstractRuleChild_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondAbstractRuleChild_0_0_0_1_Keyword_rule(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondAbstractRuleChild_0_0_0_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID
protected class SecondAbstractRuleChild_0_0_0_0_Assignment_name extends AssignmentToken  {
	
	public SecondAbstractRuleChild_0_0_0_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// 'rule'
protected class SecondAbstractRuleChild_0_0_0_1_Keyword_rule extends KeywordToken  {
	
	public SecondAbstractRuleChild_0_0_0_1_Keyword_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ':'
protected class SecondAbstractRuleChild_0_0_1_Keyword extends KeywordToken  {
	
	public SecondAbstractRuleChild_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// rule = AbstractRuleCall
protected class SecondAbstractRuleChild_0_1_Assignment_rule extends AssignmentToken  {
	
	public SecondAbstractRuleChild_0_1_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRuleCall")) {
				Solution s = new AbstractRuleCall_Assignment_rule(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// ';'
protected class SecondAbstractRuleChild_1_Keyword extends KeywordToken  {
	
	public SecondAbstractRuleChild_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule SecondAbstractRuleChild ****************/

/************ begin Rule AbstractRuleCall ****************
 *
 * AbstractRuleCall : rule = [ AbstractRule ] ;
 *
 **/


// rule = [ AbstractRule ]
protected class AbstractRuleCall_Assignment_rule extends AssignmentToken  {
	
	public AbstractRuleCall_Assignment_rule(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("rule",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rule");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractRule")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4/@alternatives/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

/************ end Rule AbstractRuleCall ****************/

}
