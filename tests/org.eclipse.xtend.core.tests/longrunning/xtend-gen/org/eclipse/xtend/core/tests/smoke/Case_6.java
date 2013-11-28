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

@SuppressWarnings("all")
public class Case_6 {
  protected List<? extends Object> _transform(final EPackage packageDecl) {
    EList<EObject> _eContents = packageDecl.eContents();
    final Function1<EObject,Object> _function = new Function1<EObject,Object>() {
      public Object apply(final EObject e) {
        Object _transform = Case_6.this.transform(((EStructuralFeature) e));
        return _transform;
      }
    };
    List<Object> _map = ListExtensions.<EObject, Object>map(_eContents, _function);
    return _map;
  }
  
  protected List<? extends Object> _transform(final EStructuralFeature entity) {
    ArrayList<EObject> _xblockexpression = null;
    {
      final List<? extends Object> inferredType = null;
      ArrayList<EObject> _newArrayList = CollectionLiterals.<EObject>newArrayList(((EObject) inferredType));
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  protected List<? extends Object> _transform(final EClass model) {
    EList<ETypeParameter> _eTypeParameters = model.getETypeParameters();
    final Function1<ETypeParameter,Object> _function = new Function1<ETypeParameter,Object>() {
      public Object apply(final ETypeParameter e) {
        Object _transform = Case_6.this.transform(e);
        return _transform;
      }
    };
    List<Object> _map = ListExtensions.<ETypeParameter, Object>map(_eTypeParameters, _function);
    return _map;
  }
  
  public Object transform(final ENamedElement model) {
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
