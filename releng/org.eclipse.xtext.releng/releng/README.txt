- Install Eclipse 3.6 from http://download.eclipse.org/eclipse/downloads (archive)
- Add to the installation from http://download.eclipse.org/releases/helios (p2)
		+ EMF 2.6 SDK
		+ Buckminster 3.6 Core
		+ Buckminster 3.6 CVS Support
		+ Buckminster 3.6 PDE Support

- Create empty project "_target"

- Create empty target platform,
	Add directory location $workspace_loc\_target,
	Activate target platform

- Checkout org.eclipse.xtext.relang

- Right-click xtext-platform.mspec, Buckminster|Import..., wait, press Finish

- Right-click xtext-local.mspec, Buckminster|Import..., wait, press Finish

BUILD SDK:
- Right-click org.eclipse.xtext.build.feature, Buckminster|Invoke action...|package.tmf-xtext-SDK.
  DO NOT FORGET to point to the properties file, e.g. /org.eclipse.xtext.releng/releng/local.properties !!!!