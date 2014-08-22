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
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
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
import org.xpect.XpectInvocation;
import org.xpect.XpectJavaModel;
import org.xpect.ui.util.ContentTypeUtil;
import org.xpect.ui.util.ContentTypeUtil.XpectContentType;
import org.xpect.ui.util.XpectFileAccess;
import org.xpect.ui.util.XpectUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JunitJavaElementDelegateAdapterFactory implements IAdapterFactory {

	public JUnitJavaElementDelegate create(IFile file) {
		if (file != null && new ContentTypeUtil().getContentType(file) == XpectContentType.XPECT) {
			XpectFile xpectFile = XpectUtil.loadFile(file);
			if (xpectFile != null) {
				JUnitJavaElementDelegate result = new JUnitJavaElementDelegate();
				result.setResource(file);
				result.setJavaElement(getTestClassJavaElement(xpectFile));
				result.setDescription(createFileDescription(xpectFile));
				return result;
			}
		}
		return null;
	}

	private XpectInvocation findInvcationAtOffset(XpectFile file, int offset) {
		INode node = NodeModelUtils.findLeafNodeAtOffset(((XtextResource) file.eResource()).getParseResult().getRootNode(), offset);
		if (node != null) {
			EObject obj = node.getSemanticElement();
			if (obj instanceof XpectInvocation)
				return (XpectInvocation) obj;
		}
		return null;
	}

	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if (adaptableObject instanceof JUnitJavaElementDelegate)
			return ((JUnitJavaElementDelegate) adaptableObject).getAdapter(adapterType);
		if (!(JUnitJavaElementDelegate.class.equals(adapterType)))
			return null;

		if (adaptableObject instanceof IFileEditorInput)
			return create(((IFileEditorInput) adaptableObject).getFile());
		if (adaptableObject instanceof IFile)
			return create((IFile) adaptableObject);
		if (adaptableObject instanceof IEditorPart)
			return create((IEditorPart) adaptableObject);
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return new Class[] { JUnitJavaElementDelegate.class };
	}

	private IJavaElement getTestClassJavaElement(XpectFile file) {
		XpectJavaModel javaModel = file.getJavaModel();
		if (javaModel != null) {
			IJavaElementFinder finder = ((XtextResource) file.eResource()).getResourceServiceProvider().get(IJavaElementFinder.class);
			JvmDeclaredType testClass = javaModel.getTestOrSuite().getJvmClass();
			if (testClass != null && !testClass.eIsProxy())
				return finder.findElementFor(testClass);
		}
		return null;
	}

	public JUnitJavaElementDelegate create(IEditorPart editor) {
		IFile file;
		if (editor.getEditorInput() instanceof IFileEditorInput)
			file = ((IFileEditorInput) editor.getEditorInput()).getFile();
		else
			return null;
		if (!(editor instanceof XtextEditor))
			return create(file);
		XtextEditor xtextEditor = (XtextEditor) editor;
		ISelection selection = xtextEditor.getSelectionProvider().getSelection();
		if (!(selection instanceof ITextSelection))
			return create(file);
		final JUnitJavaElementDelegate result = new JUnitJavaElementDelegate();
		result.setResource(file);
		final int offset = ((ITextSelection) selection).getOffset();
		xtextEditor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
			public void process(XtextResource state) throws Exception {
				XpectFile xpectFile = XpectFileAccess.getXpectFile(state);
				XpectInvocation invocation = findInvcationAtOffset(xpectFile, offset);
				result.setJavaElement(getTestClassJavaElement(xpectFile));
				if (invocation != null) {
					result.setDescription(createTestDescription(invocation));
					result.setName(invocation.getId());
				} else {
					result.setDescription(createFileDescription(xpectFile));
				}
			}
		});
		return result;
	}

}
