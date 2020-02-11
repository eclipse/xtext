/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.text.JavaElementProvider;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.InformationPresenter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.ui.editor.AbstractJvmElementHandler;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class QuickTypeHierarchyHandler extends AbstractJvmElementHandler {

	@Inject
	ILocationInFileProvider locationInFileProvider;

	@Override
	protected void openPresentation(final XtextEditor editor, final IJavaElement javaElement,
			final EObject selectedElement) {
		final ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		ITextRegion significantTextRegion = locationInFileProvider.getSignificantTextRegion(selectedElement);
		InformationPresenter presenter = new HierarchyInformationPresenter(sourceViewer, javaElement, new Region(significantTextRegion.getOffset(),significantTextRegion.getLength()));
		presenter.setDocumentPartitioning(IDocumentExtension3.DEFAULT_PARTITIONING);
		presenter.setAnchor(AbstractInformationControlManager.ANCHOR_GLOBAL);
		IInformationProvider provider = new JavaElementProvider(editor, false);
		presenter.setInformationProvider(provider, IDocument.DEFAULT_CONTENT_TYPE);
		presenter.setInformationProvider(provider, IJavaPartitions.JAVA_DOC);
		presenter.setInformationProvider(provider, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);
		presenter.setInformationProvider(provider, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);
		presenter.setInformationProvider(provider, IJavaPartitions.JAVA_STRING);
		presenter.setInformationProvider(provider, IJavaPartitions.JAVA_CHARACTER);
		presenter.setSizeConstraints(50, 20, true, false);
		presenter.install(sourceViewer);
		presenter.showInformation();
	}



}
