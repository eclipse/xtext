/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.example.entities.idea;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetupGenerated;
import org.eclipse.xtext.idea.example.entities.idea.EntitiesIdeaModule;
import org.eclipse.xtext.util.Modules2;

@SuppressWarnings("all")
public class EntitiesStandaloneSetupIdea extends EntitiesStandaloneSetupGenerated {
  @Override
  public Injector createInjector() {
    final EntitiesRuntimeModule runtimeModule = new EntitiesRuntimeModule();
    final EntitiesIdeaModule ideaModule = new EntitiesIdeaModule();
    final Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
    return Guice.createInjector(mergedModule);
  }
}
