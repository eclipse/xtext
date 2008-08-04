/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IMarkerResolutionGenerator2;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextMarkerResolutionGenerator implements IMarkerResolutionGenerator2 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.
	 * core.resources.IMarker)
	 */
	public IMarkerResolution[] getResolutions(IMarker marker) {
		return new IMarkerResolution2[] { new IMarkerResolution2() {

			public String getDescription() {
				return "Xtext Marker Resolution Descr";
			}

			public Image getImage() {
				return null;
			}

			public String getLabel() {
				return "Can Fix all problemms QuickFix";
			}

			public void run(IMarker marker) {
				// TODO Auto-generated method stub

			}
		} };
	}

	public boolean hasResolutions(IMarker marker) {
		return true;
	}

}
