/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard.cli;

import org.eclipse.xtext.util.JUnitVersion;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.LanguageServer;
import org.eclipse.xtext.xtext.wizard.LineDelimiter;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.cli.CliProjectsCreatorMain.ProjectType;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.DelimitedOptionHandler;
import org.kohsuke.args4j.spi.OneArgumentOptionHandler;
import org.kohsuke.args4j.spi.Setter;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 * @since 2.15
 */
abstract class OptionHandlers {
	
	public static class JavaVersionOptionHandler extends OneArgumentOptionHandler<JavaVersion> {
		public JavaVersionOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super JavaVersion> setter) {
			super(parser, option, setter);
		}

		@Override
		protected JavaVersion parse(String argument) throws NumberFormatException, CmdLineException {
			return JavaVersion.valueOf(argument);
		}
	}

	public static class BuildSystemOptionHandler extends OneArgumentOptionHandler<BuildSystem> {
		public BuildSystemOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super BuildSystem> setter) {
			super(parser, option, setter);
		}

		@Override
		protected BuildSystem parse(String argument) throws NumberFormatException, CmdLineException {
			return BuildSystem.valueOf(argument);
		}
	}

	public static class SourceLayoutOptionHandler extends OneArgumentOptionHandler<SourceLayout> {
		public SourceLayoutOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super SourceLayout> setter) {
			super(parser, option, setter);
		}

		@Override
		protected SourceLayout parse(String argument) throws NumberFormatException, CmdLineException {
			return SourceLayout.valueOf(argument);
		}
	}

	public static class ProjectLayoutOptionHandler extends OneArgumentOptionHandler<ProjectLayout> {
		public ProjectLayoutOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super ProjectLayout> setter) {
			super(parser, option, setter);
		}

		@Override
		protected ProjectLayout parse(String argument) throws NumberFormatException, CmdLineException {
			return ProjectLayout.valueOf(argument);
		}
	}
	
	public static class LanguageServerOptionHandler extends OneArgumentOptionHandler<LanguageServer> {
		public LanguageServerOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super LanguageServer> setter) {
			super(parser, option, setter);
		}

		@Override
		protected LanguageServer parse(String argument) throws NumberFormatException, CmdLineException {
			return LanguageServer.valueOf(argument);
		}
	}

	public static class JUnitVersionOptionHandler extends OneArgumentOptionHandler<JUnitVersion> {
		public JUnitVersionOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super JUnitVersion> setter) {
			super(parser, option, setter);
		}

		@Override
		protected JUnitVersion parse(String argument) throws NumberFormatException, CmdLineException {
			return JUnitVersion.valueOf(argument);
		}
	}

	public static class LineDelimiterOptionHandler extends OneArgumentOptionHandler<LineDelimiter> {
		public LineDelimiterOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super LineDelimiter> setter) {
			super(parser, option, setter);
		}

		@Override
		protected LineDelimiter parse(String argument) throws NumberFormatException, CmdLineException {
			return LineDelimiter.valueOf(argument);
		}
	}

	public static class ProjectTypeOptionHandler extends OneArgumentOptionHandler<ProjectType> {
		public ProjectTypeOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super ProjectType> setter) {
			super(parser, option, setter);
		}

		@Override
		protected ProjectType parse(String argument) throws NumberFormatException, CmdLineException {
			return ProjectType.valueOf(argument);
		}
	}
	
	public static class MultiProjectTypeOptionHandler extends DelimitedOptionHandler<ProjectType> {
		public MultiProjectTypeOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super ProjectType> setter) {
			super(parser, option, setter, ",", new ProjectTypeOptionHandler(parser, option, setter));
		}
	}
}
