/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Allows to implement a UI service that overrides a runtime service
 * but still can fall back to it.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class DispatchingProvider<T> implements Provider<T> {

	@Retention(RetentionPolicy.RUNTIME)
	@BindingAnnotation
	public @interface Runtime {
	}

	@Retention(RetentionPolicy.RUNTIME)
	@BindingAnnotation
	public @interface Ui {
	}

	@Inject
	@Runtime
	private T runtimeBinding;

	@Inject(optional = true)
	@Ui
	private T uiBinding;

	public T get() {
		return uiBinding != null ? uiBinding : runtimeBinding;
	}

}
