/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManagerOverrides;
import org.eclipse.jface.action.MenuManager;

import com.google.inject.ImplementedBy;

/**
 * Filters bogus contributions from other plug-ins from the context menu of outline.
 * 
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(IContentOutlineContextMenuOverrides.Default.class)
public interface IContentOutlineContextMenuOverrides extends IContributionManagerOverrides {

	static class Default implements IContentOutlineContextMenuOverrides {

		public Boolean getEnabled(IContributionItem item) {
			return isValid(item);
		}

		public Integer getAccelerator(IContributionItem item) {
			return null;
		}

		public String getAcceleratorText(IContributionItem item) {
			return null;
		}

		public String getText(IContributionItem item) {
			return null;
		}

		public Boolean getVisible(IContributionItem item) {
			return isValid(item);
		}
		
		protected boolean isValid(IContributionItem item) {
			String id = item.getId();
			if(id == null 
					|| id.startsWith("org.eclipse.debug.ui") 
					|| "org.eclipse.ui.projectConfigure".equals(id) 
					|| id.startsWith("org.eclipse.ocl.examples.xtext.oclinecore")) return false;
			if(item instanceof MenuManager && "WikiText".equals(((MenuManager) item).getMenuText())) return false;
			return true;
		}
	}
}
