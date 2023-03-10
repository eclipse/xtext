/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.UIBindings;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultViewerCreator implements IViewerCreator {
	@Inject
	protected Provider<DefaultContentViewer> contentViewerProvider;
	@Inject
	protected Provider<DefaultMergeEditor> mergeEditorProvider;
	@Inject
	protected StreamContentDocumentProvider documentProvider;
	@Inject
	protected Provider<XtextSourceViewerConfiguration> sourceViewerConfigurationProvider;
	@Inject(optional=true) @Named(UIBindings.COMPARE_VIEWER_TITLE)
	protected String compareViewerTitle = "Text Compare";
	/**
	 * @since 2.19
	 */
	@Inject
	protected XtextDocumentUtil xtextDocumentUtil;

	@Override
	public Viewer createViewer(Composite parent, CompareConfiguration compareConfiguration) {
		if (compareConfiguration == null) {
			return createContentViever(parent, compareConfiguration);
		}
		return createMergeViewer(parent, compareConfiguration);
	}

	protected Viewer createMergeViewer(Composite parent, CompareConfiguration compareConfiguration) {
		compareConfiguration.setProperty(DefaultMergeEditor.PROVIDER, mergeEditorProvider);
		DefaultMergeViewer result = new DefaultMergeViewer(parent, SWT.NULL, compareConfiguration, documentProvider,
				sourceViewerConfigurationProvider) {
			@Override
			public String getTitle() {
				if (compareViewerTitle != null) {
					return compareViewerTitle;
				}
				return super.getTitle();
			}
		};
		result.setXtextDocumentUtil(xtextDocumentUtil);
		return result;
	}

	protected Viewer createContentViever(Composite parent, CompareConfiguration compareConfiguration) {
		DefaultContentViewer defaultContentViewer = contentViewerProvider.get();
		defaultContentViewer.init(parent, compareConfiguration);
		return defaultContentViewer;
	}

}
