/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.entities.ide;

import com.google.inject.Provider;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.web.example.entities.ide.AbstractEntitiesIdeModule;

/**
 * Use this class to register ide components.
 */
@SuppressWarnings("all")
public class EntitiesIdeModule extends AbstractEntitiesIdeModule {
  public EntitiesIdeModule() {
    super();
  }
  
  public EntitiesIdeModule(final Provider<ExecutorService> executorServiceProvider) {
    super(executorServiceProvider);
  }
}
