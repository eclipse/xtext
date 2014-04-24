package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AddInterfaceProcessor extends AbstractClassProcessor {
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, final RegisterGlobalsContext context) {
    context.registerInterface("de.test.Test");
  }
  
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final AnnotationReference annotationReferenceA = context.newAnnotationReference("A");
    boolean _equals = Objects.equal(annotationReferenceA, null);
    if (_equals) {
      throw new NullPointerException();
    }
    final Procedure1<AnnotationReferenceBuildContext> _function = new Procedure1<AnnotationReferenceBuildContext>() {
      public void apply(final AnnotationReferenceBuildContext it) {
        it.set("value", Integer.valueOf(1));
        final Procedure1<AnnotationReferenceBuildContext> _function = new Procedure1<AnnotationReferenceBuildContext>() {
          public void apply(final AnnotationReferenceBuildContext it) {
            Type _findTypeGlobally = context.findTypeGlobally(Target.class);
            AnnotationReference _newAnnotationReference = context.newAnnotationReference(_findTypeGlobally);
            AnnotationReference _newAnnotationReference_1 = context.newAnnotationReference(Target.class);
            it.setAnnotationValue("lalala", _newAnnotationReference, _newAnnotationReference_1);
          }
        };
        AnnotationReference _newAnnotationReference = context.newAnnotationReference("C", _function);
        it.setAnnotationValue("a", _newAnnotationReference);
      }
    };
    final AnnotationReference annotationReferenceB = context.newAnnotationReference("B", _function);
    boolean _equals_1 = Objects.equal(annotationReferenceB, null);
    if (_equals_1) {
      throw new NullPointerException();
    }
  }
}
