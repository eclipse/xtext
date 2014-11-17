package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.intellij.lang.Language;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.PsiModificationTrackerImpl;
import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.impl.PsiTreeChangePreprocessor;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class BaseXtextCodeBlockModificationListener implements PsiTreeChangePreprocessor {
  @Accessors(AccessorType.PROTECTED_GETTER)
  private final IXtextLanguage language;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private final PsiModificationTrackerImpl psiModificationTracker;
  
  public BaseXtextCodeBlockModificationListener(final IXtextLanguage language, final PsiModificationTracker psiModificationTracker) {
    this.language = language;
    language.injectMembers(this);
    this.psiModificationTracker = ((PsiModificationTrackerImpl) psiModificationTracker);
  }
  
  public void treeChanged(final PsiTreeChangeEventImpl event) {
    boolean _and = false;
    PsiFile _file = event.getFile();
    Language _language = null;
    if (_file!=null) {
      _language=_file.getLanguage();
    }
    boolean _equals = Objects.equal(_language, this.language);
    if (!_equals) {
      _and = false;
    } else {
      boolean _hasStructuralChanges = this.hasStructuralChanges(event);
      _and = _hasStructuralChanges;
    }
    if (_and) {
      boolean _hasJavaStructuralChanges = this.hasJavaStructuralChanges(event);
      if (_hasJavaStructuralChanges) {
        this.psiModificationTracker.incCounter();
      } else {
        this.psiModificationTracker.incOutOfCodeBlockModificationCounter();
      }
    }
  }
  
  protected boolean hasStructuralChanges(final PsiTreeChangeEventImpl it) {
    boolean _switchResult = false;
    PsiTreeChangeEventImpl.PsiEventType _code = it.getCode();
    if (_code != null) {
      switch (_code) {
        case CHILD_ADDED:
        case CHILD_REMOVED:
        case CHILD_REPLACED:
        case CHILD_MOVED:
        case CHILDREN_CHANGED:
        case PROPERTY_CHANGED:
          _switchResult = it.isGenericChange();
          break;
        default:
          _switchResult = false;
          break;
      }
    } else {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  protected boolean hasJavaStructuralChanges(final PsiTreeChangeEventImpl event) {
    return false;
  }
  
  @Pure
  protected IXtextLanguage getLanguage() {
    return this.language;
  }
  
  @Pure
  protected PsiModificationTrackerImpl getPsiModificationTracker() {
    return this.psiModificationTracker;
  }
}
