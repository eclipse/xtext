/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.builder.nature.XtextNature;
import org.eclipse.xtext.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.workbench.AbstractWorkbenchTest;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

/**
 * @author koehnlein - Initial contribution and API
 */
public class AbstractQuickfixTest extends AbstractWorkbenchTest {

	protected XtextEditor newXtextEditor(String projectName, String modelFile, String model) throws CoreException, PartInitException {
		IJavaProject javaProject = JavaProjectSetupUtil.createJavaProject(projectName);
		IFile file = javaProject.getProject().getFile(modelFile);
		if (file.exists()) {
			file.delete(true, null);
		}
		file.create(new StringInputStream(model), true, null);
		file.refreshLocal(IResource.DEPTH_ONE, null);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		xtextEditor.getDocument().set(model);
		return xtextEditor;
	}

	protected Injector getInjector() {
		return Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.quickfix.QuickfixCrossrefTestLanguage");
	}

	protected List<Issue> getIssues(IXtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}
		});
	}
}
