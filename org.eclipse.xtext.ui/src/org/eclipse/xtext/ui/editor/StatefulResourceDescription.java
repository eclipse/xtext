/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StatefulResourceDescription extends AbstractResourceDescription {

	private URI uri;
	private ImmutableList<IEObjectDescription> exported;
	private final Provider<IResourceDescription> snapShotProvider;
	
	public StatefulResourceDescription(IResourceDescription original, Provider<IResourceDescription> snapShotProvider) {
		this.snapShotProvider = snapShotProvider;
		this.uri = original.getURI();
		this.exported = copyExportedObjects(original);
	}

	protected ImmutableList<IEObjectDescription> copyExportedObjects(IResourceDescription original) {
		return ImmutableList.copyOf(Iterables.filter(Iterables.transform(original.getExportedObjects(), new Function<IEObjectDescription, IEObjectDescription>() {
			@Override
			public IEObjectDescription apply(IEObjectDescription from) {
				if (from == null)
					return null;
				EObject proxy = from.getEObjectOrProxy();
				if (proxy == null)
					return null;
				if (proxy.eIsProxy())
					return from;
				InternalEObject result = (InternalEObject) EcoreUtil.create(from.getEClass());
				result.eSetProxyURI(EcoreUtil.getURI(from.getEObjectOrProxy()));
				Map<String, String> userData = null;
				for(String key: from.getUserDataKeys()) {
					if (userData == null) {
						userData = Maps.newHashMapWithExpectedSize(2);
					}
					userData.put(key, from.getUserData(key));
				}
				return EObjectDescription.create(from.getName(), result, userData);
			}
		}), Predicates.notNull()));
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		return exported;
	}
	
	@Override
	public Iterable<QualifiedName> getImportedNames() {
		IResourceDescription snapShot = snapShotProvider.get();
		if (snapShot != null)
			return snapShot.getImportedNames();
		return Collections.emptyList();
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		// find references was triggered - use up-to-date reference descriptions
		// the content of this copied description is updated as soon as the exported
		// objects of a resource change thus the default algorithm of the find 
		// references UI for the display string should work
		IResourceDescription snapShot = snapShotProvider.get();
		if (snapShot != null)
			return snapShot.getReferenceDescriptions();
		return Collections.emptyList();
	}

	@Override
	public URI getURI() {
		return uri;
	}

}
