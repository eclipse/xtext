/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.internal.corext.callhierarchy.CallHierarchy;
import org.eclipse.jdt.internal.ui.callhierarchy.CallHierarchyUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.ui.editor.AbstractJvmElementHandler;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class OpenCallHierachyHandler extends AbstractJvmElementHandler {

	@Override
	protected void openPresentation(XtextEditor editor, IJavaElement javaElement, EObject selectedElement) {
		if(CallHierarchy.isPossibleInputElement(javaElement)){
			CallHierarchyUI.openSelectionDialog(new IMember[]{(IMember) javaElement}, editor.getSite().getWorkbenchWindow());
		}
	}
}
