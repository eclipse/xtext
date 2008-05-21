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
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextSourceViewerConfiguration extends
		SourceViewerConfiguration {
	private LanguageDescriptor languageDescriptor;

	/**
	 * @param languageDescriptor
	 * @param langDescr
	 */
	public XtextSourceViewerConfiguration(
			LanguageDescriptor languageDescriptor,
			IPreferenceStore preferenceStore) {
		this.languageDescriptor = languageDescriptor;
	}

	/**
	 * @return
	 */
	public LanguageDescriptor getLanguageDescriptor() {
		return languageDescriptor;
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return new XtextReconciler(new XtextReconcilerStrategy(sourceViewer));
	}

	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		DefaultDamagerRepairer defDR = new DefaultDamagerRepairer(
				new XtextTokenScanner(getLanguageDescriptor()));
		reconciler.setRepairer(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setDamager(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;
	}
}
