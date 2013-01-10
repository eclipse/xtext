package org.eclipse.xtend.core.macro;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendClassDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.lib.macro.ModifyContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ModifyContextImpl implements ModifyContext {
  @Inject
  private IXtendJvmAssociations associations;
  
  private CompilationUnitImpl unit(final NamedElement element) {
    CompilationUnit _compilationUnit = element.getCompilationUnit();
    return ((CompilationUnitImpl) _compilationUnit);
  }
  
  private EObject delegate(final NamedElement element) {
    return null;
  }
  
  public MutableClassDeclaration getGeneratedClass(final ClassDeclaration source) {
    XtendClass _delegate = ((XtendClassDeclarationImpl) source).getDelegate();
    final JvmGenericType inferred = this.associations.getInferredType(((XtendClass) _delegate));
    CompilationUnitImpl _unit = this.unit(source);
    TypeDeclaration _typeDeclaration = _unit.toTypeDeclaration(inferred);
    return ((MutableClassDeclaration) _typeDeclaration);
  }
  
  public MutableConstructorDeclaration getGeneratedConstructor(final ConstructorDeclaration source) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public MutableNamedElement getGeneratedElement(final NamedElement source) {
    return null;
  }
  
  public MutableFieldDeclaration getGeneratedField(final FieldDeclaration source) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public MutableMethodDeclaration getGeneratedMethod(final MethodDeclaration source) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isExternal(final NamedElement element) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isGenerated(final NamedElement element) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isSource(final NamedElement element) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public ClassDeclaration newClass(final Procedure1<MutableClassDeclaration> initializer) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public ConstructorDeclaration newConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public FieldDeclaration newField(final Procedure1<MutableFieldDeclaration> initializer) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public MethodDeclaration newMethod(final Procedure1<MutableMethodDeclaration> initializer) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
