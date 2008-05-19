
package org.eclipse.xtext.grammargen.tests;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTest2ASTFactory;

public class SimpleTest2ParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new SimpleTest2ASTFactory();
	
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

while (obj.isConsumable("contents")){

	if (!obj.isConsumable("contents")) return false;
    Object value = obj.consume("contents");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedChild(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedChild(EObject obj) {
	if (!proceedChild(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedChildLock = new HashSet<ConsumationState>();

protected boolean proceedChild(InstanceDescription obj) {
	obj.push("proceedChild");
	try {
		if (! obj.isInstanceOf("Child"))
		   return false;
		
/* xtext::Group */ 
{

		
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
    	System.out.print("keyword");

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
{

	if (!obj.isConsumable("number")) return false;
    Object value = obj.consume("number");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("{");

}


}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Keyword */ 
{

	if (!obj.isLookahead())
    	System.out.print("}");

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

}
