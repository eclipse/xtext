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
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.crossrefs.services.LangATestLanguageGrammarAccess;


public class LangATestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
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
	
	public Group getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prMain().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Main_1_Assignment_types(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Main_0_Assignment_imports(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( imports += Import ) *
protected class Main_0_Assignment_imports extends AssignmentToken  {
	
	public Main_0_Assignment_imports(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prMain().ele0AssignmentImports();
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
	
	public Assignment getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prMain().ele1AssignmentTypes();
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
	
	public Group getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prImport().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Import_1_Assignment_uri(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Import_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'import'
protected class Import_0_Keyword_import extends KeywordToken  {
	
	public Import_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prImport().ele0KeywordImport();
	}	
}

// uri = STRING
protected class Import_1_Assignment_uri extends AssignmentToken  {
	
	public Import_1_Assignment_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prImport().ele1AssignmentUri();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("uri",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("uri");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = LangATestLanguageGrammarAccess.INSTANCE.prImport().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Import ****************/

/************ begin Rule Type ****************
 *
 * (error)
 *
 **/


// (error)
protected class Type_Group extends GroupToken {
	
	public Type_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prType().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Type_1_Assignment_extends(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Type_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'type' name = ID 'extends'
protected class Type_0_Group extends GroupToken {
	
	public Type_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prType().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Type_0_1_Keyword_extends(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Type_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'type' name = ID
protected class Type_0_0_Group extends GroupToken {
	
	public Type_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prType().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Type_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Type_0_0_0_Keyword_type(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'type'
protected class Type_0_0_0_Keyword_type extends KeywordToken  {
	
	public Type_0_0_0_Keyword_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prType().ele000KeywordType();
	}	
}

// name = ID
protected class Type_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Type_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prType().ele001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = LangATestLanguageGrammarAccess.INSTANCE.prType().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// 'extends'
protected class Type_0_1_Keyword_extends extends KeywordToken  {
	
	public Type_0_1_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prType().ele01KeywordExtends();
	}	
}


// (error)
protected class Type_1_Assignment_extends extends AssignmentToken  {
	
	public Type_1_Assignment_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return LangATestLanguageGrammarAccess.INSTANCE.prType().ele1AssignmentExtends();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("extends",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("extends");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Type")) {
				type = AssignmentType.CR;
				element = LangATestLanguageGrammarAccess.INSTANCE.prType().ele10CrossReferenceType(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


/************ end Rule Type ****************/

}
