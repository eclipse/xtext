/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide;

import com.google.inject.Binder;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.ide.ExecutorServiceProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

/**
 * Default Guice bindings for the generic IDE features of Xtext.
 */
@SuppressWarnings("all")
public class DefaultIdeModule extends AbstractGenericModule {
  public void configureExecutorService(final Binder binder) {
    binder.<ExecutorService>bind(ExecutorService.class).toProvider(ExecutorServiceProvider.class);
  }
}
