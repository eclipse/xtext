package org.eclipse.xtend.core.macro;

import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.AbstractNamedElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.ModifyContext;
import org.eclipse.xtend.lib.macro.Problem;
import org.eclipse.xtend.lib.macro.TypeReferenceProvider;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ModifyContextImpl implements ModifyContext {
  @Inject
  private IXtendJvmAssociations associations;
  
  private CompilationUnitImpl _unit;
  
  public CompilationUnitImpl getUnit() {
    return this._unit;
  }
  
  public void setUnit(final CompilationUnitImpl unit) {
    this._unit = unit;
  }
  
  private CompilationUnitImpl unit(final NamedElement element) {
    CompilationUnit _compilationUnit = element.getCompilationUnit();
    return ((CompilationUnitImpl) _compilationUnit);
  }
  
  private EObject delegate(final NamedElement element) {
    EObject _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof AbstractNamedElementImpl) {
        final AbstractNamedElementImpl<? extends EObject> _abstractNamedElementImpl = (AbstractNamedElementImpl<? extends EObject>)element;
        _matched=true;
        EObject _delegate = _abstractNamedElementImpl.getDelegate();
        _switchResult = _delegate;
      }
    }
    return _switchResult;
  }
  
  public MutableClassDeclaration getGeneratedClass(final ClassDeclaration source) {
    MutableNamedElement _generatedElement = this.getGeneratedElement(source);
    return ((MutableClassDeclaration) _generatedElement);
  }
  
  public MutableConstructorDeclaration getGeneratedConstructor(final ConstructorDeclaration source) {
    MutableNamedElement _generatedElement = this.getGeneratedElement(source);
    return ((MutableConstructorDeclaration) _generatedElement);
  }
  
  public MutableNamedElement getGeneratedElement(final NamedElement source) {
    MutableNamedElement _xblockexpression = null;
    {
      EObject _delegate = this.delegate(source);
      Set<EObject> _jvmElements = this.associations.getJvmElements(_delegate);
      EObject _head = IterableExtensions.<EObject>head(_jvmElements);
      final JvmMember generated = ((JvmMember) _head);
      CompilationUnitImpl _unit = this.unit(source);
      MemberDeclaration _memberDeclaration = _unit.toMemberDeclaration(generated);
      _xblockexpression = (((MutableNamedElement) _memberDeclaration));
    }
    return _xblockexpression;
  }
  
  public MutableFieldDeclaration getGeneratedField(final FieldDeclaration source) {
    MutableNamedElement _generatedElement = this.getGeneratedElement(source);
    return ((MutableFieldDeclaration) _generatedElement);
  }
  
  public MutableMethodDeclaration getGeneratedMethod(final MethodDeclaration source) {
    MutableNamedElement _generatedElement = this.getGeneratedElement(source);
    return ((MutableMethodDeclaration) _generatedElement);
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
  
  public MutableClassDeclaration findGeneratedClass(final String name) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public TypeReferenceProvider getTypeReferenceProvider() {
    return this.getUnit();
  }
  
  public void addError(final Element element, final String message) {
    CompilationUnitImpl _unit = this.getUnit();
    _unit.addError(element, message);
  }
  
  public void addInfo(final Element element, final String message) {
    CompilationUnitImpl _unit = this.getUnit();
    _unit.addInfo(element, message);
  }
  
  public void addWarning(final Element element, final String message) {
    CompilationUnitImpl _unit = this.getUnit();
    _unit.addWarning(element, message);
  }
  
  public List<Problem> getProblems(final Element element) {
    CompilationUnitImpl _unit = this.getUnit();
    List<Problem> _problems = _unit.getProblems(element);
    return _problems;
  }
}
