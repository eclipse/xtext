package i18n;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ExternalizedTest {
  @Extension
  private XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(this.getClass().getClassLoader());
  
  @Test
  public void testExtractAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package i18n");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Externalized");
    _builder.newLine();
    _builder.append("class MyMessages {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val GREETING = \"Hello {0}\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val DATE_MESSAGE = \"Today, is ${0,date}.\"");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      @Extension
      final TransformationContext ctx = it.getTransformationContext();
      final MutableClassDeclaration clazz = ctx.findClass("i18n.MyMessages");
      Assert.assertEquals(2, IterableExtensions.size(clazz.getDeclaredMethods()));
      final Path path = it.getCompilationUnit().getFilePath();
      Path _targetFolder = ctx.getTargetFolder(path);
      String _replace = clazz.getQualifiedName().replace(".", "/");
      String _plus = (_replace + ".properties");
      final Path properties = _targetFolder.append(_plus);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("GREETING = Hello {0}");
      _builder_1.newLine();
      _builder_1.append("DATE_MESSAGE = Today, is ${0,date}.");
      _builder_1.newLine();
      Assert.assertEquals(_builder_1.toString(), ctx.getContents(properties).toString());
    };
    this.compilerTester.compile(_builder, _function);
  }
}
