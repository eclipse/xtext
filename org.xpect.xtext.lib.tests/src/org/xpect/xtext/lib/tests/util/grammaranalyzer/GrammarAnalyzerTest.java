package org.xpect.xtext.lib.tests.util.grammaranalyzer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.junit.runner.RunWith;
import org.xpect.expectation.ILinesExpectation;
import org.xpect.expectation.LinesExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.setup.XpectSetup;
import org.xpect.xtext.lib.setup.ThisModel;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.util.GrammarAnalyzer;
import org.xpect.xtext.lib.util.GrammarAnalyzer.CommentRule;

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
