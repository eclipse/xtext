/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.outline;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2QuickOutlineFilterAndSorter extends QuickOutlineFilterAndSorter {

	public Xtend2QuickOutlineFilterAndSorter() {
		addFilter(new IFilter() {
			
			public boolean apply(IOutlineNode input) {
				// skip imports
				return !(input instanceof EStructuralFeatureNode);
			}
			
			public boolean isEnabled() {
				return true;
			}
		});
	}
}
