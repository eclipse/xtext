package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.serializer.analysis.Context2NameFunction
import org.eclipse.xtext.serializer.analysis.IContextProvider
import org.eclipse.xtext.util.GraphvizDotBuilder
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.emf.ecore.EClass

class Context2DotRenderer { 
	
	@Inject extension IContextProvider contextProvider
	
	@Inject Grammar grammar
	
	@Inject extension Naming naming
	
	@Inject extension Context2NameFunction nameFunction
	
	def Iterable<Pair<EObject, EClass>> types(EObject ctx) {
		ctx.typesForContext.map( t | ctx -> t)
	}
	
	def contexts() {
		grammar.allContexts.map(c | c.types).flatten
	}
	
	def Iterable<Pair<String, String>> render2Dot(GraphvizDotBuilder builder, String name) {
		contexts.map(c | c.getFileName(name) -> builder.draw(c))
	}	
	
	def String getFileName(Pair<EObject, EClass> ctx, String name) {
		val fn = grammar.name.toSimpleName + "_" + ctx.value.name + "_" + ctx.key.contextName + "_" + name;
		grammar.basePackageRuntime.asPath + "/serializer/" + fn + ".dot" 
	}
}