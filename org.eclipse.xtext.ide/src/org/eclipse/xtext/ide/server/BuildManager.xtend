/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.common.collect.HashMultimap
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.ArrayList
import java.util.Collection
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
class BuildManager {
    
    public static val CYCLIC_PROJECT_DEPENDENCIES = BuildManager.canonicalName + '.cyclicProjectDependencies'

    @Accessors(PUBLIC_SETTER)
    WorkspaceManager workspaceManager
    @Inject Provider<TopologicalSorter> sorterProvider

    val dirtyFiles = <URI>newLinkedHashSet
    val deletedFiles = <URI>newLinkedHashSet
    
    def Buildable submit(List<URI> dirtyFiles, List<URI> deletedFiles) {
    	queue(this.dirtyFiles, deletedFiles, dirtyFiles)
        queue(this.deletedFiles, dirtyFiles, deletedFiles)
        return [cancelIndicator|internalBuild(cancelIndicator)]
    }

    def List<IResourceDescription.Delta> doBuild(List<URI> dirtyFiles, List<URI> deletedFiles, CancelIndicator cancelIndicator) {
    		return submit(dirtyFiles, deletedFiles).build(cancelIndicator)
    }
    
    protected def void queue(Set<URI> files, Collection<URI> toRemove, Collection<URI> toAdd) {
        files -= toRemove
        files += toAdd
    }

    def List<IResourceDescription.Delta> doInitialBuild(List<ProjectDescription> projects, CancelIndicator indicator) {
        val sortedDescriptions = sortByDependencies(projects)
        val result = newArrayList
        for(description : sortedDescriptions) {
            val partialresult = workspaceManager.getProjectManager(description.name).doInitialBuild(indicator)
            result.addAll(partialresult.affectedResources)
        }
        return result
    }

    protected def List<IResourceDescription.Delta> internalBuild(CancelIndicator cancelIndicator) {
        val allDirty = new ArrayList(dirtyFiles)
        val project2dirty = HashMultimap.<ProjectDescription, URI>create 
        for(URI dirty: allDirty) {
            val projectManager = workspaceManager.getProjectManager(dirty).projectDescription
            project2dirty.put(projectManager, dirty)
        }
        val project2deleted = HashMultimap.<ProjectDescription, URI>create 
        for(URI deleted: deletedFiles) {
            val projectManager = workspaceManager.getProjectManager(deleted).projectDescription
            project2deleted.put(projectManager, deleted)
        }
        val sortedDescriptions = sortByDependencies(project2dirty.keySet + project2deleted.keySet)
        val result = newArrayList()
        for(ProjectDescription it: sortedDescriptions) {
            val projectManager = workspaceManager.getProjectManager(name)
            val projectDirty = project2dirty.get(it).toList
            val projectDeleted = project2deleted.get(it).toList
            val partialResult = projectManager.doBuild(projectDirty, projectDeleted, result, cancelIndicator)
            allDirty.addAll(partialResult.affectedResources.map[uri])
            this.dirtyFiles -= projectDirty
            this.deletedFiles -= projectDeleted
            result.addAll(partialResult.affectedResources)
        }
        return result
    }
    
    protected def sortByDependencies(Iterable<ProjectDescription> projectDescriptions) {
        sorterProvider.get.sortByDependencies(projectDescriptions.toList) [
            workspaceManager.getProjectManager(name).reportDependencyCycle
        ]
    }
    
    protected def reportDependencyCycle(ProjectManager manager) {
        manager.reportProjectIssue('Project has cyclic dependencies', CYCLIC_PROJECT_DEPENDENCIES, Severity.ERROR)
    }

    @Data
    protected static class ProjectBuildData {
        List<URI> dirtyFiles
        List<URI> deletedFiles
    }
    
    static interface Buildable {
    	def List<IResourceDescription.Delta> build(CancelIndicator cancelIndicator)
    }
}
