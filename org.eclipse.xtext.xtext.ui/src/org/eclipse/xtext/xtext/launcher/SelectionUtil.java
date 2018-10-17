/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.launcher;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class SelectionUtil {
	
	public static IFile getSelectedFile(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof TextSelection) {
			IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
			return getSelectedFile(activeEditor);
		} else if (selection instanceof IStructuredSelection) {
			return getSelectedFile(selection);
		}
		return null;
	}
	
	public static IFile getSelectedFile(IEditorPart editor) {
		IEditorInput editorInput = editor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;
			return fileEditorInput.getFile();
		}
		return null;
	}
	
	public static IFile getSelectedFile(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			Object firstElement = ssel.getFirstElement();
			if (firstElement instanceof IAdaptable) {
				return ((IAdaptable) firstElement).getAdapter(IFile.class);
			}
			else if (firstElement instanceof IOutlineNode) {
				IOutlineNode outlineNode = (IOutlineNode) firstElement;
				return outlineNode.tryReadOnly(new IUnitOfWork<IFile, EObject>() {
					@Override
					public IFile exec(EObject state) throws Exception {
						Resource resource = state.eResource();
						URI uri = resource.getURI();
						IPath path = new Path(uri.toPlatformString(true));
						return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
					}});
			}
		}
		return null;
	}

}
