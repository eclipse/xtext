/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.ArrayList
import java.util.Collection
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.util.CancelIndicator

import static extension org.eclipse.xtext.util.UriUtil.*
import org.eclipse.xtext.resource.impl.ProjectDescription
import com.google.inject.Singleton

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@Singleton
class BuildManager {
    
    public static val CYCLIC_PROJECT_DEPENDENCIES = BuildManager.canonicalName + '.cyclicProjectDependencies'

    @Inject WorkspaceManager workspaceManager
    @Inject Provider<TopologicalSorter> sorterProvider

    val dirtyFiles = <URI>newLinkedHashSet
    val deletedFiles = <URI>newLinkedHashSet

    def void doBuild(List<URI> dirtyFiles, List<URI> deletedFiles, CancelIndicator cancelIndicator) {
        queue(this.dirtyFiles, deletedFiles, dirtyFiles)
        queue(this.deletedFiles, dirtyFiles, deletedFiles)
        internalBuild(cancelIndicator)
    }
    
    protected def void queue(Set<URI> files, Collection<URI> toRemove, Collection<URI> toAdd) {
        files -= toRemove
        files += toAdd
    }

    def void doFullBuild(CancelIndicator indicator) {
        val sortedDescriptions = sortByDependencies(workspaceManager.projectManagers.map[projectDescription])
        for(it: sortedDescriptions) {
            workspaceManager.getProjectManager(name).doFullBuild(indicator)
        }
    }

    protected def void internalBuild(CancelIndicator cancelIndicator) {
        val allDirty = new ArrayList(dirtyFiles)
        val List<ProjectBuildData> buildData = newArrayList 
        for (projectManager : workspaceManager.projectManagers) {
            val baseDir = projectManager.baseDir
            val projectDirtyFiles = allDirty.filter[baseDir.isPrefixOf(it)].toList
            val projectDeletedFiles = deletedFiles.filter[baseDir.isPrefixOf(it)].toList
            if(!projectDirtyFiles.empty || !projectDeletedFiles.empty) {
                buildData += new ProjectBuildData(projectManager, projectDirtyFiles, projectDeletedFiles)
            }
        }
        val description2buildData = buildData.toMap[manager.projectDescription]
        val sortedDescriptions = sortByDependencies(description2buildData.keySet)
        val sortedBuildData = sortedDescriptions.map[description2buildData.get(it)]
        for(ProjectBuildData it: sortedBuildData) {
            val result = manager.doBuild(dirtyFiles, deletedFiles, cancelIndicator)
            allDirty.addAll(result.affectedResources.map[uri])
            this.dirtyFiles -= dirtyFiles
            this.deletedFiles -= deletedFiles
        }        
    }
    
    protected def sortByDependencies(Collection<ProjectDescription> projectDescriptions) {
        sorterProvider.get.sortByDependencies(projectDescriptions.toList) [
            workspaceManager.getProjectManager(name).reportDependencyCycle
        ]
    }
    
    protected def reportDependencyCycle(ProjectManager manager) {
        manager.reportProjectIssue('Project has cyclic dependencies', CYCLIC_PROJECT_DEPENDENCIES, Severity.ERROR)
    }

    @Data
    protected static class ProjectBuildData {
        ProjectManager manager
        List<URI> dirtyFiles
        List<URI> deletedFiles
    }
}
