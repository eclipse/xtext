/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.launching;

import static org.xpect.runner.DescriptionFactory.createFileDescription;
import static org.xpect.runner.DescriptionFactory.createTestDescription;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.runner.Description;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.XpectTest;
import org.xpect.ui.util.ContentTypeUtil;
import org.xpect.ui.util.ContentTypeUtil.XpectContentType;
import org.xpect.ui.util.XpectFileAccess;
import org.xpect.ui.util.XpectUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JUnitJavaElementDelegate implements IAdaptable {

	private final Description description;
	private final IJavaElement javaElement;

	public JUnitJavaElementDelegate(IEditorPart editorPart) {
		Pair<IJavaElement, Description> pair = getJavaElementForXtextEditor(editorPart);
		if (pair != null) {
			this.javaElement = pair.getFirst();
			this.description = pair.getSecond();
		} else {
			this.javaElement = null;
			this.description = null;
		}
	}

	public JUnitJavaElementDelegate(IFile file) {
		if (new ContentTypeUtil().getContentType(file) == XpectContentType.XPECT) {
			XpectFile xpectFile = XpectUtil.loadFile(file);
			if (xpectFile != null) {
				this.javaElement = getTestClassJavaElement(xpectFile);
				this.description = createFileDescription(xpectFile);
			} else {
				this.javaElement = null;
				this.description = null;
			}
		} else {
			this.javaElement = null;
			this.description = null;
		}
	}

	public JUnitJavaElementDelegate(IFileEditorInput fileEditorInput) {
		this(fileEditorInput.getFile());
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (getClass().equals(adapter))
			return this;
		if (IJavaElement.class.equals(adapter))
			return javaElement;
		if (Description.class.equals(adapter))
			return description;
		return null;
	}

	public Description getDescription() {
		return description;
	}

	public IJavaElement getJavaElement() {
		return javaElement;
	}

	private Pair<IJavaElement, Description> getJavaElementForXtextEditor(IEditorPart editor) {
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
		Pair<IJavaElement, Description> result = xtextEditor.getDocument().readOnly(new IUnitOfWork<Pair<IJavaElement, Description>, XtextResource>() {
			public Pair<IJavaElement, Description> exec(XtextResource state) throws Exception {
				XpectFile xpectFile = XpectFileAccess.getXpectFile(state);
				IJavaElement javaElement = getTestClassJavaElement(xpectFile);
				XtextResource resource = (XtextResource) xpectFile.eResource();
				INode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
				if (node != null) {
					EObject obj = node.getSemanticElement();
					if (obj instanceof XpectInvocation) {
						Description desc = createTestDescription((XpectInvocation) obj);
						return Tuples.create(javaElement, desc);
					}
				}
				Description desc = createFileDescription(xpectFile);
				return Tuples.create(javaElement, desc);
			}
		});
		return result;
	}

	private IJavaElement getTestClassJavaElement(XpectFile file) {
		XpectTest test = file.getTest();
		if (test != null) {
			IJavaElementFinder finder = ((XtextResource) test.eResource()).getResourceServiceProvider().get(IJavaElementFinder.class);
			if (test != null) {
				JvmDeclaredType testClass = test.getTestClassOrSuite().getTestOrSuite().getJvmClass();
				if (testClass != null && !testClass.eIsProxy())
					return finder.findElementFor(testClass);
			}
		}
		return null;
	}

}
