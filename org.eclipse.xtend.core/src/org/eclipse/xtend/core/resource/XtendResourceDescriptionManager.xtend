/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.resource

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Collection
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionManager
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver

@Singleton
class XtendResourceDescriptionManager extends XbaseResourceDescriptionManager implements IResourceDescription.Manager.AllChangeAware {
	
	@Inject IBatchTypeResolver typeResolver
	@Inject IQualifiedNameConverter nameConverter
	
	override IResourceDescription createResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new XtendResourceDescription(resource, strategy, cache, typeResolver, nameConverter);
	}
	
	override hasChanges(Delta delta, IResourceDescription candidate) {
		super.hasChanges(delta, candidate) || candidate.containsActiveAnnotation
	}
	
	private def boolean containsActiveAnnotation(IResourceDescription description) {
		description.exportedObjects.exists[userDataKeys.contains(XtendResourceDescriptionStrategy.ACTIVE_ANNOTATION_TIMESTAMP)]
	}
	
	/**
	 * When an annotation processor changes, even if it is just its implementation, the downstream classes should be rebuilt. That is why we are interested even in 
	 * deltas that have no changed EObjectDescriptions
	 */
	override isAffectedByAny(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context) throws IllegalArgumentException {
		isAffected(deltas, candidate, context)
	}
	
}


