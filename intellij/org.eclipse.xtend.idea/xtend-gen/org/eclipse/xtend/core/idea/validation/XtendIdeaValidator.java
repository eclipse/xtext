/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.psi.JavaDirectoryService;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiPackage;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendIdeaValidator extends AbstractDeclarativeValidator {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Override
  protected List<EPackage> getEPackages() {
    return Collections.<EPackage>unmodifiableList(CollectionLiterals.<EPackage>newArrayList(TypesPackage.eINSTANCE, XtypePackage.eINSTANCE, XbasePackage.eINSTANCE, XAnnotationsPackage.eINSTANCE, XtendPackage.eINSTANCE));
  }
  
  @Check
  public void checkFileNameConventions(final XtendFile xtendFile) {
    String expectedPackage = this.getExpectedPackageName(xtendFile);
    boolean _equals = Objects.equal(expectedPackage, null);
    if (_equals) {
      return;
    }
    String declaredPackage = xtendFile.getPackage();
    boolean _and = false;
    boolean _isEmpty = expectedPackage.isEmpty();
    if (!_isEmpty) {
      _and = false;
    } else {
      boolean _equals_1 = Objects.equal(declaredPackage, null);
      _and = _equals_1;
    }
    if (_and) {
      return;
    }
    boolean _equals_2 = Objects.equal(expectedPackage, declaredPackage);
    if (_equals_2) {
      return;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The declared package \'");
    String _notNull = Strings.notNull(declaredPackage);
    _builder.append(_notNull, "");
    _builder.append("\' does not match the expected package \'");
    String _notNull_1 = Strings.notNull(expectedPackage);
    _builder.append(_notNull_1, "");
    _builder.append("\'");
    this.error(_builder.toString(), 
      XtendPackage.Literals.XTEND_FILE__PACKAGE, 
      ValidationMessageAcceptor.INSIGNIFICANT_INDEX, 
      IssueCodes.WRONG_PACKAGE, expectedPackage);
  }
  
  protected String getExpectedPackageName(final XtendFile xtendFile) {
    String _xblockexpression = null;
    {
      final PsiElement psiElement = this._iPsiModelAssociations.getPsiElement(xtendFile);
      boolean _equals = Objects.equal(psiElement, null);
      if (_equals) {
        return null;
      }
      @Extension
      final JavaDirectoryService javaDirectoryService = JavaDirectoryService.getInstance();
      PsiFile _containingFile = psiElement.getContainingFile();
      PsiDirectory _parent = _containingFile.getParent();
      PsiPackage _package = javaDirectoryService.getPackage(_parent);
      _xblockexpression = _package.getQualifiedName();
    }
    return _xblockexpression;
  }
}
