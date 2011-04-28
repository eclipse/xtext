package org.eclipse.xtext.generator.serializer 

import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.util.GraphvizDotBuilder
import org.eclipse.xtext.serializer.impl.ContextUtil
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.serializer.impl.Context2NameFunction
import org.eclipse.emf.ecore.EObject

class Context2DotRenderer { 
	
	@Inject extension ContextUtil
	
	@Inject Grammar
	
	@Inject extension Naming
	
	@Inject extension Context2NameFunction
	
	Iterable<Pair<String, String>> render2Dot(GraphvizDotBuilder builder, String name) {
		grammar.allContexts.map(c | c.getFileName(name) -> builder.draw(c))
	}	
	
	String getFileName(EObject ctx, String name) {
		grammar.basePackageRuntime.asPath + "/serializer/" + grammar.name.toSimpleName + "_" + ctx.contextName + "_" + name + ".dot" 
	}
	
}