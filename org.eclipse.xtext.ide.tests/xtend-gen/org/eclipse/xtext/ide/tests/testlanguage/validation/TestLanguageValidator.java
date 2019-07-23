/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.validation;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Member;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.validation.AbstractTestLanguageValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class TestLanguageValidator extends AbstractTestLanguageValidator {
  public static final String INVALID_NAME = "invalidName";
  
  public static final String UNSORTED_MEMBERS = "unsorted_members";
  
  public static final String MULTILINE_PROBLEM = "multiline_problem";
  
  @Check
  public void checkGreetingStartsWithCapital(final TypeDeclaration type) {
    boolean _isUpperCase = Character.isUpperCase(type.getName().charAt(0));
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.warning("Name should start with a capital", 
        TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME, 
        TestLanguageValidator.INVALID_NAME);
    }
  }
  
  @Check
  public void checkMembersAreSorted(final TypeDeclaration type) {
    final Function1<Member, String> _function = (Member it) -> {
      return it.getName();
    };
    List<Member> _sortBy = IterableExtensions.<Member, String>sortBy(type.getMembers(), _function);
    EList<Member> _members = type.getMembers();
    boolean _notEquals = (!Objects.equal(_sortBy, _members));
    if (_notEquals) {
      this.warning(
        "Members should be in alphabetic order.", 
        TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME, 
        TestLanguageValidator.UNSORTED_MEMBERS);
    }
  }
  
  @Check
  public void checkWithMultilineError(final TypeDeclaration type) {
    boolean _startsWith = type.getName().startsWith("Multiline");
    if (_startsWith) {
      this.warning("Test Validation to mark the whole type", null, TestLanguageValidator.MULTILINE_PROBLEM);
    }
  }
}
