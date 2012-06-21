package bootstrap

import java.io.File
import javax.imageio.ImageIO
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.xdoc.xdoc.ImageRef

class ImageExtensions {
	def getDimension(ImageRef imageRef) {
		val resourceURI = imageRef.eResource.URI
		val imageURI = URI::createURI(imageRef.path).resolve(resourceURI)
		val imgageStream = ImageIO::createImageInputStream(new File(imageURI.toFileString))
		val imageReader = ImageIO::getImageReaders(imgageStream).next()
		imageReader.input = imgageStream
		return new ImageDimension(imageReader.getWidth(imageReader.minIndex), 
			imageReader.getHeight(imageReader.minIndex)
		)
	}
}

@Data
class ImageDimension {
	int width
	int height
}