package org.eclipse.xtext.example.homeautomation.tests;

import com.google.inject.Inject;
import org.eclipse.xtext.example.homeautomation.tests.AbstractTest;
import org.eclipse.xtext.junit4.formatter.FormatterTestRequest;
import org.eclipse.xtext.junit4.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FormatterTest extends AbstractTest {
  @Inject
  @Extension
  private FormatterTester _formatterTester;
  
  @Override
  protected void test(final CharSequence document) {
    final Procedure1<FormatterTestRequest> _function = new Procedure1<FormatterTestRequest>() {
      @Override
      public void apply(final FormatterTestRequest it) {
        it.setToBeFormatted(document);
      }
    };
    this._formatterTester.assertFormatted(_function);
  }
}
