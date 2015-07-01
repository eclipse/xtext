/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.facet;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author dhuebner - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class XtendGeneratorConfigurationState extends GeneratorConfigurationState {
  private boolean useJavasSourcelevel;
  
  private boolean generateGeneratedAnno;
  
  private boolean generateSuppressWarnAnno;
  
  private boolean ignoreGeneratedJava;
  
  @Pure
  public boolean isUseJavasSourcelevel() {
    return this.useJavasSourcelevel;
  }
  
  public void setUseJavasSourcelevel(final boolean useJavasSourcelevel) {
    this.useJavasSourcelevel = useJavasSourcelevel;
  }
  
  @Pure
  public boolean isGenerateGeneratedAnno() {
    return this.generateGeneratedAnno;
  }
  
  public void setGenerateGeneratedAnno(final boolean generateGeneratedAnno) {
    this.generateGeneratedAnno = generateGeneratedAnno;
  }
  
  @Pure
  public boolean isGenerateSuppressWarnAnno() {
    return this.generateSuppressWarnAnno;
  }
  
  public void setGenerateSuppressWarnAnno(final boolean generateSuppressWarnAnno) {
    this.generateSuppressWarnAnno = generateSuppressWarnAnno;
  }
  
  @Pure
  public boolean isIgnoreGeneratedJava() {
    return this.ignoreGeneratedJava;
  }
  
  public void setIgnoreGeneratedJava(final boolean ignoreGeneratedJava) {
    this.ignoreGeneratedJava = ignoreGeneratedJava;
  }
}
