/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.xtext.JvmMemberInitializableResource;
import org.eclipse.xtext.resource.DerivedStateAwareResource;

import com.google.common.collect.Lists;

/**
 * A type resolver that knows about derived JvmTypes that are added to the resource contents.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LogicalContainerAwareBatchTypeResolver extends DefaultBatchTypeResolver {
	
	private static final Logger LOG = Logger.getLogger(LogicalContainerAwareBatchTypeResolver.class);
	
	@Override
	protected void validateResourceState(Resource resource) {
		super.validateResourceState(resource);
		if (resource instanceof DerivedStateAwareResource && ((DerivedStateAwareResource) resource).isInitializing()) {
			LOG.error("Discouraged attempt to compute types during model inference. Resource was : "+resource.getURI(), new Exception());
		}
		if (resource instanceof JvmMemberInitializableResource && ((JvmMemberInitializableResource) resource).isInitializingJvmMembers()) {
			LOG.error("Discouraged attempt to compute types during JvmMember initialization. Resource was : "+resource.getURI(), new Exception());
		}
	}
	
	@Override
	protected List<EObject> getEntryPoints(EObject object) {
		Resource resource = object.eResource();
		List<EObject> contents = resource.getContents();
		List<EObject> result = Lists.newArrayList();
		for(EObject content: contents) {
			if (content instanceof JvmType) {
				result.add(content);
			}
		}
		if (result.isEmpty()) {
			return super.getEntryPoints(object);
		}
		return result;
	}

}
