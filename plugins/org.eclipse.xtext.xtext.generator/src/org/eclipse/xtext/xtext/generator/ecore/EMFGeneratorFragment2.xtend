/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ecore

import com.google.common.collect.Sets
import com.google.common.io.CharStreams
import com.google.inject.Inject
import com.google.inject.Injector
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.nio.charset.Charset
import java.util.Collection
import java.util.Collections
import java.util.List
import java.util.Map
import java.util.Properties
import java.util.Set
import org.eclipse.emf.codegen.ecore.generator.Generator
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenRuntimeVersion
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl
import org.eclipse.emf.codegen.merge.java.JControlModel
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.EClassImpl
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.resource.ContentHandler
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage
import org.eclipse.emf.ecore.xml.type.XMLTypePackage
import org.eclipse.emf.mwe.core.ConfigurationException
import org.eclipse.emf.mwe.utils.GenModelHelper
import org.eclipse.emf.mwe2.ecore.CvsIdFilteringGeneratorAdapterFactoryDescriptor
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static org.eclipse.xtext.GrammarUtil.*

import static extension org.eclipse.xtext.xtext.generator.util.GenModelUtil2.*

@Log
class EMFGeneratorFragment2 extends AbstractGeneratorFragment2 {
	
	@Inject CodeConfig codeConfig
	
	/**
	 * The java package into which the generated Java classes shall be placed.
	 */
	@Accessors(PUBLIC_SETTER)
	String basePackage
	
	/**
	 * Whether EMF edit code shall be generated.
	 */
	@Accessors(PUBLIC_SETTER)
	boolean generateEdit = false
	
	/**
	 * The target directory for the generated EMF edit code. Only needed if you want to generate an EMF edit plug-in.
	 */
	@Accessors(PUBLIC_SETTER)
	String editDirectory
	
	/**
	 * The plug-in ID of the generated EMF edit plug-in. Only needed if you want to generate an EMF edit plug-in.
	 */
	@Accessors(PUBLIC_SETTER)
	String editPluginID
	
	/**
	 * Whether EMF editor code shall be generated.
	 */
	@Accessors(PUBLIC_SETTER)
	boolean generateEditor = false
	
	/**
	 * The target directory for the generated EMF editor code. Only needed if you want to generate an EMF editor plug-in.
	 */
	@Accessors(PUBLIC_SETTER)
	String editorDirectory
	
	/**
	 * The plug-in ID of the generated EMF editor plug-in. Only needed if you want to generate an EMF editor plug-in.
	 */
	@Accessors(PUBLIC_SETTER)
	String editorPluginID
	
	/**
	 * If an existing EMF GenModel should be used, set the path to that file in this property.
	 */
	@Accessors(PUBLIC_SETTER)
	String genModel
	
	/**
	 * Sets the target directory for the generated EMF model code. Only needed if you want to generate the EMF code into
	 * a separate plug-in.
	 */
	@Accessors(PUBLIC_SETTER)
	String javaModelDirectory
	
	/**
	 * Sets the ID of the generated EMF model plug-in. Only needed if you want to generate the EMF code into a separate plug-in.
	 */
	@Accessors(PUBLIC_SETTER)
	String modelPluginID
	
	/**
	 * Whether the Java class generation should be skipped. If <code>true</code> only the ecore file is generated.
	 */
	@Accessors(PUBLIC_SETTER)
	boolean skipGenerate = false

	/**
	 * Whether the build.properties should be updated.
	 */
	@Accessors(PUBLIC_SETTER)
	boolean updateBuildProperties = true
	
	@Accessors(PUBLIC_SETTER)
	String fileExtensions
	
	/**
	 * Whether to use a qualified name for the xmi files, e.g.
	 * <code>org_eclipse_xtext_Xtext.ecore</code> rather than <code>Xtext.ecore</code>.
	 */
	@Accessors(PUBLIC_SETTER)
	boolean longFileNames = false
	
	/**
	 * The generated package implementation uses 'load initialization' if it becomes very large, which means
	 * that an additional ecore file is generated and the package content is loaded at runtime from that file.
	 * This is to prevent the compiled class file from becoming too large. Set this property to true in order
	 * to suppress this behavior.
	 */
	@Accessors(PUBLIC_SETTER)
	boolean suppressLoadInitialization = false

	GenRuntimeVersion emfRuntimeVersion
	GenJDKLevel jdkLevel = GenJDKLevel.JDK60_LITERAL
	
	/**
	 * Sets the target EMF runtime version to generate for to the specified value.
	 */
	public def void setEmfRuntimeVersion(String emfRuntimeVersion) {
		this.emfRuntimeVersion = GenRuntimeVersion.get(emfRuntimeVersion)
		if (this.emfRuntimeVersion === null)
			LOG.warn('Illegal EMF runtime version: ' + emfRuntimeVersion)
	}
	
	/**
	 * Set the JDK compatibility level. The following values are valid:
	 * <ul>
	 *   <li>"JDK14"</li>
	 *   <li>"JDK50"</li>
	 *   <li>"JDK60"</li>
	 *   <li>"JDK70"</li>
	 *   <li>"JDK80"</li>
	 * </ul>
	 * The default level is "JDK60".
	 */
	public def void setJdkLevel(String jdkLevel) {
		this.jdkLevel = GenJDKLevel.getByName(jdkLevel)
		if (this.jdkLevel === null)
			LOG.warn('Illegal JDK level: ' + jdkLevel)
	}
	
	protected def String getJavaModelDirectory() {
		javaModelDirectory ?: projectConfig.runtime.srcGen.path
	}

	protected def String getModelName(Grammar grammar) {
		if (longFileNames)
			grammar.name.replace('.', '_')
		else
			getSimpleName(grammar)
	}
	
	protected def String getBasePackage(Grammar grammar) {
		basePackage ?: getNamespace(grammar)
	}
	
	protected def String getEcoreFilePath(Grammar grammar) {
		projectConfig.runtime.ecoreModel.path + '/' + grammar.modelName + '.ecore'
	}
	
	protected def URI getEcoreFileUri(Grammar grammar) {
		URI.createPlatformResourceURI(grammar.ecoreFilePath.canonicalPath, true)
	}
	
	protected def String getGenModelPath(Grammar grammar) {
		genModel ?: projectConfig.runtime.ecoreModel.path + '/' + grammar.modelName + '.genmodel'
	}

	protected def URI getGenModelUri(Grammar grammar) {
		URI.createPlatformResourceURI(grammar.genModelPath.canonicalPath, true)
	}
	
	protected def String getRelativePath(String pathInRoot) {
		val projectRoot = projectConfig.runtime.root.path
		if (pathInRoot.startsWith(projectRoot))
			pathInRoot.substring(projectRoot.length + 1)
		else
			pathInRoot
	}
	
	protected def String getCanonicalPath(String path) {
		val result = <String>newLinkedList
		var isAbsolute = path.startsWith('/')
		for (segment : path.split('[/\\\\]')) {
			if (segment == '..') {
				if (result.empty)
					isAbsolute = true
				else
					result.removeLast()
			} else if (segment.length > 0 && segment != '.')
				result.addLast(segment)
		}
		if (isAbsolute)
			return result.join('/', '/', null, [it])
		else
			return result.join('/')
	}

	protected def String getModelPluginID() {
		modelPluginID ?: {
			val path = projectConfig.runtime.root.path
			path.substring(path.lastIndexOf('/') + 1)
		}
	}
	
	protected def String getEditDirectory() {
		editDirectory ?: projectConfig.runtime.root.path + '.edit/src'
	}

	protected def String getEditorDirectory() {
		editorDirectory ?: projectConfig.runtime.root.path + '.editor/src'
	}

	protected def String getEditPluginID() {
		editPluginID ?: getModelPluginID + '.edit'
	}

	protected def String getEditorPluginID() {
		editorPluginID ?: getModelPluginID + '.editor'
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		if (!Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.containsKey('genmodel'))
			Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put('genmodel', new EcoreResourceFactoryImpl)
		GenModelPackage.eINSTANCE.getGenAnnotation()
	}
	
	override generate() {
		if (grammar.metamodelDeclarations.filter(GeneratedMetamodel).empty) {
			return
		}
		
		try {
			// Create a clone of the grammar that can be safely modified
			val clonedGrammar = cloneGrammarIntoNewResourceSet(grammar)
			val workingResourceSet = clonedGrammar.eResource.resourceSet
			
			// Collect all the copies of the generated EPackages of this grammar
			val generatedPackages = clonedGrammar.metamodelDeclarations.filter(GeneratedMetamodel).map[EPackage].toList
			
			// Register the to-be-used genmodel if it was explicitly set
			if (genModel !== null)
				registerUsedGenModel(workingResourceSet.URIConverter, clonedGrammar)
			
			// Just to make sure that we really have a generated package and not only a meta model declaration
			if (!generatedPackages.empty) {
				// Create an index for all EPackages that are used by the generated packages
				val usedEPackages = findAllUsedEPackages(generatedPackages)
				
				// Try to find the ecore files for the potentially installed packages 
				val loadedEPackages = findEPackagesInGenPackages(usedEPackages.keySet, workingResourceSet)
				
				// Map the elements from the installed version to the file-version
				val eNamedElementMapping = createENamedElementMapping(usedEPackages, loadedEPackages)
				
				// Replace all the references to installed elements with their loaded equivalent
				replaceReferencesInGeneratedPackages(generatedPackages, eNamedElementMapping)
				
				// Put all the generated packages into a single resource
				val ePackageResource = createResourceForEPackages(clonedGrammar, generatedPackages, workingResourceSet)
				
				if (!skipGenerate) {
					LOG.info('''Generating EMF model«IF generateEdit»«IF generateEditor», edit«ELSE» and edit«ENDIF»«ENDIF»«IF generateEditor» and editor«ENDIF» code''')
					
					// Obtain the genmodel - either load the given resource (this.genModel) or create a new one
					val genModel = getSaveAndReconcileGenModel(clonedGrammar, generatedPackages, workingResourceSet)
					
					// Make sure everything is set
					genModel.reconcile()
					
					// Execute the emf generator
					doGenerate(genModel)
					
					addProjectContributions(clonedGrammar, generatedPackages, workingResourceSet)
				}
				
				// Finally save the ecore packages to the file system
				saveResource(ePackageResource)
			}
			
			updateBuildProperties()
		} catch (Exception e) {
			LOG.error('Failed to execute EMF generator', e)
		}
	}
	
	protected def void addProjectContributions(Grammar grammar, List<EPackage> generatedPackages, ResourceSet rs) {
		if (projectConfig.runtime.pluginXml !== null) {
			projectConfig.runtime.pluginXml.entries += '''
				<extension point="org.eclipse.emf.ecore.generated_package">
					«FOR pack : generatedPackages»
						<package 
							uri = "«pack.nsURI»"
							class = "«pack.getGenPackage(rs).qualifiedPackageInterfaceName»"
							genModel = "«grammar.genModelPath.relativePath»" />
					«ENDFOR»
				</extension>
			'''
		}
		if (projectConfig.runtime.manifest !== null) {
			projectConfig.runtime.manifest.requiredBundles.addAll('org.eclipse.emf.ecore', 'org.eclipse.emf.common')
		}
		for (pack : generatedPackages) {
			val genPackage = pack.getGenPackage(rs)
			if (projectConfig.runtime.manifest !== null && modelPluginID == null) {
				projectConfig.runtime.manifest.exportedPackages.addAll(
					genPackage.interfacePackageName,
					genPackage.classPackageName,
					genPackage.utilitiesPackageName
				)
			}
			language.runtimeGenSetup.registrations.add('''
				if (!«EPackage».Registry.INSTANCE.containsKey("«pack.nsURI»")) {
					«EPackage».Registry.INSTANCE.put("«pack.nsURI»", «new TypeReference(genPackage.qualifiedPackageInterfaceName)».eINSTANCE);
				}
			''')
		}
	}
	
	/**
	 * Create a clone of the original grammar. The clone will not refer to a node model.
	 */
	private def Grammar cloneGrammarIntoNewResourceSet(Grammar original) {
		val originalResource = original.eResource
		val clonedResourceSet = EcoreUtil2.clone(new XtextResourceSet, originalResource.resourceSet)
		val clonedResource = clonedResourceSet.getResource(originalResource.URI, false)
		return clonedResource.contents.head as Grammar
	}
	
	private def void registerUsedGenModel(URIConverter converter, Grammar grammar) {
		val genModelUri = grammar.genModelUri
		if (converter.exists(genModelUri, null)) {
			try {
				new GenModelHelper().registerGenModel(new XtextResourceSet, genModelUri)
			} catch (ConfigurationException ce) {
				throw ce
			} catch (Exception e) {
				LOG.error('Failed to register GenModel', e);
			}
		}
	}
	
	private def Map<String, EPackage> findAllUsedEPackages(List<EPackage> generatedPackages) {
		val result = newHashMap
		val packageContentIterator = EcoreUtil.<EObject>getAllContents(generatedPackages)
		while (packageContentIterator.hasNext) {
			val current = packageContentIterator.next
			for (referenced : current.eCrossReferences) {
				if (referenced.eIsProxy)
					throw new RuntimeException('Unresolved proxy: ' + referenced + ' in ' + current)
				if (referenced instanceof EClassifier) {
					val referencedPackage = referenced.EPackage
					if (!generatedPackages.contains(referencedPackage))
						result.put(referencedPackage.nsURI, referencedPackage)
				}
			}
		}
		return result
	}
	
	private def Map<String, EPackage> findEPackagesInGenPackages(Collection<String> packageNsURIs, ResourceSet resourceSet) {
		val result = <String, EPackage>newHashMap
		for (nsURI : packageNsURIs) {
			val resource = getGenModelResource(null, nsURI, resourceSet)
			if (resource != null) {
				val loadedGenModel = resource.contents.filter(GenModel).head
				if (loadedGenModel !== null) {
					val genPackage = findGenPackageByNsURI(loadedGenModel, nsURI)
					result.put(nsURI, genPackage.getEcorePackage)
				}
			}
		}
		return result
	}
	
	private def GenPackage findGenPackageByNsURI(GenModel genModel, String nsURI) {
		val allGenPackages = genModel.getAllGenUsedAndStaticGenPackagesWithClassifiers
		for (genPackage: allGenPackages) {
			val ecorePackage = genPackage.getEcorePackage
			if (ecorePackage === null || ecorePackage.eIsProxy)
				throw new RuntimeException('Unresolved proxy: ' + ecorePackage + ' in ' + genModel.eResource.URI)
			if (nsURI == ecorePackage.nsURI)
				return genPackage
		}
		throw new RuntimeException('No GenPackage for NsURI ' + nsURI + ' found in ' + genModel.eResource.URI)
	}

	private def Map<EObject, EObject> createENamedElementMapping(Map<String, EPackage> usedEPackages,
			Map<String, EPackage> loadedEPackages) {
		val result = newHashMap
		for (entry : usedEPackages.entrySet) {
			putMappingData(result, entry.value, loadedEPackages.get(entry.key))
		}
		return result
	}

	private def void putMappingData(Map<EObject, EObject> result, EPackage usedEPackage, EPackage loadedEPackage) {
		if (loadedEPackage !== null && usedEPackage != loadedEPackage) {
			result.put(usedEPackage, loadedEPackage)
			for (usedClassifier : usedEPackage.EClassifiers) {
				val loadedClassifier = loadedEPackage.getEClassifier(usedClassifier.name)
				if (loadedClassifier === null)
					throw new RuntimeException("Cannot find classifier '" + usedClassifier.name + "' in loaded EPackage from " + loadedEPackage.eResource.URI)
				result.put(usedClassifier, loadedClassifier)
			}
			for (usedNestedPackage : usedEPackage.ESubpackages) {
				val loadedNestedPackage = loadedEPackage.ESubpackages.findFirst[name == usedNestedPackage.name]
				if (loadedNestedPackage !== null)
					putMappingData(result, usedNestedPackage, loadedNestedPackage)
			}
		}
	}

	private def void replaceReferencesInGeneratedPackages(List<EPackage> generatedPackages,
			Map<EObject, EObject> eNamedElementMapping) {
		val packageContentIterator = EcoreUtil.<EObject>getAllContents(generatedPackages)
		while (packageContentIterator.hasNext) {
			val current = packageContentIterator.next
			val crossReferenceFeatures = (current.eClass.EAllStructuralFeatures as EClassImpl.FeatureSubsetSupplier).crossReferences
			if (crossReferenceFeatures !== null) {
				for (crossReferenceFeature : crossReferenceFeatures) {
					if (crossReferenceFeature.isChangeable) {
						val reference = crossReferenceFeature as EReference
						if (reference.isMany) {
							val values = current.eGet(reference) as List<EObject>
							for (value : values) {
								if (eNamedElementMapping.containsKey(value))
									EcoreUtil.replace(current, reference, value, eNamedElementMapping.get(value))
							}
						} else {
							val value = current.eGet(reference) as EObject
							if (eNamedElementMapping.containsKey(value))
								EcoreUtil.replace(current, reference, value, eNamedElementMapping.get(value))
						}
					}
				}
			}
		}
	}
	
	protected def Resource createResourceForEPackages(Grammar grammar, List<EPackage> packs, ResourceSet rs) {
		val ecoreFileUri = grammar.ecoreFileUri
		val existing = rs.getResource(ecoreFileUri, false)
		if (existing !== null) {
			existing.unload()
			rs.resources.remove(existing)
		}
		val ecoreFile = rs.createResource(ecoreFileUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE)
		ecoreFile.contents.addAll(packs)
		return ecoreFile
	}
	
	protected def GenModel getSaveAndReconcileGenModel(Grammar grammar, List<EPackage> packs, ResourceSet rs) {
		val genModel = getGenModel(rs, grammar)
		genModel.initialize(packs)
		for (genPackage : genModel.getGenPackages) {
			genPackage.basePackage = grammar.basePackage
			if (suppressLoadInitialization)
				genPackage.loadInitialization = false
			if (fileExtensions !== null && packs.contains(genPackage.getEcorePackage))
				genPackage.fileExtensions = fileExtensions
		}
		val referencedEPackages = getReferencedEPackages(packs)
		val usedGenPackages = getGenPackagesForPackages(genModel, referencedEPackages)
		reconcileMissingGenPackagesInUsedModels(usedGenPackages)
		genModel.usedGenPackages.addAll(usedGenPackages)
		saveResource(genModel.eResource)
		new GenModelHelper().registerGenModel(genModel)
		return genModel
	}
	
	private def void reconcileMissingGenPackagesInUsedModels(List<GenPackage> usedGenPackages) {
		val processedModels = Sets.newHashSetWithExpectedSize(usedGenPackages.size)
		for (usedGenPackage : usedGenPackages) {
			val genModel = usedGenPackage.genModel
			if (processedModels.add(genModel)) {
				val missingPackages = genModel.missingPackages
				val missingGenPackages = getGenPackagesForPackages(genModel, missingPackages)
				genModel.usedGenPackages.addAll(missingGenPackages)
			}
		}
	}

	protected def GenModel getGenModel(ResourceSet rs, Grammar grammar) {
		val genModelUri = grammar.genModelUri
		val resource = rs.getResource(genModelUri, false)
		if (resource !== null) {
			resource.unload()
			rs.resources.remove(resource)
		}
		val genModelFile = rs.createResource(genModelUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE)
		var GenModel genModel
		if (rs.URIConverter.exists(genModelUri, null)) {
			genModelFile.load(null)
			if (genModelUri.hasFragment) {
				genModel = genModelFile.getEObject(genModelUri.fragment) as GenModel
			} else {
				genModel = genModelFile.contents.head as GenModel
			}
		} else {
			// The name of the additional ecore file used for load initialization is hard-coded in GenPackageImpl.
			// We want to override it to avoid validation of that file, which uses NS URIs for references.
			genModel = new GenModelImpl {
				override createGenPackage() {
					return new GenPackageImpl {
						override getSerializedPackageFilename() {
							name + '.loadinitialization_ecore'
						}
					}
				}
			}
			genModel.modelName = grammar.modelName
			genModel.modelDirectory = getJavaModelDirectory.toGenModelProjectPath
			genModel.modelPluginID = getModelPluginID
			genModel.editDirectory = getEditDirectory.toGenModelProjectPath
			genModel.editPluginID = getEditPluginID
			genModel.editorDirectory = getEditorDirectory.toGenModelProjectPath
			genModel.editorPluginID = getEditorPluginID
			genModel.validateModel = false
			genModel.forceOverwrite = true
			genModel.canGenerate = true
			genModel.facadeHelperClass = null
			genModel.bundleManifest = true
			genModel.updateClasspath = false
			genModel.complianceLevel = jdkLevel
			genModel.runtimeVersion = emfRuntimeVersion
			genModel.rootExtendsClass = 'org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container'
			genModel.lineDelimiter = codeConfig.lineDelimiter
		}
		genModelFile.contents.add(genModel)
		return genModel
	}

	/**
	 * Required to match the path format as expected from {@link GenModelImpl#getProjectPath}.
	 */
	protected def String toGenModelProjectPath(String path) {
		if (path.nullOrEmpty || path.startsWith('/') || !path.contains('/'))
			path
		else
			path.substring(path.indexOf('/'))
	}
	
	protected def Set<EPackage> getReferencedEPackages(List<EPackage> packs) {
		val result = newHashSet
		for (pkg : packs) {
			val iterator = pkg.eAllContents
			while (iterator.hasNext) {
				val obj = iterator.next
				for (crossRef : obj.eCrossReferences) {
					if (crossRef.eIsProxy)
						LOG.error("Proxy '" + (crossRef as InternalEObject).eProxyURI + "' could not be resolved")
					else {
						val p = EcoreUtil2.getContainerOfType(crossRef, EPackage)
						if (p !== null)
							result.add(p)
					}
				}
			}
		}
		result.removeAll(packs)
		// The following GenModels are handled by the EMF generator as implemented in
		// org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl.findGenPackage(EPackage)
		result.remove(EcorePackage.eINSTANCE)
		result.remove(XMLTypePackage.eINSTANCE)
		result.remove(XMLNamespacePackage.eINSTANCE)
		return result
	}

	protected def List<GenPackage> getGenPackagesForPackages(GenModel existingGenModel, Collection<EPackage> packs) {
		val result = <GenPackage>newArrayList
		for (EPackage pkg : packs) {
			if (!existingGenModel.genPackages.exists[getEcorePackage?.nsURI == pkg.nsURI])
				result.add(getGenPackage(pkg, existingGenModel.eResource.resourceSet))
		}
		Collections.sort(result, [ o1, o2 |
			EcoreUtil.getURI(o1).toString.compareTo(EcoreUtil.getURI(o2).toString)
		])
		return result
	}

	private def void saveResource(Resource resource) {
		val saveOptions = newHashMap
		saveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.AbsoluteCrossBundleAware {
			override deresolve(URI uri) {
				if (!uri.isPlatform) {
					for (entry : EcorePlugin.platformResourceMap.entrySet) {
						val newPrefix = URI.createURI('platform:/resource/' + entry.key + '/')
						val uri2 = uri.replacePrefix(entry.value, newPrefix)
						if (uri2 !== null)
							return super.deresolve(uri2)
					}
				}
				return super.deresolve(uri)
			}
		})
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, codeConfig.lineDelimiter)
		resource.save(saveOptions)
	}
	
	protected def void doGenerate(GenModel genModel) {
		val generator = new Generator {
			override getJControlModel() {
				if (jControlModel == null) {
					jControlModel = new JControlModel
					jControlModel.initialize(null, options.mergeRulesURI)
				}
				return jControlModel
			}
		}
		generator.getAdapterFactoryDescriptorRegistry.addDescriptor(GenModelPackage.eNS_URI,
				new CvsIdFilteringGeneratorAdapterFactoryDescriptor(codeConfig.lineDelimiter))
		genModel.canGenerate = true
		generator.input = genModel
		val diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor)
		
		if (diagnostic.severity != Diagnostic.OK)
			LOG.warn(diagnostic)
		
		if (generateEdit) {
			val editDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, new BasicMonitor)
			if (editDiag.severity != Diagnostic.OK)
				LOG.warn(editDiag)
		}
		
		if (generateEditor) {
			val editorDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, new BasicMonitor)
			if (editorDiag.severity != Diagnostic.OK)
				LOG.warn(editorDiag)
		}
	}

	private def void updateBuildProperties() {
		if (!updateBuildProperties || modelPluginID !== null)
			return;
		val rootOutlet = projectConfig.runtime.root
		val buildPropertiesPath = rootOutlet.path + '/build.properties'
		val modelContainer = projectConfig.runtime.ecoreModelFolder
		val buildProperties = new Properties
		val reader = new InputStreamReader(new FileInputStream(new File(buildPropertiesPath)), Charset.forName(codeConfig.encoding))
		try {
			var existingContent = CharStreams.toString(reader)
			buildProperties.load(new StringInputStream(existingContent, 'ISO-8859-1'))
			val binIncludes = buildProperties.getProperty('bin.includes')
			var changed = false
			if (binIncludes === null) {
				existingContent += 'bin.includes = ' + modelContainer + Strings.newLine + '               '
				changed = true
			} else if (!binIncludes.contains(modelContainer)) {
				existingContent = existingContent.replace('bin.includes = ', 'bin.includes = ' + modelContainer + ',\\' + Strings.newLine + '               ')
				changed = true
			}
			if (changed) {
				val writer = new OutputStreamWriter(new FileOutputStream(new File(buildPropertiesPath)), Charset.forName(codeConfig.encoding))
				writer.write(existingContent)
				writer.close()
			}
		} finally {
			reader.close()
		}
	}

}