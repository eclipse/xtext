/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.build;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescriptionProvider;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * A resource description that has no references to the origin resource anymore (thus it is "resolved"). Imported names and reference
 * descriptions are not available.
 * 
 * @since 2.29
 */
public class ResolvedResourceDescription extends AbstractResourceDescription {

	private static final Logger LOG = Logger.getLogger(ResolvedResourceDescription.class);

	private URI uri;

	private ImmutableList<IEObjectDescription> exported;

	public ResolvedResourceDescription(IResourceDescription original) {
		uri = original.getURI();
		exported = FluentIterable.from(original.getExportedObjects()).transform(from -> {
			if (from instanceof SerializableEObjectDescriptionProvider) {
				return ((SerializableEObjectDescriptionProvider) from).toSerializableEObjectDescription();
			}
			if (from.getEObjectOrProxy().eIsProxy()) {
				return from;
			}
			InternalEObject result = (InternalEObject) EcoreUtil.create(from.getEClass());
			result.eSetProxyURI(from.getEObjectURI());
			Map<String, String> userData = null;
			String[] userDataKeys = from.getUserDataKeys();
			for (String key : userDataKeys) {
				if (userData == null) {
					userData = Maps.newHashMapWithExpectedSize(userDataKeys.length);
				}
				userData.put(key, from.getUserData(key));
			}
			return EObjectDescription.create(from.getName(), result, userData);
		}).toList();
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		return exported;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		IllegalStateException exception = new IllegalStateException("getImportedNames: " + getURI());
		LOG.error(exception.getMessage(), exception);
		return Collections.emptyList();
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		IllegalStateException exception = new IllegalStateException("getReferenceDescriptions: " + getURI());
		LOG.error(exception.getMessage(), exception);
		return Collections.emptyList();
	}

	@Override
	public URI getURI() {
		return uri;
	}
}