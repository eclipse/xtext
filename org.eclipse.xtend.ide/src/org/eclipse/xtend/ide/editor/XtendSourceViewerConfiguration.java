/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.text.javadoc.JavaDocScanner;
import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtend.ide.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.XtextPresentationReconciler;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtendSourceViewerConfiguration extends XtextSourceViewerConfiguration {
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		XtextPresentationReconciler reconciler = (XtextPresentationReconciler) super
				.getPresentationReconciler(sourceViewer);
		IPreferenceStore store = JavaPlugin.getDefault().getCombinedPreferenceStore();
		IColorManager colorManager = JavaPlugin.getDefault().getJavaTextTools().getColorManager();
		JavaDocScanner javaDocScanner = new JavaDocScanner(colorManager, store, null);
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(javaDocScanner);
		reconciler.setRepairer(dr, TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		reconciler.setDamager(dr, TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		return reconciler;
	}
}
