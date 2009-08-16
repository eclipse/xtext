package org.eclipse.xtext.generator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Runs all tests in this plug-in. Delegates to eclipse auto-generated test
 * suites (New->TestSuite) in the contained packages.
 *
 * @author Jan Koehnlein
 */
public class PluginTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.generator.tests");
		suite.addTestSuite(org.eclipse.xtext.EcoreUtil2Test.class);
		suite.addTestSuite(org.eclipse.xtext.GrammarUtilTest.class);
		suite.addTestSuite(org.eclipse.xtext.XtextGrammarTest.class);
		suite.addTestSuite(org.eclipse.xtext.actions.ParserTest.Antlr.class);
		suite.addTestSuite(org.eclipse.xtext.actions.ParserTest.Packrat.class);
		suite.addTestSuite(org.eclipse.xtext.enumrules.ParserTest.Antlr.class);
		suite.addTestSuite(org.eclipse.xtext.enumrules.ParserTest.Packrat.class);
		suite.addTestSuite(org.eclipse.xtext.enumrules.EnumAndReferenceTest.Antlr.class);
		suite.addTestSuite(org.eclipse.xtext.enumrules.EnumAndReferenceTest.Packrat.class);
		suite.addTestSuite(org.eclipse.xtext.enumrules.GrammarParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.generator.grammarAccess.EmptyPackageAwareGrammarAccessFragmentTest.class);
		suite.addTestSuite(org.eclipse.xtext.generator.grammarAccess.FragmentFakingEcoreResourceTest.class);
		suite.addTestSuite(org.eclipse.xtext.generator.grammarAccess.ParserTest.class);
//		suite.addTestSuite(org.eclipse.xtext.generator.LargeMetamodelTest.class);
		suite.addTestSuite(org.eclipse.xtext.generator.ManifestMergerTest.class);
		suite.addTestSuite(org.eclipse.xtext.generator.resource.ResourceTest.class);
		suite.addTestSuite(org.eclipse.xtext.grammarinheritance.InheritanceTest.class);
		suite.addTestSuite(org.eclipse.xtext.grammarinheritance.Bug265111Test.class);
		suite.addTestSuite(org.eclipse.xtext.grammarinheritance.ToEcoreTrafoTest.class);
		suite.addTestSuite(org.eclipse.xtext.lexer.LexerErrorTest.class);
		suite.addTestSuite(org.eclipse.xtext.lexer.LexerSLComment.class);
		suite.addTestSuite(org.eclipse.xtext.linking.CrossRefTest.class);
		suite.addTestSuite(org.eclipse.xtext.linking.LinkingErrorTest.class);
		suite.addTestSuite(org.eclipse.xtext.linking.lazy.BasicLazyLinkingTest.class);
		suite.addTestSuite(org.eclipse.xtext.linking.lazy.LazyURIEncoderTest.class);
		suite.addTestSuite(org.eclipse.xtext.linking.lazy.LazyLinkerTest.class);
		suite.addTestSuite(org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest.class);
		suite.addTestSuite(org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTest.class);
		suite.addTestSuite(org.eclipse.xtext.parseerrorhandling.ParseErrorHandlingTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.DefaultEcoreElementFactoryTest.class);
        suite.addTestSuite(org.eclipse.xtext.parser.OffsetInformationTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParserReplaceTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParsingPerformanceTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParsingPointerTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.XtextGrammarComparingTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.XtextParserBugsTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.XtextParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.antlr.LexerProviderTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.GrammarTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.MetamodelTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.MetamodelTransformationErrorTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.MetamodelTransformationTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.PackratParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.ParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.PartialParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.SerializationTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.datatyperules.ValueConverterTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.epatch.EpatchComparingTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.keywords.GrammarAccessTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.keywords.ParserTest.Antlr.class);
		suite.addTestSuite(org.eclipse.xtext.parser.keywords.ParserTest.Packrat.class);
		suite.addTestSuite(org.eclipse.xtext.parser.packrat.PackratParserGenUtilTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.packrat.PerformanceTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.packrat.PerformanceTestXtextGrammar.class);
		suite.addTestSuite(org.eclipse.xtext.parser.terminalrules.DynamicChannelTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.terminalrules.HiddensTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.terminalrules.InterpreterTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.terminalrules.PackratHiddensTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.terminalrules.PackratParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.terminalrules.ParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.ASTChangeTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.CommentTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.EmptyModelTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.HiddenTokensTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.InvalidTokenTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.LengthOffsetLineTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.NodeContentAdapterTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.NodeModelTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.NodeUtilTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.ParseTreeUtilTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.SerializeTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.impl.ParsetreeUtilTest.LinuxAndMac.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.impl.ParsetreeUtilTest.Windows.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.impl.ParsetreeUtilTest2.class);
//		suite.addTestSuite(org.eclipse.xtext.parsetree.formatter.FormatterTest.class);
//		suite.addTestSuite(org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTest.class);
//		suite.addTestSuite(org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTest.class);
//		suite.addTestSuite(org.eclipse.xtext.parsetree.reconstr.WhitespacePreservingCallbackTest.class);
//		suite.addTestSuite(org.eclipse.xtext.parsetree.reconstr.XtextGrammarReconcilationTest.class);
//		suite.addTestSuite(org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest.class);
		suite.addTestSuite(org.eclipse.xtext.reference.CommentOnEofBug_234135_Test.class);
		suite.addTestSuite(org.eclipse.xtext.reference.LeafNodeBug_234132_Test.class);
		suite.addTestSuite(org.eclipse.xtext.resource.XtextResourcePerformanceTest.class);
		suite.addTestSuite(org.eclipse.xtext.resource.XtextResourceTest.class);
		suite.addTestSuite(org.eclipse.xtext.resource.ClassloaderClasspathUriResolverTests.class);
		suite.addTestSuite(org.eclipse.xtext.service.AbstractGenericModuleTest.class);
		suite.addTestSuite(org.eclipse.xtext.scoping.DefaultScopeProviderTest.class);
		suite.addTestSuite(org.eclipse.xtext.scoping.DeclarativeScopeProviderTest.class);
//		suite.addTestSuite(org.eclipse.xtext.scoping.index.IndexBasedScopeProviderTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.ecoreInference.MultiValueFeatureTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.ecoreInference.ResourceTests.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.ecoreInference.TypeHierarchyHelperTests.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformerTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTest.class);
		suite.addTestSuite(org.eclipse.xtext.util.SimpleCacheTest.class);
		suite.addTestSuite(org.eclipse.xtext.validation.AbstractDeclarativeValidatorTest.class);
		suite.addTestSuite(org.eclipse.xtext.validation.ConcurrentValidationTest.class);
		suite.addTestSuite(org.eclipse.xtext.validation.CompositeValidatorTest.WithEObjectValidator.class);
		suite.addTestSuite(org.eclipse.xtext.validation.CompositeValidatorTest.WithoutEObjectValidator.class);
		suite.addTestSuite(org.eclipse.xtext.validation.ImportUriValidatorTest.class);
		suite.addTestSuite(org.eclipse.xtext.valueconverter.Bug250313.Antlr.class);
		suite.addTestSuite(org.eclipse.xtext.valueconverter.Bug250313.Packrat.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.ExceptionTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.ResourceLoadTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.parser.packrat.XtextPackratParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.XtextValidationTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.OverriddenValueIdentifierTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.XtextScopingTest.class);
		return suite;
	}
}
