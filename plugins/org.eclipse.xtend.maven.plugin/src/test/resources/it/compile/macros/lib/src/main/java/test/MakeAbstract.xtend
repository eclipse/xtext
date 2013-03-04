package test

import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

@Active(typeof(AbstractProcessor))
annotation MakeAbstract { }
class AbstractProcessor implements TransformationParticipant<MutableClassDeclaration> {
	
	extension TransformationContext ctx
	
	override doTransform(List<? extends MutableClassDeclaration> annotatedSourceClasses, TransformationContext context) {
		ctx = context
		annotatedSourceClasses.forEach [
			^abstract = true
		]
	}
	
}