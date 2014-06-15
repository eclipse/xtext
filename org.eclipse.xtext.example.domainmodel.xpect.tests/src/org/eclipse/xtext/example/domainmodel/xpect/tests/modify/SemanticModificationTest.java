package org.eclipse.xtext.example.domainmodel.xpect.tests.modify;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.junit.runner.RunWith;
import org.xpect.expectation.IStringDiffExpectation;
import org.xpect.expectation.StringDiffExpectation;
import org.xpect.parameter.ParameterParser;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.setup.XpectSetup;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup;
import org.xpect.xtext.lib.util.EObjectFormatter;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
@RunWith(XpectRunner.class)
@XpectSetup({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class })
public class SemanticModificationTest {

	@Inject
	private TypeReferences typeReferencers;

	@Inject
	private IJvmModelAssociations associations;

	@Xpect
	@ParameterParser(syntax = "'delete' arg1=OFFSET")
	public void astDiff(@StringDiffExpectation IStringDiffExpectation expectation, EObject arg1) {
		EObject root = EcoreUtil2.getRootContainer(arg1);
		String beforeDeletion = new EObjectFormatter().apply(root);

		deleteEntity((Entity) arg1);

		String afterDeletion = new EObjectFormatter().apply(root);

		// System.out.println("before:");
		// System.out.println(beforeDeletion);
		// System.out.println();
		// System.out.println("after");
		// System.out.println(afterDeletion);
		expectation.assertDiffEquals(beforeDeletion, afterDeletion);
	}

	public void deleteEntity(Entity entity) {
		DomainModel dmodel = EcoreUtil2.getContainerOfType(entity, DomainModel.class);
		for (Entity ent : EcoreUtil2.getAllContentsOfType(dmodel, Entity.class)) {
			JvmParameterizedTypeReference superType = ent.getSuperType();
			if (superType != null && associations.getPrimarySourceElement(superType.getType()) == entity)
				EcoreUtil.remove(superType);
		}
		for (Property prop : EcoreUtil2.getAllContentsOfType(dmodel, Property.class)) {
			JvmTypeReference type = prop.getType();
			if (type != null && associations.getPrimarySourceElement(type.getType()) == entity)
				prop.setType(typeReferencers.getTypeForName(Void.TYPE, dmodel));
		}
		EcoreUtil.remove(entity);
	}
}
