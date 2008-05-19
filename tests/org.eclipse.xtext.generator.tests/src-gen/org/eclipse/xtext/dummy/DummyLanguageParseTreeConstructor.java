
package org.eclipse.xtext.dummy;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.dummy.parser.DummyLanguageASTFactory;

public class DummyLanguageParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new DummyLanguageASTFactory();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}


public void proceedModel(EObject obj) {
	if (!proceedModel(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedModelLock = new HashSet<ConsumationState>();

protected boolean proceedModel(InstanceDescription obj) {
	obj.push("proceedModel");
	try {
		if (! obj.isInstanceOf("Model"))
		   return false;
		
/* xtext::Assignment */ 

while (obj.isConsumable("elements")){

	if (!obj.isConsumable("elements")) return false;
    Object value = obj.consume("elements");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedElement(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedElement(EObject obj) {
	if (!proceedElement(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedElementLock = new HashSet<ConsumationState>();

protected boolean proceedElement(InstanceDescription obj) {
	obj.push("proceedElement");
	try {
		if (! obj.isInstanceOf("Element"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

if (obj.isConsumable("optional")){

	if (!obj.isConsumable("optional")) return false;
    Object value = obj.consume("optional");
    
    	
    	
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("optional");

}

    	
    

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("element");

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

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 

while (obj.isConsumable("descriptions")){

	if (!obj.isConsumable("descriptions")) return false;
    Object value = obj.consume("descriptions");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print(";");

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

}
