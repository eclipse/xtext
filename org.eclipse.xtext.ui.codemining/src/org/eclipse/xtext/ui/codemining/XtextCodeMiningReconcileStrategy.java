/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.codemining;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy;

import com.google.common.annotations.Beta;

/**
 * This strategy updates code minings for the given <code>sourceViewer</code>.
 * Therefore the <code>sourceViewer</code> has to implement {@link org.eclipse.jface.text.source.ISourceViewerExtension5}.
 * The {@link org.eclipse.jface.text.source.ISourceViewerExtension5} exists in <code>org.eclipse.jface.text</code> with version 3.13.
 * This strategy will be injected, the {@link org.eclipse.xtext.xtext.generator.ide.codelens.CodeMiningFragment} creates the binding.
 * It calls {@link org.eclipse.jface.text.source.ISourceViewerExtension5#updateCodeMinings()} with reflection.
 * The reflection is necessary to handle different target platforms, which do not support <code>org.eclipse.jface.text</code> in version 3.13.  
 * 
 * @since 2.14 
 * @author René Purrio  - Initial contribution and API
 */
@Beta
public class XtextCodeMiningReconcileStrategy extends XtextDocumentReconcileStrategy {
	private static final Class<?> CLASS_SOURCE_VIEWER_EXTENSION_5;
	private static final Method METHOD_UPDATE_CODMINING;
	static {
		Class<?> clazz;
		Method method;
		try {
			clazz = Class.forName("org.eclipse.jface.text.source.ISourceViewerExtension5");
			method = clazz.getDeclaredMethod("updateCodeMinings");
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			clazz = null;
			method = null;
		} 
		CLASS_SOURCE_VIEWER_EXTENSION_5 = clazz;
		METHOD_UPDATE_CODMINING = method;
	}

	private boolean codeMiningEnabled; 
	
	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		super.setSourceViewer(sourceViewer);
		codeMiningEnabled = CLASS_SOURCE_VIEWER_EXTENSION_5 != null && CLASS_SOURCE_VIEWER_EXTENSION_5.isInstance(sourceViewer);
		if (codeMiningEnabled) {
			addStrategy(new UpdateCodeMiningStrategy(sourceViewer));
		}
	}
	
	protected class UpdateCodeMiningStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {
		private ISourceViewer sourceViewer;
		
		public UpdateCodeMiningStrategy(ISourceViewer sourceViewer) {
			this.sourceViewer = sourceViewer;
		}
		
		@Override
		public void initialReconcile() {
			updateCodeMinings();
		}
	
		@Override
		public void reconcile(IRegion partition) {
			updateCodeMinings();
		}
	
		@Override
		public void setProgressMonitor(IProgressMonitor monitor) {
			// Do nothing
		}
	
		@Override
		public void setDocument(IDocument document) {
			// Do nothing
		}
	
		@Override
		public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
			// Do nothing
		}
		
		private void updateCodeMinings() {
			try {
				if(codeMiningEnabled) {
					METHOD_UPDATE_CODMINING.invoke(sourceViewer);
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
