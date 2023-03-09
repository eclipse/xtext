/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import static org.eclipse.xtext.resource.persistence.SerializationExtensions.*;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @since 2.8
 */
public class SerializableEObjectDescription
		implements IEObjectDescription, Externalizable, SerializableEObjectDescriptionProvider {
	protected URI eObjectURI;

	protected EClass eClass;

	protected QualifiedName qualifiedName;

	protected HashMap<String, String> userData;

	protected transient EObject eObjectOrProxy;

	public void updateResourceURI(URI uri) {
		eObjectURI = uri.appendFragment(eObjectURI.fragment());
	}

	@Override
	public EObject getEObjectOrProxy() {
		if (eObjectOrProxy == null) {
			EObject proxy = EcoreUtil.create(eClass);
			((InternalEObject) proxy).eSetProxyURI(eObjectURI);
			eObjectOrProxy = proxy;
		}
		return eObjectOrProxy;
	}

	@Override
	public QualifiedName getName() {
		return qualifiedName;
	}

	@Override
	public String getUserData(String key) {
		return userData.get(key);
	}

	@Override
	public String[] getUserDataKeys() {
		return userData.keySet().toArray(new String[0]);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		eObjectURI = readURI(in);
		eClass = readEcoreElement(in);
		qualifiedName = readQualifiedName(in);
		userData = readCastedObject(in);
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		writeURI(out, eObjectURI);
		writeEcoreElement(out, eClass);
		writeQualifiedName(out, qualifiedName);
		out.writeObject(userData);
	}

	@Override
	public SerializableEObjectDescription toSerializableEObjectDescription() {
		return this;
	}

	public URI getEObjectURI() {
		return eObjectURI;
	}

	public void setEObjectURI(URI eObjectURI) {
		this.eObjectURI = eObjectURI;
	}

	public EClass getEClass() {
		return eClass;
	}

	public void setEClass(EClass eClass) {
		this.eClass = eClass;
	}

	public QualifiedName getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(QualifiedName qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	public HashMap<String, String> getUserData() {
		return userData;
	}

	public void setUserData(HashMap<String, String> userData) {
		this.userData = userData;
	}
}
