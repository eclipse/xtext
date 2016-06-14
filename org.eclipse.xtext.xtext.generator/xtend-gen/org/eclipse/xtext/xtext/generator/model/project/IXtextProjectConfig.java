/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model.project;

import java.util.List;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IWebProjectConfig;

/**
 * @noimplement
 */
@SuppressWarnings("all")
public interface IXtextProjectConfig extends IGuiceAwareGeneratorComponent {
  public abstract IRuntimeProjectConfig getRuntime();
  
  public abstract IBundleProjectConfig getRuntimeTest();
  
  public abstract IBundleProjectConfig getGenericIde();
  
  public abstract IBundleProjectConfig getEclipsePlugin();
  
  public abstract IBundleProjectConfig getEclipsePluginTest();
  
  public abstract ISubProjectConfig getIdeaPlugin();
  
  public abstract IWebProjectConfig getWeb();
  
  public abstract List<? extends ISubProjectConfig> getEnabledProjects();
  
  public abstract List<? extends ISubProjectConfig> getTestProjects();
}
