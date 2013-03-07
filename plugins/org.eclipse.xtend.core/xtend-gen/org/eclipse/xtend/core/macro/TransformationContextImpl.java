package org.eclipse.xtend.core.macro;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl;
import org.eclipse.xtend.core.macro.declaration.XtendNamedElementImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

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
  
  public boolean isExternal(final NamedElement element) {
    boolean _and = false;
    boolean _isSource = this.isSource(element);
    boolean _not = (!_isSource);
    if (!_not) {
      _and = false;
    } else {
      boolean _isGenerated = this.isGenerated(element);
      boolean _not_1 = (!_isGenerated);
      _and = (_not && _not_1);
    }
    return _and;
  }
  
  public boolean isGenerated(final NamedElement element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof JvmNamedElementImpl) {
        final JvmNamedElementImpl<? extends JvmIdentifiableElement> _jvmNamedElementImpl = (JvmNamedElementImpl<? extends JvmIdentifiableElement>)element;
        _matched=true;
        JvmIdentifiableElement _delegate = _jvmNamedElementImpl.getDelegate();
        Resource _eResource = _delegate.eResource();
        CompilationUnitImpl _unit = this.getUnit();
        XtendFile _xtendFile = _unit.getXtendFile();
        Resource _eResource_1 = _xtendFile.eResource();
        return ObjectExtensions.operator_equals(_eResource, _eResource_1);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public boolean isSource(final NamedElement element) {
    return (element instanceof XtendNamedElementImpl<?>);
  }
  
  public MutableNamedElement getPrimaryGeneratedJavaElement(final NamedElement source) {
    boolean _isSource = this.isSource(source);
    if (_isSource) {
      EObject _delegate = ((XtendNamedElementImpl<?>) source).getDelegate();
      Set<EObject> _jvmElements = this.associations.getJvmElements(_delegate);
      Iterable<JvmIdentifiableElement> _filter = Iterables.<JvmIdentifiableElement>filter(_jvmElements, JvmIdentifiableElement.class);
      final JvmIdentifiableElement derivedElement = IterableExtensions.<JvmIdentifiableElement>head(_filter);
      boolean _notEquals = ObjectExtensions.operator_notEquals(derivedElement, null);
      if (_notEquals) {
        CompilationUnitImpl _unit = this.getUnit();
        return _unit.toNamedElement(derivedElement);
      }
    }
    return null;
  }
  
  public void addError(final Element element, final String message) {
    CompilationUnitImpl _unit = this.getUnit();
    ProblemSupport _problemSupport = _unit.getProblemSupport();
    _problemSupport.addError(element, message);
  }
  
  public void addWarning(final Element element, final String message) {
    CompilationUnitImpl _unit = this.getUnit();
    ProblemSupport _problemSupport = _unit.getProblemSupport();
    _problemSupport.addWarning(element, message);
  }
  
  public List<Problem> getProblems(final Element element) {
    CompilationUnitImpl _unit = this.getUnit();
    ProblemSupport _problemSupport = _unit.getProblemSupport();
    List<Problem> _problems = _problemSupport.getProblems(element);
    return _problems;
  }
  
  public TypeReference getAnyType() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _anyType = _typeReferenceProvider.getAnyType();
    return _anyType;
  }
  
  public TypeReference getList(final TypeReference param) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _list = _typeReferenceProvider.getList(param);
    return _list;
  }
  
  public TypeReference getObject() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _object = _typeReferenceProvider.getObject();
    return _object;
  }
  
  public TypeReference getPrimitiveBoolean() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveBoolean = _typeReferenceProvider.getPrimitiveBoolean();
    return _primitiveBoolean;
  }
  
  public TypeReference getPrimitiveByte() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveByte = _typeReferenceProvider.getPrimitiveByte();
    return _primitiveByte;
  }
  
  public TypeReference getPrimitiveChar() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveChar = _typeReferenceProvider.getPrimitiveChar();
    return _primitiveChar;
  }
  
  public TypeReference getPrimitiveDouble() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveDouble = _typeReferenceProvider.getPrimitiveDouble();
    return _primitiveDouble;
  }
  
  public TypeReference getPrimitiveFloat() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveFloat = _typeReferenceProvider.getPrimitiveFloat();
    return _primitiveFloat;
  }
  
  public TypeReference getPrimitiveInt() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveInt = _typeReferenceProvider.getPrimitiveInt();
    return _primitiveInt;
  }
  
  public TypeReference getPrimitiveLong() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveLong = _typeReferenceProvider.getPrimitiveLong();
    return _primitiveLong;
  }
  
  public TypeReference getPrimitiveShort() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveShort = _typeReferenceProvider.getPrimitiveShort();
    return _primitiveShort;
  }
  
  public TypeReference getPrimitiveVoid() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _primitiveVoid = _typeReferenceProvider.getPrimitiveVoid();
    return _primitiveVoid;
  }
  
  public TypeReference getSet(final TypeReference param) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _set = _typeReferenceProvider.getSet(param);
    return _set;
  }
  
  public TypeReference getString() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _string = _typeReferenceProvider.getString();
    return _string;
  }
  
  public TypeReference newArrayTypeReference(final TypeReference componentType) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _newArrayTypeReference = _typeReferenceProvider.newArrayTypeReference(componentType);
    return _newArrayTypeReference;
  }
  
  public TypeReference newTypeReference(final String typeName, final TypeReference... typeArguments) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _newTypeReference = _typeReferenceProvider.newTypeReference(typeName, typeArguments);
    return _newTypeReference;
  }
  
  public TypeReference newTypeReference(final Type typeDeclaration, final TypeReference... typeArguments) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _newTypeReference = _typeReferenceProvider.newTypeReference(typeDeclaration, typeArguments);
    return _newTypeReference;
  }
  
  public TypeReference newWildcardTypeReference() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _newWildcardTypeReference = _typeReferenceProvider.newWildcardTypeReference();
    return _newWildcardTypeReference;
  }
  
  public TypeReference newWildcardTypeReference(final TypeReference upperBound) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    TypeReference _newWildcardTypeReference = _typeReferenceProvider.newWildcardTypeReference(upperBound);
    return _newWildcardTypeReference;
  }
  
  public MutableInterfaceDeclaration findInterface(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    MutableInterfaceDeclaration _findInterface = _typeLookup.findInterface(qualifiedName);
    return _findInterface;
  }
  
  public MutableClassDeclaration findClass(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    MutableClassDeclaration _findClass = _typeLookup.findClass(qualifiedName);
    return _findClass;
  }
  
  public MutableAnnotationTypeDeclaration findAnnotationType(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    MutableAnnotationTypeDeclaration _findAnnotationType = _typeLookup.findAnnotationType(qualifiedName);
    return _findAnnotationType;
  }
  
  public MutableEnumerationTypeDeclaration findEnumerationType(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    MutableEnumerationTypeDeclaration _findEnumerationType = _typeLookup.findEnumerationType(qualifiedName);
    return _findEnumerationType;
  }
}
