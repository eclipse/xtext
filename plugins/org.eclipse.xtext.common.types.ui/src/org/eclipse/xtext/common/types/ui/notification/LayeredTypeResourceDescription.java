/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.collect.Iterables;

/**
 * A {@link LayeredTypeResourceDescription layered description} enhances the 
 * delegate with additionally exported objects.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LayeredTypeResourceDescription implements IResourceDescription {

	private final TypeResourceDescription delegate;
	private final List<IEObjectDescription> additionallyExported;

	public LayeredTypeResourceDescription(TypeResourceDescription delegate, List<IEObjectDescription> additionallyExported) {
		this.delegate = delegate;
		this.additionallyExported = additionallyExported;
	}
	
	public Iterable<QualifiedName> getImportedNames() {
		return delegate.getImportedNames();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return delegate.getReferenceDescriptions();
	}

	public URI getURI() {
		return delegate.getURI();
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return Iterables.concat(delegate.getExportedObjects(), additionallyExported);
	}

	public Iterable<IEObjectDescription> getExportedObjects(ISelector selector) {
		Iterable<IEObjectDescription> result = Iterables.concat(
				delegate.getExportedObjects(selector), 
				selector.applySelector(additionallyExported));
		return result;
	}

}
