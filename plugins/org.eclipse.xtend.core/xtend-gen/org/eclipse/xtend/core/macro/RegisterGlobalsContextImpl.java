/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.io.InputStream;
import java.net.URI;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class RegisterGlobalsContextImpl implements RegisterGlobalsContext {
  private IJvmDeclaredTypeAcceptor _acceptor;
  
  public IJvmDeclaredTypeAcceptor getAcceptor() {
    return this._acceptor;
  }
  
  public void setAcceptor(final IJvmDeclaredTypeAcceptor acceptor) {
    this._acceptor = acceptor;
  }
  
  private CompilationUnitImpl _compilationUnit;
  
  public CompilationUnitImpl getCompilationUnit() {
    return this._compilationUnit;
  }
  
  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this._compilationUnit = compilationUnit;
  }
  
  public void registerAnnotationType(final String qualifiedName) throws IllegalArgumentException {
    final JvmAnnotationType newType = TypesFactory.eINSTANCE.createJvmAnnotationType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    this.setNameAndAccept(newType, qualifiedName);
  }
  
  public void registerClass(final String qualifiedName) throws IllegalArgumentException {
    final JvmGenericType newType = TypesFactory.eINSTANCE.createJvmGenericType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmTypeReference> _superTypes = newType.getSuperTypes();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    TypeReferences _typeReferences = _compilationUnit.getTypeReferences();
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    XtendFile _xtendFile = _compilationUnit_1.getXtendFile();
    JvmTypeReference _typeForName = _typeReferences.getTypeForName(Object.class, _xtendFile);
    _superTypes.add(_typeForName);
    this.setNameAndAccept(newType, qualifiedName);
  }
  
  public void registerEnumerationType(final String qualifiedName) throws IllegalArgumentException {
    final JvmEnumerationType newType = TypesFactory.eINSTANCE.createJvmEnumerationType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    this.setNameAndAccept(newType, qualifiedName);
  }
  
  public void registerInterface(final String qualifiedName) throws IllegalArgumentException {
    final JvmGenericType newType = TypesFactory.eINSTANCE.createJvmGenericType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    newType.setInterface(true);
    this.setNameAndAccept(newType, qualifiedName);
  }
  
  private void setNameAndAccept(final JvmDeclaredType newType, final String qualifiedName) {
    ConditionUtils.checkQualifiedName(qualifiedName, "qualifiedName");
    JvmDeclaredType _findType = this.findType(qualifiedName);
    boolean _equals = Objects.equal(_findType, null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The type \'");
    _builder.append(qualifiedName, "");
    _builder.append("\' has already been registered.");
    Preconditions.checkArgument(_equals, _builder);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    _compilationUnit.checkCanceled();
    final Pair<String, String> namespaceAndName = this.getNameParts(qualifiedName);
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    IFileHeaderProvider _fileHeaderProvider = _compilationUnit_1.getFileHeaderProvider();
    CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
    XtendFile _xtendFile = _compilationUnit_2.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    final String headerText = _fileHeaderProvider.getFileHeader(_eResource);
    CompilationUnitImpl _compilationUnit_3 = this.getCompilationUnit();
    JvmTypesBuilder _jvmTypesBuilder = _compilationUnit_3.getJvmTypesBuilder();
    _jvmTypesBuilder.setFileHeader(newType, headerText);
    String _key = namespaceAndName.getKey();
    boolean _notEquals = (!Objects.equal(_key, null));
    if (_notEquals) {
      String _key_1 = namespaceAndName.getKey();
      final JvmDeclaredType parentType = this.findType(_key_1);
      boolean _notEquals_1 = (!Objects.equal(parentType, null));
      if (_notEquals_1) {
        EList<JvmMember> _members = parentType.getMembers();
        _members.add(newType);
        newType.setStatic(true);
      } else {
        String _key_2 = namespaceAndName.getKey();
        newType.setPackageName(_key_2);
        IJvmDeclaredTypeAcceptor _acceptor = this.getAcceptor();
        _acceptor.<JvmDeclaredType>accept(newType);
      }
    } else {
      IJvmDeclaredTypeAcceptor _acceptor_1 = this.getAcceptor();
      _acceptor_1.<JvmDeclaredType>accept(newType);
    }
    String _value = namespaceAndName.getValue();
    newType.setSimpleName(_value);
  }
  
  private JvmDeclaredType findType(final String string) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendFile _xtendFile = _compilationUnit.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    return this.findRecursively(string, _filter);
  }
  
  private JvmDeclaredType findRecursively(final String string, final Iterable<? extends JvmDeclaredType> types) {
    for (final JvmDeclaredType type : types) {
      String _identifier = type.getIdentifier();
      boolean _startsWith = string.startsWith(_identifier);
      if (_startsWith) {
        String _identifier_1 = type.getIdentifier();
        boolean _equals = Objects.equal(string, _identifier_1);
        if (_equals) {
          return type;
        }
        EList<JvmMember> _members = type.getMembers();
        Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_members, JvmDeclaredType.class);
        final JvmDeclaredType result = this.findRecursively(string, _filter);
        boolean _notEquals = (!Objects.equal(result, null));
        if (_notEquals) {
          return result;
        }
      }
    }
    return null;
  }
  
  private Pair<String, String> getNameParts(final String string) {
    final char dot = '.';
    final int index = string.lastIndexOf(dot);
    if ((index != (-1))) {
      String _substring = string.substring(0, index);
      String _substring_1 = string.substring((index + 1));
      return Pair.<String, String>of(_substring, _substring_1);
    } else {
      return Pair.<String, String>of(null, string);
    }
  }
  
  public boolean exists(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.exists(path);
  }
  
  public String getCharset(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.getCharset(path);
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.getChildren(path);
  }
  
  public CharSequence getContents(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.getContents(path);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.getContentsAsStream(path);
  }
  
  public long getLastModification(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.getLastModification(path);
  }
  
  public Path getProjectFolder(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    FileLocations _fileLocations = _compilationUnit.getFileLocations();
    return _fileLocations.getProjectFolder(path);
  }
  
  public Path getSourceFolder(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    FileLocations _fileLocations = _compilationUnit.getFileLocations();
    return _fileLocations.getSourceFolder(path);
  }
  
  public Path getTargetFolder(final Path sourceFolder) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    FileLocations _fileLocations = _compilationUnit.getFileLocations();
    return _fileLocations.getTargetFolder(sourceFolder);
  }
  
  public boolean isFile(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.isFile(path);
  }
  
  public boolean isFolder(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.isFolder(path);
  }
  
  public URI toURI(final Path path) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
    return _fileSystemSupport.toURI(path);
  }
}
