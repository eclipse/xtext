/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.findrefs;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;

/**
 * @author koehnlein - Initial contribution and API
 */
public interface ReferenceSearchViewPageActions {

	public static class ShowNext extends Action {

		private ReferenceSearchViewPage page;

		public ShowNext(ReferenceSearchViewPage page) {
			super("Show Next Match");
			setImageDescriptor(XtextPluginImages.DESC_SEARCH_NEXT);
			setToolTipText("Show Next Match");
			this.page = page;
		}

		@Override
		public void run() {
			page.navigateNext(true);
		}
	}

	public static class ShowPrevious extends Action {

		private ReferenceSearchViewPage page;

		public ShowPrevious(ReferenceSearchViewPage page) {
			super("Show Previous Match");
			setImageDescriptor(XtextPluginImages.DESC_SEARCH_PREVIOUS);
			setToolTipText("Show Previous Match");
			this.page = page;
		}

		@Override
		public void run() {
			page.navigateNext(false);
		}
	}
}
