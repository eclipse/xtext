/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testing.evaluation;

import org.junit.Test;

/**
 * @since 2.36
 */
public abstract class AbstractXbaseEvaluationTestEx extends AbstractXbaseEvaluationTest {
	
	@Test
	@Override
	public void testTryWithoutResources() throws Exception {
		super.testTryWithoutResources();
	}

	@Test
	@Override
	public void testTryWithResources_easy() throws Exception {
		super.testTryWithResources_easy();
	}

	@Test
	@Override
	public void testTryWithResources_lambda() throws Exception {
		super.testTryWithResources_lambda();
	}

	@Test
	@Override
	public void testTryWithResources_2Resources() throws Exception {
		super.testTryWithResources_2Resources();
	}

	@Test
	@Override
	public void testTryWithResources_2NestedResources() throws Exception {
		super.testTryWithResources_2NestedResources();
	}

	@Test
	@Override
	public void testTryWithResources_2DiffResources() throws Exception {
		super.testTryWithResources_2DiffResources();
	}

	@Test
	@Override
	public void testTryWithResources_if1() throws Exception {
		super.testTryWithResources_if1();
	}

	@Test
	@Override
	public void testTryWithResources_if2() throws Exception {
		super.testTryWithResources_if2();
	}

	@Test
	@Override
	public void testTryWithResources_userClass() throws Exception {
		super.testTryWithResources_userClass();
	}

	@Test
	@Override
	public void testTryWithResources_isClosed1() throws Exception {
		super.testTryWithResources_isClosed1();
	}

	@Test
	@Override
	public void testTryWithResources_isClosed2() throws Exception {
		super.testTryWithResources_isClosed2();
	}

	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnConstructor() throws Exception {
		super.testTryWithResources_userClassExceptionOnConstructor();
	}

	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnClose() throws Exception {
		super.testTryWithResources_userClassExceptionOnClose();
	}

	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose1() throws Exception {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose1();
	}

	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose2() throws Exception {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose2();
	}

	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose3() throws Exception {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose3();
	}

	@Test
	@Override
	public void testTryWithResources_finally() throws Exception {
		super.testTryWithResources_finally();
	}

	@Test
	@Override
	public void testTryWithResources_catch() throws Exception {
		super.testTryWithResources_catch();
	}

	@Test
	@Override
	public void testTryWithResources_catchFinally() throws Exception {
		super.testTryWithResources_catchFinally();
	}

	@Test
	@Override
	public void testTryWithResources_ExceptionInBody() throws Exception {
		super.testTryWithResources_ExceptionInBody();
	}

	@Test
	@Override
	public void testTryWithResources_2Resources_ExceptionInBody() throws Exception {
		super.testTryWithResources_2Resources_ExceptionInBody();
	}

	@Test
	@Override
	public void testTryWithResources_2Resources_ExceptionOnClose() throws Exception {
		super.testTryWithResources_2Resources_ExceptionOnClose();
	}

	@Test
	@Override
	public void testTryWithResources_2ResourcesCatch_01() throws Exception {
		super.testTryWithResources_2ResourcesCatch_01();
	}

	@Test
	@Override
	public void testTryWithResources_2ResourcesCatch_02() throws Exception {
		super.testTryWithResources_2ResourcesCatch_02();
	}

	@Test
	@Override
	public void testTernaryIf_1() throws Exception {
		super.testTernaryIf_1();
	}

	@Test
	@Override
	public void testTernaryIf_2() throws Exception {
		super.testTernaryIf_2();
	}

	@Test
	@Override
	public void testTernaryIf_3() throws Exception {
		super.testTernaryIf_3();
	}

	@Test
	@Override
	public void testTernaryIf_4() throws Exception {
		super.testTernaryIf_4();
	}

	@Test
	@Override
	public void testTernaryIf_5() throws Exception {
		super.testTernaryIf_5();
	}

	@Test
	@Override
	public void testTernaryIf_6() throws Exception {
		super.testTernaryIf_6();
	}

	@Test
	@Override
	public void testTernaryIf_7() throws Exception {
		super.testTernaryIf_7();
	}
}
