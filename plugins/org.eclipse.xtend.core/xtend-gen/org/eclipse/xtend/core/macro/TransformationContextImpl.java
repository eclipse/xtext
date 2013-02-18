package org.eclipse.xtend.core.macro;

import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.AbstractNamedElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.TransformationContext;
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
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TransformationContextImpl implements TransformationContext {
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
  
  public CompilationUnitImpl getTypeReferenceProvider() {
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
  
  public TypeReference getAnyType() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _anyType = _unit.getAnyType();
    return _anyType;
  }
  
  public TypeReference getList(final TypeReference param) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _list = _unit.getList(param);
    return _list;
  }
  
  public TypeReference getObject() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _object = _unit.getObject();
    return _object;
  }
  
  public TypeReference getPrimitiveBoolean() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveBoolean = _unit.getPrimitiveBoolean();
    return _primitiveBoolean;
  }
  
  public TypeReference getPrimitiveByte() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveByte = _unit.getPrimitiveByte();
    return _primitiveByte;
  }
  
  public TypeReference getPrimitiveChar() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveChar = _unit.getPrimitiveChar();
    return _primitiveChar;
  }
  
  public TypeReference getPrimitiveDouble() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveDouble = _unit.getPrimitiveDouble();
    return _primitiveDouble;
  }
  
  public TypeReference getPrimitiveFloat() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveFloat = _unit.getPrimitiveFloat();
    return _primitiveFloat;
  }
  
  public TypeReference getPrimitiveInt() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveInt = _unit.getPrimitiveInt();
    return _primitiveInt;
  }
  
  public TypeReference getPrimitiveLong() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveLong = _unit.getPrimitiveLong();
    return _primitiveLong;
  }
  
  public TypeReference getPrimitiveShort() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveShort = _unit.getPrimitiveShort();
    return _primitiveShort;
  }
  
  public TypeReference getPrimitiveVoid() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _primitiveVoid = _unit.getPrimitiveVoid();
    return _primitiveVoid;
  }
  
  public TypeReference getSet(final TypeReference param) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _set = _unit.getSet(param);
    return _set;
  }
  
  public TypeReference getString() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _string = _unit.getString();
    return _string;
  }
  
  public TypeReference newArrayTypeReference(final TypeReference componentType) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _newArrayTypeReference = _unit.newArrayTypeReference(componentType);
    return _newArrayTypeReference;
  }
  
  public TypeReference newTypeReference(final String typeName, final TypeReference... typeArguments) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _newTypeReference = _unit.newTypeReference(typeName, typeArguments);
    return _newTypeReference;
  }
  
  public TypeReference newTypeReference(final Type typeDeclaration, final TypeReference... typeArguments) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _newTypeReference = _unit.newTypeReference(typeDeclaration, typeArguments);
    return _newTypeReference;
  }
  
  public TypeReference newWildcardTypeReference() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _newWildcardTypeReference = _unit.newWildcardTypeReference();
    return _newWildcardTypeReference;
  }
  
  public TypeReference newWildcardTypeReference(final TypeReference upperBound) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReference _newWildcardTypeReference = _unit.newWildcardTypeReference(upperBound);
    return _newWildcardTypeReference;
  }
}
