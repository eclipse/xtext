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


public class SimpleExpressionsParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Sequence") && (s = new Sequence_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Addition_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Multiplication_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Term_Alternatives(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Atom") && (s = new Atom_Assignment_name(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Expression") && (s = new Parens_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Sequence ****************
 *
 * Sequence : Addition ( { current = Sequence . expressions += current } expressions += Addition ) * ;
 *
 **/


// Addition ( { current = Sequence . expressions += current } expressions += Addition ) *
protected class Sequence_Group extends GroupToken {
	
	public Sequence_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.0/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Sequence_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Sequence_0_RuleCall_Addition(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// Addition
protected class Sequence_0_RuleCall_Addition extends RuleCallToken {
	
	public Sequence_0_RuleCall_Addition(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Addition_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Addition_Group(current, this).firstSolution();
	}
}

// ( { current = Sequence . expressions += current } expressions += Addition ) *
protected class Sequence_1_Group extends GroupToken {
	
	public Sequence_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.0/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Sequence_1_1_Assignment_expressions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Sequence_1_0_Action_Sequence_expressions(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Sequence . expressions += current }
protected class Sequence_1_0_Action_Sequence_expressions extends ActionToken  {

	public Sequence_1_0_Action_Sequence_expressions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Sequence")) return null;
		Object val = current.getConsumable("expressions", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("expressions")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// expressions += Addition
protected class Sequence_1_1_Assignment_expressions extends AssignmentToken  {
	
	public Sequence_1_1_Assignment_expressions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("expressions",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expressions");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Expression")) {
				Solution s = new Addition_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}



/************ end Rule Sequence ****************/

/************ begin Rule Addition ****************
 *
 * Addition returns Expression : Multiplication ( { current = Op . values += current } operator = ( '+' | '-' ) values += Multiplication ) * ;
 *
 **/


// Multiplication ( { current = Op . values += current } operator = ( '+' | '-' ) values += Multiplication ) *
protected class Addition_Group extends GroupToken {
	
	public Addition_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Addition_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Addition_0_RuleCall_Multiplication(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// Multiplication
protected class Addition_0_RuleCall_Multiplication extends RuleCallToken {
	
	public Addition_0_RuleCall_Multiplication(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Multiplication_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Multiplication_Group(current, this).firstSolution();
	}
}

// ( { current = Op . values += current } operator = ( '+' | '-' ) values += Multiplication ) *
protected class Addition_1_Group extends GroupToken {
	
	public Addition_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Addition_1_1_Assignment_values(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Addition_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Op . values += current } operator = ( '+' | '-' )
protected class Addition_1_0_Group extends GroupToken {
	
	public Addition_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Addition_1_0_1_Assignment_operator(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Addition_1_0_0_Action_Op_values(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Op . values += current }
protected class Addition_1_0_0_Action_Op_values extends ActionToken  {

	public Addition_1_0_0_Action_Op_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Op")) return null;
		Object val = current.getConsumable("values", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("values")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// operator = ( '+' | '-' )
protected class Addition_1_0_1_Assignment_operator extends AssignmentToken  {
	
	public Addition_1_0_1_Assignment_operator(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");
		if("+".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
			return new Solution(obj);
		}
		if("-".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
			return new Solution(obj);
		}
		return null;
	}
}


// values += Multiplication
protected class Addition_1_1_Assignment_values extends AssignmentToken  {
	
	public Addition_1_1_Assignment_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("values",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("values");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Expression")) {
				Solution s = new Multiplication_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}



/************ end Rule Addition ****************/

/************ begin Rule Multiplication ****************
 *
 * Multiplication returns Expression : Term ( { current = Op . values += current } operator = ( '*' | '/' ) values += Term ) * ;
 *
 **/


// Term ( { current = Op . values += current } operator = ( '*' | '/' ) values += Term ) *
protected class Multiplication_Group extends GroupToken {
	
	public Multiplication_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Multiplication_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Multiplication_0_RuleCall_Term(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// Term
protected class Multiplication_0_RuleCall_Term extends RuleCallToken {
	
	public Multiplication_0_RuleCall_Term(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Term_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Term_Alternatives(current, this).firstSolution();
	}
}

// ( { current = Op . values += current } operator = ( '*' | '/' ) values += Term ) *
protected class Multiplication_1_Group extends GroupToken {
	
	public Multiplication_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Multiplication_1_1_Assignment_values(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Multiplication_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Op . values += current } operator = ( '*' | '/' )
protected class Multiplication_1_0_Group extends GroupToken {
	
	public Multiplication_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Multiplication_1_0_1_Assignment_operator(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Multiplication_1_0_0_Action_Op_values(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// { current = Op . values += current }
protected class Multiplication_1_0_0_Action_Op_values extends ActionToken  {

	public Multiplication_1_0_0_Action_Op_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Action getGrammarElement() {
		return (Action)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if(!current.isInstanceOf("Op")) return null;
		Object val = current.getConsumable("values", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("values")) return null;
		return new Solution(getDescr((EObject)val));
	}
}

// operator = ( '*' | '/' )
protected class Multiplication_1_0_1_Assignment_operator extends AssignmentToken  {
	
	public Multiplication_1_0_1_Assignment_operator(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("operator",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("operator");
		if("*".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0");
			return new Solution(obj);
		}
		if("/".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1");
			return new Solution(obj);
		}
		return null;
	}
}


// values += Term
protected class Multiplication_1_1_Assignment_values extends AssignmentToken  {
	
	public Multiplication_1_1_Assignment_values(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("values",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("values");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Expression")) {
				Solution s = new Term_Alternatives(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}



/************ end Rule Multiplication ****************/

/************ begin Rule Term ****************
 *
 * Term returns Expression : Atom | Parens ;
 *
 **/


// Atom | Parens
protected class Term_Alternatives extends AlternativesToken {

	public Term_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return (Alternatives)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.3/@alternatives");
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Term_1_RuleCall_Parens(current, this) : new Term_0_RuleCall_Atom(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Atom
protected class Term_0_RuleCall_Atom extends RuleCallToken {
	
	public Term_0_RuleCall_Atom(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.3/@alternatives/@groups.0");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Atom_Assignment_name.class, current)) return null;
		if(!current.isInstanceOf("Atom")) return null;
		return new Atom_Assignment_name(current, this).firstSolution();
	}
}

// Parens
protected class Term_1_RuleCall_Parens extends RuleCallToken {
	
	public Term_1_RuleCall_Parens(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.3/@alternatives/@groups.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Parens_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Parens_Group(current, this).firstSolution();
	}
}


/************ end Rule Term ****************/

/************ begin Rule Atom ****************
 *
 * Atom : name = ID ;
 *
 **/


// name = ID
protected class Atom_Assignment_name extends AssignmentToken  {
	
	public Atom_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.4/@alternatives");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.4/@alternatives/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Atom ****************/

/************ begin Rule Parens ****************
 *
 * Parens returns Expression : '(' Addition ')' ;
 *
 **/


// '(' Addition ')'
protected class Parens_Group extends GroupToken {
	
	public Parens_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Parens_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// '(' Addition
protected class Parens_0_Group extends GroupToken {
	
	public Parens_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Parens_0_1_RuleCall_Addition(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parens_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// '('
protected class Parens_0_0_Keyword extends KeywordToken  {
	
	public Parens_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}	
}

// Addition
protected class Parens_0_1_RuleCall_Addition extends RuleCallToken {
	
	public Parens_0_1_RuleCall_Addition(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return (RuleCall)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Addition_Group.class, current)) return null;
		if(!current.isInstanceOf("Expression")) return null;
		return new Addition_Group(current, this).firstSolution();
	}
}


// ')'
protected class Parens_1_Keyword extends KeywordToken  {
	
	public Parens_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@rules.5/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule Parens ****************/

}
