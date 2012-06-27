package bootstrap

import java.io.File
import javax.imageio.ImageIO
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.xdoc.xdoc.ImageRef
import java.io.FileInputStream

class ImageExtensions {
	def getDimension(ImageRef imageRef) {
		val resourceURI = imageRef.eResource.URI
		val imageURI = URI::createURI(imageRef.path).resolve(resourceURI)
		val imageFile = new File(imageURI.toFileString)
		val stream = new FileInputStream(imageFile)
		try {
			val image = ImageIO::read(stream)
			return new ImageDimension(image.width, image.height)
		} finally {
			stream?.close
		}
	}
}

@Data
class ImageDimension {
	int width
	int height
}