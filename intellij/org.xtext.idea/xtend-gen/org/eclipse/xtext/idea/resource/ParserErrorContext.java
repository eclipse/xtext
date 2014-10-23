package org.eclipse.xtext.idea.resource;

import com.intellij.psi.PsiErrorElement;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.resource.ErrorContext;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformationContext;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ParserErrorContext extends ErrorContext implements ISyntaxErrorMessageProvider.IParserErrorContext {
  private final PsiErrorElement errorElement;
  
  public RecognitionException getRecognitionException() {
    return null;
  }
  
  public String[] getTokenNames() {
    return null;
  }
  
  public String getDefaultMessage() {
    return this.errorElement.getErrorDescription();
  }
  
  public ParserErrorContext(final PsiToEcoreTransformationContext transformationContext, final PsiErrorElement errorElement) {
    super(transformationContext);
    this.errorElement = errorElement;
  }
}
