package org.eclipse.xtext.generator.serializer 

import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.util.GraphvizDotBuilder
import org.eclipse.xtext.serializer.IContextProvider
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.serializer.analysis.Context2NameFunction
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider$SequencerPDAContext

class Context2DotRenderer { 
	
	@Inject extension IContextProvider
	
	@Inject Grammar
	
	@Inject extension Naming
	
	@Inject extension Context2NameFunction
	
	types(EObject ctx) {
		ctx.typesForContext.map( t | new SyntacticSequencerPDAProvider$SequencerPDAContext(ctx, t))
	}
	
	contexts() {
		grammar.allContexts.map(c | c.types).flatten
	}
	
	Iterable<Pair<String, String>> render2Dot(GraphvizDotBuilder builder, String name) {
		contexts.map(c | c.getFileName(name) -> builder.draw(c))
	}	
	
	String getFileName(SyntacticSequencerPDAProvider$SequencerPDAContext ctx, String name) {
		val fn = grammar.name.toSimpleName + "_" + ctx.type.name + "_" + ctx.context.contextName + "_" + name;
		grammar.basePackageRuntime.asPath + "/serializer/" + fn + ".dot" 
	}
	
}