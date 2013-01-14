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
  
  private boolean _generateSuppressWarnings = true;
  
  public boolean isGenerateSuppressWarnings() {
    return this._generateSuppressWarnings;
  }
  
  public void setGenerateSuppressWarnings(final boolean generateSuppressWarnings) {
    this._generateSuppressWarnings = generateSuppressWarnings;
  }
}
