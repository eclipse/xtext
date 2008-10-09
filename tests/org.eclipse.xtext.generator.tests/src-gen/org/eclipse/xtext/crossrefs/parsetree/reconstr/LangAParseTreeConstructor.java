/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class LangAParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Main") && (s = new Main_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Import") && (s = new Import_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Type") && (s = new Type_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Main ****************
 *
 * Main : ( imports += Import ) * ( types += Type ) * ;
 *
 **/


// ( imports += Import ) * ( types += Type ) *
protected class Main_Group extends GroupToken {
	
	public Main_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Main_1_Assignment_types(current, this).firstSolution();
		if(s1 == null) return null;
		return new Main_0_Assignment_imports(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// ( imports += Import ) *
protected class Main_0_Assignment_imports extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal");
	protected Object value;
	
	public Main_0_Assignment_imports(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("imports")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("imports");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Import")) return null;
		AbstractToken t = new Import_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Main_0_Assignment_importsCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Import
	}
}

// ( types += Type ) *
protected class Main_1_Assignment_types extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Main_1_Assignment_types(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("types")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("types");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Type")) return null;
		AbstractToken t = new Type_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Main_1_Assignment_typesCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Type
	}
}


/************ end Rule Main ****************/

/************ begin Rule Import ****************
 *
 * Import : 'import' uri = STRING ;
 *
 **/


// 'import' uri = STRING
protected class Import_Group extends GroupToken {
	
	public Import_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Import_1_Assignment_uri(current, this).firstSolution();
		if(s1 == null) return null;
		return new Import_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'import'
protected class Import_0_Keyword_import extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	
	public Import_0_Keyword_import(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// uri = STRING
protected class Import_1_Assignment_uri extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Import_1_Assignment_uri(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("uri")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("uri");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Import_1_Assignment_uriCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


/************ end Rule Import ****************/

/************ begin Rule Type ****************
 *
 * Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
 *
 **/


// 'type' name = ID 'extends' ^extends = [ Type ]
protected class Type_Group extends GroupToken {
	
	public Type_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Type_1_Assignment_extends(current, this).firstSolution();
		if(s1 == null) return null;
		return new Type_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'type' name = ID 'extends'
protected class Type_0_Group extends GroupToken {
	
	public Type_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Type_0_1_Keyword_extends(current, this).firstSolution();
		if(s1 == null) return null;
		return new Type_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'type' name = ID
protected class Type_0_0_Group extends GroupToken {
	
	public Type_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Type_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Type_0_0_0_Keyword_type(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'type'
protected class Type_0_0_0_Keyword_type extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Type_0_0_0_Keyword_type(InstanceDescription curr, AbstractToken pred) {
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
protected class Type_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Type_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Type_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// 'extends'
protected class Type_0_1_Keyword_extends extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Type_0_1_Keyword_extends(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// ^extends = [ Type ]
protected class Type_1_Assignment_extends extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Type_1_Assignment_extends(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("extends")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("extends");
		// handling xtext::CrossReference
		// FIXME: doing nothing for xtext::CrossReference
		return null;
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Type_1_Assignment_extendsCallback(\"xtext::CrossReference\", " + value + ")");
		// FIXME: doing nothing for xtext::CrossReference
	}
}


/************ end Rule Type ****************/

}
