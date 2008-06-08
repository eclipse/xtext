
/*
Generated using Xtext at Sun Jun 08 11:15:24 CEST 2008
*/
package org.eclipse.xtext.metamodelreferencing.tests.parsetree.internal;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parsetree.Predicate;
import org.eclipse.xtext.parsetree.internal.AbstractInternalParseTreeConstructor;

public class InternalMetamodelRefTestParseTreeConstructor extends AbstractInternalParseTreeConstructor {

	public InternalMetamodelRefTestParseTreeConstructor(GenericEcoreElementFactory factory, Grammar grammar, IValueConverterService converterService) {
		super(factory,grammar,converterService);
	}

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Foo")) {
			proceedFoo(getDescr(obj));
		} else 		if (ruleToCall.equals("NameRef")) {
			proceedNameRef(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedFoo(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("nameRefs"); 
		}
}.check() ){

	final Object value = obj.consume("nameRefs");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedNameRef(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}


}

}

protected void proceedNameRef(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
		
		lexerRuleCall(value,(RuleCall)getGrammar().eResource().getEObject("//@parserRules.1/@alternatives/@terminal"));
		
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

}
