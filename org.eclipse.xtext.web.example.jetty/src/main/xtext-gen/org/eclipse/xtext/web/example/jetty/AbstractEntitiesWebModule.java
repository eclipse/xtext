/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Provider;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.xbase.web.DefaultXbaseWebModule;

/**
 * Manual modifications go to {@link EntitiesWebModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractEntitiesWebModule extends DefaultXbaseWebModule {

	public AbstractEntitiesWebModule() {
		super();
	}

	public AbstractEntitiesWebModule(Provider<ExecutorService> executorServiceProvider) {
		super(executorServiceProvider);
	}
	
}
