/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplacingAppendableTest extends AbstractXtendUITestCase {

	@Inject 
	private CommonTypeComputationServices services;
	
	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	@Inject
	private Provider<XtextDocument> documentProvider;
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject 
	private WorkbenchTestHelper testHelper;
	
	@Inject 
	private TypesFactory typesFactory; 
	
	@Test public void testImports_0() throws Exception {
		final XtextDocument document = insertListField("package test class Foo {|}", "foo");
		assertEqualsIgnoreWhitespace("package test\n" +
				"\n" +
				"import java.util.List\n" +
				"\n" +
				"class Foo {List<?> foo}", document.get());
	}

	@Test public void testImports_1() throws Exception {
		final XtextDocument document = insertListField(" \n" +
				"\t class Foo {|}", "foo");
		assertEqualsIgnoreWhitespace("import java.util.List\n" +
				"\n" +
				"class Foo {List<?> foo}", document.get());
	}

	@Test public void testImports_2() throws Exception {
		final XtextDocument document = insertListField("class Foo {|}", "foo");
		assertEqualsIgnoreWhitespace("import java.util.List\n" +
				"\n" +
				"class Foo {List<?> foo}", document.get());
	}

	@Test public void testImports_3() throws Exception {
		final XtextDocument document = insertListField("package test\n" +
				"import java.util.Date \n" +
				"\tclass Foo {|}", "foo");
		assertEqualsIgnoreWhitespace("package test\n" +
				"import java.util.Date\n" +
				"import java.util.List\n" +
				"\n" +
				"class Foo {List<?> foo}", document.get());
	}

	@Test public void testImports_4() throws Exception {
		final XtextDocument document = insertListField("package test\n" +
				"/**\n" +
				"*/\n" +
				"\n" + 
				"class Foo {|}", "foo");
		assertEqualsIgnoreWhitespace("package test\n" +
				"\n" +
				"import java.util.List\n" +
				"\n" +
				"/**\n" +
				"*/\n" +
				"\n" +
				"class Foo {List<?> foo}", document.get());
	}
	
	@Test public void testImports_5() throws Exception {
		final XtextDocument document = insertListField("import static java.util.List.* class Foo {|}", "foo");
		assertEqualsIgnoreWhitespace("import static java.util.List.*\n" +
				"import java.util.List\n" +
				"\n" +
				"class Foo {List<?> foo}", document.get());
	}

	@Test public void testImports_10() throws Exception {
		final XtextDocument document = insertListField("package test import java.util.List class Foo {|}", "foo");
		assertEqualsIgnoreWhitespace("package test import java.util.List class Foo {List<?> foo}", document.get());
	}

	protected XtextDocument insertListField(final String model, final String fieldName)
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
				ReplacingAppendable a = appendableFactory.create(document, state, cursorPosition, 1);
				ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, context);
				LightweightTypeReference typeRef = owner.toLightweightTypeReference(services.getTypeReferences().getTypeForName(List.class, context, typesFactory.createJvmWildcardTypeReference()));
				a.append(typeRef);
				a.append(" ").append(fieldName);
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
