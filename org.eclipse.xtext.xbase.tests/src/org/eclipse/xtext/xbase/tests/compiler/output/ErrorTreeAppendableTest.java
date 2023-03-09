/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler.output;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

public class ErrorTreeAppendableTest extends AbstractXbaseTestCase {
	@Inject
	private ILocationInFileProvider locationProvider;

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Inject
	private ITraceURIConverter converter;

	@Test
	public void testTraceChildIsSelf() throws Exception {
		XExpression e = expression("42");
		ErrorTreeAppendable app = createErrorTreeAppendable(e);
		Assert.assertEquals(app, app.trace(e));
		Assert.assertEquals(app, app.trace(e, true));
		Assert.assertEquals(app, app.trace(e, XbasePackage.Literals.XNUMBER_LITERAL__VALUE, -1));
	}

	@Test
	public void testAppendUnresolvedType() throws Exception {
		XTypeLiteral e = ((XTypeLiteral) expression("typeof(  \tUnresolved\n)"));
		ErrorTreeAppendable app = createErrorTreeAppendable(e);
		app.append(e.getType());
		Assert.assertEquals("Unresolved", app.getContent());
	}

	public ErrorTreeAppendable createErrorTreeAppendable(EObject source) {
		return new TreeAppendable(new ImportManager(true), converter, locationProvider, jvmModelAssociations, source, " ", "<newline>").errorChild();
	}
}
