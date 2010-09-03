- org.eclipse.ui.views.contentoutline.ContentOutlinePage does not allow extension with an lazy tree viewer

Hauptprobleme mit der derzeitigen Outline
- zu komplizierte API
- blockiert den UI Thread
- zu komplizierte Implementierung


IOutlineNodes werden jetzt nur on demand und Model-Change-Fall nicht im UI Thread gebaut
Laziness von Iterables passt hier nicht so gut.


=========
[labels] Provide an additional simple but more efficient label provider

While the current default label provider implementation has a nice API, it has several performance drawbacks:

- in most cases, images will depend on the EClass of the element only
- if images are provided by means of a String, we convert that to an ImageDescriptor and to an Image on every method call

The image resolution currently takes about half of the time for creating an outline node, so there is potential for significant performance improvement.
========= 