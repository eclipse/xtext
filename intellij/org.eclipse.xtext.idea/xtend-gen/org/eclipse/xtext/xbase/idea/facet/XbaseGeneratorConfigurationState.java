/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.facet;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class XbaseGeneratorConfigurationState extends GeneratorConfigurationState {
  private String targetJavaVersion;
  
  private boolean generateSuppressWarnings;
  
  private boolean generateGeneratedAnnotation;
  
  private boolean includeDateInGenerated;
  
  private String generatedAnnotationComment;
  
  private boolean installDslAsPrimarySource;
  
  private boolean hideLocalSyntheticVariables;
  
  public XbaseGeneratorConfigurationState() {
  }
  
  public XbaseGeneratorConfigurationState(final OutputConfiguration defOutput) {
    super(defOutput);
    this.generateSuppressWarnings = true;
    this.hideLocalSyntheticVariables = true;
    this.setDeleteGenerated(true);
  }
  
  @Pure
  public String getTargetJavaVersion() {
    return this.targetJavaVersion;
  }
  
  public void setTargetJavaVersion(final String targetJavaVersion) {
    this.targetJavaVersion = targetJavaVersion;
  }
  
  @Pure
  public boolean isGenerateSuppressWarnings() {
    return this.generateSuppressWarnings;
  }
  
  public void setGenerateSuppressWarnings(final boolean generateSuppressWarnings) {
    this.generateSuppressWarnings = generateSuppressWarnings;
  }
  
  @Pure
  public boolean isGenerateGeneratedAnnotation() {
    return this.generateGeneratedAnnotation;
  }
  
  public void setGenerateGeneratedAnnotation(final boolean generateGeneratedAnnotation) {
    this.generateGeneratedAnnotation = generateGeneratedAnnotation;
  }
  
  @Pure
  public boolean isIncludeDateInGenerated() {
    return this.includeDateInGenerated;
  }
  
  public void setIncludeDateInGenerated(final boolean includeDateInGenerated) {
    this.includeDateInGenerated = includeDateInGenerated;
  }
  
  @Pure
  public String getGeneratedAnnotationComment() {
    return this.generatedAnnotationComment;
  }
  
  public void setGeneratedAnnotationComment(final String generatedAnnotationComment) {
    this.generatedAnnotationComment = generatedAnnotationComment;
  }
  
  @Pure
  public boolean isInstallDslAsPrimarySource() {
    return this.installDslAsPrimarySource;
  }
  
  public void setInstallDslAsPrimarySource(final boolean installDslAsPrimarySource) {
    this.installDslAsPrimarySource = installDslAsPrimarySource;
  }
  
  @Pure
  public boolean isHideLocalSyntheticVariables() {
    return this.hideLocalSyntheticVariables;
  }
  
  public void setHideLocalSyntheticVariables(final boolean hideLocalSyntheticVariables) {
    this.hideLocalSyntheticVariables = hideLocalSyntheticVariables;
  }
}
