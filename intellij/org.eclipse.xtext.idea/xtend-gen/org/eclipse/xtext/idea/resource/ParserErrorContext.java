package org.eclipse.xtext.idea.resource;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.resource.ErrorContext;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformationContext;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ParserErrorContext extends ErrorContext implements ISyntaxErrorMessageProvider.IParserErrorContext {
  private final /* PsiErrorElement */Object errorElement;
  
  public RecognitionException getRecognitionException() {
    return null;
  }
  
  public String[] getTokenNames() {
    return null;
  }
  
  public String getDefaultMessage() {
    throw new Error("Unresolved compilation problems:"
      + "\nerrorDescription cannot be resolved");
  }
  
  public ParserErrorContext(final PsiToEcoreTransformationContext transformationContext, final PsiErrorElement errorElement) {
    super(transformationContext);
    this.errorElement = errorElement;
  }
}
