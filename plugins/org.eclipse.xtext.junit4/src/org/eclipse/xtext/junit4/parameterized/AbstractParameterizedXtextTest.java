/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.junit4.serializer.SerializerTester;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(ParameterizedXtextRunner.class)
public class AbstractParameterizedXtextTest {

	protected final static int LINE_WIDTH = 80;

	protected int offset;

	protected XtextResource resource;

	@Inject
	protected IScopeProvider scopeProvider;

	@Inject
	protected SerializerTester serializerTester;

	@Inject
	protected ValidationTestHelper validationHelper;

	public AbstractParameterizedXtextTest(XtextResource resource, int offset, String[] params) {
		super();
		this.resource = resource;
		this.offset = offset;
	}

	protected String formatIssue(Issue issue) {
		StringBuilder result = new StringBuilder();
		result.append(issue.getSeverity().name().toLowerCase());
		if (issue.getOffset() != null && issue.getLength() != null) {
			result.append(" at '");
			result.append(resource.getParseResult().getRootNode().getText()
					.substring(issue.getOffset(), issue.getOffset() + issue.getLength()));
			result.append("' ");
		} else
			result.append(" ");
		result.append("message '");
		result.append(issue.getMessage());
		result.append("'");
		return result.toString();
	}

	protected EObject getEObjectAtOffset() {
		EObject object = NodeModelUtils.findActualSemanticObjectFor(getLeafNodeAtOffset());
		assertNotNull("No EObject found at offset " + offset, object);
		return object;
	}

	protected Pair<EObject, EStructuralFeature> getEStructuralFeatureAtOffset() {
		INode leaf = getLeafNodeAtOffset();
		assertTrue(leaf.getGrammarElement() instanceof AbstractElement);
		EObject object = NodeModelUtils.findActualSemanticObjectFor(leaf);
		assertNotNull("No EObject found at offset " + offset, object);
		Assignment ass = GrammarUtil.containingAssignment(leaf.getGrammarElement());
		while (ass == null && leaf.getParent() != null) {
			leaf = leaf.getParent();
			ass = GrammarUtil.containingAssignment(leaf.getGrammarElement());
		}
		assertNotNull("No Assignment found at offset " + offset, ass);
		@SuppressWarnings("null")
		EStructuralFeature feature = object.eClass().getEStructuralFeature(ass.getFeature());
		return Tuples.create(object, feature);
	}

	protected ILeafNode getLeafNodeAtOffset() {
		ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
		assertNotNull("No Leaf Node found at offset " + offset, node);
		return node;
	}

	@Test
	public void noValidationErrors() {
		validationHelper.assertNoErrors(resource.getContents().get(0));
	}

	@Test
	public void noValidationIssues() {
		validationHelper.assertNoErrors(resource.getContents().get(0));
	}

	@TestAsCommaSeparatedValues()
	public List<String> scopeAllElements() {
		Pair<EObject, EStructuralFeature> objAndFeature = getEStructuralFeatureAtOffset();
		assertTrue(objAndFeature.getSecond() instanceof EReference);
		assertFalse(((EReference) objAndFeature.getSecond()).isContainment());
		IScope scope = scopeProvider.getScope(objAndFeature.getFirst(), (EReference) objAndFeature.getSecond());
		List<String> result = Lists.newArrayList();
		for (IEObjectDescription desc : scope.getAllElements())
			result.add(desc.getName().toString());
		return result;
	}

	@Test
	public void serializeable() throws Exception {
		EObject obj = getEObjectAtOffset();
		serializerTester.assertSerializeWithNodeModel(obj);
		serializerTester.assertSerializeWithoutNodeModel(obj);
	}

	@Test
	public void serializeableWithNodeModel() throws Exception {
		serializerTester.assertSerializeWithNodeModel(getEObjectAtOffset());
	}

	@Test
	public void serializeableWithoutNodeModel() throws Exception {
		serializerTester.assertSerializeWithoutNodeModel(getEObjectAtOffset());
	}

	protected List<Issue> validateResource() {
		IResourceValidator validator = resource.getResourceServiceProvider().get(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		return issues;
	}

	@TestAsLines()
	public List<String> validationErrors() {
		List<String> result = Lists.newArrayList();
		for (Issue issue : validateResource())
			if (issue.getSeverity() == Severity.ERROR)
				result.add(formatIssue(issue));
		return result;
	}

	@TestAsLines()
	public List<String> validationIssues() {
		List<String> result = Lists.newArrayList();
		for (Issue issue : validateResource())
			result.add(formatIssue(issue));
		return result;
	}

}
