/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.util.internal.EmfAdaptable

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@EmfAdaptable class ContextualChunkedResourceDescriptions extends ChunkedResourceDescriptions implements IResourceDescriptions.IContextAware {
	
	Notifier context
	
	override setContext(Notifier context) {
		this.context = context
	}
	
	def ResourceSet getResourceSet() {
		return EcoreUtil2.getResourceSet(context)
	}
	
	new() {}
	
	new(ChunkedResourceDescriptions toBeCopied) {
		super(toBeCopied.chunk2resourceDescriptions)
	}
	
}
