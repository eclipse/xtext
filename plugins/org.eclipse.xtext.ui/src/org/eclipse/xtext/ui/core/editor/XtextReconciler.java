/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextReconciler extends MonoReconciler {

	public XtextReconciler(IReconcilingStrategy strategy, boolean isIncremental) {
		super(strategy, isIncremental);
	}

	public XtextReconciler(IReconcilingStrategy strategy) {
		this(strategy, false);
	}

}
