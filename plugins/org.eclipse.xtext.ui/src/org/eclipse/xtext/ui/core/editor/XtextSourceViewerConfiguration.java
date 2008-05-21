/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextSourceViewerConfiguration extends
		TextSourceViewerConfiguration {
	private final XtextModelManager modelManager;

	/**
	 * @param languageDescriptor
	 * @param langDescr
	 */
	public XtextSourceViewerConfiguration(XtextModelManager manager,
			IPreferenceStore preferenceStore) {
		super(preferenceStore);
		this.modelManager = manager;
	}

	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = (PresentationReconciler) super
				.getPresentationReconciler(sourceViewer);
		DefaultDamagerRepairer defDR = new DefaultDamagerRepairer(
				new XtextTokenScanner(modelManager));
		reconciler.setRepairer(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setDamager(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;
	}

}
