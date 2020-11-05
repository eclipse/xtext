/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;

import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.validation.ValidationResult;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class ValidationTest extends AbstractWebServerTest {
	protected void assertValidationResult(String resourceContent, String expectedResult) {
		XtextServiceDispatcher.ServiceDescriptor validate = getService(ImmutableMap.<String, String>builder()
				.put("serviceType", "validate").put("fullText", resourceContent).build());
		Assert.assertFalse(validate.isHasSideEffects());
		ValidationResult result = (ValidationResult) validate.getService().apply();
		assertEquals(expectedResult, result.toString());
	}

	@Test
	public void testSyntaxError() {
		assertValidationResult("stat foo end",
				"ValidationResult [\n" +
				"  issues = ArrayList (\n" +
				"    Issue [\n" +
				"      description = \"missing EOF at \'stat\'\"\n" +
				"      severity = \"error\"\n" +
				"      line = 1\n" +
				"      column = 1\n" +
				"      offset = 0\n" +
				"      length = 4\n" +
				"    ]\n" +
				"  )\n]");
	}

	@Test
	public void testCrossRefError() {
		assertValidationResult("state foo set x = true end",
				"ValidationResult [\n" +
				"  issues = ArrayList (\n" +
				"    Issue [\n" +
				"      description = \"Couldn\'t resolve reference to Signal \'x\'.\"\n" +
				"      severity = \"error\"\n" +
				"      line = 1\n" +
				"      column = 15\n" +
				"      offset = 14\n" +
				"      length = 1\n" +
				"    ]\n" +
				"  )\n]");
	}

	@Test
	public void testCustomValidationError() {
		assertValidationResult("input signal x state foo set x = true end",
				"ValidationResult [\n" +
				"  issues = ArrayList (\n" +
				"    Issue [\n" +
				"      description = \"Only output signals are allowed for write access.\"\n" +
				"      severity = \"error\"\n" +
				"      line = 1\n" +
				"      column = 30\n" +
				"      offset = 29\n" +
				"      length = 1\n" +
				"    ]\n" +
				"  )\n]");
	}

	@Test
	public void testValidateFile() {
		File file = createFile("stat foo end");
		XtextServiceDispatcher.ServiceDescriptor validate = getService(ImmutableMap.<String, String>builder()
				.put("serviceType", "validate").put("resource", file.getName()).build());
		Assert.assertFalse(validate.isHasSideEffects());
		ValidationResult result = (ValidationResult) validate.getService().apply();
		String expectedResult = "ValidationResult [\n" +
				"  issues = ArrayList (\n" +
				"    Issue [\n" +
				"      description = \"missing EOF at \'stat\'\"\n" +
				"      severity = \"error\"\n" +
				"      line = 1\n" +
				"      column = 1\n" +
				"      offset = 0\n" +
				"      length = 4\n" +
				"    ]\n" +
				"  )\n]";
		assertEquals(expectedResult, result.toString());
	}

	@Test
	public void testIncorrectStateId() {
		File file = createFile("state foo end");
		XtextServiceDispatcher.ServiceDescriptor validate = this
				.getService(ImmutableMap.<String, String>builder().put("serviceType", "validate")
						.put("resource", file.getName()).put("requiredStateId", "totalerquatsch").build());
		Assert.assertTrue(validate.isHasConflict());
		IServiceResult result = validate.getService().apply();
		MatcherAssert.assertThat(result,
				IsInstanceOf.instanceOf(ServiceConflictResult.class));
		assertEquals(((ServiceConflictResult) result).getConflict(), "invalidStateId");
	}
}
