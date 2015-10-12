package org.eclipse.xtext.xtext.generator.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation

class GeneratedJavaFileAccess extends JavaFileAccess {
	
	@Accessors
	CharSequence typeComment
	
	@Accessors
	val List<IClassAnnotation> annotations = newArrayList
	
	protected new(TypeReference typeRef, CodeConfig codeConfig) {
		super(typeRef, codeConfig)
	}
	
	override isMarkedAsGenerated() {
		return true
	}
	
	override setMarkedAsGenerated(boolean markedAsGenerated) {
		if (!markedAsGenerated)
			throw new IllegalArgumentException("It's always generated");
	}

	/**
	 * prepends the addition of required imports of the employed annotations
	 */
	override getContent() {
		classAnnotations.forEach[
			importType(annotationImport)
		]
		super.getContent()
	}
	
	private def getClassAnnotations() {
		annotations + codeConfig.classAnnotations.filter[appliesTo(this)]
	}
	
	override getInternalContent() '''
		«typeComment»
		«FOR annot : classAnnotations»
			«annot.generate()»
		«ENDFOR»	
		«super.getInternalContent»
	'''
	
}