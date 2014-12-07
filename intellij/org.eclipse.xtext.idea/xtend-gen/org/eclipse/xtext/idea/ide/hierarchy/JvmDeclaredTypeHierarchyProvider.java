package org.eclipse.xtext.idea.ide.hierarchy;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.codeInsight.TargetElementUtilBase;
import com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.idea.actionSystem.DataContextExtensions;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class JvmDeclaredTypeHierarchyProvider extends JavaTypeHierarchyProvider {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  public PsiElement getTarget(@NotNull final DataContext dataContext) {
    PsiClass _xblockexpression = null;
    {
      final Project project = DataContextExtensions.getProject(dataContext);
      boolean _equals = Objects.equal(project, null);
      if (_equals) {
        return null;
      }
      final Editor editor = DataContextExtensions.getEditor(dataContext);
      boolean _equals_1 = Objects.equal(editor, null);
      if (_equals_1) {
        PsiElement _psiElement = DataContextExtensions.getPsiElement(dataContext);
        return this.getPsiClass(_psiElement);
      }
      final PsiFile file = this.getPsiFile(project, editor);
      boolean _equals_2 = Objects.equal(file, null);
      if (_equals_2) {
        return null;
      }
      PsiElement _targetElement = this.getTargetElement(editor);
      final PsiClass psiClass = this.getPsiClass(_targetElement);
      boolean _notEquals = (!Objects.equal(psiClass, null));
      if (_notEquals) {
        return psiClass;
      }
      CaretModel _caretModel = editor.getCaretModel();
      final int offset = _caretModel.getOffset();
      PsiElement _findElementAt = file.findElementAt(offset);
      _xblockexpression = this.findPsiClass(_findElementAt);
    }
    return _xblockexpression;
  }
  
  public PsiElement getTargetElement(final Editor editor) {
    return TargetElementUtilBase.findTargetElement(editor, 
      ((TargetElementUtilBase.ELEMENT_NAME_ACCEPTED | TargetElementUtilBase.REFERENCED_ELEMENT_ACCEPTED) | TargetElementUtilBase.LOOKUP_ITEM_ACCEPTED));
  }
  
  protected PsiFile getPsiFile(final Project project, final Editor editor) {
    PsiDocumentManager _instance = PsiDocumentManager.getInstance(project);
    Document _document = editor.getDocument();
    return _instance.getPsiFile(_document);
  }
  
  protected PsiClass _findPsiClass(final BaseXtextFile element) {
    Resource _resource = element.getResource();
    EList<EObject> _contents = _resource.getContents();
    return this.getPsiClass(_contents);
  }
  
  protected PsiClass _findPsiClass(final PsiElement element) {
    PsiClass _xblockexpression = null;
    {
      final PsiClass psiClass = this.getPsiClass(element);
      boolean _notEquals = (!Objects.equal(psiClass, null));
      if (_notEquals) {
        return psiClass;
      }
      PsiElement _parent = element.getParent();
      _xblockexpression = this.findPsiClass(_parent);
    }
    return _xblockexpression;
  }
  
  protected PsiClass _findPsiClass(final Void element) {
    return null;
  }
  
  protected PsiClass getPsiClass(final PsiElement element) {
    PsiClass _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof PsiClass) {
        _matched=true;
        _switchResult = ((PsiClass)element);
      }
    }
    if (!_matched) {
      if (element instanceof PsiEObject) {
        _matched=true;
        PsiClass _xblockexpression = null;
        {
          final EObject eObject = ((PsiEObject)element).getEObject();
          PsiClass _xifexpression = null;
          boolean _equals = Objects.equal(eObject, null);
          if (_equals) {
            _xifexpression = null;
          } else {
            Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(eObject);
            _xifexpression = this.getPsiClass(_jvmElements);
          }
          _xblockexpression = _xifexpression;
        }
        _switchResult = _xblockexpression;
      }
    }
    return _switchResult;
  }
  
  protected PsiClass getPsiClass(final Collection<EObject> objects) {
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(objects, JvmDeclaredType.class);
    final JvmDeclaredType jvmType = IterableExtensions.<JvmDeclaredType>head(_filter);
    boolean _equals = Objects.equal(jvmType, null);
    if (_equals) {
      return null;
    }
    final PsiElement psiElement = this._iPsiModelAssociations.getPsiElement(jvmType);
    if ((psiElement instanceof PsiClass)) {
      return ((PsiClass)psiElement);
    }
    return null;
  }
  
  protected PsiClass findPsiClass(final PsiElement element) {
    if (element instanceof BaseXtextFile) {
      return _findPsiClass((BaseXtextFile)element);
    } else if (element != null) {
      return _findPsiClass(element);
    } else if (element == null) {
      return _findPsiClass((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
