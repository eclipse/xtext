/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide.types;

import com.google.common.base.Splitter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.objectweb.asm.ClassReader;

@Data
@SuppressWarnings("all")
public class ClasspathTypeDescriptor implements ITypeDescriptor {
  private static final Splitter NESTED_CLASS_SPLITTER = Splitter.on("$");
  
  private static final Splitter PACKAGE_AND_NESTED_CLASS_SPLITTER = Splitter.onPattern("\\.|\\$");
  
  private static final Pattern ANONYMOUS_CLASS_PATTERN = Pattern.compile("\\d+");
  
  private final String name;
  
  private final int accessFlags;
  
  @Override
  public String getSimpleName() {
    return this.getQualifiedName().getLastSegment();
  }
  
  @Override
  public QualifiedName getQualifiedName() {
    return QualifiedName.create(((String[])Conversions.unwrapArray(ClasspathTypeDescriptor.PACKAGE_AND_NESTED_CLASS_SPLITTER.split(this.name), String.class)));
  }
  
  public static ClasspathTypeDescriptor forFile(final File file, final String packageName, final Collection<String> packagePrefixes) {
    try {
      ClasspathTypeDescriptor _xblockexpression = null;
      {
        if (((!packagePrefixes.isEmpty()) && (!IterableExtensions.<String>exists(packagePrefixes, ((Function1<String, Boolean>) (String it) -> {
          return Boolean.valueOf(packageName.startsWith(it));
        }))))) {
          return null;
        }
        final String fileName = file.getName();
        InputStream inputStream = null;
        ClasspathTypeDescriptor _xtrycatchfinallyexpression = null;
        try {
          ClasspathTypeDescriptor _xifexpression = null;
          boolean _endsWith = fileName.endsWith(".class");
          if (_endsWith) {
            ClasspathTypeDescriptor _xblockexpression_1 = null;
            {
              int _length = fileName.length();
              int _minus = (_length - 6);
              final String simpleNames = fileName.substring(0, _minus);
              Iterable<String> _split = ClasspathTypeDescriptor.NESTED_CLASS_SPLITTER.split(simpleNames);
              for (final String s : _split) {
                boolean _matches = ClasspathTypeDescriptor.ANONYMOUS_CLASS_PATTERN.matcher(s).matches();
                if (_matches) {
                  return null;
                }
              }
              String _xifexpression_1 = null;
              boolean _isEmpty = packageName.isEmpty();
              if (_isEmpty) {
                _xifexpression_1 = simpleNames;
              } else {
                _xifexpression_1 = ((packageName + ".") + simpleNames);
              }
              final String name = _xifexpression_1;
              FileInputStream _fileInputStream = new FileInputStream(file);
              inputStream = _fileInputStream;
              final ClassReader classReader = new ClassReader(inputStream);
              final int accessFlags = classReader.getAccess();
              _xblockexpression_1 = new ClasspathTypeDescriptor(name, accessFlags);
            }
            _xifexpression = _xblockexpression_1;
          }
          _xtrycatchfinallyexpression = _xifexpression;
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        } finally {
          if ((inputStream != null)) {
            inputStream.close();
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ClasspathTypeDescriptor forJarEntry(final JarEntry jarEntry, final JarFile jarFile, final Collection<String> packagePrefixes) {
    try {
      ClasspathTypeDescriptor _xblockexpression = null;
      {
        final String filePath = jarEntry.getName();
        InputStream inputStream = null;
        ClasspathTypeDescriptor _xtrycatchfinallyexpression = null;
        try {
          ClasspathTypeDescriptor _xifexpression = null;
          boolean _endsWith = filePath.endsWith(".class");
          if (_endsWith) {
            ClasspathTypeDescriptor _xblockexpression_1 = null;
            {
              int _length = filePath.length();
              int _minus = (_length - 6);
              final String name = filePath.substring(0, _minus).replace("/", ".");
              if (((!packagePrefixes.isEmpty()) && (!IterableExtensions.<String>exists(packagePrefixes, ((Function1<String, Boolean>) (String it) -> {
                return Boolean.valueOf(name.startsWith(it));
              }))))) {
                return null;
              }
              int _lastIndexOf = name.lastIndexOf(".");
              int _plus = (_lastIndexOf + 1);
              final String simpleNames = name.substring(_plus);
              Iterable<String> _split = ClasspathTypeDescriptor.NESTED_CLASS_SPLITTER.split(simpleNames);
              for (final String s : _split) {
                boolean _matches = ClasspathTypeDescriptor.ANONYMOUS_CLASS_PATTERN.matcher(s).matches();
                if (_matches) {
                  return null;
                }
              }
              inputStream = jarFile.getInputStream(jarEntry);
              final ClassReader classReader = new ClassReader(inputStream);
              final int accessFlags = classReader.getAccess();
              _xblockexpression_1 = new ClasspathTypeDescriptor(name, accessFlags);
            }
            _xifexpression = _xblockexpression_1;
          }
          _xtrycatchfinallyexpression = _xifexpression;
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        } finally {
          if ((inputStream != null)) {
            inputStream.close();
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ClasspathTypeDescriptor(final String name, final int accessFlags) {
    super();
    this.name = name;
    this.accessFlags = accessFlags;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    return prime * result + this.accessFlags;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ClasspathTypeDescriptor other = (ClasspathTypeDescriptor) obj;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (other.accessFlags != this.accessFlags)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("name", this.name);
    b.add("accessFlags", this.accessFlags);
    return b.toString();
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public int getAccessFlags() {
    return this.accessFlags;
  }
}
