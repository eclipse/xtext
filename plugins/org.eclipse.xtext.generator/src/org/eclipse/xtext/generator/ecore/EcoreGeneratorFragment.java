/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import static org.eclipse.xtext.EcoreUtil2.*;
import static org.eclipse.xtext.XtextPackage.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * A {@link IGeneratorFragment} that saves the generated Ecore models and creates appropriate EMF generators. Then it
 * runs the EMF generator to create the EMF classes for the generated Ecore models.
 * 
 * @author Michael Clay
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 */
public class EcoreGeneratorFragment extends AbstractGeneratorFragment {

	private static final Logger log = Logger.getLogger(EcoreGeneratorFragment.class);

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

	private String referencedGenModels;

	private boolean skipGenerate = false;

	private String xmiModelDirectory = null;

	{
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("genmodel"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel",
					new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		GenModelPackage.eINSTANCE.getGenAnnotation();
	}

	protected Resource createResourceForEPackages(Grammar grammar, XpandExecutionContext ctx, List<EPackage> packs,
			ResourceSet rs) {
		URI ecoreFileUri = getEcoreFileUri(grammar, ctx);
		Resource ecoreFile = rs.createResource(ecoreFileUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		ecoreFile.getContents().addAll(packs);
		return ecoreFile;
	}

	protected void doGenerate(GenModel genModel) {
		Generator generator = new Generator();
		generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
				new CvsIdFilteringGeneratorAdapterFactoryDescriptor());
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
			// create a defensive clone
			ResourceSet rs = EcoreUtil2.clone(new XtextResourceSet(), grammar.eResource().getResourceSet());
			grammar = (Grammar) rs.getResource(grammar.eResource().getURI(), true).getContents().get(0);

			List<EPackage> packs = getGeneratedEPackages(grammar);
			if (!packs.isEmpty()) {
				removeFromResource(packs);
				proxifyExternalReferences(packs);
				XtextResourceSet resourceSet = getNsUriMappingResourceSet();

				Resource ePackages = createResourceForEPackages(grammar, ctx, packs, resourceSet);
				List<GenPackage> genPackages = loadReferencedGenModels(resourceSet);
				if (!skipGenerate) {
					GenModel genModel = getSaveAndReconcileGenModel(resourceSet, grammar, ctx, packs, genPackages);
					genModel.reconcile();
					doGenerate(genModel);
					if (basePackage == null)
						basePackage = genModel.getGenPackages().get(0).getBasePackage();
					super.generate(grammar, ctx);
				}
				resolveAll(resourceSet);
				ePackages.save(null);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected List<GenPackage> loadReferencedGenModels(ResourceSet rs) {
		List<GenPackage> result = Lists.newArrayList();
		if (getReferencedGenModels() != null) {
			for (String uri : getReferencedGenModels().split(",")) {
				try {
					Resource resource = rs.getResource(URI.createURI(uri.trim()), true);
					GenModel genmodel = (GenModel) resource.getContents().get(0);
					EList<GenPackage> genPackages = genmodel.getGenPackages();
					for (GenPackage genPackage : genPackages) {
						genPackage.getEcorePackage().getEClassifiers();
						result.add(genPackage);
					}
				} catch (Exception e) {
					log.error("Couldn't find genmodel for uri '" + uri + "'");
					throw new RuntimeException(e);
				}
			}
		}
		return result;
	}

	protected void proxifyExternalReferences(List<EPackage> packs) {
		// has to be done in two phases. Causes endless recursion otherwise.
		Map<EObject, URI> object2Uri = Maps.newHashMap();
		Map<EObject, Collection<Setting>> map = EcoreUtil.CrossReferencer.find(packs);
		for (Entry<EObject, Collection<Setting>> entry : map.entrySet()) {
			EObject key = entry.getKey();
			if (key.eResource() != null) {
				object2Uri.put(key, EcoreUtil.getURI(key));
			}
		}
		// proxify found elements
		for (Entry<EObject, URI> entry : object2Uri.entrySet()) {
			InternalEObject key = (InternalEObject) entry.getKey();
			if (shouldBeProxified(key, packs)) {
				checkGenModelExists(key);
				key.eSetProxyURI(entry.getValue());
			}
		}
	}

	protected void checkGenModelExists(InternalEObject key) {
		if (getReferencedGenModels() == null && this.genModel == null)
			throw new WorkflowInterruptedException(
					"The generated EPackage references an external EPackage, but 'referencedGenModels' hasn't been registered.");
	}

	private boolean shouldBeProxified(InternalEObject key, List<EPackage> packs) {
		if (EcorePackage.eINSTANCE.eResource() == key.eResource())
			return false;
		TreeIterator<Object> iterator = EcoreUtil.getAllContents(packs);
		while (iterator.hasNext()) {
			if (key == iterator.next())
				return false;
		}
		return true;
	}

	protected void removeFromResource(List<EPackage> packs) {
		for (EPackage ePackage : packs) {
			ePackage.eResource().getContents().remove(ePackage);
		}
	}

	protected void resolveAll(ResourceSet resourceSet) {
		for (Resource res : resourceSet.getResources()) {
			URI uri = res.getURI();
			if (uri.isPlatformResource()) {
				URI path = EcorePlugin.resolvePlatformResourcePath(uri.toPlatformString(true));
				res.setURI(path);
			}
		}
		EcoreUtil.resolveAll(resourceSet);
	}

	public String getBasePackage(Grammar g) {
		if (basePackage == null)
			return GrammarUtil.getNamespace(g);
		return basePackage;
	}

	protected URI getEcoreFileUri(Grammar grammar, XpandExecutionContext ctx) {
		String javaPath = getJavaModelDirectory(ctx);
		String xmiPath = getXmiModelDirectory(grammar, javaPath);
		try {
			String prefix = new File(xmiPath).getCanonicalPath() + "/" + getModelName(grammar);
			URI ecoreFileUri = URI.createFileURI(prefix + ".ecore");
			return ecoreFileUri;
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't compute canonical path for "
					+ new File(xmiPath).getAbsolutePath());
		}
	}

	public String getEditDirectory(XpandExecutionContext ctx) {
		if (this.editDirectory == null || "".equals(this.editDirectory)) {
			this.editDirectory = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.PLUGIN_RT).getPath()
					+ ".edit/src";
		}
		return editDirectory;
	}

	public String getEditorDirectory(XpandExecutionContext ctx) {
		if (editorDirectory == null || "".equals(editorDirectory)) {
			editorDirectory = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.PLUGIN_RT).getPath()
					+ ".editor/src";
		}
		return editorDirectory;
	}

	protected String getEditorPluginID(XpandExecutionContext ctx) {
		if ((editorPluginID == null || "".equals(editorPluginID)) && (getModelPluginID(ctx) != null)) {
			editorPluginID = getModelPluginID(ctx) + ".editor";
		}
		return editorPluginID;
	}

	public String getEditPluginID(XpandExecutionContext ctx) {
		if ((editPluginID == null || "".equals(editPluginID)) && (getModelPluginID(ctx) != null)) {
			editPluginID = getModelPluginID(ctx) + ".edit";
		}
		return editPluginID;
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		List<GeneratedMetamodel> typeSelect = org.eclipse.xtext.EcoreUtil2.typeSelect(grammar
				.getMetamodelDeclarations(), GeneratedMetamodel.class);
		Set<String> exportedPackages = new LinkedHashSet<String>();
		for (GeneratedMetamodel generatedMetamodel : typeSelect) {
			final String modelPackage = Strings.skipLastToken(getGeneratedEPackageName(grammar, generatedMetamodel
					.getEPackage()), ".");
			exportedPackages.add(modelPackage);
			exportedPackages.add(modelPackage + ".impl");
			exportedPackages.add(modelPackage + ".util");
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
			genModel = GenModelPackage.eINSTANCE.getGenModelFactory().createGenModel();
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
			genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);
			genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
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
				prefix = new File(getXmiModelDirectory(grammar, getJavaModelDirectory(ctx))).getCanonicalPath() + "/"
						+ getModelName(grammar);
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
		return grammar.getName().substring(grammar.getName().lastIndexOf('.') + 1);
	}

	public String getModelPluginID(XpandExecutionContext ctx) {
		if ((this.modelPluginID == null || "".equals(this.modelPluginID)) && (ctx.getVariable(MODEL_PLUGIN_ID) != null)) {
			this.modelPluginID = (String) ctx.getVariable(MODEL_PLUGIN_ID).getValue();
		}
		return modelPluginID;
	}

	protected XtextResourceSet getNsUriMappingResourceSet() {
		return new XtextResourceSet() {
			final Map<URI, URI> uriMapping = Maps.newHashMap();

			@Override
			public EObject getEObject(URI uri, boolean loadOnDemand) {
				EObject eObject = super.getEObject(uri, loadOnDemand);
				if (eObject instanceof EPackage) {
					EPackage pack = (EPackage) eObject;
					uriMapping.put(URI.createURI(pack.getNsURI()), pack.eResource().getURI());
				}
				return eObject;
			}

			@Override
			public Resource getResource(URI uri, boolean loadOnDemand) {
				if (uriMapping.containsKey(uri))
					uri = uriMapping.get(uri);
				return super.getResource(uri, loadOnDemand);
			}
		};
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object) getBasePackage(grammar));
	}

	public String getReferencedGenModels() {
		return referencedGenModels;
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] { "org.eclipse.emf.ecore", "org.eclipse.emf.common" };
	}

	protected GenModel getSaveAndReconcileGenModel(ResourceSet rs, Grammar grammar, XpandExecutionContext ctx,
			List<EPackage> packs, List<GenPackage> usedGenPackages) throws ConfigurationException {
		GenModel genModel = null;

		genModel = getGenModel(rs, grammar, ctx, packs);
		genModel.initialize(packs);
		for (GenPackage genPackage : genModel.getGenPackages()) {
			genPackage.setBasePackage(getBasePackage(grammar));
		}
		genModel.getUsedGenPackages().addAll(usedGenPackages);
		resolveAll(rs);
		try {
			genModel.eResource().save(null);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		return genModel;
	}

	public String getXmiModelDirectory() {
		return xmiModelDirectory;
	}

	protected String getXmiModelDirectory(Grammar grammar, String javaPath) {
		String xmiPath;
		if (getXmiModelDirectory() == null || "".equals(getXmiModelDirectory()))
			xmiPath = javaPath + "/"
					+ grammar.getName().substring(0, grammar.getName().lastIndexOf('.')).replace('.', '/');
		else
			xmiPath = getXmiModelDirectory();
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
	 * Sets the URIs for the generated EMF generator models (aka genmodels).
	 * 
	 * @param uris
	 */
	public void setGenModels(String uris) {
		log.warn("The property 'genModels' is deprecated. Please use 'referencedGenModels' instead.");
		setReferencedGenModels(uris);
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
	 * Sets the target directory for the generated EMF-edit code. Only needed if you want to generate an EMF edit
	 * plug-in.
	 * 
	 * @param editDirectory
	 */
	public void setEditDirectory(String editDirectory) {
		this.editDirectory = editDirectory;
	}

	/**
	 * Sets the target directory for the generated EMF-editor code. Only needed if you want to generate an EMF editor
	 * plug_in.
	 * 
	 * @param editDirectory
	 */
	public void setEditorDirectory(String editorDirectory) {
		this.editorDirectory = editorDirectory;
	}

	/**
	 * Sets the plug-in ID of the generated EMF editor plug-in. Only needed if you want to generate an EMF editor
	 * plug_in.
	 * 
	 * @param editPluginId
	 */
	public void setEditorPluginID(String editorPluginId) {
		editorPluginID = editorPluginId;
	}

	/**
	 * Sets the plug-in ID of the generated EMF edit plug-in. Only needed if you want to generate an EMF editor plug_in.
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

	public void setReferencedGenModels(String referencedGenModel) {
		if ("".equals(referencedGenModel))
			return;
		this.referencedGenModels = referencedGenModel;
	}

	/**
	 * Whether the Java class generation should be skipped. If <code>true</code> only the ecore file is generated.
	 * 
	 */
	public void setSkipGenerate(boolean skipGenerate) {
		this.skipGenerate = skipGenerate;
	}

	public void setXmiModelDirectory(String dir) {
		xmiModelDirectory = dir;
	}

	/**
	 * required to match the path format as expected from {@link GenModelImpl#getProjectPath}
	 */
	protected String toGenModelProjectPath(String path) {
		return null == path || "".equals(path) || path.startsWith("/") ? path : path.substring(path.indexOf("/"));
	}

}
