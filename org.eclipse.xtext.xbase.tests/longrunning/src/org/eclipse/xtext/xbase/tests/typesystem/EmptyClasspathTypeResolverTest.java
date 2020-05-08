/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(EmptyClasspathXbaseInjectorProvider.class)
public class EmptyClasspathTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	@Inject
	private ParseHelper<EObject> parseHelper;

	@Override
	public LightweightTypeReference resolvesTo(String expression, String type) {
		try {
			batchTypeResolver.resolveTypes(parseHelper.parse(expression));
			return null;
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Override
	public void isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
	}
}
