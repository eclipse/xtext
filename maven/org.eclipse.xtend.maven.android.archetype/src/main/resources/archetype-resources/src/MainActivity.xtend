package ${package}

import android.os.Bundle
import android.app.Activity
import android.view.Menu

class MainActivity extends Activity {

	override onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.main, menu)
		return true
	}

}
