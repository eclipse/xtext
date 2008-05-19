
package org.eclipse.xtext.metamodelreferencing.tests;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestASTFactory;

public class MetamodelRefTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new MetamodelRefTestASTFactory();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}


public void proceedFoo(EObject obj) {
	if (!proceedFoo(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedFooLock = new HashSet<ConsumationState>();

protected boolean proceedFoo(InstanceDescription obj) {
	obj.push("proceedFoo");
	try {
		if (! obj.isInstanceOf("Foo"))
		   return false;
		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

	if (!obj.isLookahead()) System.out.print(" ");
		
/* xtext::Assignment */ 

while (obj.isConsumable("nameRefs")){

	if (!obj.isConsumable("nameRefs")) return false;
    Object value = obj.consume("nameRefs");
    
    	
/* xtext::RuleCall */ 
{

	
	proceedNameRef(getDescr((EObject)value,obj.isLookahead()));
	

}

    

}


}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

public void proceedNameRef(EObject obj) {
	if (!proceedNameRef(getDescr(obj)))
		throw new IllegalArgumentException("Couldn't rewrite "+obj);
}

private final Set<ConsumationState> proceedNameRefLock = new HashSet<ConsumationState>();

protected boolean proceedNameRef(InstanceDescription obj) {
	obj.push("proceedNameRef");
	try {
		if (! obj.isInstanceOf("xtext::RuleCall"))
		   return false;
		
/* xtext::Assignment */ 
{

	if (!obj.isConsumable("name")) return false;
    Object value = obj.consume("name");
    
    	
    	if (!obj.isLookahead())
    		System.out.print(value);
    	
    

}

		return obj.isConsumed();
	} finally {
		obj.pop();
	}
}

}
