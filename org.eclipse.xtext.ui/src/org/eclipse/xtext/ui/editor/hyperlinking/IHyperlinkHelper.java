/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * The hyperlink helper should be implemented to detect hyperlinks at a given
 * offset in a {@link XtextResource resource}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(HyperlinkHelper.class)
public interface IHyperlinkHelper {

	/**
	 * Create hyperlinks at the given offset.
	 * Return <code>null</code> if no hyperlinks are available.
	 */
	IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks);

}
