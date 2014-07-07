/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import static com.google.common.collect.Lists.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.descriptions.JvmDeclaredTypeSignatureHashProvider;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

/**
 * A resource description representing a dirty {@link BatchLinkableResource}. Only type stubs are indexed with a
 * signature that is a hash over the entire model text. This is necessary in order to shadow compiled types that have
 * been deleted in the dirty state.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @see XbaseDocumentReconcileStrategy 
 * @see XbaseDirtyStateEditorSupport
 */
public class XbaseDirtyStateResourceDescription extends AbstractResourceDescription {

	public static class Manager implements IResourceDescription.Manager {

		@Inject
		private IResourceDescription.Manager delegate;

		@Inject
		private IQualifiedNameProvider qualifiedNameProvider;

		@Inject
		private JvmDeclaredTypeSignatureHashProvider hashProvider;

		public IResourceDescription getResourceDescription(Resource resource) {
			if (resource instanceof BatchLinkableResource) {
				BatchLinkableResource batchLinkableResource = (BatchLinkableResource) resource;
				try {
					batchLinkableResource.eSetDeliver(false);
					batchLinkableResource.installDerivedState(true);
					return createResourceDescription(batchLinkableResource);
				} finally {
					batchLinkableResource.discardDerivedState();
				}
			}
			return null;
		}

		protected IResourceDescription createResourceDescription(BatchLinkableResource resource) {
			return new XbaseDirtyStateResourceDescription(resource, computeTypes(resource));
		}

		private List<IEObjectDescription> computeTypes(BatchLinkableResource resource) {
			List<IEObjectDescription> result = newArrayList();
			String hash = hashProvider.getTextHash(resource);
			ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
			builder.put(JvmTypesResourceDescriptionStrategy.SIGNATURE_HASH_KEY, hash);
			ImmutableMap<String, String> userData = builder.build();
			for (TreeIterator<EObject> i = EcoreUtil.getAllProperContents(resource, true); i.hasNext();) {
				EObject next = i.next();
				if (next instanceof JvmType) {
					QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(next);
					if (qualifiedName != null) {
						result.add(EObjectDescription.create(qualifiedName, next, userData));
					}
				}
			}
			return result;
		}

		public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
			return delegate.createDelta(oldDescription, newDescription);
		}

		public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
			return delegate.isAffected(delta, candidate);
		}

		public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate,
				IResourceDescriptions context) throws IllegalArgumentException {
			return delegate.isAffected(deltas, candidate, context);
		}
	}

	private URI uri;

	List<IEObjectDescription> types;

	public XbaseDirtyStateResourceDescription(BatchLinkableResource resource, List<IEObjectDescription> types) {
		this.uri = resource.getURI();
		this.types = types;
	}

	public Iterable<QualifiedName> getImportedNames() {
		return Collections.emptyList();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Collections.emptyList();
	}

	public URI getURI() {
		return uri;
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		return types;
	}
}
