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


public class ReferenceGrammarParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Spielplatz") && (s = new Spielplatz_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Person") && (s = new Person_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Kind") && (s = new Kind_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Erwachsener") && (s = new Erwachsener_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Spielzeug") && (s = new Spielzeug_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Farbe") && (s = new Farbe_Alternatives(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Spielplatz ****************
 *
 * Spielplatz : ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug ) * '}' ) ? ;
 *
 **/


// ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug ) * '}' ) ?
protected class Spielplatz_Group extends GroupToken {
	
	public Spielplatz_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug ) *
protected class Spielplatz_0_Group extends GroupToken {
	
	public Spielplatz_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{'
protected class Spielplatz_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielplatz' groesse = INT ( beschreibung = STRING ) ?
protected class Spielplatz_0_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_0_0_1_Assignment_beschreibung(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielplatz' groesse = INT
protected class Spielplatz_0_0_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_0_0_0_1_Assignment_groesse(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_0_0_0_Keyword_spielplatz(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielplatz'
protected class Spielplatz_0_0_0_0_0_Keyword_spielplatz extends KeywordToken  {
	
	public Spielplatz_0_0_0_0_0_Keyword_spielplatz(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// groesse = INT
protected class Spielplatz_0_0_0_0_1_Assignment_groesse extends AssignmentToken  {
	
	public Spielplatz_0_0_0_0_1_Assignment_groesse(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("groesse",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("groesse");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( beschreibung = STRING ) ?
protected class Spielplatz_0_0_0_1_Assignment_beschreibung extends AssignmentToken  {
	
	public Spielplatz_0_0_0_1_Assignment_beschreibung(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("beschreibung",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("beschreibung");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// '{'
protected class Spielplatz_0_0_1_Keyword extends KeywordToken  {
	
	public Spielplatz_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug ) *
protected class Spielplatz_0_1_Alternatives extends AlternativesToken {

	public Spielplatz_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Spielplatz_0_1_1_Assignment_spielzeuge(current, this) : new Spielplatz_0_1_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// kinder += Kind | erzieher += Erwachsener
protected class Spielplatz_0_1_0_Alternatives extends AlternativesToken {

	public Spielplatz_0_1_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Spielplatz_0_1_0_1_Assignment_erzieher(current, this) : new Spielplatz_0_1_0_0_Assignment_kinder(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// kinder += Kind
protected class Spielplatz_0_1_0_0_Assignment_kinder extends AssignmentToken  {
	
	public Spielplatz_0_1_0_0_Assignment_kinder(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("kinder",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("kinder");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Kind")) {
				Solution s = new Kind_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}

// erzieher += Erwachsener
protected class Spielplatz_0_1_0_1_Assignment_erzieher extends AssignmentToken  {
	
	public Spielplatz_0_1_0_1_Assignment_erzieher(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("erzieher",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("erzieher");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Erwachsener")) {
				Solution s = new Erwachsener_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// spielzeuge += Spielzeug
protected class Spielplatz_0_1_1_Assignment_spielzeuge extends AssignmentToken  {
	
	public Spielplatz_0_1_1_Assignment_spielzeuge(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("spielzeuge",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("spielzeuge");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Spielzeug")) {
				Solution s = new Spielzeug_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}



// '}'
protected class Spielplatz_1_Keyword extends KeywordToken  {
	
	public Spielplatz_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Spielplatz ****************/

/************ begin Rule Person ****************
 *
 * Person : Kind | Erwachsener ;
 *
 **/


// Kind | Erwachsener
protected class Person_Alternatives extends AlternativesToken {

	public Person_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.1/@alternatives");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Person_1_RuleCall_Erwachsener(current, this) : new Person_0_RuleCall_Kind(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Kind
protected class Person_0_RuleCall_Kind extends RuleCallToken {
	
	public Person_0_RuleCall_Kind(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.1/@alternatives/@groups.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Kind_Group.class, current)) return null;
		if(!current.isInstanceOf("Kind")) return null;
		return new Kind_Group(current, this).firstSolution();
	}
}

// Erwachsener
protected class Person_1_RuleCall_Erwachsener extends RuleCallToken {
	
	public Person_1_RuleCall_Erwachsener(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.1/@alternatives/@groups.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Erwachsener_Group.class, current)) return null;
		if(!current.isInstanceOf("Erwachsener")) return null;
		return new Erwachsener_Group(current, this).firstSolution();
	}
}


/************ end Rule Person ****************/

/************ begin Rule Kind ****************
 *
 * Kind : 'kind' '(' name = ID age = INT ')' ;
 *
 **/


// 'kind' '(' name = ID age = INT ')'
protected class Kind_Group extends GroupToken {
	
	public Kind_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Kind_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'kind' '(' name = ID age = INT
protected class Kind_0_Group extends GroupToken {
	
	public Kind_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Kind_0_1_Assignment_age(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'kind' '(' name = ID
protected class Kind_0_0_Group extends GroupToken {
	
	public Kind_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Kind_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'kind' '('
protected class Kind_0_0_0_Group extends GroupToken {
	
	public Kind_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Kind_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_0_0_0_Keyword_kind(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'kind'
protected class Kind_0_0_0_0_Keyword_kind extends KeywordToken  {
	
	public Kind_0_0_0_0_Keyword_kind(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// '('
protected class Kind_0_0_0_1_Keyword extends KeywordToken  {
	
	public Kind_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// name = ID
protected class Kind_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Kind_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// age = INT
protected class Kind_0_1_Assignment_age extends AssignmentToken  {
	
	public Kind_0_1_Assignment_age(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("age",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("age");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ')'
protected class Kind_1_Keyword extends KeywordToken  {
	
	public Kind_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Kind ****************/

/************ begin Rule Erwachsener ****************
 *
 * Erwachsener : 'erwachsener' '(' name = ID age = INT ')' ;
 *
 **/


// 'erwachsener' '(' name = ID age = INT ')'
protected class Erwachsener_Group extends GroupToken {
	
	public Erwachsener_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'erwachsener' '(' name = ID age = INT
protected class Erwachsener_0_Group extends GroupToken {
	
	public Erwachsener_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_0_1_Assignment_age(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'erwachsener' '(' name = ID
protected class Erwachsener_0_0_Group extends GroupToken {
	
	public Erwachsener_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'erwachsener' '('
protected class Erwachsener_0_0_0_Group extends GroupToken {
	
	public Erwachsener_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_0_0_0_Keyword_erwachsener(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'erwachsener'
protected class Erwachsener_0_0_0_0_Keyword_erwachsener extends KeywordToken  {
	
	public Erwachsener_0_0_0_0_Keyword_erwachsener(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// '('
protected class Erwachsener_0_0_0_1_Keyword extends KeywordToken  {
	
	public Erwachsener_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// name = ID
protected class Erwachsener_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Erwachsener_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// age = INT
protected class Erwachsener_0_1_Assignment_age extends AssignmentToken  {
	
	public Erwachsener_0_1_Assignment_age(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("age",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("age");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ')'
protected class Erwachsener_1_Keyword extends KeywordToken  {
	
	public Erwachsener_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Erwachsener ****************/

/************ begin Rule Spielzeug ****************
 *
 * Spielzeug : 'spielzeug' '(' name = ID farbe = Farbe ')' ;
 *
 **/


// 'spielzeug' '(' name = ID farbe = Farbe ')'
protected class Spielzeug_Group extends GroupToken {
	
	public Spielzeug_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielzeug' '(' name = ID farbe = Farbe
protected class Spielzeug_0_Group extends GroupToken {
	
	public Spielzeug_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_0_1_Assignment_farbe(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielzeug' '(' name = ID
protected class Spielzeug_0_0_Group extends GroupToken {
	
	public Spielzeug_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielzeug' '('
protected class Spielzeug_0_0_0_Group extends GroupToken {
	
	public Spielzeug_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_0_0_0_Keyword_spielzeug(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'spielzeug'
protected class Spielzeug_0_0_0_0_Keyword_spielzeug extends KeywordToken  {
	
	public Spielzeug_0_0_0_0_Keyword_spielzeug(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// '('
protected class Spielzeug_0_0_0_1_Keyword extends KeywordToken  {
	
	public Spielzeug_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// name = ID
protected class Spielzeug_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Spielzeug_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// farbe = Farbe
protected class Spielzeug_0_1_Assignment_farbe extends AssignmentToken  {
	
	public Spielzeug_0_1_Assignment_farbe(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("farbe",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("farbe");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Farbe")) {
				Solution s = new Farbe_Alternatives(param, this).firstSolution();
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
protected class Spielzeug_1_Keyword extends KeywordToken  {
	
	public Spielzeug_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Spielzeug ****************/

/************ begin Rule Farbe ****************
 *
 * Farbe : 'ROT' | 'BLAU' | 'GELB' | 'GRÜN' ;
 *
 **/


// 'ROT' | 'BLAU' | 'GELB' | 'GRÜN'
protected class Farbe_Alternatives extends AlternativesToken {

	public Farbe_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Farbe_1_Keyword_GRN(current, this) : new Farbe_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// 'ROT' | 'BLAU' | 'GELB'
protected class Farbe_0_Alternatives extends AlternativesToken {

	public Farbe_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Farbe_0_1_Keyword_GELB(current, this) : new Farbe_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// 'ROT' | 'BLAU'
protected class Farbe_0_0_Alternatives extends AlternativesToken {

	public Farbe_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Farbe_0_0_1_Keyword_BLAU(current, this) : new Farbe_0_0_0_Keyword_ROT(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// 'ROT'
protected class Farbe_0_0_0_Keyword_ROT extends KeywordToken  {
	
	public Farbe_0_0_0_Keyword_ROT(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.0");
	}	
}

// 'BLAU'
protected class Farbe_0_0_1_Keyword_BLAU extends KeywordToken  {
	
	public Farbe_0_0_1_Keyword_BLAU(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.1");
	}	
}


// 'GELB'
protected class Farbe_0_1_Keyword_GELB extends KeywordToken  {
	
	public Farbe_0_1_Keyword_GELB(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.1");
	}	
}


// 'GRÜN'
protected class Farbe_1_Keyword_GRN extends KeywordToken  {
	
	public Farbe_1_Keyword_GRN(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.1");
	}	
}


/************ end Rule Farbe ****************/

}
