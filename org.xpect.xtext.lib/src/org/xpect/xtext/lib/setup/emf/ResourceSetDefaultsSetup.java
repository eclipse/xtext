package org.xpect.xtext.lib.setup.emf;

import java.util.List;

import org.xpect.setup.ISetupInitializer;
import org.xpect.setup.XpectSetup;
import org.xpect.state.Creates;
import org.xpect.xtext.lib.setup.generic.Resource;

import com.google.common.collect.Lists;

@XpectSetup(ResourceSetDefaultsSetup.class)
public class ResourceSetDefaultsSetup {

	private List<Resource> genericResources = Lists.newArrayList();

	private ResourceSet resourceSet = null;

	public ResourceSetDefaultsSetup(ISetupInitializer<ResourceSetDefaultsSetup> initializer) {
		super();
		initialize(initializer);
	}

	public void add(Resource genericResource) {
		this.genericResources.add(genericResource);
	}

	public void add(ResourceSet resourceSet) {
		if (this.resourceSet != null)
			throw new IllegalStateException("Only one ResourceSet can be configured");
		this.resourceSet = resourceSet;
	}

	protected void addThisFileIfNeeded() {
		for (ResourceFactory fact : this.resourceSet.getFactories())
			if (fact instanceof ThisResource)
				return;
		this.resourceSet.add(new ThisResource());
	}

	protected void convert(Resource res) {
		if (res instanceof org.xpect.xtext.lib.setup.generic.ThisFile)
			this.resourceSet.add(new org.xpect.xtext.lib.setup.emf.ThisResource((org.xpect.xtext.lib.setup.generic.ThisFile) res));
		else if (res instanceof org.xpect.xtext.lib.setup.generic.File)
			this.resourceSet.add(new org.xpect.xtext.lib.setup.emf.Resource((org.xpect.xtext.lib.setup.generic.File) res));
		else if (res instanceof org.xpect.xtext.lib.setup.generic.Folder)
			for (Resource child : ((org.xpect.xtext.lib.setup.generic.Folder) res).getChildren())
				convert(child);
		else
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
		for (Resource res : genericResources)
			convert(res);
		addThisFileIfNeeded();
	}

}