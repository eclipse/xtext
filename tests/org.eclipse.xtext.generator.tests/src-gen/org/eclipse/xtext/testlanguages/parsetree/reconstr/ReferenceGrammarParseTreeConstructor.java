/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree.reconstr;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class ReferenceGrammarParseTreeConstructor extends AbstractParseTreeConstructor {

	protected void internalSerialize(EObject obj, IParseTreeConstructorCallback strategy) {
		Solution t = internalSerialize(obj);
		if(t == null) throw new XtextSerializationException(getDescr(obj), "No rule found for serialization");
		t.getPredecessor().executeAllCallbacks(strategy);
	}
	
	protected Solution internalSerialize(EObject obj) {
		InstanceDescription inst = getDescr(obj);
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
	
	public Spielplatz_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielplatz_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielplatz_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug ) *
protected class Spielplatz_0_Group extends GroupToken {
	
	public Spielplatz_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielplatz_0_1_Alternatives(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielplatz_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{'
protected class Spielplatz_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielplatz_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielplatz_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielplatz' groesse = INT ( beschreibung = STRING ) ?
protected class Spielplatz_0_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielplatz_0_0_0_1_Assignment_beschreibung(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielplatz_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielplatz' groesse = INT
protected class Spielplatz_0_0_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielplatz_0_0_0_0_1_Assignment_groesse(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielplatz_0_0_0_0_0_Keyword_spielplatz(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielplatz'
protected class Spielplatz_0_0_0_0_0_Keyword_spielplatz extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Spielplatz_0_0_0_0_0_Keyword_spielplatz(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// groesse = INT
protected class Spielplatz_0_0_0_0_1_Assignment_groesse extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Spielplatz_0_0_0_0_1_Assignment_groesse(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("groesse")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("groesse");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Spielplatz_0_0_0_0_1_Assignment_groesseCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ( beschreibung = STRING ) ?
protected class Spielplatz_0_0_0_1_Assignment_beschreibung extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Spielplatz_0_0_0_1_Assignment_beschreibung(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("beschreibung")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("beschreibung");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Spielplatz_0_0_0_1_Assignment_beschreibungCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// '{'
protected class Spielplatz_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Spielplatz_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug ) *
protected class Spielplatz_0_1_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Spielplatz_0_1_Alternatives(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}

	
	protected boolean activateNextSolution() {
		if(first) {
			first = false;
			return true;
		}
		return false;
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Spielplatz_0_1_1_Assignment_spielzeuge(current, this) : new Spielplatz_0_1_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// kinder += Kind | erzieher += Erwachsener
protected class Spielplatz_0_1_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Spielplatz_0_1_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Spielplatz_0_1_0_1_Assignment_erzieher(current, this) : new Spielplatz_0_1_0_0_Assignment_kinder(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// kinder += Kind
protected class Spielplatz_0_1_0_0_Assignment_kinder extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal");
	protected Object value;
	
	public Spielplatz_0_1_0_0_Assignment_kinder(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("kinder")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("kinder");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Kind")) return null;
		AbstractToken t = new Kind_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Spielplatz_0_1_0_0_Assignment_kinderCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Kind
	}
}

// erzieher += Erwachsener
protected class Spielplatz_0_1_0_1_Assignment_erzieher extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal");
	protected Object value;
	
	public Spielplatz_0_1_0_1_Assignment_erzieher(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("erzieher")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("erzieher");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Erwachsener")) return null;
		AbstractToken t = new Erwachsener_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Spielplatz_0_1_0_1_Assignment_erzieherCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Erwachsener
	}
}


// spielzeuge += Spielzeug
protected class Spielplatz_0_1_1_Assignment_spielzeuge extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal");
	protected Object value;
	
	public Spielplatz_0_1_1_Assignment_spielzeuge(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("spielzeuge")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("spielzeuge");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Spielzeug")) return null;
		AbstractToken t = new Spielzeug_Group(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Spielplatz_0_1_1_Assignment_spielzeugeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Spielzeug
	}
}



// '}'
protected class Spielplatz_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1");
	
	public Spielplatz_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule Spielplatz ****************/

/************ begin Rule Person ****************
 *
 * Person : Kind | Erwachsener ;
 *
 **/


// Kind | Erwachsener
protected class Person_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Person_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Person_1_RuleCall_Erwachsener(current, this) : new Person_0_RuleCall_Kind(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// Kind
protected class Person_0_RuleCall_Kind extends RuleCallToken {
	
	public Person_0_RuleCall_Kind(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(checkForRecursion(Kind_Group.class, current)) return null;
		if(!current.isInstanceOf("Kind")) return null;
		return new Kind_Group(current, this).firstSolution();
	}
}

// Erwachsener
protected class Person_1_RuleCall_Erwachsener extends RuleCallToken {
	
	public Person_1_RuleCall_Erwachsener(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
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
	
	public Kind_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Kind_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Kind_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'kind' '(' name = ID age = INT
protected class Kind_0_Group extends GroupToken {
	
	public Kind_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Kind_0_1_Assignment_age(current, this).firstSolution();
		if(s1 == null) return null;
		return new Kind_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'kind' '(' name = ID
protected class Kind_0_0_Group extends GroupToken {
	
	public Kind_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Kind_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Kind_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'kind' '('
protected class Kind_0_0_0_Group extends GroupToken {
	
	public Kind_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Kind_0_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Kind_0_0_0_0_Keyword_kind(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'kind'
protected class Kind_0_0_0_0_Keyword_kind extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Kind_0_0_0_0_Keyword_kind(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// '('
protected class Kind_0_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Kind_0_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
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
protected class Kind_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Kind_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Kind_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// age = INT
protected class Kind_0_1_Assignment_age extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Kind_0_1_Assignment_age(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("age")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("age");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Kind_0_1_Assignment_ageCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ')'
protected class Kind_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1");
	
	public Kind_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
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
	
	public Erwachsener_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Erwachsener_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Erwachsener_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'erwachsener' '(' name = ID age = INT
protected class Erwachsener_0_Group extends GroupToken {
	
	public Erwachsener_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Erwachsener_0_1_Assignment_age(current, this).firstSolution();
		if(s1 == null) return null;
		return new Erwachsener_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'erwachsener' '(' name = ID
protected class Erwachsener_0_0_Group extends GroupToken {
	
	public Erwachsener_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Erwachsener_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Erwachsener_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'erwachsener' '('
protected class Erwachsener_0_0_0_Group extends GroupToken {
	
	public Erwachsener_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Erwachsener_0_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Erwachsener_0_0_0_0_Keyword_erwachsener(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'erwachsener'
protected class Erwachsener_0_0_0_0_Keyword_erwachsener extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Erwachsener_0_0_0_0_Keyword_erwachsener(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// '('
protected class Erwachsener_0_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Erwachsener_0_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
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
protected class Erwachsener_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Erwachsener_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Erwachsener_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// age = INT
protected class Erwachsener_0_1_Assignment_age extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Erwachsener_0_1_Assignment_age(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("age")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("age");
		// handling xtext::RuleCall
		return new Solution(obj);
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Erwachsener_0_1_Assignment_ageCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// ')'
protected class Erwachsener_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1");
	
	public Erwachsener_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
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
	
	public Spielzeug_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielzeug_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielzeug_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielzeug' '(' name = ID farbe = Farbe
protected class Spielzeug_0_Group extends GroupToken {
	
	public Spielzeug_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielzeug_0_1_Assignment_farbe(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielzeug_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielzeug' '(' name = ID
protected class Spielzeug_0_0_Group extends GroupToken {
	
	public Spielzeug_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielzeug_0_0_1_Assignment_name(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielzeug_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielzeug' '('
protected class Spielzeug_0_0_0_Group extends GroupToken {
	
	public Spielzeug_0_0_0_Group(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

		
	protected Solution createSolution() {
		Solution s1 = new Spielzeug_0_0_0_1_Keyword(current, this).firstSolution();
		if(s1 == null) return null;
		return new Spielzeug_0_0_0_0_Keyword_spielzeug(s1.getCurrent(), s1.getPredecessor()).firstSolution();
	}
}

// 'spielzeug'
protected class Spielzeug_0_0_0_0_Keyword_spielzeug extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	
	public Spielzeug_0_0_0_0_Keyword_spielzeug(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// '('
protected class Spielzeug_0_0_0_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	
	public Spielzeug_0_0_0_1_Keyword(InstanceDescription curr, AbstractToken pred) {
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
protected class Spielzeug_0_0_1_Assignment_name extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Spielzeug_0_0_1_Assignment_name(InstanceDescription curr, AbstractToken pred) {
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
		// System.out.println("Spielzeug_0_0_1_Assignment_nameCallback(\"xtext::RuleCall\", " + value + ")");
		callback.lexerRuleCall(current, (RuleCall) element, value);
	}
}


// farbe = Farbe
protected class Spielzeug_0_1_Assignment_farbe extends AssignmentToken  {

	protected AbstractElement element = (AbstractElement)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal");
	protected Object value;
	
	public Spielzeug_0_1_Assignment_farbe(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}

	
	protected Solution createSolution() {
		if(!current.isConsumable("farbe")) return null;
		InstanceDescription obj = (InstanceDescription)current.createClone();
		value = obj.consume("farbe");
		// handling xtext::RuleCall
		InstanceDescription param = getDescr((EObject)value);
		if(!param.isInstanceOf("Farbe")) return null;
		AbstractToken t = new Farbe_Alternatives(param, this);
		Solution s =  t.firstSolution();
		if(s == null) return null;
		return new Solution(obj,s.getPredecessor());
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		// System.out.println("Spielzeug_0_1_Assignment_farbeCallback(\"xtext::RuleCall\", " + value + ")");
		// Nothing to do for ParserRule Call Farbe
	}
}


// ')'
protected class Spielzeug_1_Keyword extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1");
	
	public Spielzeug_1_Keyword(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule Spielzeug ****************/

/************ begin Rule Farbe ****************
 *
 * Farbe : 'ROT' | 'BLAU' | 'GELB' | 'GRÜN' ;
 *
 **/


// 'ROT' | 'BLAU' | 'GELB' | 'GRÜN'
protected class Farbe_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Farbe_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Farbe_1_Keyword_GRN(current, this) : new Farbe_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// 'ROT' | 'BLAU' | 'GELB'
protected class Farbe_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Farbe_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Farbe_0_1_Keyword_GELB(current, this) : new Farbe_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// 'ROT' | 'BLAU'
protected class Farbe_0_0_Alternatives extends GroupToken {
	
	private boolean first = true;

	public Farbe_0_0_Alternatives(InstanceDescription curr, AbstractToken pred) {
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
		AbstractToken t = (first) ? new Farbe_0_0_1_Keyword_BLAU(current, this) : new Farbe_0_0_0_Keyword_ROT(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		return s; 
	}
}

// 'ROT'
protected class Farbe_0_0_0_Keyword_ROT extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.0");
	
	public Farbe_0_0_0_Keyword_ROT(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}

// 'BLAU'
protected class Farbe_0_0_1_Keyword_BLAU extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.1");
	
	public Farbe_0_0_1_Keyword_BLAU(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// 'GELB'
protected class Farbe_0_1_Keyword_GELB extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.1");
	
	public Farbe_0_1_Keyword_GELB(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


// 'GRÜN'
protected class Farbe_1_Keyword_GRN extends KeywordToken  {

	protected Keyword keyword = (Keyword)getGrammarElement("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.1");
	
	public Farbe_1_Keyword_GRN(InstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	protected Solution createSolution() {
		return new Solution();
	}
	
	public void executeCallback(IParseTreeConstructorCallback callback) {
		callback.keywordCall(current, keyword);
	}
}


/************ end Rule Farbe ****************/

}
