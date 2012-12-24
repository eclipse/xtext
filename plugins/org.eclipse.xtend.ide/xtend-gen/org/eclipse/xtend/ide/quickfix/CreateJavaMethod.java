package org.eclipse.xtend.ide.quickfix;

import java.util.List;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.quickfix.XtendMethodBuilder;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class CreateJavaMethod implements IModification {
  private final XtendMethodBuilder _methodBuilder;
  
  public XtendMethodBuilder getMethodBuilder() {
    return this._methodBuilder;
  }
  
  private final IType _type;
  
  public IType getType() {
    return this._type;
  }
  
  public void apply(final IModificationContext context) throws Exception {
    IMethod _generateMethod = this.generateMethod();
    this.openInEditor(_generateMethod);
  }
  
  private IMethod generateMethod() {
    try {
      IMethod _xblockexpression = null;
      {
        char _charAt = ".".charAt(0);
        ImportManager _importManager = new ImportManager(true, _charAt);
        final ImportManager importManager = _importManager;
        StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
        final StringBuilderBasedAppendable content = _stringBuilderBasedAppendable;
        XtendMethodBuilder _methodBuilder = this.getMethodBuilder();
        _methodBuilder.build(content);
        List<String> _imports = importManager.getImports();
        final Procedure1<String> _function = new Procedure1<String>() {
            public void apply(final String it) {
              try {
                IType _type = CreateJavaMethod.this.getType();
                ICompilationUnit _compilationUnit = _type.getCompilationUnit();
                NullProgressMonitor _monitor = CreateJavaMethod.this.monitor();
                _compilationUnit.createImport(it, null, _monitor);
              } catch (Exception _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
        IterableExtensions.<String>forEach(_imports, _function);
        IType _type = this.getType();
        String _string = content.toString();
        NullProgressMonitor _monitor = this.monitor();
        IMethod _createMethod = _type.createMethod(_string, null, true, _monitor);
        _xblockexpression = (_createMethod);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public NullProgressMonitor monitor() {
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    return _nullProgressMonitor;
  }
  
  private void openInEditor(final IJavaElement element) {
    JdtHyperlink _jdtHyperlink = new JdtHyperlink();
    final JdtHyperlink link = _jdtHyperlink;
    link.setJavaElement(element);
    link.open();
  }
  
  public CreateJavaMethod(final XtendMethodBuilder methodBuilder, final IType type) {
    super();
    this._methodBuilder = methodBuilder;
    this._type = type;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_methodBuilder== null) ? 0 : _methodBuilder.hashCode());
    result = prime * result + ((_type== null) ? 0 : _type.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CreateJavaMethod other = (CreateJavaMethod) obj;
    if (_methodBuilder == null) {
      if (other._methodBuilder != null)
        return false;
    } else if (!_methodBuilder.equals(other._methodBuilder))
      return false;
    if (_type == null) {
      if (other._type != null)
        return false;
    } else if (!_type.equals(other._type))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
