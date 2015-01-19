package org.eclipse.xtext.xbase.idea.ide.hierarchy;

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
import com.intellij.psi.PsiMember;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.actionSystem.DataContextExtensions;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class JvmDeclaredTypeHierarchyProvider extends JavaTypeHierarchyProvider {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  @Inject
  @Extension
  private IPsiLogicalContainerProvider _iPsiLogicalContainerProvider;
  
  @Override
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
    final Function1<EObject, PsiElement> _function = new Function1<EObject, PsiElement>() {
      @Override
      public PsiElement apply(final EObject it) {
        return JvmDeclaredTypeHierarchyProvider.this._iPsiModelAssociations.getPsiElement(it);
      }
    };
    List<PsiElement> _map = ListExtensions.<EObject, PsiElement>map(_contents, _function);
    Iterable<PsiClass> _filter = Iterables.<PsiClass>filter(_map, PsiClass.class);
    return IterableExtensions.<PsiClass>head(_filter);
  }
  
  protected PsiClass _findPsiClass(final PsiElement element) {
    PsiClass _switchResult = null;
    PsiElement _nearestLogicalContainer = this._iPsiLogicalContainerProvider.getNearestLogicalContainer(element);
    final PsiElement container = _nearestLogicalContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof PsiClass) {
        _matched=true;
        _switchResult = ((PsiClass)container);
      }
    }
    if (!_matched) {
      if (container instanceof PsiMember) {
        _matched=true;
        _switchResult = ((PsiMember)container).getContainingClass();
      }
    }
    if (!_matched) {
      PsiClass _elvis = null;
      PsiClass _psiClass = this.getPsiClass(element);
      if (_psiClass != null) {
        _elvis = _psiClass;
      } else {
        PsiElement _parent = element.getParent();
        PsiClass _findPsiClass = this.findPsiClass(_parent);
        _elvis = _findPsiClass;
      }
      _switchResult = _elvis;
    }
    return _switchResult;
  }
  
  protected PsiClass _findPsiClass(final Void element) {
    return null;
  }
  
  protected PsiClass getPsiClass(final PsiElement element) {
    Set<PsiElement> _jvmElements = this._iPsiJvmModelAssociations.getJvmElements(element);
    Iterable<PsiClass> _filter = Iterables.<PsiClass>filter(_jvmElements, PsiClass.class);
    return IterableExtensions.<PsiClass>head(_filter);
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
