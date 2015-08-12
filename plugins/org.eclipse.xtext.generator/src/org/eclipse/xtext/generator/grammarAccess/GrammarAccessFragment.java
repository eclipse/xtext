/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import static org.eclipse.xtext.util.Strings.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;

import com.google.common.collect.Maps;

/**
 * A grammar access fragment that handles subpackages of EPackages gracefully. In general, we recommend to avoid
 * nested EPackages if possible.
 *
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarAccessFragment extends AbstractGeneratorFragment {

	private static final Logger log = Logger.getLogger(GrammarAccessFragment.class);

	private String xmlVersion = null;

	@Override
	protected String getTemplate() {
		return GrammarAccessFragment.class.getName().replaceAll("\\.", "::");
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.<Object>singletonList(getNaming().getLineDelimiter());
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		BindFactory bindFactory = new BindFactory();
		// generating this binding for terminals will break existing languages
		if(!equal("org.eclipse.xtext.common.Terminals", grammar.getName())) {
			bindFactory
				.addTypeToInstance(ClassLoader.class.getName(), "getClass().getClassLoader()");
		}
		bindFactory.addTypeToType(IGrammarAccess.class.getName(), GrammarAccessUtil.getGrammarAccessFQName(grammar, getNaming()));
		return bindFactory.getBindings();
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[] { GrammarUtil.getNamespace(grammar), GrammarUtil.getNamespace(grammar) + ".services" };
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		RuleNames.ensureAdapterInstalled(grammar);
		super.generate(grammar, ctx);

		final ResourceSaveIndicator isSaving = new ResourceSaveIndicator();
		// create a defensive clone
		Grammar copy = deepCopy(grammar, isSaving);
		ResourceSet set = copy.eResource().getResourceSet();

		// save grammar model
		String path;
		if (xmlVersion == null) {
			path = GrammarUtil.getClasspathRelativePathToBinGrammar(copy);
		} else {
			log.warn("'xmlVersion' has been specified for this "
					+ GrammarAccessFragment.class.getSimpleName()
					+ ". Therefore, the grammar is persisted as XMI and not as binary. This can be a performance drawback.");
			path = GrammarUtil.getClasspathRelativePathToXmi(copy);
		}
		URI uri = URI.createURI(ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath() + "/" + path);
		Resource resource = set.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		addAllGrammarsToResource(resource, copy, new HashSet<Grammar>());
		isSaving.set(Boolean.TRUE);
		Map<String, Object> saveOptions = Maps.newHashMap();
		if (resource instanceof XMLResource) {
			((XMLResource) resource).setXMLVersion(getXmlVersion());
		} else if (resource instanceof BinaryResourceImpl){
			saveOptions.put(BinaryResourceImpl.OPTION_VERSION, BinaryResourceImpl.BinaryIO.Version.VERSION_1_1);
			saveOptions.put(BinaryResourceImpl.OPTION_STYLE_DATA_CONVERTER, Boolean.TRUE);
		}
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			isSaving.set(Boolean.FALSE);
		}
	}
	
	public Grammar deepCopy(Grammar grammar, ResourceSaveIndicator isSaving) {
		ResourceSet cloneInto = new ResourceSetImpl();
		// substitute the resource factory for ecore-files
		cloneInto
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(FragmentFakingEcoreResourceFactoryImpl.ECORE_SUFFIX,
						new FragmentFakingEcoreResourceFactoryImpl(isSaving));
		// clone it
		ResourceSet set = EcoreUtil2.clone(cloneInto, grammar.eResource().getResourceSet());
		// get the copy of the grammar and use this one
		Grammar copy = (Grammar) set.getResource(grammar.eResource().getURI(), true).getContents().get(0);
		return copy;
	}

	public void addAllGrammarsToResource(Resource resource, Grammar grammar, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return;
		resource.getContents().add(grammar);
		replaceResourceURIsWithNsURIs(grammar, resource.getResourceSet());
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			addAllGrammarsToResource(resource, usedGrammar, visitedGrammars);
		}
	}

	public void replaceResourceURIsWithNsURIs(Grammar grammar, ResourceSet set) {
		for (AbstractMetamodelDeclaration metamodelDecl : grammar.getMetamodelDeclarations()) {
			EPackage pack = metamodelDecl.getEPackage();
			Resource packResource = pack.eResource();
			if (!packResource.getURI().toString().equals(pack.getNsURI())) {
				ResourceSet packResourceSet = packResource.getResourceSet();
				if (packResourceSet != null) {
					EPackage topMost = pack;
					// we need to be aware of empty subpackages
					while (topMost.getESuperPackage() != null
							&& topMost.getESuperPackage().eResource() == topMost.eResource())
						topMost = topMost.getESuperPackage();
					if (packResource.getContents().contains(topMost) && packResource.getContents().size() == 1) {
						if (!topMost.getEClassifiers().isEmpty())
							packResource.setURI(URI.createURI(topMost.getNsURI()));
						else
							moveSubpackagesToNewResource(topMost, set);
					}
					if (!topMost.eResource().getURI().toString().equals(topMost.getNsURI())) 
						movePackageToNewResource(topMost, set);
				}
			}
		}
	}

	public void moveSubpackagesToNewResource(EPackage pack, ResourceSet set) {
		for (int i = pack.getESubpackages().size() - 1; i >= 0; i--) {
			EPackage sub = pack.getESubpackages().get(i);
			if (sub.eResource() == pack.eResource()) {
				if (sub.getEClassifiers().isEmpty()) {
					moveSubpackagesToNewResource(sub, set);
				} else {
					movePackageToNewResource(sub, set);
					pack.getESubpackages().remove(i);
				}
			}
		}
	}

	/**
	 * @since 2.4
	 */
	protected void movePackageToNewResource(EPackage pack, ResourceSet set) {
		Resource resource = set.createResource(
				URI.createURI("___temp___." + FragmentFakingEcoreResourceFactoryImpl.ECORE_SUFFIX),
				ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		resource.setURI(URI.createURI(pack.getNsURI()));
		resource.getContents().add(pack);
	}

	public void setXmlVersion(String xmlVersion) {
		this.xmlVersion = xmlVersion;
	}

	public String getXmlVersion() {
		return xmlVersion == null ? "1.0" : xmlVersion;
	}
}
