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
import org.eclipse.xtext.serializer.impl.FeatureFinderUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializationDiagnostic implements ISerializationDiagnostic {

	protected EStructuralFeature feature;

	protected String message;

	protected EObject semanticObject;

	protected EObject context;

	private String id;

	public SerializationDiagnostic(String id, EObject semanticObject, AbstractElement element, String message) {
		this(id, semanticObject, semanticObject != null ? FeatureFinderUtil.getFeature(element, semanticObject.eClass())
				: null, message);
	}

	public SerializationDiagnostic(String id, EObject semanticObject, EStructuralFeature feature, String message) {
		super();
		this.id = id;
		this.semanticObject = semanticObject;
		this.message = message;
		this.feature = feature;
	}

	public SerializationDiagnostic(String id, EObject semanticObject, EObject context, String message) {
		super();
		this.id = id;
		this.semanticObject = semanticObject;
		this.message = message;
		this.context = context;
	}

	public SerializationDiagnostic(String id, EObject semanticObject, String message) {
		this(id, semanticObject, (EStructuralFeature) null, message);
	}

	public boolean breaksSyntax() {
		return true;
	}

	public Throwable getException() {
		return null;
	}

	public String getMessage() {
		return message;
	}

	public EObject getSemanticObject() {
		return semanticObject;
	}

	public EObject getContext() {
		return context;
	}

	public String getId() {
		return id;
	}
}
