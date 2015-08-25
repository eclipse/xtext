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
        String _get = parts[0];
        this.groupId = _get;
        String _get_1 = parts[1];
        this.artifactId = _get_1;
        String _get_2 = parts[2];
        _xblockexpression = this.version = _get_2;
      }
      return _xblockexpression;
    }
    
    private Scope scope = Scope.COMPILE;
    
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
    final Procedure1<ExternalDependency> _function = new Procedure1<ExternalDependency>() {
      @Override
      public void apply(final ExternalDependency it) {
        it.p2.bundleId = xtextBundle;
        final Procedure1<ExternalDependency.MavenCoordinates> _function = new Procedure1<ExternalDependency.MavenCoordinates>() {
          @Override
          public void apply(final ExternalDependency.MavenCoordinates it) {
            it.groupId = "org.eclipse.xtext";
            it.artifactId = xtextBundle;
            it.version = "${xtextVersion}";
          }
        };
        it.maven(_function);
      }
    };
    return ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency, _function);
  }
  
  public static ExternalDependency createMavenDependency(final String shortNotation) {
    ExternalDependency _externalDependency = new ExternalDependency();
    final Procedure1<ExternalDependency> _function = new Procedure1<ExternalDependency>() {
      @Override
      public void apply(final ExternalDependency it) {
        it.maven.setShortNotation(shortNotation);
      }
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
