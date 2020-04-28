/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.xbase.ui.editor.XbaseResourceForEditorInputFactory;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.Test;

import com.google.inject.Inject;

public class XbaseResourceForEditorInputFactoryTest extends AbstractXbaseUITestCase {
	@Inject
	private XbaseResourceForEditorInputFactory editorInputFactory;

	@Test
	public void testValidationIsDisabled_01() throws Exception {
		IProject project = workspace.getRoot().getProject("simpleProject");
		project.create(null);
		project.open(null);
		IFile file = project.getFile("Hello.xtext");
		InputStream stream = new InputStream() {
			@Override
			public int read() throws IOException {
				return -1;
			}
		};
		file.create(stream, true, null);
		assertTrue(isValidationDisabled(file));
	}

	@Test
	public void testValidationIsDisabled_02() throws Exception {
		IProject project = AbstractXbaseUITestCase.createPluginProject("my.plugin.project");
		IFile file = project.getFile("Hello.xtext");
		InputStream stream = new InputStream() {
			@Override
			public int read() throws IOException {
				return -1;
			}
		};
		file.create(stream, true, null);
		assertFalse(isValidationDisabled(file));
	}

	@Test
	public void testValidationIsDisabled_03() throws Exception {
		IProject project = AbstractXbaseUITestCase.createPluginProject("my.plugin.project");
		IJavaProject jp = JavaCore.create(project);
		boolean wasTested = false;
		for (IPackageFragmentRoot pfr : jp.getAllPackageFragmentRoots()) {
			if (pfr.isArchive()) {
				for (Object o : pfr.getNonJavaResources()) {
					if (o instanceof IStorage) {
						assertTrue(isValidationDisabled((IStorage) o));
						wasTested = true;
					}
				}
			}
		}
		assertTrue(wasTested);
	}

	public boolean isValidationDisabled(IStorage storage) throws Exception {
		Method method = editorInputFactory.getClass().getDeclaredMethod("isValidationDisabled", IStorage.class);
		method.setAccessible(true);
		return (Boolean) method.invoke(editorInputFactory, storage);
	}
}
