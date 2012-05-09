package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.serializer.impl.Serializer
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer

class SerializerFragment extends Xtend2GeneratorFragment {
	
	@Inject AbstractSemanticSequencer abstractSemanticSequencer
	
	@Inject SemanticSequencer semanticSequencer
	
	@Inject AbstractSyntacticSequencer abstractSyntacticSequencer
	
	@Inject SyntacticSequencer syntacticSequencer
	
	@Inject GrammarConstraints grammarConstraints
	
	@Inject DebugGraphGenerator debugGraphGenerator
	
	@Inject SerializerGenFileNames names
	
	boolean generateDebugData = false;
	
	boolean srcGenOnly = false;
	
	def setGenerateDebugData(boolean doGenerate) {
		generateDebugData = doGenerate
	}
	
	def setSrcGenOnly(boolean srcGen) {
		srcGenOnly = srcGen;
	}
	
	def setGenerateStub(boolean generateStub) {
		srcGenOnly = !generateStub
	}
	
	override Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		val bf = new BindFactory();
		bf.addTypeToType(typeof(ISemanticSequencer).name, names.semanticSequencer.qualifiedName);
		bf.addTypeToType(typeof(ISyntacticSequencer).name, names.syntacticSequencer.qualifiedName);
		bf.addTypeToType(typeof(ISerializer).name, typeof(Serializer).name);
		return bf.bindings;
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		if(srcGenOnly) {
			ctx.writeFile(Generator::SRC_GEN, names.semanticSequencer.fileName, abstractSemanticSequencer.getFileContents(names.semanticSequencer));
			ctx.writeFile(Generator::SRC_GEN, names.syntacticSequencer.fileName, abstractSyntacticSequencer.getFileContents(names.syntacticSequencer));
		} else {
			ctx.writeFile(Generator::SRC, names.semanticSequencer.fileName, semanticSequencer.getFileContents(names.semanticSequencer));
			ctx.writeFile(Generator::SRC, names.syntacticSequencer.fileName, syntacticSequencer.getFileContents(names.syntacticSequencer));
			ctx.writeFile(Generator::SRC_GEN, names.abstractSemanticSequencer.fileName, abstractSemanticSequencer.getFileContents(names.abstractSemanticSequencer));
			ctx.writeFile(Generator::SRC_GEN, names.abstractSyntacticSequencer.fileName, abstractSyntacticSequencer.getFileContents(names.abstractSyntacticSequencer));
		}
		if(generateDebugData) {
			ctx.writeFile(Generator::SRC_GEN, names.grammarConstraints.fileName, grammarConstraints.getFileContents(names.grammarConstraints));
			for(obj:debugGraphGenerator.generateDebugGraphs) 
				ctx.writeFile(Generator::SRC_GEN, obj.key, obj.value);
		}
	}
	
	override getExportedPackagesRtList(Grammar grammar) {
		return newArrayList(names.semanticSequencer.packageName)
	}
}