package org.eclipse.xtext.purexbase.test;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(PureXbaseInjectorProvider.class)
@SuppressWarnings("all")
public class DefaultImportsConfigurationTest {
  @Inject
  @Extension
  private ParseHelper<Model> parser;
  
  @Inject
  private DefaultImportsConfiguration defaultImportsConfiguration;
  
  @Test
  public void testCommentsInImportSection() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// some comment");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("/* another");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* comment");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("import java.util.Set");
      _builder.newLine();
      _builder.newLine();
      _builder.append("println(\"Hello World\")");
      _builder.newLine();
      final Model model = this.parser.parse(_builder);
      Resource _eResource = model.eResource();
      int _importSectionOffset = this.defaultImportsConfiguration.getImportSectionOffset(((XtextResource) _eResource));
      Assert.assertEquals(0, _importSectionOffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
