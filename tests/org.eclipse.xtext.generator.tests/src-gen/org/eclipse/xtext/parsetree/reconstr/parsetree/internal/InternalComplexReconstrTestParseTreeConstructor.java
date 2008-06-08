
/*
Generated using Xtext at Sun Jun 08 11:15:26 CEST 2008
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree.internal;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parsetree.Predicate;
import org.eclipse.xtext.parsetree.internal.AbstractInternalParseTreeConstructor;

public class InternalComplexReconstrTestParseTreeConstructor extends AbstractInternalParseTreeConstructor {

	public InternalComplexReconstrTestParseTreeConstructor(GenericEcoreElementFactory factory, Grammar grammar, IValueConverterService converterService) {
		super(factory,grammar,converterService);
	}

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Op")) {
			proceedOp(getDescr(obj));
		} else 		if (ruleToCall.equals("Term")) {
			proceedTerm(getDescr(obj));
		} else 		if (ruleToCall.equals("Atom")) {
			proceedAtom(getDescr(obj));
		} else 		if (ruleToCall.equals("Parens")) {
			proceedParens(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedOp(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Alternatives */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("addOperands")&&true&&obj.isOfType("Add") && 
	obj.checkConsume("addOperands") && obj.isConsumed(); 
		}
}.check() ||
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("minusOperands")&&true&&obj.isOfType("Minus") && 
	obj.checkConsume("minusOperands") && obj.isConsumed(); 
		}
}.check() ){

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("addOperands")&&true&&obj.isOfType("Add") && 
	obj.checkConsume("addOperands") && obj.isConsumed(); 
		}
}.check() ) {
			
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("addOperands");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedTerm(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("addOperands"));
	action(obj,newObj, (Action) getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("minusOperands")&&true&&obj.isOfType("Minus") && 
	obj.checkConsume("minusOperands") && obj.isConsumed(); 
		}
}.check() ) {
			
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("minusOperands");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedTerm(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("minusOperands"));
	action(obj,newObj, (Action) getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		}
	

}

		
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedTerm(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}


}

}

protected void proceedTerm(InstanceDescription obj) {
	
/* xtext::Alternatives */ 
{

		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Atom"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@groups.0");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedAtom(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		}
	else		if (
new Predicate(obj) { 
		public boolean check() {
			return obj.isInstanceOf("Expression"); 
		}
}.check() ) {
			
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@groups.1");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedParens(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		}
	
		else {
		    throw new IllegalStateException("No alternative matched");
		}
	

}

}

protected void proceedAtom(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.2/@alternatives/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

protected void proceedParens(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("em"); 
		}
}.check() ){

	final Object value = obj.consume("em");
    
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedOp(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)getGrammar().eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

}

}
