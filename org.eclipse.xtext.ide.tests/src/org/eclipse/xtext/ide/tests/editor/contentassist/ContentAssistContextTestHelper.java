/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.editor.contentassist;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContentAssistContextTestHelper {
	@Inject
	private FileExtensionProvider fileExtension;
	@Inject
	private IResourceFactory resFactory;
	@Inject
	private ValidationTestHelper validator;
	private String document;
	private ParserRule entryPoint;
	private String cursor = "<|>";

	private XtextResource parse(String doc) throws Exception {
		URI uri = URI.createURI("dummy." + fileExtension.getPrimaryFileExtension());
		XtextResource res = (XtextResource) resFactory.createResource(uri);
		new XtextResourceSet().getResources().add(res);
		if (entryPoint != null) {
			res.setEntryPoint(entryPoint);
		}
		res.load(new StringInputStream(doc), Collections.emptyMap());
		validator.assertNoErrors(res);
		return res;
	}

	public String firstSetGrammarElementsToString(ContentAssistContextFactory factory) throws Exception {
		int offset = document.indexOf(cursor);
		Preconditions.checkArgument(offset >= 0, "you forgot to provide a cursor");
		String doc = document.replace(cursor, "");
		XtextResource res = parse(doc);
		factory.setPool(Executors.newCachedThreadPool());
		ContentAssistContext[] ctxs = factory.create(doc, new TextRegion(0, 0), offset, res);
		GrammarElementTitleSwitch f = new GrammarElementTitleSwitch().showAssignments().showQualified().showRule();
		Iterable<String> entries = Iterables.transform(IterableExtensions.indexed(Arrays.asList(ctxs)), ctx -> {
			String elements = Joiner.on("").join(Lists.transform(ctx.getValue().getFirstSetGrammarElements(),
					ele -> "	" + ele.eClass().getName() + ": " + f.apply(ele) + "\n"));
			String entry =
					"context" + ctx.getKey() + " {\n"
					+ elements
					+ "}\n";
			return entry;
		});
		String result = Joiner.on("").join(entries);
		return result;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public ParserRule getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(ParserRule entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
}