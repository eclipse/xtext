package test

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration


@Active(AbstractProcessor)
annotation MakeAbstract { }
class AbstractProcessor extends AbstractClassProcessor {
	
	override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
		clazz.^abstract = true
		clazz.addMethod('foo') [
			returnType = primitiveVoid
			body = '''
				new MyJavaClass().toString();
			'''
		]
	}
	
	override doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		annotatedClass.compilationUnit.filePath.targetFolder.append("/test/MyJavaClass.java").contents = '''
			package test;
			public class MyJavaClass {}
		'''
	}
}