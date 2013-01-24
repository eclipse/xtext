package org.eclipse.xtend.core.tests.performance;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.performance.GeneratorConfig;
import org.eclipse.xtend.core.tests.performance.XtendFileGenerator;
import org.eclipse.xtext.junit4.internal.StopWatchRule;
import org.eclipse.xtext.util.internal.StopWatches;
import org.eclipse.xtext.util.internal.StopWatches.StoppedTask;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Rule;
import org.junit.Test;

@SuppressWarnings("all")
public class PerformanceTest extends AbstractXtendTestCase {
  @Inject
  private XtendFileGenerator fileGenerator;
  
  @Rule
  public static StopWatchRule rule = new Function0<StopWatchRule>() {
    public StopWatchRule apply() {
      StopWatchRule _stopWatchRule = new StopWatchRule(true);
      return _stopWatchRule;
    }
  }.apply();
  
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
   */
  @Test
  public void doCompile() {
    try {
      final int num = 50;
      final Map<String,? extends CharSequence> map = this.fileGenerator.getDependencies();
      final List<String> files = CollectionLiterals.<String>newArrayList();
      Collection<? extends CharSequence> _values = map.values();
      final Function1<CharSequence,String> _function = new Function1<CharSequence,String>() {
          public String apply(final CharSequence it) {
            String _string = it.toString();
            return _string;
          }
        };
      Iterable<String> _map = IterableExtensions.map(_values, _function);
      Iterables.<String>addAll(files, _map);
      GeneratorConfig _generatorConfig = new GeneratorConfig();
      final GeneratorConfig config = _generatorConfig;
      config.packageName = "generated";
      config.noTypeInference = false;
      IntegerRange _upTo = new IntegerRange(0, num);
      for (final Integer i : _upTo) {
        {
          String _plus = ("MyGeneratedType" + i);
          config.className = _plus;
          CharSequence _contents = this.fileGenerator.getContents(config);
          String _string = _contents.toString();
          files.add(_string);
        }
      }
      final StoppedTask task = StopWatches.forTask("Validate all");
      task.start();
      this.files(true, ((String[]) ((String[])Conversions.unwrapArray(files, String.class))));
      task.stop();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
