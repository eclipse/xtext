/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.debug

import com.google.inject.Inject
import com.intellij.debugger.NoDataException
import com.intellij.debugger.PositionManager
import com.intellij.debugger.PositionManagerFactory
import com.intellij.debugger.SourcePosition
import com.intellij.debugger.engine.DebugProcess
import com.intellij.debugger.requests.ClassPrepareRequestor
import com.intellij.openapi.application.ApplicationManager
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.util.PsiUtil
import com.intellij.util.DocumentUtil
import com.sun.jdi.AbsentInformationException
import com.sun.jdi.Location
import com.sun.jdi.ReferenceType
import java.util.List
import java.util.Set
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider
import org.eclipse.xtext.idea.trace.VirtualFileInProject
import org.eclipse.xtext.util.TextRegion

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class TraceBasedPositionManagerFactory extends PositionManagerFactory {
	
	IXtextLanguage language
	
	new(IXtextLanguage language) {
		this.language = language
	}
	
	override createPositionManager(DebugProcess process) {
		val manager = new TraceBasedPositionManager(process, language)
		language.injectMembers(manager)
		return manager
	}
	
	static class TraceBasedPositionManager implements PositionManager {
		val DebugProcess process
		val IXtextLanguage language
		
		@Inject extension DebugProcessExtensions
		@Inject ITraceForVirtualFileProvider traceForVirtualFileProvider
	
		new (DebugProcess process, IXtextLanguage language) {
			this.process = process
			this.language = language
		}
		
		/**
		 * This one is called
		 */
		override createPrepareRequest(ClassPrepareRequestor requestor, SourcePosition source) throws NoDataException {
			if (source.file.language != language) {
				throw NoDataException.INSTANCE
			}
			
			val names = ApplicationManager.application.<Set<String>>runReadAction[ 
				val trace = traceForVirtualFileProvider.getTraceToTarget(VirtualFileInProject.forPsiElement(source.elementAt))
				if (trace == null)
					throw NoDataException.INSTANCE;
				return trace.allAssociatedLocations.map[it.srcRelativeResourceURI.URI.lastSegment].toSet
			]
			if (names.isEmpty)
				throw NoDataException.INSTANCE;
			return process.requestsManager.createClassPrepareRequest([ process, refType|
				try {
					if (names.contains(refType.sourceName)) {
						requestor.processClassPrepare(process, refType)
					}
				} catch (AbsentInformationException ignore) {}
			], "*") 
		}
		
		override getAllClasses(SourcePosition source) throws NoDataException {
			if (source.file.language != language) {
				throw NoDataException.INSTANCE
			}
			val traces = process.getTracesForSource(source)
			val allClasses = newArrayList
			val line = source.line
			for (uri2trace : traces.entrySet) {
				val region = uri2trace.value.treeIterator.findFirst[associatedLocations.head?.lineNumber == line]
				if (region != null) {
					val psiFile = process.getPsiFile(uri2trace.key)
					val classes = process.javaPositionManger.getAllClasses(SourcePosition.createFromLine(psiFile, region.myLineNumber+1))
					allClasses.addAll(classes)
				}
			}
			return allClasses
		}
		
		override getSourcePosition(Location location) throws NoDataException {
			val line = location.lineNumber -1
			val psiFile = process.getPsiFile(location)
			if (psiFile == null) {
				throw NoDataException.INSTANCE
			}
			val trace = SourcePosition.createFromLine(psiFile, line).traceForJava
			if (trace == null) {
				throw NoDataException.INSTANCE
			}
			val sourceURI = process.findOriginalDeclaration(location)
			var SourcePosition fallBack = null
			var SourcePosition secondaryFallBack = null
			var iter = trace.treeIterator
			while (iter.hasNext) {
				val n = iter.next
				if (n.myLineNumber === line) {
					val mergedAssociatedLocation = n.mergedAssociatedLocation
					if (n.isUseForDebugging && n.myEndLineNumber === line && mergedAssociatedLocation.lineNumber == mergedAssociatedLocation.endLineNumber) {
						val psi = process.getPsiFile(sourceURI)
						return SourcePosition.createFromOffset(psi, mergedAssociatedLocation.offset)
					} else {
						val psi = process.getPsiFile(sourceURI)
						fallBack = SourcePosition.createFromOffset(psi, mergedAssociatedLocation.offset)
					}
				}
				// special handling for method closing
				if (n.myEndLineNumber === line) {
					val mergedAssociatedLocation = n.mergedAssociatedLocation
					val psi = process.getPsiFile(sourceURI)
					secondaryFallBack = SourcePosition.createFromLine(psi, mergedAssociatedLocation.endLineNumber)
				}
			}
			return fallBack ?: secondaryFallBack
		}
	
		override locationsOfLine(ReferenceType type, SourcePosition position) throws NoDataException {
			if (position.file.language != language) {
				throw NoDataException.INSTANCE
			}
			return ApplicationManager.application.<List<Location>>runReadAction[
				val psi = position.elementAt
				val document = PsiDocumentManager.getInstance(psi.project).getDocument(psi.containingFile)
				val range = DocumentUtil.getLineTextRange(document, position.line)
				val traceToTarget = traceForVirtualFileProvider.getTraceToTarget(VirtualFileInProject.forPsiElement(psi))
				if (traceToTarget == null) {
					throw NoDataException.INSTANCE
				}
				val result = newArrayList
				for (location : traceToTarget.getAllAssociatedLocations(new TextRegion(range.startOffset, range.length)).sortBy[textRegion.lineNumber]) {
					if (type.sourceName == location.srcRelativeResourceURI.URI.lastSegment.toString 
						&& location.textRegion.lineNumber == location.textRegion.endLineNumber) {
						val locationsOfLine = type.locationsOfLine(location.textRegion.lineNumber+1)
						if (!locationsOfLine.isEmpty) {
							result.addAll(locationsOfLine)
							return result
						}
					}
				}
				throw NoDataException.INSTANCE
			]
		}
		
	}
	
}
											