/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextPresentationReconciler;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Highlighting helper.
 * Initially copied from org.eclipse.jdt.internal.ui.javaeditor.SemanticHighlightingManager
 * 
 * @author Sebastian Zarnekow
 */
public class HighlightingHelper implements IHighlightingHelper, IPropertyChangeListener {

	@Inject
	private Provider<HighlightingReconciler> reconcilerProvider;
	
	@Inject
	private Provider<HighlightingPresenter> presenterProvider;
	
	@Inject
	private IPreferenceStoreAccess preferenceStoreAccessor;
	
	@Inject
	private TextAttributeProvider textAttributeProvider;
	
	/** Highlighting presenter */
	private HighlightingPresenter fPresenter;
	/** Highlighting reconciler */
	private HighlightingReconciler fReconciler;

	/** The editor */
	private XtextEditor fEditor;
	/** The source viewer */
	private XtextSourceViewer fSourceViewer;
	/** The source viewer configuration */
	private XtextSourceViewerConfiguration fConfiguration;
	/** The presentation reconciler */
	private XtextPresentationReconciler fPresentationReconciler;

	private IPreferenceStore preferenceStore;

	@Override
	public void install(XtextEditor editor, XtextSourceViewer sourceViewer) {
		fEditor= editor;
		if (fEditor != null) {
			install(editor.getXtextSourceViewerConfiguration(), sourceViewer) ;
		}
	}

	/**
	 * @since 2.3
	 */
	public void install(XtextSourceViewerConfiguration configuration, XtextSourceViewer sourceViewer) {
		fSourceViewer= sourceViewer;
		fConfiguration= configuration;
		if(sourceViewer != null && configuration != null){
			fPresentationReconciler= (XtextPresentationReconciler) fConfiguration.getPresentationReconciler(sourceViewer);
		} else {
			fPresentationReconciler = null;
			fConfiguration = null;
		}
		preferenceStore = getPreferenceStoreAccessor().getPreferenceStore();
		preferenceStore.addPropertyChangeListener(this);
		enable();
	}

	/**
	 * Enable advanced highlighting.
	 */
	private void enable() {
		fPresenter= getPresenterProvider().get();
		fPresenter.install(fSourceViewer, fPresentationReconciler);

		if (fSourceViewer.getDocument() != null) {
			fReconciler= reconcilerProvider.get();
			fReconciler.install(fEditor, fSourceViewer, fPresenter);
		}
	}

	@Override
	public void uninstall() {
		disable();
		if (preferenceStore != null) {
			preferenceStore.removePropertyChangeListener(this);
		}
		fEditor= null;
		fSourceViewer= null;
		fConfiguration= null;
		fPresentationReconciler= null;
	}

	/**
	 * Disable advanced highlighting.
	 */
	private void disable() {
		if (fReconciler != null) {
			fReconciler.uninstall();
			fReconciler= null;
		}

		if (fPresenter != null) {
			fPresenter.uninstall();
			fPresenter= null;
		}
	}

	/**
	 * Returns this hightlighter's reconciler.
	 *
	 * @return the highlighter reconciler or <code>null</code> if none
	 */
	public HighlightingReconciler getReconciler() {
		return fReconciler;
	}

	public void setReconcilerProvider(Provider<HighlightingReconciler> reconcilerProvider) {
		this.reconcilerProvider = reconcilerProvider;
	}

	public Provider<HighlightingReconciler> getReconcilerProvider() {
		return reconcilerProvider;
	}

	public void setPresenterProvider(Provider<HighlightingPresenter> presenterProvider) {
		this.presenterProvider = presenterProvider;
	}

	public Provider<HighlightingPresenter> getPresenterProvider() {
		return presenterProvider;
	}

	public void setPreferenceStoreAccessor(IPreferenceStoreAccess preferenceStoreAccessor) {
		this.preferenceStoreAccessor = preferenceStoreAccessor;
	}

	public IPreferenceStoreAccess getPreferenceStoreAccessor() {
		return preferenceStoreAccessor;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (fReconciler != null && fEditor != null) {
			if (event.getProperty().startsWith(PreferenceStoreAccessor.tokenTypeTag(fEditor.getLanguageName()))) {
				textAttributeProvider.propertyChange(event);
				fReconciler.refresh();
			}
		}
	}

}
