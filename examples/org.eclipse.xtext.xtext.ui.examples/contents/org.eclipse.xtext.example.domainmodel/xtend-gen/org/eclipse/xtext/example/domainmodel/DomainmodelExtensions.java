package org.eclipse.xtext.example.domainmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DomainmodelExtensions {
  private final DomainmodelExtensions _this = this;
  
  public String packageName(final Object o) {
    String switchResult = null;
    final Object o_1 = o;
    boolean matched = false;
    if (!matched) {
      if (o_1 instanceof PackageDeclaration) {
        final PackageDeclaration o_2 = (PackageDeclaration) o_1;
        matched=true;
        final PackageDeclaration typeConverted_o_2 = (PackageDeclaration)o_2;
        EObject _eContainer = typeConverted_o_2.eContainer();
        String _packageName = _this.packageName(_eContainer);
        String _name = o_2.getName();
        String _concatPath = _this.concatPath(_packageName, _name);
        switchResult = _concatPath;
      }
    }
    if (!matched) {
      if (o_1 instanceof EObject) {
        final EObject o_3 = (EObject) o_1;
        matched=true;
        EObject _eContainer_1 = o_3.eContainer();
        String _packageName_1 = _this.packageName(_eContainer_1);
        switchResult = _packageName_1;
      }
    }
    if (!matched) {
      if (o_1 instanceof JvmDeclaredType) {
        final JvmDeclaredType o_4 = (JvmDeclaredType) o_1;
        matched=true;
        String _packageName_2 = o_4.getPackageName();
        switchResult = _packageName_2;
      }
    }
    if (!matched) {
      switchResult = null;
    }
    return switchResult;
  }
  
  public String concatPath(final String prefix, final String suffix) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(prefix);
    if (_isNullOrEmpty) {
      _xifexpression = suffix;
    } else {
      String _operator_plus = StringExtensions.operator_plus(prefix, ".");
      final String typeConverted_suffix = (String)suffix;
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, typeConverted_suffix);
      _xifexpression = _operator_plus_1;
    }
    return _xifexpression;
  }
}