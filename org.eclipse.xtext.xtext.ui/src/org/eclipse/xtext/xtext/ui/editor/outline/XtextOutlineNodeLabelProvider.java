/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtextOutlineNodeLabelProvider extends OutlineNodeLabelProvider {

	@Inject
	public XtextOutlineNodeLabelProvider(Delegate delegate) {
		super(delegate);
	}

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	@Override
	protected StyledString getStyledText(Object element) {
		if (element instanceof RuleNode && isShowReturnTypes()) {
			return ((RuleNode) element).getFullText();
		}
		return super.getStyledText(element);
	}
	
	protected boolean isShowReturnTypes() {
		return preferenceStoreAccess.getPreferenceStore().getBoolean(HideReturnTypesContribution.PREFERENCE_KEY);
	}
}
