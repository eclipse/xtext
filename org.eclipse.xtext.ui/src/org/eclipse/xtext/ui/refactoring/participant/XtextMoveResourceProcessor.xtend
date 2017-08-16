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
import org.eclipse.xtext.ide.refactoring.MoveResourceContext
import org.eclipse.xtext.ide.refactoring.ResourceURIChange
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class XtextMoveResourceProcessor {

	@Inject IResourceSetProvider resourceSetProvider
	@Inject LiveScopeResourceSetInitializer liveScopeResourceSetInitializer
	@Accessors(PACKAGE_GETTER) @Inject LtkIssueAcceptor issues
	@Inject extension ResourceURIConverter
	@Inject IChangeSerializer changeSerializer
	@Inject XtextMoveResourceStrategyRegistry strategyRegistry
	@Inject ChangeConverter changeConverter

	List<ResourceURIChange> folderUriChanges = newArrayList()
	List<ResourceURIChange> fileUriChanges = newArrayList()
	
	Set<IResource> excludedResources = newHashSet()

	def createChange(String name, 
					IProject project,
					IProgressMonitor pm) throws CoreException, OperationCanceledException {
		if (folderUriChanges.empty && fileUriChanges.empty)
			return null
		val resourceSet = resourceSetProvider.get(project)
		liveScopeResourceSetInitializer.initialize(resourceSet)
		val moveContext = new MoveResourceContext(fileUriChanges, folderUriChanges, issues, changeSerializer, resourceSet)
		applyMoveStrategies(moveContext)
		changeConverter.initialize(name, [
			(!(it instanceof MoveResourceChange || it instanceof RenameResourceChange) 
				|| !excludedResources.contains(modifiedElement))
		], issues)
		changeSerializer.endRecordChanges(changeConverter)
		return changeConverter.change
	}

	protected def void applyMoveStrategies(MoveResourceContext context) {
		strategyRegistry.strategies.forEach[applyMove(context)]
		context.executeModifications
	}
	
	def void addMovedResource(IResource resource, IPath oldPath, IPath newPath) {
		if (oldPath.isPrefixOf(resource.fullPath)) {
			val oldURI = resource.toURI
			val newURI = newPath.append(resource.fullPath.removeFirstSegments(oldPath.segmentCount)).toURI
			val uriChange = new ResourceURIChange(oldURI, newURI)
			excludedResources.add(resource)
			if (resource instanceof IFile) {
				fileUriChanges += uriChange
			} else if (resource instanceof IContainer) {
				folderUriChanges += uriChange
				resource.members.forEach [ member |
					addMovedResource(member, oldPath, newPath)
				]
			}
		}
	}
}