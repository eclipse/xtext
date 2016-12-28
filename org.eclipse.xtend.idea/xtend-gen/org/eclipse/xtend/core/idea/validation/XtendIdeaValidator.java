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
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.JavaDirectoryService;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiManager;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.macro.XAnnotationExtensions;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.idea.resource.ModuleProvider;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
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
  private XAnnotationExtensions _xAnnotationExtensions;
  
  @Override
  protected List<EPackage> getEPackages() {
    return Collections.<EPackage>unmodifiableList(CollectionLiterals.<EPackage>newArrayList(TypesPackage.eINSTANCE, XtypePackage.eINSTANCE, XbasePackage.eINSTANCE, XAnnotationsPackage.eINSTANCE, XtendPackage.eINSTANCE));
  }
  
  @Check
  public void checkAnnotationInSameModule(final XAnnotation annotation) {
    boolean _isProcessed = this._xAnnotationExtensions.isProcessed(annotation);
    if (_isProcessed) {
      final JvmType annotationType = annotation.getAnnotationType();
      boolean _isSameModule = this.isSameModule(annotation, annotationType);
      if (_isSameModule) {
        this.error(
          "The referenced active annotation cannot be used from within the same module.", 
          XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, 
          (-1), 
          IssueCodes.ACTIVE_ANNOTAION_IN_SAME_CONTAINER);
      }
    }
  }
  
  protected boolean isSameModule(final XAnnotation annotation, final JvmType annotationType) {
    final Computable<Boolean> _function = () -> {
      final Module module = this.getModule(annotation);
      final JavaPsiFacade psiFacade = JavaPsiFacade.getInstance(module.getProject());
      PsiClass _findClass = psiFacade.findClass(annotationType.getQualifiedName(), module.getModuleScope());
      return Boolean.valueOf((_findClass != null));
    };
    return (ApplicationManager.getApplication().<Boolean>runReadAction(_function)).booleanValue();
  }
  
  protected Module getModule(final EObject object) {
    return ModuleProvider.findModule(object.eResource().getResourceSet());
  }
  
  @Check
  public void checkFileNameConventions(final XtendFile xtendFile) {
    String expectedPackage = this.getExpectedPackageName(xtendFile);
    if ((expectedPackage == null)) {
      return;
    }
    String declaredPackage = xtendFile.getPackage();
    if ((expectedPackage.isEmpty() && (declaredPackage == null))) {
      return;
    }
    boolean _equals = Objects.equal(expectedPackage, declaredPackage);
    if (_equals) {
      return;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The declared package \'");
    String _notNull = Strings.notNull(declaredPackage);
    _builder.append(_notNull);
    _builder.append("\' does not match the expected package \'");
    String _notNull_1 = Strings.notNull(expectedPackage);
    _builder.append(_notNull_1);
    _builder.append("\'");
    this.error(_builder.toString(), 
      XtendPackage.Literals.XTEND_FILE__PACKAGE, 
      ValidationMessageAcceptor.INSIGNIFICANT_INDEX, 
      IssueCodes.WRONG_PACKAGE, expectedPackage);
  }
  
  protected String getExpectedPackageName(final XtendFile xtendFile) {
    final Computable<String> _function = () -> {
      final VirtualFile file = VirtualFileURIUtil.getVirtualFile(xtendFile.eResource().getURI());
      final PsiDirectory psiDirectory = PsiManager.getInstance(this.getModule(xtendFile).getProject()).findDirectory(file.getParent());
      final JavaDirectoryService javaDirectoryService = JavaDirectoryService.getInstance();
      return javaDirectoryService.getPackage(psiDirectory).getQualifiedName();
    };
    return ApplicationManager.getApplication().<String>runReadAction(_function);
  }
}
