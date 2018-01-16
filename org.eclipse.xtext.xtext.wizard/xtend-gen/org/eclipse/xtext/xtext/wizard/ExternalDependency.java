/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.Scope;

@Accessors
@SuppressWarnings("all")
public class ExternalDependency {
  @Accessors
  public static class MavenCoordinates {
    private String groupId;
    
    private String artifactId;
    
    private String version;
    
    public String setShortNotation(final String shortNotation) {
      String _xblockexpression = null;
      {
        final String[] parts = shortNotation.split(":");
        this.groupId = parts[0];
        this.artifactId = parts[1];
        _xblockexpression = this.version = parts[2];
      }
      return _xblockexpression;
    }
    
    private Scope scope = Scope.COMPILE;
    
    private boolean optional = false;
    
    @Pure
    public String getGroupId() {
      return this.groupId;
    }
    
    public void setGroupId(final String groupId) {
      this.groupId = groupId;
    }
    
    @Pure
    public String getArtifactId() {
      return this.artifactId;
    }
    
    public void setArtifactId(final String artifactId) {
      this.artifactId = artifactId;
    }
    
    @Pure
    public String getVersion() {
      return this.version;
    }
    
    public void setVersion(final String version) {
      this.version = version;
    }
    
    @Pure
    public Scope getScope() {
      return this.scope;
    }
    
    public void setScope(final Scope scope) {
      this.scope = scope;
    }
    
    @Pure
    public boolean isOptional() {
      return this.optional;
    }
    
    public void setOptional(final boolean optional) {
      this.optional = optional;
    }
  }
  
  @Accessors
  public static class P2Coordinates {
    private String bundleId;
    
    private String version;
    
    private Set<String> packages = CollectionLiterals.<String>newHashSet();
    
    @Pure
    public String getBundleId() {
      return this.bundleId;
    }
    
    public void setBundleId(final String bundleId) {
      this.bundleId = bundleId;
    }
    
    @Pure
    public String getVersion() {
      return this.version;
    }
    
    public void setVersion(final String version) {
      this.version = version;
    }
    
    @Pure
    public Set<String> getPackages() {
      return this.packages;
    }
    
    public void setPackages(final Set<String> packages) {
      this.packages = packages;
    }
  }
  
  public static ExternalDependency createXtextDependency(final String xtextBundle) {
    ExternalDependency _externalDependency = new ExternalDependency();
    final Procedure1<ExternalDependency> _function = (ExternalDependency it) -> {
      it.p2.bundleId = xtextBundle;
      final Procedure1<ExternalDependency.MavenCoordinates> _function_1 = (ExternalDependency.MavenCoordinates it_1) -> {
        it_1.groupId = "org.eclipse.xtext";
        it_1.artifactId = xtextBundle;
        it_1.version = "${xtextVersion}";
      };
      it.maven(_function_1);
    };
    return ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency, _function);
  }
  
  public static ExternalDependency createMavenDependency(final String shortNotation) {
    ExternalDependency _externalDependency = new ExternalDependency();
    final Procedure1<ExternalDependency> _function = (ExternalDependency it) -> {
      it.maven.setShortNotation(shortNotation);
    };
    return ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency, _function);
  }
  
  public static ExternalDependency createBundleDependency(final String bundleId) {
    ExternalDependency _externalDependency = new ExternalDependency();
    final Procedure1<ExternalDependency> _function = (ExternalDependency it) -> {
      it.p2.bundleId = bundleId;
    };
    return ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency, _function);
  }
  
  private final ExternalDependency.MavenCoordinates maven = new ExternalDependency.MavenCoordinates();
  
  private final ExternalDependency.P2Coordinates p2 = new ExternalDependency.P2Coordinates();
  
  public void maven(final Procedure1<? super ExternalDependency.MavenCoordinates> config) {
    config.apply(this.maven);
  }
  
  public void p2(final Procedure1<? super ExternalDependency.P2Coordinates> config) {
    config.apply(this.p2);
  }
  
  @Pure
  public ExternalDependency.MavenCoordinates getMaven() {
    return this.maven;
  }
  
  @Pure
  public ExternalDependency.P2Coordinates getP2() {
    return this.p2;
  }
}
