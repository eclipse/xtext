
package org.eclipse.xtext.parsetree.reconstr;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.parser.ComplexReconstrTestASTFactory;

public class ComplexReconstrTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new ComplexReconstrTestASTFactory();
	private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestConstants.getComplexReconstrTestGrammar();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}


public void proceedOp(EObject obj) {
	proceedOp(getDescr(obj));
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

	Object value = obj.consume("addOperands");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal");
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

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("addOperands"));
	action(obj,newObj, (Action) grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0"));
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

	Object value = obj.consume("minusOperands");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal");
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

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Action */ 
{

	InstanceDescription newObj = getDescr((EObject) obj.consume("minusOperands"));
	action(obj,newObj, (Action) grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0"));
	obj = newObj;

}


}


}

		}
	

}

		
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedTerm(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}


}

}

public void proceedTerm(EObject obj) {
	proceedTerm(getDescr(obj));
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
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.1/@alternatives/@groups.0");
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
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.1/@alternatives/@groups.1");
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

public void proceedAtom(EObject obj) {
	proceedAtom(getDescr(obj));
}

protected void proceedAtom(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.2/@alternatives/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

public void proceedParens(EObject obj) {
	proceedParens(getDescr(obj));
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

	Object value = obj.consume("em");
    
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal"));

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = obj;
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1");
	try {
		ruleCallStart(val, false, (RuleCall) ruleCall);
		proceedOp(val);
	} finally {
		ruleCallEnd(val, false, (RuleCall) ruleCall);
	}
	

}

		
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"));

}


}


}


}

}

}
