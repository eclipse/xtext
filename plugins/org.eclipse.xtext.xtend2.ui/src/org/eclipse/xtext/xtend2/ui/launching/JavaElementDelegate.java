/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.launching;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IParent;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class JavaElementDelegate implements IAdaptable {

	private static final Logger log = Logger.getLogger(JavaElementDelegate.class);

	private IEditorPart editor;
	private IResource resource;
	private IFileEditorInput editorInput;

	@Inject
	private DerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	public void initializeWith(IEditorPart editorInput) {
		this.editor = editorInput;
	}

	public void initializeWith(IFileEditorInput editorInput) {
		this.editorInput = editorInput;
	}

	public void initializeWith(IResource resource) {
		this.resource = resource;
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (IJavaElement.class.equals(adapter)) {
			if (editorInput != null) {
				IFile file = editorInput.getFile();
				if (fileExtensionProvider.isValid(file.getFileExtension())) {
					return getJavaElementForResource(file);
				}
			} else if (editor != null) {
				IJavaElement javaFile = getJavaElementForEditor(editor);
				if (javaFile != null) {
					IJavaElement javaMethod = getJavaElementForXtextEditor(javaFile, editor);
					if (javaMethod != null)
						return javaMethod;
					return javaFile;
				}
			} else if (resource != null) {
				if (fileExtensionProvider.isValid(resource.getFileExtension())) {
					return getJavaElementForResource(resource);
				}
			}
		}
		return null;
	}

	protected XtendFunction findFunction(XtextResource resource, int offset) {
		if (resource.getParseResult() == null)
			return null;
		INode root = resource.getParseResult().getRootNode();
		INode node = NodeModelUtils.findLeafNodeAtOffset(root, offset);
		if (node == null)
			return null;
		INode previousSementic = null, nextSemantic = null;
		NodeIterator backwards = new NodeIterator(node);
		while (backwards.hasPrevious()) {
			INode n = backwards.previous();
			if (n instanceof ILeafNode && !((ILeafNode) n).isHidden()) {
				previousSementic = n;
				break;
			}
		}
		NodeIterator forward = new NodeIterator(node);
		while (forward.hasNext()) {
			INode n = forward.next();
			if (n instanceof ILeafNode && !((ILeafNode) n).isHidden()) {
				nextSemantic = n;
				break;
			}
		}
		if (previousSementic == null || nextSemantic == null)
			return null;
		EObject prevObj = NodeModelUtils.findActualSemanticObjectFor(previousSementic);
		EObject nextObj = NodeModelUtils.findActualSemanticObjectFor(nextSemantic);
		if (prevObj == null || nextObj == null)
			return null;
		XtendFunction prev = EcoreUtil2.getContainerOfType(prevObj, XtendFunction.class);
		XtendFunction next = EcoreUtil2.getContainerOfType(nextObj, XtendFunction.class);
		if (prev != null && prev == next)
			return prev;
		return null;
	}

	protected IJavaElement getJavaElementForXtextEditor(IJavaElement javaFile, IEditorPart editor) {
		if (!(editor instanceof XtextEditor))
			return null;
		XtextEditor xtextEditor = (XtextEditor) editor;
		ISelection selection = xtextEditor.getSelectionProvider().getSelection();
		if (!(selection instanceof ITextSelection))
			return null;
		final int offset = ((ITextSelection) selection).getOffset();
		XtendFunction func = xtextEditor.getDocument().readOnly(new IUnitOfWork<XtendFunction, XtextResource>() {
			public XtendFunction exec(XtextResource state) throws Exception {
				return findFunction(state, offset);
			}
		});
		if (func == null || Strings.isEmpty(func.getName()))
			return null;
		if (!(javaFile instanceof IParent))
			return null;
		try {
			for (IJavaElement child : ((IParent) javaFile).getChildren())
				if (child instanceof IType) {
					IType type = (IType) child;
					IMethod method = type.getMethod(func.getName(), new String[0]);
					if (method != null)
						return method;
				}
		} catch (JavaModelException e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
		}
		return null;
	}

	protected IJavaElement getJavaElementForEditor(IEditorPart editor) {
		if (editor.getEditorInput() instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) editor.getEditorInput()).getFile();
			if (fileExtensionProvider.isValid(file.getFileExtension())) {
				return getJavaElementForResource(file);
			}
		}
		return null;
	}

	protected IJavaElement getJavaElementForResource(IResource resource) {
		try {
			final String getSourcePath = URI.createPlatformResourceURI(resource.getFullPath().toString(), true).toString();
			List<IFile> resources = derivedResourceMarkers.findDerivedResources(resource.getProject(), getSourcePath);
			if (resources.size() >= 1)
				return JavaCore.create(resources.get(0));
		} catch (CoreException e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
		}
		return null;
	}

}
