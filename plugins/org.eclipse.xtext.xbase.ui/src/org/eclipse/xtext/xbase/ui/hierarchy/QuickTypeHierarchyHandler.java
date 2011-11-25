/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.text.JavaElementProvider;
import org.eclipse.jdt.internal.ui.typehierarchy.HierarchyInformationControl;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.InformationPresenter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class QuickTypeHierarchyHandler extends AbstractTypeHierarchyHandler {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Override
	protected void openPresentation(final XtextEditor editor, final IJavaElement javaElement, final EObject selectedElement) {
		final ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		InformationPresenter presenter= new HierarchyInformationPresenter(getHierarchyPresenterControlCreator(), sourceViewer, javaElement, selectedElement);
		presenter.setDocumentPartitioning(IDocumentExtension3.DEFAULT_PARTITIONING);
		presenter.setAnchor(AbstractInformationControlManager.ANCHOR_GLOBAL);
		IInformationProvider provider= new JavaElementProvider(editor, false);
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
	
	private IInformationControlCreator getHierarchyPresenterControlCreator() {
		return new IInformationControlCreator() {
			public IInformationControl createInformationControl(Shell parent) {
				int shellStyle= SWT.RESIZE;
				int treeStyle= SWT.V_SCROLL | SWT.H_SCROLL;
				HierarchyInformationControl hierarchyInformationControl = new HierarchyInformationControl(parent, shellStyle, treeStyle);
				return hierarchyInformationControl;
			}
		};
	}
	

	protected final class HierarchyInformationPresenter extends InformationPresenter {
		private final ISourceViewer sourceViewer;
		private final IJavaElement javaElement;
		private final EObject selectedElement;

		protected HierarchyInformationPresenter(IInformationControlCreator creator, ISourceViewer sourceViewer,
				IJavaElement javaElement, EObject selectedElement) {
			super(creator);
			this.sourceViewer = sourceViewer;
			this.javaElement = javaElement;
			this.selectedElement = selectedElement;
		}

		@Override
		protected void computeInformation() {
			setCustomInformationControlCreator(null);
			ITextRegion significantRegion = locationInFileProvider.getSignificantTextRegion(selectedElement);
			setInformation(javaElement,computeArea(new Region(significantRegion.getOffset(), significantRegion.getLength())));
			presentInformation();
		}

		// copied from org.eclipse.jface.text.information.InformationPresenter due to visibility problems
		protected Rectangle computeArea(IRegion region) {

			int start= 0;
			int end= 0;

			IRegion widgetRegion= modelRange2WidgetRange(region);
			if (widgetRegion != null) {
				start= widgetRegion.getOffset();
				end= widgetRegion.getOffset() + widgetRegion.getLength();
			}

			StyledText styledText= sourceViewer.getTextWidget();
			Rectangle bounds;
			if (end > 0 && start < end)
				bounds= styledText.getTextBounds(start, end - 1);
			else {
				Point loc= styledText.getLocationAtOffset(start);
				bounds= new Rectangle(loc.x, loc.y, 0, styledText.getLineHeight(start));
			}

			return bounds;
		}

		// copied from org.eclipse.jface.text.information.InformationPresenter due to visibility problems
		protected IRegion modelRange2WidgetRange(IRegion region) {
			if (sourceViewer instanceof ITextViewerExtension5) {
				ITextViewerExtension5 extension= (ITextViewerExtension5) sourceViewer;
				return extension.modelRange2WidgetRange(region);
			}

			IRegion visibleRegion= sourceViewer.getVisibleRegion();
			int start= region.getOffset() - visibleRegion.getOffset();
			int end= start + region.getLength();
			if (end > visibleRegion.getLength())
				end= visibleRegion.getLength();

			return new Region(start, end - start);
		}
	}

}
