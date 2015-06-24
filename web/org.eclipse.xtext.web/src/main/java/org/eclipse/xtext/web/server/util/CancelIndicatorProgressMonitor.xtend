package org.eclipse.xtext.web.server.util

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.CancelIndicator

@FinalFieldsConstructor
class CancelIndicatorProgressMonitor implements IProgressMonitor {

	val CancelIndicator delegate	
	
	boolean isCanceled
	
	override beginTask(String name, int totalWork) {
	}
	
	override done() {
	}
	
	override internalWorked(double work) {
	}
	
	override isCanceled() {
		isCanceled || delegate.isCanceled
	}
	
	override setCanceled(boolean value) {
		isCanceled = value
	}
	
	override setTaskName(String name) {
	}
	
	override subTask(String name) {
	}
	
	override worked(int work) {
	}
}