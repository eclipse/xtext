/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

public class ErrorSafeExtensionsTest extends AbstractXbaseTestCase {
	@Inject
	private ILocationInFileProvider locationProvider;

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Inject
	private ElementIssueProvider.Factory issueProviderFactory;

	@Inject
	private ITraceURIConverter converter;

	@Inject
	private ErrorSafeExtensions errorSafeExtensions;

	@Test
	public void testAppendForEachSafely() throws Exception {
		XBlockExpression e = (XBlockExpression) validatedExpression("{ val x=42 val y=42 }");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
		errorSafeExtensions.forEachSafely(app, e.getExpressions(), getLoopInitializer(), (XExpression it, ITreeAppendable app2) -> {
			app2.append(getText(it));
		});
		Assert.assertEquals("(val x=42:val y=42)", app.getContent());
	}

	@Test
	public void testAppendForEachSafely_0() throws Exception {
		XBlockExpression e = (XBlockExpression) validatedExpression("{ error val x=42 val y=42 }");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertTrue(errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(2)));
		errorSafeExtensions.forEachSafely(app, e.getExpressions(), getLoopInitializer(), (XExpression it, ITreeAppendable app2) -> {
			app2.append(getText(it));
		});
		Assert.assertEquals("(/* error */val x=42:val y=42)", app.getContent());
	}

	@Test
	public void testAppendForEachSafely_1() throws Exception {
		XBlockExpression e = (XBlockExpression) validatedExpression("{ val x=42 error val y=42 }");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
		Assert.assertTrue(errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(2)));
		errorSafeExtensions.forEachSafely(app, e.getExpressions(), getLoopInitializer(), (XExpression it, ITreeAppendable app2) -> {
			app2.append(getText(it));
		});
		Assert.assertEquals("(val x=42/* :error */:val y=42)", app.getContent());
	}

	@Test
	public void testAppendForEachSafely_2() throws Exception {
		XBlockExpression e = (XBlockExpression) validatedExpression("{ val x=42 val y=42 error }");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
		Assert.assertFalse(errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
		Assert.assertTrue(errorSafeExtensions.hasErrors(e.getExpressions().get(2)));
		errorSafeExtensions.forEachSafely(app, e.getExpressions(), getLoopInitializer(), (XExpression it, ITreeAppendable app2) -> {
			app2.append(getText(it));
		});
		Assert.assertEquals("(val x=42:val y=42/* :error */)", app.getContent());
	}

	@Test
	public void testAppendForEachSafely_3() throws Exception {
		XBlockExpression e = (XBlockExpression) validatedExpression("{ error }");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertTrue(errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
		errorSafeExtensions.forEachSafely(app, e.getExpressions(), getLoopInitializer(), (XExpression it, ITreeAppendable app2) -> {
			app2.append(getText(it));
		});
		Assert.assertEquals("/* (error) */", app.getContent());
	}

	@Test
	public void testAppendForEachSafely_4() throws Exception {
		XBlockExpression e = (XBlockExpression) validatedExpression("{ error1 error2 }");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertTrue(errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
		Assert.assertTrue(errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
		errorSafeExtensions.forEachSafely(app, e.getExpressions(), getLoopInitializer(), (XExpression it, ITreeAppendable app2) -> {
			app2.append(getText(it));
		});
		Assert.assertEquals("/* (error1:error2) */", app.getContent());
	}

	@Test
	public void testSerializeSafely() throws Exception {
		XCastedExpression e = (XCastedExpression) validatedExpression("null as Unresolved");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertTrue(errorSafeExtensions.hasErrors(e));
		errorSafeExtensions.serializeSafely(e.getType(), app);
		Assert.assertEquals("/* Unresolved */", app.getContent());
	}

	@Test
	public void testSerializeSafely_1() throws Exception {
		XCastedExpression e = (XCastedExpression) validatedExpression("null as Unresolved");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertTrue(errorSafeExtensions.hasErrors(e));
		errorSafeExtensions.serializeSafely(e.getType(), "Object", app);
		Assert.assertEquals("/* Unresolved */Object", app.getContent());
	}

	@Test
	public void testSerializeSafely_2() throws Exception {
		XCastedExpression e = (XCastedExpression) validatedExpression("null as String");
		TreeAppendable app = createTreeAppendable(e);
		Assert.assertFalse(errorSafeExtensions.hasErrors(e));
		errorSafeExtensions.serializeSafely(e.getType(), app);
		Assert.assertEquals("String", app.getContent());
	}

	protected XExpression validatedExpression(CharSequence model) throws Exception {
		XExpression expression = expression(model, false);
		issueProviderFactory.attachData(expression.eResource());
		return expression;
	}

	protected TreeAppendable createTreeAppendable(EObject source) {
		return new TreeAppendable(new ImportManager(true), converter, locationProvider, jvmModelAssociations, source, " ", "<newline>");
	}

	protected String getText(EObject object) {
		return NodeModelUtils.findActualNodeFor(object).getText().trim();
	}

	protected Procedure1<? super LoopParams> getLoopInitializer() {
		return (LoopParams it) -> {
			it.setPrefix("(");
			it.setSeparator(":");
			it.setSuffix(")");
		};
	}
}
