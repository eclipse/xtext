package org.eclipse.xtext.idea.build.incremental;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.idea.build.XtextIdeaRefreshComponent;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.ProjectPaths;
import org.jetbrains.jps.cmdline.ProjectDescriptor;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.CompilerEncodingConfiguration;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;
import org.jetbrains.jps.model.JpsUrlList;
import org.jetbrains.jps.model.module.JpsModule;

@Data
@SuppressWarnings("all")
public class IdeaBuildData {
  private final String compilerName;
  
  private final CompileContext context;
  
  private final ModuleChunk chunk;
  
  private final ModuleLevelBuilder.OutputConsumer outputConsumer;
  
  private final XtextIdeaRefreshComponent refreshComponent;
  
  public JpsModule getModule() {
    Set<JpsModule> _modules = this.chunk.getModules();
    return IterableExtensions.<JpsModule>head(_modules);
  }
  
  public Collection<File> getClasspath() {
    return ProjectPaths.getCompilationClasspath(this.chunk, false);
  }
  
  public Set<File> getSourceRoots() {
    Map<File, String> _sourceRootsWithDependents = ProjectPaths.getSourceRootsWithDependents(this.chunk);
    return _sourceRootsWithDependents.keySet();
  }
  
  public String getEncoding() {
    ProjectDescriptor _projectDescriptor = this.context.getProjectDescriptor();
    CompilerEncodingConfiguration _encodingConfiguration = _projectDescriptor.getEncodingConfiguration();
    return _encodingConfiguration.getPreferredModuleChunkEncoding(this.chunk);
  }
  
  public String getBaseDir() {
    JpsModule _module = this.getModule();
    JpsUrlList _contentRootsList = _module.getContentRootsList();
    List<String> _urls = _contentRootsList.getUrls();
    final Function1<String, URI> _function = new Function1<String, URI>() {
      @Override
      public URI apply(final String it) {
        return URI.createURI(it);
      }
    };
    List<URI> _map = ListExtensions.<String, URI>map(_urls, _function);
    final Function1<URI, Boolean> _function_1 = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        return Boolean.valueOf(it.isFile());
      }
    };
    URI _findFirst = IterableExtensions.<URI>findFirst(_map, _function_1);
    return _findFirst.path();
  }
  
  public IdeaBuildData(final String compilerName, final CompileContext context, final ModuleChunk chunk, final ModuleLevelBuilder.OutputConsumer outputConsumer, final XtextIdeaRefreshComponent refreshComponent) {
    super();
    this.compilerName = compilerName;
    this.context = context;
    this.chunk = chunk;
    this.outputConsumer = outputConsumer;
    this.refreshComponent = refreshComponent;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.compilerName== null) ? 0 : this.compilerName.hashCode());
    result = prime * result + ((this.context== null) ? 0 : this.context.hashCode());
    result = prime * result + ((this.chunk== null) ? 0 : this.chunk.hashCode());
    result = prime * result + ((this.outputConsumer== null) ? 0 : this.outputConsumer.hashCode());
    result = prime * result + ((this.refreshComponent== null) ? 0 : this.refreshComponent.hashCode());
    return result;
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
    IdeaBuildData other = (IdeaBuildData) obj;
    if (this.compilerName == null) {
      if (other.compilerName != null)
        return false;
    } else if (!this.compilerName.equals(other.compilerName))
      return false;
    if (this.context == null) {
      if (other.context != null)
        return false;
    } else if (!this.context.equals(other.context))
      return false;
    if (this.chunk == null) {
      if (other.chunk != null)
        return false;
    } else if (!this.chunk.equals(other.chunk))
      return false;
    if (this.outputConsumer == null) {
      if (other.outputConsumer != null)
        return false;
    } else if (!this.outputConsumer.equals(other.outputConsumer))
      return false;
    if (this.refreshComponent == null) {
      if (other.refreshComponent != null)
        return false;
    } else if (!this.refreshComponent.equals(other.refreshComponent))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("compilerName", this.compilerName);
    b.add("context", this.context);
    b.add("chunk", this.chunk);
    b.add("outputConsumer", this.outputConsumer);
    b.add("refreshComponent", this.refreshComponent);
    return b.toString();
  }
  
  @Pure
  public String getCompilerName() {
    return this.compilerName;
  }
  
  @Pure
  public CompileContext getContext() {
    return this.context;
  }
  
  @Pure
  public ModuleChunk getChunk() {
    return this.chunk;
  }
  
  @Pure
  public ModuleLevelBuilder.OutputConsumer getOutputConsumer() {
    return this.outputConsumer;
  }
  
  @Pure
  public XtextIdeaRefreshComponent getRefreshComponent() {
    return this.refreshComponent;
  }
}
