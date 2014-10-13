package org.eclipse.xtext.idea.tests;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TestDecoratorProcessor extends AbstractClassProcessor {
  public void doTransform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    final MutableFieldDeclaration delegate = it.findDeclaredField("delegate");
    boolean _equals = Objects.equal(delegate, null);
    if (_equals) {
      context.addWarning(it, "Delegate is not declared");
    }
    TypeReference _type = delegate.getType();
    Iterable<? extends ResolvedMethod> _allResolvedMethods = _type.getAllResolvedMethods();
    final Function1<ResolvedMethod, MethodDeclaration> _function = new Function1<ResolvedMethod, MethodDeclaration>() {
      public MethodDeclaration apply(final ResolvedMethod it) {
        return it.getDeclaration();
      }
    };
    Iterable<MethodDeclaration> _map = IterableExtensions.map(_allResolvedMethods, _function);
    final Function1<MethodDeclaration, Boolean> _function_1 = new Function1<MethodDeclaration, Boolean>() {
      public Boolean apply(final MethodDeclaration it) {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(_simpleName.startsWith("test"));
      }
    };
    Iterable<MethodDeclaration> _filter = IterableExtensions.<MethodDeclaration>filter(_map, _function_1);
    for (final MethodDeclaration declaredMethod : _filter) {
      String _simpleName = declaredMethod.getSimpleName();
      final Procedure1<MutableMethodDeclaration> _function_2 = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("delegate.");
              String _simpleName = declaredMethod.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append("();");
            }
          };
          it.setBody(_client);
          Iterable<? extends TypeReference> _exceptions = declaredMethod.getExceptions();
          it.setExceptions(((TypeReference[])Conversions.unwrapArray(_exceptions, TypeReference.class)));
        }
      };
      it.addMethod(_simpleName, _function_2);
    }
  }
}
