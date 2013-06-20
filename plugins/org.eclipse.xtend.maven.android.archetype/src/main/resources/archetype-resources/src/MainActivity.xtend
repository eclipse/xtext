package ${package};

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class MainActivity extends Activity {

	override onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		contentView = R.layout.activity_main
	}

	override onCreateOptionsMenu(Menu m) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.main, m)
		return true
	}

}
