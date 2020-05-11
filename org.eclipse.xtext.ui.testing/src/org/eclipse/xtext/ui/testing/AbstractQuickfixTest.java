/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author miklossy - Initial contribution and API
 * @since 2.16
 */
public abstract class AbstractQuickfixTest extends AbstractEditorTest {

	private static class TestModificationContext implements IModificationContext {

		private IXtextDocument document;

		@Override
		public IXtextDocument getXtextDocument() {
			return document;
		}

		@Override
		public IXtextDocument getXtextDocument(URI uri) {
			return document;
		}

		public IXtextDocument setDocument(IXtextDocument document) {
			this.document = document;
			return document;
		}
	}

	protected static class Quickfix {

		private final String label;

		private final String description;

		private final String result;

		public Quickfix(String label, String description, String result) {
			this.label = label;
			this.description = description;
			this.result = result;
		}

		public String getLabel() {
			return label;
		}

		public String getDescription() {
			return description;
		}

		public String getResult() {
			return result;
		}

		@Override
		public int hashCode() {
			int prime = 31;
			int result = 1;
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			return prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AbstractQuickfixTest.Quickfix other = (AbstractQuickfixTest.Quickfix) obj;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (result == null) {
				if (other.result != null)
					return false;
			} else if (!result.equals(other.result))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "label: " + label + ", description: " + description + ", result: " + result;
		}
	}

	@Inject
	protected Injector injector;

	@Inject
	protected IResourceSetProvider resourceSetProvider;

	@Inject
	protected IResourceValidator resourceValidator;

	@Inject
	protected FileExtensionProvider fileExtensionProvider;

	@Inject
	protected IssueResolutionProvider issueResolutionProvider;

	protected IProject project;

	/**
	 * Test that the expected quickfixes are offered on a given validation issue in a given DSL text.
	 * 
	 * @param content
	 *            The initial DSL text.
	 * @param issueCode
	 *            The code of the validation issue to that the offered quickfixes are to test.
	 * @param quickfixes
	 *            The quickfixes that are expected to be offered on the given <code>issueCode</code>. Each expected quickfix should be
	 *            described by the following triple:
	 *            <ol>
	 *            <li>the quickfix label</li>
	 *            <li>the quickfix description</li>
	 *            <li>the DSL text after the quickfix application</li>
	 *            </ol>
	 */
	public void testQuickfixesOn(CharSequence content, String issueCode, AbstractQuickfixTest.Quickfix... quickfixes) {
		IFile dslFile = dslFile(getProjectName(), getFileName(), getFileExtension(), content);
		this.project = dslFile.getProject();
		quickfixesAreOffered(openInEditor(dslFile), issueCode, quickfixes);
	}

	protected String getProjectName() {
		return "QuickfixTestProject";
	}

	protected String getFileName() {
		return "quickfix";
	}

	protected String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}

	protected XtextEditor openInEditor(IFile dslFile) {
		IResourcesSetupUtil.waitForBuild();
		try {
			return openEditor(dslFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void quickfixesAreOffered(XtextEditor editor, String issueCode, Quickfix... expected) {
		List<Quickfix> expectedSorted = Arrays.asList(expected);
		expectedSorted.sort(Comparator.comparing(e -> e.getLabel()));

		IXtextDocument document = editor.getDocument();
		String originalText = document.get();
		Issue issue = getValidationIssue(document, issueCode);

		List<IssueResolution> actualIssueResolutions = issueResolutionProvider.getResolutions(issue);
		actualIssueResolutions.sort(Comparator.comparing(i -> i.getLabel()));
		assertEquals("The number of quickfixes does not match!", expectedSorted.size(), actualIssueResolutions.size());

		for (int i = 0; i < actualIssueResolutions.size(); i++) {
			IssueResolution actualIssueResolution = actualIssueResolutions.get(i);
			Quickfix expectedIssueResolution = expectedSorted.get(i);
			assertEquals(expectedIssueResolution.label, actualIssueResolution.getLabel());
			assertEquals(expectedIssueResolution.description, actualIssueResolution.getDescription());
			assertIssueResolutionResult(expectedIssueResolution.result, actualIssueResolution, originalText);
		}
	}

	protected Issue getValidationIssue(IXtextDocument document, String issueCode) {
		List<Issue> issueCandidates = document
				.readOnly(state -> resourceValidator.validate(state, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)) //
				.stream() //
				.filter(issue -> issue.getCode().equals(issueCode)) //
				.collect(Collectors.toList());
		assertEquals("There should be one '" + issueCode + "' validation issue!", 1, issueCandidates.size());
		return issueCandidates.get(0);
	}

	/**
	 * @since 2.22
	 */
	protected List<Issue> getAllValidationIssues(IXtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			@Override
			public List<Issue> exec(XtextResource state) throws Exception {
				return resourceValidator.validate(state, CheckMode.ALL, null);
			}
		});
	}

	protected void assertIssueResolutionResult(String expectedResult, IssueResolution actualIssueResolution, String originalText) {
		/*
		 * Manually create an IModificationContext with an XtextDocument and call the
		 * apply method of the actualIssueResolution with that IModificationContext
		 */
		IXtextDocument document = getDocument(originalText);
		TestModificationContext modificationContext = new TestModificationContext();
		modificationContext.setDocument(document);

		new IssueResolution(actualIssueResolution.getLabel(), //
				actualIssueResolution.getDescription(), //
				actualIssueResolution.getImage(), //
				modificationContext, //
				actualIssueResolution.getModification(), //
				actualIssueResolution.getRelevance()).apply();
		String actualResult = document.get();
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * The implementation of the following helper methods are taken from the
	 * {@code org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder} class.
	 */
	protected IXtextDocument getDocument(String model) {
		XtextResource xtextResource = getXtextResource(model);
		XtextDocument document = injector.getInstance(XtextDocument.class);
		document.set(model);
		document.setInput(xtextResource);
		return document;
	}

	protected XtextResource getXtextResource(String model) {
		StringInputStream in = new StringInputStream(Strings.emptyIfNull(model));
		URI uri = URI.createURI(""); // creating an in-memory EMF Resource

		ResourceSet resourceSet = resourceSetProvider.get(project);
		Resource resource = injector.getInstance(IResourceFactory.class).createResource(uri);
		resourceSet.getResources().add(resource);

		try {
			resource.load(in, null);
			if (resource instanceof LazyLinkingResource) {
				((LazyLinkingResource) resource).resolveLazyCrossReferences(CancelIndicator.NullImpl);
			} else {
				EcoreUtil.resolveAll(resource);
			}
			return (XtextResource) resource;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
