/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtend.core.compiler.UnicodeAwarePostProcessor;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Charsets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
public class UnicodeAwarePostProcessorTest extends Assert implements IJvmModelAssociations, ILocationInFileProvider {

	@Inject
	private UnicodeAwarePostProcessor postProcessor;
	
	@Test
	public void testUTF8_plain() {
		CharSequence result = postProcessor.postProcess(URI.createFileURI("com/acme/MyFile.java"), "\u03b1\u03c1\u03b5\u03c4\u03b7", Charsets.UTF_8);
		assertEquals("\u03b1\u03c1\u03b5\u03c4\u03b7", result.toString());
	}
	
	@Test
	public void testISO_8859_1_plain() {
		CharSequence result = postProcessor.postProcess(URI.createFileURI("com/acme/MyFile.java"), "\u03b1\u03c1\u03b5\u03c4\u03b7", Charsets.ISO_8859_1);
		assertEquals("\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7", result.toString());
	}
	
	@Test
	public void testOnlyJavaEscaped() {
		CharSequence result = postProcessor.postProcess(URI.createFileURI("com/acme/MyFile.notJava"), "\u03b1\u03c1\u03b5\u03c4\u03b7", Charsets.ISO_8859_1);
		assertEquals("\u03b1\u03c1\u03b5\u03c4\u03b7", result.toString());
	}
	
	@Test
	public void testUTF8_tree() {
		TreeAppendable treeAppendable = new TreeAppendable(null, null, this, this, EcoreFactory.eINSTANCE.createEObject(), "  ", "\n");
		treeAppendable.append("\u03b1\u03c1\u03b5\u03c4\u03b7");
		CharSequence result = postProcessor.postProcess(URI.createFileURI("com/acme/MyFile.java"), treeAppendable, Charsets.UTF_8);
		assertSame(treeAppendable, result);
		assertEquals("\u03b1\u03c1\u03b5\u03c4\u03b7", result.toString());
	}
	
	@Test
	public void testISO_8859_1_tree() {
		TreeAppendable treeAppendable = new TreeAppendable(null, null, this, this, EcoreFactory.eINSTANCE.createEObject(), "  ", "\n");
		treeAppendable.append("\u03b1\u03c1\u03b5\u03c4\u03b7");
		CharSequence result = postProcessor.postProcess(URI.createFileURI("com/acme/MyFile.java"), treeAppendable, Charsets.ISO_8859_1);
		assertSame(treeAppendable, result);
		assertEquals("\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7", result.toString());
	}

	public Set<EObject> getSourceElements(EObject jvmElement) {
		return Collections.emptySet();
	}

	public Set<EObject> getJvmElements(EObject sourceElement) {
		return Collections.emptySet();
	}

	public EObject getPrimarySourceElement(EObject jvmElement) {
		return null;
	}

	public ITextRegion getSignificantTextRegion(EObject obj) {
		return getDummyTextRegion();
	}

	public ITextRegion getSignificantTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		return getDummyTextRegion();
	}

	private ITextRegion getDummyTextRegion() {
		return new TextRegionWithLineInformation(1, 1, 1, 1);
	}

	public ITextRegion getFullTextRegion(EObject obj) {
		return getDummyTextRegion();
	}

	public ITextRegion getFullTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		return getDummyTextRegion();
	}

	public EObject getPrimaryJvmElement(EObject sourceElement) {
		return null;
	}

	public boolean isPrimaryJvmElement(EObject jvmElement) {
		return false;
	}
}
