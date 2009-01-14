/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * Provides a default implementation of interface <code>IXtextSourceViewer</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see IXtextSourceViewer
 */
public class XtextSourceViewer extends ProjectionViewer {

	public XtextSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}

	@Override
	protected void createControl(Composite parent, int styles) {
		// required for 'headless' standalone unit tests
		if (parent != null) {
			super.createControl(parent, styles);
		}
	}

}
