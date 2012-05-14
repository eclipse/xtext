package org.eclipse.xtext.xbase.ui.tests.editor;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.eclipse.xtext.xbase.ui.tests.editor.TestingXbaseHoverProvider;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class Bug379238Test extends AbstractXbaseUITestCase {
  @Inject
  private ParseHelper<XConstructorCall> parseHelper;
  
  @Inject
  private TestingXbaseHoverProvider hoverProvider;
  
  @Test
  public void testXConstructorWithNullConstructorNoException() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new()");
    _builder.newLine();
    final XConstructorCall constructorCall = this.parseHelper.parse(_builder);
    final XtextBrowserInformationControlInput result = this.hoverProvider.getHoverInfo(constructorCall);
    Assert.assertNull(result);
  }
}
