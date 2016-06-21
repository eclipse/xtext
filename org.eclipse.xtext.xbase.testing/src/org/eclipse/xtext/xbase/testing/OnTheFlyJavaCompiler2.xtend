package org.eclipse.xtext.xbase.testing

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Map
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.xbase.testing.InMemoryJavaCompiler.Result

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

	/**
	 * Creates a new OnTheFlyCompiler that accepts Java6 compliant code.
	 */
	@Inject
	new(ClassLoader scope) {
		this(scope, JavaVersion.JAVA6)
	}
	
	new(ClassLoader scope, JavaVersion version) {
		inMemoryCompiler = new InMemoryJavaCompiler(scope, version)
	}
	
	def Class<?> compileToClass(String classname, String code) {
		val Result result = inMemoryCompiler.compile(
			new JavaSource(classname.toJavaFile,
				code))
		try {
			if (result.compilationProblems.exists[error]) {
				throw new IllegalArgumentException('''
					Java code compiled with errors:
					«result.compilationProblems.filter[error].join('\n')»
					
					Code was:
					«code»
				''')
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
				throw new IllegalArgumentException('''
					Java code compiled with errors:
					«result.compilationProblems.filter[error].join('\n')»
					
					Code was:
					=========
					«sources.values.join('\n=========\n')»
					=========
				''')
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
