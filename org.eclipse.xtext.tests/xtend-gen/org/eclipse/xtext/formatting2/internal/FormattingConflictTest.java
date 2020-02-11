/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.ConflictingRegionsException;
import org.eclipse.xtext.formatting2.internal.GenericFormatter;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTestRequest;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTester;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class FormattingConflictTest {
  @Inject
  @Extension
  private GenericFormatterTester _genericFormatterTester;
  
  @Test
  public void enableDebugTracingTrue() {
    final Wrapper<Throwable> wrapper = new Wrapper<Throwable>();
    final Wrapper<Integer> execution = new Wrapper<Integer>(Integer.valueOf(0));
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          Integer _get = execution.get();
          int _plus = ((_get).intValue() + 1);
          execution.set(Integer.valueOf(_plus));
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.setSpace(" ");
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
            it_1.setSpace("\t");
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function_1);
        }
      };
      it.setFormatter(_function_1);
      FormatterRequest _request = it.getRequest();
      _request.setEnableDebugTracing(true);
      FormatterRequest _request_1 = it.getRequest();
      final IAcceptor<Exception> _function_2 = (Exception e) -> {
        wrapper.set(e);
      };
      _request_1.setExceptionHandler(_function_2);
    };
    this._genericFormatterTester.assertFormatted(_function);
    Throwable _get = wrapper.get();
    final ConflictingRegionsException exception = ((ConflictingRegionsException) _get);
    Assert.assertEquals(1, (execution.get()).intValue());
    Assert.assertEquals(2, exception.getTraces().size());
  }
  
  @Test
  public void enableDebugTracingFalse() {
    final Wrapper<Throwable> wrapper = new Wrapper<Throwable>();
    final Wrapper<Integer> execution = new Wrapper<Integer>(Integer.valueOf(0));
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          Integer _get = execution.get();
          int _plus = ((_get).intValue() + 1);
          execution.set(Integer.valueOf(_plus));
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.setSpace(" ");
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
            it_1.setSpace("\t");
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function_1);
        }
      };
      it.setFormatter(_function_1);
      FormatterRequest _request = it.getRequest();
      _request.setEnableDebugTracing(false);
      FormatterRequest _request_1 = it.getRequest();
      final IAcceptor<Exception> _function_2 = (Exception e) -> {
        wrapper.set(e);
      };
      _request_1.setExceptionHandler(_function_2);
    };
    this._genericFormatterTester.assertFormatted(_function);
    Throwable _get = wrapper.get();
    final ConflictingRegionsException exception = ((ConflictingRegionsException) _get);
    Assert.assertEquals(2, (execution.get()).intValue());
    Assert.assertEquals(2, exception.getTraces().size());
  }
}
