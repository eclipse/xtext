/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Moritz Eyshold - Initial contribution and API
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class SemanticSequencer extends GeneratedFile {
  @Inject
  private SerializerGenFileNames names;
  
  @Inject
  @Extension
  private Naming _naming;
  
  @Inject
  @Named("generateXtendStub")
  private Boolean generateXtendStub;
  
  @Override
  public CharSequence getFileContents(final SerializerGenFileNames.GenFileName filename) {
    CharSequence _xifexpression = null;
    if ((this.generateXtendStub).booleanValue()) {
      StringConcatenation _builder = new StringConcatenation();
      String _fileHeader = this._naming.fileHeader();
      _builder.append(_fileHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.append("package ");
      String _packageName = filename.getPackageName();
      _builder.append(_packageName, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _simpleName = filename.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append(" extends ");
      SerializerGenFileNames.GenFileName _abstractSemanticSequencer = this.names.getAbstractSemanticSequencer();
      String _simpleName_1 = _abstractSemanticSequencer.getSimpleName();
      _builder.append(_simpleName_1, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _fileHeader_1 = this._naming.fileHeader();
      _builder_1.append(_fileHeader_1, "");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("package ");
      String _packageName_1 = filename.getPackageName();
      _builder_1.append(_packageName_1, "");
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("public class ");
      String _simpleName_2 = filename.getSimpleName();
      _builder_1.append(_simpleName_2, "");
      _builder_1.append(" extends ");
      SerializerGenFileNames.GenFileName _abstractSemanticSequencer_1 = this.names.getAbstractSemanticSequencer();
      String _simpleName_3 = _abstractSemanticSequencer_1.getSimpleName();
      _builder_1.append(_simpleName_3, "");
      _builder_1.append(" {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("}");
      _builder_1.newLine();
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
}
