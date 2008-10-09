/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


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
		if(inst.isInstanceOf("Model") && (s = new EntryRule_Assignment_multiFeature(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("AbstractElement") && (s = new AbstractRule_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("ChoiceElement") && (s = new ChoiceRule_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("ReducibleElement") && (s = new ReducibleRule_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("TerminalElement") && (s = new TerminalRule_Assignment_stringFeature(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule EntryRule ****************
 *
 * EntryRule returns Model : ( multiFeature += AbstractRule ) * ;
 *
 **/


// ( multiFeature += AbstractRule ) *
protected class EntryRule_Assignment_multiFeature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public EntryRule_Assignment_multiFeature(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("multiFeature")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("multiFeature");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("AbstractElement")) return null;
		AbstractToken t = new AbstractRule_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("EntryRule_Assignment_multiFeatureCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call AbstractRule
	}
}

/************ end Rule EntryRule ****************/

/************ begin Rule AbstractRule ****************
 *
 * AbstractRule returns AbstractElement : ChoiceRule | ReducibleRule ;
 *
 **/


// ChoiceRule | ReducibleRule
protected class AbstractRule_Alternatives extends GroupToken {
	
	private boolean first = true;

	public AbstractRule_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected boolean activateNextSolution() {
		if(first) {
			first = false;
			return true;
		}
		return false;
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractRule_1_RuleCall_ReducibleRule(current, this) : new AbstractRule_0_RuleCall_ChoiceRule(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// ChoiceRule
protected class AbstractRule_0_RuleCall_ChoiceRule extends RuleCallToken {
	
	public AbstractRule_0_RuleCall_ChoiceRule(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(ChoiceRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ChoiceElement")) return null;
		return new ChoiceRule_Group(current, this).firstSolution();
	}
}

// ReducibleRule
protected class AbstractRule_1_RuleCall_ReducibleRule extends RuleCallToken {
	
	public AbstractRule_1_RuleCall_ReducibleRule(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(ReducibleRule_Group.class, current)) return null;
		if(!current.isInstanceOf("ReducibleElement")) return null;
		return new ReducibleRule_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractRule ****************/

/************ begin Rule ChoiceRule ****************
 *
 * ChoiceRule returns ChoiceElement : 'choice' ( optionalKeyword ?= 'optional' ) ? name = ID ;
 *
 **/


// 'choice' ( optionalKeyword ?= 'optional' ) ? name = ID
protected class ChoiceRule_Group extends GroupToken {
	
	public ChoiceRule_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ChoiceRule_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new ChoiceRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'choice' ( optionalKeyword ?= 'optional' ) ?
protected class ChoiceRule_0_Group extends GroupToken {
	
	public ChoiceRule_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ChoiceRule_0_1_Assignment_optionalKeyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new ChoiceRule_0_0_Keyword_choice(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'choice'
protected class ChoiceRule_0_0_Keyword_choice extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ChoiceRule_0_0_Keyword_choice(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// ( optionalKeyword ?= 'optional' ) ?
protected class ChoiceRule_0_1_Assignment_optionalKeyword extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ChoiceRule_0_1_Assignment_optionalKeyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("optionalKeyword")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("optionalKeyword");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ChoiceRule_0_1_Assignment_optionalKeywordCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}


// name = ID
protected class ChoiceRule_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ChoiceRule_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("ChoiceRule_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule ChoiceRule ****************/

/************ begin Rule ReducibleRule ****************
 *
 * ReducibleRule returns ReducibleElement : 'reducible' TerminalRule ( { current = ReducibleComposite . actionFeature += current } actionFeature += TerminalRule ) ? ;
 *
 **/


// 'reducible' TerminalRule ( { current = ReducibleComposite . actionFeature += current } actionFeature += TerminalRule ) ?
protected class ReducibleRule_Group extends GroupToken {
	
	public ReducibleRule_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ReducibleRule_1_Group(current, this).firstSolution();
		if(s1 == null) return null;
		return new ReducibleRule_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'reducible' TerminalRule
protected class ReducibleRule_0_Group extends GroupToken {
	
	public ReducibleRule_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ReducibleRule_0_1_RuleCall_TerminalRule(current, this).firstSolution();
		if(s1 == null) return null;
		return new ReducibleRule_0_0_Keyword_reducible(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'reducible'
protected class ReducibleRule_0_0_Keyword_reducible extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0");
	
	public ReducibleRule_0_0_Keyword_reducible(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// TerminalRule
protected class ReducibleRule_0_1_RuleCall_TerminalRule extends RuleCallToken {
	
	public ReducibleRule_0_1_RuleCall_TerminalRule(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(TerminalRule_Assignment_stringFeature.class, current)) return null;
		if(!current.isInstanceOf("TerminalElement")) return null;
		return new TerminalRule_Assignment_stringFeature(current, this).firstSolution();
	}
}


// ( { current = ReducibleComposite . actionFeature += current } actionFeature += TerminalRule ) ?
protected class ReducibleRule_1_Group extends GroupToken {
	
	public ReducibleRule_1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new ReducibleRule_1_1_Assignment_actionFeature(current, this).firstSolution();
		if(s1 == null) return null;
		return new ReducibleRule_1_0_Action_ReducibleComposite_actionFeature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// { current = ReducibleComposite . actionFeature += current }
protected class ReducibleRule_1_0_Action_ReducibleComposite_actionFeature extends AssignmentToken  {

	public ReducibleRule_1_0_Action_ReducibleComposite_actionFeature(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isInstanceOf("ReducibleComposite")) return null;
		if(!current.isConsumable("actionFeature")) return null;
		IInstanceDescription obj = current.createClone();
		Object val = obj.consume("actionFeature");
		if(!obj.isConsumed()) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// actionFeature += TerminalRule
protected class ReducibleRule_1_1_Assignment_actionFeature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal");
	protected Object value;
	
	public ReducibleRule_1_1_Assignment_actionFeature(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("actionFeature")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("actionFeature");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("TerminalElement")) return null;
		AbstractToken t = new TerminalRule_Assignment_stringFeature(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("ReducibleRule_1_1_Assignment_actionFeatureCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call TerminalRule
	}
}



/************ end Rule ReducibleRule ****************/

/************ begin Rule TerminalRule ****************
 *
 * TerminalRule returns TerminalElement : stringFeature = STRING ;
 *
 **/


// stringFeature = STRING
protected class TerminalRule_Assignment_stringFeature extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@rules.4/@alternatives/@terminal");
	protected Object value;
	
	public TerminalRule_Assignment_stringFeature(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("stringFeature")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("stringFeature");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("TerminalRule_Assignment_stringFeatureCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}

/************ end Rule TerminalRule ****************/

}
