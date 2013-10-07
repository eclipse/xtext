package org.xpect.xtext.lib.setup.emf;

import java.util.List;

import org.xpect.setup.ISetupInitializer;
import org.xpect.setup.XpectSetup;
import org.xpect.state.Creates;
import org.xpect.xtext.lib.setup.generic.GenericResource;

import com.google.common.collect.Lists;

@XpectSetup(ResourceSetDefaultsSetup.class)
public class ResourceSetDefaultsSetup {

	private List<GenericResource> genericResources = Lists.newArrayList();

	private ResourceSet resourceSet = null;

	public ResourceSetDefaultsSetup(ISetupInitializer<ResourceSetDefaultsSetup> initializer) {
		super();
		initialize(initializer);
	}

	public void add(GenericResource genericResource) {
		this.genericResources.add(genericResource);
	}

	public void add(ResourceSet resourceSet) {
		if (this.resourceSet != null)
			throw new IllegalStateException("Only one ResourceSet can be configured");
		this.resourceSet = resourceSet;
	}

	protected void addThisFileIfNeeded() {
		for (ResourceFactory fact : this.resourceSet.getFactories())
			if (fact instanceof ThisFile)
				return;
		this.resourceSet.add(new ThisFile());
	}

	protected ResourceFactory convert(GenericResource res) {
		if (res instanceof org.xpect.xtext.lib.setup.generic.File)
			return new File((org.xpect.xtext.lib.setup.generic.File) res);
		else if (res instanceof org.xpect.xtext.lib.setup.generic.ThisFile)
			return new org.xpect.xtext.lib.setup.emf.ThisFile((org.xpect.xtext.lib.setup.generic.ThisFile) res);
		throw new IllegalStateException();
	}

	protected ResourceSet createResourceSet() {
		return new ResourceSet();
	}

	@Creates
	public ResourceSet getResourceSet() {
		return this.resourceSet;
	}

	protected void initialize(ISetupInitializer<ResourceSetDefaultsSetup> initializer) {
		initializer.initialize(this);
		if (resourceSet == null)
			resourceSet = createResourceSet();
		for (GenericResource generic : genericResources)
			this.resourceSet.add(convert(generic));
		addThisFileIfNeeded();
	}

}