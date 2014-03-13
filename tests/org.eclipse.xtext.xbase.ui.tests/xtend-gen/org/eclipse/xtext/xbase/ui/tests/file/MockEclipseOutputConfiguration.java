/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.file;

import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class MockEclipseOutputConfiguration extends EclipseOutputConfigurationProvider {
  private Function1<? super IProject, ? extends Set<OutputConfiguration>> function;
  
  public MockEclipseOutputConfiguration(final Function1<? super IProject, ? extends Set<OutputConfiguration>> function) {
    super(null);
    this.function = function;
  }
  
  public Set<OutputConfiguration> getOutputConfigurations(final IProject project) {
    return this.function.apply(project);
  }
}
