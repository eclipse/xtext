package org.eclipse.xtext.idea.build.incremental

import com.google.inject.Guice
import com.google.inject.Inject
import com.intellij.openapi.util.SystemInfo
import java.io.File
import java.io.IOException
import org.eclipse.xtext.idea.build.XtextIdeaRefreshComponent
import org.jetbrains.jps.ModuleChunk
import org.jetbrains.jps.builders.DirtyFilesHolder
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.incremental.ModuleBuildTarget
import org.jetbrains.jps.incremental.ModuleLevelBuilder
import org.jetbrains.jps.incremental.ProjectBuildException
import org.jetbrains.jps.incremental.messages.CustomBuilderMessage

import static org.jetbrains.jps.incremental.BuilderCategory.*
import static org.jetbrains.jps.incremental.ModuleLevelBuilder.ExitCode.*

class XtextIncrementalBuilder extends ModuleLevelBuilder {

	static val standaloneInjector = Guice.createInjector(new IdeaStandaloneBuilderModule())

	@Inject XtextIdeaRefreshComponent refreshComponent

	public new() {
		super(SOURCE_GENERATOR)
	}
	
	override build(CompileContext context, ModuleChunk chunk, DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder, OutputConsumer outputConsumer) throws ProjectBuildException, IOException {
		if(!dirtyFilesHolder.hasDirtyFiles && !dirtyFilesHolder.hasRemovedFiles)
			return NOTHING_DONE;
			
		val dirtyJavaFiles = <File>newArrayList
		val dirtyXtextFiles = <File>newArrayList
		dirtyFilesHolder.processDirtyFiles [ target, file, root |
			val fileExtension = file.fileExtension
			if(fileExtension == 'java')
				dirtyJavaFiles.add(file)
			else if(XtextLanguages.getLanguageAccesses.keySet.contains(fileExtension))
				dirtyXtextFiles.add(file)
			true
		]
		
		val buildData = new IdeaBuildData(presentableName, context, chunk, outputConsumer, refreshComponent)
		val standaloneBuilder = standaloneInjector.getInstance(IdeaStandaloneBuilder) => [
			it.buildData = buildData 
			failOnValidationError = false
			languages = XtextLanguages.getLanguageAccesses
		]
		if(standaloneBuilder.launch)
			return OK
		else
			return ABORT
	}
	
	override buildFinished(CompileContext context) {
		val filesToRefresh = refreshComponent.filesToRefresh
		if (!filesToRefresh.empty) {
			for (file : filesToRefresh) 
				context.processMessage(new CustomBuilderMessage('xtext', 'generated', file))
			context.processMessage(new CustomBuilderMessage('xtext', 'refresh', ""))
		}
	}
	
	override getCompilableFileExtensions() {
		XtextLanguages.getLanguageAccesses.keySet.toList
	}
	
	private def getFileExtension(File file) {
		val fileName = if(SystemInfo.isFileSystemCaseSensitive)
				file.name
			else
				file.name.toLowerCase 
		val index = fileName.lastIndexOf('.')
		if(index != -1) 
			return file.name.substring(file.name.lastIndexOf('.') + 1)
		else 
			return null
	}
	
	override getPresentableName() {
		'Xtext (incremental)'
	}
}