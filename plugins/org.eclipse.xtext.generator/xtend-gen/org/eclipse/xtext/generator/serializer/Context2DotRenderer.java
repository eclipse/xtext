package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.serializer.IContextProvider;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerPDAContext;
import org.eclipse.xtext.util.GraphvizDotBuilder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Context2DotRenderer {
  @Inject private IContextProvider iContextProvider;
  @Inject private Grammar grammar;
  @Inject private Naming naming;
  @Inject private Context2NameFunction context2NameFunction;
  
  public Iterable<SequencerPDAContext> types(final EObject ctx) {
    Set<EClass> _typesForContext = this.iContextProvider.getTypesForContext(ctx);
    final Function1<EClass,SequencerPDAContext> _function = new Function1<EClass,SequencerPDAContext>() {
        public SequencerPDAContext apply(final EClass t) {
          SequencerPDAContext _sequencerPDAContext = new SequencerPDAContext(ctx, t);
          return _sequencerPDAContext;
        }
      };
    Iterable<SequencerPDAContext> _map = IterableExtensions.<EClass, SequencerPDAContext>map(_typesForContext, _function);
    return _map;
  }
  
  public Iterable<SequencerPDAContext> contexts() {
    List<EObject> _allContexts = this.iContextProvider.getAllContexts(this.grammar);
    final Function1<EObject,Iterable<SequencerPDAContext>> _function = new Function1<EObject,Iterable<SequencerPDAContext>>() {
        public Iterable<SequencerPDAContext> apply(final EObject c) {
          Iterable<SequencerPDAContext> _types = Context2DotRenderer.this.types(c);
          return _types;
        }
      };
    List<Iterable<SequencerPDAContext>> _map = ListExtensions.<EObject, Iterable<SequencerPDAContext>>map(_allContexts, _function);
    Iterable<SequencerPDAContext> _flatten = IterableExtensions.<SequencerPDAContext>flatten(_map);
    return _flatten;
  }
  
  public Iterable<Pair<String,String>> render2Dot(final GraphvizDotBuilder builder, final String name) {
    Iterable<SequencerPDAContext> _contexts = this.contexts();
    final Function1<SequencerPDAContext,Pair<String,String>> _function = new Function1<SequencerPDAContext,Pair<String,String>>() {
        public Pair<String,String> apply(final SequencerPDAContext c) {
          String _fileName = Context2DotRenderer.this.getFileName(c, name);
          String _draw = builder.draw(c);
          Pair<String,String> _operator_mappedTo = ObjectExtensions.<String, String>operator_mappedTo(_fileName, _draw);
          return _operator_mappedTo;
        }
      };
    Iterable<Pair<String,String>> _map = IterableExtensions.<SequencerPDAContext, Pair<String,String>>map(_contexts, _function);
    return _map;
  }
  
  public String getFileName(final SequencerPDAContext ctx, final String name) {
    String _xblockexpression = null;
    {
      String _name = this.grammar.getName();
      String _simpleName = this.naming.toSimpleName(_name);
      String _operator_plus = StringExtensions.operator_plus(_simpleName, "_");
      EClass _type = ctx.getType();
      String _name_1 = _type.getName();
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name_1);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "_");
      EObject _context = ctx.getContext();
      String _contextName = this.context2NameFunction.getContextName(_context);
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, _contextName);
      String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "_");
      String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, name);
      final String fn = _operator_plus_5;
      String _basePackageRuntime = this.naming.basePackageRuntime(this.grammar);
      String _asPath = this.naming.asPath(_basePackageRuntime);
      String _operator_plus_6 = StringExtensions.operator_plus(_asPath, "/serializer/");
      String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, fn);
      String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, ".dot");
      _xblockexpression = (_operator_plus_8);
    }
    return _xblockexpression;
  }
}