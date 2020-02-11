/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import static org.eclipse.xtext.EcoreUtil2.*;
import static org.eclipse.xtext.XtextPackage.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenRuntimeVersion;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.AbsoluteCrossBundleAware;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.utils.GenModelHelper;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.emf.mwe2.ecore.CvsIdFilteringGeneratorAdapterFactoryDescriptor;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.GenModelAccess;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.CharStreams;

/**
 * A {@link IGeneratorFragment} that saves the generated Ecore models and creates appropriate EMF generators. Then it
 * runs the EMF generator to create the EMF classes for the generated Ecore models.
 * 
 * @author Michael Clay
 * @author Sebastian Zarnekow - Write to model folder by default, update build.properties
 * @author Sven Efftinge
 * 
 * @since 2.4
 */
@Deprecated
public class EMFGeneratorFragment extends AbstractGeneratorFragment {

	private static final Logger log = Logger.getLogger(EMFGeneratorFragment.class);

	private static final String MODEL_PLUGIN_ID = "modelPluginID";

	private String basePackage = null;

	private String editDirectory = null;

	private String editorDirectory = null;

	private String editorPluginID = null;

	private String editPluginID = null;

	private boolean generateEdit = false;

	private boolean generateEditor = false;

	private String genModel = null;

	private String javaModelDirectory = null;

	private String modelPluginID = null;

	private boolean skipGenerate = false;

	private String xmiModelDirectory = "/generated";
	private boolean xmiModelDirectorySet = false;
	
	private boolean updateBuildProperties = true;

	private String fileExtensions = null;
	
	private boolean longFileNames = false;

	/* Default to 2.20 if available, otherwise #get will return null */
	private GenRuntimeVersion emfRuntimeVerison = GenRuntimeVersion.get(GenRuntimeVersion.EMF220_VALUE);
	
	private boolean suppressLoadInitialization = false;
	
	private GenJDKLevel jdkLevel = GenJDKLevel.JDK80_LITERAL;
	
	private boolean bindEPackageAndEFactory = false;
	
	private String rootExtendsClass = "org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container";
	
	private String getLineDelimiter() {
		return getNaming().getLineDelimiter();
	}
	
	{
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("genmodel"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel",
					new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		GenModelPackage.eINSTANCE.getGenAnnotation();
	}

	protected Resource createResourceForEPackages(Grammar grammar, XpandExecutionContext ctx, List<EPackage> packs,
			ResourceSet rs) {
		URI ecoreFileUri = getEcoreFileUri(grammar, ctx);
		ecoreFileUri = toPlatformResourceURI(ecoreFileUri);
		Resource existing = rs.getResource(ecoreFileUri, false);
		if (existing != null) {
			existing.unload();
			rs.getResources().remove(existing);
		}
		Resource ecoreFile = rs.createResource(ecoreFileUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		ecoreFile.getContents().addAll(packs);
		return ecoreFile;
	}

	protected void doGenerate(GenModel genModel) {
		Generator generator = new Generator() {
			@Override
			public JControlModel getJControlModel() {
				if (jControlModel == null) {
				      jControlModel = new JControlModel();
				      jControlModel.initialize(null, options.mergeRulesURI);
				}
				return jControlModel;
			}
		};
		generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
				new CvsIdFilteringGeneratorAdapterFactoryDescriptor(getLineDelimiter()));
		genModel.setCanGenerate(true);
		generator.setInput(genModel);
		Diagnostic diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor());

		if (diagnostic.getSeverity() != Diagnostic.OK)
			log.info(diagnostic);

		if (isGenerateEdit()) {
			Diagnostic editDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE,
					new BasicMonitor());
			if (editDiag.getSeverity() != Diagnostic.OK)
				log.info(editDiag);
		}

		if (isGenerateEditor()) {
			Diagnostic editorDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE,
					new BasicMonitor());
			if (editorDiag.getSeverity() != Diagnostic.OK)
				log.info(editorDiag);
		}
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		try {
			// early exit
			if (!hasGeneratedMetamodel(grammar))
				return;

			// Create a clone of the grammar that can be safely modified
			Grammar clonedGrammar = cloneGrammarIntoNewResourceSet(grammar);
			ResourceSet workingResourceSet = clonedGrammar.eResource().getResourceSet();
			
			// Let's collect all the copies of the generated EPackages of this grammar
			List<EPackage> generatedPackages = getGeneratedEPackages(clonedGrammar);

			// now we register the to-be-used genmodel
			// if it was explicitly set
			registerUsedGenModel(workingResourceSet.getURIConverter());
						
			// just to make sure that we really have a generated package and not only a 
			// meta model declaration
			if (!generatedPackages.isEmpty()) {
				// create an index for all EPackages that are used by the generated packages
				Map<String, EPackage> usedEPackages = findAllUsedEPackages(generatedPackages);
				
				// try to find the *.ecore files for the potentially installed packages 
				Map<String, EPackage> loadedEPackages = findEPackagesInGenPackages(usedEPackages.keySet(), workingResourceSet);
				
				// map the elements from the installed version to the file-version
				Map<EObject, EObject> eNamedElementMapping = createENamedElementMapping(usedEPackages, loadedEPackages);
				
				// and finally replace all the references to installed elements with their 
				// loaded equivalent
				replaceReferencesInGeneratedPackages(generatedPackages, eNamedElementMapping);
				
				// put all the generated packages into a single resource
				Resource ePackageResource = createResourceForEPackages(clonedGrammar, ctx, generatedPackages, workingResourceSet);
				if (!skipGenerate) {
					// obtain the genmodel - either load the given resource (this.genModel) or create a new one
					GenModel genModel = getSaveAndReconcileGenModel(workingResourceSet, clonedGrammar, ctx, generatedPackages);
					// make sure everything is set
					genModel.reconcile();
					// execute the emf generator
					doGenerate(genModel);
					if (basePackage == null)
						basePackage = genModel.getGenPackages().get(0).getBasePackage();
					super.generate(clonedGrammar, ctx);
				}
				// finally save the ecore packages to the file system
				saveResource(ePackageResource);
			}
			updateBuildProperties(ctx);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	void updateBuildProperties(XpandExecutionContext ctx) throws Exception {
		if (!updateBuildProperties || modelPluginID != null)
			return;
		Outlet rootOutlet = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.PLUGIN_RT);
		Outlet modelOutlet = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.MODEL);
		String buildPropertiesPath = rootOutlet.getPath() + "/build.properties";
		String modelPath = modelOutlet.getPath().substring(rootOutlet.getPath().length() + 1) + "/";
		Properties buildProperties = new Properties();
		Reader reader = new InputStreamReader(new FileInputStream(new File(buildPropertiesPath)), Charset.forName(rootOutlet.getFileEncoding()));
		try {
			String existingContent = CharStreams.toString(reader);
			// for encoding details, see Properties.load
			buildProperties.load(new StringInputStream(existingContent, "ISO-8859-1"));
			String binIncludes = buildProperties.getProperty("bin.includes");
			boolean changed = false;
			if (binIncludes == null) {
				existingContent += "bin.includes = " + modelPath + Strings.newLine()+ "               ";
				changed = true;
			} else if (!binIncludes.contains(modelPath)) {
				existingContent = existingContent.replace("bin.includes = ", "bin.includes = " + modelPath + ",\\" + Strings.newLine() +"               ");
				changed = true;
			}
			if (changed) {
				Writer writer = new OutputStreamWriter(new FileOutputStream(new File(buildPropertiesPath)), Charset.forName(rootOutlet.getFileEncoding()));
				writer.write(existingContent);
				writer.close();
			}
		} finally {
			reader.close();
		}
	}

	private void saveResource(Resource resource) throws IOException {
		Map<String, Object> saveOptions = Maps.newHashMap();
		saveOptions.put(XMLResource.OPTION_URI_HANDLER, new ToPlatformResourceDeresolvingURIHandler());
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, getLineDelimiter());
		resource.save(saveOptions);
	}
	
	private void registerUsedGenModel(URIConverter converter) {
		if (genModel == null)
			return;
		URI genModelUri = URI.createURI(genModel);
		genModelUri = toPlatformResourceURI(genModelUri);
		if (converter.exists(genModelUri, null)) {
			try {
				new GenModelHelper().registerGenModel(new XtextResourceSet(), genModelUri);
			} catch (ConfigurationException ce) {
				throw ce;
			} catch (Exception e) {
				log.error(e, e);
			}
		}
	}

	private void replaceReferencesInGeneratedPackages(
			List<EPackage> generatedPackages,
			Map<EObject, EObject> eNamedElementMapping) {
		TreeIterator<EObject> packageContentIterator = EcoreUtil.<EObject>getAllContents(generatedPackages);
		while(packageContentIterator.hasNext()) {
			EObject current = packageContentIterator.next();
			EStructuralFeature[] crossReferenceFeatures = 
					((EClassImpl.FeatureSubsetSupplier) current.eClass().getEAllStructuralFeatures()).crossReferences();
			if (crossReferenceFeatures != null) {
				for(EStructuralFeature crossReferenceFeature: crossReferenceFeatures) {
					if (crossReferenceFeature.isChangeable()) {
						EReference reference = (EReference) crossReferenceFeature;
						if (reference.isMany()) {
							@SuppressWarnings("unchecked")
							List<EObject> values = (List<EObject>) current.eGet(reference);
							for(int i = 0; i < values.size(); i++) {
								EObject value = values.get(i);
								if (eNamedElementMapping.containsKey(value)) {
									EcoreUtil.replace(current, reference, value, eNamedElementMapping.get(value));
								}
							}
						} else {
							EObject value = (EObject) current.eGet(reference);
							if (eNamedElementMapping.containsKey(value)) {
								EcoreUtil.replace(current, reference, value, eNamedElementMapping.get(value));
							}
						}
					}
				}
			}
		}
	}

	private Map<EObject, EObject> createENamedElementMapping(Map<String, EPackage> usedEPackages,
			Map<String, EPackage> loadedEPackages) {
		Map<EObject, EObject> result = Maps.newHashMap();
		for(String nsURI: usedEPackages.keySet()) {
			EPackage usedEPackage = usedEPackages.get(nsURI);
			EPackage loadedEPackage = loadedEPackages.get(nsURI);
			putMappingData(result, usedEPackage, loadedEPackage);
		}
		return result;
	}

	private void putMappingData(Map<EObject, EObject> result, EPackage usedEPackage, EPackage loadedEPackage) {
		if (loadedEPackage != null && usedEPackage != loadedEPackage) {
			result.put(usedEPackage, loadedEPackage);
			for(EClassifier usedClassifier: usedEPackage.getEClassifiers()) {
				EClassifier loadedClassifier = loadedEPackage.getEClassifier(usedClassifier.getName());
				if (loadedClassifier == null)
					throw new RuntimeException(
							"Cannot find classifier '" + usedClassifier.getName() + "' in loaded EPackage from " + loadedEPackage.eResource().getURI());
				result.put(usedClassifier, loadedClassifier);
			}
			for(EPackage usedNestedPackage: usedEPackage.getESubpackages()) {
				for(EPackage loadedNestedPackage: loadedEPackage.getESubpackages()) {
					if (usedNestedPackage.getName().equals(loadedNestedPackage.getName())) {
						putMappingData(result, usedNestedPackage, loadedNestedPackage);
						break;
					}
				}
			}
		}
	}

	private Map<String, EPackage> findAllUsedEPackages(List<EPackage> generatedPackages) {
		Map<String, EPackage> result = Maps.newHashMap();
		TreeIterator<EObject> packageContentIterator = EcoreUtil.<EObject>getAllContents(generatedPackages);
		while(packageContentIterator.hasNext()) {
			EObject current = packageContentIterator.next();
			for(EObject referenced: current.eCrossReferences()) {
				if (referenced.eIsProxy())
					throw new RuntimeException("Unresolved proxy: " + referenced + " in " + current);
				if (referenced instanceof EClassifier) {
					EPackage referencedPackage = ((EClassifier) referenced).getEPackage();
					if (!generatedPackages.contains(referencedPackage)) {
						result.put(referencedPackage.getNsURI(), referencedPackage);
					}
				}
			}
		}
		return result;
	}
	
	private Map<String, EPackage> findEPackagesInGenPackages(Set<String> packageNsURIs, ResourceSet resourceSet) {
		Map<String, EPackage> result = Maps.newHashMap();
		for(String nsURI: packageNsURIs) {
			Resource resource = GenModelAccess.getGenModelResource(null, nsURI, resourceSet);
			if (resource != null) {
				for(EObject content: resource.getContents()) {
					if (content instanceof GenModel) {
						GenModel loadedGenModel = (GenModel) content;
						GenPackage genPackage = findGenPackageByNsURI(loadedGenModel, nsURI);
						result.put(nsURI, genPackage.getEcorePackage());
						break;
					}
				}
			}
		}
		return result;
	}
	
	/*
	 * Adopted from GenModel#findGenPackageHelper
	 */
	private GenPackage findGenPackageByNsURI(GenModel genModel, String nsURI) {
		List<GenPackage> allGenPackages = genModel.getAllGenUsedAndStaticGenPackagesWithClassifiers();
		for(GenPackage genPackage: allGenPackages) {
			EPackage ecorePackage = genPackage.getEcorePackage();
			if (ecorePackage == null || ecorePackage.eIsProxy()) {
				throw new RuntimeException("Unresolved proxy: " + ecorePackage + " in " + genModel.eResource().getURI());
			}
			if (nsURI.equals(ecorePackage.getNsURI())) {
				return genPackage;
			}
		}
		throw new RuntimeException("No GenPackage for NsURI " + nsURI + " found in " + genModel.eResource().getURI());
	}
	
	private boolean hasGeneratedMetamodel(Grammar grammar) {
		Iterable<GeneratedMetamodel> generatedMetamodels = Iterables.filter(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
		if (!generatedMetamodels.iterator().hasNext())
			return false;
		return true;
	}
	
	/**
	 * Create a clone of the original grammar. The clone will not refer to a node model.
	 */
	private Grammar cloneGrammarIntoNewResourceSet(Grammar original) {
		Resource originalResource = original.eResource();
		ResourceSet clonedResourceSet = EcoreUtil2.clone(new XtextResourceSet(), originalResource.getResourceSet());
		Resource clonedResource = clonedResourceSet.getResource(originalResource.getURI(), false);
		Grammar clonedGrammar = (Grammar) clonedResource.getContents().get(0);
		return clonedGrammar;
	}

	public static class ToPlatformResourceDeresolvingURIHandler extends AbsoluteCrossBundleAware {
		@Override
		public URI deresolve(URI uri) {
			return super.deresolve(toPlatformResourceURI(uri));
		}
	}
	
	protected static URI toPlatformResourceURI(URI uri) {
		if (uri.isPlatform())
			return uri;
		Map<String, URI> map = EcorePlugin.getPlatformResourceMap();
		for (Entry<String, URI> entries : map.entrySet()) {
			final URI newPrefix = URI.createURI("platform:/resource/" + entries.getKey() + "/");
			URI uri2 = uri.replacePrefix(entries.getValue(), newPrefix);
			if (uri2 != null)
				return uri2;
		}
		return uri;
	}

	/**
	 * @since 2.0
	 */
	protected Set<EPackage> getReferencedEPackages(List<EPackage> packs) {
		Set<EPackage> result = Sets.newHashSet();
		for (EPackage pkg : packs) {
			TreeIterator<EObject> it = pkg.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				for (EObject crossRef : obj.eCrossReferences()) {
					if (crossRef.eIsProxy())
						log.error("Proxy '" + ((InternalEObject) crossRef).eProxyURI() + "' could not be resolved");
					else {
						EPackage p = EcoreUtil2.getContainerOfType(crossRef, EPackage.class);
						if (p != null)
							result.add(p);
					}
				}
			}
		}
		for (EPackage pkg : packs)
			result.remove(pkg);
		// the following GenModels are handled by the EMF's generator as implemented in:
		//org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl.findGenPackage(EPackage)
		result.remove(EcorePackage.eINSTANCE);
		result.remove(XMLTypePackage.eINSTANCE);
		result.remove(XMLNamespacePackage.eINSTANCE);
		return result;
	}

	/**
	 * @since 2.0
	 */
	protected List<GenPackage> getGenPackagesForPackages(GenModel existingGenModel, Collection<EPackage> packs) {
		List<GenPackage> result = Lists.newArrayList();
		for (EPackage pkg : packs) {
			boolean found = false;
			for (GenPackage gp : existingGenModel.getGenPackages())
				if (gp.getEcorePackage() != null && gp.getEcorePackage().getNsURI() != null
						&& gp.getEcorePackage().getNsURI().equals(pkg.getNsURI()))
					found = true;
			if (!found)
				result.add(GenModelAccess.getGenPackage(pkg, existingGenModel.eResource().getResourceSet()));
		}
		Collections.sort(result, new Comparator<GenPackage>() {
			@Override
			public int compare(GenPackage o1, GenPackage o2) {
				return EcoreUtil.getURI(o1).toString().compareTo(EcoreUtil.getURI(o2).toString());
			}
		});
		return result;
	}

	public String getBasePackage(Grammar g) {
		if (basePackage == null)
			return GrammarUtil.getNamespace(g);
		return basePackage;
	}

	protected URI getEcoreFileUri(Grammar grammar, XpandExecutionContext ctx) {
		String javaPath = getJavaModelDirectory(ctx);
		String xmiPath = getXmiModelDirectory(grammar, javaPath, ctx);
		try {
			String prefix = new File(xmiPath).getCanonicalPath() + File.separator + getModelName(grammar);
			URI ecoreFileUri = URI.createFileURI(prefix + ".ecore");
			return ecoreFileUri;
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't compute canonical path for "
					+ new File(xmiPath).getAbsolutePath());
		}
	}

	public String getEditDirectory(XpandExecutionContext ctx) {
		if (this.editDirectory == null || "".equals(this.editDirectory)) {
			return ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.PLUGIN_RT).getPath()
					+ ".edit/src";
		}
		return editDirectory;
	}

	public String getEditorDirectory(XpandExecutionContext ctx) {
		if (editorDirectory == null || "".equals(editorDirectory)) {
			return ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.PLUGIN_RT).getPath()
					+ ".editor/src";
		}
		return editorDirectory;
	}

	protected String getEditorPluginID(XpandExecutionContext ctx) {
		if ((editorPluginID == null || "".equals(editorPluginID)) && (getModelPluginID(ctx) != null)) {
			return getModelPluginID(ctx) + ".editor";
		}
		return editorPluginID;
	}

	public String getEditPluginID(XpandExecutionContext ctx) {
		if ((editPluginID == null || "".equals(editPluginID)) && (getModelPluginID(ctx) != null)) {
			return getModelPluginID(ctx) + ".edit";
		}
		return editPluginID;
	}

	/*
	 * TODO: Ask the genmodel instead
	 */
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		List<GeneratedMetamodel> typeSelect = org.eclipse.xtext.EcoreUtil2.typeSelect(
				grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
		Set<String> exportedPackages = new LinkedHashSet<String>();
		if (modelPluginID == null) {
			for (GeneratedMetamodel generatedMetamodel : typeSelect) {
				final String modelPackage = Strings.skipLastToken(
						getGeneratedEPackageName(grammar, generatedMetamodel.getEPackage()), ".");
				exportedPackages.add(modelPackage);
				exportedPackages.add(modelPackage + ".impl");
				exportedPackages.add(modelPackage + ".util");
			}
		}
		return exportedPackages.toArray(new String[exportedPackages.size()]);
	}

	public String getGeneratedEPackageName(Grammar g, EPackage pack) {
		return getBasePackage(g) + "." + pack.getName() + "." + Strings.toFirstUpper(pack.getName()) + "Package";
	}

	protected List<EPackage> getGeneratedEPackages(Grammar grammar) {
		List<GeneratedMetamodel> list = typeSelect(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
		List<EPackage> packs = collect(list, GENERATED_METAMODEL__EPACKAGE, EPackage.class);
		return packs;
	}

	protected GenModel getGenModel(ResourceSet rs, Grammar grammar, XpandExecutionContext ctx, List<EPackage> packs) {
		URI genModelUri = getGenModelUri(grammar, ctx);
		genModelUri = toPlatformResourceURI(genModelUri);
		Resource resource = rs.getResource(genModelUri, false);
		if (resource != null) {
			resource.unload();
			rs.getResources().remove(resource);
		}
		Resource genModelFile = rs.createResource(genModelUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		GenModel genModel;
		if (rs.getURIConverter().exists(genModelUri, null)) {
			try {
				genModelFile.load(null);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
			if (genModelUri.hasFragment()) {
				genModel = (GenModel) genModelFile.getEObject(genModelUri.fragment());
			} else {
				genModel = (GenModel) genModelFile.getContents().get(0);
			}
		} else {
			// The name of the additional ecore file used for load initialization is hard-coded in GenPackageImpl.
			// We want to override it to avoid validation of that file, which uses NS URIs for references.
			genModel = new GenModelImpl() {
				@Override
				public GenPackage createGenPackage() {
					return new GenPackageImpl() {
						@Override
						public String getSerializedPackageFilename() {
							return getName() + ".loadinitialization_ecore";
						}
					};
				}
			};
			genModel.setModelDirectory(toGenModelProjectPath(getJavaModelDirectory(ctx)));
			genModel.setModelName(getModelName(grammar));
			genModel.setModelPluginID(getModelPluginID(ctx));
			genModel.setEditDirectory(toGenModelProjectPath(getEditDirectory(ctx)));
			genModel.setEditorDirectory(toGenModelProjectPath(getEditorDirectory(ctx)));
			genModel.setEditPluginID(getEditPluginID(ctx));
			genModel.setEditorPluginID(getEditorPluginID(ctx));
			genModel.setValidateModel(false);
			genModel.setForceOverwrite(true);
			genModel.setCanGenerate(true);
			genModel.setFacadeHelperClass(null);
			genModel.setBundleManifest(true);
			genModel.setUpdateClasspath(false);
			genModel.setComplianceLevel(jdkLevel);
			genModel.setRuntimeVersion(emfRuntimeVerison);
			genModel.setRootExtendsClass(rootExtendsClass);
			genModel.setLineDelimiter(getLineDelimiter());
		}
		genModelFile.getContents().add(genModel);
		return genModel;
	}

	protected URI getGenModelUri(Grammar grammar, XpandExecutionContext ctx) {
		if (genModel != null) {
			return URI.createURI(genModel);
		} else {
			String prefix;
			try {
				prefix = new File(getXmiModelDirectory(grammar, getJavaModelDirectory(ctx), ctx)).getCanonicalPath()
						+ File.separator + getModelName(grammar);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
			URI genModelUri = URI.createFileURI(prefix + ".genmodel");
			return genModelUri;
		}
	}

	protected String getJavaModelDirectory(XpandExecutionContext ctx) {
		String javaPath;
		if (javaModelDirectory == null || "".equals(javaModelDirectory))
			javaPath = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.SRC_GEN).getPath();
		else
			javaPath = javaModelDirectory;
		return javaPath;
	}

	protected String getModelName(Grammar grammar) {
		String grammarName = grammar.getName();
		if (isLongFileNames()) {
			return grammarName.replace('.', '_');
		}
		return grammarName.substring(grammarName.lastIndexOf('.') + 1);
	}

	public String getModelPluginID(XpandExecutionContext ctx) {
		if ((this.modelPluginID == null || "".equals(this.modelPluginID)) && (ctx.getVariable(MODEL_PLUGIN_ID) != null)) {
			return (String) ctx.getVariable(MODEL_PLUGIN_ID).getValue();
		}
		return modelPluginID;
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object) getBasePackage(grammar));
	}
	
	private List<Object> getParameters(Grammar grammar, XpandExecutionContext ctx) {
		try {
			File projectRootFile = new File(ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.PLUGIN_RT).getPath());
			String projectRoot = projectRootFile.getCanonicalPath();
			URI genmodelURI = getGenModelUri(grammar, ctx);
			if (genmodelURI.toFileString().startsWith(projectRoot)) {
				URI relative = genmodelURI.deresolve(URI.createFileURI(projectRoot).appendSegment(""));
				String genModelPath = relative.toString();
				return Lists.<Object>newArrayList(getBasePackage(grammar), genModelPath);
			}
			throw new ConfigurationException("Invalid configuration of genmodel location: " + genmodelURI + "  and project root: " + projectRoot);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::addToPluginXmlRt", grammar, getParameters(grammar, ctx));
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] { "org.eclipse.emf.ecore", "org.eclipse.emf.common" };
	}

	/**
	 * @since 2.0
	 */
	protected GenModel getSaveAndReconcileGenModel(ResourceSet rs, Grammar grammar, XpandExecutionContext ctx,
			List<EPackage> packs) throws ConfigurationException {
		GenModel genModel = getGenModel(rs, grammar, ctx, packs);
		genModel.initialize(packs);
		for (GenPackage genPackage : genModel.getGenPackages()) {
			genPackage.setBasePackage(getBasePackage(grammar));
			if (isSuppressLoadInitialization()) {
				genPackage.setLoadInitialization(false);
			}
			if (getFileExtensions() != null && packs.contains(genPackage.getEcorePackage())) {
				genPackage.setFileExtensions(getFileExtensions());
			}
		}
		Set<EPackage> referencedEPackages = getReferencedEPackages(packs);
		List<GenPackage> usedGenPackages = getGenPackagesForPackages(genModel, referencedEPackages);
		reconcileMissingGenPackagesInUsedModels(usedGenPackages);
		genModel.getUsedGenPackages().addAll(usedGenPackages);
		try {
			saveResource(genModel.eResource());
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		new GenModelHelper().registerGenModel(genModel);
		return genModel;
	}

	private void reconcileMissingGenPackagesInUsedModels(List<GenPackage> usedGenPackages) {
		Set<GenModel> processedModels = Sets.newHashSet();
		for(GenPackage usedGenPackage: usedGenPackages) {
			GenModel genModel = usedGenPackage.getGenModel();
			if (processedModels.add(genModel)) {
				List<EPackage> missingPackages = genModel.getMissingPackages();
				List<GenPackage> missingGenPackages = getGenPackagesForPackages(genModel, missingPackages);
				genModel.getUsedGenPackages().addAll(missingGenPackages);
			}
		}
	}

	public String getXmiModelDirectory() {
		return xmiModelDirectory;
	}

	protected String getXmiModelDirectory(Grammar grammar, String javaPath, XpandExecutionContext ctx) {
		String xmiPath;
		if (getXmiModelDirectory() == null || "".equals(getXmiModelDirectory())) {
			xmiPath = javaPath + "/"
					+ grammar.getName().substring(0, grammar.getName().lastIndexOf('.')).replace('.', '/');
		} else {
			if (xmiModelDirectorySet)
				xmiPath = getXmiModelDirectory();
			else {
				xmiPath = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.MODEL).getPath() + getXmiModelDirectory();
			}
		}
		return xmiPath;
	}

	public boolean isGenerateEdit() {
		return generateEdit;
	}

	public boolean isGenerateEditor() {
		return generateEditor;
	}

	public boolean isSkipGenerate() {
		return skipGenerate;
	}

	/**
	 * the java package the generated java classes shall be placed in.
	 */
	public void setBasePackage(String basePackage) {
		if ("".equals(basePackage.trim()))
			return;
		this.basePackage = basePackage;
	}

	/**
	 * Sets the target EMF runtime version to generate for to the specified value.
	 * Default is 2.20
	 * 
	 * @param emfRuntimeVersion the EMF runtime version.
	 * @since 2.3
	 */
	public void setEmfRuntimeVersion(String emfRuntimeVersion) {
		this.emfRuntimeVerison = GenRuntimeVersion.get(emfRuntimeVersion);
		if(this.emfRuntimeVerison == null) {
			log.warn("Illegal EMF runtime verison " + emfRuntimeVersion + ". Using default version instead.");
		}
	}
	
	/**
	 * Sets the target directory for the generated EMF-edit code. Only needed if you want to generate an EMF edit
	 * plug-in.
	 * 
	 * @param editDirectory
	 */
	public void setEditDirectory(String editDirectory) {
		this.editDirectory = editDirectory;
	}

	/**
	 * Sets the target directory for the generated EMF-editor code. Only needed if you want to generate an EMF editor plug-in.
	 * 
	 * @param editorDirectory
	 */
	public void setEditorDirectory(String editorDirectory) {
		this.editorDirectory = editorDirectory;
	}

	/**
	 * Sets the plug-in ID of the generated EMF editor plug-in. Only needed if you want to generate an EMF editor plug-in.
	 * 
	 * @param editorPluginId
	 */
	public void setEditorPluginID(String editorPluginId) {
		editorPluginID = editorPluginId;
	}

	/**
	 * Sets the plug-in ID of the generated EMF edit plug-in. Only needed if you want to generate an EMF edit plug-in.
	 * 
	 * @param editPluginId
	 */
	public void setEditPluginID(String editPluginId) {
		editPluginID = editPluginId;
	}

	/**
	 * If true, the EMF-edit code will be generated as well.
	 * 
	 * @param gen
	 * @see #setEditDirectory(String)
	 * @see #setEditPluginID(String)
	 */
	public void setGenerateEdit(boolean gen) {
		this.generateEdit = gen;
	}

	/**
	 * If true, the EMF editor code will be generated as well.
	 * 
	 * @param gen
	 * @see #setEditorDirectory(String)
	 * @see #setEditorPluginID(String)
	 */
	public void setGenerateEditor(boolean gen) {
		this.generateEditor = gen;
	}

	public void setGenModel(String genModel) {
		if ("".equals(genModel))
			return;
		this.genModel = genModel;
	}

	/**
	 * Sets the target directory for the generated EMF-model code. Only needed if you want to generate the EMF code into
	 * a separate plug-in.
	 * 
	 * @param dir
	 */
	public void setJavaModelDirectory(String dir) {
		javaModelDirectory = dir;
	}

	/**
	 * Sets the ID of the generated EMF-model plug-in. Only needed if you want to generate the EMF code into a separate
	 * plug-in.
	 * 
	 * @param modelPluginId
	 */
	public void setModelPluginID(String modelPluginId) {
		modelPluginID = modelPluginId;
	}

	/**
	 * Whether the Java class generation should be skipped. If <code>true</code> only the ecore file is generated.
	 */
	public void setSkipGenerate(boolean skipGenerate) {
		this.skipGenerate = skipGenerate;
	}

	public void setXmiModelDirectory(String dir) {
		xmiModelDirectory = dir;
		xmiModelDirectorySet = true;
	}
	
	/**
	 * Whether to use a qualified name for the xmi files, e.g.
	 * <code>org_eclipse_xtext_Xtext.ecore</code> rather than <code>Xtext.ecore</code>.
	 */
	public void setLongFileNames(boolean longFileNames) {
		this.longFileNames = longFileNames;
	}
	
	public boolean isLongFileNames() {
		return longFileNames;
	}
	
	/**
	 * Whether the build.properties should be updated.
	 */
	public void setUpdateBuildProperties(boolean updateBuildProperties) {
		this.updateBuildProperties = updateBuildProperties;
	}
	
	public boolean isUpdateBuildProperties() {
		return updateBuildProperties;
	}

	/**
	 * required to match the path format as expected from {@link GenModelImpl#getProjectPath}
	 */
	protected String toGenModelProjectPath(String path) {
		return null == path || "".equals(path) || path.startsWith("/") || !path.contains("/") ? path : path.substring(path.indexOf("/"));
	}

	/**
	 * @deprecated Save mappings are no longer supported. The EcoreGeneratorFragment will use the 
	 * uri that is given in the referenced genmodel or create a platform resource uri for new files. 
	 */
	@Deprecated
	public void addSaveMapping(Mapping mapping) {
		log.warn("Save mappings are no longer supported. The EcoreGeneratorFragment will use the " +
				"uri that is given in the referenced genmodel or create a platform resource uri for new files.");
	}

	/**
	 * @param fileExtensions
	 *            a comma-separated list of fileExtensions for the generated packages.
	 */
	public void setFileExtensions(String fileExtensions) {
		this.fileExtensions = fileExtensions;
	}

	public String getFileExtensions() {
		return fileExtensions;
	}

	/**
	 * The generated package implementation uses 'load initialization' if it becomes very large, which means
	 * that an additional ecore file is generated and the package content is loaded at runtime from that file.
	 * This is to prevent the compiled class file from becoming too large. Set this property to true in order
	 * to suppress this behavior.
	 * 
	 * @since 2.8
	 */
	public void setSuppressLoadInitialization(boolean suppressLoadInitialization) {
		this.suppressLoadInitialization = suppressLoadInitialization;
	}

	/**
	 * @since 2.8
	 */
	public boolean isSuppressLoadInitialization() {
		return suppressLoadInitialization;
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
	 * The default level is "JDK80".
	 * 
	 * @since 2.8
	 */
	public void setJdkLevel(String jdkLevel) {
		GenJDKLevel l = GenJDKLevel.getByName(jdkLevel);
		Assert.isNotNull(l, "Invalid JDK level");
		this.jdkLevel = l;
	}

	/**
	 * @since 2.8
	 */
	public String getJdkLevel() {
		return jdkLevel.getName();
	}

	/**
	 * If set generated {@link EPackage} and {@link EFactory} interfaces are bound to their <code>eINSTANCE</code> instance.
	 * @since 2.11
	 */
	public void setBindEPackageAndEFactory(boolean bindEPackageAndEFactory) {
		this.bindEPackageAndEFactory = bindEPackageAndEFactory;
	}

	/**
	 * @since 2.11
	 */
	public boolean isBindEPackageAndEFactory() {
		return bindEPackageAndEFactory;
	}

	/**
	 * Sets the BaseClass for the EClasses in the inferred GenModel.
	 * Default value is {@link org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container}.
	 * 
	 * @since 2.16
	 */
	public void setRootExtendsClass(final String rootExtendsClass) {
		this.rootExtendsClass = rootExtendsClass;
	}

	/**
	 * @since 2.11
	 */
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (isBindEPackageAndEFactory()) {
			BindFactory bindFactory = new BindFactory();
			// Register generated EPackage and EFactory instances in the runtime module
			for (EPackage pkg: getGeneratedEPackages(grammar)) {
				GenPackage genPkg = GenModelUtil2.getGenPackage(pkg, grammar.eResource().getResourceSet());
				bindFactory
					.addTypeToInstance(genPkg.getQualifiedPackageInterfaceName(), genPkg.getQualifiedPackageInterfaceName()+".eINSTANCE")
					.addTypeToInstance(genPkg.getQualifiedFactoryInterfaceName(), genPkg.getQualifiedFactoryInterfaceName()+".eINSTANCE");
			}
			return bindFactory.getBindings();
		} else {
			return Collections.emptySet();
		}
	}	
	
	
}
