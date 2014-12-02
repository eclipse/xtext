/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.ng

import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.Provider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Accessors
class CompilationRequest {
	
	val Set<URI> toBeUpdated = newHashSet
	
	val Set<URI> toBeDeleted = newHashSet

	String projectName
	
	List<IResourceDescription.Delta> upstreamProjectChanges
	
	boolean computeAffected
	
	Provider<ResourceSet> resourceSetProvider
	
	override toString() '''
		CompilationRequest: «projectName»:
		  delete: «FOR uri: toBeDeleted SEPARATOR ','»«uri?.lastSegment»«ENDFOR»
		  update: «FOR uri: toBeUpdated SEPARATOR ','»«uri?.lastSegment»«ENDFOR»
		  «upstreamProjectChanges?.size» upstreamChanges 
	'''
	
	def boolean shouldCompile() {
		computeAffected || !toBeDeleted.empty || !toBeUpdated.empty || (upstreamProjectChanges != null && upstreamProjectChanges.empty)
	}
}