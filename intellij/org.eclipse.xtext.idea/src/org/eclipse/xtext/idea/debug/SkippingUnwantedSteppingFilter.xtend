/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.debug

import com.google.inject.Inject
import com.intellij.debugger.engine.ExtraSteppingFilter
import com.intellij.debugger.engine.SuspendContext
import com.sun.jdi.Location
import com.sun.jdi.Method
import com.sun.jdi.request.StepRequest
import org.eclipse.xtext.idea.lang.IXtextLanguage

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class SkippingUnwantedSteppingFilter implements ExtraSteppingFilter {
	
	@Inject extension DebugProcessExtensions
	
	new(IXtextLanguage language) {
		language.injectMembers(this)
	}
	
	override getStepRequestDepth(SuspendContext context) {
		if (isEmptyAnonymousClassConstructor(context))
			return StepRequest.STEP_OUT
		return StepRequest.STEP_OVER
	}
	
	override isApplicable(SuspendContext context) {
		if (context == null || !isXtextSourced(context)) {
            return false;
        }
        val debugProcess = context.getDebugProcess()
        val positionManager = debugProcess.positionManager
        val location = context.getFrameProxy().location()
        if (isEmptyAnonymousClassConstructor(context))
        	return true;
        val result = positionManager.getSourcePosition(location) == null
        if (result) {
        	return true
        }
        return false 
	}
	
	protected def boolean isXtextSourced(SuspendContext context) {
		val location = context.frameProxy.location
		return context.debugProcess.findOriginalDeclaration(location) != null
	}
		
	def isEmptyAnonymousClassConstructor(SuspendContext context) {
		val Location location = context.frameProxy.location
        if (location != null) {
          val Method method = location.method();
          if (method != null && method.isConstructor() && method.argumentTypes.isEmpty && method.declaringType.name.indexOf('$') > 0) {
            return true
          }
        }
	}
	
}