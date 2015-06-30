/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.stubs;

import com.intellij.lang.Language;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.psi.tree.IStubFileElementType;
import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class XtextFileElementType<T extends XtextFileStub<?>> extends IStubFileElementType<T> {
  public XtextFileElementType(final Language language) {
    super(language);
    if ((language instanceof IXtextLanguage)) {
      ((IXtextLanguage)language).injectMembers(this);
    }
  }
  
  @Override
  public String getExternalId() {
    StringConcatenation _builder = new StringConcatenation();
    Language _language = this.getLanguage();
    String _iD = _language.getID();
    _builder.append(_iD, "");
    _builder.append(".FILE");
    return _builder.toString();
  }
  
  @Override
  public void serialize(final T stub, final StubOutputStream it) throws IOException {
    URI _uri = stub.getUri();
    this.writeURI(it, _uri);
  }
  
  protected void writeURI(final StubOutputStream it, final URI uri) {
    try {
      String _string = uri.toString();
      it.writeUTF(_string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public T deserialize(final StubInputStream it, final StubElement parentStub) throws IOException {
    T _xblockexpression = null;
    {
      final XtextFileStub<BaseXtextFile> stub = new XtextFileStub<BaseXtextFile>(null, this);
      URI _readURI = this.readURI(it);
      stub.setUri(_readURI);
      _xblockexpression = ((T) stub);
    }
    return _xblockexpression;
  }
  
  protected URI readURI(final StubInputStream it) {
    try {
      String _readUTF = it.readUTF();
      return URI.createURI(_readUTF);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void indexStub(final T stub, final IndexSink sink) {
  }
}
