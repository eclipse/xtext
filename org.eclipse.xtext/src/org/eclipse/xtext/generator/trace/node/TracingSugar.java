/**
 * Copyright (c) 2017, 2020 TypeFox (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

import com.google.inject.Inject;

/**
 * Some additional sugar extension to - create generator nodes for EObjects - create ILocationData for EObjects. -
 * enhance FileSystemAccess for tracing
 */
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
	public void generateTracedFile(IFileSystemAccess2 fsa, String path, EObject rootTrace,
			StringConcatenationClient code) {
		CompositeGeneratorNode node = trace(rootTrace, code);
		generateTracedFile(fsa, path, node);
	}

	/**
	 * Use to generate a file based on generator node.
	 */
	public void generateTracedFile(IFileSystemAccess2 fsa, String path, CompositeGeneratorNode rootNode) {
		GeneratorNodeProcessor.Result result = processor.process(rootNode);
		fsa.generateFile(path, result);
	}

	/**
	 * Convenience shorthand for <code>obj.location.trace</code>
	 */
	public CompositeGeneratorNode trace(EObject obj) {
		return trace(location(obj));
	}

	/**
	 * Convenience shorthand for <code>obj.trace.appendTemplate('''some template''')</code>
	 */
	public CompositeGeneratorNode trace(EObject obj, StringConcatenationClient code) {
		return appendTemplate(trace(obj), code);
	}

	/**
	 * @return ILocationData covering the <code>fullTextRegion</code> of the given EObject.
	 */
	public ILocationData location(EObject obj) {
		ITextRegion region = locationProvider.getFullTextRegion(obj);
		SourceRelativeURI uri = traceURIConverter.getURIForTrace(obj.eResource());
		return new LocationData((ITextRegionWithLineInformation) region, uri);
	}

	/**
	 * @param obj
	 *            the EObject containing the feature
	 * @param feature
	 *            the EStructuralFeature to trace
	 * @param idx
	 *            the index of the value to trace, in case the feature contains a list, should be <code>-1</code>
	 *            otherwise.
	 * 
	 * @return ILocationData covering the <code>fullTextRegion</code> of the given feature in the given EObject.
	 */
	public ILocationData location(EObject obj, EStructuralFeature feature, int idx) {
		ITextRegion region = locationProvider.getFullTextRegion(obj, feature, idx);
		SourceRelativeURI uri = traceURIConverter.getURIForTrace(obj.eResource());
		return new LocationData((ITextRegionWithLineInformation) region, uri);
	}
}
