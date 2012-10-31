package org.xpect.xtext.lib.setup;


public class FileCtx {

	private ResourceSet resourceSet = null;

	private AssertingValidator validate;

	public AssertingValidator getValidate() {
		if (validate == null)
			validate = new AssertingValidator();
		return validate;
	}

	public void setValidate(AssertingValidator validate) {
		this.validate = validate;
	}

	public void add(ResourceSet resourceSet) {
		if (this.resourceSet != null)
			throw new IllegalStateException("Only one ResourceSet per test is supported.");
		this.resourceSet = resourceSet;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

}