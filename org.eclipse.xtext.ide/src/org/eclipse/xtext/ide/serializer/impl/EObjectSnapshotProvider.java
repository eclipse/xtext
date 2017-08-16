/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
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

		public URI getContainerEObjectURI() {
			return containerEObjectURI;
		}

		public EReference getEReference() {
			return eReference;
		}

		public int getIndexInList() {
			return indexInList;
		}

		public URI getSourceEObjectUri() {
			return sourceEObjectUri;
		}

		public IEObjectSnapshot getTarget() {
			return targetEObject;
		}
	}

	public static class ResourceSnapshot implements IResourceSnapshot {
		protected final Map<EObject, IEObjectSnapshot> objects;
		protected final ITextRegionAccess regions;
		protected final Resource resource;
		protected final URI uri;

		public ResourceSnapshot(EObjectSnapshotProvider strategy, Resource resource) {
			this.resource = resource;
			this.regions = strategy.getTextRegionAccess(resource);
			this.objects = strategy.createEObjectSnapshots(resource);
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
				if (!uri.equals(targetURI.trimFragment())) {
					continue;
				}
				EObject target = resource.getEObject(targetURI.fragment());
				EObjectSnapshot snapshot = getOrCreate(result, target);
				ReferenceSnapshot rd = new ReferenceSnapshot(ref.getSourceEObjectUri(), snapshot, ref.getEReference(),
						ref.getIndexInList(), ref.getContainerEObjectURI());
				snapshot.incomingReferences.add(rd);
			}
		}
		return result;

	}

	public IResourceSnapshot createResourceSnapshot(Resource resource) {
		return new ResourceSnapshot(this, resource);
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
