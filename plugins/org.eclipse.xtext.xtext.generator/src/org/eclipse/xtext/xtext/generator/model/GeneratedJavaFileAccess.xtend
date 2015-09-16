package org.eclipse.xtext.xtext.generator.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation
import java.util.Collections
import com.google.common.collect.Lists

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

	override getContent() {
		val classAnnotations = annotations + codeConfig.classAnnotations.filter[appliesTo(this)]
		classAnnotations.forEach[importType(annotationImport)]
		val sortedImports = Lists.newArrayList(imports.values)
		Collections.sort(sortedImports)
		return '''
			«codeConfig.fileHeader»
			package «javaType.packageName»«IF appendSemicolons»;«ENDIF»
			
			«FOR importName : sortedImports»
				import «importName»«IF appendSemicolons»;«ENDIF»
			«ENDFOR»
			
			«typeComment»
			«FOR annot : classAnnotations»
				«annot.generate()»
			«ENDFOR»
			«internalContents»
		'''
	}	
}