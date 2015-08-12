/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.grammarAccess

import com.google.inject.Inject
import java.io.IOException
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.ContentHandler
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.service.AbstractElementFinder.AbstractEnumRuleElementFinder
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder
import org.eclipse.xtext.service.GrammarProvider
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.LanguageConfig2
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.annotations.SingletonClassAnnotation

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

@Log
class GrammarAccessFragment2 extends AbstractGeneratorFragment2 {
	
	@Accessors
	String xmlVersion
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject FileAccessFactory fileAccessFactory
	
	@Inject extension GrammarAccessExtensions
	
	override generate(LanguageConfig2 language) {
		val bindingFactory = new GuiceModuleAccess.BindingFactory()
		if (language.grammar.name != 'org.eclipse.xtext.common.Terminals') {
			bindingFactory.addTypeToInstance(ClassLoader.typeRef, 'getClass().getClassLoader()')
		}
		bindingFactory.addTypeToType(IGrammarAccess.typeRef, language.grammar.grammarAccess)
			.contributeTo(language.runtimeGenModule)
		if (projectConfig.runtimeManifest !== null) {
			projectConfig.runtimeManifest.exportedPackages.addAll(#[
				language.naming.runtimeBasePackage, language.naming.runtimeBasePackage + ".services"
			])
		}
		
		doGenerateGrammarAccess(language)
		writeGrammar(language)
	}
	
	def protected String getQualifiedName(AbstractRule rule) {
		return GrammarUtil.getGrammar(rule).name + '.' + rule.name
	}
	
	protected def void writeGrammar(LanguageConfig2 language) {
		val isSaving = Wrapper.wrap(false)
		val ResourceSet cloneInto = new ResourceSetImpl
		// Substitute the resource factory for ecore-files
		cloneInto.resourceFactoryRegistry.extensionToFactoryMap.put(
			FragmentFakingEcoreResource.FactoryImpl.ECORE_SUFFIX, new FragmentFakingEcoreResource.FactoryImpl(isSaving))
		val resourceSet = EcoreUtil2.clone(cloneInto, language.grammar.eResource.resourceSet)
		// Get the copy of the grammar and use this one
		val copy = resourceSet.getResource(language.grammar.eResource.URI, true).contents.head as Grammar

		// Save grammar model
		val path =
			if (xmlVersion === null) {
				copy.classpathRelativePathToBinGrammar
			} else {
				LOG.warn("The property 'xmlVersion' has been specified for this " + GrammarAccessFragment2.simpleName
						+ ". Therefore, the grammar is persisted as XMI and not as binary. This can be a performance drawback.")
				copy.classpathRelativePathToXmi
			}
		val uri = projectConfig.runtimeSrcGen.getURI(path)
		val resource = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE)
		addAllGrammarsToResource(resource, copy, new HashSet<Grammar>())
		isSaving.set(true)
		val Map<String, Object> saveOptions = newHashMap
		if (resource instanceof XMLResource) {
			resource.XMLVersion = xmlVersion ?: '1.0'
		} else if (resource instanceof BinaryResourceImpl){
			saveOptions.put(BinaryResourceImpl.OPTION_VERSION, BinaryResourceImpl.BinaryIO.Version.VERSION_1_1)
			saveOptions.put(BinaryResourceImpl.OPTION_STYLE_DATA_CONVERTER, true)
		}
		try {
			resource.save(saveOptions)
		} catch (IOException e) {
			LOG.error(e.getMessage(), e)
		} finally {
			isSaving.set(false)
		}
	}

	protected def void addAllGrammarsToResource(Resource resource, Grammar grammar, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar)) {
			return
		}
		resource.contents.add(grammar)
		// Replace resource URIs with namespace URIs
		for (metamodelDecl : grammar.metamodelDeclarations) {
			val pack = metamodelDecl.EPackage
			val packResource = pack.eResource
			if (packResource.URI.toString != pack.nsURI) {
				val packResourceSet = packResource.resourceSet
				if (packResourceSet !== null) {
					var topMost = pack
					// We need to be aware of empty subpackages
					while (topMost.ESuperPackage !== null && topMost.ESuperPackage.eResource === topMost.eResource) {
						topMost = topMost.ESuperPackage
					}
					if (packResource.contents.contains(topMost) && packResource.contents.size == 1) {
						if (!topMost.EClassifiers.empty)
							packResource.setURI(URI.createURI(topMost.nsURI))
						else
							moveSubpackagesToNewResource(topMost, resource.resourceSet)
					}
					if (!topMost.eResource.URI.toString.equals(topMost.nsURI)) 
						movePackageToNewResource(topMost, resource.resourceSet)
				}
			}
		}
		for (usedGrammar : grammar.usedGrammars) {
			addAllGrammarsToResource(resource, usedGrammar, visitedGrammars)
		}
	}

	protected def void moveSubpackagesToNewResource(EPackage pack, ResourceSet set) {
		for (var i = pack.ESubpackages.size - 1; i >= 0; i--) {
			val sub = pack.ESubpackages.get(i)
			if (sub.eResource === pack.eResource) {
				if (sub.EClassifiers.empty) {
					moveSubpackagesToNewResource(sub, set)
				} else {
					movePackageToNewResource(sub, set)
					pack.ESubpackages.remove(i)
				}
			}
		}
	}

	protected def void movePackageToNewResource(EPackage pack, ResourceSet set) {
		val resource = set.createResource(
				URI.createURI('___temp___.' + FragmentFakingEcoreResource.FactoryImpl.ECORE_SUFFIX),
				ContentHandler.UNSPECIFIED_CONTENT_TYPE)
		resource.setURI(URI.createURI(pack.nsURI))
		resource.contents.add(pack)
	}
	
	protected def doGenerateGrammarAccess(LanguageConfig2 language) {
		val javaFile = fileAccessFactory.with(language).createJavaFile(language.grammar.grammarAccess)
		javaFile.annotations += new SingletonClassAnnotation
		javaFile.javaContent = '''
			public class «language.grammar.grammarAccess.simpleName» extends «AbstractGrammarElementFinder» {
				
				«FOR r : language.grammar.rules.filter(ParserRule)»
					«parserRuleClasses(r)»
				«ENDFOR»
				
				«FOR r : language.grammar.rules.filter(EnumRule)»
					«parserRuleClasses(r)»
				«ENDFOR»
				
				«FOR r : language.grammar.rules»
					«cache(r)»
				«ENDFOR»
				
				private final «Grammar» grammar;
				«FOR g : language.grammar.usedGrammars»
					
					private final «g.grammarAccess» «g.gaGrammarAccessLocalVarName»;
				«ENDFOR»
			
				@«Inject»
				public «language.grammar.grammarAccess.simpleName»(«GrammarProvider» grammarProvider«FOR g : language.grammar.usedGrammars»,
						«g.grammarAccess» «g.gaGrammarAccessLocalVarName»«ENDFOR») {
					this.grammar = internalFindGrammar(grammarProvider);
					«FOR g : language.grammar.usedGrammars»
						this.«g.gaGrammarAccessLocalVarName» = «g.gaGrammarAccessLocalVarName»;
					«ENDFOR»
					«FOR r : language.grammar.rules»
						«initializer(r)»
					«ENDFOR»
				}
				
				protected «Grammar» internalFindGrammar(«GrammarProvider» grammarProvider) {
					«Grammar» grammar = grammarProvider.getGrammar(this);
					while (grammar != null) {
						if ("«language.grammar.name»".equals(grammar.getName())) {
							return grammar;
						}
						«List»<«Grammar»> grammars = grammar.getUsedGrammars();
						if (!grammars.isEmpty()) {
							grammar = grammars.iterator().next();
						} else {
							return null;
						}
					}
					return grammar;
				}
				
				@Override
				public «Grammar» getGrammar() {
					return grammar;
				}
				
				«FOR g : language.grammar.usedGrammars»
					
					public «g.grammarAccess» get«g.grammarAccess.simpleName»() {
						return «g.gaGrammarAccessLocalVarName»;
					}
				«ENDFOR»
			
				«FOR r : language.grammar.allRules»
					
					«getter(r, language.grammar)»
				«ENDFOR»
			}
		'''
		javaFile.writeTo(projectConfig.runtimeSrcGen)
	}
	
	protected def StringConcatenationClient parserRuleClasses(ParserRule it) '''
		public class «gaRuleAccessorClassName» extends «AbstractParserRuleElementFinder» {
			private final «ParserRule» rule = («ParserRule») «GrammarUtil».findRuleForName(getGrammar(), "«qualifiedName»");
			«FOR e : containedAbstractElements»
				private final «e.eClass» «e.gaElementAccessorLocalVarName» = «e.loadElementStatement»;
			«ENDFOR»
			
			«grammarFragmentToString('//')»
			@Override public «ParserRule» getRule() { return rule; }
			«FOR e : containedAbstractElements»
				
				«e.grammarFragmentToString('//')»
				public «e.eClass» «e.gaElementAccessMethodName»() { return «e.gaElementAccessorLocalVarName»; }
			«ENDFOR»
		}
	'''
	
	protected def StringConcatenationClient parserRuleClasses(EnumRule it) '''
		public class «gaRuleAccessorClassName» extends «AbstractEnumRuleElementFinder» {
			private final «EnumRule» rule = («EnumRule») «GrammarUtil».findRuleForName(getGrammar(), "«qualifiedName»");
			«FOR e : containedAbstractElements»
				private final «e.eClass» «e.gaElementAccessorLocalVarName» = «e.loadElementStatement»;
			«ENDFOR»
			
			«grammarFragmentToString('//')»
			public EnumRule getRule() { return rule; }
			«FOR e : containedAbstractElements»
				
				«e.grammarFragmentToString('//')»
				public «e.eClass» «e.gaElementAccessMethodName»() { return «e.gaElementAccessorLocalVarName»; }
			«ENDFOR»
		}
	'''
	
	protected def dispatch StringConcatenationClient cache(ParserRule it) '''
		private final «gaRuleAccessorClassName» «gaRuleAccessorLocalVarName»;
	'''
	
	protected def dispatch StringConcatenationClient cache(EnumRule it) '''
		private final «gaRuleAccessorClassName» «gaRuleAccessorLocalVarName»;
	'''
	
	protected def dispatch StringConcatenationClient cache(TerminalRule it) '''
		private final «TerminalRule» «gaRuleAccessorLocalVarName»;
	'''
	
	protected def dispatch StringConcatenationClient initializer(ParserRule it) '''
		this.«gaRuleAccessorLocalVarName» = new «gaRuleAccessorClassName»();
	'''
	
	protected def dispatch StringConcatenationClient initializer(EnumRule it) '''
		this.«gaRuleAccessorLocalVarName» = new «gaRuleAccessorClassName»();
	'''
	
	protected def dispatch StringConcatenationClient initializer(TerminalRule it) '''
		this.«gaRuleAccessorLocalVarName» = («TerminalRule») «GrammarUtil».findRuleForName(getGrammar(), "«qualifiedName»");
	'''
	
	protected def dispatch StringConcatenationClient getter(ParserRule it, Grammar original) '''
		«grammarFragmentToString('//')»
		«IF grammar === original»
			public «gaRuleAccessorClassName» «gaElementsAccessor» {
				return «gaRuleAccessorLocalVarName»;
			}
		«ELSE»	
			public «grammar.grammarAccess».«gaBaseRuleAccessorClassName» «gaElementsAccessor» {
				return «usedGrammar(original).gaGrammarAccessLocalVarName».«gaBaseElementsAccessor»;
			}
		«ENDIF»
		
		public ParserRule «gaRuleAccessor» {
			return «gaElementsAccessor».getRule();
		}
	'''
	
	protected def dispatch StringConcatenationClient getter(EnumRule it, Grammar original) '''
		«grammarFragmentToString('//')»
		«IF grammar === original»
			public «gaRuleAccessorClassName» «gaElementsAccessor» {
				return «gaRuleAccessorLocalVarName»;
			}
		«ELSE»	
			public «grammar.grammarAccess».«gaRuleAccessorClassName» «gaElementsAccessor» {
				return «usedGrammar(original).gaGrammarAccessLocalVarName».«gaElementsAccessor»;
			}
		«ENDIF»
		
		public «EnumRule» «gaRuleAccessor» {
			return «gaElementsAccessor».getRule();
		}
	'''
	
	protected def dispatch StringConcatenationClient getter(TerminalRule it, Grammar original) '''
		«grammarFragmentToString('//')»
		public «TerminalRule» «gaRuleAccessor» {
			«IF grammar === original»
				return «gaRuleAccessorLocalVarName»;
			«ELSE»
				return «usedGrammar(original).gaGrammarAccessLocalVarName».«gaBaseRuleAccessor»;
			«ENDIF»
		}
	'''
	
	protected def String gaGrammarAccessLocalVarName(Grammar g) {
		'ga' + GrammarUtil.getName(g)
	}
	
	protected def String gaElementAccessorLocalVarName(AbstractElement ele) {
		'c' + ele.gaElementIdentifier
	}
		
	protected def dispatch String gaRuleAccessorLocalVarName(ParserRule rule) {
		'p' + rule.gaRuleIdentifier
	}
	
	protected def dispatch String gaRuleAccessorLocalVarName(TerminalRule rule) {
		't' + rule.gaRuleIdentifier
	}

	protected def StringConcatenationClient loadElementStatement(AbstractElement ele) {
		'''(«ele.eClass»)«ele.loadElementParentStatement».eContents().get(«ele.eContainer.eContents.indexOf(ele)»)'''
	}
	
	protected def String loadElementParentStatement(AbstractElement ele) {
		if (ele.eContainer instanceof AbstractElement)
			(ele.eContainer as AbstractElement).gaElementAccessorLocalVarName 
		else
			"rule"
	}
	
	protected def Grammar usedGrammar(AbstractRule rule, Grammar parent) {
		parent.usedGrammars.findFirst[allRules.contains(rule)]
	}
	
}