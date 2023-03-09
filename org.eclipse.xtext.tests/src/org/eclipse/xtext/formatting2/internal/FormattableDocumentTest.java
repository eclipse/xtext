/**
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ISubFormatter;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.TextRegion;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
public class FormattableDocumentTest {
	@Inject
	private GenericFormatterTester genericFormatterTester;

	@Inject
	private FormatterTestLanguageGrammarAccess formatterTestLanguageGrammarAccess;

	@Test
	public void simple() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			String model = "idlist  a\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<IDList>() {
				@Override
				protected void format(IDList model, ITextRegionExtensions regions, IFormattableDocument document) {
					document.append(regions.regionFor(model).keyword("idlist"), IHiddenRegionFormatter::oneSpace);
				}
			});
			String expectation = "idlist a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void autowrap() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 10);
			});
			String model = "idlist  aaa  bbb  ccc  ddd  eee  fff\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<IDList>() {
				@Override
				protected void format(IDList model, ITextRegionExtensions regions, IFormattableDocument document) {
					regions.regionFor(model).ruleCallsTo(formatterTestLanguageGrammarAccess.getIDRule())
							.forEach((ISemanticRegion r) -> {
								document.prepend(r, (IHiddenRegionFormatter f) -> {
									f.autowrap();
									f.oneSpace();
								});
							});
				}
			});
			String expectation = "idlist aaa\nbbb ccc\nddd eee fff\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void autowrapNotInPreviousLineBetweenFormattedRegions() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 5);
			});
			String model = "kwlist kw1\nkw2 kw3 kw4  kw5\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<KWList>() {
				@Override
				protected void format(KWList model, ITextRegionExtensions regions, IFormattableDocument document) {
					document.append(regions.regionFor(model).keyword("kwlist"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.oneSpace();
					});
					document.append(regions.regionFor(model).keyword("kw4"), IHiddenRegionFormatter::oneSpace);
				}
			});
			String expectation = "kwlist kw1\nkw2 kw3 kw4 kw5\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void autowrapNotInPreviousLineInFormattedRegion() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 10);
			});
			String model = "kwlist kw1 kw2 kw3 kw4  kw5\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<KWList>() {
				@Override
				protected void format(KWList model, ITextRegionExtensions regions, IFormattableDocument document) {
					document.append(regions.regionFor(model).keyword("kwlist"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.oneSpace();
					});
					document.append(regions.regionFor(model).keyword("kw1"), IHiddenRegionFormatter::newLine);
					document.append(regions.regionFor(model).keyword("kw4"), IHiddenRegionFormatter::oneSpace);
				}
			});
			String expectation = "kwlist kw1\nkw2 kw3 kw4 kw5\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void autoWrapWithSpan() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 10);
			});
			String model = "kwlist  kw1  kw2  kw3  kw4\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<KWList>() {
				@Override
				protected void format(KWList model, ITextRegionExtensions regions, IFormattableDocument document) {
					document.append(regions.regionFor(model).keyword("kwlist"), (IHiddenRegionFormatter f) -> {
						f.autowrap(6);
						f.oneSpace();
					});
					document.append(regions.regionFor(model).keyword("kw1"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.oneSpace();
					});
					document.append(regions.regionFor(model).keyword("kw2"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.oneSpace();
					});
					document.append(regions.regionFor(model).keyword("kw3"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.oneSpace();
					});
					document.append(regions.regionFor(model).keyword("kw4"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.newLine();
					});
				}
			});
			String expectation = "kwlist\nkw1 kw2\nkw3 kw4\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void autoWrapRewrite() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 10);
			});
			String model = "kwlist  kw1  kw2\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<KWList>() {
				@Override
				protected void format(KWList model, ITextRegionExtensions regions, IFormattableDocument document) {
					document.append(regions.regionFor(model).keyword("kwlist"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.setOnAutowrap(
								(ITextSegment region, IHiddenRegionFormatting wrapped, IFormattableDocument doc) -> {
									doc.append(regions.regionFor(model).keyword("kw1"), (IHiddenRegionFormatter f2) -> {
										f2.setSpace("!");
									});
								});
						document.append(regions.regionFor(model).keyword("kw1"), (IHiddenRegionFormatter f3) -> {
							f3.setSpace("@");
							f3.lowPriority();
						});
					});
				}
			});
			String expectation = "kwlist\nkw1!kw2\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void autoWrapInsert() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 10);
			});
			String model = "kwlist  kw1  kw2\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<KWList>() {
				@Override
				protected void format(KWList model, ITextRegionExtensions regions, IFormattableDocument document) {
					document.append(regions.regionFor(model).keyword("kwlist"), (IHiddenRegionFormatter f) -> {
						f.autowrap();
						f.setOnAutowrap(
								(ITextSegment region, IHiddenRegionFormatting wrapped, IFormattableDocument doc) -> {
									doc.append(regions.regionFor(model).keyword("kw1"), (IHiddenRegionFormatter f2) -> {
										f2.setSpace("!");
									});
								});
						document.append(regions.regionFor(model).keyword("kw2"), (IHiddenRegionFormatter f3) -> {
							f3.setSpace("@" + System.getProperty("line.separator"));
						});
					});
				}
			});
			String expectation = "kwlist\nkw1!kw2@\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void conditionalFormatting1() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 10);
			});
			String model = "kwlist  kw1  kw2\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<KWList>() {
				@Override
				protected void format(KWList model, ITextRegionExtensions regions, IFormattableDocument document) {
					ISubFormatter subFormatter1 = (IFormattableSubDocument doc) -> {

						IFormattableSubDocument fits = doc.requireFitsInLine();
						fits.append(regions.regionFor(model).keyword("kwlist"), IHiddenRegionFormatter::oneSpace);
						fits.append(regions.regionFor(model).keyword("kw1"), IHiddenRegionFormatter::oneSpace);
					};
					ISubFormatter subFormatter2 = (IFormattableSubDocument doc) -> {
						doc.append(regions.regionFor(model).keyword("kwlist"), IHiddenRegionFormatter::newLine);
						doc.append(regions.regionFor(model).keyword("kw1"), IHiddenRegionFormatter::newLine);
					};
					document.formatConditionally(model, subFormatter1, subFormatter2);
				}
			});
			String expectation = "kwlist\nkw1\nkw2\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void conditionalFormatting2() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(FormatterPreferenceKeys.maxLineWidth, 30);
			});
			String model = "kwlist  kw1  kw2\n";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<KWList>() {
				@Override
				protected void format(KWList model, ITextRegionExtensions regions, IFormattableDocument document) {
					ISubFormatter subFormatter1 = (IFormattableSubDocument doc) -> {

						IFormattableSubDocument fits = doc.requireFitsInLine();
						fits.append(regions.regionFor(model).keyword("kwlist"), IHiddenRegionFormatter::oneSpace);
						fits.append(regions.regionFor(model).keyword("kw1"), IHiddenRegionFormatter::oneSpace);
					};
					ISubFormatter subFormatter2 = (IFormattableSubDocument doc) -> {
						doc.append(regions.regionFor(model).keyword("kwlist"), IHiddenRegionFormatter::newLine);
						doc.append(regions.regionFor(model).keyword("kw1"), IHiddenRegionFormatter::newLine);
					};
					document.formatConditionally(model, subFormatter1, subFormatter2);
				}
			});
			String expectation = "kwlist kw1 kw2\n";
			it.setExpectation(expectation);
		});
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=482665
	 */
	@Test
	public void aroundDocument() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.getRequest().getRegions().add(new TextRegion(0, 6));
			String model = "idlist";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<IDList>() {
				@Override
				protected void format(IDList model, ITextRegionExtensions regions, IFormattableDocument document) {
					document.surround(regions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter f) -> {
						f.setSpace("!");
					});
				}
			});
			String expectation = "!idlist!";
			it.setExpectation(expectation);
		});
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=482110
	 */
	@Test
	public void shouldFormat() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.getRequest().getRegions().add(new TextRegion(0, 6));
			String model = "idlist";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<EObject>() {
				@Override
				protected void format(EObject model, ITextRegionExtensions regionAccess,
						IFormattableDocument document) {
					throw new IllegalStateException("this method should never be called");
				}

				@Override
				public boolean shouldFormat(Object obj, IFormattableDocument document) {
					return false;
				}
			});
			String expectation = "idlist";
			it.setExpectation(expectation);
		});
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=482110
	 */
	@Test(expected = IllegalStateException.class)
	public void shouldFormat_02() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.getRequest().getRegions().add(new TextRegion(0, 6));
			String model = "idlist";
			it.setToBeFormatted(model);
			it.setFormatter(new GenericFormatter<EObject>() {
				@Override
				protected void format(EObject model, ITextRegionExtensions regionAccess,
						IFormattableDocument document) {
					throw new IllegalStateException("this method should never be called");
				}

				@Override
				public boolean shouldFormat(Object obj, IFormattableDocument document) {
					return true;
				}
			});
			String expectation = "idlist";
			it.setExpectation(expectation);
		});
	}
}
