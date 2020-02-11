/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.utils.GenModelHelper;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.GenModelAccess;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Lists;

/**
 * A {@link IGeneratorFragment} that saves the generated Ecore models and creates appropriate EMF generators. Then it
 * runs the EMF generator to create the EMF classes for the generated Ecore models.
 * 
 * @author Michael Clay
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @deprecated Use the {@link EMFGeneratorFragment} instead. It writes the EPackage to the model folder.
 */
@Deprecated
public class EcoreGeneratorFragment extends EMFGeneratorFragment {

	private static final Logger log = Logger.getLogger(EcoreGeneratorFragment.class);
	
	@Deprecated
	private String referencedGenModels;
	
	public static class ToPlatformResourceDeresolvingURIHandler extends EMFGeneratorFragment.ToPlatformResourceDeresolvingURIHandler {
		@Override
		public URI deresolve(URI uri) {
			return super.deresolve(toPlatformResourceURI(uri));
		}
	}
	
	public EcoreGeneratorFragment() {
		setXmiModelDirectory(null);
	}
	
	@Override
	void updateBuildProperties(XpandExecutionContext ctx) {
		// nothing to do
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::addToPluginXmlRt", grammar, getParameters(grammar));
	}
	
	@Deprecated
	public String getReferencedGenModels() {
		return referencedGenModels;
	}
	
	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		// register all explicitly referenced genmodels
		// since this may cause side effects on global singeltons, we don't guard it
		registerReferencedGenModels();
		super.generate(grammar, ctx);
	}

	/**
	 * Use {@link GenModelAccess#getGenPackage(EPackage, ResourceSet)}
	 */
	@Deprecated
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
					throw new WrappedException(e);
				}
			}
		}
		return result;
	}
	
	/**
	 * use {@link StandaloneSetup#addRegisterGenModelFile(String)}
	 */
	@Deprecated
	public void setReferencedGenModels(String referencedGenModel) {
		if ("".equals(referencedGenModel))
			return;
		this.referencedGenModels = referencedGenModel;
		log.warn("The property 'referencedGenModels' is deprecated. Please use 'StandaloneSetup.registerGenModelFile' instead.");
	}
	

	/**
	 * @since 2.0
	 */
	@Deprecated
	protected void registerReferencedGenModels() {
		try {
			if (getReferencedGenModels() != null && getReferencedGenModels().length() > 0) {
				ResourceSet rs = new XtextResourceSet();
				GenModelHelper gmh = new GenModelHelper();
				for (String uriStr : getReferencedGenModels().split(",")) {
					URI uri = URI.createURI(uriStr.trim());
					gmh.registerGenModel(rs, uri);
				}
			}
		} catch (ConfigurationException ce) {
			throw ce;
		} catch (Exception e) {
			log.error(e, e);
		}
	}
	
	/**
	 * Sets the URIs for the generated EMF generator models (aka genmodels).
	 * 
	 * use {@link StandaloneSetup#addRegisterGenModelFile(String)}
	 * 
	 * @param uris
	 * @deprecated
	 */
	@Deprecated
	public void setGenModels(String uris) {
		log.warn("The property 'genModels' is deprecated. Please use 'referencedGenModels' instead.");
		setReferencedGenModels(uris);
	}
}
