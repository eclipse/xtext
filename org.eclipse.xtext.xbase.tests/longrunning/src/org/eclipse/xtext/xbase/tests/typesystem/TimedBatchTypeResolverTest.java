/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.tests.StopwatchRule;
import org.eclipse.xtext.tests.Timed;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
@Ignore
public class TimedBatchTypeResolverTest extends AbstractBatchTypeResolverTest {
	@Rule
	public final StopwatchRule rule = new StopwatchRule(false);

	@Inject
	private TimedBatchTypeResolver typeResolver;

	@Override
	public IBatchTypeResolver getTypeResolver() {
		return typeResolver;
	}

	@Test
	@Timed
	@Override
	public void testFeatureCall_15_n() throws Exception {
		super.testFeatureCall_15_n();
	}

	@Test
	@Timed
	@Override
	public void testFeatureCall_15_n_1() throws Exception {
		super.testFeatureCall_15_n_1();
	}

	@Test
	@Timed
	@Override
	public void testFeatureCall_15_n_2() throws Exception {
		super.testFeatureCall_15_n_2();
	}
}
