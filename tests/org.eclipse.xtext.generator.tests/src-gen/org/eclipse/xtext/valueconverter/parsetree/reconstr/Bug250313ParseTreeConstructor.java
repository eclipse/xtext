/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class Bug250313ParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Ref2") && (s = new Ref2_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Ref2 ****************
 *
 * Ref2 : '#2' ref2 = ( 'mykeyword1' | STRING | ID ) ;
 *
 **/


// '#2' ref2 = ( 'mykeyword1' | STRING | ID )
protected class Ref2_Group extends GroupToken {
	
	public Ref2_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Ref2_1_Assignment_ref2(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Ref2_0_Keyword_2(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// '#2'
protected class Ref2_0_Keyword_2 extends KeywordToken  {
	
	public Ref2_0_Keyword_2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	}	
}

// ref2 = ( 'mykeyword1' | STRING | ID )
protected class Ref2_1_Assignment_ref2 extends AssignmentToken  {
	
	public Ref2_1_Assignment_ref2(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ref2",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ref2");
		if("mykeyword1".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0");
			return new Solution(obj);
		}
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1"); 
			return new Solution(obj);
		}
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.1"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Ref2 ****************/

}
