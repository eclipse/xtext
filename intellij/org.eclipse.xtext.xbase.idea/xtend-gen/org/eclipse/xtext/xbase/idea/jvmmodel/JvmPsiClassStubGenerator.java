/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvmmodel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class JvmPsiClassStubGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  public void generateStub(final JvmDeclaredType it, final IFileSystemAccess fileSystemAccess) {
    String _javaFileName = this.getJavaFileName(it);
    CharSequence _javaStubSource = this.getJavaStubSource(it);
    fileSystemAccess.generateFile(_javaFileName, _javaStubSource);
  }
  
  protected String getJavaFileName(final JvmDeclaredType it) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(it);
    List<String> _segments = _fullyQualifiedName.getSegments();
    String _concat = Strings.concat("/", _segments);
    return (_concat + ".java");
  }
  
  protected CharSequence getJavaStubSource(final JvmDeclaredType it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = it.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    String _compileVisibility = this.compileVisibility(it);
    _builder.append(_compileVisibility, "");
    _builder.append(" ");
    String _compileType = this.compileType(it);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _simpleName = it.getSimpleName();
    _builder.append(_simpleName, "");
    CharSequence _compileTypeParameters = this.compileTypeParameters(it);
    _builder.append(_compileTypeParameters, "");
    _builder.append(" {}");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected String compileType(final JvmDeclaredType it) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof JvmEnumerationType) {
        _matched=true;
        _switchResult = "enum";
      }
    }
    if (!_matched) {
      if (it instanceof JvmAnnotationType) {
        _matched=true;
        _switchResult = "@interface";
      }
    }
    if (!_matched) {
      if (it instanceof JvmGenericType) {
        boolean _isInterface = ((JvmGenericType)it).isInterface();
        if (_isInterface) {
          _matched=true;
          _switchResult = "interface";
        }
      }
    }
    if (!_matched) {
      _switchResult = "class";
    }
    return _switchResult;
  }
  
  protected String compileVisibility(final JvmDeclaredType it) {
    String _switchResult = null;
    JvmVisibility _visibility = it.getVisibility();
    if (_visibility != null) {
      switch (_visibility) {
        case PUBLIC:
          _switchResult = "public";
          break;
        case PROTECTED:
          _switchResult = "protected";
          break;
        case PRIVATE:
          _switchResult = "private";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected CharSequence compileTypeParameters(final JvmDeclaredType it) {
    CharSequence _xifexpression = null;
    if ((it instanceof JvmGenericType)) {
      StringConcatenation _builder = new StringConcatenation();
      {
        EList<JvmTypeParameter> _typeParameters = ((JvmGenericType)it).getTypeParameters();
        boolean _hasElements = false;
        for(final JvmTypeParameter typeParameter : _typeParameters) {
          if (!_hasElements) {
            _hasElements = true;
            _builder.append("<", "");
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _simpleName = typeParameter.getSimpleName();
          _builder.append(_simpleName, "");
        }
        if (_hasElements) {
          _builder.append(">", "");
        }
      }
      _xifexpression = _builder;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
}
