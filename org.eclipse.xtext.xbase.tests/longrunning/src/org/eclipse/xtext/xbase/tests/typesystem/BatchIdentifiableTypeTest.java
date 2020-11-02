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

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class BatchIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	public IBatchTypeResolver getTypeResolver() {
		return batchTypeResolver;
	}

	@Override
	public void resolvesIdentifiablesTo(String expression, String... types) throws Exception {
			String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
		XExpression xExpression = expression(expressionWithQualifiedNames, false);
		IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(xExpression);
		List<JvmIdentifiableElement> identifiables = findIdentifiables(xExpression);
		Assert.assertFalse(identifiables.isEmpty());
		Assert.assertEquals(types.length, identifiables.size());
		IterableExtensions.forEach(identifiables, (JvmIdentifiableElement identifiable, Integer index) -> {
			LightweightTypeReference type = resolvedTypes.getActualType(identifiable);
			Assert.assertNotNull(type);
			Assert.assertEquals("failed for identifiable at " + index, types[index], type.getSimpleName());
			});
	}
}
