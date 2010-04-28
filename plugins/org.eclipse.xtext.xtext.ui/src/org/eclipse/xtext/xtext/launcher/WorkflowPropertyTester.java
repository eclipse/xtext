/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.launcher;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;

/**
 * This property tester checks if there is a workflow file associated with the currently selected Xtext grammar file.
 * 
 * A workflow is considered being associated with a grammar file if:
 * <ul>
 * <li>It resides in the same folder as the Xtext grammar file</li>
 * <li>Its name is Generate&lt;Name of Grammar&gt;.mwe</li>
 * </ul>
 * 
 * @author Peter Friese - Initial contribution and API
 */
public class WorkflowPropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver == null)
			return false;

		IResource resource = (IResource) Platform.getAdapterManager().getAdapter(receiver,
				org.eclipse.core.resources.IResource.class);
		if (resource != null) {
			return WorkflowLaunchUtils.workflowFileAvailableForGrammarFile(resource);
		} else

		if (receiver instanceof ContentOutlineNode) {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			XtextEditor activeEditor = (XtextEditor) activePage.getActiveEditor();
			return WorkflowLaunchUtils.workflowFileAvailableFor(activeEditor);
		}

		TextSelection textSelection = (TextSelection) Platform.getAdapterManager().getAdapter(receiver,
				org.eclipse.jface.text.TextSelection.class);
		if (textSelection != null) {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorPart activeEditor = activePage.getActiveEditor();
			return WorkflowLaunchUtils.workflowFileAvailableFor(activeEditor);
		}

		return false;
	}
}
