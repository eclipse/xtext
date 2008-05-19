
package org.eclipse.xtext.grammargen.tests;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTestASTFactory;

public class SimpleTestParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new SimpleTestASTFactory();
	
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
