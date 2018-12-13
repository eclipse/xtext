package i18n;

import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class ExternalizedProcessor extends AbstractClassProcessor implements CodeGenerationParticipant<ClassDeclaration> {
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    Iterable<? extends MutableFieldDeclaration> _declaredFields = annotatedClass.getDeclaredFields();
    for (final MutableFieldDeclaration field : _declaredFields) {
      {
        final String initializer = this.getInitializerAsString(field);
        MessageFormat _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = new MessageFormat(initializer);
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
            final IllegalArgumentException e = (IllegalArgumentException)_t;
            MessageFormat _xblockexpression = null;
            {
              Expression _initializer = field.getInitializer();
              String _message = e.getMessage();
              String _plus = ("invalid format : " + _message);
              context.addError(_initializer, _plus);
              _xblockexpression = new MessageFormat("");
            }
            _xtrycatchfinallyexpression = _xblockexpression;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        final MessageFormat msgFormat = _xtrycatchfinallyexpression;
        final Format[] formats = msgFormat.getFormatsByArgumentIndex();
        int _length = msgFormat.getFormats().length;
        int _length_1 = formats.length;
        boolean _notEquals = (_length != _length_1);
        if (_notEquals) {
          context.addWarning(field.getInitializer(), "Unused placeholders. They should start at index 0.");
        }
        final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
          final Procedure2<Format, Integer> _function_1 = (Format format, Integer idx) -> {
            TypeReference _switchResult = null;
            boolean _matched = false;
            if (format instanceof NumberFormat) {
              _matched=true;
              _switchResult = context.getPrimitiveInt();
            }
            if (!_matched) {
              if (format instanceof DateFormat) {
                _matched=true;
                _switchResult = context.newTypeReference(Date.class);
              }
            }
            if (!_matched) {
              _switchResult = context.getString();
            }
            it.addParameter(("arg" + idx), _switchResult);
          };
          IterableExtensions.<Format>forEach(((Iterable<Format>)Conversions.doWrapArray(formats)), _function_1);
          it.setReturnType(context.getString());
          it.setDocComment(initializer);
          it.setStatic(true);
          final Iterable<? extends MutableParameterDeclaration> params = it.getParameters();
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("try {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("String msg = RESOURCE_BUNDLE.getString(\"");
              String _simpleName = field.getSimpleName();
              _builder.append(_simpleName, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              {
                int _length = formats.length;
                boolean _greaterThan = (_length > 0);
                if (_greaterThan) {
                  _builder.append("\t");
                  _builder.append("msg = ");
                  _builder.append(MessageFormat.class, "\t");
                  _builder.append(".format(msg,");
                  final Function1<MutableParameterDeclaration, String> _function = (MutableParameterDeclaration it_1) -> {
                    return it_1.getSimpleName();
                  };
                  String _join = IterableExtensions.join(IterableExtensions.map(params, _function), ",");
                  _builder.append(_join, "\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("return msg;");
              _builder.newLine();
              _builder.append("} catch (");
              _builder.append(MissingResourceException.class);
              _builder.append(" e) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("// TODO error logging");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("return \"");
              _builder.append(initializer, "\t");
              _builder.append("\";");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          };
          it.setBody(_client);
          context.setPrimarySourceElement(it, field);
        };
        annotatedClass.addMethod(field.getSimpleName(), _function);
      }
    }
    final Consumer<MutableFieldDeclaration> _function = (MutableFieldDeclaration it) -> {
      it.remove();
    };
    annotatedClass.getDeclaredFields().forEach(_function);
    final Procedure1<MutableFieldDeclaration> _function_1 = (MutableFieldDeclaration it) -> {
      it.setStatic(true);
      it.setFinal(true);
      it.setType(context.newTypeReference(ResourceBundle.class));
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("ResourceBundle.getBundle(\"");
          String _qualifiedName = annotatedClass.getQualifiedName();
          _builder.append(_qualifiedName);
          _builder.append("\")");
        }
      };
      it.setInitializer(_client);
      context.setPrimarySourceElement(it, annotatedClass);
    };
    annotatedClass.addField("RESOURCE_BUNDLE", _function_1);
  }
  
  @Override
  public void doGenerateCode(final List<? extends ClassDeclaration> annotatedSourceElements, @Extension final CodeGenerationContext context) {
    for (final ClassDeclaration clazz : annotatedSourceElements) {
      {
        final Path filePath = clazz.getCompilationUnit().getFilePath();
        Path _targetFolder = context.getTargetFolder(filePath);
        String _replace = clazz.getQualifiedName().replace(".", "/");
        String _plus = (_replace + ".properties");
        final Path file = _targetFolder.append(_plus);
        StringConcatenation _builder = new StringConcatenation();
        {
          Iterable<? extends FieldDeclaration> _declaredFields = clazz.getDeclaredFields();
          for(final FieldDeclaration field : _declaredFields) {
            String _simpleName = field.getSimpleName();
            _builder.append(_simpleName);
            _builder.append(" = ");
            String _initializerAsString = this.getInitializerAsString(field);
            _builder.append(_initializerAsString);
            _builder.newLineIfNotEmpty();
          }
        }
        context.setContents(file, _builder);
      }
    }
  }
  
  public String getInitializerAsString(final FieldDeclaration f) {
    Expression _initializer = f.getInitializer();
    String _string = null;
    if (_initializer!=null) {
      _string=_initializer.toString();
    }
    final String string = _string;
    if ((string == null)) {
      return "empty string";
    }
    int _length = string.length();
    int _minus = (_length - 1);
    return string.substring(1, _minus);
  }
}
