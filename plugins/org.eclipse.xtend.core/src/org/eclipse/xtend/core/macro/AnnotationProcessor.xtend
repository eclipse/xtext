/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import java.util.List
import javax.inject.Provider
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.internal.Stopwatches

import static extension org.eclipse.xtend.core.macro.AnnotationProcessor.*

/**
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
class AnnotationProcessor {
	
	@Inject Provider<TransformationContextImpl> modifyContextProvider

	/**
	 * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
	 */
	def indexingPhase(ActiveAnnotationContext ctx, IAcceptor<JvmDeclaredType> acceptor, CancelIndicator monitor) {
		val task = Stopwatches::forTask('[macros] indexingPhase (AnnotationProcessor.indexingPhase)')
		task.start
		try {
			switch processor : ctx.processorInstance{
				RegisterGlobalsParticipant: {
					//TODO
				}
			}
		} finally {
			task.stop
		}
	}

	def inferencePhase(ActiveAnnotationContext ctx, CancelIndicator monitor) {
		val task = Stopwatches::forTask('[macros] inferencePhase (AnnotationProcessor.inferencePhase)')
		task.start
		try {
			switch processor : ctx.processorInstance{
				TransformationParticipant: {
					val modifyCtx = modifyContextProvider.get
					modifyCtx.unit = ctx.compilationUnit
					processor.doTransform(ctx.annotatedSourceElements.map[
						val xtendMember = ctx.compilationUnit.toXtendMemberDeclaration(it as XtendMember)
						return modifyCtx.getGeneratedElement(xtendMember)
					], modifyCtx)
				}
			}
		} finally {
			task.stop
		}
	}
	
}

