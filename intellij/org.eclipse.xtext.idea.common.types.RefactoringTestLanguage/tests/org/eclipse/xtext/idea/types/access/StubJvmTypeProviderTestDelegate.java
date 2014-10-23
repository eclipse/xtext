package org.eclipse.xtext.idea.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProviderTest;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.resource.IResourceSetProvider;
import org.eclipse.xtext.psi.IPsiModelAssociator;

import com.google.inject.Inject;
import com.intellij.openapi.project.Project;

public class StubJvmTypeProviderTestDelegate extends AbstractTypeProviderTest {

	@Inject
	protected IResourceSetProvider resourceSetProvider;

	@Inject
	protected IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	@Inject
	protected IPsiModelAssociator psiModelAssociator;
	
	@Inject
	protected TypeResourceServices services;

	private IJvmTypeProvider typeProvider;

	public void setUp(Project project) throws Exception {
		super.setUp();
		RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
		ResourceSet resourceSet = resourceSetProvider.get(project);
		typeProvider = new StubJvmTypeProvider(project, resourceSet, indexedJvmTypeAccess, services, psiModelAssociator);
	}

	public void tearDown() {
		typeProvider = null;
	}

	@Override
	protected String getCollectionParamName() {
		return "collection";
	}

	@Override
	protected IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}

}