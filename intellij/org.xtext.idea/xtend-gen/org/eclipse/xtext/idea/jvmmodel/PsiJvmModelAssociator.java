package org.eclipse.xtext.idea.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.idea.types.psi.impl.JvmPsiClassImpl;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PsiJvmModelAssociator extends JvmModelAssociator {
  @Inject
  @Extension
  private IPsiModelAssociator _iPsiModelAssociator;
  
  @Inject
  @Extension
  private IPsiModelAssociations psiAssociations;
  
  public void associate(final EObject sourceElement, final EObject jvmElement) {
    super.associate(sourceElement, jvmElement);
    final PsiElementProvider psiElementProvider = this.createPsiElementProvider(sourceElement, jvmElement);
    boolean _notEquals = (!Objects.equal(psiElementProvider, null));
    if (_notEquals) {
      this._iPsiModelAssociator.associate(jvmElement, psiElementProvider);
    }
  }
  
  public void associatePrimary(final EObject sourceElement, final EObject jvmElement) {
    super.associatePrimary(sourceElement, jvmElement);
    final PsiElementProvider psiElementProvider = this.createPsiElementProvider(sourceElement, jvmElement);
    boolean _notEquals = (!Objects.equal(psiElementProvider, null));
    if (_notEquals) {
      this._iPsiModelAssociator.associatePrimary(jvmElement, psiElementProvider);
    }
  }
  
  public PsiElementProvider createPsiElementProvider(final EObject sourceElement, final EObject jvmElement) {
    PsiElementProvider _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (jvmElement instanceof JvmDeclaredType) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          public PsiElement get() {
            PsiClass _xifexpression = null;
            JvmDeclaredType _declaringType = ((JvmDeclaredType)jvmElement).getDeclaringType();
            boolean _equals = Objects.equal(_declaringType, null);
            if (_equals) {
              PsiElement _psiElement = PsiJvmModelAssociator.this.psiAssociations.getPsiElement(sourceElement);
              _xifexpression = new JvmPsiClassImpl(((JvmDeclaredType)jvmElement), ((PsiNamedElement) _psiElement));
            } else {
              PsiClass _xblockexpression = null;
              {
                JvmDeclaredType _declaringType_1 = ((JvmDeclaredType)jvmElement).getDeclaringType();
                PsiElement _psiElement_1 = PsiJvmModelAssociator.this.psiAssociations.getPsiElement(_declaringType_1);
                final PsiClass psiClass = ((PsiClass) _psiElement_1);
                boolean _equals_1 = Objects.equal(psiClass, null);
                if (_equals_1) {
                  return null;
                }
                PsiClass[] _innerClasses = psiClass.getInnerClasses();
                final Function1<PsiClass, Boolean> _function = new Function1<PsiClass, Boolean>() {
                  public Boolean apply(final PsiClass it) {
                    Object _userData = it.<Object>getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY);
                    return Boolean.valueOf(Objects.equal(_userData, jvmElement));
                  }
                };
                _xblockexpression = IterableExtensions.<PsiClass>findFirst(((Iterable<PsiClass>)Conversions.doWrapArray(_innerClasses)), _function);
              }
              _xifexpression = _xblockexpression;
            }
            return _xifexpression;
          }
        };
        return _function;
      }
    }
    if (!_matched) {
      if (jvmElement instanceof JvmExecutable) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          public PsiElement get() {
            PsiMethod _xblockexpression = null;
            {
              JvmDeclaredType _declaringType = ((JvmExecutable)jvmElement).getDeclaringType();
              PsiElement _psiElement = PsiJvmModelAssociator.this.psiAssociations.getPsiElement(_declaringType);
              final PsiClass psiClass = ((PsiClass) _psiElement);
              boolean _equals = Objects.equal(psiClass, null);
              if (_equals) {
                return null;
              }
              PsiMethod[] _methods = psiClass.getMethods();
              final Function1<PsiMethod, Boolean> _function = new Function1<PsiMethod, Boolean>() {
                public Boolean apply(final PsiMethod it) {
                  Object _userData = it.<Object>getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY);
                  return Boolean.valueOf(Objects.equal(_userData, jvmElement));
                }
              };
              _xblockexpression = IterableExtensions.<PsiMethod>findFirst(((Iterable<PsiMethod>)Conversions.doWrapArray(_methods)), _function);
            }
            return _xblockexpression;
          }
        };
        _switchResult = _function;
      }
    }
    if (!_matched) {
      if (jvmElement instanceof JvmField) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          public PsiElement get() {
            PsiField _xblockexpression = null;
            {
              JvmDeclaredType _declaringType = ((JvmField)jvmElement).getDeclaringType();
              PsiElement _psiElement = PsiJvmModelAssociator.this.psiAssociations.getPsiElement(_declaringType);
              final PsiClass psiClass = ((PsiClass) _psiElement);
              boolean _equals = Objects.equal(psiClass, null);
              if (_equals) {
                return null;
              }
              PsiField[] _fields = psiClass.getFields();
              final Function1<PsiField, Boolean> _function = new Function1<PsiField, Boolean>() {
                public Boolean apply(final PsiField it) {
                  Object _userData = it.<Object>getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY);
                  return Boolean.valueOf(Objects.equal(_userData, jvmElement));
                }
              };
              _xblockexpression = IterableExtensions.<PsiField>findFirst(((Iterable<PsiField>)Conversions.doWrapArray(_fields)), _function);
            }
            return _xblockexpression;
          }
        };
        _switchResult = _function;
      }
    }
    if (!_matched) {
      if (jvmElement instanceof JvmFormalParameter) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          public PsiElement get() {
            PsiParameter _xblockexpression = null;
            {
              EObject _eContainer = ((JvmFormalParameter)jvmElement).eContainer();
              PsiElement _psiElement = PsiJvmModelAssociator.this.psiAssociations.getPsiElement(_eContainer);
              final PsiMethod psiMethod = ((PsiMethod) _psiElement);
              boolean _equals = Objects.equal(psiMethod, null);
              if (_equals) {
                return null;
              }
              PsiParameterList _parameterList = psiMethod.getParameterList();
              PsiParameter[] _parameters = _parameterList.getParameters();
              final Function1<PsiParameter, Boolean> _function = new Function1<PsiParameter, Boolean>() {
                public Boolean apply(final PsiParameter it) {
                  Object _userData = it.<Object>getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY);
                  return Boolean.valueOf(Objects.equal(_userData, jvmElement));
                }
              };
              _xblockexpression = IterableExtensions.<PsiParameter>findFirst(((Iterable<PsiParameter>)Conversions.doWrapArray(_parameters)), _function);
            }
            return _xblockexpression;
          }
        };
        _switchResult = _function;
      }
    }
    return _switchResult;
  }
}
