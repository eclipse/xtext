/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class BatchClosureTypeTest extends AbstractClosureTypeTest {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	public IBatchTypeResolver getTypeResolver() {
		return batchTypeResolver;
	}

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Override
	public List<Object> resolvesClosuresTo(String expression, String... types) throws Exception {
		List<XClosure> closures = findClosures(expression);
		Assert.assertFalse(closures.isEmpty());
		Assert.assertEquals(types.length, closures.size());
		IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(Iterables.getFirst(closures, null));
		List<Object> result = new ArrayList<>();
		IterableExtensions.forEach(closures, (XClosure closure, Integer index) -> {
			LightweightTypeReference closureType = resolvedTypes.getActualType(closure);
			collector.checkSucceeds(() -> {
				Assert.assertTrue("failed for closure at " + index + ": " + closureType, closureType instanceof FunctionTypeReference);
				return null;
			});
			collector.checkSucceeds(() -> {
				Assert.assertEquals("failed for closure at " + index, types[index], closureType.getSimpleName());
				return null;
			});
			result.add(closureType);
		});
		return result;
	}

	@Override
	public void withEquivalents(List<Object> references, String... types) {
		IterableExtensions.forEach(references, (Object reference, Integer index) -> {
			collector.checkSucceeds(() -> {
				Assert.assertTrue(reference instanceof FunctionTypeReference);
				return null;
			});
			collector.checkSucceeds(() -> {
				Assert.assertEquals(types[index], getEquivalent((FunctionTypeReference) reference));
				return null;
			});
		});
	}

	public String getEquivalent(ParameterizedTypeReference type) {
		if (type.getTypeArguments().isEmpty()) {
			return type.getType().getSimpleName();
		}
		return type.getType().getSimpleName() + "<"
				+ type.getTypeArguments().stream().map(it -> it.getSimpleName()).collect(Collectors.joining(", ")) + ">";
	}
}
