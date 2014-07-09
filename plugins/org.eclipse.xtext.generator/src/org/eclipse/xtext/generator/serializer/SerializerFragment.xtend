/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
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
import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.xtext.generator.IStubGenerating
import static java.util.Collections.*

class SerializerFragment extends Xtend2GeneratorFragment implements IStubGenerating, IStubGenerating.XtendOption {
	
	@Inject AbstractSemanticSequencer abstractSemanticSequencer
	
	@Inject SemanticSequencer semanticSequencer
	
	@Inject AbstractSyntacticSequencer abstractSyntacticSequencer
	
	@Inject SyntacticSequencer syntacticSequencer
	
	@Inject GrammarConstraints grammarConstraints
	
	@Inject DebugGraphGenerator debugGraphGenerator
	
	@Inject SerializerGenFileNames names
	
	boolean generateDebugData = false;
	
	boolean srcGenOnly = false;
	
	@Property boolean generateXtendStub
	
	override protected addLocalBindings(Binder binder) {
		binder
			.bind(Boolean).annotatedWith(Names.named("generateXtendStub")).toInstance(generateXtendStub && generateStub)
	}
	
	def setGenerateDebugData(boolean doGenerate) {
		generateDebugData = doGenerate
	}
	
	def setSrcGenOnly(boolean srcGen) {
		srcGenOnly = srcGen;
	}
	
	override setGenerateStub(boolean generateStub) {
		srcGenOnly = !generateStub
	}
	
	override isGenerateStub() {
		!srcGenOnly
	}
	
	override Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		val bf = new BindFactory();
		bf.addTypeToType(ISemanticSequencer.name, names.semanticSequencer.qualifiedName);
		bf.addTypeToType(ISyntacticSequencer.name, names.syntacticSequencer.qualifiedName);
		bf.addTypeToType(ISerializer.name, Serializer.name);
		return bf.bindings;
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		if(srcGenOnly) {
			ctx.writeFile(Generator.SRC_GEN, names.semanticSequencer.fileName, abstractSemanticSequencer.getFileContents(names.semanticSequencer));
			ctx.writeFile(Generator.SRC_GEN, names.syntacticSequencer.fileName, abstractSyntacticSequencer.getFileContents(names.syntacticSequencer));
		} else {
			ctx.writeFile(Generator.SRC, names.semanticSequencer.fileName, semanticSequencer.getFileContents(names.semanticSequencer));
			ctx.writeFile(Generator.SRC, names.syntacticSequencer.fileName, syntacticSequencer.getFileContents(names.syntacticSequencer));
			ctx.writeFile(Generator.SRC_GEN, names.abstractSemanticSequencer.fileName, abstractSemanticSequencer.getFileContents(names.abstractSemanticSequencer));
			ctx.writeFile(Generator.SRC_GEN, names.abstractSyntacticSequencer.fileName, abstractSyntacticSequencer.getFileContents(names.abstractSyntacticSequencer));
		}
		if(generateDebugData) {
			ctx.writeFile(Generator.SRC_GEN, names.grammarConstraints.fileName, grammarConstraints.getFileContents(names.grammarConstraints));
			for(obj:debugGraphGenerator.generateDebugGraphs) 
				ctx.writeFile(Generator.SRC_GEN, obj.key, obj.value);
		}
	}
	
	override getExportedPackagesRtList(Grammar grammar) {
		return newArrayList(names.semanticSequencer.packageName)
	}
	
	override getRequiredBundlesRt(Grammar grammar) {
		if(generateXtendStub) 
			singletonList('org.eclipse.xtext.xbase.lib')
		else 
			null
	}
	
}