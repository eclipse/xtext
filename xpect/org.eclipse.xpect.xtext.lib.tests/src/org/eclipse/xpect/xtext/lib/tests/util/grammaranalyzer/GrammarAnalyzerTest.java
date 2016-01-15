package org.eclipse.xpect.xtext.lib.tests.util.grammaranalyzer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xpect.expectation.ILinesExpectation;
import org.eclipse.xpect.expectation.LinesExpectation;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xpect.xtext.lib.setup.ThisModel;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.eclipse.xpect.xtext.lib.util.GrammarAnalyzer;
import org.eclipse.xpect.xtext.lib.util.GrammarAnalyzer.CommentRule;
import org.eclipse.xtext.Grammar;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;

@RunWith(XpectRunner.class)
@XpectSetup(XtextStandaloneSetup.class)
public class GrammarAnalyzerTest {
	@Xpect
	public void comments(@LinesExpectation ILinesExpectation expectation, @ThisModel EObject grammar) {
		List<String> actual = Lists.newArrayList();
		for (CommentRule comment : new GrammarAnalyzer((Grammar) grammar).getCommentRules())
			actual.add(comment.toString());
		expectation.assertEquals(actual);
	}
}
