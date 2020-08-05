/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.resource;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.FluentIterable;

/**
 * @author Sven Efftinge
 */
public class BatchLinkableResourceStorageWritable extends ResourceStorageWritable {
	private static final Logger LOG = Logger.getLogger(BatchLinkableResourceStorageWritable.class);

	public BatchLinkableResourceStorageWritable(OutputStream out, boolean storeNodeModel) {
		super(out, storeNodeModel);
	}

	@Override
	protected void writeEntries(StorageAwareResource resource, ZipOutputStream zipOut) throws IOException {
		super.writeEntries(resource, zipOut);
		if (resource instanceof BatchLinkableResource) {
			zipOut.putNextEntry(new ZipEntry("associations"));
			BufferedOutputStream buffOut = new BufferedOutputStream(zipOut);
			try {
				writeAssociationsAdapter((BatchLinkableResource) resource, buffOut);
			} finally {
				buffOut.flush();
				zipOut.closeEntry();
			}
		}
	}

	@Override
	protected void beforeSaveEObject(InternalEObject object, BinaryResourceImpl.EObjectOutputStream writable)
			throws IOException {
		super.beforeSaveEObject(object, writable);
		// make sure lazy type references are computed
		if (object instanceof XComputedTypeReference) {
			((XComputedTypeReference) object).getType();
		}
	}

	@Override
	protected void handleSaveEObject(InternalEObject object, BinaryResourceImpl.EObjectOutputStream out)
			throws IOException {
		super.handleSaveEObject(object, out);
		
		DocumentationAdapter documentationAdapter = null;
		JvmIdentifiableMetaData metaDataAdapter = null;
		for (Adapter adapter : object.eAdapters()) {
			if (adapter instanceof DocumentationAdapter) {
				documentationAdapter = (DocumentationAdapter) adapter;
			}
			if (adapter instanceof JvmIdentifiableMetaData) {
				metaDataAdapter = (JvmIdentifiableMetaData) adapter;
			}
		}
		// store Documentation adapters
		if (documentationAdapter != null) {
			out.writeBoolean(true);
			out.writeString(documentationAdapter.getDocumentation());
		} else {
			out.writeBoolean(false);
		}
		// store additional meta data
		if (metaDataAdapter != null) {
			out.writeBoolean(true);
			out.writeBoolean(metaDataAdapter.isSynthetic());
		} else {
			out.writeBoolean(false);
		}
	}

	protected void writeAssociationsAdapter(BatchLinkableResource resource, OutputStream zipOut) throws IOException {
		JvmModelAssociator.Adapter adapter = (JvmModelAssociator.Adapter) EcoreUtil.getExistingAdapter(resource, JvmModelAssociator.Adapter.class);
		if (adapter == null) {
			for(int i = 1, max = resource.getContents().size(); i < max; i++) {
				if (resource.getContents().get(i) instanceof JvmType) {
					throw new IOException("Missing JvmModelAssociator.Adapter but resource contains inferred types: " + resource.getURI());
				}
			}
			adapter = new JvmModelAssociator.Adapter();
		}
		try (ObjectOutputStream objOut = new ObjectOutputStream(zipOut) {
			@Override
			public void close() throws IOException {
				flush();
			}
		}) {
			// logicalMap
			Map<String, String> logicalMap = new LinkedHashMap<>();
			adapter.logicalContainerMap.forEach((key, value)->{
				logIfResourceMismatch(resource, key);
				logicalMap.put(getFragment(key), getFragment(value));
			});
			objOut.writeObject(logicalMap);
			
			writeAssociationMap(adapter.sourceToTargetMap, resource, objOut);
			writeAssociationMap(adapter.targetToSourceMap, resource, objOut);
		}
	}
	
	private void writeAssociationMap(Map<EObject, Set<EObject>> serializeMe, BatchLinkableResource resource, ObjectOutputStream objOut) throws IOException {
		Map<String, Set<String>> fragmentMap = new LinkedHashMap<>();
		serializeMe.forEach((keyObject, valueObjects)->{
			logIfResourceMismatch(resource, keyObject);
			fragmentMap.put(getFragment(keyObject), objectsToFragments(valueObjects));
		});
		objOut.writeObject(fragmentMap);
	}

	private void logIfResourceMismatch(BatchLinkableResource resource, EObject object) {
		Resource keyResource = object.eResource();
		if (resource != keyResource) {
			LOG.info("object (" + object + ") not from resource " + resource.getURI() + " but from " + (keyResource == null ? null : keyResource.getURI()));
		}
	}
	
	private Set<String> objectsToFragments(Set<EObject> objects) {
		return FluentIterable.from(objects)
			.transform(this::getFragment)
			.copyInto(new LinkedHashSet<>());
	}

	protected String getFragment(EObject obj) {
		if (obj == null || obj.eIsProxy() || obj.eResource() == null) {
			return "none";
		}
		return obj.eResource().getURIFragment(obj);
	}

}
