/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.core.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class TestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("File") && (s = new File_Assignment_stuff(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Stuff") && (s = new Stuff_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule File ****************
 *
 * File : ( stuff += Stuff ) * ;
 *
 **/


// ( stuff += Stuff ) *
protected class File_Assignment_stuff extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public File_Assignment_stuff(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("stuff")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("stuff");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Stuff")) return null;
		AbstractToken t = new Stuff_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("File_Assignment_stuffCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Stuff
	}
}

/************ end Rule File ****************/

/************ begin Rule Stuff ****************
 *
 * Stuff : 'stuff' name = ID ;
 *
 **/


// 'stuff' name = ID
protected class Stuff_Group extends GroupToken {
	
	public Stuff_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Stuff_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Stuff_0_Keyword_stuff(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'stuff'
protected class Stuff_0_Keyword_stuff extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	
	public Stuff_0_Keyword_stuff(InstanceDescription curr, AbstractToken pred) {
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
protected class Stuff_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Stuff_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("name")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("name");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Stuff_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule Stuff ****************/

}
