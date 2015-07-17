/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.debug

import com.google.inject.Inject
import com.intellij.debugger.SourcePosition
import com.intellij.debugger.engine.DebugProcess
import com.intellij.debugger.engine.DebugProcessImpl
import com.intellij.debugger.engine.PositionManagerImpl
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.sun.jdi.Location
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.generator.trace.AbstractTraceRegion
import org.eclipse.xtext.generator.trace.TraceFileNameProvider
import org.eclipse.xtext.generator.trace.TraceRegionSerializer
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class DebugProcessExtensions {
	
	@Inject TraceRegionSerializer traceRegionSerializer
	@Inject TraceFileNameProvider traceFileNameProvider
	
	def PsiFile getPsiFile(DebugProcess process, Location location) {
		val delegate = getJavaPositionManger(process)
		return ApplicationManager.application.<PsiFile>runReadAction [|
			val method = PositionManagerImpl.getDeclaredMethod('getPsiFileByLocation', Project, Location)
			method.accessible = true
			val result = method.invoke(delegate, process.project, location)
			return result as PsiFile
		]
	}	
	
	def AbstractTraceRegion getTraceForJava(SourcePosition javaSource) {
		val uri = javaSource.file.virtualFile.getURI
		val lastSegmentOfTrace = traceFileNameProvider.getTraceFromJava(uri.lastSegment)
		val virtualFile = uri.trimSegments(1).appendSegment(lastSegmentOfTrace).virtualFile
		if (virtualFile == null || !virtualFile.exists) {
			return null
		}
		val trace = traceRegionSerializer.readTraceRegionFrom(virtualFile.inputStream)
		return trace
	}
	
	def PsiFile getPsiFile(DebugProcess process, URI uri) {
		return ApplicationManager.application.<PsiFile>runReadAction [|
			PsiManager.getInstance(process.project).findFile(uri.virtualFile)
		]
	}
	
	def Map<URI,AbstractTraceRegion> getTracesForSource(DebugProcess process, SourcePosition source) {
		val builder = process.project.getComponent(XtextAutoBuilderComponent)
		val generated = builder.getGeneratedSources(source.file.virtualFile.getURI)
		val result = newHashMap
		for (uri : generated.filter[fileExtension=='java']) {
			val lastSegmentOfTrace = traceFileNameProvider.getTraceFromJava(uri.lastSegment)
			val virtualFile = uri.trimSegments(1).appendSegment(lastSegmentOfTrace).virtualFile
			if (virtualFile != null && virtualFile.exists) {
				val trace = traceRegionSerializer.readTraceRegionFrom(virtualFile.inputStream)
				result.put(uri,trace)
			}
		}
		return result
	}
	
	def PositionManagerImpl getJavaPositionManger(DebugProcess process) {
		new PositionManagerImpl(process as DebugProcessImpl)
	}
		
	def URI findOriginalDeclaration(DebugProcess process, Location location) {
		val psiFile = process.getPsiFile(location)
		if (psiFile == null)
			return null
		else 
			return process.project.getComponent(XtextAutoBuilderComponent).getSource4GeneratedSource(psiFile.virtualFile.getURI).head
	}
}