package org.eclipse.xtend.core.macro;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.CompilationContext;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer2;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;

@SuppressWarnings("all")
public class CompilationContextImpl implements CompilationContext {
  private ReflectExtensions reflectExtensions = new Function0<ReflectExtensions>() {
    public ReflectExtensions apply() {
      ReflectExtensions _reflectExtensions = new ReflectExtensions();
      return _reflectExtensions;
    }
  }.apply();
  
  private ITreeAppendable appendable;
  
  private ImportManager importManager;
  
  private CompilationUnitImpl compilationUnit;
  
  private TypeReferenceSerializer2 typeRefSerializer;
  
  public CompilationContextImpl(final ITreeAppendable appendable, final CompilationUnitImpl compilationUnit, final TypeReferenceSerializer2 typeRefSerializer) {
    this.appendable = appendable;
    ImportManager _importManager = this.getImportManager(appendable);
    this.importManager = _importManager;
    this.compilationUnit = compilationUnit;
    this.typeRefSerializer = typeRefSerializer;
  }
  
  public ImportManager getImportManager(final ITreeAppendable appendable) {
    try {
      Object _get = this.reflectExtensions.<Object>get(appendable, "state");
      return _get==null?(ImportManager)null:this.reflectExtensions.<ImportManager>get(_get, "importManager");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String toJavaCode(final TypeReference typeref) {
    StringBuilderBasedAppendable _xifexpression = null;
    boolean _notEquals = ObjectExtensions.operator_notEquals(this.importManager, null);
    if (_notEquals) {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(this.importManager);
      _xifexpression = _stringBuilderBasedAppendable;
    } else {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable_1 = new StringBuilderBasedAppendable();
      _xifexpression = _stringBuilderBasedAppendable_1;
    }
    final StringBuilderBasedAppendable appendable = _xifexpression;
    final JvmTypeReference typeRef = this.compilationUnit.toJvmTypeReference(typeref);
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    this.typeRefSerializer.serialize(typeRef, _xtendFile, appendable);
    return appendable.toString();
  }
}
