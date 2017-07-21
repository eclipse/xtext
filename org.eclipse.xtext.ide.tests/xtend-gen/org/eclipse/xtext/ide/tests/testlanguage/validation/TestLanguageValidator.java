/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.validation;

import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.validation.AbstractTestLanguageValidator;
import org.eclipse.xtext.validation.Check;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class TestLanguageValidator extends AbstractTestLanguageValidator {
  public final static String INVALID_NAME = "invalidName";
  
  @Check
  public void checkGreetingStartsWithCapital(final TypeDeclaration type) {
    boolean _isUpperCase = Character.isUpperCase(type.getName().charAt(0));
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.warning("Name should start with a capital", 
        TestLanguagePackage.Literals.TYPE_DECLARATION__NAME, 
        TestLanguageValidator.INVALID_NAME);
    }
  }
}
