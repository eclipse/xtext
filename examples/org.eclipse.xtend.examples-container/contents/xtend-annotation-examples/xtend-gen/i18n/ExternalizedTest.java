package i18n;

import extract.Extract;
import junit.framework.Assert;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

@SuppressWarnings("all")
public class ExternalizedTest {
  @Extension
  private XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(Extract.class);
  
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
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = new IAcceptor<XtendCompilerTester.CompilationResult>() {
      public void accept(final XtendCompilerTester.CompilationResult it) {
        @Extension
        final TransformationContext ctx = it.getTransformationContext();
        final MutableClassDeclaration clazz = ctx.findClass("i18n.MyMessages");
        Iterable<? extends MutableMethodDeclaration> _declaredMethods = clazz.getDeclaredMethods();
        int _size = IterableExtensions.size(_declaredMethods);
        Assert.assertEquals(2, _size);
        CompilationUnit _compilationUnit = it.getCompilationUnit();
        final Path path = _compilationUnit.getFilePath();
        Path _targetFolder = ctx.getTargetFolder(path);
        String _qualifiedName = clazz.getQualifiedName();
        String _replace = _qualifiedName.replace(".", "/");
        String _plus = (_replace + ".properties");
        final Path properties = _targetFolder.append(_plus);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("GREETING = Hello {0}");
        _builder.newLine();
        _builder.append("DATE_MESSAGE = Today, is ${0,date}.");
        _builder.newLine();
        String _string = _builder.toString();
        CharSequence _contents = ctx.getContents(properties);
        String _string_1 = _contents.toString();
        Assert.assertEquals(_string, _string_1);
      }
    };
    this.compilerTester.compile(_builder, _function);
  }
}
