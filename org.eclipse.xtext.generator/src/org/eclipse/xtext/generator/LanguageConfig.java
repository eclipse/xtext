/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.ui.generator.ImplicitUiFragment;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @deprecated Use {@link org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage} instead.
 */
@Deprecated
public class LanguageConfig extends CompositeGeneratorFragment {

	private final class ToStringFunction implements Function<IGeneratorFragment, String> {
		private String delim;

		/**
		 * @param string
		 */
		public ToStringFunction(String string) {
			this.delim = string;
		}

		@Override
		public String apply(IGeneratorFragment from) {
			if (from instanceof CompositeGeneratorFragment) {
				return Strings.toString(((CompositeGeneratorFragment) from).fragments, this, delim);
			}
			return from.getClass().getSimpleName();
		}
	}

	private final static Logger LOG = Logger.getLogger(LanguageConfig.class);
	private Grammar grammar;

	private List<String> fileExtensions = new ArrayList<String>();
	
	private List<String> loadedResources = new ArrayList<String>();
	
	private ResourceSet forcedResourceSet = null;
	
	private String encoding;
	
	/**
	 * @since 2.1
	 */
	public void setForcedResourceSet(ResourceSet forcedResourceSet) {
		this.forcedResourceSet = forcedResourceSet;
	}
	
	/**
	 * @since 2.1
	 */
	public ResourceSet getForcedResourceSet() {
		return forcedResourceSet;
	}
	
	/**
	 * @since 2.1
	 */
	public void addLoadedResource(String uri) {
		loadedResources.add(uri);
	}

	/**
	 * @since 2.1
	 */
	public List<String> getLoadedResources() {
		return loadedResources;
	}
	
	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (LOG.isInfoEnabled()) {
			LOG.info("generating infrastructure for " + grammar.getName() + " with fragments : "
					+ Strings.toString(this.fragments, new ToStringFunction(", "), ", "));
		}
		super.generate(grammar, ctx);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (isCheckFileExtension()) {
			for (String extension : fileExtensions) {
				char[] charArray = extension.toCharArray();
				if (!Character.isJavaIdentifierPart(charArray[0])) {
					issues.addError("file extension '"+extension+"' starts with a non identifier letter : '"+charArray[0]+"'", this);
				}
				for (int i = 1; i < charArray.length; i++) {
					char c = charArray[i];
					if (!Character.isJavaIdentifierPart(c)) {
						issues.addError("file extension '"+extension+"' contains non identifier letter : '"+c+"'", this);
					}
				}
			}
		}
		if (getGrammar() == null) {
			issues.addError("property 'uri' is mandatory for element 'language'.", this);
		}
	}
	
	private boolean shouldCheckFileExtension = true;

	protected boolean isCheckFileExtension() {
		return this.shouldCheckFileExtension;
	}
	
	/**
	 * @since 2.4
	 */
	public void setCheckFileExtension(boolean shouldCheckFileExtension) {
		this.shouldCheckFileExtension = shouldCheckFileExtension;
	}

	public void setFileExtensions(String fileExtensions) {
		if ("".equals(fileExtensions.trim()))
			return;
		String[] split = fileExtensions.split("\\s*,\\s*");
		for (String string : split) {
			this.fileExtensions.add(string);
		}
	}

	public List<String> getFileExtensions(Grammar g) {
		if (fileExtensions.isEmpty()) {
			String lowerCase = GrammarUtil.getSimpleName(g).toLowerCase();
			if (LOG.isInfoEnabled())
				LOG.info("No explicit fileExtensions configured. Using '*." + lowerCase + "'.");
			return fileExtensions = Collections.singletonList(lowerCase);
		}
		return fileExtensions;
	}

	public void initialize(boolean isUi) {
		if (isUi)
			this.fragments.add(0, new ImplicitUiFragment(getFileExtensions(getGrammar())));
		this.fragments.add(0, new ImplicitRuntimeFragment());
	}
	
	public void setUri(String uri) {
		ResourceSet rs = forcedResourceSet != null ? forcedResourceSet : new XtextResourceSet();
		for (String loadedResource : loadedResources) {
			URI loadedResourceUri = URI.createURI(loadedResource);
			if(equal(loadedResourceUri.fileExtension(), "genmodel")) {
				IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri);
				if(resourceServiceProvider == null) {
					try {
						Class<?> genModelSupport = Class.forName("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport");
						Object instance = genModelSupport.newInstance();
						genModelSupport.getDeclaredMethod("createInjectorAndDoEMFRegistration").invoke(instance);
					} catch (ClassNotFoundException e) {
						LOG.error("Couldn't initialize GenModel support. Is it on the classpath?");
						LOG.debug(e.getMessage(), e);
					} catch (Exception e) {
						LOG.error("Couldn't initialize GenModel support.", e);
					}
				}
			} else if(equal(loadedResourceUri.fileExtension(), "ecore")) {
				IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri);
				if(resourceServiceProvider == null) {
					EcoreSupportStandaloneSetup.setup();
				}
			} else if (equal(loadedResourceUri.fileExtension(), "xcore")) {
				IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri);
				if(resourceServiceProvider == null) {
					try {
						Class<?> xcore = Class.forName("org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup");
						xcore.getDeclaredMethod("doSetup", new Class[0]).invoke(null);
					} catch (ClassNotFoundException e) {
						LOG.error("Couldn't initialize Xcore support. Is it on the classpath?");
						LOG.debug(e.getMessage(), e);
					} catch (Exception e) {
						LOG.error("Couldn't initialize Xcore support.", e);
					}
				}
				URI xcoreLangURI = URI.createPlatformResourceURI("/org.eclipse.emf.ecore.xcore.lib/model/XcoreLang.xcore", true);
				try {
					rs.getResource(xcoreLangURI, true);
				} catch(WrappedException e) {
					LOG.error("Could not load XcoreLang.xcore.", e);
					Resource brokenResource = rs.getResource(xcoreLangURI, false);
					rs.getResources().remove(brokenResource);
				}
			}
			rs.getResource(loadedResourceUri, true);
		}
		if (!rs.getResources().isEmpty()) {
			installIndex(rs);
			for(int i = 0, size = rs.getResources().size(); i<size; i++) {
				Resource res = rs.getResources().get(i);
				if (res.getContents().isEmpty())
					LOG.error("Error loading '" + res.getURI() + "'");
				else if (!res.getErrors().isEmpty())
					LOG.error("Error loading '" + res.getURI() + "':\n" + Joiner.on('\n').join(res.getErrors()));	
			}
			EcoreUtil.resolveAll(rs);
		}
		if (encoding != null) {
			rs.getLoadOptions().put(XtextResource.OPTION_ENCODING, encoding);
		}
		XtextResource resource = (XtextResource) rs.getResource(URI.createURI(uri), true);
		if (resource.getContents().isEmpty()) {
			throw new IllegalArgumentException("Couldn't load grammar for '" + uri + "'.");
		}
		if (!resource.getErrors().isEmpty()) {
			LOG.error(resource.getErrors());
			throw new IllegalStateException("Problem parsing '" + uri + "':\n" + Joiner.on('\n').join(resource.getErrors()));
		}

		final Grammar grammar = (Grammar) resource.getContents().get(0);
		validateGrammar(grammar);
		this.grammar = grammar;
	}
	
	private void installIndex(ResourceSet resourceSet) {
		if (ResourceDescriptionsData.ResourceSetAdapter.findResourceDescriptionsData(resourceSet) == null) {
			// Fill index
			ResourceDescriptionsData index = new ResourceDescriptionsData(Collections.<IResourceDescription>emptyList());
			List<Resource> resources = Lists.newArrayList(resourceSet.getResources());
			for (Resource resource : resources) {
				index(resource, resource.getURI(), index);
			}
			ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index);
		}
	}

	private void index(Resource resource, URI uri, ResourceDescriptionsData index) {
		IResourceServiceProvider serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
		if (serviceProvider != null) {
			IResourceDescription resourceDescription = serviceProvider.getResourceDescriptionManager().getResourceDescription(resource);
			if (resourceDescription != null) {
				index.addDescription(uri, resourceDescription);
			}
		}
	}
	
	/**
	 * @since 2.3
	 */
	protected void validateGrammar(Grammar grammar) {
		validateAllImports(grammar);
		EValidator validator = EValidator.Registry.INSTANCE.getEValidator(XtextPackage.eINSTANCE);
		if (validator != null) {
			DiagnosticChain chain = new DiagnosticChain() {

				@Override
				public void add(Diagnostic diagnostic) {
					if (diagnostic.getSeverity() == Diagnostic.ERROR) {
						if (diagnostic.getException() == null)
							throw new IllegalStateException(diagnostic.getMessage());
						else
							throw new IllegalStateException(diagnostic.getMessage(), diagnostic.getException());
					}
				}

				@Override
				public void addAll(Diagnostic diagnostic) {
					add(diagnostic);
				}

				@Override
				public void merge(Diagnostic diagnostic) {
					throw new UnsupportedOperationException();
				}
			};
			validator.validate(grammar, chain, null);
			TreeIterator<EObject> iterator = grammar.eAllContents();
			while (iterator.hasNext())
				validator.validate(iterator.next(), chain, new HashMap<Object, Object>());
		}
	}
	
	/**
	 * @since 2.3
	 */
	protected void validateAllImports(Grammar grammar) {
		for (AbstractMetamodelDeclaration amd : GrammarUtil.allMetamodelDeclarations(grammar))
			if (amd instanceof ReferencedMetamodel)
				validateReferencedMetamodel((ReferencedMetamodel) amd);
	}

	/**
	 * @since 2.3
	 */
	protected void validateReferencedMetamodel(ReferencedMetamodel ref) {
		if (ref.getEPackage() != null && !ref.getEPackage().eIsProxy())
			return;
		EReference eref = XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE;
		List<INode> nodes = NodeModelUtils.findNodesForFeature(ref, eref);
		String refName = nodes.isEmpty() ? "(unknown)" : NodeModelUtils.getTokenText(nodes.get(0));
		String grammarName = GrammarUtil.getGrammar(ref).getName();
		String msg = "The EPackage " + refName + " in grammar " + grammarName + " could not be found. ";
		msg += "You might want to register that EPackage in your workflow file.";
		throw new IllegalStateException(msg);
	}

	/**
	 * @return {@link Grammar}
	 */
	public Grammar getGrammar() {
		return grammar;
	}

	/**
	 * @since 2.9
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	/**
	 * @since 2.9
	 */
	public String getEncoding() {
		return encoding;
	}
}
