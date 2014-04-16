package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.core.tests.macro.Get;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class GetProcessor implements TransformationParticipant<MutableMethodDeclaration> {
  public void doTransform(final List<? extends MutableMethodDeclaration> methods, @Extension final TransformationContext context) {
    for (final MutableMethodDeclaration m : methods) {
      {
        Type _findTypeGlobally = context.findTypeGlobally(Get.class);
        final AnnotationReference annotation = m.findAnnotation(_findTypeGlobally);
        final Object pattern = annotation.getValue("value");
        boolean _equals = Objects.equal(pattern, null);
        if (_equals) {
          context.addError(annotation, "A URL pattern must be provided.");
        } else {
        }
      }
    }
  }
}
