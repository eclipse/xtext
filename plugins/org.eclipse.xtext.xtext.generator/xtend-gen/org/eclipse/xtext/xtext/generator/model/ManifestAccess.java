/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.util.MergeableManifest;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Log
@Accessors
@SuppressWarnings("all")
public class ManifestAccess extends TextFileAccess {
  private String bundleName;
  
  private String symbolicName;
  
  private String version = "0.0.1.qualifier";
  
  private boolean merge = true;
  
  private final Set<String> exportedPackages = CollectionLiterals.<String>newHashSet();
  
  private final Set<String> requiredBundles = CollectionLiterals.<String>newHashSet();
  
  private final Set<String> importedPackages = CollectionLiterals.<String>newHashSet();
  
  private TypeReference activator;
  
  public ManifestAccess() {
    this.setPath("MANIFEST.MF");
  }
  
  /**
   * Merge the contents of the given manifest into this one.
   */
  public boolean merge(final ManifestAccess other) {
    boolean _xblockexpression = false;
    {
      String _path = this.getPath();
      String _path_1 = other.getPath();
      boolean _notEquals = (!Objects.equal(_path, _path_1));
      if (_notEquals) {
        String _path_2 = this.getPath();
        String _plus = ("Merging manifest files with different paths: " + _path_2);
        String _plus_1 = (_plus + ", ");
        String _path_3 = other.getPath();
        String _plus_2 = (_plus_1 + _path_3);
        ManifestAccess.LOG.warn(_plus_2);
      }
      boolean _notEquals_1 = (!Objects.equal(this.bundleName, other.bundleName));
      if (_notEquals_1) {
        if ((this.bundleName == null)) {
          this.bundleName = other.bundleName;
        } else {
          if ((other.bundleName != null)) {
            ManifestAccess.LOG.warn(((("Merging manifest files with different bundle names: " + this.bundleName) + ", ") + other.bundleName));
          }
        }
      }
      boolean _notEquals_2 = (!Objects.equal(this.symbolicName, other.symbolicName));
      if (_notEquals_2) {
        if ((this.symbolicName == null)) {
          this.symbolicName = other.symbolicName;
        } else {
          if ((other.symbolicName != null)) {
            ManifestAccess.LOG.warn(((("Merging manifest files with different symbolic names: " + this.symbolicName) + ", ") + other.symbolicName));
          }
        }
      }
      boolean _notEquals_3 = (!Objects.equal(this.activator, other.activator));
      if (_notEquals_3) {
        if ((this.activator == null)) {
          this.activator = other.activator;
        } else {
          if ((other.activator != null)) {
            ManifestAccess.LOG.warn(((("Merging manifest files with different activators: " + this.activator) + ", ") + other.activator));
          }
        }
      }
      boolean _notEquals_4 = (!Objects.equal(this.version, other.version));
      if (_notEquals_4) {
        ManifestAccess.LOG.warn(((("Merging manifest files with different versions: " + this.version) + ", ") + other.version));
      }
      if ((this.merge != other.merge)) {
        ManifestAccess.LOG.warn("Merging manifest files with different merging settings.");
      }
      this.exportedPackages.addAll(other.exportedPackages);
      this.requiredBundles.addAll(other.requiredBundles);
      _xblockexpression = this.importedPackages.addAll(other.importedPackages);
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence setContent(final StringConcatenationClient content) {
    throw new UnsupportedOperationException("cannot directly set \'content\' on a manifest.mf. Use the individual properties instead.");
  }
  
  @Override
  public CharSequence getContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: ");
    _builder.append(this.bundleName, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-SymbolicName: ");
    String _elvis = null;
    if (this.symbolicName != null) {
      _elvis = this.symbolicName;
    } else {
      _elvis = this.bundleName;
    }
    _builder.append(_elvis, "");
    _builder.append("; singleton:=true");
    _builder.newLineIfNotEmpty();
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.version);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append("Bundle-Version: ");
        _builder.append(this.version, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.6");
    _builder.newLine();
    _builder.append("Bundle-ActivationPolicy: lazy");
    _builder.newLine();
    {
      boolean _isEmpty = this.exportedPackages.isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        _builder.append("Export-Package: ");
        {
          List<String> _sort = IterableExtensions.<String>sort(this.exportedPackages);
          boolean _hasElements = false;
          for(final String pack : _sort) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(pack, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isEmpty_1 = this.requiredBundles.isEmpty();
      boolean _not_2 = (!_isEmpty_1);
      if (_not_2) {
        _builder.append("Require-Bundle: ");
        {
          List<String> _sort_1 = IterableExtensions.<String>sort(this.requiredBundles);
          boolean _hasElements_1 = false;
          for(final String bundle : _sort_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(bundle, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isEmpty_2 = this.importedPackages.isEmpty();
      boolean _not_3 = (!_isEmpty_2);
      if (_not_3) {
        _builder.append("Import-Package: ");
        {
          List<String> _sort_2 = IterableExtensions.<String>sort(this.importedPackages);
          boolean _hasElements_2 = false;
          for(final String pack_1 : _sort_2) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",\n ", "");
            }
            _builder.append(pack_1, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((this.activator != null)) {
        _builder.append("Bundle-Activator: ");
        _builder.append(this.activator, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  @Override
  public void writeTo(final IFileSystemAccess2 fileSystemAccess) {
    try {
      boolean _notEquals = (!Objects.equal(fileSystemAccess, null));
      if (_notEquals) {
        CharSequence _content = this.getContent();
        StringBuffer _stringBuffer = new StringBuffer(_content);
        final String contentToWrite = MergeableManifest.make512Safe(_stringBuffer);
        byte[] _bytes = contentToWrite.getBytes("UTF-8");
        ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
        final MergeableManifest mergableManifest = new MergeableManifest(_byteArrayInputStream);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        mergableManifest.write(bout);
        String _path = this.getPath();
        byte[] _byteArray = bout.toByteArray();
        ByteArrayInputStream _byteArrayInputStream_1 = new ByteArrayInputStream(_byteArray);
        fileSystemAccess.generateFile(_path, _byteArrayInputStream_1);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static Logger LOG = Logger.getLogger(ManifestAccess.class);
  
  @Pure
  public String getBundleName() {
    return this.bundleName;
  }
  
  public void setBundleName(final String bundleName) {
    this.bundleName = bundleName;
  }
  
  @Pure
  public String getSymbolicName() {
    return this.symbolicName;
  }
  
  public void setSymbolicName(final String symbolicName) {
    this.symbolicName = symbolicName;
  }
  
  @Pure
  public String getVersion() {
    return this.version;
  }
  
  public void setVersion(final String version) {
    this.version = version;
  }
  
  @Pure
  public boolean isMerge() {
    return this.merge;
  }
  
  public void setMerge(final boolean merge) {
    this.merge = merge;
  }
  
  @Pure
  public Set<String> getExportedPackages() {
    return this.exportedPackages;
  }
  
  @Pure
  public Set<String> getRequiredBundles() {
    return this.requiredBundles;
  }
  
  @Pure
  public Set<String> getImportedPackages() {
    return this.importedPackages;
  }
  
  @Pure
  public TypeReference getActivator() {
    return this.activator;
  }
  
  public void setActivator(final TypeReference activator) {
    this.activator = activator;
  }
}
