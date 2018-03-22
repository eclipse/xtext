/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 */
public interface IReconcileStrategyFactory {

	IReconcilingStrategy create(ISourceViewer viewer);
	
	default IReconcilingStrategy createOrNull(ISourceViewer viewer) {
		try {
			return create(viewer);
		} catch(Throwable t) {
			return null;
		}
	}
	
}
