package ${package}

import android.os.Bundle
import android.app.Activity
import android.view.Menu

public class MainActivity extends Activity {

	protected override void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	public override boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu)
		true
	}

}
