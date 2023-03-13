/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IFilter;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShowSyntheticMembersContribution extends AbstractFilterOutlineContribution {

	public static final String PREFERENCE_KEY = "ui.outline.filterSynthetic";

	@Inject
	private PluginImageHelper imageHelper;

	private IFilter filter;
	
	@Override
	public IFilter getFilter() {
		if (filter == null) {
			filter = new IFilter() {
				@Override
				public boolean apply(IOutlineNode node) {
					return ShowSyntheticMembersContribution.this.apply(node);
				}

				@Override
				public boolean isEnabled() {
					return !isPropertySet();
				}
			};
		}
		return filter;
	}
	
	@Override
	protected boolean apply(IOutlineNode node) {
		if (node instanceof XtendFeatureNode) {
			XtendFeatureNode eObjectNode = (XtendFeatureNode) node;
			return !eObjectNode.isSynthetic();
		}
		return true;
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void configureAction(Action action) {
		action.setText("Show Synthetic Members");
		action.setDescription("Show Synthetic Members");
		action.setToolTipText("Show Synthetic Members");
		action.setImageDescriptor(imageHelper.getImageDescriptor("generated_code_view.png"));
	}
}
