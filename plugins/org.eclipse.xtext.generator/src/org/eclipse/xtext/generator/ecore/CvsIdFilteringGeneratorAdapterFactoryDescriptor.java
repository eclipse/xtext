package org.eclipse.xtext.generator.ecore;

import java.io.OutputStream;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenEnumGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.LineFilterOutputStream;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CvsIdFilteringGeneratorAdapterFactoryDescriptor implements GeneratorAdapterFactory.Descriptor {
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected class IdFilteringGenModelGeneratorAdapterFactory extends GenModelGeneratorAdapterFactory {

		protected class IdFilteringGenPackageAdapter extends GenPackageGeneratorAdapter {
			protected IdFilteringGenPackageAdapter(GeneratorAdapterFactory generatorAdapterFactory) {
				super(generatorAdapterFactory);
			}

			@Override
			protected OutputStream createOutputStream(URI workspacePath) throws Exception {
				return CvsIdFilteringGeneratorAdapterFactoryDescriptor.this.createOutputStream(super
						.createOutputStream(workspacePath), getLineDelimiter());
			}
		}

		protected class IdFilteringGenEnumAdapter extends GenEnumGeneratorAdapter {
			protected IdFilteringGenEnumAdapter(GeneratorAdapterFactory generatorAdapterFactory) {
				super(generatorAdapterFactory);
			}

			@Override
			protected OutputStream createOutputStream(URI workspacePath) throws Exception {
				return CvsIdFilteringGeneratorAdapterFactoryDescriptor.this.createOutputStream(super
						.createOutputStream(workspacePath), getLineDelimiter());
			}
		}

		protected class IdFilteringGenClassAdapter extends GenClassGeneratorAdapter {
			protected IdFilteringGenClassAdapter(GeneratorAdapterFactory generatorAdapterFactory) {
				super(generatorAdapterFactory);
			}

			@Override
			protected OutputStream createOutputStream(URI workspacePath) throws Exception {
				return CvsIdFilteringGeneratorAdapterFactoryDescriptor.this.createOutputStream(super
						.createOutputStream(workspacePath), getLineDelimiter());
			}
		}

		@Override
		public Adapter createGenClassAdapter() {
			return new IdFilteringGenClassAdapter(this);
		}

		@Override
		public Adapter createGenEnumAdapter() {
			return new IdFilteringGenEnumAdapter(this);
		}

		@Override
		public Adapter createGenModelAdapter() {
			if (genModelGeneratorAdapter == null) {
				genModelGeneratorAdapter = new GenModelGeneratorAdapter(this) {
					// we handle these ones on our own
					@Override
					protected void generateModelBuildProperties(GenModel genModel,
							org.eclipse.emf.common.util.Monitor monitor) {
					}

					@Override
					protected void generateModelManifest(GenModel genModel,
							org.eclipse.emf.common.util.Monitor monitor) {
					}

					@Override
					protected void generateModelPluginClass(GenModel genModel,
							org.eclipse.emf.common.util.Monitor monitor) {
					}

					@Override
					protected void generateModelPluginProperties(GenModel genModel,
							org.eclipse.emf.common.util.Monitor monitor) {
					}
				};
			}
			return genModelGeneratorAdapter;
		}

		@Override
		public Adapter createGenPackageAdapter() {
			return new IdFilteringGenPackageAdapter(this);
		}
	}

	protected OutputStream createOutputStream(OutputStream stream, String lineDelimiter) throws Exception {
		return new LineFilterOutputStream(stream, " * $Id" + "$", lineDelimiter != null ? lineDelimiter : Strings
				.newLine());
	}

	public GeneratorAdapterFactory createAdapterFactory() {
		return new IdFilteringGenModelGeneratorAdapterFactory();
	}
}