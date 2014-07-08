/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.concurrent.CancellationException
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Stopwatches
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.lib.macro.ValidationParticipant

/**
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
class AnnotationProcessor {
	
	@Inject Provider<TransformationContextImpl> modifyContextProvider
	@Inject Provider<RegisterGlobalsContextImpl> registerGlobalsContextProvider
	@Inject Provider<ValidationContextImpl> validationContextProvider

	/**
	 * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
	 */
	def indexingPhase(ActiveAnnotationContext ctx, IJvmDeclaredTypeAcceptor acceptor, CancelIndicator monitor) {
		val task = Stopwatches.forTask('[macros] indexingPhase (AnnotationProcessor.indexingPhase)')
		task.start
		try {
			switch processor : ctx.processorInstance {
				RegisterGlobalsParticipant<NamedElement>: {
					val registerGlobalsCtx = registerGlobalsContextProvider.get
					registerGlobalsCtx.acceptor = acceptor
					registerGlobalsCtx.compilationUnit = ctx.compilationUnit
					
					runWithCancelIndiciator(ctx, monitor) [|
						processor.doRegisterGlobals(ctx.annotatedSourceElements.map[ctx.compilationUnit.toXtendMemberDeclaration(it as XtendMember)], registerGlobalsCtx)
					]
				}
			}
		} finally {
			task.stop
		}
	}

	def inferencePhase(ActiveAnnotationContext ctx, CancelIndicator monitor) {
		val task = Stopwatches.forTask('[macros] inferencePhase (AnnotationProcessor.inferencePhase)')
		task.start
		try {
			switch processor : ctx.processorInstance{
				TransformationParticipant<MutableNamedElement>: {
					val modifyCtx = modifyContextProvider.get
					modifyCtx.unit = ctx.compilationUnit
					
					runWithCancelIndiciator(ctx, monitor) [|
						val map = ctx.annotatedSourceElements.map[
							val xtendMember = switch it {
								XtendMember : ctx.compilationUnit.toXtendMemberDeclaration(it)
								XtendParameter : ctx.compilationUnit.toXtendParameterDeclaration(it)
							}
							return modifyCtx.getPrimaryGeneratedJavaElement(xtendMember) as MutableNamedElement
						]
						processor.doTransform(map, modifyCtx)
					]
				}
			}
		} finally {
			task.stop
		}
	}
	
	def validationPhase(ActiveAnnotationContext ctx, CancelIndicator monitor) {
		val task = Stopwatches.forTask('[macros] validationPhase (AnnotationProcessor.validationPhase)')
		task.start
		try {
			switch processor : ctx.processorInstance{
				ValidationParticipant<NamedElement>: {
					val validationContext = validationContextProvider.get
					ctx.compilationUnit.modifyAllowed = false
					validationContext.unit = ctx.compilationUnit
					
					runWithCancelIndiciator(ctx, monitor) [|
						val map = ctx.annotatedSourceElements.map[
							val xtendMember = switch it {
								XtendMember : ctx.compilationUnit.toXtendMemberDeclaration(it)
								XtendParameter : ctx.compilationUnit.toXtendParameterDeclaration(it)
							}
							return validationContext.getPrimaryGeneratedJavaElement(xtendMember)
						]
						processor.doValidate(map, validationContext)
					]
				}
			}
		} finally {
			task.stop
		}
	}
	
	/**
	 * runs the given runnable and another thread in parallel, that sets the timeout property on the compilation unit to true
	 * when the given amount of milliseconds have passed by.
	 */
	private def runWithCancelIndiciator(ActiveAnnotationContext ctx, CancelIndicator cancelIndicator, Runnable runnable) {
		val AtomicBoolean isFinished = new AtomicBoolean(false)
		new Thread ([|
			while (!isFinished.get) {
				if (cancelIndicator.canceled) {
					ctx.compilationUnit.canceled = true
					return;
				}
				Thread.sleep(100)
			}
		]).start
		try {
			runnable.run
		} catch (CancellationException e) {
		} finally {
			isFinished.set(true)
		}
	}
	
}

