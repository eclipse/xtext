/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.tests;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.junit.runner.RunWith;
import org.xpect.expectation.IStringExpectation;
import org.xpect.expectation.StringExpectation;
import org.xpect.parameter.ParameterParser;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.setup.XpectSetup;
import org.xpect.xtext.lib.setup.ThisResource;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
@RunWith(XpectRunner.class)
@XpectSetup(XtextStandaloneSetup.class)
public class JvmModelInferrerTest {

	public static class SignatureGenerator extends JvmModelGenerator {
		@Override
		public void generateExecutableBody(JvmExecutable op, ITreeAppendable appendable, final GeneratorConfig config) {
			appendable.append("{...}");
		}

		@Override
		public ITreeAppendable generateMember(final JvmMember it, final ITreeAppendable appendable, final GeneratorConfig config) {
			switch (it.getVisibility()) {
			case PROTECTED:
			case PUBLIC:
				return super.generateMember(it, appendable, config);
			case DEFAULT:
			case PRIVATE:
			default:
			}
			return appendable;
		}
	}

	@Inject
	private JvmModelGenerator jvmModelGenerator;

	@Inject
	private SignatureGenerator jvmSignatureGenerator;

	protected String formatFiles(InMemoryFileSystemAccess fsa, String fileName) {
		Map<String, CharSequence> files = fsa.getFiles();
		if (fileName != null) {
			Map<String, CharSequence> filtered = Maps.newHashMap();
			for (Map.Entry<String, CharSequence> e : files.entrySet()) {
				if (e.getKey().endsWith(fileName))
					filtered.put(e.getKey(), e.getValue());
			}
			files = filtered;
		}
		if (files.isEmpty())
			return "(no jvm model has been generated)";
		else if (files.size() == 1)
			return files.values().iterator().next().toString().trim();
		else {
			List<String> result = Lists.newArrayList();
			for (Map.Entry<String, CharSequence> e : files.entrySet()) {
				StringBuilder buf = new StringBuilder();
				buf.append("-- ");
				buf.append(e.getKey());
				buf.append(" --\n  ");
				buf.append(e.getValue().toString().trim().replace("\n", "\n  "));
				buf.append("\n-- / --");
				result.add(buf.toString());
			}
			return Joiner.on("\n").join(result);
		}
	}

	public JvmModelGenerator getJvmModelGenerator() {
		return jvmModelGenerator;
	}

	public SignatureGenerator getJvmSignatureGenerator() {
		return jvmSignatureGenerator;
	}

	@Xpect
	@ParameterParser(syntax = "('file' arg2=TEXT)?")
	public void jvmModel(@StringExpectation IStringExpectation expectation, @ThisResource XtextResource resource, String arg2) {
		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
		jvmModelGenerator.doGenerate(resource, fsa);
		String files = formatFiles(fsa, arg2);
		expectation.assertEquals(files);
	}

	@Xpect
	@ParameterParser(syntax = "('file' arg2=TEXT)?")
	public void jvmModelSignatures(@StringExpectation IStringExpectation expectation, @ThisResource XtextResource resource, String arg2) {
		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
		jvmSignatureGenerator.doGenerate(resource, fsa);
		String files = formatFiles(fsa, arg2);
		expectation.assertEquals(files);
	}
}
