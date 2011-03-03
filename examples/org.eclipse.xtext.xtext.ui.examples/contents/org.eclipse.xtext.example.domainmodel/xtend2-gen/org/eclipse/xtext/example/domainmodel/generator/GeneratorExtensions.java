package org.eclipse.xtext.example.domainmodel.generator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class GeneratorExtensions {
  private final GeneratorExtensions _this = this;
  
  public String packageName(final Object o) {
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
  
  public String concatPath(final String prefix, final String suffix) {
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
  
  public String shortName(final JvmTypeReference r, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder();
      importManager.appendTypeRef(r, builder);
      String _string = builder.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String fileName(final Entity e) {
    final Entity final_e = (Entity)e;
    String _packageName = _this.packageName(final_e);
    String _replace = _packageName.replace(".", "/");
    String _operator_plus = StringExtensions.operator_plus(_replace, "/");
    String _name = e.getName();
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ".java");
    return _operator_plus_2;
  }
  
  public String parameterList(final Operation o, final ImportManager importManager) {
    EList<JvmFormalParameter> _params = o.getParams();
    final Function1<JvmFormalParameter,String> function = new Function1<JvmFormalParameter,String>() {
        public String apply(JvmFormalParameter p) {
          JvmTypeReference _parameterType = p.getParameterType();
          String _shortName = _this.shortName(_parameterType, importManager);
          String _operator_plus = StringExtensions.operator_plus(_shortName, " ");
          String _name = p.getName();
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
          return _operator_plus_1;
        }
      };
    List<String> _map = ListExtensions.map(_params, function);
    String _elementsToString = IterableExtensions.elementsToString(_map, ", ");
    return _elementsToString;
  }
}