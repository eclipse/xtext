package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.lib.macro.ModifyContext;
import org.eclipse.xtend.lib.macro.ModifyProcessor;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AbstractProcessor implements ModifyProcessor<MutableClassDeclaration> {
  private ModifyContext ctx;
  
  public void modify(final List<? extends MutableClassDeclaration> annotatedSourceClasses, final ModifyContext context) {
    this.ctx = context;
    final Procedure1<MutableClassDeclaration> _function = new Procedure1<MutableClassDeclaration>() {
        public void apply(final MutableClassDeclaration it) {
          MutableClassDeclaration _generatedClass = AbstractProcessor.this.ctx.getGeneratedClass(it);
          _generatedClass.setAbstract(true);
        }
      };
    IterableExtensions.forEach(annotatedSourceClasses, _function);
  }
}
