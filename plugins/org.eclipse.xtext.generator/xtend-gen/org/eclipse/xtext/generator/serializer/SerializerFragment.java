package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.serializer.AbstractSemanticSequencer;
import org.eclipse.xtext.generator.serializer.AbstractSyntacticSequencer;
import org.eclipse.xtext.generator.serializer.DebugGraphGenerator;
import org.eclipse.xtext.generator.serializer.GrammarConstraints;
import org.eclipse.xtext.generator.serializer.SemanticSequencer;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames.GenFileName;
import org.eclipse.xtext.generator.serializer.SyntacticSequencer;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class SerializerFragment extends Xtend2GeneratorFragment {
  @Inject
  private AbstractSemanticSequencer abstractSemanticSequencer;
  
  @Inject
  private SemanticSequencer semanticSequencer;
  
  @Inject
  private AbstractSyntacticSequencer abstractSyntacticSequencer;
  
  @Inject
  private SyntacticSequencer syntacticSequencer;
  
  @Inject
  private GrammarConstraints grammarConstraints;
  
  @Inject
  private DebugGraphGenerator debugGraphGenerator;
  
  @Inject
  private SerializerGenFileNames names;
  
  private boolean generateDebugData = false;
  
  private boolean srcGenOnly = false;
  
  public boolean setGenerateDebugData(final boolean doGenerate) {
    boolean _generateDebugData = this.generateDebugData = doGenerate;
    return _generateDebugData;
  }
  
  public boolean setSrcGenOnly(final boolean srcGen) {
    boolean _srcGenOnly = this.srcGenOnly = srcGen;
    return _srcGenOnly;
  }
  
  public boolean setGenerateStub(final boolean generateStub) {
    boolean _not = (!generateStub);
    boolean _srcGenOnly = this.srcGenOnly = _not;
    return _srcGenOnly;
  }
  
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    BindFactory _bindFactory = new BindFactory();
    final BindFactory bf = _bindFactory;
    String _name = ISemanticSequencer.class.getName();
    GenFileName _semanticSequencer = this.names.getSemanticSequencer();
    String _qualifiedName = _semanticSequencer.getQualifiedName();
    bf.addTypeToType(_name, _qualifiedName);
    String _name_1 = ISyntacticSequencer.class.getName();
    GenFileName _syntacticSequencer = this.names.getSyntacticSequencer();
    String _qualifiedName_1 = _syntacticSequencer.getQualifiedName();
    bf.addTypeToType(_name_1, _qualifiedName_1);
    String _name_2 = ISerializer.class.getName();
    String _name_3 = Serializer.class.getName();
    bf.addTypeToType(_name_2, _name_3);
    return bf.getBindings();
  }
  
  public void generate(final Xtend2ExecutionContext ctx) {
    if (this.srcGenOnly) {
      GenFileName _semanticSequencer = this.names.getSemanticSequencer();
      String _fileName = _semanticSequencer.getFileName();
      GenFileName _semanticSequencer_1 = this.names.getSemanticSequencer();
      CharSequence _fileContents = this.abstractSemanticSequencer.getFileContents(_semanticSequencer_1);
      ctx.writeFile(Generator.SRC_GEN, _fileName, _fileContents);
      GenFileName _syntacticSequencer = this.names.getSyntacticSequencer();
      String _fileName_1 = _syntacticSequencer.getFileName();
      GenFileName _syntacticSequencer_1 = this.names.getSyntacticSequencer();
      CharSequence _fileContents_1 = this.abstractSyntacticSequencer.getFileContents(_syntacticSequencer_1);
      ctx.writeFile(Generator.SRC_GEN, _fileName_1, _fileContents_1);
    } else {
      GenFileName _semanticSequencer_2 = this.names.getSemanticSequencer();
      String _fileName_2 = _semanticSequencer_2.getFileName();
      GenFileName _semanticSequencer_3 = this.names.getSemanticSequencer();
      CharSequence _fileContents_2 = this.semanticSequencer.getFileContents(_semanticSequencer_3);
      ctx.writeFile(Generator.SRC, _fileName_2, _fileContents_2);
      GenFileName _syntacticSequencer_2 = this.names.getSyntacticSequencer();
      String _fileName_3 = _syntacticSequencer_2.getFileName();
      GenFileName _syntacticSequencer_3 = this.names.getSyntacticSequencer();
      CharSequence _fileContents_3 = this.syntacticSequencer.getFileContents(_syntacticSequencer_3);
      ctx.writeFile(Generator.SRC, _fileName_3, _fileContents_3);
      GenFileName _abstractSemanticSequencer = this.names.getAbstractSemanticSequencer();
      String _fileName_4 = _abstractSemanticSequencer.getFileName();
      GenFileName _abstractSemanticSequencer_1 = this.names.getAbstractSemanticSequencer();
      CharSequence _fileContents_4 = this.abstractSemanticSequencer.getFileContents(_abstractSemanticSequencer_1);
      ctx.writeFile(Generator.SRC_GEN, _fileName_4, _fileContents_4);
      GenFileName _abstractSyntacticSequencer = this.names.getAbstractSyntacticSequencer();
      String _fileName_5 = _abstractSyntacticSequencer.getFileName();
      GenFileName _abstractSyntacticSequencer_1 = this.names.getAbstractSyntacticSequencer();
      CharSequence _fileContents_5 = this.abstractSyntacticSequencer.getFileContents(_abstractSyntacticSequencer_1);
      ctx.writeFile(Generator.SRC_GEN, _fileName_5, _fileContents_5);
    }
    if (this.generateDebugData) {
      GenFileName _grammarConstraints = this.names.getGrammarConstraints();
      String _fileName_6 = _grammarConstraints.getFileName();
      GenFileName _grammarConstraints_1 = this.names.getGrammarConstraints();
      CharSequence _fileContents_6 = this.grammarConstraints.getFileContents(_grammarConstraints_1);
      ctx.writeFile(Generator.SRC_GEN, _fileName_6, _fileContents_6);
      Iterable<Pair<String,String>> _generateDebugGraphs = this.debugGraphGenerator.generateDebugGraphs();
      for (final Pair<String,String> obj : _generateDebugGraphs) {
        String _key = obj.getKey();
        String _value = obj.getValue();
        ctx.writeFile(Generator.SRC_GEN, _key, _value);
      }
    }
  }
  
  public List<String> getExportedPackagesRtList(final Grammar grammar) {
    GenFileName _semanticSequencer = this.names.getSemanticSequencer();
    String _packageName = _semanticSequencer.getPackageName();
    return CollectionLiterals.<String>newArrayList(_packageName);
  }
}
