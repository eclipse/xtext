/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguageFactory;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
public class FormatterReplacementsTest {
	@Inject
	private Provider<FormatterRequest> requestProvider;

	@Inject
	private TextRegionAccessBuilder regionBuilder;

	@Inject
	private ParseHelper<IDList> parseHelper;

	@Inject
	private FormatterTestLanguageGrammarAccess formatterTestLanguageGrammarAccess;

	@Inject
	private Serializer serializer;

	@Inject
	private IResourceFactory resFact;

	private FormattertestlanguageFactory fact = FormattertestlanguageFactory.eINSTANCE;

	@Test
	public void testIdentityEditsAreFiltered() throws Exception {
		GenericFormatter<IDList> formatter = new GenericFormatter<IDList>() {
			@Override
			protected void format(IDList model, ITextRegionExtensions regions, IFormattableDocument document) {
				regions.regionFor(model).ruleCallsTo(formatterTestLanguageGrammarAccess.getIDRule()).forEach(r -> {
					document.prepend(r, it -> {
						it.autowrap();
						it.oneSpace();
					});
				});
			}
		};
		IDList parsed = parseHelper.parse("idlist  aaa bbb");
		FormatterRequest request = requestProvider.get();
		request.setAllowIdentityEdits(false);
		request.setTextRegionAccess(regionBuilder.forNodeModel((XtextResource) parsed.eResource()).create());
		List<ITextReplacement> replacements = formatter.format(request);
		String actual = Joiner.on("").join(
				Lists.transform(replacements, it -> ("'" + it.getText() + "' -> '" + it.getReplacementText() + "'\n")));
		String expected = "'  ' -> ' '\n";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testUndefinedIdentityEditsAreNotFiltered() {
		GenericFormatter<IDList> formatter = new GenericFormatter<IDList>() {
			@Override
			protected void format(IDList model, ITextRegionExtensions regions, IFormattableDocument document) {
				regions.regionFor(model).ruleCallsTo(formatterTestLanguageGrammarAccess.getIDRule()).forEach(r -> {
					document.prepend(r, it -> it.setSpace(""));
				});
			}
		};
		IDList model = fact.createIDList();
		model.getIds().add("a");
		Resource r = resFact.createResource(URI.createURI("foo.ext"));
		new XtextResourceSet().getResources().add(r);
		r.getContents().add(model);
		FormatterRequest request = requestProvider.get();
		request.setAllowIdentityEdits(false);
		request.setTextRegionAccess(serializer.serializeToRegions(model));
		List<ITextReplacement> replacements = formatter.format(request);
		String actual = Joiner.on("").join(
				Lists.transform(replacements, it -> ("'" + it.getText() + "' -> '" + it.getReplacementText() + "'\n")));
		String expected = 
				"'' -> ''\n" +
				"'' -> ''\n" +
				"'' -> ''\n";
		Assert.assertEquals(expected, actual);
	}
}
