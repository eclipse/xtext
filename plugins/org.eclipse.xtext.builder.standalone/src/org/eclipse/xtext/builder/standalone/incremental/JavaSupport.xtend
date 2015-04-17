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
import java.net.URLClassLoader
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
class JavaSupport {

	static val LOG = Logger.getLogger(JavaSupport)

	@Inject TypeResourceServices typeResourceServices
	@Inject IndexedJvmTypeAccess typeAccess
	@Inject IJavaCompiler compiler
	@Inject AbstractFileSystemAccess commonFileAccess

	def installLocalOnlyTypeProvider(Iterable<File> classPathRoots, XtextResourceSet resourceSet) {
		LOG.info("Installing type provider for local types only")
		val classLoader = createURLClassLoader(classPathRoots)
		new ClasspathTypeProvider(classLoader, resourceSet, null, typeResourceServices)
		resourceSet.setClasspathURIContext(classLoader);
	}

	def File generateAndCompileJavaStubs(Iterable<URI> changedResources, ResourceDescriptionsData newIndex,
		BuildRequest request, extension BuildContext context) {
		// Generate Stubs
		compileStubs(generateStubs(changedResources, newIndex, request, context), request)
	}

	def void installTypeProvider(Iterable<File> classPathRoots, XtextResourceSet resSet) {
		LOG.info("Installing type provider with stubs")
		val classLoader = createURLClassLoader(classPathRoots)
		new ClasspathTypeProvider(classLoader, resSet, typeAccess, typeResourceServices)
		resSet.setClasspathURIContext(classLoader);
	}

	protected def URLClassLoader createURLClassLoader(Iterable<File> classPathEntries) {
		val classPathUrls = classPathEntries.map[toURI.toURL]
		return new URLClassLoader(classPathUrls)
	}

	def protected compileStubs(File stubsDir, BuildRequest request) {
		val stubsClassesFolder = createTempDir("classes", request)
		compiler.setClassPath(request.classPath.map[absolutePath])
		LOG.info("Compiling stubs located in " + stubsDir.absolutePath)
		val sourcesToCompile = uniqueEntries(request.sourceRoots.map[absolutePath] +
			newArrayList(stubsDir.absolutePath))
		LOG.info("Compiler source roots: " + sourcesToCompile.join(','))
		val result = compiler.compile(sourcesToCompile, stubsClassesFolder)
		switch (result) {
			case CompilationResult.SKIPPED:
				LOG.info("Nothing to compile. Stubs compilation was skipped.")
			case CompilationResult.FAILED:
				LOG.info("Stubs compilation finished with errors.")
			case CompilationResult.SUCCEEDED:
				LOG.info("Stubs compilation successfully finished.")
		}
		return stubsClassesFolder
	}

	def protected generateStubs(Iterable<URI> changedResources, ResourceDescriptionsData newIndex, BuildRequest request,
		extension BuildContext context) {
		val stubsDir = createTempDir("stubs", request)
		LOG.info("Generating stubs into " + stubsDir.absolutePath)
		commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, stubsDir.absolutePath)
		val generateStubs = changedResources.filter[languageAccess.linksAgainstJava]
		generateStubs.forEach [
			languageAccess.stubGenerator.doGenerateStubs(commonFileAccess, newIndex.getResourceDescription(it))
		]
		return stubsDir
	}

	def protected createTempDir(String subDir, BuildRequest request) {
		val file = new File(request.tempDir, subDir)
		if (!file.mkdirs && !file.exists)
			throw new IOException("Failed to create directory '" + file.absolutePath + "'")
		return file
	}

	def protected uniqueEntries(Iterable<String> pathes) {
		pathes.map[new File(it).absolutePath].toSet
	}
}