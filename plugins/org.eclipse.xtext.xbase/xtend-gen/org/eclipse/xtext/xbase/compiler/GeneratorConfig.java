package org.eclipse.xtext.xbase.compiler;

@SuppressWarnings("all")
public class GeneratorConfig {
  private boolean _generateExpressions = true;
  
  public boolean isGenerateExpressions() {
    return this._generateExpressions;
  }
  
  public void setGenerateExpressions(final boolean generateExpressions) {
    this._generateExpressions = generateExpressions;
  }
  
  private boolean _generateSyntheticSuppressWarnings = true;
  
  public boolean isGenerateSyntheticSuppressWarnings() {
    return this._generateSyntheticSuppressWarnings;
  }
  
  public void setGenerateSyntheticSuppressWarnings(final boolean generateSyntheticSuppressWarnings) {
    this._generateSyntheticSuppressWarnings = generateSyntheticSuppressWarnings;
  }
}
