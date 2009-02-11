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
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;


public class FowlerDslParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("Statemachine") && (s = new Statemachine_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Event") && (s = new Event_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Command") && (s = new Command_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("State") && (s = new State_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Transition") && (s = new Transition_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule Statemachine ****************
 *
 * Statemachine:   "events" (events+=Event)* "end" "commands" (commands+=Command)* "end" (states+=State)*;
 *
 **/


// "events" (events+=Event)* "end" "commands" (commands+=Command)* "end" (states+=State)*
protected class Statemachine_Group extends GroupToken {
	
	public Statemachine_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_1_Assignment_states(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "events" (events+=Event)* "end" "commands" (commands+=Command)* "end"
protected class Statemachine_0_Group extends GroupToken {
	
	public Statemachine_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "events" (events+=Event)* "end" "commands" (commands+=Command)*
protected class Statemachine_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_1_Assignment_commands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "events" (events+=Event)* "end" "commands"
protected class Statemachine_0_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_0_1_Keyword_commands(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "events" (events+=Event)* "end"
protected class Statemachine_0_0_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_0_0_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "events" (events+=Event)*
protected class Statemachine_0_0_0_0_0_Group extends GroupToken {
	
	public Statemachine_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele00000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Statemachine_0_0_0_0_0_1_Assignment_events(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Statemachine_0_0_0_0_0_0_Keyword_events(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "events"
protected class Statemachine_0_0_0_0_0_0_Keyword_events extends KeywordToken  {
	
	public Statemachine_0_0_0_0_0_0_Keyword_events(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele000000KeywordEvents();
	}	
}

// (events+=Event)*
protected class Statemachine_0_0_0_0_0_1_Assignment_events extends AssignmentToken  {
	
	public Statemachine_0_0_0_0_0_1_Assignment_events(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele000001AssignmentEvents();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("events",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("events");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Event")) {
				Solution s = new Event_Group(param, this).firstSolution();
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


// "end"
protected class Statemachine_0_0_0_0_1_Keyword_end extends KeywordToken  {
	
	public Statemachine_0_0_0_0_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele00001KeywordEnd();
	}	
}


// "commands"
protected class Statemachine_0_0_0_1_Keyword_commands extends KeywordToken  {
	
	public Statemachine_0_0_0_1_Keyword_commands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele0001KeywordCommands();
	}	
}


// (commands+=Command)*
protected class Statemachine_0_0_1_Assignment_commands extends AssignmentToken  {
	
	public Statemachine_0_0_1_Assignment_commands(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele001AssignmentCommands();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("commands",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("commands");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Command")) {
				Solution s = new Command_Group(param, this).firstSolution();
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


// "end"
protected class Statemachine_0_1_Keyword_end extends KeywordToken  {
	
	public Statemachine_0_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele01KeywordEnd();
	}	
}


// (states+=State)*
protected class Statemachine_1_Assignment_states extends AssignmentToken  {
	
	public Statemachine_1_Assignment_states(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine().ele1AssignmentStates();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("states",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("states");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("State")) {
				Solution s = new State_Group(param, this).firstSolution();
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


/************ end Rule Statemachine ****************/


/************ begin Rule Event ****************
 *
 * Event:   (resetting?="resetting")? name=ID code=ID;
 *
 **/


// (resetting?="resetting")? name=ID code=ID
protected class Event_Group extends GroupToken {
	
	public Event_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prEvent().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Event_1_Assignment_code(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Event_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// (resetting?="resetting")? name=ID
protected class Event_0_Group extends GroupToken {
	
	public Event_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prEvent().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Event_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Event_0_0_Assignment_resetting(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// (resetting?="resetting")?
protected class Event_0_0_Assignment_resetting extends AssignmentToken  {
	
	public Event_0_0_Assignment_resetting(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prEvent().ele00AssignmentResetting();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("resetting",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("resetting");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = FowlerDslGrammarAccess.INSTANCE.prEvent().ele000KeywordResetting();
			return new Solution(obj);
		}

		return null;
	}
}

// name=ID
protected class Event_0_1_Assignment_name extends AssignmentToken  {
	
	public Event_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prEvent().ele01AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = FowlerDslGrammarAccess.INSTANCE.prEvent().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// code=ID
protected class Event_1_Assignment_code extends AssignmentToken  {
	
	public Event_1_Assignment_code(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prEvent().ele1AssignmentCode();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("code",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("code");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = FowlerDslGrammarAccess.INSTANCE.prEvent().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Event ****************/


/************ begin Rule Command ****************
 *
 * Command:   name=ID code=ID;
 *
 **/


// name=ID code=ID
protected class Command_Group extends GroupToken {
	
	public Command_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prCommand().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Command_1_Assignment_code(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Command_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// name=ID
protected class Command_0_Assignment_name extends AssignmentToken  {
	
	public Command_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prCommand().ele0AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = FowlerDslGrammarAccess.INSTANCE.prCommand().ele00LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// code=ID
protected class Command_1_Assignment_code extends AssignmentToken  {
	
	public Command_1_Assignment_code(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prCommand().ele1AssignmentCode();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("code",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("code");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = FowlerDslGrammarAccess.INSTANCE.prCommand().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Command ****************/


/************ begin Rule State ****************
 *
 * State:   "state" name=ID ("actions" "{" (actions+=[Command])+ "}")? (transitions+=Transition)* "end";
 *
 **/


// "state" name=ID ("actions" "{" (actions+=[Command])+ "}")? (transitions+=Transition)* "end"
protected class State_Group extends GroupToken {
	
	public State_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new State_1_Keyword_end(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "state" name=ID ("actions" "{" (actions+=[Command])+ "}")? (transitions+=Transition)*
protected class State_0_Group extends GroupToken {
	
	public State_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new State_0_1_Assignment_transitions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "state" name=ID ("actions" "{" (actions+=[Command])+ "}")?
protected class State_0_0_Group extends GroupToken {
	
	public State_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "state" name=ID
protected class State_0_0_0_Group extends GroupToken {
	
	public State_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_0_0_Keyword_state(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "state"
protected class State_0_0_0_0_Keyword_state extends KeywordToken  {
	
	public State_0_0_0_0_Keyword_state(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele0000KeywordState();
	}	
}

// name=ID
protected class State_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public State_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele0001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = FowlerDslGrammarAccess.INSTANCE.prState().ele00010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("actions" "{" (actions+=[Command])+ "}")?
protected class State_0_0_1_Group extends GroupToken {
	
	public State_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "actions" "{" (actions+=[Command])+
protected class State_0_0_1_0_Group extends GroupToken {
	
	public State_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele0010Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_0_1_Assignment_actions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "actions" "{"
protected class State_0_0_1_0_0_Group extends GroupToken {
	
	public State_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele00100Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new State_0_0_1_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new State_0_0_1_0_0_0_Keyword_actions(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "actions"
protected class State_0_0_1_0_0_0_Keyword_actions extends KeywordToken  {
	
	public State_0_0_1_0_0_0_Keyword_actions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele001000KeywordActions();
	}	
}

// "{"
protected class State_0_0_1_0_0_1_Keyword extends KeywordToken  {
	
	public State_0_0_1_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele001001KeywordLeftCurlyBracket();
	}	
}


// (actions+=[Command])+
protected class State_0_0_1_0_1_Assignment_actions extends AssignmentToken  {
	
	public State_0_0_1_0_1_Assignment_actions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele00101AssignmentActions();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("actions",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("actions");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Command")) {
				type = AssignmentType.CR;
				element = FowlerDslGrammarAccess.INSTANCE.prState().ele001010CrossReferenceEStringCommand(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// "}"
protected class State_0_0_1_1_Keyword extends KeywordToken  {
	
	public State_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele0011KeywordRightCurlyBracket();
	}	
}



// (transitions+=Transition)*
protected class State_0_1_Assignment_transitions extends AssignmentToken  {
	
	public State_0_1_Assignment_transitions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele01AssignmentTransitions();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("transitions",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("transitions");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Transition")) {
				Solution s = new Transition_Group(param, this).firstSolution();
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


// "end"
protected class State_1_Keyword_end extends KeywordToken  {
	
	public State_1_Keyword_end(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prState().ele1KeywordEnd();
	}	
}


/************ end Rule State ****************/


/************ begin Rule Transition ****************
 *
 * Transition:   event=[Event] "=>" state=[State];
 *
 **/


// event=[Event] "=>" state=[State]
protected class Transition_Group extends GroupToken {
	
	public Transition_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prTransition().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Transition_1_Assignment_state(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Transition_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// event=[Event] "=>"
protected class Transition_0_Group extends GroupToken {
	
	public Transition_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prTransition().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Transition_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Transition_0_0_Assignment_event(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// event=[Event]
protected class Transition_0_0_Assignment_event extends AssignmentToken  {
	
	public Transition_0_0_Assignment_event(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prTransition().ele00AssignmentEvent();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("event",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("event");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Event")) {
				type = AssignmentType.CR;
				element = FowlerDslGrammarAccess.INSTANCE.prTransition().ele000CrossReferenceEStringEvent(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// "=>"
protected class Transition_0_1_Keyword extends KeywordToken  {
	
	public Transition_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prTransition().ele01KeywordEqualsSignGreaterThanSign();
	}	
}


// state=[State]
protected class Transition_1_Assignment_state extends AssignmentToken  {
	
	public Transition_1_Assignment_state(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return FowlerDslGrammarAccess.INSTANCE.prTransition().ele1AssignmentState();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("state",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("state");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("State")) {
				type = AssignmentType.CR;
				element = FowlerDslGrammarAccess.INSTANCE.prTransition().ele10CrossReferenceEStringState(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


/************ end Rule Transition ****************/

}
