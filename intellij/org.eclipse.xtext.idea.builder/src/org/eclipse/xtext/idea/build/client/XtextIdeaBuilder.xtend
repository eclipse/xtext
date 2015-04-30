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
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.ISetupExtension
import org.eclipse.xtext.idea.build.net.ObjectChannel
import org.eclipse.xtext.idea.build.net.Protocol.BuildFailureMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildIssueMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildRequestMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildResultMessage
import org.eclipse.xtext.idea.build.net.Protocol.JavaDependencyRequest
import org.eclipse.xtext.idea.build.net.Protocol.JavaDependencyResult
import org.jetbrains.jps.ModuleChunk
import org.jetbrains.jps.ProjectPaths
import org.jetbrains.jps.builders.DirtyFilesHolder
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.incremental.FSOperations
import org.jetbrains.jps.incremental.ModuleBuildTarget
import org.jetbrains.jps.incremental.ModuleLevelBuilder
import org.jetbrains.jps.incremental.ProjectBuildException
import org.jetbrains.jps.incremental.fs.CompilationRound
import org.jetbrains.jps.incremental.messages.BuildMessage
import org.jetbrains.jps.incremental.messages.CompilerMessage
import org.jetbrains.jps.incremental.messages.CustomBuilderMessage
import org.jetbrains.jps.service.JpsServiceManager

import static org.jetbrains.jps.incremental.BuilderCategory.*
import static org.jetbrains.jps.incremental.ModuleLevelBuilder.ExitCode.*

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

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
					BuildIssueMessage: {
						message.reportIssue(context)
					}
					BuildFailureMessage: {
						reportError(message.message, context)
						result = ABORT						
					}
					JavaDependencyRequest: {
						channel.writeObject(message.handleJavaDependencyRequest(context))
					}
				}
			}
		} catch (Exception exc) {
			LOG.error('Error in build', exc)
			reportError(exc.message, context)
			result = ABORT
		} finally {
			socketChannel?.close
		}
		return result
	}
	
	private def createBuildRequest(ModuleChunk chunk, CompileContext context,
		DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder) {
		val buildRequest = new BuildRequestMessage() => [
			dirtyFilesHolder.processDirtyFiles [ target, file, root |
				dirtyFiles += file.asURI.toString
				true
			]
			deletedFiles += dirtyFilesHolder.getRemovedFiles(chunk.representativeTarget).map[asFileURI.toString]
			classpath += ProjectPaths.getCompilationClasspath(chunk, true).toList.map[asURI.toString]
			outputs += ProjectPaths.getOutputPathsWithDependents(chunk).map[asURI.toString]
			sourceRoots += ProjectPaths.getSourceRootsWithDependents(chunk).keySet.toList.map[asURI.toString]
			encoding = context.projectDescriptor.encodingConfiguration.
				getPreferredModuleChunkEncoding(chunk)
			baseDir = chunk.representativeTarget.module.contentRootsList.urls.map[asURI].findFirst[isFile].toString
		]
		buildRequest
	}
	
	private def handleJavaDependencyRequest(JavaDependencyRequest request, CompileContext context) {
		val dependencyFinder = new IdeaClassFileDependencyFinder(context)
		val dependentJavaFiles = dependencyFinder.getDependentJavaFiles(
			request.dirtyJavaFiles.map[asURI], request.deletedJavaFiles.map[asURI]
		)
		new JavaDependencyResult => [
			it.dependentJavaFiles += dependentJavaFiles.map[toString]
		]
	}

	private def handleBuildResult(BuildResultMessage result, CompileContext context, ModuleChunk chunk,
		OutputConsumer outputConsumer) {
		val target = chunk.representativeTarget
		result.generatedFiles.forEach [
			val outputFile = file.asURI.asFile
			FSOperations.markDirty(context, CompilationRound.NEXT, outputFile)
			// Hack: As we cannot set the JavaSourceRootDescriptor#isGenereatedSource
			// we have to mark our files as generated by resetting the timestamp.
			outputFile.lastModified = context.compilationStartStamp
			context.processMessage(new CustomBuilderMessage(presentableName, 'generated', file))
			context.processMessage(new CustomBuilderMessage(presentableName, 'refresh', file))
			outputConsumer.registerOutputFile(target, outputFile, sourceFiles.map[asURI.asPath])
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
			uriToProblem.asURI.asPath,
			startOffset,
			endOffset,
			locationOffset,
			line,
			column
		))
	}
	
	protected def reportError(String message, CompileContext context) {
		context.processMessage(new BuildMessage(message, BuildMessage.Kind.ERROR) {})
	}

	override getCompilableFileExtensions() {
		JpsServiceManager.instance.getExtensions(ISetup).filter(ISetupExtension).map[fileExtensions].flatten.toList
	}

	override getPresentableName() {
		'Xtext'
	}
}