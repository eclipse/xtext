/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.client

import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.builder.standalone.incremental.IClassFileBasedDependencyFinder
import org.jetbrains.jps.builders.java.JavaBuilderUtil
import org.jetbrains.jps.builders.java.dependencyView.Mappings
import org.jetbrains.jps.incremental.CompileContext

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@FinalFieldsConstructor
class IdeaClassFileDependencyFinder implements IClassFileBasedDependencyFinder {
	
	val CompileContext context

	override getDependentJavaFiles(Iterable<URI> dirtyJavaFiles, Iterable<URI> deletedJavaFiles) {
		var projectDescriptor = context.projectDescriptor
		var globalMappings = projectDescriptor.dataManager.mappings
		var delta = globalMappings.createDelta
		val affected = dirtyJavaFiles.map[asFile].toSet
		val deleted = deletedJavaFiles.map[asPath].toSet
		val constantSearch = JavaBuilderUtil.CONSTANT_SEARCH_SERVICE.get(context)
		val moduleBasedFilter = new Mappings.DependentFilesFilter() {
			override accept(File file) {
				true
			}

			override belongsToCurrentTargetChunk(File file) {
				true
			}
		}
		val allAffected = newHashSet
		allAffected += affected
		globalMappings.differentiateOnIncrementalMake(
			delta,
			deleted, // removed
			affected, // filesToCompile 
			affected, // compiledFiles
			allAffected, // affectedFiles
			moduleBasedFilter,
			constantSearch)
		allAffected.removeAll(affected)
		val result = allAffected.map[asURI]
		return result
	}

}