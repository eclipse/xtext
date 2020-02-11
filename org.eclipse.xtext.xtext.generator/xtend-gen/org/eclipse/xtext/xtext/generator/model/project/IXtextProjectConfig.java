/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.project;

import java.util.List;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IWebProjectConfig;

/**
 * Configuration of the subprojects for one or more Xtext languages. Implemented by {@link XtextProjectConfig}.
 * 
 * @noimplement This interface should not be implemented by clients.
 */
@SuppressWarnings("all")
public interface IXtextProjectConfig extends IGuiceAwareGeneratorComponent {
  IRuntimeProjectConfig getRuntime();
  
  IBundleProjectConfig getRuntimeTest();
  
  IBundleProjectConfig getGenericIde();
  
  IBundleProjectConfig getEclipsePlugin();
  
  IBundleProjectConfig getEclipsePluginTest();
  
  ISubProjectConfig getIdeaPlugin();
  
  IWebProjectConfig getWeb();
  
  List<? extends ISubProjectConfig> getEnabledProjects();
  
  List<? extends ISubProjectConfig> getTestProjects();
}
