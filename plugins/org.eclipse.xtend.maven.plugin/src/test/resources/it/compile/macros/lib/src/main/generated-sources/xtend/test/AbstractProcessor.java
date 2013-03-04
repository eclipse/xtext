package test;

import java.util.List;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AbstractProcessor implements TransformationParticipant<MutableClassDeclaration> {
  private TransformationContext ctx;
  
  public void doTransform(final List<? extends MutableClassDeclaration> annotatedSourceClasses, final TransformationContext context) {
    this.ctx = context;
    final Procedure1<MutableClassDeclaration> _function = new Procedure1<MutableClassDeclaration>() {
        public void apply(final MutableClassDeclaration it) {
          it.setAbstract(true);
        }
      };
    IterableExtensions.forEach(annotatedSourceClasses, _function);
  }
}
