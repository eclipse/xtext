/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendQuickOutlineFilterAndSorter extends QuickOutlineFilterAndSorter {

	public XtendQuickOutlineFilterAndSorter() {
		addFilter(new IFilter() {
			
			@Override
			public boolean apply(IOutlineNode input) {
				if (input instanceof XtendFeatureNode) {
					return !((XtendFeatureNode) input).isSynthetic();
				}
				return !equal("import declarations", input.getText().toString());
			}
			
			@Override
			public boolean isEnabled() {
				return true;
			}
		});
	}
}
