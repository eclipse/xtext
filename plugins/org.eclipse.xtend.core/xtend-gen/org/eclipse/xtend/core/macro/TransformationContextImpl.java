/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.InputStream;
import java.net.URI;
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
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
  
  public boolean isExternal(final NamedElement element) {
    boolean _and = false;
    boolean _isSource = this.isSource(element);
    boolean _not = (!_isSource);
    if (!_not) {
      _and = false;
    } else {
      boolean _isGenerated = this.isGenerated(element);
      boolean _not_1 = (!_isGenerated);
      _and = _not_1;
    }
    return _and;
  }
  
  public boolean isGenerated(final NamedElement element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof JvmNamedElementImpl) {
        _matched=true;
        JvmIdentifiableElement _delegate = ((JvmNamedElementImpl<JvmIdentifiableElement>)element).getDelegate();
        Resource _eResource = _delegate.eResource();
        CompilationUnitImpl _unit = this.getUnit();
        XtendFile _xtendFile = _unit.getXtendFile();
        Resource _eResource_1 = _xtendFile.eResource();
        return Objects.equal(_eResource, _eResource_1);
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
      Iterable<JvmIdentifiableElement> _filter = Iterables.<JvmIdentifiableElement>filter(_jvmElements, 
        JvmIdentifiableElement.class);
      final JvmIdentifiableElement derivedElement = IterableExtensions.<JvmIdentifiableElement>head(_filter);
      boolean _notEquals = (!Objects.equal(derivedElement, null));
      if (_notEquals) {
        CompilationUnitImpl _unit = this.getUnit();
        NamedElement _namedElement = _unit.toNamedElement(derivedElement);
        return ((MutableNamedElement) _namedElement);
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
    return _problemSupport.getProblems(element);
  }
  
  public TypeReference getAnyType() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getAnyType();
  }
  
  public TypeReference getList(final TypeReference param) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getList(param);
  }
  
  public TypeReference getObject() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getObject();
  }
  
  public TypeReference getPrimitiveBoolean() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveBoolean();
  }
  
  public TypeReference getPrimitiveByte() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveByte();
  }
  
  public TypeReference getPrimitiveChar() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveChar();
  }
  
  public TypeReference getPrimitiveDouble() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveDouble();
  }
  
  public TypeReference getPrimitiveFloat() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveFloat();
  }
  
  public TypeReference getPrimitiveInt() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveInt();
  }
  
  public TypeReference getPrimitiveLong() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveLong();
  }
  
  public TypeReference getPrimitiveShort() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveShort();
  }
  
  public TypeReference getPrimitiveVoid() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getPrimitiveVoid();
  }
  
  public TypeReference getSet(final TypeReference param) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getSet(param);
  }
  
  public TypeReference getString() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.getString();
  }
  
  public TypeReference newArrayTypeReference(final TypeReference componentType) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.newArrayTypeReference(componentType);
  }
  
  public TypeReference newTypeReference(final String typeName, final TypeReference... typeArguments) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.newTypeReference(typeName, typeArguments);
  }
  
  public TypeReference newTypeReference(final Type typeDeclaration, final TypeReference... typeArguments) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.newTypeReference(typeDeclaration, typeArguments);
  }
  
  public TypeReference newTypeReference(final Class<? extends Object> clazz, final TypeReference... typeArguments) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.newTypeReference(clazz, typeArguments);
  }
  
  public TypeReference newWildcardTypeReference() {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.newWildcardTypeReference();
  }
  
  public TypeReference newWildcardTypeReference(final TypeReference upperBound) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.newWildcardTypeReference(upperBound);
  }
  
  public TypeReference newWildcardTypeReferenceWithLowerBound(final TypeReference upperBound) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeReferenceProvider _typeReferenceProvider = _unit.getTypeReferenceProvider();
    return _typeReferenceProvider.newWildcardTypeReferenceWithLowerBound(upperBound);
  }
  
  public MutableInterfaceDeclaration findInterface(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    return _typeLookup.findInterface(qualifiedName);
  }
  
  public MutableClassDeclaration findClass(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    return _typeLookup.findClass(qualifiedName);
  }
  
  public MutableAnnotationTypeDeclaration findAnnotationType(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    return _typeLookup.findAnnotationType(qualifiedName);
  }
  
  public MutableEnumerationTypeDeclaration findEnumerationType(final String qualifiedName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    return _typeLookup.findEnumerationType(qualifiedName);
  }
  
  public Type findTypeGlobally(final Class<? extends Object> clazz) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    return _typeLookup.findTypeGlobally(clazz);
  }
  
  public Type findTypeGlobally(final String typeName) {
    CompilationUnitImpl _unit = this.getUnit();
    TypeLookupImpl _typeLookup = _unit.getTypeLookup();
    return _typeLookup.findTypeGlobally(typeName);
  }
  
  public boolean exists(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.exists(path);
  }
  
  public String getCharset(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.getCharset(path);
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.getChildren(path);
  }
  
  public CharSequence getContents(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.getContents(path);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.getContentsAsStream(path);
  }
  
  public long getLastModification(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.getLastModification(path);
  }
  
  public Path getProjectFolder(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    FileLocations _fileLocations = _unit.getFileLocations();
    return _fileLocations.getProjectFolder(path);
  }
  
  public Path getSourceFolder(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    FileLocations _fileLocations = _unit.getFileLocations();
    return _fileLocations.getSourceFolder(path);
  }
  
  public Path getTargetFolder(final Path sourceFolder) {
    CompilationUnitImpl _unit = this.getUnit();
    FileLocations _fileLocations = _unit.getFileLocations();
    return _fileLocations.getTargetFolder(sourceFolder);
  }
  
  public boolean isFile(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.isFile(path);
  }
  
  public boolean isFolder(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.isFolder(path);
  }
  
  public URI toURI(final Path path) {
    CompilationUnitImpl _unit = this.getUnit();
    MutableFileSystemSupport _fileSystemSupport = _unit.getFileSystemSupport();
    return _fileSystemSupport.toURI(path);
  }
}
