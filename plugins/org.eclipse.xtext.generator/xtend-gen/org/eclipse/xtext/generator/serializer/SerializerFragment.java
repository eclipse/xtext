package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.serializer.AbstractSemanticSequencer;
import org.eclipse.xtext.generator.serializer.Context2DotRenderer;
import org.eclipse.xtext.generator.serializer.GrammarConstraints;
import org.eclipse.xtext.generator.serializer.SemanticSequencer;
import org.eclipse.xtext.generator.serializer.SerializerFragmentState;
import org.eclipse.xtext.generator.serializer.SyntacticSequencerPDA2ExtendedDot;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class SerializerFragment extends Xtend2GeneratorFragment {
  @Inject private AbstractSemanticSequencer abstractSemanticSequencer;
  @Inject private SemanticSequencer semanticSequencer;
  @Inject private GrammarConstraints grammarConstraints;
  @Inject private Context2DotRenderer context2DotRenderer;
  
  private final HashMap<ArrayList<?>,SerializerFragmentState> _createCache_state = new HashMap<ArrayList<?>,SerializerFragmentState>();
  
  public SerializerFragmentState state() {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList();
    SerializerFragmentState _this;
    synchronized (_createCache_state) {
      if (_createCache_state.containsKey(_cacheKey)) {
        return _createCache_state.get(_cacheKey);
      }
      SerializerFragmentState _serializerFragmentState = new SerializerFragmentState();
      _this = _serializerFragmentState;
      _createCache_state.put(_cacheKey, _this);
    }
    return _this;
  }
  
  public boolean setGenerateDebugData(final boolean doGenerate) {
    SerializerFragmentState _state = this.state();
    boolean _generateDebugData = _state.generateDebugData = doGenerate;
    return _generateDebugData;
  }
  
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    {
      BindFactory _bindFactory = new BindFactory();
      final BindFactory bf = _bindFactory;
      String _name = org.eclipse.xtext.serializer.ISemanticSequencer.class.getName();
      String _qualifiedName = this.semanticSequencer.getQualifiedName();
      bf.addTypeToType(_name, _qualifiedName);
      String _name_1 = org.eclipse.xtext.serializer.ISerializer.class.getName();
      String _name_2 = org.eclipse.xtext.serializer.impl.Serializer.class.getName();
      bf.addTypeToType(_name_1, _name_2);
      Set<Binding> _bindings = bf.getBindings();
      return _bindings;
    }
  }
  
  public void generate(final Xtend2ExecutionContext ctx) {
    {
      String _fileName = this.semanticSequencer.getFileName();
      String _fileContents = this.semanticSequencer.getFileContents();
      ctx.writeFile(Generator.SRC, _fileName, _fileContents);
      String _fileName_1 = this.abstractSemanticSequencer.getFileName();
      String _fileContents_1 = this.abstractSemanticSequencer.getFileContents();
      ctx.writeFile(Generator.SRC_GEN, _fileName_1, _fileContents_1);
      SerializerFragmentState _state = this.state();
      if (_state.generateDebugData) {
        {
          String _fileName_2 = this.grammarConstraints.getFileName();
          String _fileContents_2 = this.grammarConstraints.getFileContents();
          ctx.writeFile(Generator.SRC_GEN, _fileName_2, _fileContents_2);
          SyntacticSequencerPDA2ExtendedDot _syntacticSequencerPDA2ExtendedDot = new SyntacticSequencerPDA2ExtendedDot();
          Iterable<Pair<String,String>> _render2Dot = this.context2DotRenderer.render2Dot(_syntacticSequencerPDA2ExtendedDot, "pda");
          for (Pair<String,String> obj : _render2Dot) {
            String _key = obj.getKey();
            String _value = obj.getValue();
            ctx.writeFile(Generator.SRC_GEN, _key, _value);
          }
        }
      }
    }
  }
}