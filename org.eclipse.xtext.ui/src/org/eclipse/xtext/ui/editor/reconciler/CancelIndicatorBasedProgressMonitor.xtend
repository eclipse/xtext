/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.7
 */
class CancelIndicatorBasedProgressMonitor implements IProgressMonitor {

	@Delegate 
	val IProgressMonitor doDelegate = new NullProgressMonitor()
	
	val CancelIndicator cancelIndicator
	@FinalFieldsConstructor new() {}

	override boolean isCanceled() {
		return cancelIndicator.canceled
	}
}