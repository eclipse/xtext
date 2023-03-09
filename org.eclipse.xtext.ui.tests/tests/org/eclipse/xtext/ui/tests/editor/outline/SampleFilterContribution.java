/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SampleFilterContribution extends AbstractFilterOutlineContribution {

	public static final String PREFERENCE_KEY = "ui.outline.sampleFilter";
	
	@Inject
	private IWorkbench workbench;
	
	@Override
	protected boolean apply(IOutlineNode node) {
		String text = node.getText().toString();
		return text.equals("test") || text.length() < 4;
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void configureAction(Action action) {
		action.setText("Filter Sample");
		action.setToolTipText("Filter Sample");
		action.setDescription("Filter Sample");
		action.setImageDescriptor(workbench.getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_CLEAR));
	}

}
