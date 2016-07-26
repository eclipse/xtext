/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.formatting2;

import java.util.Arrays;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class TestLanguageFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private TestLanguageGrammarAccess _testLanguageGrammarAccess;
  
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    EList<TypeDeclaration> _types = model.getTypes();
    for (final TypeDeclaration type : _types) {
      document.<TypeDeclaration>format(type);
    }
  }
  
  protected void _format(final TypeDeclaration type, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(type);
    TestLanguageGrammarAccess.TypeDeclarationElements _typeDeclarationAccess = this._testLanguageGrammarAccess.getTypeDeclarationAccess();
    Keyword _leftCurlyBracketKeyword_3 = _typeDeclarationAccess.getLeftCurlyBracketKeyword_3();
    ISemanticRegion _keyword = _regionFor.keyword(_leftCurlyBracketKeyword_3);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(type);
    TestLanguageGrammarAccess.TypeDeclarationElements _typeDeclarationAccess_1 = this._testLanguageGrammarAccess.getTypeDeclarationAccess();
    Keyword _rightCurlyBracketKeyword_5 = _typeDeclarationAccess_1.getRightCurlyBracketKeyword_5();
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(_rightCurlyBracketKeyword_5);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    ISemanticRegion _prepend = document.prepend(_keyword_1, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_prepend, _function_2);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(type);
    TestLanguageGrammarAccess.TypeDeclarationElements _typeDeclarationAccess_2 = this._testLanguageGrammarAccess.getTypeDeclarationAccess();
    Keyword _leftCurlyBracketKeyword_3_1 = _typeDeclarationAccess_2.getLeftCurlyBracketKeyword_3();
    ISemanticRegion _keyword_2 = _regionFor_2.keyword(_leftCurlyBracketKeyword_3_1);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(type);
    TestLanguageGrammarAccess.TypeDeclarationElements _typeDeclarationAccess_3 = this._testLanguageGrammarAccess.getTypeDeclarationAccess();
    Keyword _rightCurlyBracketKeyword_5_1 = _typeDeclarationAccess_3.getRightCurlyBracketKeyword_5();
    ISemanticRegion _keyword_3 = _regionFor_3.keyword(_rightCurlyBracketKeyword_5_1);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_keyword_2, _keyword_3, _function_3);
    EList<Property> _properties = type.getProperties();
    for (final Property property : _properties) {
      document.<Property>format(property);
    }
  }
  
  protected void _format(final Property property, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<Property>append(property, _function);
  }
  
  public void format(final Object model, final IFormattableDocument document) {
    if (model instanceof XtextResource) {
      _format((XtextResource)model, document);
      return;
    } else if (model instanceof Model) {
      _format((Model)model, document);
      return;
    } else if (model instanceof Property) {
      _format((Property)model, document);
      return;
    } else if (model instanceof TypeDeclaration) {
      _format((TypeDeclaration)model, document);
      return;
    } else if (model instanceof EObject) {
      _format((EObject)model, document);
      return;
    } else if (model == null) {
      _format((Void)null, document);
      return;
    } else if (model != null) {
      _format(model, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model, document).toString());
    }
  }
}
