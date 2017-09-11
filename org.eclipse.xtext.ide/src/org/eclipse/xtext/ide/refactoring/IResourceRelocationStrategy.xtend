/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import com.google.inject.Inject
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.ecore.resource.Resource

/**
 * Allows a language to execute side-effects when the URI of a resource changes.
 * 
 * Such changes can be move, rename and copy operations, e.g. triggered by the 
 * user in a file browser. An example for a language in which such side-effects 
 * would make sense is Java, where the package name and the name of the first 
 * public top-level class must match the resource's path.
 * 
 * Clients should not directly implement this interface but extend the 
 * {@link IResourceRelocationStrategy.AbstractImpl}. 
 * 
 * In Eclipse, {@link IResourceRelocationStrategy} are registered to an extension 
 * point.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
interface IResourceRelocationStrategy {

	def boolean canHandle(ResourceRelocationChange change)

	def Resource loadAndWatchResource(ResourceRelocationChange change, ResourceRelocationContext context) 
	
	def void applyChange(ResourceRelocationChange change, Resource resource, ResourceRelocationContext context)

	def void applySideEffects(ResourceRelocationChange change, Resource resource, ResourceRelocationContext context)
	
	/** 
	 * Clients should extend this class to register side-effects on resource relocation changes.
	 */
	abstract class AbstractImpl implements IResourceRelocationStrategy {
		
		@Inject IResourceServiceProvider resourceServiceProvider
		
		override boolean canHandle(ResourceRelocationChange change) {
			resourceServiceProvider.canHandle(change.fromURI)
		}
		
		override Resource loadAndWatchResource(ResourceRelocationChange change, ResourceRelocationContext context) {
			val fromResource = context.resourceSet.getResource(change.fromURI, true)
			if (change.type === ResourceRelocationChange.Type.COPY) {
				val copy = context.resourceSet.createResource(change.toURI)
				return copy
			} else {
				context.changeSerializer.beginRecordChanges(fromResource)
				return fromResource
			}
		}
		
		override void applyChange(ResourceRelocationChange change, Resource resource, ResourceRelocationContext context) {
			val fromResource = context.resourceSet.getResource(change.fromURI, false)
			switch change.type {
				case COPY: {
					val buffer = new ByteArrayOutputStream
					fromResource.save(buffer, null)
					val copy = context.resourceSet.getResource(change.toURI, false)
					copy.load(new ByteArrayInputStream(buffer.toByteArray), null)
					context.changeSerializer.beginRecordChanges(copy)
				}
				case MOVE,
				case RENAME: {
					context.changeSerializer.beginRecordChanges(fromResource)
					fromResource.URI = change.toURI
				}
			}
		}
	}
}


