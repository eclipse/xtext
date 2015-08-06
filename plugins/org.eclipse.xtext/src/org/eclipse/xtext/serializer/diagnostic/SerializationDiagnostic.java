/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import static org.eclipse.xtext.serializer.impl.FeatureFinderUtil.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializationDiagnostic implements ISerializationDiagnostic {

	protected EStructuralFeature feature;

	protected String message;

	protected EObject semanticObject;

	protected EObject context;

	private String id;
	
	private Throwable throwable;

	public SerializationDiagnostic(String id, EObject semantic, AbstractElement element, String msg, Throwable exc) {
		this(id, semantic, semantic != null ? getFeature(element, semantic.eClass()) : null, msg, exc);
	}

	public SerializationDiagnostic(String id, EObject semanticObject, AbstractElement element, String message) {
		this(id, semanticObject, semanticObject != null ? getFeature(element, semanticObject.eClass()) : null, message);
	}

	public SerializationDiagnostic(String id, EObject semanticObject, EStructuralFeature feature, String message) {
		super();
		this.id = id;
		this.semanticObject = semanticObject;
		this.message = message;
		this.feature = feature;
	}
	
	public SerializationDiagnostic(String id, EObject semanticObject, EStructuralFeature feature, String message, Throwable throwable) {
		super();
		this.id = id;
		this.semanticObject = semanticObject;
		this.throwable = throwable;
		this.feature = feature;
		this.message = message;
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

	@Override
	public boolean breaksSyntax() {
		return true;
	}

	@Override
	public Throwable getException() {
		return throwable;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public EObject getSemanticObject() {
		return semanticObject;
	}

	@Override
	public EObject getContext() {
		return context;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public EStructuralFeature getEStructuralFeature() {
		return feature;
	}
}
