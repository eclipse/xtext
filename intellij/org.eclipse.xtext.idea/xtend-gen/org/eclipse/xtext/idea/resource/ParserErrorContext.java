/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
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
  
  @Override
  public RecognitionException getRecognitionException() {
    return null;
  }
  
  @Override
  public String[] getTokenNames() {
    return null;
  }
  
  @Override
  public String getDefaultMessage() {
    return this.errorElement.getErrorDescription();
  }
  
  public ParserErrorContext(final PsiToEcoreTransformationContext transformationContext, final PsiErrorElement errorElement) {
    super(transformationContext);
    this.errorElement = errorElement;
  }
}
