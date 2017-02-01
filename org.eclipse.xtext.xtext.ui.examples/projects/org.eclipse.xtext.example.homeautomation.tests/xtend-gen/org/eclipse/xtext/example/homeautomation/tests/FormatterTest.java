package org.eclipse.xtext.example.homeautomation.tests;

import com.google.inject.Inject;
import org.eclipse.xtext.example.homeautomation.tests.AbstractTest;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FormatterTest extends AbstractTest {
  @Inject
  @Extension
  private FormatterTestHelper _formatterTestHelper;
  
  @Override
  protected void test(final CharSequence document) {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted(document);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
}
