/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler;

import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.AbstractEObjectDescription;
import org.eclipse.xtext.util.Strings;

import com.google.common.hash.HashCode;

class ClassFileEObjectDescription extends AbstractEObjectDescription {

	private static final String HASH = "#";

	private final URI uri;
	private final HashCode hash;

	ClassFileEObjectDescription(URI uri, HashCode hash) {
		this.uri = uri;
		this.hash = hash;
	}

	@Override
	public QualifiedName getName() {
		return getQualifiedName();
	}

	@Override
	public QualifiedName getQualifiedName() {
		return QualifiedName.create(Strings.split(uri.fragment(), '.'));
	}

	@Override
	public EObject getEObjectOrProxy() {
		InternalEObject result = (InternalEObject) EcoreUtil.create(getEClass());
		result.eSetProxyURI(getEObjectURI());
		return result;
	}

	@Override
	public URI getEObjectURI() {
		return uri;
	}

	@Override
	public EClass getEClass() {
		return TypesPackage.Literals.JVM_GENERIC_TYPE;
	}

	@Override
	public String getUserData(String name) {
		if (HASH.equals(name)) {
			return hash.toString();
		}
		return null;
	}

	@Override
	public String[] getUserDataKeys() {
		return new String[] { HASH };
	}

	@Override
	public int hashCode() {
		return Objects.hash(hash, uri);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassFileEObjectDescription other = (ClassFileEObjectDescription) obj;
		return Objects.equals(hash, other.hash) && Objects.equals(uri, other.uri);
	}

}