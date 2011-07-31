package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.generator.generator.GeneratorFragment
import org.eclipse.xtext.generator.IGeneratorFragment
import org.eclipse.xtext.generator.DefaultGeneratorFragment
import org.eclipse.xtext.Grammar
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.internal.xpand2.ast.TextStatement
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Naming
import java.util.Set
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.serializer.impl.Serializer
import org.eclipse.xtext.serializer.impl.ContextUtil
import com.google.inject.Inject
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer
import java.util.List

class SerializerFragment extends Xtend2GeneratorFragment {
	
	@Inject AbstractSemanticSequencer abstractSemanticSequencer
	
	@Inject SemanticSequencer semanticSequencer
	
	@Inject AbstractSyntacticSequencer abstractSyntacticSequencer
	
	@Inject SyntacticSequencer syntacticSequencer
	
	@Inject GrammarConstraints grammarConstraints
	
	@Inject Context2DotRenderer dotRenderer
	
	def create result: new SerializerFragmentState() state() {}
	
	def setGenerateDebugData(boolean doGenerate) {
		state.generateDebugData = doGenerate
	}
	
	def setSrcGenOnly(boolean srcGen) {
		state.srcGenOnly = srcGen;
	}
	
	override Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		val bf = new BindFactory();
		if(state.srcGenOnly) {
			bf.addTypeToType(typeof(ISemanticSequencer).name, abstractSemanticSequencer.qualifiedName);
			bf.addTypeToType(typeof(ISyntacticSequencer).name, abstractSyntacticSequencer.qualifiedName);
		} else {
			bf.addTypeToType(typeof(ISemanticSequencer).name, semanticSequencer.qualifiedName);
			bf.addTypeToType(typeof(ISyntacticSequencer).name, syntacticSequencer.qualifiedName);
		}
		bf.addTypeToType(typeof(ISerializer).name, typeof(Serializer).name);
		return bf.bindings;
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		if(!state.srcGenOnly) {
			ctx.writeFile(Generator::SRC, semanticSequencer.fileName, semanticSequencer.fileContents);
			ctx.writeFile(Generator::SRC, syntacticSequencer.fileName, syntacticSequencer.fileContents);
		}
		ctx.writeFile(Generator::SRC_GEN, abstractSemanticSequencer.fileName, abstractSemanticSequencer.fileContents);
		ctx.writeFile(Generator::SRC_GEN, abstractSyntacticSequencer.fileName, abstractSyntacticSequencer.fileContents);
		if(state.generateDebugData) {
			ctx.writeFile(Generator::SRC_GEN, grammarConstraints.fileName, grammarConstraints.fileContents);
//			for(obj:context2DotRenderer.render2Dot(new SyntacticSequencerPDA2SimpleDot(), "pda"))
//				ctx.writeFile(Generator::SRC_GEN, obj.key, obj.value);
			for(obj:dotRenderer.render2Dot(new SyntacticSequencerPDA2ExtendedDot(), "pda"))
				ctx.writeFile(Generator::SRC_GEN, obj.key, obj.value);
		}
	}
	
	override getExportedPackagesRtList(Grammar grammar) {
		return newArrayList(semanticSequencer.packageName)
	}
}