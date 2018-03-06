/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model.project;

import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

/**
 * Configuration of subprojects.
 * 
 * @noimplement This interface should not be implemented by clients.
 */
@SuppressWarnings("all")
public interface ISubProjectConfig extends IGuiceAwareGeneratorComponent {
  public abstract boolean isEnabled();
  
  public abstract String getName();
  
  public abstract IXtextGeneratorFileSystemAccess getRoot();
  
  public abstract IXtextGeneratorFileSystemAccess getMetaInf();
  
  public abstract IXtextGeneratorFileSystemAccess getSrc();
  
  public abstract IXtextGeneratorFileSystemAccess getSrcGen();
  
  public abstract IXtextGeneratorFileSystemAccess getIcons();
}
