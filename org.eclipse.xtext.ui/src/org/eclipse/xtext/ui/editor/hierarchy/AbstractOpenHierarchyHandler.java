/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public abstract class AbstractOpenHierarchyHandler extends AbstractHandler {

	private final static Logger LOG = Logger.getLogger(AbstractOpenHierarchyHandler.class);

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
		if (editor != null) {
			ISelection selection = editor.getSelectionProvider().getSelection();
			if (selection instanceof ITextSelection) {
				IWorkbenchWindow workbenchWindow = editor.getEditorSite().getWorkbenchWindow();
				editor.getDocument().priorityReadOnly(resource -> {
					openHierarchy(eObjectAtOffsetHelper.resolveElementAt(resource, ((ITextSelection) selection).getOffset()),
							workbenchWindow);
					return null;
				});
			}
		}
		return null;
	}

	protected void openHierarchy(EObject target, IWorkbenchWindow workbenchWindow) {
		try {
			IViewPart viewPart = workbenchWindow.getActivePage().showView(getHierarchyViewPartID());
			if (viewPart instanceof AbstractHierarchyViewPart) {
				AbstractHierarchyViewPart hierarchyViewPart = (AbstractHierarchyViewPart) viewPart;
				hierarchyViewPart.setBuilder(createHierarchyBuilder(target));
				hierarchyViewPart.setRootURI(EcoreUtil2.getPlatformResourceOrNormalizedURI(target));
				hierarchyViewPart.refresh(null);
			}
		} catch (PartInitException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	protected abstract String getHierarchyViewPartID();

	protected abstract IHierarchyBuilder createHierarchyBuilder(EObject target);
}
