package org.eclipse.xtext.example.domainmodel.tests;

import org.eclipse.xtext.example.domainmodel.DomainmodelUiInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein - copied and adapted from Xtend
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class ContentAssistTest extends AbstractContentAssistTest {
  @Test
  public void testImportCompletion() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append("import java.util.Da");
      _append.assertText("java.util.Date");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImportCompletion_1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append("import LinkedHashSet");
      _append.assertText("java.util.LinkedHashSet");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeCompletion() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append("entity Foo { bar: LinkedHashSet");
      _append.assertText("java.util.LinkedHashSet");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
