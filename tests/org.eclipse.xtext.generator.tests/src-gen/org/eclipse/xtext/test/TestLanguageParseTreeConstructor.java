
package org.eclipse.xtext.test;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.test.parser.TestLanguageASTFactory;

public class TestLanguageParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new TestLanguageASTFactory();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}


public void proceedEntryRule(EObject obj) {
	if (!proceedEntryRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedEntryRuleLock = new HashSet<ConsumationState>();

protected boolean proceedEntryRule(InstanceDescription obj) {
	obj.push("proceedEntryRule");
	try {
		if (! obj.isInstanceOf("Model"))
		   return false;
		
/* xtext::Assignment */ 

while (obj.isConsumable("multiFeature")){

	if (!obj.isConsumable("multiFeature")) return false;
    Object value = obj.consume("multiFeature");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedAbstractRule(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedAbstractRule(EObject obj) {
	if (!proceedAbstractRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedAbstractRuleLock = new HashSet<ConsumationState>();

protected boolean proceedAbstractRule(InstanceDescription obj) {
	obj.push("proceedAbstractRule");
	try {
		if (! obj.isInstanceOf("AbstractElement"))
		   return false;
		
/* xtext::Alternatives */ 
{

		if (proceedChoiceRule(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedChoiceRule(obj);
	
	

}

		}
	else		if (proceedReducibleRule(obj.newLookaheadDescription())) {
			
/* xtext::RuleCall */ 
{

	
	
	proceedReducibleRule(obj);
	
	

}

		}

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedChoiceRule(EObject obj) {
	if (!proceedChoiceRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedChoiceRuleLock = new HashSet<ConsumationState>();

protected boolean proceedChoiceRule(InstanceDescription obj) {
	obj.push("proceedChoiceRule");
	try {
		if (! obj.isInstanceOf("ChoiceElement"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("choice");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 

if (obj.isConsumable("optionalKeyword")){

	if (!obj.isConsumable("optionalKeyword")) return false;
    Object value = obj.consume("optionalKeyword");
    
    	
    	
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("optional");

}

    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedReducibleRule(EObject obj) {
	if (!proceedReducibleRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedReducibleRuleLock = new HashSet<ConsumationState>();

protected boolean proceedReducibleRule(InstanceDescription obj) {
	obj.push("proceedReducibleRule");
	try {
		if (! obj.isInstanceOf("ReducibleElement"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("reducible");

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::RuleCall */ 
{

	
	
	proceedTerminalRule(obj);
	
	

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Group */ 

if ((obj.isOfType("ReducibleComposite") && obj.isConsumable("actionFeature"))){

		
/* xtext::Action */ 
{

	if (!obj.isConsumable("actionFeature")) return false;
	EObject newObj = (EObject) obj.consume("actionFeature");
	proceedReducibleRule(getDescr(newObj,obj.isLookahead()));

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("actionFeature")) return false;
    Object value = obj.consume("actionFeature");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedTerminalRule(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedTerminalRule(EObject obj) {
	if (!proceedTerminalRule(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedTerminalRuleLock = new HashSet<ConsumationState>();

protected boolean proceedTerminalRule(InstanceDescription obj) {
	obj.push("proceedTerminalRule");
	try {
		if (! obj.isInstanceOf("TerminalElement"))
		   return false;
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("stringFeature")) return false;
    Object value = obj.consume("stringFeature");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

}
