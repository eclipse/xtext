package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtend.lib.Property;

@SuppressWarnings("all")
public class GeneratorConfig {
  @Property
  private boolean _generateExpressions = true;
  
  @Property
  private boolean _generateSyntheticSuppressWarnings = true;
  
  public boolean isGenerateExpressions() {
    return this._generateExpressions;
  }
  
  public void setGenerateExpressions(final boolean generateExpressions) {
    this._generateExpressions = generateExpressions;
  }
  
  public boolean isGenerateSyntheticSuppressWarnings() {
    return this._generateSyntheticSuppressWarnings;
  }
  
  public void setGenerateSyntheticSuppressWarnings(final boolean generateSyntheticSuppressWarnings) {
    this._generateSyntheticSuppressWarnings = generateSyntheticSuppressWarnings;
  }
}
