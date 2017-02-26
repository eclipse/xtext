package org.eclipse.xtext.generator.trace.node

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.trace.AbstractTraceRegion
import org.eclipse.xtext.generator.trace.ITraceRegionProvider
import org.eclipse.xtext.generator.trace.ITraceURIConverter
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.generator.trace.TraceNotFoundException
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions
import org.eclipse.xtext.generator.trace.node.IGeneratorNode
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor
import org.eclipse.xtext.generator.trace.ILocationData
import org.eclipse.emf.ecore.EStructuralFeature

class TracingSugar extends GeneratorNodeExtensions {
	
	@Inject protected ILocationInFileProvider locationProvider
	@Inject protected ITraceURIConverter traceURIConverter
	@Inject protected WhiteSpaceConfig whiteSpaceConfig
	
	def void generateTracedFile(IFileSystemAccess2 fsa, String path, EObject rootTrace, StringConcatenationClient code) {
		val node = trace(rootTrace, code)
		val proc = new GeneratorNodeProcessor(new StringBuilder(), whiteSpaceConfig.indentationString, whiteSpaceConfig.lineDelimiter)
		proc.process(node);
		fsa.generateFile(path, new Result(proc.contents, proc.currentRegion))
	}
	
	def void generateTracedFile(IFileSystemAccess2 fsa, String path, CompositeGeneratorNode rootNode) {
		val proc = new GeneratorNodeProcessor(new StringBuilder(), "  ", "\n")
		proc.process(rootNode);
		fsa.generateFile(path, new Result(proc.contents, proc.currentRegion))
	}
	
	def IGeneratorNode trace(EObject obj, StringConcatenationClient code) {
		val region = locationProvider.getFullTextRegion(obj)
		val uri = traceURIConverter.getURIForTrace(obj.eResource)
		val location = new LocationData(region as ITextRegionWithLineInformation, uri);
		return location.startTrace.appendTemplate(code)
	}
	
	def <T extends EObject> IGeneratorNode trace(T obj, (T)=>String code) {
		val string = code.apply(obj);
		val location = location(obj);
		return location.startTrace.append(string)
	}
	
	def ILocationData location(EObject obj) {
		val region = locationProvider.getFullTextRegion(obj)
		val uri = traceURIConverter.getURIForTrace(obj.eResource)
		return new LocationData(region as ITextRegionWithLineInformation, uri);
	}
	
	def ILocationData location(EObject obj, EStructuralFeature feature, int idx) {
		val region = locationProvider.getFullTextRegion(obj, feature, idx)
		val uri = traceURIConverter.getURIForTrace(obj.eResource)
		return new LocationData(region as ITextRegionWithLineInformation, uri);
	}
	
	@Data static class Result implements CharSequence, ITraceRegionProvider {
		@Delegate CharSequence contents
		AbstractTraceRegion traceRegion
		
		override getTraceRegion() throws TraceNotFoundException {
			return traceRegion
		}
		
		override toString() {
			contents.toString()
		}
	}
}
