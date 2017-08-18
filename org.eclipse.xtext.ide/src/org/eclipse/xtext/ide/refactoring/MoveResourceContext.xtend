/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.resource.IResourceServiceProvider
import java.util.Map
import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*
import org.apache.log4j.Logger

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@FinalFieldsConstructor
class MoveResourceContext {
	
	static val LOG = Logger.getLogger(MoveResourceContext)

	@Accessors(PUBLIC_GETTER) val List<ResourceURIChange> fileChanges
	@Accessors(PUBLIC_GETTER) val List<ResourceURIChange> folderChanges
	@Accessors(PUBLIC_GETTER) val RefactoringIssueAcceptor issueAcceptor

	val IChangeSerializer changeSerializer
	val ResourceSet resourceSet

	val IResourceServiceProvider.Registry resourceServiceProviderRegistry

	val Map<Resource, ResourceModification> modifications = newHashMap

	def addModification(URI uri, ResourceModification modification) {
		try {
			val resource = resourceSet.getResource(uri, true)
			changeSerializer.beginRecordChanges(resource)
			modifications.put(resource, modification)
		} catch (Throwable t) {
			issueAcceptor.add(ERROR, 'Error loading resource ' + uri?.toString, t)
			LOG.error(t)
		}
	}

	def executeModifications() {
		modifications.entrySet.forEach [
			try {
				value.modify(key)
			} catch (Throwable t) {
				issueAcceptor.add(ERROR, 'Error executing modification on resource ' + key?.URI?.toString, t)
				LOG.error(t)
			}
		]
	}

	def isXtextResource(URI uri) {
		resourceServiceProviderRegistry.getResourceServiceProvider(uri) !== null
	}

	static class Factory {
		@Inject IResourceServiceProvider.Registry resourceServiceProviderRegistry

		def MoveResourceContext create(List<ResourceURIChange> fileChanges, List<ResourceURIChange> folderChanges,
			RefactoringIssueAcceptor issues, IChangeSerializer changeSerializer, ResourceSet resourceSet) {
			new MoveResourceContext(fileChanges, folderChanges, issues, changeSerializer, resourceSet,
				resourceServiceProviderRegistry)
		}
	}
}

/**
 * URIs can also refer to folders and non-Xtext resources.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
class ResourceURIChange {
	URI oldURI
	URI newURI
}
