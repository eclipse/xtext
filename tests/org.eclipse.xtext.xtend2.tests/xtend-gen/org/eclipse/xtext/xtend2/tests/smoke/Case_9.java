package org.eclipse.xtext.xtend2.tests.smoke;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Case_9 {
  protected StringConcatenation _generateTypeRef(final ENamedElement c) {
    StringConcatenation _xifexpression = null;
    EObject _eContainer = c.eContainer();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_eContainer, null);
    if (_operator_notEquals) {
      EObject _eContainer_1 = c.eContainer();
      StringConcatenation _generateTypeRef = this.generateTypeRef(_eContainer_1);
      _xifexpression = _generateTypeRef;
    } else {
      StringConcatenation _xifexpression_1 = null;
      boolean _eIsProxy = c.eIsProxy();
      if (_eIsProxy) {
        StringConcatenation _builder = new StringConcatenation();
        String _name = c.getName();
        _builder.append(_name, "");
        _xifexpression_1 = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _xifexpression_1 = _builder_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected StringConcatenation _generateTypeRef(final EObject o) {
    EObject _eContainer = o.eContainer();
    StringConcatenation _generateTypeRef = this.generateTypeRef(_eContainer);
    return _generateTypeRef;
  }
  
  public StringConcatenation generateTypeRef(final EObject c) {
    if (c instanceof ENamedElement) {
      return _generateTypeRef((ENamedElement)c);
    } else {
      return _generateTypeRef(c);
    }
  }
}
