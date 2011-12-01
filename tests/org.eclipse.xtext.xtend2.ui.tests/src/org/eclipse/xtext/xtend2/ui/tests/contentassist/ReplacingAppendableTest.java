/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.contentassist;

import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import junit.framework.Test;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xtend2.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplacingAppendableTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(ReplacingAppendableTest.class);
	}
	
	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	@Inject
	private Provider<XtextDocument> documentProvider;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypeReferenceSerializer typeRefSerializer;
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject 
	private WorkbenchTestHelper testHelper;
	
	public void testImports_0() throws Exception {
		final XtextDocument document = insertField("package test class Foo {|}", "foo", List.class);
		assertEqualsIgnoreWhitespace("package test import java.util.List class Foo {List<?> foo}", document.get());
	}

	public void testImports_1() throws Exception {
		final XtextDocument document = insertField("package test import java.util.List class Foo {|}", "foo", List.class);
		assertEqualsIgnoreWhitespace("package test import java.util.List class Foo {List<?> foo}", document.get());
	}

	public void testVarName_0() throws Exception {
		final XtextDocument document = insertField("package test import java.util.List class Foo {String foo |}", "foo", List.class);
		assertEqualsIgnoreWhitespace("package test import java.util.List class Foo {String foo List<?> foo_1}", document.get());
	}

	public void testVarName_1() throws Exception {
		final XtextDocument document = insertField("package test import java.util.List class Foo {String foo_1 def bar(String foo) {|}}", "foo", List.class);
		assertEqualsIgnoreWhitespace("package test import java.util.List class Foo {String foo_1 def bar(String foo) {List<?> foo_2}}", document.get());
	}

	public void testVarName_2() throws Exception {
		final XtextDocument document = insertField("package test import java.util.List class Foo {def bar(String foo) {} def baz() {|}}", "foo", List.class);
		assertEqualsIgnoreWhitespace("package test import java.util.List class Foo {def bar(String foo) {} def baz() {List<?> foo}}", document.get());
	}

	protected XtextDocument insertField(final String model, final String fieldName, final Class<?> fieldType)
			throws Exception {
		final int cursorPosition = model.indexOf('|');
		String actualModel = model.replace("|", " ");
		final XtendFile file = testHelper.xtendFile("Foo", actualModel);
		final XtextDocument document = documentProvider.get();
		document.set(actualModel);
		XtextResource xtextResource = (XtextResource) file.eResource();
		document.setInput(xtextResource);
		final EObject context = eObjectAtOffsetHelper.resolveElementAt(xtextResource, cursorPosition);
		document.modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				ReplacingAppendable a = appendableFactory.get(document, context, cursorPosition, 1, 0, false);
				typeRefSerializer.serialize(typeReferences.getTypeForName(fieldType, context), context, a);
				a.append(" ").append(a.declareVariable(new Object(), fieldName));
				a.commitChanges();
			}
		});
		return document;
	}
	
	protected void assertEqualsIgnoreWhitespace(String s0, String s1) {
		if(!equalsIgnoreWhitespace(s0, s1)) {
			assertEquals(s0,s1);
		}
	}
}
