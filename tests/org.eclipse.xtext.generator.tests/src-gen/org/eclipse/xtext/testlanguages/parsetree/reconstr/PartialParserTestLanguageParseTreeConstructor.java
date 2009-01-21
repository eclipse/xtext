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
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;


public class PartialParserTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Container") && (s = new Container_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Nested") && (s = new Nested_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Content") && (s = new Content_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Children") && (s = new Children_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Child") && (s = new Child_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractChildren") && (s = new AbstractChildren_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AbstractChild") && (s = new AbstractChild_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("FirstConcrete") && (s = new FirstConcrete_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("SecondConcrete") && (s = new SecondConcrete_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Named") && (s = new Named_Assignment_name(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Container ****************
 *
 * Container : "container" name = ID "{" ( nested += Nested | content += Content ) * "}" ;
 *
 **/


// "container" name = ID "{" ( nested += Nested | content += Content ) * "}"
protected class Container_Group extends GroupToken {
	
	public Container_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Container_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Container_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "container" name = ID "{" ( nested += Nested | content += Content ) *
protected class Container_0_Group extends GroupToken {
	
	public Container_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Container_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Container_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "container" name = ID "{"
protected class Container_0_0_Group extends GroupToken {
	
	public Container_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Container_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Container_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "container" name = ID
protected class Container_0_0_0_Group extends GroupToken {
	
	public Container_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Container_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Container_0_0_0_0_Keyword_container(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "container"
protected class Container_0_0_0_0_Keyword_container extends KeywordToken  {
	
	public Container_0_0_0_0_Keyword_container(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele0000KeywordContainer();
	}	
}

// name = ID
protected class Container_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Container_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele0001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele00010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "{"
protected class Container_0_0_1_Keyword extends KeywordToken  {
	
	public Container_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele001KeywordLeftCurlyBracket();
	}	
}


// ( nested += Nested | content += Content ) *
protected class Container_0_1_Alternatives extends AlternativesToken {

	public Container_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele01Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Container_0_1_1_Assignment_content(current, this) : new Container_0_1_0_Assignment_nested(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// nested += Nested
protected class Container_0_1_0_Assignment_nested extends AssignmentToken  {
	
	public Container_0_1_0_Assignment_nested(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele010AssignmentNested();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nested",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nested");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Nested")) {
				Solution s = new Nested_Group(param, this).firstSolution();
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

// content += Content
protected class Container_0_1_1_Assignment_content extends AssignmentToken  {
	
	public Container_0_1_1_Assignment_content(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele011AssignmentContent();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("content",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("content");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Content")) {
				Solution s = new Content_Alternatives(param, this).firstSolution();
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
protected class Container_1_Keyword extends KeywordToken  {
	
	public Container_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule Container ****************/


/************ begin Rule Nested ****************
 *
 * Nested : "nested" "{" ( nested += Container ) + "}" ;
 *
 **/


// "nested" "{" ( nested += Container ) + "}"
protected class Nested_Group extends GroupToken {
	
	public Nested_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Nested_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Nested_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "nested" "{" ( nested += Container ) +
protected class Nested_0_Group extends GroupToken {
	
	public Nested_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Nested_0_1_Assignment_nested(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Nested_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "nested" "{"
protected class Nested_0_0_Group extends GroupToken {
	
	public Nested_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Nested_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Nested_0_0_0_Keyword_nested(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "nested"
protected class Nested_0_0_0_Keyword_nested extends KeywordToken  {
	
	public Nested_0_0_0_Keyword_nested(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested().ele000KeywordNested();
	}	
}

// "{"
protected class Nested_0_0_1_Keyword extends KeywordToken  {
	
	public Nested_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested().ele001KeywordLeftCurlyBracket();
	}	
}


// ( nested += Container ) +
protected class Nested_0_1_Assignment_nested extends AssignmentToken  {
	
	public Nested_0_1_Assignment_nested(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested().ele01AssignmentNested();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nested",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nested");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Container")) {
				Solution s = new Container_Group(param, this).firstSolution();
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
protected class Nested_1_Keyword extends KeywordToken  {
	
	public Nested_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule Nested ****************/


/************ begin Rule Content ****************
 *
 * Content : Children | AbstractChildren ;
 *
 **/


// Children | AbstractChildren
protected class Content_Alternatives extends AlternativesToken {

	public Content_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContent().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Content_1_RuleCall_AbstractChildren(current, this) : new Content_0_RuleCall_Children(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Children
protected class Content_0_RuleCall_Children extends RuleCallToken {
	
	public Content_0_RuleCall_Children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContent().ele0ParserRuleCallChildren();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Children_Group.class, current)) return null;
		if(!current.isInstanceOf("Children")) return null;
		return new Children_Group(current, this).firstSolution();
	}
}

// AbstractChildren
protected class Content_1_RuleCall_AbstractChildren extends RuleCallToken {
	
	public Content_1_RuleCall_AbstractChildren(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContent().ele1ParserRuleCallAbstractChildren();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(AbstractChildren_Group.class, current)) return null;
		if(!current.isInstanceOf("AbstractChildren")) return null;
		return new AbstractChildren_Group(current, this).firstSolution();
	}
}


/************ end Rule Content ****************/


/************ begin Rule Children ****************
 *
 * Children : "children" "{" children += Child ( "," children += Child ) * "}" ;
 *
 **/


// "children" "{" children += Child ( "," children += Child ) * "}"
protected class Children_Group extends GroupToken {
	
	public Children_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Children_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Children_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "children" "{" children += Child ( "," children += Child ) *
protected class Children_0_Group extends GroupToken {
	
	public Children_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Children_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Children_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "children" "{" children += Child
protected class Children_0_0_Group extends GroupToken {
	
	public Children_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Children_0_0_1_Assignment_children(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Children_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "children" "{"
protected class Children_0_0_0_Group extends GroupToken {
	
	public Children_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Children_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Children_0_0_0_0_Keyword_children(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "children"
protected class Children_0_0_0_0_Keyword_children extends KeywordToken  {
	
	public Children_0_0_0_0_Keyword_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele0000KeywordChildren();
	}	
}

// "{"
protected class Children_0_0_0_1_Keyword extends KeywordToken  {
	
	public Children_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele0001KeywordLeftCurlyBracket();
	}	
}


// children += Child
protected class Children_0_0_1_Assignment_children extends AssignmentToken  {
	
	public Children_0_0_1_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele001AssignmentChildren();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("children",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Child")) {
				Solution s = new Child_Group(param, this).firstSolution();
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


// ( "," children += Child ) *
protected class Children_0_1_Group extends GroupToken {
	
	public Children_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Children_0_1_1_Assignment_children(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Children_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class Children_0_1_0_Keyword extends KeywordToken  {
	
	public Children_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele010KeywordComma();
	}	
}

// children += Child
protected class Children_0_1_1_Assignment_children extends AssignmentToken  {
	
	public Children_0_1_1_Assignment_children(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele011AssignmentChildren();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("children",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("children");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Child")) {
				Solution s = new Child_Group(param, this).firstSolution();
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
protected class Children_1_Keyword extends KeywordToken  {
	
	public Children_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule Children ****************/


/************ begin Rule Child ****************
 *
 * Child : "->" "C" "(" value = Named ")" ;
 *
 **/


// "->" "C" "(" value = Named ")"
protected class Child_Group extends GroupToken {
	
	public Child_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Child_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Child_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "C" "(" value = Named
protected class Child_0_Group extends GroupToken {
	
	public Child_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Child_0_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Child_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "C" "("
protected class Child_0_0_Group extends GroupToken {
	
	public Child_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Child_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Child_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "C"
protected class Child_0_0_0_Group extends GroupToken {
	
	public Child_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Child_0_0_0_1_Keyword_C(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Child_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->"
protected class Child_0_0_0_0_Keyword extends KeywordToken  {
	
	public Child_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele0000KeywordHyphenMinusGreaterThanSign();
	}	
}

// "C"
protected class Child_0_0_0_1_Keyword_C extends KeywordToken  {
	
	public Child_0_0_0_1_Keyword_C(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele0001KeywordC();
	}	
}


// "("
protected class Child_0_0_1_Keyword extends KeywordToken  {
	
	public Child_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele001KeywordLeftParenthesis();
	}	
}


// value = Named
protected class Child_0_1_Assignment_value extends AssignmentToken  {
	
	public Child_0_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele01AssignmentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Named")) {
				Solution s = new Named_Assignment_name(param, this).firstSolution();
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
protected class Child_1_Keyword extends KeywordToken  {
	
	public Child_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChild().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule Child ****************/


/************ begin Rule AbstractChildren ****************
 *
 * AbstractChildren : "abstract children" "{" ( abstractChildren += AbstractChild ) + "}" ;
 *
 **/


// "abstract children" "{" ( abstractChildren += AbstractChild ) + "}"
protected class AbstractChildren_Group extends GroupToken {
	
	public AbstractChildren_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChildren().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new AbstractChildren_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractChildren_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "abstract children" "{" ( abstractChildren += AbstractChild ) +
protected class AbstractChildren_0_Group extends GroupToken {
	
	public AbstractChildren_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChildren().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new AbstractChildren_0_1_Assignment_abstractChildren(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractChildren_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "abstract children" "{"
protected class AbstractChildren_0_0_Group extends GroupToken {
	
	public AbstractChildren_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChildren().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new AbstractChildren_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AbstractChildren_0_0_0_Keyword_abstractchildren(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "abstract children"
protected class AbstractChildren_0_0_0_Keyword_abstractchildren extends KeywordToken  {
	
	public AbstractChildren_0_0_0_Keyword_abstractchildren(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChildren().ele000KeywordAbstractChildren();
	}	
}

// "{"
protected class AbstractChildren_0_0_1_Keyword extends KeywordToken  {
	
	public AbstractChildren_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChildren().ele001KeywordLeftCurlyBracket();
	}	
}


// ( abstractChildren += AbstractChild ) +
protected class AbstractChildren_0_1_Assignment_abstractChildren extends AssignmentToken  {
	
	public AbstractChildren_0_1_Assignment_abstractChildren(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChildren().ele01AssignmentAbstractChildren();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstractChildren",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstractChildren");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AbstractChild")) {
				Solution s = new AbstractChild_Alternatives(param, this).firstSolution();
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
protected class AbstractChildren_1_Keyword extends KeywordToken  {
	
	public AbstractChildren_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChildren().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule AbstractChildren ****************/


/************ begin Rule AbstractChild ****************
 *
 * AbstractChild : FirstConcrete | SecondConcrete ;
 *
 **/


// FirstConcrete | SecondConcrete
protected class AbstractChild_Alternatives extends AlternativesToken {

	public AbstractChild_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChild().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AbstractChild_1_RuleCall_SecondConcrete(current, this) : new AbstractChild_0_RuleCall_FirstConcrete(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// FirstConcrete
protected class AbstractChild_0_RuleCall_FirstConcrete extends RuleCallToken {
	
	public AbstractChild_0_RuleCall_FirstConcrete(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChild().ele0ParserRuleCallFirstConcrete();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(FirstConcrete_Group.class, current)) return null;
		if(!current.isInstanceOf("FirstConcrete")) return null;
		return new FirstConcrete_Group(current, this).firstSolution();
	}
}

// SecondConcrete
protected class AbstractChild_1_RuleCall_SecondConcrete extends RuleCallToken {
	
	public AbstractChild_1_RuleCall_SecondConcrete(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChild().ele1ParserRuleCallSecondConcrete();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(SecondConcrete_Group.class, current)) return null;
		if(!current.isInstanceOf("SecondConcrete")) return null;
		return new SecondConcrete_Group(current, this).firstSolution();
	}
}


/************ end Rule AbstractChild ****************/


/************ begin Rule FirstConcrete ****************
 *
 * FirstConcrete : "->" "F" "(" value = Named ( referencedContainer = [ Container ] ) ? ")" ;
 *
 **/


// "->" "F" "(" value = Named ( referencedContainer = [ Container ] ) ? ")"
protected class FirstConcrete_Group extends GroupToken {
	
	public FirstConcrete_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstConcrete_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstConcrete_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F" "(" value = Named ( referencedContainer = [ Container ] ) ?
protected class FirstConcrete_0_Group extends GroupToken {
	
	public FirstConcrete_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstConcrete_0_1_Assignment_referencedContainer(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstConcrete_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F" "(" value = Named
protected class FirstConcrete_0_0_Group extends GroupToken {
	
	public FirstConcrete_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstConcrete_0_0_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstConcrete_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F" "("
protected class FirstConcrete_0_0_0_Group extends GroupToken {
	
	public FirstConcrete_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstConcrete_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstConcrete_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F"
protected class FirstConcrete_0_0_0_0_Group extends GroupToken {
	
	public FirstConcrete_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new FirstConcrete_0_0_0_0_1_Keyword_F(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new FirstConcrete_0_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->"
protected class FirstConcrete_0_0_0_0_0_Keyword extends KeywordToken  {
	
	public FirstConcrete_0_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele00000KeywordHyphenMinusGreaterThanSign();
	}	
}

// "F"
protected class FirstConcrete_0_0_0_0_1_Keyword_F extends KeywordToken  {
	
	public FirstConcrete_0_0_0_0_1_Keyword_F(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele00001KeywordF();
	}	
}


// "("
protected class FirstConcrete_0_0_0_1_Keyword extends KeywordToken  {
	
	public FirstConcrete_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele0001KeywordLeftParenthesis();
	}	
}


// value = Named
protected class FirstConcrete_0_0_1_Assignment_value extends AssignmentToken  {
	
	public FirstConcrete_0_0_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele001AssignmentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Named")) {
				Solution s = new Named_Assignment_name(param, this).firstSolution();
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


// ( referencedContainer = [ Container ] ) ?
protected class FirstConcrete_0_1_Assignment_referencedContainer extends AssignmentToken  {
	
	public FirstConcrete_0_1_Assignment_referencedContainer(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele01AssignmentReferencedContainer();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("referencedContainer",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("referencedContainer");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Container")) {
				type = AssignmentType.CR;
				element = PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele010CrossReferenceEStringContainer(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// ")"
protected class FirstConcrete_1_Keyword extends KeywordToken  {
	
	public FirstConcrete_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule FirstConcrete ****************/


/************ begin Rule SecondConcrete ****************
 *
 * SecondConcrete : "->" "F" "S" "(" value = Named ( referencedChildren += [ Child ] ) ? ")" ;
 *
 **/


// "->" "F" "S" "(" value = Named ( referencedChildren += [ Child ] ) ? ")"
protected class SecondConcrete_Group extends GroupToken {
	
	public SecondConcrete_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondConcrete_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondConcrete_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F" "S" "(" value = Named ( referencedChildren += [ Child ] ) ?
protected class SecondConcrete_0_Group extends GroupToken {
	
	public SecondConcrete_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondConcrete_0_1_Assignment_referencedChildren(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondConcrete_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F" "S" "(" value = Named
protected class SecondConcrete_0_0_Group extends GroupToken {
	
	public SecondConcrete_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondConcrete_0_0_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondConcrete_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F" "S" "("
protected class SecondConcrete_0_0_0_Group extends GroupToken {
	
	public SecondConcrete_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondConcrete_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondConcrete_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F" "S"
protected class SecondConcrete_0_0_0_0_Group extends GroupToken {
	
	public SecondConcrete_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondConcrete_0_0_0_0_1_Keyword_S(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondConcrete_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->" "F"
protected class SecondConcrete_0_0_0_0_0_Group extends GroupToken {
	
	public SecondConcrete_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SecondConcrete_0_0_0_0_0_1_Keyword_F(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SecondConcrete_0_0_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "->"
protected class SecondConcrete_0_0_0_0_0_0_Keyword extends KeywordToken  {
	
	public SecondConcrete_0_0_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele000000KeywordHyphenMinusGreaterThanSign();
	}	
}

// "F"
protected class SecondConcrete_0_0_0_0_0_1_Keyword_F extends KeywordToken  {
	
	public SecondConcrete_0_0_0_0_0_1_Keyword_F(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele000001KeywordF();
	}	
}


// "S"
protected class SecondConcrete_0_0_0_0_1_Keyword_S extends KeywordToken  {
	
	public SecondConcrete_0_0_0_0_1_Keyword_S(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele00001KeywordS();
	}	
}


// "("
protected class SecondConcrete_0_0_0_1_Keyword extends KeywordToken  {
	
	public SecondConcrete_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele0001KeywordLeftParenthesis();
	}	
}


// value = Named
protected class SecondConcrete_0_0_1_Assignment_value extends AssignmentToken  {
	
	public SecondConcrete_0_0_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele001AssignmentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Named")) {
				Solution s = new Named_Assignment_name(param, this).firstSolution();
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


// ( referencedChildren += [ Child ] ) ?
protected class SecondConcrete_0_1_Assignment_referencedChildren extends AssignmentToken  {
	
	public SecondConcrete_0_1_Assignment_referencedChildren(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele01AssignmentReferencedChildren();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("referencedChildren",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("referencedChildren");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Child")) {
				type = AssignmentType.CR;
				element = PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele010CrossReferenceEStringChild(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// ")"
protected class SecondConcrete_1_Keyword extends KeywordToken  {
	
	public SecondConcrete_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule SecondConcrete ****************/


/************ begin Rule Named ****************
 *
 * Named : name = ID ;
 *
 **/


// name = ID
protected class Named_Assignment_name extends AssignmentToken  {
	
	public Named_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNamed().eleAssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = PartialParserTestLanguageGrammarAccess.INSTANCE.prNamed().ele0LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule Named ****************/

}
