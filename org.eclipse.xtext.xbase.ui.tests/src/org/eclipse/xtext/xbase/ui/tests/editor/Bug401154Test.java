/*******************************************************************************
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug401154Test extends AbstractXbaseContentAssistBugTest {

	@Test
	public void testImplicitReceiver() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	CharSequence: "
		// @formatter:on
		).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
	}

	@Test
	public void testLocalSwitchVariable() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	CharSequence: "
		// @formatter:on
		).assertProposal("it").withDisplayString("it");
	}

	@Test
	public void testLocalSwitchVariableInpublicault() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	publicault: "
		// @formatter:on
		).assertProposal("it").withDisplayString("it");
	}

	@Test
	public void testImplicitReceiverInEmptyBlock() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	CharSequence: {"
		// @formatter:on
		).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
	}

	@Test
	public void testImplicitReceiverInBlock() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	CharSequence: { length "
		// @formatter:on
		).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
	}

	@Test
	public void testNestedSwitchWithImplicitReceiverInBlock_01() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	CharSequence: switch it {\n" +
			"		Appendable: { appe"
		// @formatter:on
		).assertProposal("append()");
	}

	@Test
	public void testNestedSwitchWithImplicitReceiverInBlock_02() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	CharSequence: switch it {\n" +
			"		Appendable: { "
		// @formatter:on
		).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
	}

	@Test
	public void testExplicitReceiver() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new Object {\n" +
			"	CharSequence: it."
		// @formatter:on
		).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
	}

	@Test
	public void testKnownTypeIsSupertype() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new StringBuilder {\n" +
			"	CharSequence: "
		// @formatter:on
		).assertProposal("charAt()").withDisplayString("charAt(int index) : char - AbstractStringBuilder");
	}

	@Test
	public void testKnownTypeIsSupertype_02() throws Exception {
		newBuilder().append(
		// @formatter:off
			"switch it: new StringBuilder {\n" +
			"	CharSequence: it."
		// @formatter:on
		).assertProposal("charAt()").withDisplayString("charAt(int index) : char - AbstractStringBuilder");
	}
}