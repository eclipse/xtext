/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.util.internal.CodeGenUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;

/**
 * A utility class for generating Java files.
 */
@SuppressWarnings("all")
public class JavaFileAccess extends TextFileAccess {
  protected static class JavaTypeAwareStringConcatenation extends StringConcatenation {
    private final JavaFileAccess access;

    public JavaTypeAwareStringConcatenation(final JavaFileAccess access) {
      super(access.codeConfig.getLineDelimiter());
      this.access = access;
    }

    @Override
    public String getStringRepresentation(final Object object) {
      String _xifexpression = null;
      if ((object instanceof TypeReference)) {
        _xifexpression = this.access.importType(((TypeReference)object));
      } else {
        String _xifexpression_1 = null;
        if ((object instanceof Class<?>)) {
          TypeReference _typeReference = new TypeReference(((Class<?>)object));
          _xifexpression_1 = this.access.importType(_typeReference);
        } else {
          String _xifexpression_2 = null;
          if (((object instanceof EClass) && (this.access.resourceSet != null))) {
            TypeReference _typeReference_1 = new TypeReference(((EClass) object), this.access.resourceSet);
            _xifexpression_2 = this.access.importType(_typeReference_1);
          } else {
            String _xifexpression_3 = null;
            if (((object instanceof EPackage) && (this.access.resourceSet != null))) {
              TypeReference _typeReference_2 = new TypeReference(((EPackage) object), this.access.resourceSet);
              _xifexpression_3 = this.access.importType(_typeReference_2);
            } else {
              _xifexpression_3 = object.toString();
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    }
  }

  /**
   * A list of keywords in the Java language. Use this to avoid illegal variable names.
   */
  public static final Set<String> JAVA_KEYWORDS = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"));

  /**
   * Set this value for the 'importNestedTypeThreshold' property to disable importing of nested types
   */
  public static final int DONT_IMPORT_NESTED_TYPES = Integer.MAX_VALUE;

  protected final Map<String, String> imports = CollectionLiterals.<String, String>newHashMap();

  protected final TypeReference javaType;

  protected final CodeConfig codeConfig;

  @Accessors
  private int importNestedTypeThreshold = 8;

  @Accessors
  private boolean markedAsGenerated;

  @Accessors(AccessorType.PUBLIC_SETTER)
  private ResourceSet resourceSet;

  protected JavaFileAccess(final TypeReference typeRef, final CodeConfig codeConfig) {
    int _length = ((Object[])Conversions.unwrapArray(typeRef.getSimpleNames(), Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      throw new IllegalArgumentException(("Nested type cannot be serialized: " + typeRef));
    }
    this.javaType = typeRef;
    this.codeConfig = codeConfig;
    String _path = typeRef.getPath();
    String _plus = (_path + ".");
    String _fileExtension = this.getFileExtension();
    String _plus_1 = (_plus + _fileExtension);
    this.setPath(_plus_1);
  }

  protected String getFileExtension() {
    return "java";
  }

  public String importType(final TypeReference typeRef) {
    final List<String> simpleNames = typeRef.getSimpleNames();
    String usableName = null;
    if ((Objects.equal(typeRef.getPackageName(), "java.lang") || Objects.equal(typeRef.getPackageName(), this.javaType.getPackageName()))) {
      usableName = IterableExtensions.join(simpleNames, ".");
    } else {
      boolean found = false;
      for (int i = (((Object[])Conversions.unwrapArray(simpleNames, Object.class)).length - 1); ((i >= 0) && (!found)); i--) {
        {
          final String simpleName = simpleNames.get(i);
          if ((usableName == null)) {
            usableName = simpleName;
          } else {
            usableName = ((simpleName + ".") + usableName);
          }
          if (((!CodeGenUtil2.isJavaDefaultType(simpleName)) && (!((i > 0) && (simpleName.length() <= this.importNestedTypeThreshold))))) {
            String _packageName = typeRef.getPackageName();
            String _plus = (_packageName + ".");
            String _join = IterableExtensions.join(simpleNames.subList(0, (i + 1)), ".");
            final String importable = (_plus + _join);
            final String imported = this.imports.get(usableName);
            if ((imported == null)) {
              this.imports.put(usableName, importable);
              found = true;
            } else {
              boolean _equals = Objects.equal(imported, importable);
              if (_equals) {
                found = true;
              }
            }
          }
        }
      }
      if ((!found)) {
        usableName = typeRef.getName();
      }
    }
    final Function1<TypeReference, CharSequence> _function = (TypeReference it) -> {
      return this.importType(it);
    };
    String _join = IterableExtensions.<TypeReference>join(typeRef.getTypeArguments(), "<", ", ", ">", _function);
    return (usableName + _join);
  }

  @Override
  public void setContent(final StringConcatenationClient javaContent) {
    final JavaFileAccess.JavaTypeAwareStringConcatenation javaStringConcat = new JavaFileAccess.JavaTypeAwareStringConcatenation(this);
    javaStringConcat.append(javaContent);
    this.internalContents = javaStringConcat;
  }

  protected boolean appendSemicolons() {
    return true;
  }

  @Override
  public CharSequence getContent() {
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _packageName = this.javaType.getPackageName();
    _builder.append(_packageName);
    {
      boolean _appendSemicolons = this.appendSemicolons();
      if (_appendSemicolons) {
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<String> _sort = IterableExtensions.<String>sort(IterableExtensions.<String>toSet(this.imports.values()));
      for(final String importName : _sort) {
        _builder.append("import ");
        _builder.append(importName);
        {
          boolean _appendSemicolons_1 = this.appendSemicolons();
          if (_appendSemicolons_1) {
            _builder.append(";");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _internalContent = this.getInternalContent();
    _builder.append(_internalContent);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence getInternalContent() {
    return this.internalContents;
  }

  @Pure
  public int getImportNestedTypeThreshold() {
    return this.importNestedTypeThreshold;
  }

  public void setImportNestedTypeThreshold(final int importNestedTypeThreshold) {
    this.importNestedTypeThreshold = importNestedTypeThreshold;
  }

  @Pure
  public boolean isMarkedAsGenerated() {
    return this.markedAsGenerated;
  }

  public void setMarkedAsGenerated(final boolean markedAsGenerated) {
    this.markedAsGenerated = markedAsGenerated;
  }

  public void setResourceSet(final ResourceSet resourceSet) {
    this.resourceSet = resourceSet;
  }
}
