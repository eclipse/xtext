/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import java.util.List;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;

@SuppressWarnings("all")
public interface IXtextGeneratorLanguage {
  public abstract Grammar getGrammar();
  
  public abstract List<String> getFileExtensions();
  
  public abstract StandaloneSetupAccess getRuntimeGenSetup();
  
  public abstract GuiceModuleAccess getRuntimeGenModule();
  
  public abstract GuiceModuleAccess getEclipsePluginGenModule();
  
  public abstract GuiceModuleAccess getIdeaGenModule();
  
  public abstract GuiceModuleAccess getWebGenModule();
  
  public abstract ResourceSet getResourceSet();
}
