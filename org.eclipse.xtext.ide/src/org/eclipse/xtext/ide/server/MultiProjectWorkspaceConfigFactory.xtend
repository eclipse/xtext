/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import java.io.File
import java.util.HashSet
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig

import static extension org.eclipse.xtext.util.UriUtil.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
class MultiProjectWorkspaceConfigFactory implements IWorkspaceConfigFactory {
        
    override getWorkspaceConfig(URI workspaceBaseURI) {
        val baseFile = new File(workspaceBaseURI.toFileString)
        if(baseFile.isDirectory) {
            val name2config = <String, IProjectConfig> newHashMap
            val result = new MultiProjectWorkspaceConfig(name2config)
            val IAcceptor<IProjectConfig> acceptor = [
                name2config.put(name, it)
            ]
            baseFile.listFiles.filter[directory].forEach [
                addProjectConfigs(URI.createFileURI(absolutePath), result, acceptor)   
            ]
            return result
        }
        return null
    }
    
    def addProjectConfigs(URI projectBaseURI, IWorkspaceConfig workspaceConfig, IAcceptor<IProjectConfig> acceptor) {
        acceptor.accept(new RootSourceFolderProjectConfig(projectBaseURI.appendSegment(''), projectBaseURI.lastSegment, workspaceConfig))
    }
}

@FinalFieldsConstructor
class MultiProjectWorkspaceConfig implements IWorkspaceConfig {
    
    val Map<String, IProjectConfig> name2config 
    
    override getProjects() {
        new HashSet(name2config.values)
    }

    override findProjectByName(String name) {
        name2config.get(name)
    }
    
    override findProjectContaining(URI member) {
        name2config.values.filter[
            findSourceFolderContaining(member) !== null
        ].maxBy[path.segmentCount]
    }
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@Data
class RootSourceFolderProjectConfig implements IProjectConfig, ISourceFolder {
    val URI path
    val String name
    val IWorkspaceConfig workspaceConfig
    
    override findSourceFolderContaining(URI member) {
        if(path.isPrefixOf(member))
            this
        else
            null
    }
    
    override getSourceFolders() {
        #{this}
    }
} 

