/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.junit.formatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.formatting.AbstractFormatter;
import org.eclipse.xtext.xbase.formatting.IBasicFormatter;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @deprecated use org.eclipse.xtext.junit4.formatter.FormatterTester
 */
@Deprecated(forRemoval = true)
public class FormatterTester {
	@Inject
	private ParseHelper<EObject> parseHelper;

	@Inject
	private IBasicFormatter formatter;

	public void assertFormatted(Procedure1<? super AssertingFormatterData> init) {
		AssertingFormatterData data = new AssertingFormatterData();
		data.setConfig(new MapBasedPreferenceValues(new HashMap<>()));
		init.apply(data);
		assertFormatted(data);
	}

	public void assertFormatted(AssertingFormatterData it) {
		try {
			String fullToBeParsed = it.getPrefix() + it.getToBeFormatted() + it.getPostfix();
			EObject parsed = parseHelper.parse(fullToBeParsed);
			if (!it.isAllowErrors()) {
				Assert.assertEquals(Joiner.on("\n").join(parsed.eResource().getErrors()), 0, parsed.eResource().getErrors().size());
			}
			String oldDocument = null;
			IParseResult parseResult = ((XtextResource) parsed.eResource()).getParseResult();
			if (parseResult != null) {
				ICompositeNode rootNode = parseResult.getRootNode();
				if (rootNode != null) {
					oldDocument = rootNode.getText();
				}
			}
			if (formatter instanceof AbstractFormatter) {
				((AbstractFormatter) formatter).setAllowIdentityEdits(true);
			}
			int start = it.getPrefix().length();
			int length = it.getToBeFormatted().length();
			Set<TextReplacement> edits = new LinkedHashSet<>();
			Iterables.addAll(edits, formatter.format((XtextResource) parsed.eResource(), start, length, it.getCfg()));
			if (formatter instanceof AbstractFormatter) {
				if (((AbstractFormatter) formatter).isConflictOccurred()) {
					throw new RuntimeException("There are conflicting text edits, see console for details.");
				}
			}
			if (!it.isAllowErrors()) {
				Iterables.addAll(edits, createMissingEditReplacements((XtextResource) parsed.eResource(), edits, start, length));
			}
			String newDocument = applyEdits(oldDocument, edits);
			try {
				Assert.assertEquals((it.getPrefix() + it.getExpectation() + it.getPostfix()).toString(), newDocument.toString());
			} catch (AssertionError e) {
				System.out.println(applyDebugEdits(oldDocument, edits));
				System.out.println();
				throw e;
			}
			String parsed2Doc = applyEdits(fullToBeParsed,
					formatter.format((XtextResource) parsed.eResource(), 0, fullToBeParsed.length(), it.getCfg()));
			EObject parsed2 = parseHelper.parse(parsed2Doc);
			if (!it.isAllowErrors()) {
				Assert.assertEquals(0, parsed2.eResource().getErrors().size());
			}
			List<TextReplacement> edits2 = formatter.format((XtextResource) parsed2.eResource(), 0, parsed2Doc.length(), it.getCfg());
			String newDocument2 = applyEdits(parsed2Doc, edits2);
			try {
				Assert.assertEquals(parsed2Doc, newDocument2.toString());
			} catch (AssertionError e) {
				System.out.println(applyDebugEdits(newDocument, edits2));
				System.out.println();
				throw e;
			}
		} catch (Throwable e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected String applyEdits(String oldDocument, Collection<TextReplacement> edits) {
		int lastOffset = 0;
		StringBuilder newDocument = new StringBuilder();
		for (TextReplacement edit : IterableExtensions.sortBy(edits, TextReplacement::getOffset)) {
			newDocument.append(oldDocument.substring(lastOffset, edit.getOffset()));
			newDocument.append(edit.getText());
			lastOffset = edit.getOffset() + edit.getLength();
		}
		newDocument.append(oldDocument.substring(lastOffset, oldDocument.length()));
		return newDocument.toString();
	}

	protected String applyDebugEdits(String oldDocument, Collection<TextReplacement> edits) {
		int lastOffset = 0;
		StringBuilder debugTrace = new StringBuilder();
		for (TextReplacement edit : IterableExtensions.sortBy(edits, TextReplacement::getOffset)) {
			debugTrace.append(oldDocument.substring(lastOffset, edit.getOffset()));
			debugTrace.append(
					"[" + oldDocument.substring(edit.getOffset(), edit.getOffset() + edit.getLength()) + "|" + edit.getText() + "]");
			lastOffset = edit.getOffset() + edit.getLength();
		}
		debugTrace.append(oldDocument.substring(lastOffset, oldDocument.length()));
		return debugTrace.toString();
	}

	protected ArrayList<TextReplacement> createMissingEditReplacements(XtextResource res, Collection<TextReplacement> edits, int offset,
			int length) {
		Set<Integer> offsets = IterableExtensions
				.toSet(Iterables.transform(edits, (TextReplacement it) -> Integer.valueOf(it.getOffset())));
		ArrayList<TextReplacement> result = new ArrayList<>();
		int lastOffset = 0;
		IParseResult parseResult = res.getParseResult();
		if (parseResult != null) {
			ICompositeNode rootNode = parseResult.getRootNode();
			if (rootNode != null) {
				for (ILeafNode leaf : rootNode.getLeafNodes()) {
					if (!leaf.isHidden() || !StringExtensions.isNullOrEmpty(leaf.getText().trim())) {
						ITextRegion leafRegion = leaf.getTextRegion();
						if (lastOffset >= offset && leafRegion.getOffset() <= offset + length && !offsets.contains(Integer.valueOf(lastOffset))) {
							result.add(new TextReplacement(lastOffset, leafRegion.getOffset() - lastOffset, "!!"));
						}
						lastOffset = leafRegion.getOffset() + leafRegion.getLength();
					}
				}
			}
		}
		return result;
	}
}
