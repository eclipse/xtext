/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.javaconverter

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.codeInsight.FileModificationService
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.util.Computable
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.codeStyle.CodeStyleManager
import com.intellij.psi.util.PsiUtil
import com.intellij.refactoring.RefactoringActionHandler
import com.intellij.util.SequentialModalProgressTask
import com.intellij.util.SequentialTask
import java.util.Collection
import java.util.Iterator
import java.util.Map
import java.util.Set
import org.eclipse.xtend.core.formatting2.FormatterFacade
import org.eclipse.xtend.core.idea.javaconverter.ConvertJavaCodeHandler.ConvertJavaSequentialTask
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.core.javaconverter.JavaConverter
import org.eclipse.xtend.core.javaconverter.JavaConverter.ConversionResult

/**
 * @author dhuebner - Initial contribution and API
 */
class ConvertJavaCodeHandler implements RefactoringActionHandler {

	@Inject Provider<JavaConverter> jcProvider
	@Inject FormatterFacade formatter

	new() {
		XtendLanguage.INSTANCE.injectMembers(this)
	}

	override invoke(Project project, Editor editor, PsiFile file, DataContext dataContext) {
		invoke(project, newImmutableList(file), dataContext)
	}

	override invoke(Project project, PsiElement[] elements, DataContext dataContext) {
		runJavaConverter(elements.collectJavaFiles(newHashSet()), CommonDataKeys.PROJECT.getData(dataContext))
	}

	def Collection<PsiJavaFile> collectJavaFiles(PsiElement[] elements, Set<PsiJavaFile> collector) {
		elements.forEach [
			if (it instanceof PsiJavaFile) {
				collector.add(it)
			} else if (it instanceof PsiDirectory) {
				collector.addAll(it.children.collectJavaFiles(collector))
			} else if (it.containingFile instanceof PsiJavaFile) {
				collector.add(it.containingFile as PsiJavaFile)
			}
		]
		return collector
	}
	
	def runJavaConverter(Collection<PsiJavaFile> files, Project project) {
		val Map<PsiFile, ConversionResult> coversionResult = newHashMap
		var Task.Backgroundable task = new Task.Backgroundable(project, "Conversion...", true) {
			var done = 0

			override void run(ProgressIndicator indicator) {

				files.forEach [ javaFile |
					if (indicator.isCanceled()) {
						return;
					}
					indicator.text = "Converting " + javaFile.name
					val jc = jcProvider.get()
					val javaSrc = ApplicationManager.application.runReadAction([javaFile.text] as Computable<String>)
					val context = ProjectRootManager.getInstance(project).getFileIndex().getModuleForFile(
						javaFile.virtualFile)
					val result = jc.toXtend(javaFile.virtualFile.nameWithoutExtension, javaSrc, context)
					result.xtendCode = formatter.format(result.xtendCode)
					coversionResult.put(javaFile, result)
					done++
					indicator.fraction = done as double / files.size
				]
			}

			override void onSuccess() {
				if (!coversionResult.isEmpty()) {
					if(!FileModificationService.getInstance().
						preparePsiElementsForWrite(coversionResult.keySet())) return;
					val progressTask = new SequentialModalProgressTask(project, "Applying conversion results", true)
					progressTask.setMinIterationTime(50)
					progressTask.setTask(new ConvertJavaSequentialTask(coversionResult, progressTask))
					// undoable
					CommandProcessor.getInstance().executeCommand(project, [
						CommandProcessor.getInstance().markCurrentCommandAsGlobal(project)
						ApplicationManager.getApplication().runWriteAction([
							try {
								ProgressManager.getInstance().run(progressTask)
							} catch (ProcessCanceledException e) {
								println("Canceled")
							}
						] as Runnable)
					], '''Convert «coversionResult.keySet.size» Java to Xtend''', null)
				}

			}
		}
		ProgressManager.getInstance().run(task)
	}

	private static class ConvertJavaSequentialTask implements SequentialTask {
		final int todo
		final Iterator<Runnable> workUnits
		final SequentialModalProgressTask progressTask
		int alreadyDone = 0

		private new(Map<PsiFile, ConversionResult> runnables, SequentialModalProgressTask modalProgressTask) {

			workUnits = runnables.entrySet().map [ resultEntry |
				new Runnable() {

					override run() {
						val result = resultEntry.value
						if (!result.xtendCode.nullOrEmpty) {
							val jvf = resultEntry.key.virtualFile
							val xtendFileName = jvf.nameWithoutExtension + ".xtend"
							if (jvf.parent.findChild(xtendFileName) === null) {
								val xtendFile = jvf.parent.createChildData(this, xtendFileName)
								xtendFile.binaryContent = result.xtendCode.bytes
								val project = resultEntry.key.project
								val formatter = CodeStyleManager.getInstance(project)
								val xtendPsiFile = PsiUtil.getPsiFile(project, xtendFile)
								formatter.reformat(xtendPsiFile)
								jvf.delete(this)
								if (runnables.size === 1) {
									ApplicationManager.getApplication().invokeLater [
										FileEditorManager.getInstance(project).openFile(xtendFile, true)
									]
								}
							}
						}
					}
				} as Runnable

			].iterator()
			progressTask = modalProgressTask
			todo = runnables.size()
		}

		override void prepare() {
		}

		override boolean isDone() {
			return alreadyDone > todo - 1
		}

		override boolean iteration() {
			val ProgressIndicator indicator = progressTask.getIndicator()
			if (indicator !== null) {
				indicator.setFraction(alreadyDone as double / todo)
			}
			workUnits.next().run()
			alreadyDone++
			return true
		}

		override void stop() {
			alreadyDone = todo
		}

	}
}