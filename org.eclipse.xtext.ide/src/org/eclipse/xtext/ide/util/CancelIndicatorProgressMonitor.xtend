/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.util

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@FinalFieldsConstructor
class CancelIndicatorProgressMonitor implements IProgressMonitor {

	val CancelIndicator delegate	
	
	boolean canceled
	
	override isCanceled() {
		canceled || delegate.isCanceled
	}
	
	override setCanceled(boolean value) {
		canceled = value
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