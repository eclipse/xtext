/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static java.util.Collections.*;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.IQueryData;

import com.google.common.base.Predicate;

public class ReferenceQueryData implements IQueryData {
	
	private URI localContextResourceURI;
	private URI leadElementURI;
	private Set<URI> targetURIs;
	private Predicate<IReferenceDescription> resultFilter;
	private String label;

	public ReferenceQueryData(URI targetURI) {
		this(targetURI, singleton(targetURI), targetURI.trimFragment(), null, "");
	}
	
	public ReferenceQueryData(URI leadElementURI, Set<URI> targetURIs, URI localContextResourceURI,
			Predicate<IReferenceDescription> resultFilter, String label) {
		this.leadElementURI = leadElementURI;
		this.targetURIs = targetURIs;
		this.localContextResourceURI = localContextResourceURI.trimFragment();
		this.resultFilter = resultFilter;
		this.label = label;
	}

	public URI getLeadElementURI() {
		return leadElementURI;
	}

	public Set<URI> getTargetURIs() {
		return targetURIs;
	}

	public Predicate<IReferenceDescription> getResultFilter() {
		return resultFilter;
	}

	public URI getLocalContextResourceURI() {
		return localContextResourceURI;
	}
	
	public String getLabel() {
		return label;
	}
}