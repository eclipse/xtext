/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
import java.io.File
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
class RegisteringFileSystemAccess extends JavaIoFileSystemAccess { 

	/**
	 * @noreference This class is not intended to be referenced by clients.
	 */
	@Data static class GeneratedFile {
		String path
		String javaClassName
		CharSequence contents
	}
	@Inject IWorkspaceConfigProvider workspaceConfigProvider
	@Accessors val Set<GeneratedFile> textFiles = newHashSet()
	@Accessors Object context;

	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		super.generateFile(fileName, outputConfigurationName, contents)
		val path = getPath(fileName, outputConfigurationName)
		val javaName = if (fileName.endsWith(".java")) {
				fileName.substring(0, fileName.length - 5).replace('/', '.')
			}
		textFiles.add(new RegisteringFileSystemAccess.GeneratedFile(path, javaName, contents))
	}

	protected def getPath(String fileName, String outputConfigurationName) {
		val path = pathes.get(outputConfigurationName)
		return "/" + project.name + "/" + path + "/" + fileName
	}
	
	override protected getFile(String fileName, String outputConfigName) {
		val outlet=pathes.get(outputConfigName) 
		if (outlet === null) 
			throw new IllegalArgumentException('''A slot with name '«»«outputConfigName»' has not been configured.''')
		new File(project.path.toFileString, outlet + "/" + fileName)
	}
	
	def getProject() {
		if (context instanceof Resource) {
			workspaceConfigProvider.getWorkspaceConfig(context).projects.head
		}
	}
	
}