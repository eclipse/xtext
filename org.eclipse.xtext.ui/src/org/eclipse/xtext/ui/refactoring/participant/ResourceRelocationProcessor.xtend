/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.participant

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext
import org.eclipse.xtext.ide.refactoring.ResourceRelocationStrategyExecutor
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class ResourceRelocationProcessor {

	@Inject IResourceSetProvider resourceSetProvider
	@Inject LiveScopeResourceSetInitializer liveScopeResourceSetInitializer
	@Accessors(PACKAGE_GETTER) @Inject LtkIssueAcceptor issues
	@Inject extension ResourceURIConverter
	@Inject IChangeSerializer changeSerializer
	@Inject ResourceRelocationStrategyRegistry strategyRegistry
	@Inject ChangeConverter changeConverter
	@Inject ResourceRelocationStrategyExecutor executor

	List<ResourceRelocationChange> uriChanges = newArrayList()
	
	Set<IResource> excludedResources = newHashSet()
	
	IProject project // TODO: multi-project move

	def createChange(String name, 
					IProgressMonitor pm) throws CoreException, OperationCanceledException {
		if (uriChanges.empty)
			return null
		val resourceSet = resourceSetProvider.get(project)
		liveScopeResourceSetInitializer.initialize(resourceSet)
		val context = new ResourceRelocationContext(uriChanges,issues, changeSerializer, resourceSet)
		executeParticipants(context)
		changeConverter.initialize(name, [
			(!(it instanceof MoveResourceChange || it instanceof RenameResourceChange) 
				|| !excludedResources.contains(modifiedElement))
		], issues)
		changeSerializer.endRecordChanges(changeConverter)
		return changeConverter.change
	}

	protected def void executeParticipants(ResourceRelocationContext context) {
		executor.executeParticipants(strategyRegistry.strategies, context)
	}
	
	def void addChangedResource(IResource resource, IPath fromPath, IPath toPath, ResourceRelocationChange.Type type) {
		if (project === null)
			project = resource.project

		if (fromPath.isPrefixOf(resource.fullPath)) {
			val oldURI = resource.toURI
			val newURI = toPath.append(resource.fullPath.removeFirstSegments(fromPath.segmentCount)).toURI
			excludedResources.add(resource)
			if (resource instanceof IFile) {
				val uriChange = new ResourceRelocationChange(oldURI, newURI, type, true)
				uriChanges += uriChange
			} else if (resource instanceof IContainer) {
				val uriChange = new ResourceRelocationChange(oldURI, newURI, type, false)
				uriChanges += uriChange
				resource.members.forEach [ member |
					addChangedResource(member, fromPath, toPath, type)
				]
			}
		}
	}
}