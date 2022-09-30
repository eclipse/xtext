/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

class ClassFileResourceDescription extends AbstractResourceDescription {

	final URI uri;
	final Set<ClassFileEObjectDescription> descriptions;

	ClassFileResourceDescription(URI uri, Set<ClassFileEObjectDescription> descriptions) {
		this.uri = uri;
		this.descriptions = descriptions;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		return Collections.emptySet();
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Collections.emptySet();
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		return new ArrayList<>(descriptions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(descriptions, uri);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassFileResourceDescription other = (ClassFileResourceDescription) obj;
		return Objects.equals(descriptions, other.descriptions) && Objects.equals(uri, other.uri);
	}

}