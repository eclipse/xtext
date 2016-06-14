/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.util

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.CancelIndicator

@FinalFieldsConstructor
class CancelIndicatorProgressMonitor implements IProgressMonitor {

	val CancelIndicator delegate	
	
	boolean isCanceled
	
	override isCanceled() {
		isCanceled || delegate.isCanceled
	}
	
	override setCanceled(boolean value) {
		isCanceled = value
	}
	
	override beginTask(String name, int totalWork) {
	}
	
	override setTaskName(String name) {
	}
	
	override subTask(String name) {
	}
	
	override internalWorked(double work) {
	}
	
	override worked(int work) {
	}
	
	override done() {
	}
	
}