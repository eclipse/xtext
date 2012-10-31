/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.registry;

import java.lang.annotation.Annotation;

import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.spi.ConstructorBinding;
import com.google.inject.spi.LinkedKeyBinding;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractDelegatingModule implements Module {

	@Inject
	private Injector original;

	public Injector getOriginal() {
		return original;
	}

	protected <T> void overrideAndBackup(Binder binder, Class<T> key, Class<? extends T> impl) {
		binder.bind(key).to(impl);
		Class<? extends T> original = getOriginalType(Key.get(key));
		if (original != null)
			binder.bind(key).annotatedWith(DefaultBinding.class).to(original);
	}

	protected <T> void overrideAndBackup(Binder binder, Class<T> key, Class<? extends Annotation> annotation, Class<? extends T> impl) {
		binder.bind(key).annotatedWith(annotation).to(impl);
		Class<? extends T> original = getOriginalType(Key.get(key, annotation));
		if (original != null)
			binder.bind(key).annotatedWith(DefaultBinding.class).to(original);
	}

	@SuppressWarnings("unchecked")
	protected <T> Class<? extends T> getOriginalType(Key<T> type) {
		try {
			Binding<T> binding = original.getBinding(type);
			if (binding instanceof LinkedKeyBinding<?>)
				return (Class<? extends T>) ((LinkedKeyBinding<T>) binding).getLinkedKey().getTypeLiteral().getRawType();
			if (binding instanceof ConstructorBinding<?>)
				return (Class<T>) ((ConstructorBinding<T>) binding).getConstructor().getDeclaringType().getRawType();
		} catch (ConfigurationException e) {
		}
		return null;
	}
}
