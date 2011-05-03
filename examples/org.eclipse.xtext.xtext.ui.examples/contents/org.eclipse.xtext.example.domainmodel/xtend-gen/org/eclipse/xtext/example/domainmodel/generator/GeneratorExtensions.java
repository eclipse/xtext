package org.eclipse.xtext.example.domainmodel.generator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.domainmodel.DomainmodelExtensions;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class GeneratorExtensions extends DomainmodelExtensions {
  
  public String shortName(final JvmTypeReference r, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder builder = _stringBuilder;
      importManager.appendTypeRef(r, builder);
      String _string = builder.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String fileName(final Entity e) {
    String _packageName = this.packageName(e);
    String _folderName = this.folderName(_packageName);
    String _operator_plus = StringExtensions.operator_plus(_folderName, "/");
    String _name = e.getName();
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ".java");
    return _operator_plus_2;
  }
  
  public String folderName(final String javaPackageName) {
    String _xifexpression = null;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(javaPackageName, null);
    if (_operator_notEquals) {
      String _replace = javaPackageName.replace(".", "/");
      _xifexpression = _replace;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public String parameterList(final Operation o, final ImportManager importManager) {
    EList<JvmFormalParameter> _params = o.getParams();
    final Function1<JvmFormalParameter,String> _function = new Function1<JvmFormalParameter,String>() {
        public String apply(final JvmFormalParameter p) {
          JvmTypeReference _parameterType = p.getParameterType();
          String _shortName = GeneratorExtensions.this.shortName(_parameterType, importManager);
          String _operator_plus = StringExtensions.operator_plus(_shortName, " ");
          String _name = p.getName();
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
          return _operator_plus_1;
        }
      };
    List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_params, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(", ");
    _builder.newLine();
    String _join = IterableExtensions.join(_map, _builder);
    return _join;
  }
  
  public boolean isInterface(final JvmTypeReference typeRef) {
    JvmType _type = typeRef.getType();
    boolean _isInterface = ((JvmGenericType) _type).isInterface();
    return _isInterface;
  }
}