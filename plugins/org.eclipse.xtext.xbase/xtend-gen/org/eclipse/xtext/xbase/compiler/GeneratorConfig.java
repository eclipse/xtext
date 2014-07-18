package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class GeneratorConfig {
  private boolean generateExpressions = true;
  
  private boolean generateSyntheticSuppressWarnings = true;
  
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
}
