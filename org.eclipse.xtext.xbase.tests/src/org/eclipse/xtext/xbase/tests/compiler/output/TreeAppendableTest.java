/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler.output;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.AbstractIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TreeAppendableTest extends Assert implements ILocationInFileProvider, IJvmModelAssociations, ITraceURIConverter {

	private Iterator<ITextRegionWithLineInformation> expectedRegions;
	private EClass content;
	private Resource resource;

	@Override
	public ITextRegionWithLineInformation getSignificantTextRegion(/* @Nullable */ EObject obj) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public ITextRegionWithLineInformation getSignificantTextRegion(/* @Nullable */ EObject owner, /* @Nullable */ EStructuralFeature feature, int indexInList) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ITextRegionWithLineInformation getFullTextRegion(/* @Nullable */ EObject obj) {
		return expectedRegions.next();
	}

	@Override
	public ITextRegionWithLineInformation getFullTextRegion(/* @Nullable */ EObject owner, /* @Nullable */ EStructuralFeature feature, int indexInList) {
		throw new UnsupportedOperationException();
	}

	@Before
	public void createResource() {
		content = EcoreFactory.eINSTANCE.createEClass();
		resource = new XtextResource(URI.createURI("platform:/resource/test"));
		resource.getContents().add(content);
	}
	
	@After
	public void clearFields() {
		content = null;
		resource = null;
		if (expectedRegions != null) {
			assertFalse(expectedRegions.hasNext());
		}
	}
	
	@Test
	public void testEmpty() {
		expectedRegions = Collections.<ITextRegionWithLineInformation>singleton(new TextRegionWithLineInformation(47, 11, 12, 137)).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		assertEquals("", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertNotNull(traceRegion);
		assertEquals(47, traceRegion.getMergedAssociatedLocation().getOffset());
		assertEquals(11, traceRegion.getMergedAssociatedLocation().getLength());
		assertEquals(getURIForTrace(resource), traceRegion.getAssociatedSrcRelativePath());
		assertTrue(traceRegion.getNestedRegions().isEmpty());
	}
	
	@Test
	public void testNoRedundantRegions() {
		ITextRegionWithLineInformation redundant = new TextRegionWithLineInformation(47, 11, 12, 137);
		ITextRegionWithLineInformation second = new TextRegionWithLineInformation(8, 15, 12, 137);
		expectedRegions = Arrays.asList(redundant, redundant, second).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		appendable.append("initial");
		appendable.trace(content).append("first");
		appendable.trace(content).append("second");
		assertEquals("initialfirstsecond", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertNotNull(traceRegion);
		assertEquals(47, traceRegion.getMergedAssociatedLocation().getOffset());
		assertEquals(11, traceRegion.getMergedAssociatedLocation().getLength());
		assertEquals(0, traceRegion.getMyOffset());
		assertEquals("initialfirstsecond".length(), traceRegion.getMyLength());
		List<AbstractTraceRegion> nestedRegions = traceRegion.getNestedRegions();
		assertEquals(1, nestedRegions.size());
		AbstractTraceRegion child = nestedRegions.get(0);
		assertEquals(8, child.getMergedAssociatedLocation().getOffset());
		assertEquals(15, child.getMergedAssociatedLocation().getLength());
		assertEquals("initialfirst".length(), child.getMyOffset());
		assertEquals("second".length(), child.getMyLength());
	}
	
	@Test
	public void testNoEmptyLeafs() {
		ITextRegionWithLineInformation root = new TextRegionWithLineInformation(47, 11, 12, 137);
		ITextRegionWithLineInformation emptyChild = new TextRegionWithLineInformation(8, 15, 12, 137);
		ITextRegionWithLineInformation emptyGrandChild = new TextRegionWithLineInformation(123, 321, 12, 137);
		expectedRegions = Arrays.asList(root, emptyChild, emptyGrandChild).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		appendable.append("initial");
		appendable.trace(content).trace(content);
		appendable.append("end");
		assertEquals("initialend", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertTrue(traceRegion.getNestedRegions().isEmpty());
	}
	
	@Test
	public void testIntermediatesMayBeEmpty() {
		ITextRegionWithLineInformation root = new TextRegionWithLineInformation(47, 11, 12, 137);
		ITextRegionWithLineInformation emptyChild = new TextRegionWithLineInformation(8, 15, 12, 137);
		ITextRegionWithLineInformation emptyGrandChild = new TextRegionWithLineInformation(123, 321, 12, 137);
		expectedRegions = Arrays.asList(root, emptyChild, emptyGrandChild).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		appendable.trace(content).trace(content).append("text");
		assertEquals("text", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertEquals(1, traceRegion.getNestedRegions().size());
		AbstractTraceRegion child = traceRegion.getNestedRegions().get(0);
		assertEquals(1, child.getNestedRegions().size());
		AbstractTraceRegion grandChild = child.getNestedRegions().get(0);
		assertTrue(grandChild.getNestedRegions().isEmpty());
		assertEquals(0, grandChild.getMyOffset());
		assertEquals(4, grandChild.getMyLength());
		assertEquals(123, grandChild.getMergedAssociatedLocation().getOffset());
		assertEquals(321, grandChild.getMergedAssociatedLocation().getLength());
	}
	
	@Test
	public void testInsertionIsProhibited() {
		ITextRegionWithLineInformation root = new TextRegionWithLineInformation(47, 11, 12, 137);
		ITextRegionWithLineInformation child = new TextRegionWithLineInformation(8, 15, 12, 137);
		expectedRegions = Arrays.asList(root, child).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		TreeAppendable traced = appendable.trace(content);
		appendable.append("test");
		// don't use @Test(expected=..) since we want to be sure about the cause
		try {
			traced.append("insertion");
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test
	public void testUnsafeInsertionIsOk() {
		ITextRegionWithLineInformation root = new TextRegionWithLineInformation(47, 11, 12, 137);
		ITextRegionWithLineInformation child = new TextRegionWithLineInformation(8, 15, 12, 137);
		expectedRegions = Arrays.asList(root, child).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		TreeAppendable traced = appendable.trace(content);
		appendable.append("test");
		traced.appendUnsafe("insertion");
		assertEquals("insertiontest", appendable.getContent());
	}
	
	@Test
	public void testTracesAreTrimmed() {
		ITextRegionWithLineInformation root = new TextRegionWithLineInformation(47, 11, 12, 137);
		ITextRegionWithLineInformation child = new TextRegionWithLineInformation(8, 15, 12, 137);
		expectedRegions = Arrays.asList(root, child).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		appendable.append("  some value  ");
		appendable.trace(content).newLine().append("  more value  ").newLine();
		appendable.append("  trailing value  ");
		String content = appendable.getContent();
		assertEquals(
				"  some value  \n" +
				"  more value  \n" +
				"  trailing value  ", content);
		AbstractTraceRegion rootTraceRegion = appendable.getTraceRegion();
		assertEquals(0, rootTraceRegion.getMyOffset());
		assertEquals(content.length(), rootTraceRegion.getMyLength());
		assertEquals(0, rootTraceRegion.getMyLineNumber());
		assertEquals(2, rootTraceRegion.getMyEndLineNumber());
		assertEquals(1, rootTraceRegion.getNestedRegions().size());
		
		AbstractTraceRegion childTraceRegion = rootTraceRegion.getNestedRegions().get(0);
		assertEquals(content.indexOf("more value"), childTraceRegion.getMyOffset());
		assertEquals("more value".length(), childTraceRegion.getMyLength());
		assertEquals(1, childTraceRegion.getMyLineNumber());
		assertEquals(1, childTraceRegion.getMyEndLineNumber());
		assertEquals(0, childTraceRegion.getNestedRegions().size());
	}
	
	@Test
	public void testLineNumbers() {
		expectedRegions = new AbstractIterator<ITextRegionWithLineInformation>() {
			int start = 0;
			@Override
			protected ITextRegionWithLineInformation computeNext() {
				return new TextRegionWithLineInformation(start++, 1, 1, 1);
			}
		};
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "  ", "\n");
		appendable.append("start line").increaseIndentation();
		appendable.newLine().trace(content).append("1");
		appendable.trace(content).newLine().append("2");
		appendable.newLine().trace(content).append("3\n4");
		appendable.decreaseIndentation().newLine().append("last line");
		assertEquals(
				"start line\n" +
				"  1\n" +
				"  2\n" +
				"  3\n" +
				"  4\n" +
				"last line", appendable.getContent());
		AbstractTraceRegion rootTraceRegion = appendable.getTraceRegion();
		assertEquals(0, rootTraceRegion.getMyLineNumber());
		assertEquals(5, rootTraceRegion.getMyEndLineNumber());
		AbstractTraceRegion firstChild = rootTraceRegion.getNestedRegions().get(0);
		assertEquals(1, firstChild.getMyLineNumber());
		assertEquals(1, firstChild.getMyEndLineNumber());
		AbstractTraceRegion secondChild = rootTraceRegion.getNestedRegions().get(1);
		assertEquals(2, secondChild.getMyLineNumber());
		assertEquals(2, secondChild.getMyEndLineNumber());
		AbstractTraceRegion thirdChild = rootTraceRegion.getNestedRegions().get(2);
		assertEquals(3, thirdChild.getMyLineNumber());
		assertEquals(4, thirdChild.getMyEndLineNumber());
		expectedRegions = null;
	}
	
	@Test
	public void testNewlineIndents() {
		expectedRegions = Collections.<ITextRegionWithLineInformation>singleton(ITextRegionWithLineInformation.EMPTY_REGION).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "aa", "bb");
		assertEquals("bb", appendable.newLine().getContent());
		appendable.increaseIndentation();
		assertEquals("bbbbaa", appendable.newLine().getContent());
		appendable.decreaseIndentation();
		assertEquals("bbbbaabb", appendable.newLine().getContent());
	}

	@Test
	public void testAppendedTextIsIndented() {
		expectedRegions = Collections.<ITextRegionWithLineInformation>singleton(ITextRegionWithLineInformation.EMPTY_REGION).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, this, this, content, "aa", "bb");
		appendable.increaseIndentation();
		appendable.append("my \n text \r more \r\n end");
		assertEquals("my bbaa text bbaa more bbaa end", appendable.getContent());
	}

	@Override
	public Set<EObject> getSourceElements(EObject jvmElement) {
		return Collections.emptySet();
	}

	@Override
	public Set<EObject> getJvmElements(EObject sourceElement) {
		return Collections.emptySet();
	}

	@Override
	public EObject getPrimarySourceElement(EObject jvmElement) {
		return null;
	}
	
	@Override
	public SourceRelativeURI getURIForTrace(IProjectConfig projectConfig, AbsoluteURI qualifiedURI) {
		return new SourceRelativeURI(URI.createURI(qualifiedURI.getURI().path()));
	}
	
	@Override
	public SourceRelativeURI getURIForTrace(Resource resource) {
		return SourceRelativeURI.fromAbsolute(resource.getURI());
	}

	@Override
	public EObject getPrimaryJvmElement(EObject sourceElement) {
		return null;
	}

	@Override
	public boolean isPrimaryJvmElement(EObject jvmElement) {
		return false;
	}
	
}
