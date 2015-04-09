/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.client

import com.google.inject.Inject
import java.io.File
import java.io.IOException
import java.nio.channels.SocketChannel
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.ISetupExtension
import org.eclipse.xtext.idea.build.net.ObjectChannel
import org.eclipse.xtext.idea.build.net.Protocol.BuildIssueMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildRequestMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildResultMessage
import org.jetbrains.jps.ModuleChunk
import org.jetbrains.jps.ProjectPaths
import org.jetbrains.jps.builders.DirtyFilesHolder
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.incremental.FSOperations
import org.jetbrains.jps.incremental.ModuleBuildTarget
import org.jetbrains.jps.incremental.ModuleLevelBuilder
import org.jetbrains.jps.incremental.ModuleLevelBuilder.OutputConsumer
import org.jetbrains.jps.incremental.ProjectBuildException
import org.jetbrains.jps.incremental.fs.CompilationRound
import org.jetbrains.jps.incremental.messages.BuildMessage
import org.jetbrains.jps.incremental.messages.CompilerMessage
import org.jetbrains.jps.incremental.messages.CustomBuilderMessage
import org.jetbrains.jps.model.java.JavaSourceRootType
import org.jetbrains.jps.model.module.JpsModule
import org.jetbrains.jps.service.JpsServiceManager

import static org.jetbrains.jps.incremental.BuilderCategory.*
import static org.jetbrains.jps.incremental.ModuleLevelBuilder.ExitCode.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextIdeaBuilder extends ModuleLevelBuilder {

	static val LOG = Logger.getLogger(XtextIdeaBuilder)

	@Inject DaemonConnector connector

	public new() {
		super(SOURCE_GENERATOR)
	}

	override build(CompileContext context, ModuleChunk chunk,
		DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder,
		OutputConsumer outputConsumer) throws ProjectBuildException, IOException {
		if (!dirtyFilesHolder.hasDirtyFiles && !dirtyFilesHolder.hasRemovedFiles)
			return NOTHING_DONE;
		var ExitCode result = null
		var SocketChannel socketChannel = null
		try {
			val buildRequest = createBuildRequest(chunk, context, dirtyFilesHolder)
			socketChannel = connector.connect
			val channel = new ObjectChannel(socketChannel)
			channel.writeObject(buildRequest)
			while (result == null) {
				val message = channel.readObject
				switch message {
					BuildResultMessage: {
						handleBuildResult(message, context, chunk, outputConsumer)
						result = OK
					}
					BuildIssueMessage:
						message.reportIssue(context)
				}
			}
		} catch (Exception exc) {
			LOG.error('Error in build', exc)
			context.processMessage(new BuildMessage(exc.message, BuildMessage.Kind.ERROR) {
			})
			result = ABORT
		} finally {
			socketChannel?.close
		}
		return result
	}

	private def createBuildRequest(ModuleChunk chunk, CompileContext context,
		DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder) {
		val buildRequest = new BuildRequestMessage()
		dirtyFilesHolder.processDirtyFiles [ target, file, root |
			buildRequest.dirtyFiles += file.path
			true
		]
		buildRequest.deletedFiles += dirtyFilesHolder.getRemovedFiles(chunk.representativeTarget)
		buildRequest.classpath += ProjectPaths.getCompilationClasspath(chunk, true).toList.map[path]
		buildRequest.sourceRoots += ProjectPaths.getSourceRootsWithDependents(chunk).keySet.toList.map[path]
		buildRequest.encoding = context.projectDescriptor.encodingConfiguration.
			getPreferredModuleChunkEncoding(chunk)
		buildRequest.baseDir = chunk.representativeTarget.module.contentRootsList.urls.map [
			URI.createURI(it)
		].findFirst [
			isFile
		].path
		buildRequest
	}

	private def handleBuildResult(BuildResultMessage result, CompileContext context, ModuleChunk chunk,
		OutputConsumer outputConsumer) {
		val module = chunk.representativeTarget.module
		result.outputDirs.forEach [
			createSourceRoot(module)
		]
		result.dirtyFiles.forEach [
			FSOperations.markDirty(context, CompilationRound.CURRENT, new File(it))
			context.processMessage(new CustomBuilderMessage(presentableName, 'generated', it))
			context.processMessage(new CustomBuilderMessage(presentableName, 'refresh', it))
		]
		result.deletedFiles.forEach [
			FSOperations.markDeleted(context, new File(it))
			context.processMessage(new CustomBuilderMessage(presentableName, 'generated', it))
			context.processMessage(new CustomBuilderMessage(presentableName, 'refresh', it))
		]
	}

	private def reportIssue(BuildIssueMessage it, CompileContext context) {
		context.processMessage(new CompilerMessage(
			presentableName,
			kind,
			message,
			path,
			startOffset,
			endOffset,
			locationOffset,
			line,
			column
		))
	}

	protected def createSourceRoot(String outputDir, JpsModule module) {
		val outletUrl = URI.createFileURI(outputDir).toString
		if (!module.getSourceRoots(JavaSourceRootType.SOURCE).exists[url == outletUrl])
			module.addSourceRoot(outletUrl, JavaSourceRootType.SOURCE)
	}

	override getCompilableFileExtensions() {
		JpsServiceManager.instance.getExtensions(ISetup).filter(ISetupExtension).map[fileExtensions].flatten.toList
	}

	override getPresentableName() {
		'Xtext'
	}
}