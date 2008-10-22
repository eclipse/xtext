package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;

public class DefaultCrossReferenceSerializer implements
		ICrossReferenceSerializer {

	public String serializeCrossRef(IInstanceDescription container,
			CrossReference grammarElement, EObject target) {
		return null;
	}

}
