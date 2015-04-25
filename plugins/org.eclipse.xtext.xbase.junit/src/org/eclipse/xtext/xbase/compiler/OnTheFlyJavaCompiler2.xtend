package org.eclipse.xtext.xbase.compiler

import java.util.Map
import org.eclipse.xtext.xbase.compiler.InMemoryJavaCompiler.Result
import com.google.inject.Inject
import com.google.inject.Singleton

/** 
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.9
 */
@Singleton
class OnTheFlyJavaCompiler2 {
	InMemoryJavaCompiler inMemoryCompiler

	@Inject
	new(ClassLoader scope) {
		inMemoryCompiler = new InMemoryJavaCompiler(scope)
	}

	def Class<?> compileToClass(String classname, String code) {
		val Result result = inMemoryCompiler.compile(
			new JavaSource(classname.toJavaFile,
				code))
		try {
			if (result.compilationProblems.exists[error]) {
				println(result.compilationProblems)
			}
			return result.getClassLoader().loadClass(classname)
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException('''
				Couldn't load '«»«classname»' 
				source :
					«code»
				
				PROBLEMS : 
					«result.getCompilationProblems().join('\n')»
			''', e)
		}

	}
	
	private def toJavaFile(String string) {
		string.replace('.','/')+".java"
	}

	def Map<String, Class<?>> compileToClasses(Map<String, String> sources) {
		val Result result = inMemoryCompiler.compile(sources.entrySet.map[new JavaSource(key.toJavaFile, value)])
		try {
			if (result.compilationProblems.exists[error]) {
				println(result.compilationProblems)
			}
			val classLoader = result.getClassLoader()
			return sources.keySet.map[ classLoader.loadClass(it)].toMap[name]
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException('''
				«e.message» 
				source :
					«sources»
				
				PROBLEMS : 
					«result.getCompilationProblems().join('\n')»
			''', e)
		}
	}

	@SuppressWarnings("unchecked") def <RT> Functions.Function0<RT> createFunction(String expression, Class<RT> returnType) {
		val clazz = compileToClass("__Generated", '''
			public class __Generated implements org.eclipse.xtext.xbase.lib.Functions.Function0<«returnType.name»> {
				public «returnType.name» apply() {
					«expression»
				}
			}
		''')
		return clazz.newInstance as Functions.Function0<RT>
	}
	
}
