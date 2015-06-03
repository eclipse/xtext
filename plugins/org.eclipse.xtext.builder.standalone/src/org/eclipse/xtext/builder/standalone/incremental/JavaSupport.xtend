/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.inject.Inject
import java.io.File
import java.io.IOException
import java.net.URL
import java.net.URLClassLoader
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

import static extension com.google.common.io.Files.*
import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
class JavaSupport {

	static val LOG = Logger.getLogger(JavaSupport)

	@Inject IJavaCompiler compiler
	@Inject JavaIoFileSystemAccess commonFileAccess

	def protected URLClassLoader createURLClassLoader(Iterable<URI> classPathEntries) {
		val classPathUrls = classPathEntries.map[new URL(toString)]
		return new URLClassLoader(classPathUrls)
	}
	
	def URI preCompileJavaFiles(Iterable<URI> changedResources, ResourceDescriptionsData newIndex,
		BuildRequest request, extension BuildContext context) {
		val stubsDir = createTmpDir("stubs", request)
		val javaDir = createTmpDir("java", request)
		LOG.info("Generating stubs into " + stubsDir.absolutePath)
		LOG.info("Copying modified Java files into " + javaDir.absolutePath)
		commonFileAccess => [
			setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, stubsDir.absolutePath)
			writeTrace = false
		] 
		for(resource: changedResources) {
			if(resource.fileExtension == 'java') {
				val relativeURI = resource.findSourceRootRelativeURI(request)
				if(relativeURI == null) {
					LOG.error('Changed java file ' + resource + ' is not in any sourceRoot')
				} else {
					val source = new File(resource.asPath)
					val target = new File(javaDir, relativeURI.toString)
					target.createParentDirs
					source.copy(target)
				}
			} else if(resource.languageAccess?.linksAgainstJava) {
				resource.languageAccess.stubGenerator.doGenerateStubs(commonFileAccess, newIndex.getResourceDescription(resource))
			}
		}
		val stubsClasses = createTmpDir('stubs-classes', request)
		val javaClasses = createTmpDir('classes', request)
		stubsDir.compile(stubsClasses, request)
		javaDir.compile(javaClasses, request, stubsClasses)
		return javaClasses.asURI
	}

	def protected compile(File sourceDir, File targetDir, BuildRequest request, File... additionalClassesFolders) {
		compiler.setClassPath(additionalClassesFolders.map[absolutePath] 
				+ request.outputs.map[asPath] 
				+ request.classPath.map[asPath])
		LOG.info("Pre-compiling java files located in " + sourceDir.absolutePath)
		val result = compiler.compile(#[ sourceDir.absolutePath ], targetDir)
		switch (result) {
			case CompilationResult.SKIPPED:
				LOG.info("Nothing to pre-compile.")
			case CompilationResult.FAILED:
				LOG.info("Pre-compilation finished with errors. No need to worry. This is normal.")
			case CompilationResult.SUCCEEDED:
				LOG.info("Pre-compilation successfully finished.")
		}
	}

	def protected createTmpDir(String subDir, BuildRequest request) {
		val tmpRoot = new File(request.baseDir.asFile, 'xtext-tmp')
		if (!tmpRoot.mkdirs && !tmpRoot.exists)
			throw new IOException("Failed to create directory '" + tmpRoot.absolutePath + "'")
		val tmpDir = new File(tmpRoot, subDir)
		if (!tmpDir.mkdirs && !tmpDir.exists)
			throw new IOException("Failed to create directory '" + tmpDir.absolutePath + "'")
		return tmpDir
	}
}