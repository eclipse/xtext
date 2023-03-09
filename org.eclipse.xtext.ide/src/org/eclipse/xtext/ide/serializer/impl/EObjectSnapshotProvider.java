/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.ide.serializer.hooks.IEObjectDescriptionProvider;
import org.eclipse.xtext.ide.serializer.hooks.IEObjectSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class EObjectSnapshotProvider {

	public static class EObjectSnapshot implements IEObjectSnapshot {
		protected List<IEObjectDescription> descriptions = Lists.newArrayList();
		protected List<IReferenceSnapshot> incomingReferences = Lists.newArrayList();
		protected final EObject object;

		public EObjectSnapshot(EObject object) {
			super();
			this.object = object;
		}

		@Override
		public List<IEObjectDescription> getDescriptions() {
			return descriptions;
		}

		@Override
		public List<IReferenceSnapshot> getIncomingReferences() {
			return incomingReferences;
		}

		@Override
		public EObject getObject() {
			return object;
		}

		@Override
		public String toString() {
			List<String> result = Lists.newArrayList();
			for (IEObjectDescription desc : descriptions) {
				result.add(desc.toString());
			}
			for (IReferenceSnapshot ref : incomingReferences) {
				EReference eRef = ref.getEReference();
				String cls = eRef.getEContainingClass().getName();
				String refString = cls + "." + eRef.getName() + ":" + eRef.getEReferenceType().getName();
				result.add("<- " + refString + " @ " + ref.getSourceEObjectUri());
			}
			Collections.sort(result);
			return Joiner.on("\n").join(result);
		}
	}

	public static class ReferenceSnapshot implements IReferenceSnapshot {
		private URI containerEObjectURI;
		private EReference eReference;
		private int indexInList = -1;
		private URI sourceEObjectUri;
		private IEObjectSnapshot targetEObject;

		public ReferenceSnapshot(URI sourceEObjectUri, IEObjectSnapshot targetEObject, EReference eReference,
				int indexInList, URI containerEObjectURI) {
			super();
			this.indexInList = indexInList;
			this.sourceEObjectUri = sourceEObjectUri;
			this.targetEObject = targetEObject;
			this.eReference = eReference;
			this.containerEObjectURI = containerEObjectURI;
		}

		@Override
		public URI getContainerEObjectURI() {
			return containerEObjectURI;
		}

		@Override
		public EReference getEReference() {
			return eReference;
		}

		@Override
		public int getIndexInList() {
			return indexInList;
		}

		@Override
		public URI getSourceEObjectUri() {
			return sourceEObjectUri;
		}

		@Override
		public IEObjectSnapshot getTarget() {
			return targetEObject;
		}

		@Override
		public String toString() {
			String cls = eReference.getEContainingClass().getName();
			String ref = cls + "." + eReference.getName() + ":" + eReference.getEReferenceType().getName();
			String target;
			List<IEObjectDescription> descs = targetEObject.getDescriptions();
			if (descs.size() == 0) {
				target = EcoreUtil.getURI(targetEObject.getObject()).toString();
			} else if (descs.size() == 1) {
				target = descs.get(0).toString();
			} else {
				target = "[" + Joiner.on(", ").join(descs) + "]";
			}
			return ref + " @ " + sourceEObjectUri + " -> " + target;
		}
	}

	public static class ResourceSnapshot implements IResourceSnapshot {
		protected final Map<EObject, IEObjectSnapshot> objects;
		protected final ITextRegionAccess regions;
		protected final Resource resource;
		protected final URI uri;

		public ResourceSnapshot(EObjectSnapshotProvider strategy, Resource resource, boolean recordReferences) {
			this.resource = resource;
			this.regions = strategy.getTextRegionAccess(resource);
			if (recordReferences) {
				this.objects = strategy.createEObjectSnapshots(resource);
			} else {
				this.objects = Collections.emptyMap();
			}
			this.uri = resource.getURI();
		}

		@Override
		public Map<EObject, IEObjectSnapshot> getObjects() {
			return objects;
		}

		@Override
		public ITextRegionAccess getRegions() {
			return regions;
		}

		@Override
		public Resource getResource() {
			return resource;
		}

		@Override
		public URI getURI() {
			return uri;
		}

		@Override
		public String toString() {
			List<String> result = Lists.newArrayList();
			result.add(getClass().getSimpleName() + ": " + uri);
			for (IEObjectSnapshot obj : objects.values()) {
				String value = obj.toString();
				if (value.contains("\n")) {
					result.add("{\n  " + value.replace("\n", "\n  ") + "\n}");
				} else {
					result.add(value);
				}
			}
			return Joiner.on("\n").join(result);
		}

	}

	@Inject
	private IEObjectDescriptionProvider descriptionProvider;

	@Inject
	private IResourceDescriptionsProvider resourceDescriptionsProvider;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionBuilderProvider;

	protected Map<EObject, IEObjectSnapshot> createEObjectSnapshots(Resource resource) {
		Map<EObject, IEObjectSnapshot> result = Maps.newLinkedHashMap();
		for (IEObjectDescription desc : descriptionProvider.getEObjectDescriptions(resource)) {
			EObject obj = EcoreUtil.resolve(desc.getEObjectOrProxy(), resource);
			EObjectSnapshot snapshot = getOrCreate(result, obj);
			snapshot.descriptions.add(desc);
		}
		ResourceSet resourceSet = resource.getResourceSet();
		IResourceDescriptions descriptions = resourceDescriptionsProvider.getResourceDescriptions(resourceSet);
		URI uri = resource.getURI();
		for (IResourceDescription desc : descriptions.getAllResourceDescriptions()) {
			for (IReferenceDescription ref : desc.getReferenceDescriptions()) {
				URI targetURI = ref.getTargetEObjectUri();
				URI sourceEObjectUri = ref.getSourceEObjectUri();
				EReference reference = ref.getEReference();
				if (targetURI == null || sourceEObjectUri == null || reference == null) {
					continue;
				}
				if (!uri.equals(targetURI.trimFragment())) {
					continue;
				}
				EObject target = resource.getEObject(targetURI.fragment());
				if (target == null || target.eIsProxy()) {
					continue;
				}
				EObjectSnapshot snapshot = getOrCreate(result, target);
				ReferenceSnapshot rd = new ReferenceSnapshot(sourceEObjectUri, snapshot, reference,
						ref.getIndexInList(), ref.getContainerEObjectURI());
				snapshot.incomingReferences.add(rd);
			}
		}
		return result;

	}

	public IResourceSnapshot createResourceSnapshot(Resource resource, boolean recordReferences) {
		return new ResourceSnapshot(this, resource, recordReferences);
	}

	protected EObjectSnapshot getOrCreate(Map<EObject, IEObjectSnapshot> map, EObject obj) {
		IEObjectSnapshot result = map.get(obj);
		if (result == null) {
			result = new EObjectSnapshot(obj);
			map.put(obj, result);
		}
		return (EObjectSnapshot) result;
	}

	protected ITextRegionAccess getTextRegionAccess(Resource res) {
		if (res instanceof XtextResource) {
			return textRegionBuilderProvider.get().forNodeModel((XtextResource) res).create();
		}
		return null;
	}

}
