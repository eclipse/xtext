package org.eclipse.xtext.xtend2.tests.smoke;

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
  protected List<?> _transform(final EPackage packageDecl) {
    EList<EObject> _eContents = packageDecl.eContents();
    final Function1<EObject,List<?>> _function = new Function1<EObject,List<?>>() {
        public List<?> apply(final EObject e) {
          List<?> _transform = Case_6.this.transform(((EStructuralFeature) e));
          return _transform;
        }
      };
    List<List<?>> _map = ListExtensions.<EObject, List<?>>map(_eContents, _function);
    return _map;
  }
  
  protected List<?> _transform(final EStructuralFeature entity) {
    ArrayList<EObject> _xblockexpression = null;
    {
      final Object inferredType = null;
      ArrayList<EObject> _newArrayList = CollectionLiterals.<EObject>newArrayList(((EObject) inferredType));
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  protected List<?> _transform(final EClass model) {
    EList<ETypeParameter> _eTypeParameters = model.getETypeParameters();
    final Function1<ETypeParameter,List<?>> _function = new Function1<ETypeParameter,List<?>>() {
        public List<?> apply(final ETypeParameter e) {
          List<?> _transform = Case_6.this.transform(e);
          return _transform;
        }
      };
    List<List<?>> _map = ListExtensions.<ETypeParameter, List<?>>map(_eTypeParameters, _function);
    return _map;
  }
  
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
