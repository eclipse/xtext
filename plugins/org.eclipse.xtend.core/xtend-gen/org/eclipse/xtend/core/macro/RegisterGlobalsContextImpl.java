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
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.FileSystemSupport;
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
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class RegisterGlobalsContextImpl implements RegisterGlobalsContext {
  @Accessors
  private IJvmDeclaredTypeAcceptor acceptor;
  
  @Accessors
  private CompilationUnitImpl compilationUnit;
  
  public void registerAnnotationType(final String qualifiedName) throws IllegalArgumentException {
    final JvmAnnotationType newType = TypesFactory.eINSTANCE.createJvmAnnotationType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    this.setNameAndAccept(newType, qualifiedName);
  }
  
  public void registerClass(final String qualifiedName) throws IllegalArgumentException {
    final JvmGenericType newType = TypesFactory.eINSTANCE.createJvmGenericType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmTypeReference> _superTypes = newType.getSuperTypes();
    TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
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
    this.compilationUnit.checkCanceled();
    final Pair<String, String> namespaceAndName = this.getNameParts(qualifiedName);
    IFileHeaderProvider _fileHeaderProvider = this.compilationUnit.getFileHeaderProvider();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    final String headerText = _fileHeaderProvider.getFileHeader(_eResource);
    JvmTypesBuilder _jvmTypesBuilder = this.compilationUnit.getJvmTypesBuilder();
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
        this.acceptor.<JvmDeclaredType>accept(newType);
      }
    } else {
      this.acceptor.<JvmDeclaredType>accept(newType);
    }
    String _value = namespaceAndName.getValue();
    newType.setSimpleName(_value);
  }
  
  private JvmDeclaredType findType(final String string) {
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
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
  
  @Delegate
  public FileSystemSupport getFileSystemSupport() {
    return this.compilationUnit.getFileSystemSupport();
  }
  
  @Delegate
  public FileLocations getFileLocations() {
    return this.compilationUnit.getFileLocations();
  }
  
  @Pure
  public IJvmDeclaredTypeAcceptor getAcceptor() {
    return this.acceptor;
  }
  
  public void setAcceptor(final IJvmDeclaredTypeAcceptor acceptor) {
    this.acceptor = acceptor;
  }
  
  @Pure
  public CompilationUnitImpl getCompilationUnit() {
    return this.compilationUnit;
  }
  
  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }
  
  public boolean exists(final Path path) {
    return this.getFileSystemSupport().exists(path);
  }
  
  public String getCharset(final Path path) {
    return this.getFileSystemSupport().getCharset(path);
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    return this.getFileSystemSupport().getChildren(path);
  }
  
  public CharSequence getContents(final Path path) {
    return this.getFileSystemSupport().getContents(path);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    return this.getFileSystemSupport().getContentsAsStream(path);
  }
  
  public long getLastModification(final Path path) {
    return this.getFileSystemSupport().getLastModification(path);
  }
  
  public boolean isFile(final Path path) {
    return this.getFileSystemSupport().isFile(path);
  }
  
  public boolean isFolder(final Path path) {
    return this.getFileSystemSupport().isFolder(path);
  }
  
  public URI toURI(final Path path) {
    return this.getFileSystemSupport().toURI(path);
  }
  
  public Path getProjectFolder(final Path path) {
    return this.getFileLocations().getProjectFolder(path);
  }
  
  public Path getSourceFolder(final Path path) {
    return this.getFileLocations().getSourceFolder(path);
  }
  
  public Path getTargetFolder(final Path sourceFolder) {
    return this.getFileLocations().getTargetFolder(sourceFolder);
  }
}
