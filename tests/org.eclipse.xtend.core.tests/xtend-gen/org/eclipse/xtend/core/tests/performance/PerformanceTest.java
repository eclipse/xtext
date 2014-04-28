package org.eclipse.xtend.core.tests.performance;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.performance.GeneratorConfig;
import org.eclipse.xtend.core.tests.performance.XtendFileGenerator;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

@SuppressWarnings("all")
public class PerformanceTest extends AbstractXtendTestCase {
  @Inject
  private XtendFileGenerator fileGenerator;
  
  @Rule
  public final StopwatchRule rule = new StopwatchRule(true);
  
  /**
   * Sven 2013-01-24 (old typesystem)
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'Validate all' took 20869ms (1 measurements).
   * Task 'parsing' took 1181ms (57 measurements).
   * Task 'primary JVM Model inference' took 1899ms (57 measurements).
   * Task '[macros] findActiveAnnotations' took 802ms (57 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference' took 0ms (57 measurements).
   * Task 'Crosslink resolution' took 23223ms (11902 measurements).
   * Task 'validation' took 17002ms (57 measurements).
   * ----------------------------------------------------
   * 
   * Sven 2013-01-24 (new typesystem)
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'Validate all' took 19591ms (1 measurements).
   * Task 'parsing' took 1087ms (57 measurements).
   * Task 'primary JVM Model inference' took 1703ms (57 measurements).
   * Task '[macros] findActiveAnnotations' took 824ms (57 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference' took 0ms (57 measurements).
   * Task 'Crosslink resolution' took 6639ms (4076 measurements).
   * Task 'validation' took 15979ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 12025ms (57 measurements).
   * Task 'LightweightTypeReference.copyInto' took 84ms (379414 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 1745ms (283109 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 13ms (267 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 159ms (31429 measurements).
   * Task 'UnboundTypeReference.copyInto' took 23ms (24385 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * 
   * Sven 2013-01-24 (after cached ClassFinder - new typesystem)
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'Validate all' took 14995ms (1 measurements).
   * Task 'parsing' took 1166ms (57 measurements).
   * Task 'primary JVM Model inference' took 1229ms (57 measurements).
   * Task '[macros] findActiveAnnotations' took 596ms (57 measurements).
   * Task 'Load class ' took 329ms (204809 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference' took 1ms (57 measurements).
   * Task 'Crosslink resolution' took 2366ms (4076 measurements).
   * Task 'validation' took 11717ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 9475ms (57 measurements).
   * Task 'LightweightTypeReference.copyInto' took 114ms (379414 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 1730ms (283109 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 14ms (267 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 157ms (31429 measurements).
   * Task 'UnboundTypeReference.copyInto' took 28ms (24385 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Sven 2013-01-24 (after cached ClassFinder - new typesystem)
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'Validate all' took 14135ms (1 measurements).
   * Task 'parsing' took 1243ms (57 measurements).
   * Task 'primary JVM Model inference' took 1416ms (57 measurements).
   * Task '[macros] findActiveAnnotations' took 569ms (57 measurements).
   * Task 'Load class ' took 301ms (60879 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference' took 0ms (57 measurements).
   * Task 'Crosslink resolution' took 12790ms (11902 measurements).
   * Task 'validation' took 10647ms (57 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * 
   * Test 'doCompile(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'Validate all' took 10521ms (1 measurements).
   * Task 'parsing' took 720ms (57 measurements).
   * Task 'primary JVM Model inference' took 1756ms (57 measurements).
   * Task '[macros] findActiveAnnotations' took 1202ms (57 measurements).
   * Task 'ClassFinder.forName' took 1189ms (60887 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference' took 0ms (57 measurements).
   * Task 'Crosslink resolution' took 10582ms (11902 measurements).
   * Task 'validation' took 7569ms (57 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Test 'doCompile(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 9253ms (1 measurements).
   * Task 'AbstractParser.parse' took 696ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1485ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 1113ms (57 measurements).
   * Task 'ClassFinder.forName' took 237ms (172817 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (57 measurements).
   * Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 2225ms (4074 measurements).
   * Task 'ResourceValidatorImpl.validation' took 6575ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 5101ms (114 measurements).
   * Task 'LightweightTypeReference.copyInto' took 70ms (274432 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 1295ms (265117 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 5ms (62 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 57ms (12012 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Test 'doCompile(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * (without warmup)
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 8441ms (1 measurements).
   * Task 'AbstractParser.parse' took 723ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1507ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 1105ms (57 measurements).
   * Task 'ClassFinder.forName' took 199ms (72275 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (57 measurements).
   * Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 2312ms (4074 measurements).
   * Task 'ResourceValidatorImpl.validation' took 5690ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 3923ms (114 measurements).
   * Task 'LightweightTypeReference.copyInto' took 44ms (94082 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 491ms (74909 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 6ms (62 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 73ms (11369 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * (with warmup)
   * Task 'PerformanceTest.doCompile' took 6106ms (1 measurements).
   * Task 'AbstractParser.parse' took 408ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 349ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 159ms (57 measurements).
   * Task 'ClassFinder.forName' took 311ms (72275 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (57 measurements).
   * Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 1267ms (4074 measurements).
   * Task 'ResourceValidatorImpl.validation' took 5108ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 3730ms (114 measurements).
   * Task 'LightweightTypeReference.copyInto' took 24ms (94082 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 442ms (74909 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 0ms (62 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 54ms (11369 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 5364ms (1 measurements).
   * Task 'AbstractParser.parse' took 385ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 428ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 157ms (57 measurements).
   * Task 'ClassFinder.forName' took 227ms (72428 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (57 measurements).
   * Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 1167ms (4074 measurements).
   * Task 'ResourceValidatorImpl.validation' took 4275ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2986ms (114 measurements).
   * Task 'LightweightTypeReference.copyInto' took 33ms (94082 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 357ms (74909 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 1ms (62 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 42ms (11369 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * with warm-up: (ClasspathTypeProvider#TypesInResourceSetCache
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4891ms (1 measurements).
   * Task 'AbstractParser.parse' took 334ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 217ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 75ms (57 measurements).
   * Task 'ClassFinder.forName' took 203ms (72426 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (57 measurements).
   * Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 491ms (4074 measurements).
   * Task 'ResourceValidatorImpl.validation' took 4158ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 3019ms (114 measurements).
   * Task 'LightweightTypeReference.copyInto' took 51ms (101296 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 439ms (75827 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 0ms (62 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 46ms (11370 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * without warm-up:
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 7122ms (1 measurements).
   * Task 'AbstractParser.parse' took 686ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1264ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 957ms (57 measurements).
   * Task 'ClassFinder.forName' took 181ms (72426 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (57 measurements).
   * Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 1473ms (4074 measurements).
   * Task 'ResourceValidatorImpl.validation' took 4679ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 3317ms (114 measurements).
   * Task 'LightweightTypeReference.copyInto' took 26ms (101296 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 481ms (75827 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 2ms (62 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 82ms (11370 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * with warm-up: refactored checkImports
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4149ms (1 measurements).
   * Task 'AbstractParser.parse' took 370ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 256ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 80ms (57 measurements).
   * Task 'ClassFinder.forName' took 157ms (72426 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (57 measurements).
   * Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 411ms (4074 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3272ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2347ms (114 measurements).
   * Task 'LightweightTypeReference.copyInto' took 21ms (101296 measurements).
   * Task 'LightweightTypeReference#internalIsAssignableFrom' took 355ms (75827 measurements).
   * Task 'LightweightTypeReference#collectSuperTypes' took 1ms (62 measurements).
   * Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 32ms (11370 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Before '.' as nested class delimiter:
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 8366ms (3 measurements).
   * Task 'AbstractParser.parse' took 513ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 409ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 421ms (171 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 138ms (171 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 1ms (171 measurements).
   * Task 'ResourceValidatorImpl.validation' took 6980ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 5119ms (342 measurements).
   * Task 'StaticExtensionImportsScope.getLocalElementsByName' took 848ms (16962 measurements).
   * Task 'StaticImportsScope.getLocalElementsByName' took 3ms (1866 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * After '.' as nested class delimiter:
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 12666ms (3 measurements).
   * Task 'AbstractParser.parse' took 512ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 440ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 749ms (171 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 318ms (171 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (171 measurements).
   * Task 'ResourceValidatorImpl.validation' took 10917ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 7794ms (342 measurements).
   * Task 'StaticExtensionImportsScope.getLocalElementsByName' took 971ms (16962 measurements).
   * Task 'StaticImportsScope.getLocalElementsByName' took 5ms (1866 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Test 'doCompile(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 9396ms (1 measurements).
   * Task 'AbstractParser.parse' took 762ms (57 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 516ms (57 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1631ms (57 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 1082ms (57 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 1ms (57 measurements).
   * Task 'ResourceValidatorImpl.validation' took 6433ms (57 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 4842ms (114 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * After '.' as nested class delimiter with fixed import normalizers
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 12876ms (3 measurements).
   * Task 'AbstractParser.parse' took 519ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 450ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 740ms (171 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 310ms (171 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 2ms (171 measurements).
   * Task 'ResourceValidatorImpl.validation' took 11122ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 8023ms (342 measurements).
   * Task 'StaticExtensionImportsScope.getLocalElementsByName' took 989ms (16962 measurements).
   * Task 'StaticImportsScope.getLocalElementsByName' took 9ms (1866 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Sketched optimized type scope:
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 7216ms (3 measurements).
   * Task 'AbstractParser.parse' took 524ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 410ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 641ms (171 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 375ms (171 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (171 measurements).
   * Task 'ResourceValidatorImpl.validation' took 5596ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 4144ms (342 measurements).
   * Task 'StaticExtensionImportsScope.getLocalElementsByName' took 898ms (16962 measurements).
   * Task 'StaticImportsScope.getLocalElementsByName' took 2ms (1866 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Sketched optimized type scope with caching:
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 6604ms (3 measurements).
   * Task 'AbstractParser.parse' took 518ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 455ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 435ms (171 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 218ms (171 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (171 measurements).
   * Task 'ResourceValidatorImpl.validation' took 5154ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 3978ms (342 measurements).
   * Task 'StaticExtensionImportsScope.getLocalElementsByName' took 986ms (16962 measurements).
   * Task 'StaticImportsScope.getLocalElementsByName' took 11ms (1866 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * After specialized lazy linking
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 6193ms (3 measurements).
   * Task 'AbstractParser.parse' took 495ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 295ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 342ms (171 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 133ms (171 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 3ms (171 measurements).
   * Task 'ResourceValidatorImpl.validation' took 5014ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 3885ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * After unicode identifiers: 2.5
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 5409ms (3 measurements).
   * Task 'AbstractParser.parse' took 913ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 314ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 612ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 228ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3675ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2688ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * After flexing rather than lexing
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4908ms (3 measurements).
   * Task 'AbstractParser.parse' took 407ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 338ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 637ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 245ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 1ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3624ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2661ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Before ClassReaderTypeProvider
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4381ms (3 measurements).
   * Task 'AbstractParser.parse' took 379ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 207ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 553ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 236ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 1ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3347ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2410ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * After ClassReaderTypeProvider
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4314ms (3 measurements).
   * Task 'AbstractParser.parse' took 404ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 198ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 528ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 227ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 2ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3289ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2341ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * v2.5.2
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4752ms (3 measurements).
   * Task 'AbstractParser.parse' took 465ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 214ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 575ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 236ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 1ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3608ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2579ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * v2.5.3
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4410ms (3 measurements).
   * Task 'AbstractParser.parse' took 446ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 203ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 541ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 225ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 1ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3329ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2370ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * v2.5.4
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4583ms (3 measurements).
   * Task 'AbstractParser.parse' took 431ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 212ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 582ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 256ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3462ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2451ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * Before extraction of IFeatureScopeTracker
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 5489ms (3 measurements).
   * Task 'AbstractParser.parse' took 519ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 222ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 540ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 224ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 4303ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 3128ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   * After extraction of IFeatureScopeTracker
   * Test 'doCompileThreeTimes(org.eclipse.xtend.core.tests.performance.PerformanceTest)' :
   * -------------------------------------------------------------------------------------------------------------------------
   * Task 'PerformanceTest.doCompile' took 4617ms (3 measurements).
   * Task 'AbstractParser.parse' took 456ms (171 measurements).
   * Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 207ms (171 measurements).
   * Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 541ms (339 measurements).
   * Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 218ms (339 measurements).
   * Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (339 measurements).
   * Task 'ResourceValidatorImpl.validation' took 3495ms (171 measurements).
   * Task 'DefaultReentrantTypeResolver.resolve' took 2413ms (342 measurements).
   * -------------------------------------------------------------------------------------------------------------------------
   */
  @Test
  public void doCompile() {
    try {
      final int num = 50;
      final Map<String, ? extends CharSequence> map = this.fileGenerator.getDependencies();
      final List<String> files = CollectionLiterals.<String>newArrayList();
      Collection<? extends CharSequence> _values = map.values();
      final Function1<CharSequence, String> _function = new Function1<CharSequence, String>() {
        public String apply(final CharSequence it) {
          return it.toString();
        }
      };
      Iterable<String> _map = IterableExtensions.map(_values, _function);
      Iterables.<String>addAll(files, _map);
      final GeneratorConfig config = new GeneratorConfig();
      config.packageName = "generated";
      config.noTypeInference = false;
      IntegerRange _upTo = new IntegerRange(0, num);
      for (final Integer i : _upTo) {
        {
          config.className = ("MyGeneratedType" + i);
          CharSequence _contents = this.fileGenerator.getContents(config);
          String _string = _contents.toString();
          files.add(_string);
        }
      }
      final Stopwatches.StoppedTask task = Stopwatches.forTask("PerformanceTest.doCompile");
      task.start();
      this.files(true, ((String[]) ((String[])Conversions.unwrapArray(files, String.class))));
      task.stop();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void doCompileAgain() {
    this.doCompile();
  }
  
  @Test
  public void doCompileTwice() {
    this.doCompile();
    this.doCompile();
  }
  
  @Test
  public void doCompileThreeTimes() {
    this.doCompile();
    this.doCompile();
    this.doCompile();
  }
  
  @Test
  @Ignore
  public void doCompileFiveTimes() {
    this.doCompile();
    this.doCompile();
    this.doCompile();
    this.doCompile();
    this.doCompile();
  }
  
  @Test
  @Ignore
  public void doCompileTenTimes() {
    this.doCompileFiveTimes();
    this.doCompileFiveTimes();
  }
  
  @Test
  @Ignore
  public void doCompileTwentyTimes() {
    this.doCompileFiveTimes();
    this.doCompileFiveTimes();
    this.doCompileFiveTimes();
    this.doCompileFiveTimes();
  }
}
