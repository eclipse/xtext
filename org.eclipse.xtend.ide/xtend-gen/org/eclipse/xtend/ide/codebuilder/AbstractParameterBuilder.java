/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractParameterBuilder extends AbstractCodeBuilder {
  @Accessors
  private String name;

  @Accessors
  private LightweightTypeReference type;

  @Accessors
  private boolean varArgsFlag;

  @Accessors
  private boolean extensionFlag;

  @Accessors
  private boolean finalFlag;

  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      this.appendModifiers(appendable);
      if (this.varArgsFlag) {
        this.appendType(appendable, ((ArrayTypeReference) this.type).getComponentType(), "Object").append("...");
      } else {
        this.appendType(appendable, this.type, "Object");
      }
      _xblockexpression = appendable.append(" ").append(this.name);
    }
    return _xblockexpression;
  }

  protected abstract ISourceAppender appendModifiers(final ISourceAppender appendable);

  @Override
  public boolean isValid() {
    return (((this.type != null) && ((!this.varArgsFlag) || (this.type instanceof ArrayTypeReference))) && super.isValid());
  }

  @Override
  public String getImage() {
    return "parameter.gif";
  }

  @Pure
  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Pure
  public LightweightTypeReference getType() {
    return this.type;
  }

  public void setType(final LightweightTypeReference type) {
    this.type = type;
  }

  @Pure
  public boolean isVarArgsFlag() {
    return this.varArgsFlag;
  }

  public void setVarArgsFlag(final boolean varArgsFlag) {
    this.varArgsFlag = varArgsFlag;
  }

  @Pure
  public boolean isExtensionFlag() {
    return this.extensionFlag;
  }

  public void setExtensionFlag(final boolean extensionFlag) {
    this.extensionFlag = extensionFlag;
  }

  @Pure
  public boolean isFinalFlag() {
    return this.finalFlag;
  }

  public void setFinalFlag(final boolean finalFlag) {
    this.finalFlag = finalFlag;
  }
}
