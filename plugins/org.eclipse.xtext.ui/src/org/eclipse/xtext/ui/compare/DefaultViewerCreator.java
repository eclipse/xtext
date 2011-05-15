/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;

import com.google.inject.Inject;
import com.google.inject.Provider;

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

	public Viewer createViewer(Composite parent, CompareConfiguration compareConfiguration) {
		if (compareConfiguration == null) {
			return createContentViever(parent, compareConfiguration);
		}
		return createMergeViewer(parent, compareConfiguration);
	}

	protected Viewer createMergeViewer(Composite parent, CompareConfiguration compareConfiguration) {
		compareConfiguration.setProperty(DefaultMergeEditor.PROVIDER, mergeEditorProvider);
		return new DefaultMergeViewer(parent, SWT.NULL, compareConfiguration, documentProvider,
				sourceViewerConfigurationProvider);
	}

	protected Viewer createContentViever(Composite parent, CompareConfiguration compareConfiguration) {
		DefaultContentViewer defaultContentViewer = contentViewerProvider.get();
		defaultContentViewer.init(parent, compareConfiguration);
		return defaultContentViewer;
	}

}
