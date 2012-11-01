/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.xpect.XpectFile;
import org.xpect.XpectTest;
import org.xpect.ui.util.ContentTypeUtil;
import org.xpect.ui.util.ContentTypeUtil.XpectContentType;
import org.xpect.ui.util.XpectFileAccess;
import org.xpect.ui.util.XpectUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JUnitJavaElementDelegate implements IAdaptable {

	private final IEditorPart editorPart;

	private final IFileEditorInput fileEditorInput;

	private final IResource resource;

	public JUnitJavaElementDelegate(IEditorPart editorPart) {
		this.editorPart = editorPart;
		this.fileEditorInput = null;
		this.resource = null;
	}

	public JUnitJavaElementDelegate(IFileEditorInput fileEditorInput) {
		this.fileEditorInput = fileEditorInput;
		this.resource = null;
		this.editorPart = null;
	}

	public JUnitJavaElementDelegate(IResource resource) {
		this.resource = resource;
		this.fileEditorInput = null;
		this.editorPart = null;
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (getClass().equals(adapter))
			return this;
		if (!(IJavaElement.class.equals(adapter)))
			return null;
		if (editorPart != null)
			return getJavaElementForXtextEditor(editorPart);
		else if (resource instanceof IFile)
			return getTestClassJavaElement((IFile) resource);
		else if (fileEditorInput != null)
			return getTestClassJavaElement(fileEditorInput.getFile());
		return null;
	}

	public IEditorPart getEditorPart() {
		return editorPart;
	}

	public IFileEditorInput getFileEditorInput() {
		return fileEditorInput;
	}

	protected IJavaElement getJavaElementForXtextEditor(IEditorPart editor) {
		if (!(editor instanceof XtextEditor))
			return null;
		IJavaProject jp = null;
		if (editor.getEditorInput() instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) editor.getEditorInput()).getFile();
			if (new ContentTypeUtil().getContentType(file) != XpectContentType.XPECT)
				return null;
			jp = JavaCore.create(file.getProject());
			if (jp == null || !jp.exists() || !jp.isOpen())
				return null;
		} else
			return null;
		XtextEditor xtextEditor = (XtextEditor) editor;
		ISelection selection = xtextEditor.getSelectionProvider().getSelection();
		if (!(selection instanceof ITextSelection))
			return null;
		final int offset = ((ITextSelection) selection).getOffset();
		IJavaElement func = xtextEditor.getDocument().readOnly(new IUnitOfWork<IJavaElement, XtextResource>() {
			public IJavaElement exec(XtextResource state) throws Exception {
				XtextResource xpectResource = XpectFileAccess.getXpectResource(state);
				INode node = NodeModelUtils.findLeafNodeAtOffset(xpectResource.getParseResult().getRootNode(), offset);
				if (node != null) {
					EObject obj = node.getSemanticElement();
					EObject current = obj;
					while (current != null) {
						// if (current instanceof XpectInvocation) {
						// XpectInvocation inv = (XpectInvocation) current;
						// JvmOperation operation = inv.getElement();
						// if (operation != null && !operation.eIsProxy())
						// return finder.findElementFor(operation);
						// return null;
						// } else
						if (current instanceof XpectFile)
							return getTestClassJavaElement((XpectFile) current);
						current = current.eContainer();
					}
				}
				return null;
			}

		});
		return func;
	}

	public IResource getResource() {
		return resource;
	}

	private IJavaElement getTestClassJavaElement(IFile iFile) {
		if (new ContentTypeUtil().getContentType(iFile) != XpectContentType.XPECT)
			return null;
		XpectFile xpectFile = XpectUtil.load(iFile);
		if (xpectFile != null)
			return getTestClassJavaElement(xpectFile);
		return null;
	}

	protected IJavaElement getTestClassJavaElement(XpectFile file) {
		XpectTest test = file.getTest();
		if (test != null) {
			IJavaElementFinder finder = ((XtextResource) test.eResource()).getResourceServiceProvider().get(IJavaElementFinder.class);
			if (test != null) {
				JvmDeclaredType testClass = test.getTestClass();
				if (testClass != null && !testClass.eIsProxy())
					return finder.findElementFor(testClass);
			}
		}
		return null;
	}

}
