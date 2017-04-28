package org.eclipse.xtext.generator.trace.node

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.trace.ILocationData
import org.eclipse.xtext.generator.trace.ITraceURIConverter
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.util.ITextRegionWithLineInformation

/**
 * Some additional sugar extension to 
 *  - create generator nodes for EObjects 
 *  - create ILocationData for EObjects.
 *  - enhance FileSystemAccess for tracing
 */
class TracingSugar extends GeneratorNodeExtensions {
	
	@Inject protected ILocationInFileProvider locationProvider
	@Inject protected ITraceURIConverter traceURIConverter
	@Inject protected GeneratorWhiteSpaceConfig whiteSpaceConfig
	@Inject protected GeneratorNodeProcessor processor
	
	/**
	 * Convenience extension, to generate traced code.
	 */
	def void generateTracedFile(IFileSystemAccess2 fsa, String path, EObject rootTrace, StringConcatenationClient code) {
		val node = trace(rootTrace, code)
		generateTracedFile(fsa, path, node)
	}
	
	/**
	 * Use to generate a file based on generator node.
	 */
	def void generateTracedFile(IFileSystemAccess2 fsa, String path, CompositeGeneratorNode rootNode) {
		val result = processor.process(rootNode)
		fsa.generateFile(path, result)
	}
	
	/**
	 * Convenience shorthand for <code>obj.location.trace</code>
	 */
	def CompositeGeneratorNode trace(EObject obj) {
		return obj.location.trace
	}
	
	/**
	 * Convenience shorthand for <code>obj.trace.appendTemplate('''some template''')</code>
	 */
	def CompositeGeneratorNode trace(EObject obj, StringConcatenationClient code) {
		return obj.trace.appendTemplate(code)
	}
	
	/**
	 * @return ILocationData covering the <code>fullTextRegion</code> of the given EObject.
	 */
	def ILocationData location(EObject obj) {
		val region = locationProvider.getFullTextRegion(obj)
		val uri = traceURIConverter.getURIForTrace(obj.eResource)
		return new LocationData(region as ITextRegionWithLineInformation, uri)
	}
	
	/**
	 * @param obj the EObject containing the feature
	 * @param feature the EStructuralFeature to trace
	 * @param idx the index of the value to trace, in case the feature contains a list, should be <code>-1</code> otherwise.
	 *  
	 * @return ILocationData covering the <code>fullTextRegion</code> of the given feature in the given EObject.
	 */
	def ILocationData location(EObject obj, EStructuralFeature feature, int idx) {
		val region = locationProvider.getFullTextRegion(obj, feature, idx)
		val uri = traceURIConverter.getURIForTrace(obj.eResource)
		return new LocationData(region as ITextRegionWithLineInformation, uri)
	}
	
}
