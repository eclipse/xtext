package i18n

import java.text.DateFormat
import java.text.MessageFormat
import java.text.NumberFormat
import java.util.Date
import java.util.MissingResourceException
import java.util.ResourceBundle
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant
import java.util.List

@Active(ExternalizedProcessor)
annotation Externalized {
}

class ExternalizedProcessor extends AbstractClassProcessor implements CodeGenerationParticipant<ClassDeclaration> {

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		for (field : annotatedClass.declaredFields) {
			val initializer = field.initializerAsString
			val msgFormat = try {
				new MessageFormat(initializer)
			} catch(IllegalArgumentException e) {
				field.initializer.addError("invalid format : " + e.message)
				new MessageFormat("")
			}
			val formats = msgFormat.formatsByArgumentIndex
			if(msgFormat.formats.length != formats.length) {
				field.initializer.addWarning('Unused placeholders. They should start at index 0.')
			}

			annotatedClass.addMethod(field.simpleName) [
				formats.forEach [ format, idx |
					addParameter("arg" + idx,
						switch format {
							NumberFormat: primitiveInt
							DateFormat: Date.newTypeReference()
							default: string
						})
				]
				returnType = string
				docComment = initializer
				static = true
				val params = parameters
				body = [
					'''
						try {
							String msg = RESOURCE_BUNDLE.getString("«field.simpleName»");
							«IF formats.length > 0»
								msg = «toJavaCode(MessageFormat.newTypeReference())».format(msg,«params.map[simpleName].join(",")»);
							«ENDIF»
							return msg;
						} catch («toJavaCode(MissingResourceException.newTypeReference())» e) {
							// TODO error logging
							return "«initializer»";
						}
					''']
				primarySourceElement = field
			]
		}
		annotatedClass.declaredFields.forEach[remove]

		//private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
		annotatedClass.addField("RESOURCE_BUNDLE") [
			static = true
			final = true
			type = ResourceBundle.newTypeReference
			initializer = ['''ResourceBundle.getBundle("«annotatedClass.qualifiedName»")''']
			primarySourceElement = annotatedClass
		]

	}

	override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, extension CodeGenerationContext context) {
		for (clazz : annotatedSourceElements) {
			val filePath = clazz.compilationUnit.filePath
			val file = filePath.targetFolder.append(clazz.qualifiedName.replace('.', '/') + ".properties")
			file.contents = '''
				«FOR field : clazz.declaredFields»
					«field.simpleName» = «field.initializerAsString»
				«ENDFOR»
			'''
		}
	}

	def getInitializerAsString(FieldDeclaration f) {
		val string = f.initializer?.toString
		if(string == null)
			return "empty string"
		return string.substring(1, string.length - 1)
	}

}
