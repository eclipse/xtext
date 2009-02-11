/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;


public class ReferenceGrammarParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Spielplatz") && (s = new Spielplatz_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Person") && (s = new Person_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Kind") && (s = new Kind_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Erwachsener") && (s = new Erwachsener_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Spielzeug") && (s = new Spielzeug_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Familie") && (s = new Familie_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Farbe") && (s = new Farbe_Assignment_wert(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("CustomType") && (s = new CustomTypeParserRule_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Spielplatz ****************
 *
 * Spielplatz:   ("spielplatz" groesse=INT (beschreibung=STRING)? "{" (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)* "}")?;
 *
 **/


// ("spielplatz" groesse=INT (beschreibung=STRING)? "{" (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)* "}")?
protected class Spielplatz_Group extends GroupToken {
	
	public Spielplatz_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielplatz" groesse=INT (beschreibung=STRING)? "{" (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)*
protected class Spielplatz_0_Group extends GroupToken {
	
	public Spielplatz_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielplatz" groesse=INT (beschreibung=STRING)? "{"
protected class Spielplatz_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielplatz" groesse=INT (beschreibung=STRING)?
protected class Spielplatz_0_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_0_0_1_Assignment_beschreibung(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielplatz" groesse=INT
protected class Spielplatz_0_0_0_0_Group extends GroupToken {
	
	public Spielplatz_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielplatz_0_0_0_0_1_Assignment_groesse(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielplatz_0_0_0_0_0_Keyword_spielplatz(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielplatz"
protected class Spielplatz_0_0_0_0_0_Keyword_spielplatz extends KeywordToken  {
	
	public Spielplatz_0_0_0_0_0_Keyword_spielplatz(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele00000KeywordSpielplatz();
	}	
}

// groesse=INT
protected class Spielplatz_0_0_0_0_1_Assignment_groesse extends AssignmentToken  {
	
	public Spielplatz_0_0_0_0_1_Assignment_groesse(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele00001AssignmentGroesse();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("groesse",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("groesse");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele000010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// (beschreibung=STRING)?
protected class Spielplatz_0_0_0_1_Assignment_beschreibung extends AssignmentToken  {
	
	public Spielplatz_0_0_0_1_Assignment_beschreibung(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele0001AssignmentBeschreibung();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("beschreibung",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("beschreibung");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele00010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// "{"
protected class Spielplatz_0_0_1_Keyword extends KeywordToken  {
	
	public Spielplatz_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele001KeywordLeftCurlyBracket();
	}	
}


// (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)*
protected class Spielplatz_0_1_Alternatives extends AlternativesToken {

	public Spielplatz_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele01Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Spielplatz_0_1_1_Assignment_types(current, this) : new Spielplatz_0_1_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie
protected class Spielplatz_0_1_0_Alternatives extends AlternativesToken {

	public Spielplatz_0_1_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele010Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Spielplatz_0_1_0_1_Assignment_familie(current, this) : new Spielplatz_0_1_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug
protected class Spielplatz_0_1_0_0_Alternatives extends AlternativesToken {

	public Spielplatz_0_1_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele0100Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Spielplatz_0_1_0_0_1_Assignment_spielzeuge(current, this) : new Spielplatz_0_1_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// kinder+=Kind|erzieher+=Erwachsener
protected class Spielplatz_0_1_0_0_0_Alternatives extends AlternativesToken {

	public Spielplatz_0_1_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele01000Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Spielplatz_0_1_0_0_0_1_Assignment_erzieher(current, this) : new Spielplatz_0_1_0_0_0_0_Assignment_kinder(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// kinder+=Kind
protected class Spielplatz_0_1_0_0_0_0_Assignment_kinder extends AssignmentToken  {
	
	public Spielplatz_0_1_0_0_0_0_Assignment_kinder(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele010000AssignmentKinder();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("kinder",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("kinder");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Kind")) {
				Solution s = new Kind_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// erzieher+=Erwachsener
protected class Spielplatz_0_1_0_0_0_1_Assignment_erzieher extends AssignmentToken  {
	
	public Spielplatz_0_1_0_0_0_1_Assignment_erzieher(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele010001AssignmentErzieher();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("erzieher",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("erzieher");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Erwachsener")) {
				Solution s = new Erwachsener_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// spielzeuge+=Spielzeug
protected class Spielplatz_0_1_0_0_1_Assignment_spielzeuge extends AssignmentToken  {
	
	public Spielplatz_0_1_0_0_1_Assignment_spielzeuge(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele01001AssignmentSpielzeuge();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("spielzeuge",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("spielzeuge");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Spielzeug")) {
				Solution s = new Spielzeug_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// familie+=Familie
protected class Spielplatz_0_1_0_1_Assignment_familie extends AssignmentToken  {
	
	public Spielplatz_0_1_0_1_Assignment_familie(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele0101AssignmentFamilie();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("familie",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("familie");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Familie")) {
				Solution s = new Familie_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// types+=CustomTypeParserRule
protected class Spielplatz_0_1_1_Assignment_types extends AssignmentToken  {
	
	public Spielplatz_0_1_1_Assignment_types(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele011AssignmentTypes();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("types",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("types");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("CustomType")) {
				Solution s = new CustomTypeParserRule_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// "}"
protected class Spielplatz_1_Keyword extends KeywordToken  {
	
	public Spielplatz_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule Spielplatz ****************/


/************ begin Rule Person ****************
 *
 * Person:   Kind|Erwachsener;
 *
 **/


// Kind|Erwachsener
protected class Person_Alternatives extends AlternativesToken {

	public Person_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prPerson().eleAlternatives();
	}

	@Override	
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
		return ReferenceGrammarGrammarAccess.INSTANCE.prPerson().ele0ParserRuleCallKind();
	}
	
	@Override
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
		return ReferenceGrammarGrammarAccess.INSTANCE.prPerson().ele1ParserRuleCallErwachsener();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(Erwachsener_Group.class, current)) return null;
		if(!current.isInstanceOf("Erwachsener")) return null;
		return new Erwachsener_Group(current, this).firstSolution();
	}
}


/************ end Rule Person ****************/


/************ begin Rule Kind ****************
 *
 * Kind:   "kind" "(" name=ID age=INT ")";
 *
 **/


// "kind" "(" name=ID age=INT ")"
protected class Kind_Group extends GroupToken {
	
	public Kind_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Kind_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "kind" "(" name=ID age=INT
protected class Kind_0_Group extends GroupToken {
	
	public Kind_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Kind_0_1_Assignment_age(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "kind" "(" name=ID
protected class Kind_0_0_Group extends GroupToken {
	
	public Kind_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Kind_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "kind" "("
protected class Kind_0_0_0_Group extends GroupToken {
	
	public Kind_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Kind_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Kind_0_0_0_0_Keyword_kind(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "kind"
protected class Kind_0_0_0_0_Keyword_kind extends KeywordToken  {
	
	public Kind_0_0_0_0_Keyword_kind(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele0000KeywordKind();
	}	
}

// "("
protected class Kind_0_0_0_1_Keyword extends KeywordToken  {
	
	public Kind_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele0001KeywordLeftParenthesis();
	}	
}


// name=ID
protected class Kind_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Kind_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// age=INT
protected class Kind_0_1_Assignment_age extends AssignmentToken  {
	
	public Kind_0_1_Assignment_age(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele01AssignmentAge();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("age",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("age");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// ")"
protected class Kind_1_Keyword extends KeywordToken  {
	
	public Kind_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prKind().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule Kind ****************/


/************ begin Rule Erwachsener ****************
 *
 * Erwachsener:   "erwachsener" "(" name=ID age=INT ")";
 *
 **/


// "erwachsener" "(" name=ID age=INT ")"
protected class Erwachsener_Group extends GroupToken {
	
	public Erwachsener_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "erwachsener" "(" name=ID age=INT
protected class Erwachsener_0_Group extends GroupToken {
	
	public Erwachsener_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_0_1_Assignment_age(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "erwachsener" "(" name=ID
protected class Erwachsener_0_0_Group extends GroupToken {
	
	public Erwachsener_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "erwachsener" "("
protected class Erwachsener_0_0_0_Group extends GroupToken {
	
	public Erwachsener_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Erwachsener_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Erwachsener_0_0_0_0_Keyword_erwachsener(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "erwachsener"
protected class Erwachsener_0_0_0_0_Keyword_erwachsener extends KeywordToken  {
	
	public Erwachsener_0_0_0_0_Keyword_erwachsener(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele0000KeywordErwachsener();
	}	
}

// "("
protected class Erwachsener_0_0_0_1_Keyword extends KeywordToken  {
	
	public Erwachsener_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele0001KeywordLeftParenthesis();
	}	
}


// name=ID
protected class Erwachsener_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Erwachsener_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// age=INT
protected class Erwachsener_0_1_Assignment_age extends AssignmentToken  {
	
	public Erwachsener_0_1_Assignment_age(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele01AssignmentAge();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("age",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("age");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// ")"
protected class Erwachsener_1_Keyword extends KeywordToken  {
	
	public Erwachsener_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prErwachsener().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule Erwachsener ****************/


/************ begin Rule Spielzeug ****************
 *
 * Spielzeug:   "spielzeug" "(" name=ID farbe=Farbe ")";
 *
 **/


// "spielzeug" "(" name=ID farbe=Farbe ")"
protected class Spielzeug_Group extends GroupToken {
	
	public Spielzeug_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielzeug" "(" name=ID farbe=Farbe
protected class Spielzeug_0_Group extends GroupToken {
	
	public Spielzeug_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_0_1_Assignment_farbe(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielzeug" "(" name=ID
protected class Spielzeug_0_0_Group extends GroupToken {
	
	public Spielzeug_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielzeug" "("
protected class Spielzeug_0_0_0_Group extends GroupToken {
	
	public Spielzeug_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Spielzeug_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Spielzeug_0_0_0_0_Keyword_spielzeug(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "spielzeug"
protected class Spielzeug_0_0_0_0_Keyword_spielzeug extends KeywordToken  {
	
	public Spielzeug_0_0_0_0_Keyword_spielzeug(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele0000KeywordSpielzeug();
	}	
}

// "("
protected class Spielzeug_0_0_0_1_Keyword extends KeywordToken  {
	
	public Spielzeug_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele0001KeywordLeftParenthesis();
	}	
}


// name=ID
protected class Spielzeug_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Spielzeug_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// farbe=Farbe
protected class Spielzeug_0_1_Assignment_farbe extends AssignmentToken  {
	
	public Spielzeug_0_1_Assignment_farbe(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele01AssignmentFarbe();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("farbe",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("farbe");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Farbe")) {
				Solution s = new Farbe_Assignment_wert(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ")"
protected class Spielzeug_1_Keyword extends KeywordToken  {
	
	public Spielzeug_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule Spielzeug ****************/


/************ begin Rule Familie ****************
 *
 * Familie:   "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind] ("," kinder+=[Kind])* ")";
 *
 **/


// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind] ("," kinder+=[Kind])* ")"
protected class Familie_Group extends GroupToken {
	
	public Familie_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind] ("," kinder+=[Kind])*
protected class Familie_0_Group extends GroupToken {
	
	public Familie_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind]
protected class Familie_0_0_Group extends GroupToken {
	
	public Familie_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_0_0_1_Assignment_kinder(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener]
protected class Familie_0_0_0_Group extends GroupToken {
	
	public Familie_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_0_0_0_1_Assignment_vater(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener]
protected class Familie_0_0_0_0_Group extends GroupToken {
	
	public Familie_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_0_0_0_0_1_Assignment_mutter(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "familie" "(" name=("keyword"|STRING|ID)
protected class Familie_0_0_0_0_0_Group extends GroupToken {
	
	public Familie_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele00000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_0_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "familie" "("
protected class Familie_0_0_0_0_0_0_Group extends GroupToken {
	
	public Familie_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele000000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_0_0_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_0_0_0_0_0_0_Keyword_familie(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "familie"
protected class Familie_0_0_0_0_0_0_0_Keyword_familie extends KeywordToken  {
	
	public Familie_0_0_0_0_0_0_0_Keyword_familie(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele0000000KeywordFamilie();
	}	
}

// "("
protected class Familie_0_0_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public Familie_0_0_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele0000001KeywordLeftParenthesis();
	}	
}


// name=("keyword"|STRING|ID)
protected class Familie_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Familie_0_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele000001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");

		if("keyword".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele000001000KeywordKeyword();
			return new Solution(obj);
		}

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele000001001LexerRuleCallSTRING();
			return new Solution(obj);
		}
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele00000101LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// mutter=[Erwachsener]
protected class Familie_0_0_0_0_1_Assignment_mutter extends AssignmentToken  {
	
	public Familie_0_0_0_0_1_Assignment_mutter(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele00001AssignmentMutter();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("mutter",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("mutter");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Erwachsener")) {
				type = AssignmentType.CR;
				element = ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele000010CrossReferenceEStringErwachsener(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// vater=[Erwachsener]
protected class Familie_0_0_0_1_Assignment_vater extends AssignmentToken  {
	
	public Familie_0_0_0_1_Assignment_vater(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele0001AssignmentVater();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("vater",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("vater");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Erwachsener")) {
				type = AssignmentType.CR;
				element = ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele00010CrossReferenceEStringErwachsener(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// kinder+=[Kind]
protected class Familie_0_0_1_Assignment_kinder extends AssignmentToken  {
	
	public Familie_0_0_1_Assignment_kinder(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele001AssignmentKinder();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("kinder",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("kinder");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Kind")) {
				type = AssignmentType.CR;
				element = ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele0010CrossReferenceEStringKind(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// ("," kinder+=[Kind])*
protected class Familie_0_1_Group extends GroupToken {
	
	public Familie_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele01Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Familie_0_1_1_Assignment_kinder(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Familie_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class Familie_0_1_0_Keyword extends KeywordToken  {
	
	public Familie_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele010KeywordComma();
	}	
}

// kinder+=[Kind]
protected class Familie_0_1_1_Assignment_kinder extends AssignmentToken  {
	
	public Familie_0_1_1_Assignment_kinder(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele011AssignmentKinder();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("kinder",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("kinder");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Kind")) {
				type = AssignmentType.CR;
				element = ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele0110CrossReferenceEStringKind(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



// ")"
protected class Familie_1_Keyword extends KeywordToken  {
	
	public Familie_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule Familie ****************/


/************ begin Rule Farbe ****************
 *
 * Farbe:   wert=("ROT"|"BLAU"|"GELB"|"GR\u00DCN");
 *
 **/


// wert=("ROT"|"BLAU"|"GELB"|"GR\u00DCN")
protected class Farbe_Assignment_wert extends AssignmentToken  {
	
	public Farbe_Assignment_wert(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFarbe().eleAssignmentWert();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("wert",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("wert");

		if("ROT".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prFarbe().ele0000KeywordROT();
			return new Solution(obj);
		}


		if("BLAU".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prFarbe().ele0001KeywordBLAU();
			return new Solution(obj);
		}


		if("GELB".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prFarbe().ele001KeywordGELB();
			return new Solution(obj);
		}


		if("GRÜN".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prFarbe().ele01KeywordGRÜN();
			return new Solution(obj);
		}

		return null;
	}
}

/************ end Rule Farbe ****************/


/************ begin Rule CustomTypeParserRule ****************
 *
 * CustomTypeParserRule returns CustomType:   "type" name=ID;
 *
 **/


// "type" name=ID
protected class CustomTypeParserRule_Group extends GroupToken {
	
	public CustomTypeParserRule_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prCustomTypeParserRule().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new CustomTypeParserRule_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CustomTypeParserRule_0_Keyword_type(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "type"
protected class CustomTypeParserRule_0_Keyword_type extends KeywordToken  {
	
	public CustomTypeParserRule_0_Keyword_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prCustomTypeParserRule().ele0KeywordType();
	}	
}

// name=ID
protected class CustomTypeParserRule_1_Assignment_name extends AssignmentToken  {
	
	public CustomTypeParserRule_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prCustomTypeParserRule().ele1AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = ReferenceGrammarGrammarAccess.INSTANCE.prCustomTypeParserRule().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule CustomTypeParserRule ****************/

}
