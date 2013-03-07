package org.eclipse.xtend.core.tests.macro.declaration;

import java.util.List;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;

@SuppressWarnings("all")
public class AddNestedTypesProcessor implements RegisterGlobalsParticipant<TypeDeclaration> {
  public void doRegisterGlobals(final List<? extends TypeDeclaration> annotatedSourceElements, final RegisterGlobalsContext context) {
    for (final TypeDeclaration type : annotatedSourceElements) {
      {
        String _name = type.getName();
        String _plus = (_name + ".NestedClass");
        context.registerClass(_plus);
        String _name_1 = type.getName();
        String _plus_1 = (_name_1 + ".NestedInterface");
        context.registerInterface(_plus_1);
        String _name_2 = type.getName();
        String _plus_2 = (_name_2 + ".NestedAnnotationType");
        context.registerAnnotationType(_plus_2);
        String _name_3 = type.getName();
        String _plus_3 = (_name_3 + ".NestedEnumerationType");
        context.registerEnumerationType(_plus_3);
      }
    }
  }
}
