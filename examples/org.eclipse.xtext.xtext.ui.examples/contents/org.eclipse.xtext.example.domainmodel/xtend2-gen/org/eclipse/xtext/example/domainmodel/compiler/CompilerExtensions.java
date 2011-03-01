package org.eclipse.xtext.example.domainmodel.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class CompilerExtensions {
  private final CompilerExtensions _this = this;
  
  public String packageName(Object o) {
    String switchResult = null;
    final Object o_1 = o;
    boolean matched = false;
    if (!matched) {
      if (o_1 instanceof PackageDeclaration) {
        final PackageDeclaration o_2 = (PackageDeclaration) o_1;
        matched=true;
        final PackageDeclaration final_o_2 = (PackageDeclaration)o_2;
        EObject _eContainer = final_o_2.eContainer();
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
  
  public String concatPath(String prefix, String suffix) {
    String _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(prefix, null);
    boolean _operator_equals_1 = ObjectExtensions.operator_equals(prefix, "");
    boolean _operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
    if (((Boolean)_operator_or)) {
      _xifexpression = suffix;
    } else {
      String _operator_plus = StringExtensions.operator_plus(prefix, ".");
      final String final_suffix = (String)suffix;
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, final_suffix);
      _xifexpression = _operator_plus_1;
    }
    return _xifexpression;
  }
  
  public String shortName(JvmTypeReference r, ImportManager importManager) {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder();
      importManager.appendTypeRef(r, builder);
      String _string = builder.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
}