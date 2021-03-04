
package com.example.facemaker;
/**
 *
 * @author Saylene Hernandez
 * @date 03/03/2021
 *
 */
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		FaceView SurfaceViewFace = (FaceView) findViewById(R.id.FaceView);
		Button ButtonRandomize = (Button) findViewById(R.id.randomizeButton);
		SeekBar SeekBarRed = (SeekBar) findViewById(R.id.redSeekBar);
		SeekBar SeekBarGreen = (SeekBar) findViewById(R.id.greenSeekBar);
		SeekBar SeekBarBlue = (SeekBar) findViewById(R.id.blueSeekBar);

		Spinner spinnerStyles = (Spinner) findViewById(R.id.SpinnerStyles);

		/**
		 * EXTERNAL CITATION
		 * 	Date:		03 March 2021
		 * 	Problem:	Could not figure out how to set up the spinner. I used this video as well as the API
		 * 	to figure out how to utilize spinners.
		 * 	Resource:	https://www.youtube.com/watch?v=on_OrrX7Nw4 and https://developer.android.com/guide/topics/ui/controls/spinner
		 * 	Solution:	Used this video which was recommended to me from a friend and also used the API
		 * 	to fix some issues in my code.
		 */
		ArrayAdapter<CharSequence> AdapterStyle = ArrayAdapter.createFromResource(
				this, R.array.styles, android.R.layout.simple_spinner_item);
		AdapterStyle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerStyles.setAdapter(AdapterStyle);

		RadioGroup RadioGroupHES = (RadioGroup) findViewById(R.id.RadioGroupHES);

		FaceController controller = new FaceController(	SurfaceViewFace, SeekBarRed, SeekBarGreen,
														SeekBarBlue, RadioGroupHES, spinnerStyles);
		ButtonRandomize.setOnClickListener(controller);
		SeekBarRed.setOnSeekBarChangeListener(controller);
		SeekBarGreen.setOnSeekBarChangeListener(controller);
		SeekBarBlue.setOnSeekBarChangeListener(controller);
		spinnerStyles.setOnItemSelectedListener(controller);
		RadioGroupHES.setOnCheckedChangeListener(controller);
	}
}
