/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.codemining;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.ISourceViewerExtension5;
import org.eclipse.xtext.ui.editor.reconciler.IReconcileStrategyFactory;

import com.google.common.annotations.Beta;

/**
 * This strategy updates code minings for the given <code>sourceViewer</code>.
 * Therefore the <code>sourceViewer</code> has to implement
 * {@link org.eclipse.jface.text.source.ISourceViewerExtension5}. The
 * {@link org.eclipse.jface.text.source.ISourceViewerExtension5} exists in
 * <code>org.eclipse.jface.text</code> with version 3.13. This strategy will be
 * injected, the
 * {@link org.eclipse.xtext.xtext.generator.ide.codelens.CodeMiningFragment}
 * creates the binding. It calls
 * {@link org.eclipse.jface.text.source.ISourceViewerExtension5#updateCodeMinings()}
 * with reflection. The reflection is necessary to handle different target
 * platforms, which do not support <code>org.eclipse.jface.text</code> in
 * version 3.13.
 * 
 * @since 2.14
 * @author René Purrio - Initial contribution and API
 * @author Karsten Thoms - Initial contribution and API
 */
@Beta
public class XtextCodeMiningReconcileStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

	public static class Factory implements IReconcileStrategyFactory {

		@Override
		public IReconcilingStrategy create(ISourceViewer viewer) {
			if (viewer instanceof ISourceViewerExtension5) {
				return new XtextCodeMiningReconcileStrategy((ISourceViewerExtension5) viewer);
			}
			return null;
		}

	}

	private ISourceViewerExtension5 sourceViewer;

	public XtextCodeMiningReconcileStrategy(ISourceViewerExtension5 sourceViewer) {
		this.sourceViewer = sourceViewer;
	}

	@Override
	public void initialReconcile() {
		sourceViewer.updateCodeMinings();
	}

	@Override
	public void reconcile(IRegion partition) {
		sourceViewer.updateCodeMinings();
	}

	@Override
	public void setProgressMonitor(IProgressMonitor monitor) {
		// Do nothing
	}

	@Override
	public void setDocument(IDocument document) {
		sourceViewer.updateCodeMinings();
	}

	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		// Do nothing
	}
}
