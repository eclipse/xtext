
package org.eclipse.xtext.metamodelreferencing.tests.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.metamodelreferencing.tests.parsetree.internal.InternalMetamodelRefTestParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class MetamodelRefTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalMetamodelRefTestParseTreeConstructor(getFactory(),getGrammar()).update(object);
	}
}
