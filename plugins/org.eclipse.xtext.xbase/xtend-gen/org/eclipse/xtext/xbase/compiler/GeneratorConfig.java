/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.compiler.JavaVersion;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Holger Schill - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class GeneratorConfig {
  private boolean generateExpressions = true;
  
  private boolean generateSyntheticSuppressWarnings = true;
  
  private JavaVersion targetVersion = JavaVersion.JAVA5;
  
  @Pure
  public boolean isGenerateExpressions() {
    return this.generateExpressions;
  }
  
  public void setGenerateExpressions(final boolean generateExpressions) {
    this.generateExpressions = generateExpressions;
  }
  
  @Pure
  public boolean isGenerateSyntheticSuppressWarnings() {
    return this.generateSyntheticSuppressWarnings;
  }
  
  public void setGenerateSyntheticSuppressWarnings(final boolean generateSyntheticSuppressWarnings) {
    this.generateSyntheticSuppressWarnings = generateSyntheticSuppressWarnings;
  }
  
  @Pure
  public JavaVersion getTargetVersion() {
    return this.targetVersion;
  }
  
  public void setTargetVersion(final JavaVersion targetVersion) {
    this.targetVersion = targetVersion;
  }
}
