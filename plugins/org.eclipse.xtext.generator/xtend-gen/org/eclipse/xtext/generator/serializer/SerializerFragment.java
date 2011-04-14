package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.serializer.AbstractSemanticSequencer;
import org.eclipse.xtext.generator.serializer.SemanticSequencer;

@SuppressWarnings("all")
public class SerializerFragment extends Xtend2GeneratorFragment {
  @Inject private AbstractSemanticSequencer abstractSemanticSequencer;
  @Inject private SemanticSequencer semanticSequencer;
  
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    {
      BindFactory _bindFactory = new BindFactory();
      final BindFactory bf = _bindFactory;
      String _name = org.eclipse.xtext.serializer.ISemanticSequencer.class.getName();
      String _qualifiedName = this.semanticSequencer.getQualifiedName();
      bf.addTypeToType(_name, _qualifiedName);
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
    }
  }
}