/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.Wrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
public class FormattingConflictTest {
	@Inject
	private GenericFormatterTester genericFormatterTester;

	@Test
	public void enableDebugTracingTrue() {
		Wrapper<Throwable> wrapper = new Wrapper<>();
		Wrapper<Integer> execution = new Wrapper<>(0);
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted("idlist a");
			it.setFormatter(new GenericFormatter<IDList>() {
				@Override
				protected void format(IDList model, ITextRegionExtensions regions,
						IFormattableDocument document) {
					execution.set(execution.get().intValue() + 1);
					document.append(regions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter f) -> f.setSpace(" "));
					document.append(regions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter f) -> f.setSpace("\t"));
				}
			});
			it.getRequest().setEnableDebugTracing(true);
			it.getRequest().setExceptionHandler((Exception e) -> wrapper.set(e));
		});
		ConflictingRegionsException exception = (ConflictingRegionsException) wrapper.get();
		Assert.assertEquals(1, execution.get().intValue());
		Assert.assertEquals(2, exception.getTraces().size());
	}

	@Test
	public void enableDebugTracingFalse() {
		Wrapper<Throwable> wrapper = new Wrapper<>();
		Wrapper<Integer> execution = new Wrapper<>(0);
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted("idlist a");
			it.setFormatter(new GenericFormatter<IDList>() {
				@Override
				protected void format(IDList model, ITextRegionExtensions regions,
						IFormattableDocument document) {
					execution.set(execution.get().intValue() + 1);
					document.append(regions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter f) -> f.setSpace(" "));
					document.append(regions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter f) -> f.setSpace("\t"));
				}
			});
			it.getRequest().setEnableDebugTracing(false);
			it.getRequest().setExceptionHandler((Exception e) -> wrapper.set(e));
		});
		ConflictingRegionsException exception = (ConflictingRegionsException) wrapper.get();
		Assert.assertEquals(2, execution.get().intValue());
		Assert.assertEquals(2, exception.getTraces().size());
	}
}
