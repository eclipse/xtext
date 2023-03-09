/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceStorageWritable {
	private final OutputStream out;

	private final boolean storeNodeModel;

	public ResourceStorageWritable(OutputStream out, boolean storeNodeModel) {
		this.out = out;
		this.storeNodeModel = storeNodeModel;
	}

	public void writeResource(StorageAwareResource resource) throws IOException {
		if (resource.isLoadedFromStorage())
			throw new IllegalStateException("cannot write resources loaded from storage. URI was " + resource.getURI());
		try (ZipOutputStream zipOut = new ZipOutputStream(out)) {
			writeEntries(resource, zipOut);
		}
	}

	/**
	 * Write entries into the storage. Overriding methods should first delegate to super before adding their own
	 * entries.
	 */
	protected void writeEntries(StorageAwareResource resource, ZipOutputStream zipOut) throws IOException {
		BufferedOutputStream bufferedOutput = new BufferedOutputStream(zipOut);
		zipOut.putNextEntry(new ZipEntry("emf-contents"));
		try {
			writeContents(resource, bufferedOutput);
		} finally {
			bufferedOutput.flush();
			zipOut.closeEntry();
		}
		zipOut.putNextEntry(new ZipEntry("resource-description"));
		try {
			writeResourceDescription(resource, bufferedOutput);
		} finally {
			bufferedOutput.flush();
			zipOut.closeEntry();
		}
		if (storeNodeModel) {
			zipOut.putNextEntry(new ZipEntry("node-model"));
			try {
				writeNodeModel(resource, bufferedOutput);
			} finally {
				bufferedOutput.flush();
				zipOut.closeEntry();
			}
		}
	}

	protected void writeContents(StorageAwareResource storageAwareResource, OutputStream outputStream)
			throws IOException {
		BinaryResourceImpl.EObjectOutputStream out = new BinaryResourceImpl.EObjectOutputStream(outputStream,
				Collections.emptyMap()) {
			@Override
			public void writeURI(URI uri, String fragment) throws IOException {
				URI fullURI = uri.appendFragment(fragment);
				URI portableURI = storageAwareResource.getPortableURIs().toPortableURI(storageAwareResource, fullURI);
				URI uriToWrite = portableURI == null ? fullURI : portableURI;
				super.writeURI(uriToWrite.trimFragment(), uriToWrite.fragment());
			}

			@Override
			public void saveEObject(InternalEObject internalEObject, BinaryResourceImpl.EObjectOutputStream.Check check)
					throws IOException {
				beforeSaveEObject(internalEObject, this);
				super.saveEObject(internalEObject, check);
				handleSaveEObject(internalEObject, this);
			}
		};
		try {
			out.saveResource(storageAwareResource);
		} finally {
			out.flush();
		}
	}

	protected void beforeSaveEObject(InternalEObject object, BinaryResourceImpl.EObjectOutputStream writable)
			throws IOException {
	}

	protected void handleSaveEObject(InternalEObject object, BinaryResourceImpl.EObjectOutputStream out)
			throws IOException {
	}

	protected void writeResourceDescription(StorageAwareResource resource, OutputStream outputStream)
			throws IOException {
		IResourceDescription description = resource.getResourceServiceProvider().getResourceDescriptionManager()
				.getResourceDescription(resource);
		SerializableResourceDescription serializableDescription = SerializableResourceDescription
				.createCopy(description);
		convertExternalURIsToPortableURIs(serializableDescription, resource);
		ObjectOutputStream out = new ObjectOutputStream(outputStream);
		try {
			out.writeObject(serializableDescription);
		} finally {
			out.flush();
		}
	}

	protected void convertExternalURIsToPortableURIs(SerializableResourceDescription description,
			StorageAwareResource resource) {
		for (IReferenceDescription ref : description.getReferenceDescriptions()) {
			if (!ref.getTargetEObjectUri().trimFragment().equals(resource.getURI())) {
				URI portableURI = resource.getPortableURIs().toPortableURI(resource, ref.getTargetEObjectUri());
				((SerializableReferenceDescription) ref)
						.setTargetEObjectUri(portableURI != null ? portableURI : ref.getTargetEObjectUri());
			}
		}
	}

	protected void writeNodeModel(StorageAwareResource resource, OutputStream outputStream) throws IOException {
		DataOutputStream out = new DataOutputStream(outputStream);
		new SerializableNodeModel(resource).writeObjectData(out, new SerializationConversionContext(resource));
		out.flush();
	}

}
