/**
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.BinaryFile;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.SourceFolderDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@Accessors
@SuppressWarnings("all")
public abstract class ProjectDescriptor {
  private final WizardConfiguration config;
  
  private boolean enabled;
  
  public String getName() {
    String _baseName = this.config.getBaseName();
    String _nameQualifier = this.getNameQualifier();
    return (_baseName + _nameQualifier);
  }
  
  public abstract String getNameQualifier();
  
  public String getLocation() {
    String _xifexpression = null;
    ProjectLayout _projectLayout = this.config.getProjectLayout();
    boolean _equals = Objects.equal(_projectLayout, ProjectLayout.FLAT);
    if (_equals) {
      String _rootLocation = this.config.getRootLocation();
      String _plus = (_rootLocation + "/");
      String _name = this.getName();
      _xifexpression = (_plus + _name);
    } else {
      String _location = this.config.getParentProject().getLocation();
      String _plus_1 = (_location + "/");
      String _name_1 = this.getName();
      _xifexpression = (_plus_1 + _name_1);
    }
    return _xifexpression;
  }
  
  public Set<? extends ProjectDescriptor> getUpstreamProjects() {
    return CollectionLiterals.<ProjectDescriptor>emptySet();
  }
  
  /**
   * @since 2.15 (changed return value use 'path' of 'SourceFolderDescriptor' to get same result as before)
   */
  public Set<SourceFolderDescriptor> getSourceFolders() {
    final Function1<Outlet, SourceFolderDescriptor> _function = (Outlet it) -> {
      String _sourceFolder = this.sourceFolder(it);
      boolean _isTest = this.isTest(it);
      return new SourceFolderDescriptor(_sourceFolder, _isTest);
    };
    return IterableExtensions.<SourceFolderDescriptor>toSet(ListExtensions.<Outlet, SourceFolderDescriptor>map(Collections.<Outlet>unmodifiableList(CollectionLiterals.<Outlet>newArrayList(Outlet.MAIN_JAVA, Outlet.MAIN_RESOURCES, Outlet.MAIN_SRC_GEN, Outlet.MAIN_XTEND_GEN)), _function));
  }
  
  public Iterable<? extends AbstractFile> getFiles() {
    final List<TextFile> files = CollectionLiterals.<TextFile>newArrayList();
    boolean _isEclipsePluginProject = this.isEclipsePluginProject();
    if (_isEclipsePluginProject) {
      PlainTextFile _file = this.file(Outlet.META_INF, "MANIFEST.MF", this.manifest());
      files.add(_file);
      PlainTextFile _file_1 = this.file(Outlet.ROOT, "build.properties", this.buildProperties());
      files.add(_file_1);
    }
    boolean _isEclipseFeatureProject = this.isEclipseFeatureProject();
    if (_isEclipseFeatureProject) {
      PlainTextFile _file_2 = this.file(Outlet.ROOT, "build.properties", this.buildProperties());
      files.add(_file_2);
    }
    if ((this.config.needsGradleBuild() && this.isPartOfGradleBuild())) {
      GradleBuildFile _buildGradle = this.buildGradle();
      files.add(_buildGradle);
    }
    if ((this.config.needsMavenBuild() && this.isPartOfMavenBuild())) {
      PomFile _pom = this.pom();
      files.add(_pom);
    }
    return files;
  }
  
  public abstract boolean isPartOfGradleBuild();
  
  public abstract boolean isPartOfMavenBuild();
  
  public abstract boolean isEclipsePluginProject();
  
  public boolean isEclipseFeatureProject() {
    return false;
  }
  
  public CharSequence buildProperties() {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<SourceFolderDescriptor, String> _function = (SourceFolderDescriptor it) -> {
      String _path = it.getPath();
      return (_path + "/");
    };
    String _buildPropertiesEntry = this.buildPropertiesEntry("source..", IterableExtensions.<SourceFolderDescriptor, String>map(this.getSourceFolders(), _function));
    _builder.append(_buildPropertiesEntry);
    _builder.newLineIfNotEmpty();
    String _buildPropertiesEntry_1 = this.buildPropertiesEntry("bin.includes", this.getBinIncludes());
    _builder.append(_buildPropertiesEntry_1);
    _builder.newLineIfNotEmpty();
    String _buildPropertiesEntry_2 = this.buildPropertiesEntry("bin.excludes", this.getBinExcludes());
    _builder.append(_buildPropertiesEntry_2);
    _builder.newLineIfNotEmpty();
    String _buildPropertiesEntry_3 = this.buildPropertiesEntry("additional.bundles", this.getDevelopmentBundles());
    _builder.append(_buildPropertiesEntry_3);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public Set<String> getBinIncludes() {
    StringConcatenation _builder = new StringConcatenation();
    String _sourceFolder = this.sourceFolder(Outlet.META_INF);
    _builder.append(_sourceFolder);
    _builder.append("/");
    return CollectionLiterals.<String>newLinkedHashSet(".", _builder.toString());
  }
  
  /**
   * @since 2.11
   */
  public Set<String> getBinExcludes() {
    return CollectionLiterals.<String>newLinkedHashSet("**/*.xtend");
  }
  
  public Set<String> getDevelopmentBundles() {
    return CollectionLiterals.<String>emptySet();
  }
  
  private String buildPropertiesEntry(final String key, final Iterable<String> value) {
    String _xblockexpression = null;
    {
      boolean _isEmpty = IterableExtensions.isEmpty(value);
      if (_isEmpty) {
        return "";
      }
      final String assignment = (key + " = ");
      final String indent = Strings.repeat(" ", assignment.length());
      String _join = IterableExtensions.join(value, (",\\\n" + indent));
      _xblockexpression = (assignment + _join);
    }
    return _xblockexpression;
  }
  
  public String manifest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: ");
    String _name = this.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-Vendor: My Company");
    _builder.newLine();
    _builder.append("Bundle-Version: 1.0.0.qualifier");
    _builder.newLine();
    _builder.append("Bundle-SymbolicName: ");
    String _name_1 = this.getName();
    _builder.append(_name_1);
    _builder.append("; singleton:=true");
    _builder.newLineIfNotEmpty();
    {
      Object _activatorClassName = this.getActivatorClassName();
      boolean _tripleNotEquals = (_activatorClassName != null);
      if (_tripleNotEquals) {
        _builder.append("Bundle-Activator: ");
        Object _activatorClassName_1 = this.getActivatorClassName();
        _builder.append(_activatorClassName_1);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("Bundle-ActivationPolicy: lazy");
    _builder.newLine();
    String _manifestEntry = this.manifestEntry("Require-Bundle", this.getRequiredBundles());
    _builder.append(_manifestEntry);
    _builder.newLineIfNotEmpty();
    String _manifestEntry_1 = this.manifestEntry("Import-Package", this.getImportedPackages());
    _builder.append(_manifestEntry_1);
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-RequiredExecutionEnvironment: ");
    String _bree = this.getBree();
    _builder.append(_bree);
    _builder.newLineIfNotEmpty();
    _builder.append("Automatic-Module-Name: ");
    String _name_2 = this.getName();
    _builder.append(_name_2);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String getBree() {
    return this.config.getJavaVersion().getBree();
  }
  
  private String manifestEntry(final String key, final Iterable<String> value) {
    boolean _isEmpty = IterableExtensions.isEmpty(value);
    if (_isEmpty) {
      return "";
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(key);
    _builder.append(": ");
    String _join = IterableExtensions.join(value, ",\n ");
    _builder.append(_join);
    return _builder.toString();
  }
  
  public Set<String> getRequiredBundles() {
    LinkedHashSet<String> _xblockexpression = null;
    {
      final LinkedHashSet<String> bundles = CollectionLiterals.<String>newLinkedHashSet();
      final Function1<ProjectDescriptor, String> _function = (ProjectDescriptor it) -> {
        return it.getName();
      };
      Iterable<String> _map = IterableExtensions.map(this.getUpstreamProjects(), _function);
      Iterables.<String>addAll(bundles, _map);
      final Function1<ExternalDependency, ExternalDependency.P2Coordinates> _function_1 = (ExternalDependency it) -> {
        return it.getP2();
      };
      final Function1<ExternalDependency.P2Coordinates, Boolean> _function_2 = (ExternalDependency.P2Coordinates it) -> {
        String _bundleId = it.getBundleId();
        return Boolean.valueOf((_bundleId != null));
      };
      final Function1<ExternalDependency.P2Coordinates, String> _function_3 = (ExternalDependency.P2Coordinates it) -> {
        String _bundleId = it.getBundleId();
        String _xifexpression = null;
        String _version = it.getVersion();
        boolean _tripleEquals = (_version == null);
        if (_tripleEquals) {
          _xifexpression = "";
        } else {
          String _version_1 = it.getVersion();
          String _plus = (";bundle-version=\"" + _version_1);
          _xifexpression = (_plus + "\"");
        }
        return (_bundleId + _xifexpression);
      };
      Iterable<String> _map_1 = IterableExtensions.<ExternalDependency.P2Coordinates, String>map(IterableExtensions.<ExternalDependency.P2Coordinates>filter(IterableExtensions.<ExternalDependency, ExternalDependency.P2Coordinates>map(this.getExternalDependencies(), _function_1), _function_2), _function_3);
      Iterables.<String>addAll(bundles, _map_1);
      _xblockexpression = bundles;
    }
    return _xblockexpression;
  }
  
  public Set<String> getImportedPackages() {
    final Function1<ExternalDependency, Set<String>> _function = (ExternalDependency it) -> {
      return it.getP2().getPackages();
    };
    return IterableExtensions.<String>toSet(Iterables.<String>concat(IterableExtensions.<ExternalDependency, Set<String>>map(this.getExternalDependencies(), _function)));
  }
  
  public Set<ExternalDependency> getExternalDependencies() {
    final LinkedHashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newLinkedHashSet();
    Set<EPackageInfo> _ePackageInfos = this.config.getEcore2Xtext().getEPackageInfos();
    for (final EPackageInfo ePackage : _ePackageInfos) {
      ExternalDependency _createBundleDependency = ExternalDependency.createBundleDependency(ePackage.getBundleID());
      deps.add(_createBundleDependency);
    }
    return deps;
  }
  
  public Object getActivatorClassName() {
    return null;
  }
  
  protected boolean isAtLeastJava9() {
    return this.config.getJavaVersion().isAtLeast(JavaVersion.JAVA9);
  }
  
  public GradleBuildFile buildGradle() {
    return new GradleBuildFile(this);
  }
  
  public PomFile pom() {
    return new PomFile(this);
  }
  
  public String sourceFolder(final Outlet outlet) {
    return this.config.getSourceLayout().getPathFor(outlet);
  }
  
  public boolean isTest(final Outlet outlet) {
    return Arrays.<Outlet>asList(Outlet.testOutlets()).contains(outlet);
  }
  
  protected PlainTextFile file(final Outlet outlet, final String relativePath, final CharSequence content) {
    return new PlainTextFile(outlet, relativePath, this, content);
  }
  
  protected PlainTextFile file(final Outlet outlet, final String relativePath, final CharSequence content, final boolean executable) {
    return new PlainTextFile(outlet, relativePath, this, content, executable);
  }
  
  protected BinaryFile binaryFile(final Outlet outlet, final String relativePath, final URL url) {
    return new BinaryFile(outlet, relativePath, this, false, url);
  }
  
  protected boolean isFromExistingEcoreModels() {
    boolean _isEmpty = this.config.getEcore2Xtext().getEPackageInfos().isEmpty();
    return (!_isEmpty);
  }
  
  public ProjectDescriptor(final WizardConfiguration config) {
    super();
    this.config = config;
  }
  
  @Pure
  public WizardConfiguration getConfig() {
    return this.config;
  }
  
  @Pure
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }
}
