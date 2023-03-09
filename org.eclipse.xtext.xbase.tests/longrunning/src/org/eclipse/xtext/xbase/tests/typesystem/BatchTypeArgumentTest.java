/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class BatchTypeArgumentTest extends AbstractTypeArgumentTest {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	public IBatchTypeResolver getTypeResolver() {
		return batchTypeResolver;
	}

	private IResolvedTypes resolvedTypes;

	@Override
	protected void resolveTypes(XExpression expression) {
		this.resolvedTypes = getTypeResolver().resolveTypes(expression);
	}

	@After
	public void discardResolvedTypes() {
		this.resolvedTypes = null;
	}

	@Override
	protected void hasTypeArguments(XExpression expression, String... typeArguments) {
		List<LightweightTypeReference> actualTypeArguments = this.resolvedTypes.getActualTypeArguments(expression);
		Assert.assertEquals(typeArguments.length, actualTypeArguments.size());
		IterableExtensions.forEach(Arrays.asList(typeArguments), (String typeArgument, Integer i) -> {
			String message = Arrays.stream(typeArguments).collect(Collectors.joining(", ")) + " vs "
					+ actualTypeArguments.stream().<String> map(a -> a.getSimpleName()).collect(Collectors.joining(", "));
			Assert.assertEquals(message, typeArgument, actualTypeArguments.get(i).getSimpleName());
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
}
