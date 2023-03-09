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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * @since 2.8
 */
public class SerializableReferenceDescription implements IReferenceDescription, Externalizable {
	private URI sourceEObjectUri;

	private URI targetEObjectUri;

	private URI containerEObjectURI;

	private EReference eReference;

	private int indexInList;

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		sourceEObjectUri = readURI(in);
		targetEObjectUri = readURI(in);
		containerEObjectURI = readURI(in);
		eReference = readEcoreElement(in);
		indexInList = in.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		writeURI(out, sourceEObjectUri);
		writeURI(out, targetEObjectUri);
		writeURI(out, containerEObjectURI);
		writeEcoreElement(out, eReference);
		out.writeInt(indexInList);
	}

	public void updateResourceURI(URI newURI, URI oldURI) {
		sourceEObjectUri = newURI.appendFragment(sourceEObjectUri.fragment());
		if (targetEObjectUri.trimFragment().equals(oldURI))
			targetEObjectUri = newURI.appendFragment(targetEObjectUri.fragment());
	}

	public URI getSourceEObjectUri() {
		return sourceEObjectUri;
	}

	public void setSourceEObjectUri(URI sourceEObjectUri) {
		this.sourceEObjectUri = sourceEObjectUri;
	}

	public URI getTargetEObjectUri() {
		return targetEObjectUri;
	}

	public void setTargetEObjectUri(URI targetEObjectUri) {
		this.targetEObjectUri = targetEObjectUri;
	}

	public URI getContainerEObjectURI() {
		return containerEObjectURI;
	}

	public void setContainerEObjectURI(URI containerEObjectURI) {
		this.containerEObjectURI = containerEObjectURI;
	}

	public EReference getEReference() {
		return eReference;
	}

	public void setEReference(EReference eReference) {
		this.eReference = eReference;
	}

	public int getIndexInList() {
		return indexInList;
	}

	public void setIndexInList(int indexInList) {
		this.indexInList = indexInList;
	}
}
