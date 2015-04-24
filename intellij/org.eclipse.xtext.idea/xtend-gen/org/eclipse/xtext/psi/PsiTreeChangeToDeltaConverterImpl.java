package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription;
import org.eclipse.xtext.psi.PsiTreeChangeToDeltaConverter;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class PsiTreeChangeToDeltaConverterImpl implements PsiTreeChangeToDeltaConverter {
  private final HashMap<URI, IResourceDescription> descriptions = CollectionLiterals.<URI, IResourceDescription>newHashMap();
  
  @Override
  public List<IResourceDescription.Delta> convert(final PsiTreeChangeEventImpl event) {
    List<IResourceDescription.Delta> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(event, null);
      if (_equals) {
        return CollectionLiterals.<IResourceDescription.Delta>emptyList();
      }
      boolean _isGenericChange = event.isGenericChange();
      boolean _not = (!_isGenericChange);
      if (_not) {
        return CollectionLiterals.<IResourceDescription.Delta>emptyList();
      }
      List<IResourceDescription.Delta> _switchResult = null;
      PsiTreeChangeEventImpl.PsiEventType _code = event.getCode();
      if (_code != null) {
        switch (_code) {
          case BEFORE_CHILD_ADDITION:
          case BEFORE_CHILD_REMOVAL:
          case BEFORE_CHILD_REPLACEMENT:
          case BEFORE_CHILD_MOVEMENT:
          case BEFORE_CHILDREN_CHANGE:
          case BEFORE_PROPERTY_CHANGE:
            final PsiFile file = event.getFile();
            if ((file instanceof BaseXtextFile)) {
              final PsiFileBasedResourceDescription description = new PsiFileBasedResourceDescription(((BaseXtextFile)file));
              URI _uRI = description.getURI();
              this.descriptions.put(_uRI, description);
            }
            return CollectionLiterals.<IResourceDescription.Delta>emptyList();
          case CHILD_ADDED:
          case CHILD_REMOVED:
          case CHILD_REPLACED:
          case CHILD_MOVED:
          case CHILDREN_CHANGED:
          case PROPERTY_CHANGED:
            List<IResourceDescription.Delta> _xblockexpression_1 = null;
            {
              final PsiFile file_1 = event.getFile();
              List<IResourceDescription.Delta> _xifexpression = null;
              if ((file_1 instanceof BaseXtextFile)) {
                List<IResourceDescription.Delta> _xblockexpression_2 = null;
                {
                  final PsiFileBasedResourceDescription newDescription = new PsiFileBasedResourceDescription(((BaseXtextFile)file_1));
                  URI _uRI_1 = newDescription.getURI();
                  final IResourceDescription oldDescription = this.descriptions.remove(_uRI_1);
                  XtextResource _resource = ((BaseXtextFile)file_1).getResource();
                  IResourceServiceProvider _resourceServiceProvider = _resource.getResourceServiceProvider();
                  final IResourceDescription.Manager manager = _resourceServiceProvider.getResourceDescriptionManager();
                  IResourceDescription.Delta _createDelta = manager.createDelta(oldDescription, newDescription);
                  _xblockexpression_2 = Collections.<IResourceDescription.Delta>unmodifiableList(CollectionLiterals.<IResourceDescription.Delta>newArrayList(_createDelta));
                }
                _xifexpression = _xblockexpression_2;
              } else {
                _xifexpression = CollectionLiterals.<IResourceDescription.Delta>emptyList();
              }
              _xblockexpression_1 = _xifexpression;
            }
            _switchResult = _xblockexpression_1;
            break;
          default:
            break;
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
