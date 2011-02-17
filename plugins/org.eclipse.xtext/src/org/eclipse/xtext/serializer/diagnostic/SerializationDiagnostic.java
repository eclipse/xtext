/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializationDiagnostic implements ISerializationDiagnostic {

	protected static EStructuralFeature getFeature(EObject semanticObject, AbstractElement element) {
		if (semanticObject != null && element != null) {
			Assignment ass = GrammarUtil.containingAssignment(element);
			if (ass != null && ass.getFeature() != null)
				return semanticObject.eClass().getEStructuralFeature(ass.getFeature());
		}
		return null;
	}

	protected EStructuralFeature feature;

	protected String message;

	protected EObject semanticObject;

	public SerializationDiagnostic(EObject semanticObject, AbstractElement element, String message) {
		this(semanticObject, getFeature(semanticObject, element), message);
	}

	public SerializationDiagnostic(EObject semanticObject, EStructuralFeature feature, String message) {
		super();
		this.semanticObject = semanticObject;
		this.message = message;
		this.feature = feature;
	}

	public SerializationDiagnostic(EObject semanticObject, String message) {
		this(semanticObject, (EStructuralFeature) null, message);
	}

	public boolean breaksSyntax() {
		return true;
	}

	public Throwable getException() {
		return null;
	}

	public String getMessage() {
		return "foo bar";
	}

	public EObject getSemanitcObject() {
		return null;
	}

}
