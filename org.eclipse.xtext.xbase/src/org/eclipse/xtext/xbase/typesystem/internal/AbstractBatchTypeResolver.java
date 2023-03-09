/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.xtext.JvmMemberInitializableResource;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.scoping.batch.FeatureScopes;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractBatchTypeResolver implements IBatchTypeResolver {

	//non-final because of LoggerTester test
	private static Logger LOG = Logger.getLogger(AbstractBatchTypeResolver.class);
	
	@Inject
	private IBatchScopeProvider scopeProvider;
	@Inject
	private FeatureScopes featureScopes;
	@Inject
	private CommonTypeComputationServices services;
	
	protected AbstractBatchTypeResolver() {
	}
	
	/* @NonNull */
	@Override
	public IResolvedTypes resolveTypes(/* @NonNull */ Resource resource) {
		return resolveTypes(resource, null);
	}

	/* @NonNull */
	@Override
	public final IResolvedTypes resolveTypes(final /* @Nullable */ EObject object) {
		return resolveTypes(object, null);
	}
	
	/* @NonNull */
	@Override
	public final IResolvedTypes resolveTypes(final /* @Nullable */ EObject object, CancelIndicator monitor) {
		if (object == null || object.eIsProxy()) {
			return IResolvedTypes.NULL;
		}
		Resource resource = object.eResource();
		validateResourceState(resource);
		if (resource instanceof JvmMemberInitializableResource) {
			((JvmMemberInitializableResource) resource).ensureJvmMembersInitialized();
		}
		return doResolveTypes(object, monitor);
	}

	/**
	 * Checks the internal state of the resource and logs if type resolution was triggered unexpectedly.
	 */
	protected void validateResourceState(Resource resource) {
		if (resource instanceof StorageAwareResource && ((StorageAwareResource) resource).isLoadedFromStorage()) {
			LOG.error("Discouraged attempt to compute types for resource that was loaded from storage. Resource was : "+resource.getURI(), new Exception());
		}
	}
	
	/* @NonNull */
	@Override
	public IResolvedTypes resolveTypes(/* @NonNull */ Resource resource, /* @Nullable */ CancelIndicator monitor) {
		validateResourceState(resource);
		List<EObject> resourceContents = resource.getContents();
		if (resourceContents.isEmpty()) {
			IFeatureScopeSession session = scopeProvider.newSession(resource);
			return new EmptyResolvedTypes(session, featureScopes, new StandardTypeReferenceOwner(services, resource));
		} else {
			return resolveTypes(resourceContents.get(0), monitor);
		}
	}

	/* @NonNull */
	protected abstract IResolvedTypes doResolveTypes(/* @NonNull */ EObject object, /* @Nullable */ CancelIndicator monitor);
}
