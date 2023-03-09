/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder.CallHierarchyType;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author kosyakov - Initial contribution and API
 */
public class SetHierarchyTypeAction extends Action {

	private final CallHierarchyType callHierarchyType;

	private final AbstractCallHierarchyViewPart callHierarchyViewPart;

	public SetHierarchyTypeAction(CallHierarchyType callHierarchyType, AbstractCallHierarchyViewPart callHierarchyViewPart) {
		super("", IAction.AS_RADIO_BUTTON);
		this.callHierarchyType = callHierarchyType;
		this.callHierarchyViewPart = callHierarchyViewPart;
		switch (callHierarchyType) {
			case CALLEE:
				setText("Show Callee Hierarchy");
				setToolTipText("Show Callee Hierarchy");
				setImageDescriptor(XtextPluginImages.DESC_CH_CALLEES);
				setHoverImageDescriptor(XtextPluginImages.DESC_CH_CALLEES);
				break;
			default:
				setText("Show Caller Hierarchy");
				setToolTipText("Show Caller Hierarchy");
				setImageDescriptor(XtextPluginImages.DESC_CH_CALLERS);
				setHoverImageDescriptor(XtextPluginImages.DESC_CH_CALLERS);
				break;
		}
	}

	@Override
	public void run() {
		callHierarchyViewPart.setCallHierarchyType(callHierarchyType);
	}

	public CallHierarchyType getHierarchyType() {
		return callHierarchyType;
	}
}
