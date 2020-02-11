/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

public class AbstractComposite<T> {
	
	private List<T> elements = Lists.newArrayList();

	@Inject
	public AbstractComposite(Class<T> clazz, Injector injector) {
		List<Binding<T>> bindingsByType = injector.findBindingsByType(TypeLiteral
				.get(clazz));
		for (Binding<T> binding : bindingsByType) {
			try {
				elements.add(binding.getProvider().get());
			} catch (RuntimeException e) {
				handle(e);
			}
		}
	}

	protected void handle(RuntimeException e) {
		throw e;
	}
	
	protected List<T> getElements() {
		return elements;
	}
}
