/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class LookaheadLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "Couldn't find rule '"+ruleToCall+"'");
		callback.beginSerialize();
		t.getPredecessor().executeAllCallbacks(callback);
		callback.endSerialize();
		System.out.println("success!");
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if((s = new Entry_Assignment_contents(inst, null).firstSolution()) != null) return s;
		if((s = new Alts_Alternatives(inst, null).firstSolution()) != null) return s;
		if((s = new LookAhead0_Group(inst, null).firstSolution()) != null) return s;
		if((s = new LookAhead1_Group(inst, null).firstSolution()) != null) return s;
		if((s = new LookAhead2_Group(inst, null).firstSolution()) != null) return s;
		if((s = new LookAhead3_Group(inst, null).firstSolution()) != null) return s;
		if((s = new LookAhead4_Alternatives(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Entry ****************/


protected class Entry_Assignment_contents extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.0/@alternatives/@terminal");
	protected Object value;
	
	public Entry_Assignment_contents(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("contents")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("contents");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Alts")) return null;
		AbstractToken t = new Alts_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Entry_Assignment_contentsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Alts
	}
}

/************ end Rule Entry ****************/
/************ begin Rule Alts ****************/


protected class Alts_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Alts_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Alts_1_RuleCall_LookAhead3(current, this) : new Alts_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class Alts_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Alts_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Alts_0_1_RuleCall_LookAhead1(current, this) : new Alts_0_0_RuleCall_LookAhead0(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class Alts_0_0_RuleCall_LookAhead0 extends RuleCallToken {
	
	public Alts_0_0_RuleCall_LookAhead0(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(LookAhead0_Group.class, current)) return null;
		if(!current.isInstanceOf("LookAhead0")) return null;
		return new LookAhead0_Group(current, this).firstSolution();
	}
}

protected class Alts_0_1_RuleCall_LookAhead1 extends RuleCallToken {
	
	public Alts_0_1_RuleCall_LookAhead1(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(LookAhead1_Group.class, current)) return null;
		if(!current.isInstanceOf("LookAhead1")) return null;
		return new LookAhead1_Group(current, this).firstSolution();
	}
}


protected class Alts_1_RuleCall_LookAhead3 extends RuleCallToken {
	
	public Alts_1_RuleCall_LookAhead3(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(LookAhead3_Group.class, current)) return null;
		if(!current.isInstanceOf("LookAhead3")) return null;
		return new LookAhead3_Group(current, this).firstSolution();
	}
}


/************ end Rule Alts ****************/
/************ begin Rule LookAhead0 ****************/


protected class LookAhead0_Group extends GroupToken {
	
	public LookAhead0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead0_1_Assignment_x(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead0_0_Keyword_bar(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}


protected class LookAhead0_0_Keyword_bar extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0");
	
	public LookAhead0_0_Keyword_bar(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

protected class LookAhead0_1_Assignment_x extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LookAhead0_1_Assignment_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("x")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("x");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead0_1_Assignment_xCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}


/************ end Rule LookAhead0 ****************/
/************ begin Rule LookAhead1 ****************/


protected class LookAhead1_Group extends GroupToken {
	
	public LookAhead1_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead1_1_Assignment_x(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class LookAhead1_0_Group extends GroupToken {
	
	public LookAhead1_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead1_0_1_Assignment_x(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class LookAhead1_0_0_Group extends GroupToken {
	
	public LookAhead1_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead1_0_0_1_Assignment_y(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead1_0_0_0_Keyword_foo(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}


protected class LookAhead1_0_0_0_Keyword_foo extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public LookAhead1_0_0_0_Keyword_foo(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

protected class LookAhead1_0_0_1_Assignment_y extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LookAhead1_0_0_1_Assignment_y(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("y")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("y");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("LookAhead2")) return null;
		AbstractToken t = new LookAhead2_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead1_0_0_1_Assignment_yCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call LookAhead2
	}
}


protected class LookAhead1_0_1_Assignment_x extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LookAhead1_0_1_Assignment_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("x")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("x");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead1_0_1_Assignment_xCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}


protected class LookAhead1_1_Assignment_x extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LookAhead1_1_Assignment_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("x")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("x");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead1_1_Assignment_xCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}


/************ end Rule LookAhead1 ****************/
/************ begin Rule LookAhead2 ****************/


protected class LookAhead2_Group extends GroupToken {
	
	public LookAhead2_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead2_1_Keyword_c(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead2_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class LookAhead2_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public LookAhead2_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new LookAhead2_0_1_Assignment_z(current, this) : new LookAhead2_0_0_Assignment_z(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class LookAhead2_0_0_Assignment_z extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@groups.0/@terminal");
	protected Object value;
	
	public LookAhead2_0_0_Assignment_z(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("z")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("z");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead2_0_0_Assignment_zCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}

protected class LookAhead2_0_1_Assignment_z extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@groups.1/@terminal");
	protected Object value;
	
	public LookAhead2_0_1_Assignment_z(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("z")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("z");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead2_0_1_Assignment_zCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}



protected class LookAhead2_1_Keyword_c extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1");
	
	public LookAhead2_1_Keyword_c(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule LookAhead2 ****************/
/************ begin Rule LookAhead3 ****************/


protected class LookAhead3_Group extends GroupToken {
	
	public LookAhead3_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead3_1_Assignment_z(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead3_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class LookAhead3_0_Group extends GroupToken {
	
	public LookAhead3_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead3_0_1_Assignment_x(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead3_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

protected class LookAhead3_0_0_Group extends GroupToken {
	
	public LookAhead3_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new LookAhead3_0_0_1_Keyword_bar(current, this).firstSolution();
		if(s1 == null) return null;
		return new LookAhead3_0_0_0_Keyword_foo(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}


protected class LookAhead3_0_0_0_Keyword_foo extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public LookAhead3_0_0_0_Keyword_foo(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


protected class LookAhead3_0_0_1_Keyword_bar extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public LookAhead3_0_0_1_Keyword_bar(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


protected class LookAhead3_0_1_Assignment_x extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LookAhead3_0_1_Assignment_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("x")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("x");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead3_0_1_Assignment_xCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}


protected class LookAhead3_1_Assignment_z extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public LookAhead3_1_Assignment_z(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("z")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("z");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("LookAhead4")) return null;
		AbstractToken t = new LookAhead4_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead3_1_Assignment_zCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call LookAhead4
	}
}


/************ end Rule LookAhead3 ****************/
/************ begin Rule LookAhead4 ****************/


protected class LookAhead4_Alternatives extends GroupToken {
	
	private boolean first = true;

	public LookAhead4_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new LookAhead4_1_Assignment_x(current, this) : new LookAhead4_0_Assignment_x(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

protected class LookAhead4_0_Assignment_x extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.6/@alternatives/@groups.0/@terminal");
	protected Object value;
	
	public LookAhead4_0_Assignment_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("x")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("x");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead4_0_Assignment_xCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}

protected class LookAhead4_1_Assignment_x extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.6/@alternatives/@groups.1/@terminal");
	protected Object value;
	
	public LookAhead4_1_Assignment_x(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("x")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("x");
		// handling xtext::Keyword
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("LookAhead4_1_Assignment_xCallback(\"xtext::Keyword\", " + value + ")");
		callback.keywordCall(current, (Keyword)element);
	}
}


/************ end Rule LookAhead4 ****************/
}
