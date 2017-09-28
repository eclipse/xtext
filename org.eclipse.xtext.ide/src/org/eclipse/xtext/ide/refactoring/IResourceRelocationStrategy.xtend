/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import com.google.inject.Inject
import org.eclipse.xtext.resource.IResourceServiceProvider

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

	def void loadAndWatchResources(ResourceRelocationContext context) 
	
	def void applyChange(ResourceRelocationContext context)

	def void applySideEffects(ResourceRelocationContext context)
	
	/** 
	 * Clients should extend this class to register side-effects on resource relocation changes.
	 */
	abstract class AbstractImpl implements IResourceRelocationStrategy {
		
		@Inject IResourceServiceProvider resourceServiceProvider
		
		def boolean canHandle(ResourceRelocationChange change) {
			resourceServiceProvider.canHandle(change.fromURI)
		}
		
		override void loadAndWatchResources(ResourceRelocationContext context) {
			context.changes.filter[ isFile && canHandle ].forEach [ change | 
				if (context.changeType === ResourceRelocationContext.ChangeType.COPY) {
					val fromResource = context.resourceSet.createResource(change.fromURI)
					fromResource.load(context.resourceSet.URIConverter.createInputStream(change.fromURI), null)
					fromResource.URI = change.toURI
					context.changeSerializer.beginRecordChanges(fromResource)
				} else {
					val fromResource = context.resourceSet.getResource(change.fromURI, true)
					context.changeSerializer.beginRecordChanges(fromResource)
				}
			]
		}
		
		override void applyChange(ResourceRelocationContext context) {
			context.changes.filter[ isFile && canHandle ].forEach[ change | 
				switch context.changeType {
					case MOVE,
					case RENAME: {
						val fromResource = context.resourceSet.getResource(change.fromURI, false)
						fromResource.URI = change.toURI
					}
					case COPY: {}
				}
			]
		}
	}
}


