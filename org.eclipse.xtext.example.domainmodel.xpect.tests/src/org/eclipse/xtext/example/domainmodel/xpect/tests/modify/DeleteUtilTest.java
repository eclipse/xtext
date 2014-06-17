package org.eclipse.xtext.example.domainmodel.xpect.tests.modify;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
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
import org.xpect.xtext.lib.util.TokenSerializer;
import org.xpect.xtext.lib.util.TokenSerializer.Token;

import com.google.inject.Inject;

@RunWith(XpectRunner.class)
@XpectSetup({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class })
public class DeleteUtilTest {

	@Inject
	private TokenSerializer serializer;

	@Inject
	private DeleteUtil deleteUtil;

	@Xpect
	@ParameterParser(syntax = "'delete' arg1=OFFSET")
	public void astDiff(@StringDiffExpectation IStringDiffExpectation expectation, EObject arg1) {
		EObject root = EcoreUtil2.getRootContainer(arg1);
		String beforeDeletion = new EObjectFormatter().apply(root);

		deleteUtil.deleteEntity((Entity) arg1);

		String afterDeletion = new EObjectFormatter().apply(root);
		expectation.assertDiffEquals(beforeDeletion, afterDeletion);
	}

	@Xpect
	@ParameterParser(syntax = "arg1=OFFSET")
	public void delete(@StringDiffExpectation IStringDiffExpectation expectation, EObject arg1) {
		EObject root = EcoreUtil2.getRootContainer(arg1);
		List<Token> beforeDeletion = serializer.serialize(root);

		deleteUtil.deleteEntity((Entity) arg1);

		List<Token> afterDeletion = serializer.serialize(root);
		expectation.assertDiffEquals(beforeDeletion, afterDeletion);
	}

}
