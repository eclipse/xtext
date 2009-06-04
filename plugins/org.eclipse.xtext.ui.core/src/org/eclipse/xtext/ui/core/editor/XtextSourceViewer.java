/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.ArrayList;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextSourceViewer extends ProjectionViewer {

	@ImplementedBy(DefaultFactory.class)
	public interface Factory {
		XtextSourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles);
	}
	
	public static class DefaultFactory implements Factory {

		public XtextSourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler,
				IOverviewRuler overviewRuler, boolean showsAnnotationOverview, int styles) {
			return new XtextSourceViewer(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
		}
		
	}
	
	public XtextSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}
	
	/**
	 * copied from org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer.prependTextPresentationListener(ITextPresentationListener)
	 */
	@SuppressWarnings("unchecked")
	public void prependTextPresentationListener(ITextPresentationListener listener) {

		Assert.isNotNull(listener);

		if (fTextPresentationListeners == null)
			fTextPresentationListeners= new ArrayList<ITextPresentationListener>();

		fTextPresentationListeners.remove(listener);
		fTextPresentationListeners.add(0, listener);
	}

}
