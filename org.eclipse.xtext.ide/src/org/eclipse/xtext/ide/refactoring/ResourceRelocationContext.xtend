/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.serializer.IChangeSerializer

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@FinalFieldsConstructor
@Accessors(PUBLIC_GETTER)
class ResourceRelocationContext {

	val ChangeType changeType
	val List<ResourceRelocationChange> changes
	val RefactoringIssueAcceptor issueAcceptor

	val IChangeSerializer changeSerializer
	val ResourceSet resourceSet

	enum ChangeType {
		COPY,
		MOVE,
		RENAME
	}

	/**
	 * Loads and watches the respective resource, applies the relocation change and
	 * calls the given <code>modification</code> with the renamed/moved/copied resource.
	 * 
	 * @param change the change to execute
	 * @param modification the side-effect the rename/move/copy operation should have. 
	 */
	def void addModification(ResourceRelocationChange change, IChangeSerializer.IModification<Resource> modification) {
		changeSerializer.addModification(loadAndWatchResource(change), modification)
	}

	/**
	 * Loads and watches the respective resource and applies the relocation change.
	 * Clients may usually rather call {@link #addModification()} to register their
	 * side-effects.
	 *  
	 * @param change the change to execute
	 */
	def Resource loadAndWatchResource(ResourceRelocationChange change) {
		val resource = switch changeType {
			case MOVE,
			case RENAME: {
				val original = resourceSet.getResource(change.fromURI, true)				
				changeSerializer.addModification(original)[original.URI = change.toURI]
				original
			}
			case COPY: {
				val copy = resourceSet.createResource(change.fromURI)
				copy.load(resourceSet.URIConverter.createInputStream(change.fromURI), null)
				copy.URI = change.toURI
				copy
			}
		}
		return resource
	}	
}
