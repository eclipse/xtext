/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hierarchy;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.typehierarchy.HierarchyInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.InformationPresenter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

@SuppressWarnings("restriction")
public class HierarchyInformationPresenter extends InformationPresenter {
	private final ISourceViewer sourceViewer;
	private final IJavaElement javaElement;
	private IRegion region;

	protected static IInformationControlCreator getHierarchyPresenterControlCreator() {
		return new IInformationControlCreator() {
			@Override
			public IInformationControl createInformationControl(Shell parent) {
				int shellStyle = SWT.RESIZE;
				int treeStyle = SWT.V_SCROLL | SWT.H_SCROLL;
				HierarchyInformationControl hierarchyInformationControl = new HierarchyInformationControl(parent,
						shellStyle, treeStyle);
				return hierarchyInformationControl;
			}
		};
	}

	public HierarchyInformationPresenter(ISourceViewer sourceViewer,
			IJavaElement javaElement, IRegion region) {
		super(getHierarchyPresenterControlCreator());
		this.sourceViewer = sourceViewer;
		this.javaElement = javaElement;
		this.region = region;
	}

	@Override
	protected void computeInformation() {
		setCustomInformationControlCreator(null);
		setInformation(javaElement, computeArea(region));
		presentInformation();
	}

	// copied from org.eclipse.jface.text.information.InformationPresenter due to visibility problems
	protected Rectangle computeArea(IRegion region) {

		int start = 0;
		int end = 0;

		IRegion widgetRegion = modelRange2WidgetRange(region);
		if (widgetRegion != null) {
			start = widgetRegion.getOffset();
			end = widgetRegion.getOffset() + widgetRegion.getLength();
		}

		StyledText styledText = sourceViewer.getTextWidget();
		Rectangle bounds;
		if (end > 0 && start < end)
			bounds = styledText.getTextBounds(start, end - 1);
		else {
			Point loc = styledText.getLocationAtOffset(start);
			bounds = new Rectangle(loc.x, loc.y, 0, styledText.getLineHeight(start));
		}

		return bounds;
	}

	// copied from org.eclipse.jface.text.information.InformationPresenter due to visibility problems
	protected IRegion modelRange2WidgetRange(IRegion region) {
		if (sourceViewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension = (ITextViewerExtension5) sourceViewer;
			return extension.modelRange2WidgetRange(region);
		}

		IRegion visibleRegion = sourceViewer.getVisibleRegion();
		int start = region.getOffset() - visibleRegion.getOffset();
		int end = start + region.getLength();
		if (end > visibleRegion.getLength())
			end = visibleRegion.getLength();

		return new Region(start, end - start);
	}
}