package org.eclipse.xtext.generator.trace.node;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor;
import org.eclipse.xtext.generator.trace.node.GeneratorWhiteSpaceConfig;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * Some additional sugar extension to
 *  - create generator nodes for EObjects
 *  - create ILocationData for EObjects.
 *  - enhance FileSystemAccess for tracing
 */
@SuppressWarnings("all")
public class TracingSugar extends GeneratorNodeExtensions {
  @Inject
  protected ILocationInFileProvider locationProvider;
  
  @Inject
  protected ITraceURIConverter traceURIConverter;
  
  @Inject
  protected GeneratorWhiteSpaceConfig whiteSpaceConfig;
  
  @Inject
  protected GeneratorNodeProcessor processor;
  
  /**
   * Convenience extension, to generate traced code.
   */
  public void generateTracedFile(final IFileSystemAccess2 fsa, final String path, final EObject rootTrace, final StringConcatenationClient code) {
    final CompositeGeneratorNode node = this.trace(rootTrace, code);
    this.generateTracedFile(fsa, path, node);
  }
  
  /**
   * Use to generate a file based on generator node.
   */
  public void generateTracedFile(final IFileSystemAccess2 fsa, final String path, final CompositeGeneratorNode rootNode) {
    final GeneratorNodeProcessor.Result result = this.processor.process(rootNode);
    fsa.generateFile(path, result);
  }
  
  /**
   * Convenience shorthand for <code>obj.location.trace</code>
   */
  public CompositeGeneratorNode trace(final EObject obj) {
    return this.trace(this.location(obj));
  }
  
  /**
   * Convenience shorthand for <code>obj.trace.appendTemplate('''some template''')</code>
   */
  public CompositeGeneratorNode trace(final EObject obj, final StringConcatenationClient code) {
    return this.appendTemplate(this.trace(obj), code);
  }
  
  /**
   * @return ILocationData covering the <code>fullTextRegion</code> of the given EObject.
   */
  public ILocationData location(final EObject obj) {
    final ITextRegion region = this.locationProvider.getFullTextRegion(obj);
    final SourceRelativeURI uri = this.traceURIConverter.getURIForTrace(obj.eResource());
    return new LocationData(((ITextRegionWithLineInformation) region), uri);
  }
  
  /**
   * @param obj the EObject containing the feature
   * @param feature the EStructuralFeature to trace
   * @param idx the index of the value to trace, in case the feature contains a list, should be <code>-1</code> otherwise.
   * 
   * @return ILocationData covering the <code>fullTextRegion</code> of the given feature in the given EObject.
   */
  public ILocationData location(final EObject obj, final EStructuralFeature feature, final int idx) {
    final ITextRegion region = this.locationProvider.getFullTextRegion(obj, feature, idx);
    final SourceRelativeURI uri = this.traceURIConverter.getURIForTrace(obj.eResource());
    return new LocationData(((ITextRegionWithLineInformation) region), uri);
  }
}
