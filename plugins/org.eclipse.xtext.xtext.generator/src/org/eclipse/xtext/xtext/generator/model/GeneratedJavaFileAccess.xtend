package org.eclipse.xtext.xtext.generator.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess.JavaTypeAwareStringConcatenation
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation

class GeneratedJavaFileAccess extends JavaFileAccess {
	
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
	
	def setTypeComment(StringConcatenationClient javaContent) {
		val javaStringConcat = new JavaTypeAwareStringConcatenation(this)
		javaStringConcat.append(javaContent)
		this.typeComment = javaStringConcat
	}
	
	/**
	 * Prepends the addition of required imports of the employed annotations.
	 * Since the 'typeComment' is a {@link JavaFileAccess.JavaTypeAwareStringConcatenation}
	 * any optionally required imports are already processed and tracked in {@link #imports}.
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