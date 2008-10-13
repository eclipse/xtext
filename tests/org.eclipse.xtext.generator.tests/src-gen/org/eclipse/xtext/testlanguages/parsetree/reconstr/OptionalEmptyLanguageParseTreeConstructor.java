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


public class OptionalEmptyLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Model") && (s = new Model_Assignment_child(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Greeting") && (s = new Greeting_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Model ****************
 *
 * Model : ( child = Greeting ) ? ;
 *
 **/


// ( child = Greeting ) ?
protected class Model_Assignment_child extends AssignmentToken  {
	
	public Model_Assignment_child(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("child",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("child");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Greeting")) {
				Solution s = new Greeting_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}

/************ end Rule Model ****************/

/************ begin Rule Greeting ****************
 *
 * Greeting : 'hallo' name = ID ;
 *
 **/


// 'hallo' name = ID
protected class Greeting_Group extends GroupToken {
	
	public Greeting_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
		
	protected Solution createSolution() {
		Solution s1 = new Greeting_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Greeting_0_Keyword_hallo(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'hallo'
protected class Greeting_0_Keyword_hallo extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	
	public Greeting_0_Keyword_hallo(IInstanceDescription curr, AbstractToken pred) {
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
protected class Greeting_1_Assignment_name extends AssignmentToken  {
	
	public Greeting_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Greeting ****************/

}
