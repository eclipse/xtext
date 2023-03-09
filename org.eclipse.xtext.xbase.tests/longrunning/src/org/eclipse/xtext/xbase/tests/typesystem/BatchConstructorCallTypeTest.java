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

import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class BatchConstructorCallTypeTest extends AbstractConstructorCallTypeTest {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	public IBatchTypeResolver getTypeResolver() {
		return batchTypeResolver;
	}

	@Override
	public void resolvesConstructorCallsTo(String expression, String... types) throws Exception {
		String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
		List<XConstructorCall> featureCalls = findConstructorCalls(expressionWithQualifiedNames);
		Assert.assertFalse(featureCalls.isEmpty());
		Assert.assertEquals(types.length, featureCalls.size());
		IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(Iterables.getFirst(featureCalls, null));
		IterableExtensions.forEach(featureCalls, (XConstructorCall featureCall, Integer index) -> {
			LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
			Assert.assertEquals("failed for constructor call at " + index, types[index], type.getSimpleName());
		});
	}
}
