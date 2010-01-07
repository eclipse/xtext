/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.containers.DelegatingIAllContainerAdapter;
import org.eclipse.xtext.resource.containers.IAllContainersState;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * <p>
 * A Reader used to read EMF resources from a set of pathes.
 * A path can point to a folder or an archive (zips and jars are supported).
 * Those pathes are recursively scanned and all resources for which an {@link IResourceServiceProvider} is
 * registered in the {@link IResourceServiceProvider.Registry} will be available.
 * </p>
 * 
 * <p>
 * The {@link ISetup} of an Xtext language registers such an {@link IResourceServiceProvider} automatically. If you want to integrate with non Xtext-based models,
 * make sure to add {@link IResourceServiceProvider} manually. The easiest way might be to implement an {@link ISetup}. 
 * </p>
 * <p>
 * A {@link SlotEntry} is responsible for selecting certain EObjects from the loaded resources.
 * It supports selecting EObjects by their name (see {@link org.eclipse.xtext.resource.IEObjectDescription}) or by an EClass.
 * In many cases such selction returns multiple EObjects, if you're only interested in one element set the firstOnly flag to <code>true</code>.
 * </p>
 * <p>
 * You might want to populate multiple workflow slots with model elements.
 * </p>
 * <p>
 * Below an example of a usage in the MWE XML syntax:
 * </p>
 * <pre>
 * &lt;component class="org.eclipse.xtext.mwe.Reader" useJavaClassPath="true"&gt;
 *   &lt;register class="foo.bar.MyLanguageSetandaloneSetup"/&gt;
 *   &lt;load slot="types" type="Type"/&gt;
 *   &lt;validate/&gt; 
 * &lt;/component&gt;
 * </pre>
 * It supports fetching elements by type
 * {@link IResourceServiceProvider#getResourceDescriptionManager()} is used to identify model elements within these resources. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class Reader extends AbstractWorkflowComponent2 {

	private final static Logger log = Logger.getLogger(Reader.class.getName());
	private List<String> pathes = Lists.newArrayList();

	/**
	 * <p>
	 * A path pointing to a folder, jar or zip which contains EMF resources.
	 * </p><p>
	 * Example use:
	 * </p> 
	 * <code>
	 * &lt;path value="./foo/bar.jar"/&gt;
	 * </code>
	 */
	public void addPath(String path) {
		this.pathes.add(path);
	}

	public List<String> getPathes() {
		return pathes;
	}

	/**
	 * <p>
	 * Automatically adds all class path entries of the current process (more specifically uses 'java.class.path' system property).
	 * </p><p>
	 * Example use:
	 * </p> 
	 * <code>
	 * &lt;useJavaClassPath value="true"/&gt;
	 * </code>
	 */
	public void setUseJavaClassPath(boolean isUse) {
		if (isUse) {
			String classPath = System.getProperty("java.class.path");
			String separator = System.getProperty("path.separator");
			String[] strings = classPath.split(separator);
			for (String path : strings) {
				addPath(path);
			}
		}
	}

	private Set<SlotEntry> slotEntries = Sets.newHashSet();

	/**
	 * Example use: 
	 * &lt;load type="Entity"/&gt;
	 */
	public void addLoad(SlotEntry outputSlot) {
		slotEntries.add(outputSlot);
	}
	
	public Set<SlotEntry> getSlotEntries() {
		return slotEntries;
	}

	private List<Injector> injectors = Lists.newArrayList();

	/**
	 * <p>
	 * Used to register any languages.
	 * </p>
	 * <p>
	 * For Xtext language a [MyLanguage]StandaloneSetup is generated automatically.
	 * If you want to work with other EMF based resources, you can use this hook in order to do any kind of initialization.
	 * </p>
	 */
	public void addRegister(ISetup setup) {
		injectors.add(setup.createInjectorAndDoEMFRegistration());
	}
	
	public List<Injector> getInjectors() {
		return injectors;
	}

	private Provider<ResourceSet> provider = null;

	public void setResourceSetProvider(Provider<ResourceSet> provider) {
		this.provider = provider;
	}
	
	/**
	 * By default the first registered language (see {@link #addRegister(ISetup)} is used to
	 * create an instanceof {@link ResourceSet}.
	 * 
	 * Use this hook in order to configure a different startegy.
	 */
	public Provider<ResourceSet> getResourceSetProvider() {
		return provider;
	}

	private Validator validator = new Validator();

	public void setValidate(Validator validator) {
		this.validator = validator;
	}
	
	/**
	 * The validator is used in order to validate the models.
	 * By default this property is not set. See {@link Validator} for details
	 * 
	 */
	public Validator getValidator() {
		return validator;
	}
	
	private ResourceDescriptionsProvider resourceDescriptionsProvider = new ResourceDescriptionsProvider();

	public void setResourceDescriptionsProvider(ResourceDescriptionsProvider resourceDescriptionsProvider) {
		this.resourceDescriptionsProvider = resourceDescriptionsProvider;
	}
	
	public ResourceDescriptionsProvider getResourceDescriptionsProvider() {
		return resourceDescriptionsProvider;
	}
	
	private ContainersStateFactory containersStateFactory = new ContainersStateFactory();

	public void setContainersStateFactory(ContainersStateFactory containersStateFactory) {
		this.containersStateFactory = containersStateFactory;
	}
	
	public ContainersStateFactory getContainersStateFactory() {
		return containersStateFactory;
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		super.checkConfigurationInternal(issues);
		if (pathes.isEmpty()) {
			issues.addWarning("No path set, using java class path entries (useJavaClassPath='true').");
			setUseJavaClassPath(true);
		}
		if (log.isDebugEnabled()) {
			log.debug("Resource Pathes : " + pathes);
		}
		for (String path : pathes) {
			if (!new File(path).exists())
				issues.addWarning("Skipping the path '" + path + "', because it does not exist.");
		}
		
		if (slotEntries.isEmpty()) {
			issues.addError("No slot entries (example <load slot='mySlot' type='Type'/>) configured. You need to add at least one slot entry.");
		}
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		ResourceSet resourceSet = getResourceSet();
		Multimap<String, URI> uris = new PathTraverser().resolvePathes(pathes, new Predicate<URI>() {
			public boolean apply(URI input) {
				return getRegistry().getResourceServiceProvider(input, null) != null;
			}
		});
		IAllContainersState containersState = containersStateFactory.getContainersState(pathes, uris);
		installAsAdapter(resourceSet, containersState);
		populateResourceSet(resourceSet, uris);
		if (validator != null) {
			validator.validate(resourceSet, getRegistry(), issues);
		}
		addModelElementsToContext(ctx, resourceSet);
	}

	protected void addModelElementsToContext(WorkflowContext ctx, ResourceSet resourceSet) {
		IResourceDescriptions descriptions = resourceDescriptionsProvider.get(resourceSet);
		for (SlotEntry entries : this.slotEntries) {
			entries.put(ctx, descriptions, resourceSet);
		}
	}

	protected void populateResourceSet(ResourceSet set, Multimap<String, URI> uris) {
		Collection<URI> values = Sets.newHashSet(uris.values());
		for (URI uri : values) {
			set.createResource(uri);
		}
	}

	protected void installAsAdapter(ResourceSet set, IAllContainersState containersState)
			throws WorkflowInterruptedException {
		set.eAdapters().add(new DelegatingIAllContainerAdapter(containersState));
	}

	protected IResourceServiceProvider.Registry getRegistry() {
		return IResourceServiceProvider.Registry.INSTANCE;
	}

	protected ResourceSet getResourceSet() {
		if (provider != null)
			return provider.get();
		if (!injectors.isEmpty()) {
			ResourceSet instance = injectors.get(0).getInstance(ResourceSet.class);
			return instance;
		}
		return new ResourceSetImpl();
	}

}
