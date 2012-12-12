/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.CompletionContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.JavaModelStatus;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.4
 */
public class XtendJavaDocContentAssistInvocationContext extends JavaContentAssistInvocationContext {

	protected int offset;
	protected IEditorPart editor;

	public XtendJavaDocContentAssistInvocationContext(ITextViewer viewer, int offset, IEditorPart editor) {
		super(viewer, offset, editor);
		this.offset = offset;
		this.editor = editor;
	}

	ICompilationUnit unit = null;

	@Override
	public ICompilationUnit getCompilationUnit() {
		try {
			final PackageFragment packageFragment = (PackageFragment) getJavaProject().getPackageFragments()[0];
			CompilationUnit compilationUnit = new CompilationUnit(packageFragment, "Xtend", new WorkingCopyOwner() {
			}) {
				@Override
				protected IStatus validateExistence(IResource underlyingResource) {
					return JavaModelStatus.VERIFIED_OK;
				}

				@Override
				public IImportDeclaration[] getImports() throws JavaModelException {
					List<IImportDeclaration> result = Lists.newArrayList();
					List<String> importStrings = getImportStrings();
					for (final String importString : importStrings) {
						result.add(new FakedImportDeclaration(importString));
					}
					return result.toArray(new IImportDeclaration[result.size()]);
				}
			};
			compilationUnit.getBuffer().append(getCodeInFrontIncludingJavaDoc() + "class Xtend {}");
			return compilationUnit;

		} catch (Exception e) {
			return null;
		}
	}

	protected String getCodeInFrontIncludingJavaDoc() throws BadLocationException {
		XtextDocument document = (XtextDocument) getDocument();
		ITypedRegion partition = document.getPartition(offset);
		final int partitionOffset = partition.getOffset();
		int length = partition.getLength();
		return document.get(0, partitionOffset + length);
	}

	protected List<String> getImportStrings() {
		XtextDocument document = (XtextDocument) getDocument();
		return document.readOnly(new IUnitOfWork<List<String>, XtextResource>() {
			public List<String> exec(XtextResource state) throws Exception {
				XtendFile xtendFile = (XtendFile) state.getContents().get(0);
				EList<XtendImport> xtendImports = xtendFile.getImports();
				List<String> imports = Lists.newArrayList();
				for (XtendImport imp : xtendImports) {
					imports.add(imp.getImportedNamespace() != null ? imp.getImportedNamespace() : imp
							.getImportedTypeName());
				}
				return imports;
			}
		});
	}

	private IJavaProject getJavaProject() {
		return EditorUtility.getJavaProject(editor.getEditorInput());
	}
}
