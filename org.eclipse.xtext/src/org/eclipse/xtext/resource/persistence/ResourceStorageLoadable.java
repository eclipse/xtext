/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.zip.ZipInputStream;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.parser.ParseResult;

import com.google.common.io.CharStreams;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceStorageLoadable {
	private static final Logger LOG = Logger.getLogger(ResourceStorageLoadable.class);

	private final InputStream in;

	private final boolean storeNodeModel;

	public ResourceStorageLoadable(InputStream in, boolean storeNodeModel) {
		this.in = in;
		this.storeNodeModel = storeNodeModel;
	}

	protected void loadIntoResource(StorageAwareResource resource) throws IOException {
		if (!resource.isLoadedFromStorage())
			throw new IllegalStateException("Please use StorageAwareResource#load(ResourceStorageLoadable).");
		try (ZipInputStream zin = new ZipInputStream(in)) {
			loadEntries(resource, zin);
		}
	}

	/**
	 * Load entries from the storage. Overriding methods should first delegate to super before adding their own entries.
	 */
	protected void loadEntries(StorageAwareResource resource, ZipInputStream zipIn) throws IOException {
		zipIn.getNextEntry();
		readContents(resource, new BufferedInputStream(zipIn));
		zipIn.getNextEntry();
		readResourceDescription(resource, new BufferedInputStream(zipIn));
		if (storeNodeModel) {
			zipIn.getNextEntry();
			readNodeModel(resource, new BufferedInputStream(zipIn));
		}
	}

	protected void readContents(StorageAwareResource resource, InputStream inputStream) throws IOException {
		new BinaryResourceImpl.EObjectInputStream(inputStream, Collections.emptyMap()) {
			@Override
			public int readCompressedInt() throws IOException {
				//HACK! null resource set, to avoid usage of resourceSet's package registry
				resourceSet = null;
				return super.readCompressedInt();
			}

			@Override
			public InternalEObject loadEObject() throws IOException {
				InternalEObject result = super.loadEObject();
				handleLoadEObject(result, this);
				return result;
			}
		}.loadResource(resource);
	}

	protected void handleLoadEObject(InternalEObject loaded, BinaryResourceImpl.EObjectInputStream input)
			throws IOException {
	}

	protected void readResourceDescription(StorageAwareResource resource, InputStream inputStream) throws IOException {
		try {
			SerializableResourceDescription description = (SerializableResourceDescription) new ObjectInputStream(
					inputStream).readObject();
			description.updateResourceURI(resource.getURI());
			resource.setResourceDescription(description);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	protected void readNodeModel(StorageAwareResource resource, InputStream inputStream) throws IOException {
		SerializableNodeModel serializableNodeModel = new SerializableNodeModel(resource);
		// if this is a synthetic resource (i.e. tests or so, don't load the node model)
		if (!resource.getResourceSet().getURIConverter().exists(resource.getURI(),
				resource.getResourceSet().getLoadOptions())) {
			LOG.info("Skipping loading node model for synthetic resource " + resource.getURI());
			return;
		}
		String completeContent = CharStreams.toString(
				new InputStreamReader(resource.getResourceSet().getURIConverter().createInputStream(resource.getURI()),
						resource.getEncoding()));
		DeserializationConversionContext deserializationContext = new DeserializationConversionContext(resource,
				completeContent);
		serializableNodeModel.readObjectData(new DataInputStream(inputStream), deserializationContext);
		resource.setParseResult(new ParseResult(head(resource.getContents()), serializableNodeModel.root,
				deserializationContext.hasErrors()));
	}

}
