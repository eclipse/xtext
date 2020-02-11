/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 * @since 2.14
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
