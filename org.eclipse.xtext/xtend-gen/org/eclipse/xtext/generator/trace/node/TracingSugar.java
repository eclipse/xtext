package org.eclipse.xtext.generator.trace.node;

import com.google.inject.Inject;
import java.util.stream.IntStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.WhiteSpaceConfig;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class TracingSugar extends GeneratorNodeExtensions {
  @Data
  public static class Result implements CharSequence, ITraceRegionProvider {
    @Delegate
    private final CharSequence contents;
    
    private final AbstractTraceRegion traceRegion;
    
    @Override
    public AbstractTraceRegion getTraceRegion() throws TraceNotFoundException {
      return this.traceRegion;
    }
    
    @Override
    public String toString() {
      return this.contents.toString();
    }
    
    public Result(final CharSequence contents, final AbstractTraceRegion traceRegion) {
      super();
      this.contents = contents;
      this.traceRegion = traceRegion;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.contents== null) ? 0 : this.contents.hashCode());
      result = prime * result + ((this.traceRegion== null) ? 0 : this.traceRegion.hashCode());
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
      TracingSugar.Result other = (TracingSugar.Result) obj;
      if (this.contents == null) {
        if (other.contents != null)
          return false;
      } else if (!this.contents.equals(other.contents))
        return false;
      if (this.traceRegion == null) {
        if (other.traceRegion != null)
          return false;
      } else if (!this.traceRegion.equals(other.traceRegion))
        return false;
      return true;
    }
    
    @Pure
    public CharSequence getContents() {
      return this.contents;
    }
    
    public char charAt(final int index) {
      return this.contents.charAt(index);
    }
    
    public IntStream chars() {
      return this.contents.chars();
    }
    
    public IntStream codePoints() {
      return this.contents.codePoints();
    }
    
    public int length() {
      return this.contents.length();
    }
    
    public CharSequence subSequence(final int start, final int end) {
      return this.contents.subSequence(start, end);
    }
  }
  
  @Inject
  protected ILocationInFileProvider locationProvider;
  
  @Inject
  protected ITraceURIConverter traceURIConverter;
  
  @Inject
  protected WhiteSpaceConfig whiteSpaceConfig;
  
  public void generateTracedFile(final IFileSystemAccess2 fsa, final String path, final EObject rootTrace, final StringConcatenationClient code) {
    final IGeneratorNode node = this.trace(rootTrace, code);
    StringBuilder _stringBuilder = new StringBuilder();
    String _indentationString = this.whiteSpaceConfig.getIndentationString();
    String _lineDelimiter = this.whiteSpaceConfig.getLineDelimiter();
    final GeneratorNodeProcessor proc = new GeneratorNodeProcessor(_stringBuilder, _indentationString, _lineDelimiter);
    proc.process(node);
    StringBuilder _contents = proc.getContents();
    AbstractTraceRegion _currentRegion = proc.getCurrentRegion();
    TracingSugar.Result _result = new TracingSugar.Result(_contents, _currentRegion);
    fsa.generateFile(path, _result);
  }
  
  public void generateTracedFile(final IFileSystemAccess2 fsa, final String path, final CompositeGeneratorNode rootNode) {
    StringBuilder _stringBuilder = new StringBuilder();
    final GeneratorNodeProcessor proc = new GeneratorNodeProcessor(_stringBuilder, "  ", "\n");
    proc.process(rootNode);
    StringBuilder _contents = proc.getContents();
    AbstractTraceRegion _currentRegion = proc.getCurrentRegion();
    TracingSugar.Result _result = new TracingSugar.Result(_contents, _currentRegion);
    fsa.generateFile(path, _result);
  }
  
  public IGeneratorNode trace(final EObject obj, final StringConcatenationClient code) {
    final ITextRegion region = this.locationProvider.getFullTextRegion(obj);
    final SourceRelativeURI uri = this.traceURIConverter.getURIForTrace(obj.eResource());
    final LocationData location = new LocationData(((ITextRegionWithLineInformation) region), uri);
    return this.appendTemplate(this.startTrace(location), code);
  }
  
  public <T extends EObject> IGeneratorNode trace(final T obj, final Function1<? super T, ? extends String> code) {
    final String string = code.apply(obj);
    final ILocationData location = this.location(obj);
    return this.append(this.startTrace(location), string);
  }
  
  public ILocationData location(final EObject obj) {
    final ITextRegion region = this.locationProvider.getFullTextRegion(obj);
    final SourceRelativeURI uri = this.traceURIConverter.getURIForTrace(obj.eResource());
    return new LocationData(((ITextRegionWithLineInformation) region), uri);
  }
  
  public ILocationData location(final EObject obj, final EStructuralFeature feature, final int idx) {
    final ITextRegion region = this.locationProvider.getFullTextRegion(obj, feature, idx);
    final SourceRelativeURI uri = this.traceURIConverter.getURIForTrace(obj.eResource());
    return new LocationData(((ITextRegionWithLineInformation) region), uri);
  }
}
