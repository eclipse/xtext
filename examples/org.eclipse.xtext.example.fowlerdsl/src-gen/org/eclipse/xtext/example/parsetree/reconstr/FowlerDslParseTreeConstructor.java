/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;


public class FowlerDslParseTreeConstructor extends AbstractParseTreeConstructor {

	public IAbstractToken serialize(EObject object) {
		Solution t = internalSerialize(object);
		if(t == null) throw new XtextSerializationException(getDescr(object), "No rule found for serialization");
		return t.getPredecessor();
	}
	
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Statemachine") && (s = new Statemachine_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Event") && (s = new Event_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Command") && (s = new Command_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("State") && (s = new State_Group(inst, null).firstSolution()) != null) return s;
		if(inst.isInstanceOf("Transition") && (s = new Transition_Group(inst, null).firstSolution()) != null) return s;
		return null;
	}
	
/************ begin Rule Statemachine ****************
 *
 * Statemachine : 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end' ( states += State ) * ;
 *
 **/


// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end' ( states += State ) *
protected class Statemachine_Group extends GroupToken {
	
	public Statemachine_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_1_Assignment_states(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) * 'end'
protected class Statemachine_0_Group extends GroupToken {
	
	public Statemachine_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'events' ( events += Event ) * 'end' 'commands' ( commands += Command ) *
protected class Statemachine_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_1_Assignment_commands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'events' ( events += Event ) * 'end' 'commands'
protected class Statemachine_0_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_0_1_Keyword_commands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'events' ( events += Event ) * 'end'
protected class Statemachine_0_0_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_0_0_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'events' ( events += Event ) *
protected class Statemachine_0_0_0_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_0_0_0_1_Assignment_events(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_0_0_0_Keyword_events(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'events'
protected class Statemachine_0_0_0_0_0_0_Keyword_events extends KeywordToken  {
	
	public Statemachine_0_0_0_0_0_0_Keyword_events(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// ( events += Event ) *
protected class Statemachine_0_0_0_0_0_1_Assignment_events extends AssignmentToken  {
	
	public Statemachine_0_0_0_0_0_1_Assignment_events(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("events",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("events");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Event")) {
				Solution s = new Event_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// 'end'
protected class Statemachine_0_0_0_0_1_Keyword_end extends KeywordToken  {
	
	public Statemachine_0_0_0_0_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// 'commands'
protected class Statemachine_0_0_0_1_Keyword_commands extends KeywordToken  {
	
	public Statemachine_0_0_0_1_Keyword_commands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( commands += Command ) *
protected class Statemachine_0_0_1_Assignment_commands extends AssignmentToken  {
	
	public Statemachine_0_0_1_Assignment_commands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("commands",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("commands");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Command")) {
				Solution s = new Command_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// 'end'
protected class Statemachine_0_1_Keyword_end extends KeywordToken  {
	
	public Statemachine_0_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( states += State ) *
protected class Statemachine_1_Assignment_states extends AssignmentToken  {
	
	public Statemachine_1_Assignment_states(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("states",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("states");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("State")) {
				Solution s = new State_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


/************ end Rule Statemachine ****************/

/************ begin Rule Event ****************
 *
 * Event : ( resetting ?= 'resetting' ) ? name = ID code = ID ;
 *
 **/


// ( resetting ?= 'resetting' ) ? name = ID code = ID
protected class Event_Group extends GroupToken {
	
	public Event_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Event_1_Assignment_code(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Event_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( resetting ?= 'resetting' ) ? name = ID
protected class Event_0_Group extends GroupToken {
	
	public Event_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Event_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Event_0_0_Assignment_resetting(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( resetting ?= 'resetting' ) ?
protected class Event_0_0_Assignment_resetting extends AssignmentToken  {
	
	public Event_0_0_Assignment_resetting(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("resetting",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("resetting");
		if("resetting".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal");
			return new Solution(obj);
		}
		return null;
	}
}

// name = ID
protected class Event_0_1_Assignment_name extends AssignmentToken  {
	
	public Event_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// code = ID
protected class Event_1_Assignment_code extends AssignmentToken  {
	
	public Event_1_Assignment_code(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("code",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("code");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Event ****************/

/************ begin Rule Command ****************
 *
 * Command : name = ID code = ID ;
 *
 **/


// name = ID code = ID
protected class Command_Group extends GroupToken {
	
	public Command_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Command_1_Assignment_code(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Command_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name = ID
protected class Command_0_Assignment_name extends AssignmentToken  {
	
	public Command_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}

// code = ID
protected class Command_1_Assignment_code extends AssignmentToken  {
	
	public Command_1_Assignment_code(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("code",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("code");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Command ****************/

/************ begin Rule State ****************
 *
 * State : 'state' name = ID ( 'actions' '{' ( actions += [ fowlerdsl :: Command ] ) + '}' ) ? ( transitions += Transition ) * 'end' ;
 *
 **/


// 'state' name = ID ( 'actions' '{' ( actions += [ fowlerdsl :: Command ] ) + '}' ) ? ( transitions += Transition ) * 'end'
protected class State_Group extends GroupToken {
	
	public State_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new State_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'state' name = ID ( 'actions' '{' ( actions += [ fowlerdsl :: Command ] ) + '}' ) ? ( transitions += Transition ) *
protected class State_0_Group extends GroupToken {
	
	public State_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new State_0_1_Assignment_transitions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'state' name = ID ( 'actions' '{' ( actions += [ fowlerdsl :: Command ] ) + '}' ) ?
protected class State_0_0_Group extends GroupToken {
	
	public State_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'state' name = ID
protected class State_0_0_0_Group extends GroupToken {
	
	public State_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_0_0_Keyword_state(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'state'
protected class State_0_0_0_0_Keyword_state extends KeywordToken  {
	
	public State_0_0_0_0_Keyword_state(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// name = ID
protected class State_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public State_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"); 
			return new Solution(obj);
		}
		return null;
	}
}


// ( 'actions' '{' ( actions += [ fowlerdsl :: Command ] ) + '}' ) ?
protected class State_0_0_1_Group extends GroupToken {
	
	public State_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'actions' '{' ( actions += [ fowlerdsl :: Command ] ) +
protected class State_0_0_1_0_Group extends GroupToken {
	
	public State_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_0_1_Assignment_actions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'actions' '{'
protected class State_0_0_1_0_0_Group extends GroupToken {
	
	public State_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_1_0_0_0_Keyword_actions(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'actions'
protected class State_0_0_1_0_0_0_Keyword_actions extends KeywordToken  {
	
	public State_0_0_1_0_0_0_Keyword_actions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0");
	}	
}

// '{'
protected class State_0_0_1_0_0_1_Keyword extends KeywordToken  {
	
	public State_0_0_1_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	}	
}


// ( actions += [ fowlerdsl :: Command ] ) +
protected class State_0_0_1_0_1_Assignment_actions extends AssignmentToken  {
	
	public State_0_0_1_0_1_Assignment_actions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("actions",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("actions");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Command")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// '}'
protected class State_0_0_1_1_Keyword extends KeywordToken  {
	
	public State_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1");
	}	
}



// ( transitions += Transition ) *
protected class State_0_1_Assignment_transitions extends AssignmentToken  {
	
	public State_0_1_Assignment_transitions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("transitions",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("transitions");
		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Transition")) {
				Solution s = new Transition_Group(param, this).firstSolution();
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}
		return null;
	}
}


// 'end'
protected class State_1_Keyword_end extends KeywordToken  {
	
	public State_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.1");
	}	
}


/************ end Rule State ****************/

/************ begin Rule Transition ****************
 *
 * Transition : event = [ fowlerdsl :: Event ] '=>' state = [ fowlerdsl :: State ] ;
 *
 **/


// event = [ fowlerdsl :: Event ] '=>' state = [ fowlerdsl :: State ]
protected class Transition_Group extends GroupToken {
	
	public Transition_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Transition_1_Assignment_state(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Transition_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// event = [ fowlerdsl :: Event ] '=>'
protected class Transition_0_Group extends GroupToken {
	
	public Transition_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return (Group)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0");
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Transition_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Transition_0_0_Assignment_event(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// event = [ fowlerdsl :: Event ]
protected class Transition_0_0_Assignment_event extends AssignmentToken  {
	
	public Transition_0_0_Assignment_event(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("event",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("event");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Event")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// '=>'
protected class Transition_0_1_Keyword extends KeywordToken  {
	
	public Transition_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return (Keyword)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1");
	}	
}


// state = [ fowlerdsl :: State ]
protected class Transition_1_Assignment_state extends AssignmentToken  {
	
	public Transition_1_Assignment_state(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return (Assignment)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.1");
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("state",required)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("state");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("State")) {
				type = AssignmentType.CR;
				element = (AbstractElement)getGrammarEle("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal"); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


/************ end Rule Transition ****************/

}
