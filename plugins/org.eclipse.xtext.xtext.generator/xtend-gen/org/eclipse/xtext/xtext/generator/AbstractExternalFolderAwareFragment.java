/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

/**
 * Generator fragment that allows to write files to arbitrary, user configurable
 * locations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractExternalFolderAwareFragment extends AbstractXtextGeneratorFragment {
  private String absolutePath;
  
  @Accessors({ AccessorType.PROTECTED_GETTER, AccessorType.PUBLIC_SETTER })
  private boolean override = false;
  
  private IXtextGeneratorFileSystemAccess outputLocation;
  
  protected IXtextGeneratorFileSystemAccess getOutputLocation() {
    return this.outputLocation;
  }
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    XtextGeneratorFileSystemAccess _xtextGeneratorFileSystemAccess = new XtextGeneratorFileSystemAccess(this.absolutePath, this.override);
    this.outputLocation = _xtextGeneratorFileSystemAccess;
    injector.injectMembers(this.outputLocation);
  }
  
  protected String getAbsolutePath() {
    return this.absolutePath;
  }
  
  @Mandatory
  public void setAbsolutePath(final String absolutePath) {
    this.absolutePath = absolutePath;
  }
  
  @Pure
  protected boolean isOverride() {
    return this.override;
  }
  
  public void setOverride(final boolean override) {
    this.override = override;
  }
}
