/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parsetree.reconstr;

//import org.apache.log4j.Logger;
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
		IInstanceDescription inst = getDescr(obj);
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
	
	public Main_Group(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Main_0_Assignment_imports(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("imports",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("imports");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Import")) {
				Solution s = new Import_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}

// ( types += Type ) *
protected class Main_1_Assignment_types extends AssignmentToken  {
	
	public Main_1_Assignment_types(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("types",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("types");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Type")) {
				Solution s = new Type_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
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
	
	public Import_Group(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Import_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Import_1_Assignment_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("uri",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("uri");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
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
	
	public Type_Group(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Type_0_Group(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Type_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Type_0_0_0_Keyword_type(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Type_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// 'extends'
protected class Type_0_1_Keyword_extends extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1");
	
	public Type_0_1_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
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
	
	public Type_1_Assignment_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("extends",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("extends");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Type")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


/************ end Rule Type ****************/

}
