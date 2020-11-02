/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class BatchFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	public IBatchTypeResolver getTypeResolver() {
		return batchTypeResolver;
	}

	@Override
	public void resolvesFeatureCallsTo(String expression, String... types) throws Exception {
		String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
		List<XAbstractFeatureCall> featureCalls = findFeatureCalls(expressionWithQualifiedNames);
		IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(Iterables.getFirst(featureCalls, null));
		Iterable<XAbstractFeatureCall> actualFeatureCalls = filterTypeLiteralsAndPackageFragments(featureCalls);
		Assert.assertFalse(Iterables.isEmpty(actualFeatureCalls));
		Assert.assertEquals("" + actualFeatureCalls, types.length, Iterables.size(actualFeatureCalls));
		IterableExtensions.forEach(actualFeatureCalls, (XAbstractFeatureCall featureCall, Integer index) -> {
			LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
			Assert.assertEquals(("failed for feature call at " + index), types[index], type.getSimpleName());
		});
	}

	@Test
	@Ignore("TODO Fix me")
	@Override
	public void testRawType_01() throws Exception {
		super.testRawType_01();
	}

	@Test
	@Ignore("TODO Fix me")
	@Override
	public void testRawType_02() throws Exception {
		super.testRawType_02();
	}

	@Test
	@Ignore("TODO Fix me")
	@Override
	public void testRawType_05() throws Exception {
		super.testRawType_05();
	}

	@Test
	@Ignore("TODO This should work")
	@Override
	public void testBug_391758() throws Exception {
		super.testBug_391758();
	}

	@Test
	@Ignore("TODO Fix me")
	@Override
	public void testArray_09() throws Exception {
		super.testArray_09();
	}
}
