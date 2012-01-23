/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * This enhances the Xtext editor with functionality that allows to reveal the originating offsets 
 * for selected java elements. Thus the XbaseEditor is capable to work with {@link IEditorInput input}
 * that points to {@link JavaCore#isJavaLikeFileName(String) java resources}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseEditor extends XtextEditor {

	protected static final String TAG_ASSOCIATED_JAVA_RESOURCE= "javaResourcePath"; //$NON-NLS-1$
	
	@Inject
	private ITraceInformation traceInformation;

	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private IWorkspace workspace;
	
	@Inject
	private LanguageInfo languageInfo;

	private IResource javaResource = null;
	
	private boolean expectJavaSelection = false;
	
	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);
		if (javaResource != null && javaResource.getFullPath() != null) {
			memento.putString(TAG_ASSOCIATED_JAVA_RESOURCE, javaResource.getFullPath().toPortableString());
		}
	}
	
	@Override
	protected void doRestoreState(IMemento memento) {
		super.doRestoreState(memento);
		String pathString = memento.getString(TAG_ASSOCIATED_JAVA_RESOURCE);
		if (pathString != null) {
			IPath path = Path.fromPortableString(pathString);
			IResource foundResource = workspace.getRoot().findMember(path);
			if (foundResource != null && foundResource.exists()) {
				javaResource = foundResource;
			}
		}
	}
	
	@Override
	protected boolean containsSavedState(IMemento memento) {
		boolean result = super.containsSavedState(memento);
		if (!result) {
			return memento.getString(TAG_ASSOCIATED_JAVA_RESOURCE) != null;	
		}
		return result;
	}
	
	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		try {
			// TODO set javaResource to null if input is Xbase file that does not match the Java case (needs reversed trace data)
			IResource resource = ResourceUtil.getResource(input);
			ILocationInResource sourceInformation = traceInformation.getSingleSourceInformation(resource, languageInfo, null);
			if (sourceInformation == null) {
				super.doSetInput(input);
				return;
			}
			IStorage originalStorage = sourceInformation.getStorage();
			if (originalStorage instanceof IFile) {
				super.doSetInput(new FileEditorInput((IFile) originalStorage));
			} else {
				super.doSetInput(new XtextReadonlyEditorInput(originalStorage));
			}
			if (JavaCore.isJavaLikeFileName(resource.getName())) {
				markNextSelectionAsJavaOffset(resource);
			}
		} catch(CoreException e) { 
			// ignore
		}
		super.doSetInput(input);
	}

	public void markNextSelectionAsJavaOffset(IResource javaResource) {
		this.expectJavaSelection = true;
		this.javaResource = javaResource;
	}
	
	@Override
	protected void selectAndReveal(final int selectionStart, final int selectionLength, final int revealStart, final int revealLength) {
		if (expectJavaSelection) {
			// TODO: use trace information for that purpose as soon as it's available
			final ITextRegion[] fixedSelection = new ITextRegion[] { ITextRegion.EMPTY_REGION }; 
			final ITextRegion[] fixedReveal = new ITextRegion[] { ITextRegion.EMPTY_REGION }; 
			getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource resource) throws Exception {
					if (resource != null) {
						IJavaElement root = JavaCore.create(javaResource);
						if (root != null) {
							ICompilationUnit compilationUnit = (ICompilationUnit) root.getAncestor(IJavaElement.COMPILATION_UNIT);
							if (compilationUnit != null) {
								fixedSelection[0] = mergeSelectionOfDerivedMembers(resource, compilationUnit, selectionStart, selectionLength);
								fixedReveal[0] = mergeSelectionOfDerivedMembers(resource, compilationUnit, revealStart, revealLength);
							}		
						}
					}
				}
			});
			expectJavaSelection = false;
			super.selectAndReveal(fixedSelection[0].getOffset(), fixedSelection[0].getLength(), fixedReveal[0].getOffset(), fixedReveal[0].getLength());
		} else {
			super.selectAndReveal(selectionStart, selectionLength, revealStart, revealLength);
		}
	}
	
	private ITextRegion mergeSelectionOfDerivedMembers(XtextResource resource,
			ICompilationUnit compilationUnit, int offset, int length) throws CoreException {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		// TODO improve by using trace information
		IJavaElement[] selectedElements = compilationUnit.codeSelect(offset, length);
		for(IJavaElement javaElement: selectedElements) {
			result = mergeSelectionOfDerivedMember(resource, javaElement, result);
		}
		if (selectedElements.length == 0) {
			IJavaElement elementAtOffset = compilationUnit.getElementAt(offset);
			result = mergeSelectionOfDerivedMember(resource, elementAtOffset, result);
		}
		return result;
	}
	
	@Override
	public void reveal(int offset, int length) {
		/* 
		 * This is only overwritten for documentation purpose.
		 * It is not necessary to fix the offset and length for #reveal since this API is 
		 * private to Xtext and never used from JDT thus the given offset and length are
		 * always relative the our own objects and not relative the the derived java files.
		 */
		super.reveal(offset, length);
	}

	private ITextRegion mergeSelectionOfDerivedMember(XtextResource resource, IJavaElement javaElement,
			ITextRegion current) {
		if (javaElement instanceof IMember) {
			IMember member = (IMember) javaElement;
			URI memberURI = new TypeURIHelper().getFullURI(member);
			String identifier = memberURI.fragment();
			TreeIterator<EObject> contents = EcoreUtil.<EObject>getAllContents(resource, true);
			while(contents.hasNext()) {
				EObject content = contents.next();
				if (content instanceof JvmMember) {
					String identifierFromResource = ((JvmIdentifiableElement) content).getIdentifier();
					if (identifier.equals(identifierFromResource)) {
						EObject sourceElement = associations.getPrimarySourceElement(content);
						return current.merge(locationProvider.getSignificantTextRegion(sourceElement));
					}
				}
			}
		}
		return current;
	}

}
