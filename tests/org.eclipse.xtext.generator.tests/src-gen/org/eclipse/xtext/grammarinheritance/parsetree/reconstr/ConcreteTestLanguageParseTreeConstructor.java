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


public class ConcreteTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("ConcreteParserRule") && (s = new ConcreteParserRule_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("mm::AType") && (s = new InheritedParserRule_Group(inst, null).firstSolution()) != null) return s;
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
		
	protected Solution createSolution() {
		Solution s1 = new ConcreteParserRule_1_Assignment_elements(current, this).firstSolution();
		if(s1 == null) return null;
		return new ConcreteParserRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'model' magicNumber = REAL ':'
protected class ConcreteParserRule_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new ConcreteParserRule_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new ConcreteParserRule_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'model' magicNumber = REAL
protected class ConcreteParserRule_0_0_Group extends GroupToken {
	
	public ConcreteParserRule_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new ConcreteParserRule_0_0_1_Assignment_magicNumber(current, this).firstSolution();
		if(s1 == null) return null;
		return new ConcreteParserRule_0_0_0_Keyword_model(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'model'
protected class ConcreteParserRule_0_0_0_Keyword_model extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public ConcreteParserRule_0_0_0_Keyword_model(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// magicNumber = REAL
protected class ConcreteParserRule_0_0_1_Assignment_magicNumber extends AssignmentToken  {
	
	public ConcreteParserRule_0_0_1_Assignment_magicNumber(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("magicNumber",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("magicNumber");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ':'
protected class ConcreteParserRule_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public ConcreteParserRule_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// ( elements += InheritedParserRule ) *
protected class ConcreteParserRule_1_Assignment_elements extends AssignmentToken  {
	
	public ConcreteParserRule_1_Assignment_elements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("elements",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elements");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("mm::AType")) {
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
 * InheritedParserRule returns mm :: AType : 'element' name = ID ;
 *
 **/


// 'element' name = ID
protected class InheritedParserRule_Group extends GroupToken {
	
	public InheritedParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new InheritedParserRule_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new InheritedParserRule_0_Keyword_element(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'element'
protected class InheritedParserRule_0_Keyword_element extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	
	public InheritedParserRule_0_Keyword_element(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// name = ID
protected class InheritedParserRule_1_Assignment_name extends AssignmentToken  {
	
	public InheritedParserRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule InheritedParserRule ****************/

}
