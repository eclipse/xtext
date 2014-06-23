package org.eclipse.xtend.core.tests.smoke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Synthetic;

@SuppressWarnings("all")
public class Case_6 {
  protected List<?> _transform(final EPackage packageDecl) {
    EList<EObject> _eContents = packageDecl.eContents();
    final Function1<EObject, Object> _function = new Function1<EObject, Object>() {
      public Object apply(final EObject e) {
        return Case_6.this.transform(((EStructuralFeature) e));
      }
    };
    return ListExtensions.<EObject, Object>map(_eContents, _function);
  }
  
  protected List<?> _transform(final EStructuralFeature entity) {
    ArrayList<EObject> _xblockexpression = null;
    {
      final Object inferredType = null;
      _xblockexpression = CollectionLiterals.<EObject>newArrayList(((EObject) ((EObject)inferredType)));
    }
    return _xblockexpression;
  }
  
  protected List<?> _transform(final EClass model) {
    EList<ETypeParameter> _eTypeParameters = model.getETypeParameters();
    final Function1<ETypeParameter, Object> _function = new Function1<ETypeParameter, Object>() {
      public Object apply(final ETypeParameter e) {
        return Case_6.this.transform(e);
      }
    };
    return ListExtensions.<ETypeParameter, Object>map(_eTypeParameters, _function);
  }
  
  @Synthetic
  public List<?> transform(final ENamedElement model) {
    if (model instanceof EClass) {
      return _transform((EClass)model);
    } else if (model instanceof EStructuralFeature) {
      return _transform((EStructuralFeature)model);
    } else if (model instanceof EPackage) {
      return _transform((EPackage)model);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model).toString());
    }
  }
}
