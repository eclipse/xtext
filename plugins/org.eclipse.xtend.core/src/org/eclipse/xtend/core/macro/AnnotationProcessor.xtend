/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Provider
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
import org.eclipse.xtend.lib.macro.services.TimeoutException
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.internal.Stopwatches
import java.util.concurrent.CancellationException

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
				RegisterGlobalsParticipant<?>: {
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
				TransformationParticipant<MutableNamedElement>: {
					val modifyCtx = modifyContextProvider.get
					modifyCtx.unit = ctx.compilationUnit
					
					runWithCancelIndiciator(ctx, monitor) [|
						val map = ctx.annotatedSourceElements.map[
							val xtendMember = ctx.compilationUnit.toXtendMemberDeclaration(it as XtendMember)
							return modifyCtx.getGeneratedElement(xtendMember)
						]
						processor.doTransform(map, modifyCtx)
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
				Thread::sleep(100)
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

